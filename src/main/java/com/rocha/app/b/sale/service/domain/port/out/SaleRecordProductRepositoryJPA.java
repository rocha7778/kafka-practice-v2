package com.rocha.app.b.sale.service.domain.port.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rocha.app.b.sale.application.domain.model.SaleRecordProduct;

public interface SaleRecordProductRepositoryJPA extends JpaRepository<SaleRecordProduct, Long>{

}
