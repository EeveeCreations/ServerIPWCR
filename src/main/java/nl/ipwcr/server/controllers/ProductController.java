package nl.ipwcr.server.controllers;

import nl.ipwcr.server.daos.ProductDAO;
import nl.ipwcr.server.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {
    @Autowired
    public final ProductDAO productDAO;

    public ProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping(value = "/product/all")
    public List<Product> getAllCategories() {
        return productDAO.getAll();
    }

    @GetMapping(value = "/product/{id}")
    public Product getProduct(@PathVariable final Long id) {
        return productDAO.getById(id);
    }

    @PutMapping(value = "/product/{id}")
    public Product editProduct(@RequestBody Product editProduct, @PathVariable Long id) throws Exception {

        return productDAO.getByIdOptional(id)
                .map(product -> {
                    product.setName(editProduct.getName());
                    product.setDescription(editProduct.getDescription());
                    product.setPrice(editProduct.getPrice());
                    product.setCategory(editProduct.getCategory());
                    product.setImagePath(editProduct.getImagePath());
                    product.setStorage(editProduct.getStorage());
                    return productDAO.addProduct(product);
                })
                .orElseThrow(() -> new Exception(
                        "No product found with id " + id + "\""));
    }

    @PutMapping(value = "/product")
    public Product addProduct(@RequestBody Product newProduct) {
        return productDAO.addProduct(newProduct);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productDAO.deleteByProductId(id);
    }

}
