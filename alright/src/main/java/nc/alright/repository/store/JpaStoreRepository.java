package nc.alright.repository.store;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import nc.alright.domain.store.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JpaStoreRepository implements StoreRepository{

    @PersistenceContext
    private EntityManager entityManager;

    /*
    @PostConstruct
    public void init() {
        try {
            // 초기 카테고리 데이터를 추가합니다.
            createStore(new Category(1L, "노키즈존"));
            createCategory(new Category(2L, "예스키즈존"));
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 콘솔에 출력
        }
    }
*/
    @Override
    @Transactional
    public Store createStore(Store store) {
        // 고유 ID 생성 및 설정
        store.setStoreId(null); // ID는 자동 생성
        entityManager.persist(store);
        return store;
    }

    @Override
    public Store getStoreById(Long storeId) {
        return entityManager.find(Store.class,storeId);
    }

    @Override
    public List<Store> getAllStore() {
        String jpql = "SELECT s FROM Store s";
        TypedQuery<Store> query = entityManager.createQuery(jpql, Store.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public Store updateStore(Long storeId, Store updatedStore) {
        Store existingStore = entityManager.find(Store.class, storeId);
        if (existingStore != null) {
            // 업데이트된 정보로 사용자 업데이트
            existingStore.setStoreAddress(updatedStore.getStoreAddress());
            existingStore.setStoreImage(updatedStore.getStoreImage());
            existingStore.setStoreLatitude(updatedStore.getStoreLatitude());
            existingStore.setStoreLongitude(updatedStore.getStoreLongitude());
            existingStore.setStorePhoneNumber(updatedStore.getStorePhoneNumber());
            existingStore.setStoreName(updatedStore.getStoreName());
            entityManager.merge(existingStore);
            return existingStore;
        }
        return null;
        /** 에러 캐치 할건가용?**/
    }

    @Override
    public void deleteStore(Long storeId) {
        Store store = entityManager.find(Store.class, storeId);
        if (store != null) {
            entityManager.remove(store);
        }
    }

    @Override
    public List<Store> getStoreByName(String storeName) {
        String jpql = "SELECT s FROM Store s WHERE s.storeName = :storeName";
        TypedQuery<Store> query = entityManager.createQuery(jpql, Store.class);
        query.setParameter("storeName",storeName );
        return query.getResultList();
    }

    @Override
    public List<Store> getStoreByWord(String word) {
        String jpql = "SELECT s FROM Store s WHERE s.storeName LIKE :word";
        TypedQuery<Store> query = entityManager.createQuery(jpql, Store.class);
        query.setParameter("word", "%" + word + "%");
        return query.getResultList();
    }


    @Override
    public Store getStoreByLocation(float storeLatitude, float storeLongitude) {
        String jpql = "SELECT s FROM Store s " +
                "WHERE s.storeLatitude BETWEEN :minLatitude AND :maxLatitude " +
                "AND s.storeLongitude BETWEEN :minLongitude AND :maxLongitude";

        float epsilon = 0.000001f;  // 적절한 오차 값을 선택하세요

        TypedQuery<Store> query = entityManager.createQuery(jpql, Store.class);
        query.setParameter("minLatitude", storeLatitude - epsilon);
        query.setParameter("maxLatitude", storeLatitude + epsilon);
        query.setParameter("minLongitude", storeLongitude - epsilon);
        query.setParameter("maxLongitude", storeLongitude + epsilon);

        return query.getSingleResult();
    }

    @Override
    public Store getStoreByPhoneNumber(String storePhoneNumber) {
        String jpql = "SELECT s FROM Store s WHERE s.storePhoneNumber = :storePhoneNumber";
        TypedQuery<Store> query = entityManager.createQuery(jpql, Store.class);
        query.setParameter("storePhoneNumber",storePhoneNumber );
        return query.getSingleResult();
    }

    @Override
    public Store getStoreByAddress(String storeAddress) {
        String jpql = "SELECT s FROM Store s WHERE s.storeAddress = :storeAddress";
        TypedQuery<Store> query = entityManager.createQuery(jpql, Store.class);
        query.setParameter("storeAddress",storeAddress );
        return query.getSingleResult();
    }
}
