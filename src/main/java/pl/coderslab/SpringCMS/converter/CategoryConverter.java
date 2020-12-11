package pl.coderslab.SpringCMS.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.SpringCMS.model.Category;
import pl.coderslab.SpringCMS.repository.CategoryDao;

@Component
public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Category convert(String s) {
        return categoryDao.findById(Long.parseLong(s));
    }
}
