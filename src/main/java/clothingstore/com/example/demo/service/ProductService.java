package clothingstore.com.example.demo.service;

import clothingstore.com.example.demo.domain.product.Product;
import clothingstore.com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
