package tn.rnu.enit.cinemamicroservice.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rnu.enit.cinemamicroservice.Dto.ReviewDeletedDTO;
import tn.rnu.enit.cinemamicroservice.Repository.CinemaRepository;
import tn.rnu.enit.cinemamicroservice.Repository.ReviewRepository;
import tn.rnu.enit.cinemamicroservice.Service.ReviewService;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.Review;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public ReviewDeletedDTO deleteReviewById(Long id) {
        Review review = reviewRepository.getOne(id);
        ReviewDeletedDTO reviewDeletedDTO = new ReviewDeletedDTO();
        reviewDeletedDTO.setId(id);
        reviewDeletedDTO.setUserId(review.getUserId());
        reviewDeletedDTO.setComment(review.getComment());
        reviewDeletedDTO.setDeleted(true);
        reviewRepository.deleteById(id);
        return reviewDeletedDTO;
    }

    @Override
    public List<Review> findByUserId(Long userId) {
        return reviewRepository.findByUserId(userId);
    }

    @Override
    public List<Review> findByCinema(Cinema cinema) {
        return reviewRepository.findByCinema(cinema);
    }
}
