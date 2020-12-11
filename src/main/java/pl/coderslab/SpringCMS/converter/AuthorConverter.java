package pl.coderslab.SpringCMS.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.SpringCMS.model.Author;
import pl.coderslab.SpringCMS.repository.AuthorDao;

@Component
public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;


    @Override
    public Author convert(String s) {
        return authorDao.findById(Long.parseLong(s));
    }
}
