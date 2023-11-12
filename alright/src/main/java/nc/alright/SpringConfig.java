package nc.alright;

import jakarta.persistence.EntityManager;
import nc.alright.repository.store.JpaStoreRepository;
import nc.alright.repository.store.StoreRepository;
import nc.alright.repository.user.JpaUserRepository;
import nc.alright.repository.user.UserRepository;
import nc.alright.service.store.StoreService;
import nc.alright.service.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final EntityManager entityManager;
    public SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Bean
    public UserService userService() {return new UserService(userRepository());
    }
    @Bean
    public UserRepository userRepository() {return new JpaUserRepository(entityManager);}

/*
    @Bean
    public StoreService storeService(){ return new StoreService((JpaStoreRepository) storeRepository());
    }

    @Bean
    public StoreRepository storeRepository() {return new JpaStoreRepository(entityManager);}
*/
}
