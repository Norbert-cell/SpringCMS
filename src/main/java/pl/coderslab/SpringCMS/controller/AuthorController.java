package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.SpringCMS.model.Author;
import pl.coderslab.SpringCMS.repository.AuthorDao;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Author> findAll(){
        return authorDao.authors();
    }
}
