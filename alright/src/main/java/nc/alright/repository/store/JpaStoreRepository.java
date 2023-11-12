package nc.alright.repository.store;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nc.alright.domain.store.Store;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


@Repository
@Slf4j
@RequiredArgsConstructor

public class JpaStoreRepository implements StoreRepository{

    @PersistenceContext
    private final EntityManager entityManager;

    private final JpaStoreRepositoryLegend jpaStoreRepositoryLegend;

    public Store makeStore(String name, String address, String phoneNumber,float Latitude, float Longitude,Long categoryId){
        Store store = new Store();
        store.setStoreName(name);
        store.setStoreAddress(address);
        store.setStorePhoneNumber(phoneNumber);
        store.setStoreLatitude(Latitude);
        store.setStoreLongitude(Longitude);
        store.setStoreCategoryId(categoryId);
        store.setStoreImage(null);

        return store;
    }

    @PostConstruct
    public void init() {
        try {
            List<Store> stores = new ArrayList<>();

            stores.add(makeStore("dayeon's house", "효목동", "010-2807-7142", 35.884216f, 128.636611f, 1L));
            stores.add(makeStore("jeongmin's house", "검사동", "010-5829-3811", 35.844101f, 128.598248f, 2L));
            stores.add(makeStore("어린이공원", "검사동", "010-5829-3811", 35.858111f, 128.581458f, 3L));
            stores.add(makeStore("빌리 웍스", "북구 고성동", "010-7849-2190", 35.883112f, 128.588544f, 1L));
            stores.add(makeStore("MGU문화순화", "북구 복현동입니당", "010-2134-5123", 35.892840f, 128.620513f, 3L));
            stores.add(makeStore("MGU문화순화센터", "북구 복현동", "010-2134-5123", 35.87840f, 128.630513f, 3L));
            stores.add(makeStore("점프플레이방", "서구 평리로 137", "010-2449-9586", 35.865883f, 128.564108f, 3L));
            stores.add(makeStore("플레이방방", "대구광역시 서구 국채보상로 316", "010-1405-9473", 35.871621f, 128.565298f, 3L));
            stores.add(makeStore("몽키팡팡", "대구광역시 서구 달서천로57길 32 ", "010-2449-9586", 35.887130f, 128.564235f, 3L));
            stores.add(makeStore("제리집", "대구광역시 중구 약령길 20", "010-6930-1058", 35.867277f, 128.589032f, 2L));
            stores.add(makeStore("에이피피", "대구 중구 달구벌대로443길 17", "010-8854-2439", 35.863755f, 128.605011f, 2L));
            stores.add(makeStore("캡트커피", "대구 수성구 청솔로14길 28", "010-5023-1234", 35.851016f, 128.622359f, 2L));
            stores.add(makeStore("디웨이브", "대구 서구 서대구로 3", "010-6969-2383", 35.858065f, 128.556505f, 2L));
            stores.add(makeStore("낫온리커피어반델리", "대구 수성구 용학로 106-7", "053-795-5588", 35.824299f, 128.618883f, 1L));
            stores.add(makeStore("호반", "대구 수성구 용학로 45", "010-1234-1234", 35.826316f, 128.614669f, 1L));
            stores.add(makeStore("푸나왈라", "대구 북구 동천로 127", "010-6311-5820", 35.825825f, 128.560607f, 2L));
            stores.add(makeStore("쏠레이", "대구 동구 동촌로46길 12", "010-3386-9214", 35.880790f, 128.663816f, 2L));
            stores.add(makeStore("애하인앞산", "대구 남구 용두2길 26", "010-6610-4920", 35.830781f, 128.603757f, 2L));
            stores.add(makeStore("푸나왈라", "대구 북구 동천로 127", "010-6311-5820", 35.825825f, 128.560607f, 2L));
            stores.add(makeStore("은화", "대구 달서구 구마로39길 10", "010-5502-2954", 35.837768f, 128.548909f, 2L));
            stores.add(makeStore("맘편한 플레이스", "대구 북구 대현로 102", "010-4833-3922", 35.882044f, 128.610042f, 3L));

            for (Store store : stores) {
                jpaStoreRepositoryLegend.createStore(store);
                log.info("Store inserted: {}", store.getStoreName());
            }
        } catch (Exception e) {
            log.error("Error during initialization: " + e.getMessage());
        }
    }

    @Override
    public Store createStore(Store store) {
        // 고유 ID 생성 및 설정
        //store.setStoreId(null); // ID는 자동 생성
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
        TypedQuery<Store> query = entityManager.createQuery(jpql,Store.class);
        return query.getResultList();
    }
    @Override
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
