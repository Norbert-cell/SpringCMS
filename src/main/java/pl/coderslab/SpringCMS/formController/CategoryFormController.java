package pl.coderslab.SpringCMS.formController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringCMS.model.Article;
import pl.coderslab.SpringCMS.model.Category;
import pl.coderslab.SpringCMS.repository.ArticleDao;
import pl.coderslab.SpringCMS.repository.CategoryDao;


import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/categoryForm")
public class CategoryFormController {
    private final Logger logger = LoggerFactory.getLogger(CategoryFormController.class);
    private final CategoryDao categoryDao;
    private final ArticleDao articleDao;

    public CategoryFormController(CategoryDao categoryDao, ArticleDao articleDao) {
        this.categoryDao = categoryDao;
        this.articleDao = articleDao;
    }

    @GetMapping("")
    public String allCategories(Model model){
        model.addAttribute("categories", categoryDao.findAll());
        return "category/all";
    }

    @GetMapping("/add")
    public String initAddCategory(Model model){
        model.addAttribute("category", new Category());
        return "category/addAndEdit";
    }

    @PostMapping("/add")
    public String persistCategory(@ModelAttribute Category category){
        categoryDao.saveCategory(category);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String initMergeCategory(@RequestParam long toEditId, Model model){
        model.addAttribute("category", categoryDao.findById(toEditId));
        return "category/addAndEdit";
    }

    @PostMapping("/edit")
    public String mergeCategory(@ModelAttribute Category category){
        categoryDao.update(category);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String prepareRemoveCategory(@RequestParam long toRemoveId, Model model){
        model.addAttribute("category", categoryDao.findById(toRemoveId));
        return "category/confirmDelete";
    }

    @PostMapping("/remove")
    public String removeCategory(@ModelAttribute Category category, @RequestParam String confirmed){
        if("yes".equals(confirmed)){
            for (Article article : articleDao.articles()) {
                List<Category> collect = article.getCategories();
                List<Category> finalCategory = collect.stream()
                        .filter(x -> x.getId() != category.getId())
                        .collect(Collectors.toList());
                article.setCategories(finalCategory);
                articleDao.update(article);
                logger.info(article.toString());
            }
            categoryDao.delete(category);
        }
        return "redirect:";
    }

}
