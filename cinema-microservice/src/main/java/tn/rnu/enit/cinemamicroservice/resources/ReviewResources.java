package tn.rnu.enit.cinemamicroservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rnu.enit.cinemamicroservice.Dto.ReviewDeletedDTO;
import tn.rnu.enit.cinemamicroservice.Service.ReviewService;
import tn.rnu.enit.cinemamicroservice.domain.Cinema;
import tn.rnu.enit.cinemamicroservice.domain.Review;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class ReviewResources {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/get-all-reviews")
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    @PostMapping("/create-review")
    public ResponseEntity<Review> createNewReview(@RequestBody Review review){
        return new ResponseEntity<>(reviewService.createReview(review), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-review/{id}")
    public ResponseEntity<ReviewDeletedDTO> deleteReview(@PathVariable("id") Long id){
        return new ResponseEntity<>(reviewService.deleteReviewById(id), HttpStatus.OK);
    }

    @GetMapping("/find-reviews-user/{userId}")
    public ResponseEntity<List<Review>> findByUserId(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(reviewService.findByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/find-reviews-cinema")
    public ResponseEntity<List<Review>> findByFilm(@RequestBody Cinema cinema){
        return new ResponseEntity<>(reviewService.findByCinema(cinema), HttpStatus.OK);
    }
}
