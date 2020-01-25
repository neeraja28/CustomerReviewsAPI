package com.udacity.reviewsAPI.reviewsApiRepositoryTests;

import com.udacity.reviewsAPI.entity.Product;
import com.udacity.reviewsAPI.repository.ProductRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
 public class productRepositoryTests {
    @Autowired private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    Product product1 = new Product();
    Product product2 = new Product();

    @Before
    public void setUp() {
        // given
        product1.setProductId(1);
        product1.setProductName("Book");
        productRepository.save(product1);

        product2.setProductId(2);
        product2.setProductName("BOOK2");
        productRepository.save(product2);
    }

    /**
      * Test to create a product.
     */
    @Test
    public void testSave() throws Exception {
        assertThat(product1.getProductName()).isEqualTo("Book");
        assertThat(product1.getProductId()).isEqualTo(1);
    }

    /**
      * Test to find a product by id.
     */
    @Test
    public void testFindByID() {
        Optional<Product> product = productRepository.findById(product1.getProductId());

        assertThat(product.get().getProductId()).isEqualTo(product1.getProductId());
        assertThat(product.get().getProductName()).isEqualTo(product1.getProductName());
    }

    /**
      * Test to list all products.
     */
    @Test
    public void testFindAll() {
        assertThat(productRepository.findAll().size()).isEqualTo(2);
    }
}
