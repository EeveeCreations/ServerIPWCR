package com.example.serveripwcr.daos;

import com.example.serveripwcr.models.Product;
import com.example.serveripwcr.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAO {

    @Autowired
    private ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        ArrayList<Product> products = (ArrayList<Product>) this.productRepository.findAll();
        products.sort(Comparator.comparingLong(Product::getProductNumber));
        return products;
    }

    public Product getById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This Product id: " + id + "has not found");
        }
        return optionalProduct.get();
    }

    public Optional<Product> getByIdOptional(long id) {
        return productRepository.findById(id);
    }

    public void deleteByProductId(long productId) {
        productRepository.deleteById(productId);
    }

    public Product addProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }
}
