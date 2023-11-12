package nc.alright.repository.category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nc.alright.domain.category.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class JpaCategoryRepository implements CategoryRepository {
    @PersistenceContext
    private EntityManager em;
    public JpaCategoryRepository() {
        // 초기 카테고리 데이터를 추가합니다.
        createCategory(new Category(1L, "노키즈존"));
        createCategory(new Category(2L, "예스키즈존"));
    }


    @Override
    public Category createCategory(Category category) {
        em.persist(category);
        return category;
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return em.find(Category.class, categoryId);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return em.createQuery("SELECT c FROM Category c WHERE c.categoryName = :categoryName", Category.class)
                .setParameter("categoryName", categoryName)
                .getSingleResult();
    }

    @Override
    public List<Category> getAllCategories() {
        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    @Override
    public Category updateCategory(Category category) {
        return em.merge(category);
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        Category category = getCategoryById(categoryId);
        em.remove(category);
    }

    @Override
    public void deleteCategoryByName(String categoryName) {
        Category category = getCategoryByName(categoryName);
        em.remove(category);
    }
}