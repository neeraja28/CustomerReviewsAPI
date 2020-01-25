package com.udacity.reviewsAPI.reviewsApiRepositoryTests;

import com.udacity.reviewsAPI.entity.Comment;
import com.udacity.reviewsAPI.entity.Product;
import com.udacity.reviewsAPI.entity.Review;
import com.udacity.reviewsAPI.repository.CommentRepository;
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
public class CommentRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    Product product = new Product();
    Product savedProduct = new Product();
    Review review = new Review();
    Review savedReview = new Review();

    Comment comment1 = new Comment();
    Comment comment2 = new Comment();
    Comment savedComment1 = new Comment();
    Comment savedComment2 = new Comment();

    @Before
    public void setUp() {
        //given
        product.setProductId(3);
        product.setProductName("Book");
        savedProduct = productRepository.save(product);

        review.setReviewId(4);
        review.setReview("This is a nice book on Java");
        review.setProduct(savedProduct);
        savedReview = reviewRepository.save(review);

        comment1.setCommentId(1);
        comment1.setComment("I like it");
        comment1.setReview(savedReview);
        savedComment1 = commentRepository.save(comment1);

        comment2.setCommentId(2);
        comment2.setComment("Thank You");
        comment2.setReview(savedReview);
        savedComment2 = commentRepository.save(comment2);
    }

    /**
    * Test to create a comment for a review.
    */
    @Test
    public void testCreateCommentForReview() throws Exception {
        assertThat(savedComment1.getComment()).isEqualTo(comment1.getComment());
        assertThat(savedComment2.getComment()).isEqualTo(comment2.getComment());
    }

     /**
       * Test to  list comments for a review.
     */
    @Test
    public void testListCommentsForReview() throws Exception {
        assertThat(commentRepository.findAll().size()).isEqualTo(2);
    }
}
