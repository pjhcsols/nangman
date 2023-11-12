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

    public Store makeStore(String name, String address, String phoneNumber,float Latitude, float Longitude,int storeCategoryId){
        Store store = new Store();
        store.setStoreName(name);
        store.setStoreAddress(address);
        store.setStorePhoneNumber(phoneNumber);
        store.setStoreLatitude(Latitude);
        store.setStoreLongitude(Longitude);
        store.setStoreCategoryId(storeCategoryId);
        store.setStoreImage(null);

        return store;
    }

    @PostConstruct
    public void init() {
        try {
            List<Store> stores = new ArrayList<>();
            stores.add(makeStore("dayeon's house", "효목동", "010-2807-7142", 35.884216f, 128.636611f, 1));
            stores.add(makeStore("jeongmin's house", "검사동", "010-5829-3811", 35.844101f, 128.598248f, 2));
            stores.add(makeStore("어린이공원", "검사동", "010-5829-3811", 35.858111f, 128.581458f, 3));
            stores.add(makeStore("빌리 웍스", "북구 고성동", "010-7849-2190", 35.883112f, 128.588544f, 1));
            stores.add(makeStore("MGU문화순화", "북구 복현동", "010-2134-5123", 35.892840f, 128.620513f, 3));
            stores.add(makeStore("점프플레이방", "서구 평리로 137", "010-2449-9586", 35.865883f, 128.564108f, 3));
            stores.add(makeStore("플레이방방", "대구광역시 서구 국채보상로 316", "010-1405-9473", 35.871621f, 128.565298f, 3));
            stores.add(makeStore("몽키팡팡", "대구광역시 서구 달서천로57길 32 ", "010-2449-9586", 35.887130f, 128.564235f, 3));
            stores.add(makeStore("제리집", "대구광역시 중구 약령길 20", "010-6930-1058", 35.867277f, 128.589032f, 2));
            stores.add(makeStore("에이피피", "대구 중구 달구벌대로443길 17", "010-8854-2439", 35.863755f, 128.605011f, 2));
            stores.add(makeStore("캡트커피", "대구 수성구 청솔로14길 28", "010-5023-1234", 35.851016f, 128.622359f, 2));
            stores.add(makeStore("디웨이브", "대구 서구 서대구로 3", "010-6969-2383", 35.858065f, 128.556505f, 2));
            stores.add(makeStore("낫온리커피어반델리", "대구 수성구 용학로 106-7", "053-795-5588", 35.824299f, 128.618883f, 1));
            stores.add(makeStore("호반", "대구 수성구 용학로 45", "010-1234-1234", 35.826316f, 128.614669f, 1));
            stores.add(makeStore("푸나왈라", "대구 북구 동천로 127", "010-6311-5820", 35.825825f, 128.560607f, 2));
            stores.add(makeStore("쏠레이", "대구 동구 동촌로46길 12", "010-3386-9214", 35.880790f, 128.663816f, 2));
            stores.add(makeStore("애하인앞산", "대구 남구 용두2길 26", "010-6610-4920", 35.830781f, 128.603757f, 2));
            stores.add(makeStore("푸나왈라", "대구 북구 동천로 127", "010-6311-5820", 35.825825f, 128.560607f, 2));
            stores.add(makeStore("은화", "대구 달서구 구마로39길 10", "010-5502-2954", 35.837768f, 128.548909f, 2));
            stores.add(makeStore("라켓옴", "대구 남구 앞산순환로87길 51", "010-4421-4231", 35.832847f, 128.572907f, 1));
            stores.add(makeStore("베리베리", "대구 달서구 달구벌대로309길 8 1층", "010-4833-3922", 35.850389f, 128.610042f, 1));
            stores.add(makeStore("두낫디스터브 앞산점", "대구 남구 현충로6길 7 1, 2층", "010-1123-8988", 35.834671f, 128.580125f, 1));
            stores.add(makeStore("오아", "대구 수성구 달구벌대로 2811", "010-2261-9403",  35.850231f, 128.667384f, 1));
            stores.add(makeStore("더밀턴", "대구 수성구 용학로 106-7", "010-4833-3922", 35.824450f, 128.619879f, 1));
            stores.add(makeStore("제주 가는 길", "대구 수성구 파동로18길 51-5", "053-692-4329", 35.812269f, 128.620727f, 1));
            stores.add(makeStore("히어로플레이파크 대구침산점", "대구 북구 침산로 240 4층", "010-7783-3132", 35.892840f, 128.589477f, 3));
            stores.add(makeStore("너티차일드", "대구 북구 호암로 51", "010-2134-5123", 35.892840f, 128.589477f, 3));
            stores.add(makeStore("유후점핑클럽", "대구 북구 복현로 105", "010-9582-1232", 35.899186f, 128.621528f, 3));
            stores.add(makeStore("또봇&쥬쥬플레이랜드 대구점", "대구 북구 유통단지로 14길 22", "010-2134-5123", 35.905058f, 128.610450f, 3));
            stores.add(makeStore("헬로밀가루 대구점", "대구 북구 성북로 43 ", "053-356-0816", 35.891547f, 128.588298f, 3));
            stores.add(makeStore("위니키즈카페", "대구 북구 침산로 168", "053-341-9401", 35.891119f, 128.590682f, 3));
            stores.add(makeStore("우리끼리 키즈카페 하늘마을 대구점", "대구 북구 복현동 234-5 2층 205호", "0507-1386-7244",  35.898715f, 128.622266f, 3));
            stores.add(makeStore("아이니키즈시티랜드", "대구 북구 침산로 93 스펙트럼시티 5층", "053-792-7600",  35.885230f, 128.589833f, 3));
            stores.add(makeStore("아이펀블럭", "북구 복현동", "053-355-5123", 35.892402f, 128.587884f, 3));
            stores.add(makeStore("아이랑소금놀이키즈카페 대구점", "대구 북구 침산남로 92 경맥빌딩 6층", "010-5921-3592", 35.889045f, 128.585845f, 3));
            stores.add(makeStore("와글아이 대구반달스퀘어점", "대구 중구 달구벌대로 2095", "010-5521-3721", 35.86629f, 128.592748f, 3));
            stores.add(makeStore("바게리", "대구 수성구 달구벌대로489길 23", "010-4291-5921", 35.859848f, 128.560607f, 2));
            stores.add(makeStore("메이드림", "대구 서구 국채보상로60길 5", "010-6311-5820", 35.871304f, 128.564062f, 2));
            stores.add(makeStore("로에베플로레스", "대구 북구 이곡길 35-10 2층", "010-7794-9343", 35.938461f, 128.604700f, 2));
            stores.add(makeStore("슬로우벗베럴", "대구 동구 신평로 113", "010-7712-4124", 35.879398f, 128.560607f, 2));
            stores.add(makeStore("핸즈커피 앞산점", "대구 남구 앞산순환로 415 1층", "010-6311-5720",  35.831621f, 128.571671f, 2));
            stores.add(makeStore("레이틀리92", "대구 동구 초례로 6 1층", "010-7771-1231",  35.875529f, 128.752443f, 2));
            stores.add(makeStore("신사식탁", "대구 수성구 고산로4안길 25 1층", "010-6921-4951", 35.875529f, 128.752443f, 2));
            stores.add(makeStore("바토 플루이르 송해", "대구 달성군 옥포읍 옥포로57길 57-7 1층", "053-611-7620",  35.769618f, 128.490979f, 2));
            stores.add(makeStore("지지피", "대구 달성군 다사읍 대실역남로4길 30-21 2층", "053-611-5820", 35.848702f, 128.467687f, 2));

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

    @Override
    public List<Store> getStoreByCategoryId(int storeCategoryId) {
        String jpql = "SELECT s FROM Store s WHERE s.storeCategoryId = :storeCategoryId";
        TypedQuery<Store> query = entityManager.createQuery(jpql, Store.class);
        query.setParameter("storeCategoryId", storeCategoryId);
        return query.getResultList();
    }
/*
    @Override
    public List<Store> getAllStore() {
        String jpql = "SELECT s FROM Store s";
        TypedQuery<Store> query = entityManager.createQuery(jpql,Store.class);
        return query.getResultList();
    }

 */
}
/*
    @Override
    public List<Store> getStoreByCategoryId(Long storeCategoryId) {
        String jpql = "SELECT s FROM Store s WHERE s.storeCategoryId = :storeCategoryId";
        TypedQuery<Store> query = entityManager.createQuery(jpql, Store.class);
        query.setParameter("storeCategoryId",storeCategoryId );
        return query.getResultList();
    }

     */