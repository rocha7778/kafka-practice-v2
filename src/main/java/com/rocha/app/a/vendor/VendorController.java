package com.rocha.app.a.vendor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rocha.app.a.product.entity.Product;
import com.rocha.app.a.product.entity.Vendor;
import com.rocha.app.a.product.service.IProductService;
import com.rocha.app.a.vendor.repository.VendorRepositoryJPA;

@RestController
@RequestMapping("/vendors")
public class VendorController {

	@Autowired
	private VendorRepositoryJPA vendorRepository;

	@Autowired
	private IProductService productService;

	@GetMapping
	public List<Vendor> getVendors() {
		return vendorRepository.findAll();
	}

	@GetMapping("/{id}")
	public Vendor getVendorsById(@PathVariable Long id) {
		return vendorRepository.findById(id).get();
	}

	@PostMapping
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	@PutMapping("/{id}")
	public Vendor updateNameVendor(@PathVariable long id, @RequestParam(required = false) String name) {
		Vendor v = vendorRepository.findById(id).get();

		v.setName(name);
		v = vendorRepository.save(v);
		return v;

	}

	@PutMapping("/{id}/add-products")
	public Vendor updateVendors(@PathVariable long id, @RequestBody List<Product> products) {
		Vendor v = vendorRepository.findById(id).get();
		List<Product> productEntyties = new ArrayList<>();

		products.stream().forEach(p -> {
			productEntyties.add(productService.findProductById(p.getId()));
		});

		v.setProducts(productEntyties);
		v = vendorRepository.save(v);
		return v;

	}

}
