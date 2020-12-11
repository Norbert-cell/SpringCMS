package pl.coderslab.SpringCMS.formController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringCMS.model.Author;
import pl.coderslab.SpringCMS.repository.ArticleDao;
import pl.coderslab.SpringCMS.repository.AuthorDao;



@Controller
@RequestMapping("/authorForm")
public class AuthorFormController {

    private final AuthorDao authorDao;
    private final ArticleDao articleDao;

    public AuthorFormController(AuthorDao authorDao, ArticleDao articleDao) {
        this.authorDao = authorDao;
        this.articleDao = articleDao;
    }

    @GetMapping("")
    public String allCategories(Model model){
        model.addAttribute("authors", authorDao.authors());
        return "author/all";
    }

    @GetMapping("/add")
    public String initAddAutor(Model model){
        model.addAttribute("author", new Author());
        return "author/addAndEdit";
    }

    @PostMapping("/add")
    public String persistAutor(@ModelAttribute Author author){
        authorDao.saveAuthor(author);
        return "redirect:";
    }

    @GetMapping("/edit")
    public String initMergeAuthor(@RequestParam long toEditId, Model model){
        model.addAttribute("author", authorDao.findById(toEditId));
        return "author/addAndEdit";
    }

    @PostMapping("/edit")
    public String mergeAuthor(@ModelAttribute Author author){
        authorDao.update(author);
        return "redirect:";
    }

    @GetMapping("/remove")
    public String prepareRemoveAuthor(@RequestParam long toRemoveId, Model model){
        model.addAttribute("author", authorDao.findById(toRemoveId));
        return "author/confirmDelete";
    }

    @PostMapping("/remove")
    public String removeCategory(@ModelAttribute Author author, @RequestParam String confirmed){
        if("yes".equals(confirmed)){
            articleDao.deleteArticleFromInputAutor(author.getId());
            authorDao.delete(author);
        }
        return "redirect:";
    }
}
