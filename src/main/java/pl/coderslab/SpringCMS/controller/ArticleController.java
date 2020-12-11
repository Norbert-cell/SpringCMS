package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.SpringCMS.model.Article;
import pl.coderslab.SpringCMS.model.Author;
import pl.coderslab.SpringCMS.model.Category;
import pl.coderslab.SpringCMS.repository.ArticleDao;
import pl.coderslab.SpringCMS.repository.AuthorDao;
import pl.coderslab.SpringCMS.repository.CategoryDao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleDao articleDao;
    private final CategoryDao categoryDao;
    private final AuthorDao authorDao;

    public ArticleController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
        this.articleDao = articleDao;
        this.categoryDao = categoryDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Article> findAll(){
        return articleDao.articles();
    }


    @GetMapping("/delete/{id}")
    @ResponseBody
    public String removeArticle(@PathVariable long id) {
        articleDao.delete(articleDao.findById(id));
        return "Usunieto!";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String readSingleArticle(@PathVariable long id) {
        return articleDao.findById(id).toString();
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public String updateArticle(@PathVariable long id) {
        Article article = articleDao.findById(id);
        article.setUpdatedOn(LocalDateTime.now());
        article.setTitle("tytul");
        articleDao.update(article);
        return "Zaktualizowano! " + article.toString();
    }

    @GetMapping("/add")
    public String addArticle(){
        Article article = new Article();
        Article article2 = new Article();

        Category category = categoryDao.findById(1);
        Category category2 = categoryDao.findById(2);
        List<Category>categories = Arrays.asList(category,category2);

        Author author = authorDao.findById(1);
        Author author2 = authorDao.findById(2);

        article.setAuthor(author);
        article.setCategories(categories);
        article.setTitle("nowy");
        article.setUpdatedOn(LocalDateTime.now());
        article.setCreatedOn(LocalDateTime.now());
        article.setContent("opis");

        article2.setAuthor(author2);
        article2.setCategories(categories);
        article2.setTitle("nowy2");
        article2.setUpdatedOn(LocalDateTime.now());
        article2.setCreatedOn(LocalDateTime.now());
        article2.setContent("opis2");

        articleDao.saveArticle(article);
        articleDao.saveArticle(article2);
        return article.toString();

    }
}
