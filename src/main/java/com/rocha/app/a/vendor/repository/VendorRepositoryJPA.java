package com.rocha.app.a.vendor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocha.app.a.product.entity.Vendor;

public interface VendorRepositoryJPA extends JpaRepository<Vendor, Long>{
	

}
