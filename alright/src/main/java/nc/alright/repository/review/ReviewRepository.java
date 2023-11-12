package nc.alright.repository.review;

import nc.alright.domain.review.Review;
import nc.alright.domain.store.Store;

import java.util.List;

public interface ReviewRepository {
    Review createReview(Review review);

    void deleteReview(Long reviewId);
    Review updateReview(Long reviewId,Review updatedReview);
    List<Review> getAllReview();

    //스토어 별로 리뷰를 보여주는 메서드
    List<Review> getReviewByStore(Long storeId);

    //유저 별로 리뷰를 보여주는 메서드
    List<Review> getReviewByUser(Long userId);
}
