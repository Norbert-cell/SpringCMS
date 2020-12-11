package pl.coderslab.SpringCMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.SpringCMS.model.Category;
import pl.coderslab.SpringCMS.repository.CategoryDao;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;


    @GetMapping("/findAll")
    @ResponseBody
    public List<Category> findAll(){
        return categoryDao.findAll();
    }
}
