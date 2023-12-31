package nc.alright.repository.store;

import nc.alright.domain.store.Store;
import nc.alright.domain.user.User;

import java.util.List;

public interface StoreRepository {

    //상점 생성하는 메서드
    Store createStore(Store store);

    //상점id로 상점 찾는 메서드
    Store getStoreById(Long storeId);

    //상점 고유 Id로 상점을 업데이트 하는 메서드
    Store updateStore(Long storeId,Store updatedStore);

    //이름으로 상점 찾는 메서드
    List<Store> getStoreByName(String storeName);

    //단어가 일치하는 상점 찾는 메서드
    List<Store> getStoreByWord(String word);

    //모든 상점 목록을 조회하는 메서드
    List<Store> getAllStore();

    // 상점 고유 ID로 상점을 삭제하는 메서드
    void deleteStore(Long storeId);

    //상점의 경도와 위도를 이용하여 상점을 조회하는 메서드
    Store getStoreByLocation(float storeLatitude, float storeLongitude);

    //전화번호를 이용하여 상점을 조회하는 메서드
    Store getStoreByPhoneNumber(String storePhoneNumber);

    //주소를 이용하여 상점을 조회하는 메서드
    Store getStoreByAddress(String storeAddress);

    //추가
    List<Store> getStoreByCategoryId(int storeCategoryId);
}
