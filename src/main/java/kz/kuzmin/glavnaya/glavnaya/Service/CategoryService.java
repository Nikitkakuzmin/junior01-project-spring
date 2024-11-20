package kz.kuzmin.glavnaya.glavnaya.Service;

import kz.kuzmin.glavnaya.glavnaya.Model.Category;
import kz.kuzmin.glavnaya.glavnaya.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        return categoryRepository.findAll();

    }

    public  Category getCategory(Long id){
return categoryRepository.findById(id).orElseThrow();
    }
}
