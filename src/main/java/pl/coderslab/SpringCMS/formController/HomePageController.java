package pl.coderslab.SpringCMS.formController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.SpringCMS.model.Article;
import pl.coderslab.SpringCMS.repository.ArticleDao;


import java.util.List;

@Controller
public class HomePageController {

    private final Logger logger = LoggerFactory.getLogger(HomePageController.class);


    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping(value = "/", produces = "text/html; charset=UTF-8")
    public String home(Model model){
        List<Article> articles = articleDao.fiveLastAddedArticle();
        articles.stream().forEach(x -> logger.info(String.valueOf(x)));
        model.addAttribute("fiveArticle", articles);
        return "home/home";
    }
}
