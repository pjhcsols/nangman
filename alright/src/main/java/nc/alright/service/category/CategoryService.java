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

    public List<Store> getStoreByCategory(Long categoryId) {
        Category category = categoryRepository.getCategoryById(categoryId);
        if (category != null) {
            if ("노키즈존".equals(category.getCategoryName())) {
                return storeRepository.getStoreByName("노키즈존");
            } else if ("예스키즈존".equals(category.getCategoryName())) {
                return storeRepository.getStoreByName("예스키즈존");
            }
        }
        //return new ArrayList<>(); // 노키즈존 또는 예스키즈존이 없는 경우 빈 목록 반환
        return null;
    }
}