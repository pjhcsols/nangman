package nc.alright.service.store;

import nc.alright.domain.store.Store;
import nc.alright.repository.store.JpaStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StoreService {
    private final JpaStoreRepository jpaStoreRepository;

    @Autowired
    public StoreService(JpaStoreRepository jpaStoreRepository) {
        this.jpaStoreRepository = jpaStoreRepository;
    }

    public Store createStore(Store store){
        return jpaStoreRepository.createStore(store);
    }

    public Store getStoreById(Long storeId){
        return jpaStoreRepository.getStoreById(storeId);
    }

    public List<Store> getAllStore(){
        return jpaStoreRepository.getAllStore();
    }

    public Store updateStore(Long storeId,Store updatedStore){
        return jpaStoreRepository.updateStore(storeId,updatedStore);
    }

    public void deleteStore(Long storeId){
        jpaStoreRepository.deleteStore(storeId);
    }

    public List<Store> getStoreByName(String storeName) {
        return jpaStoreRepository.getStoreByName(storeName);
    }

    public List<Store> getStoreByWord(String word){
        return jpaStoreRepository.getStoreByWord(word);
    }

    public Store getStoreByLocation(float storeLatitude, float storeLongitude){
        return jpaStoreRepository.getStoreByLocation(storeLatitude,storeLongitude);
    }

    public Store getStoreByPhoneNumber(String storePhoneNumber){
        return jpaStoreRepository.getStoreByPhoneNumber(storePhoneNumber);
    }

    public Store getStoreByAddress(String storeAddress){
        return jpaStoreRepository.getStoreByAddress(storeAddress);
    }
}

