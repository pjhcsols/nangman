package nc.alright.service.review;

import nc.alright.domain.review.Review;
import nc.alright.domain.store.Store;
import nc.alright.repository.review.JpaReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final JpaReviewRepository jpaReviewRepository;

    @Autowired
    public ReviewService( JpaReviewRepository jpaReviewRepository){
        this.jpaReviewRepository = jpaReviewRepository;
    }

    public Review createReview(Review review){
        return jpaReviewRepository.createReview(review);
    }

    public void deleteReview(Long reviewId){
        jpaReviewRepository.deleteReview(reviewId);
    }

    public Review updateReview(Long reviewId, Review updatedReview){
        return jpaReviewRepository.updateReview(reviewId,updatedReview);
    }

    public List<Review> getAllReview(){
        return jpaReviewRepository.getAllReview();
    }

    public List<Review> getReviewByStore(Long storeId){
        return jpaReviewRepository.getReviewByStore(storeId);
    }

    public List<Review> getReviewByUser(Long userId){
        return jpaReviewRepository.getReviewByUser(userId);
    }
}
