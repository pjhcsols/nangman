package nc.alright.service.category;

import jakarta.transaction.Transactional;
import nc.alright.domain.category.Category;
import nc.alright.domain.store.Store;
import nc.alright.repository.category.CategoryRepository;
import nc.alright.repository.store.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final StoreRepository storeRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, StoreRepository storeRepository) {
        this.categoryRepository = categoryRepository;
        this.storeRepository = storeRepository;
    }


    public Category createCategory(Category category) {
        return categoryRepository.createCategory(category);
    }
/*
    public List<Store> getStoreByCategory(Long storeCategoryId) {
        Category category = categoryRepository.getCategoryById(storeCategoryId);
        if (category != null) {
            Long categoryValue = category.getCategoryId();
            return storeRepository.getStoreByCategoryId(categoryValue);
        } else {
            // 지정된 categoryId에 해당하는 카테고리가 없는 경우 빈 목록 반환
            return new ArrayList<>();
        }
    }

 */
}