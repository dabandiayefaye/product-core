package sn.isi.l3gl.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 0.0.1-SNAPSHOT
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    // 0.1.0-SNAPSHOT
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
    // 0.2.0-SNAPSHOT
    public Product updateQuantity(Long id, int quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setQuantity(quantity);
        return productRepository.save(product);
    }
    // 0.3.0-SNAPSHOT
    public long countLowStockProducts() {
        return productRepository.findByQuantityLessThanEqual(5).size();
    }

}
