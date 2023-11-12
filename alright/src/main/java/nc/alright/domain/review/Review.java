package nc.alright.domain.review;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nc.alright.domain.store.Store;
import nc.alright.domain.user.User;

import java.util.Date;

@Entity
@Getter @Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String reviewContent;

    private Date reviewDate;

    private float reviewScore;

    @ManyToOne
    private User user;

    @ManyToOne
    private Store store;
}
