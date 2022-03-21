package tn.rnu.enit.cinemamicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rnu.enit.cinemamicroservice.Dto.ReviewDeletedDTO;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    ReviewDeletedDTO deleteReviewById(Long id);
    List<Review> findByUserId(Long userId);
    List<Review> findByCinema(Cinema cinema);
}
