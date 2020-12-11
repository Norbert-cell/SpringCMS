package pl.coderslab.SpringCMS.formController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringCMS.model.Article;
import pl.coderslab.SpringCMS.model.Author;
import pl.coderslab.SpringCMS.model.Category;
import pl.coderslab.SpringCMS.repository.ArticleDao;
import pl.coderslab.SpringCMS.repository.AuthorDao;
import pl.coderslab.SpringCMS.repository.CategoryDao;

import java.util.List;

@Controller
@RequestMapping("/articleForm")
public class ArticleFormController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;
    private final Logger logger = LoggerFactory.getLogger(CategoryFormController.class);


    public ArticleFormController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @ModelAttribute("authors")
    public List<Author> authorList(){
        return authorDao.authors();
    }
    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return categoryDao.findAll();
    }

    @GetMapping("")
    public String allArticles(Model model){
        model.addAttribute("articles", articleDao.articles());
        return "article/all";
    }

    @GetMapping("/add")
    public String initAddArticle(Model model){
        model.addAttribute("article", new Article());
        return "article/addAndEdit";
    }

    @PostMapping("/add")
    public String persistArticle(@ModelAttribute Article article){
        logger.info(article.toString());
        articleDao.saveArticle(article);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String initMergeArticle(@RequestParam long toEditId, Model model){
        model.addAttribute("article", articleDao.findById(toEditId));
        return "article/addAndEdit";
    }

    @PostMapping("/edit")
    public String mergeArticle(@ModelAttribute Article article){
        articleDao.update(article);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String prepareRemoveArticle(@RequestParam long toRemoveId, Model model){
        model.addAttribute("article", articleDao.findById(toRemoveId));
        return "article/confirmDelete";
    }

    @PostMapping("/remove")
    public String removeArticle(@ModelAttribute Article article, @RequestParam String confirmed){
        if("yes".equals(confirmed)){
          articleDao.delete(article);
        }
        return "redirect:";
    }
}
