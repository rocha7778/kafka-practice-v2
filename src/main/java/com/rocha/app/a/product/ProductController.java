package com.rocha.app.a.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.app.a.product.entity.NumberGenerator;
import com.rocha.app.a.product.entity.NumberGeneratorSingleton;
import com.rocha.app.a.product.entity.Product;
import com.rocha.app.a.product.entity.Vendor;
import com.rocha.app.a.product.repository.VendorRepositoryJPA;
import com.rocha.app.a.product.service.IProductService;

@RestController
@RequestMapping("/products")
@Transactional
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private IProductService productService;

	@Autowired
	private VendorRepositoryJPA vendorRepository;

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
	public Product createProduct(@RequestHeader(value = "User-Agent") String userAgent, @RequestBody Product product) {
		logger.info(userAgent);
		return productService.createProductInternal(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);

	}

	

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.findProductByIdTransactional(id);
	}

	@GetMapping()
	public List<Product> getProducs() {
		return productService.findAll();
	}

	@GetMapping("/vendors")
	public List<Vendor> getVendors() {
		return vendorRepository.findAll();
	}

	@GetMapping("/vendors/{id}")
	public Vendor getVendorsById(@PathVariable Long id) {
		return vendorRepository.findById(id).get();
	}

	@PostMapping("/vendors")
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	
	@PutMapping("/vendors/{id}")
	@Transactional(readOnly=true)
	public Vendor updateNameProduct(@PathVariable long id, @RequestParam(required = false) String name) {
		Vendor v = vendorRepository.findById(id).get();
		v.setName(name);
		//v= vendorRepository.save(v);
		return v;

	}

}
