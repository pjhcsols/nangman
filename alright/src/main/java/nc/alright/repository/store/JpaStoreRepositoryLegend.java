package nc.alright.repository.store;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nc.alright.domain.store.Store;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaStoreRepositoryLegend {
    private final EntityManager entityManager;

    @Transactional
    public Store createStore(Store store) {
        // 고유 ID 생성 및 설정
        //store.setStoreId(null); // ID는 자동 생성
        entityManager.persist(store);
        return store;
    }
}
