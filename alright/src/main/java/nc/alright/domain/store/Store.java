package nc.alright.domain.store;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;
    private String storeName;
    private String storePhoneNumber;
    private String storeAddress;
    private String storeImage;
    private float storeLatitude;
    private float storeLongitude;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage;
    }

    public float getStoreLatitude() {
        return storeLatitude;
    }

    public void setStoreLatitude(float storeLatitude) {
        this.storeLatitude = storeLatitude;
    }

    public float getStoreLongitude() {
        return storeLongitude;
    }

    public void setStoreLongitude(float storeLongitude) {
        this.storeLongitude = storeLongitude;
    }

    public Store(){

    }
}
