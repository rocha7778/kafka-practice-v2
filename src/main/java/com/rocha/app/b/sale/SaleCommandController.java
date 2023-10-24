package com.rocha.app.b.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rocha.app.a.product.dto.ProductDto;
import com.rocha.app.b.sale.dto.SaleRecordProductDto;
import com.rocha.app.b.sale.service.SaleService;
import com.rocha.app.util.SaleRecordMapperUtil;


@RestController
@RequestMapping("/products")
public class SaleCommandController {
	
	@Autowired
	private SaleService saleService;
	
	
	@PostMapping("/sell")
	public ProductDto sellProduct(@RequestBody SaleRecordProductDto saleRecordProduct) throws Exception {
		saleService.registerSale(SaleRecordMapperUtil.mapper(saleRecordProduct));
		return null;
	}
	
	
	@ControllerAdvice
	public class RestResponseEntityExceptionHandler 
	  extends ResponseEntityExceptionHandler {

	    @ExceptionHandler(value = { Exception.class })
	    protected ResponseEntity<Object> handleConflict(
	    		Exception ex, WebRequest request) {
	       
	        return handleExceptionInternal(ex, ex.getMessage(), 
	          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	    }
	}

}