package nc.alright.controller.review;

import nc.alright.domain.review.Review;
import nc.alright.service.review.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public List<Review> getAllReview(){
        return reviewService.getAllReview();
    }
    @PostMapping("/create")
    public Review createReview(Review review){
        return reviewService.createReview(review);
    }

    @GetMapping("/{storeId}")
    public List<Review> getReviewByStore(@PathVariable Long storeId){
        return reviewService.getReviewByStore(storeId);
    }

    @GetMapping("/{userId}")
    public List<Review> getReviewByUser(@PathVariable Long userId){
        return reviewService.getReviewByStore(userId);
    }


}
