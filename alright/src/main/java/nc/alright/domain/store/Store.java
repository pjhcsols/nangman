package nc.alright.domain.store;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter @Setter
//@Table(name = "")
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

    /*@ManyToOne
    private Host host;*/

    public Store(){
    }
}
