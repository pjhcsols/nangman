package nc.alright.controller.category;

import nc.alright.domain.store.Store;
import nc.alright.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
/*
    @PostMapping("/stores")
    public List<Store> getStoresByCategory(@PathVariable Long storeCategoryId) {
        return categoryService.getStoreByCategory(storeCategoryId);
    }

 */
/*
    @GetMapping("/{categoryId}/stores")
    public List<Store> getStoresByCategory(@PathVariable Long categoryId) {
        return categoryService.getStoreByCategory(categoryId);
    }

 */
}
