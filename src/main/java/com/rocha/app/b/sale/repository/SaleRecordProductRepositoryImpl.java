package com.rocha.app.b.sale.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.app.b.sale.entity.SaleRecordProduct;

@Service
public class SaleRecordProductRepositoryImpl implements SaleRecordProductRepository {

	@Autowired
	private SaleRecordProductRepositoryJPA saleRecordProductRepository;

	@Override
	public SaleRecordProduct registerSale(SaleRecordProduct saleRecordProduct) {
		return saleRecordProductRepository.save(saleRecordProduct);
	}

	

	

}
