package nc.alright.repository.review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import nc.alright.domain.review.Review;
import nc.alright.domain.store.Store;
import nc.alright.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class JpaReviewRepository implements ReviewRepository{

    @PersistenceContext
    EntityManager entityManager;


    //후기 생성하는 메서드
    @Override
    public Review createReview(Review review) {
        review.setReviewId(null);
        entityManager.persist(review);
        return review;
    }

    //후기 삭제하는 메서드
    @Override
    public void deleteReview(Long reviewId) {
        Review review = entityManager.find(Review.class, reviewId);
        if(review !=null) entityManager.remove(review);
    }

    //후기 수정하는 메서드
    @Override
    public Review updateReview(Long reviewId, Review updatedReview) {
        Review existingReview = entityManager.find(Review.class, reviewId);
        if(existingReview != null){
            existingReview.setReviewContent(updatedReview.getReviewContent());
            existingReview.setReviewScore(updatedReview.getReviewScore());
            existingReview.setReviewDate(updatedReview.getReviewDate());//날짜를 그냥 서버에서 현재시간으로 해야하는건가?
            return existingReview;
        }
        return null;
    }

    //모든 후기를 얻는 메서드
    @Override
    public List<Review> getAllReview(){
        String jpql = "SELECT r FROM Review r";
        TypedQuery<Review> query = entityManager.createQuery(jpql, Review.class);
        return query.getResultList();
    }

    //가게별로 리뷰 보여주는 메서드
    @Override
    public List<Review> getReviewByStore(Long storeId) {
        Store store = entityManager.find(Store.class, storeId);
        if (store == null) {
            // 지정된 ID에 해당하는 Store가 없을 경우 처리 로직을 추가하세요.
            // 예를 들어, 예외를 던지거나 빈 목록을 반환할 수 있습니다.
            return Collections.emptyList();
        }
        String jpql = "SELECT r FROM Review r WHERE r.store = :store";
        TypedQuery<Review> query = entityManager.createQuery(jpql, Review.class);
        query.setParameter("store", store);
        return query.getResultList();
    }

    @Override
    public List<Review> getReviewByUser(Long userId) {
        User user = entityManager.find(User.class, userId);

        if (userId== null) {
            // 지정된 ID에 해당하는 Store가 없을 경우 처리 로직을 추가하세요.
            // 예를 들어, 예외를 던지거나 빈 목록을 반환할 수 있습니다.
            return Collections.emptyList();
        }
        String jpql = "SELECT r FROM Review r WHERE r.user = :user";
        TypedQuery<Review> query = entityManager.createQuery(jpql, Review.class);
        query.setParameter("user", user);
        return query.getResultList();
    }


}
