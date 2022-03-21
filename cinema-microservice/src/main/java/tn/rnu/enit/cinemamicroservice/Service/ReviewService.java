package tn.rnu.enit.cinemamicroservice.Service;

import tn.rnu.enit.cinemamicroservice.Dto.ReviewDeletedDTO;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();

    Review createReview(Review review);

    ReviewDeletedDTO deleteReviewById(Long id);

    List<Review> findByUserId(Long userId);

    List<Review> findByCinema(Cinema cinema);
}
