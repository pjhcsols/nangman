package nc.alright.controller.store;

import nc.alright.domain.store.Store;
import nc.alright.domain.user.JoinStatus;
import nc.alright.domain.user.User;
import nc.alright.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/create")
    public Store createStore(@RequestBody Store store){
        return storeService.createStore(store);
    }

    @GetMapping("/{storeId}")
    public Store getStoreById(@PathVariable Long storeId){
        return storeService.getStoreById(storeId);
    }
    //스토어 전체 항목 전송
    @GetMapping("/allstore")
    public List<Store> getAllStore(){
        return storeService.getAllStore();
    }



    //카테고리에 해당되는 스토어 항목 전송
    @GetMapping("/categorys")
    public List<Store> getStoresByCategoryIds(@PathVariable int storeCategoryId) {
        return storeService.getStoresByCategoryId(storeCategoryId);
    }



    @PostMapping("/category")
    public List<Store> getStoresByCategoryId(@RequestBody int storeCategoryId) {
        return storeService.getStoresByCategoryId(storeCategoryId);
    }



    @PutMapping("/{storeId}")
    public Store updateStore(@PathVariable Long storeId,@RequestBody Store updatedStore){
        return storeService.updateStore(storeId,updatedStore);
    }

    @DeleteMapping("/{storeId}")
    public void deleteStore(Long storeId){
        storeService.deleteStore(storeId);
    }

    public List<Store> getStoreByName(@PathVariable String storeName) {
        return storeService.getStoreByName(storeName);
    }

    @GetMapping("/search/{word}")
    public List<Store> getStoreByWord(@PathVariable String word){
        return storeService.getStoreByWord(word);
    }



    public Store getStoreByLocation(float storeLatitude, float storeLongitude){
        return storeService.getStoreByLocation(storeLatitude,storeLongitude);
    }


    public Store getStoreByPhoneNumber(String storePhoneNumber){
        return storeService.getStoreByPhoneNumber(storePhoneNumber);
    }


    public Store getStoreByAddress(String storeAddress){
        return storeService.getStoreByAddress(storeAddress);
    }
}
