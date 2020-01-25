package com.udacity.reviewsAPI.reviewsApiRepositoryTests;

import com.udacity.reviewsAPI.entity.Product;
import com.udacity.reviewsAPI.entity.Review;
import com.udacity.reviewsAPI.repository.ProductRepository;
import com.udacity.reviewsAPI.repository.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    Product product = new Product();
    Product savedProduct = new Product();

    Review review1 = new Review();
    Review review2 = new Review();
    Review savedReview1 = new Review();
    Review savedReview2 = new Review();

    @Before
    public void setUp() {
        //given
        product.setProductId(3);
        product.setProductName("Book");
        savedProduct = productRepository.save(product);

        review1.setReviewId(1);
        review1.setProduct(savedProduct);
        review1.setReview("This is a nice book on Java");
        savedReview1 = reviewRepository.save(review1);
        review2.setReviewId(2);
        review2.setProduct(savedProduct);
        review2.setReview("Good content on Java");
        savedReview2 = reviewRepository.save(review2);
    }

      /**
          * Test for creating a review for a product.
      */
    @Test
    public void testSaveReviewForProduct() throws Exception {
        assertThat(savedReview1.getReview()).isEqualTo(review1.getReview());
        assertThat(savedReview2.getReview()).isEqualTo(review2.getReview());
        assertThat(savedReview1.getProduct().getProductName()).isEqualTo(product.getProductName());
    }

     /**
         * Test for listing reviews by product.
     */
    @Test
    public void testFindAllReviewsForProduct() {
        assertThat(reviewRepository.findAll().size()).isEqualTo(2);
    }

}
