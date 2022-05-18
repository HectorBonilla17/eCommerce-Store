package com.commerce.Store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.Store.dao.ProductRepository;
import com.commerce.Store.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository theProductRepository;

	@Override
	public List<Product> findAll() {
		return theProductRepository.findAll();
	}

	@Override
	public Product findById(int theId) {
		
		Optional<Product> result = theProductRepository.findById(theId);
		
		Product theProduct = null;
		if(result.isPresent()) {
			theProduct = result.get();
		} else {
			throw new RuntimeException("Did not find product with id - " + theId);
		}
		
		return theProduct;
	}

	@Override
	public void save(Product theProduct) {
		theProductRepository.save(theProduct);
	}

	@Override
	public void deleteById(int theId) {
		theProductRepository.deleteById(theId);
	}
	
	@Override
	public void purchaseCart(List<Product> theProducts) {
		
		for (Product tempProduct : theProducts) {
			Product foundProduct = findById(tempProduct.getId());
			foundProduct.setQuantity(foundProduct.getQuantity() - tempProduct.getQuantity());
			save(foundProduct);
		}
		
		theProducts.clear();
	}
	
}
