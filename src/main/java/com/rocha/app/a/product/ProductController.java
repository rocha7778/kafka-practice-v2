package com.rocha.app.a.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rocha.app.a.product.entity.NumberGenerator;
import com.rocha.app.a.product.entity.NumberGeneratorSingleton;
import com.rocha.app.a.product.entity.Product;
import com.rocha.app.a.product.repository.ProductSpecification;
import com.rocha.app.a.product.service.IProductService;
import com.rocha.app.product.exceptions.ApiErrorResponse;
import com.rocha.app.product.exceptions.NotFounException;

@RestController
@RequestMapping("/products")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private IProductService productService;

	@Autowired
	private NumberGenerator numberGenerator;

	@Autowired
	private NumberGeneratorSingleton numberGeneratorSingleton;

	@GetMapping("/random/request-scope")
	public Integer getRamdon() {
		return numberGenerator.getRamdonNumer();
	}

	@GetMapping("/random/singleton-scope")
	public Integer getRamdonSingleton() {
		return numberGeneratorSingleton.getRamdonNumer();
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProductInternal(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable long id, @RequestBody Product product) throws Exception {
		return productService.updateProduct(id, product);

	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable long id) throws Exception {
		productService.deleteProductById(id);

	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) throws Exception {
		return productService.findProductById(id).orElseThrow(() -> new NotFounException("Not Product Found"));
	}

	@GetMapping("/price-less-than/{price}/quantity-less-than/{quantity}")
	public List<Product> getProductsByCriteria(@PathVariable Double price, @PathVariable Double quantity) {
		Specification<Product> priceLessThan = ProductSpecification.priceLessThan(price);
		Specification<Product> quantityLessThan = ProductSpecification.quantityLessThan(quantity);

		return productService.findallSpec(priceLessThan.or(quantityLessThan));
	}
	
	
	@GetMapping("/price-greater-than/{initial_range}/price-less-than/{final_range}")
	public List<Product> getProductsByPriceRange(@PathVariable Double initial_range, @PathVariable Double final_range) {
		Specification<Product> priceGreaterThan = ProductSpecification.priceGreaterThan(initial_range);
		Specification<Product> quantityLessThan = ProductSpecification.priceLessThan(final_range);

		return productService.findallSpec(priceGreaterThan.and(quantityLessThan));
	}
	
	
	

	@GetMapping()
	public List<Product> getProducs() {
		return productService.findAll();
	}

	@ControllerAdvice
	public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

		@ExceptionHandler(value = { NotFounException.class })
		protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
			ApiErrorResponse apiErrorResponse = new ApiErrorResponse(404, ex.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
					.body(apiErrorResponse);
		}
	}

}
