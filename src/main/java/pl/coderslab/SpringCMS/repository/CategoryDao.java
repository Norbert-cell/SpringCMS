package pl.coderslab.SpringCMS.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.SpringCMS.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveCategory (Category category) {
        entityManager.persist(category);
    }

    public Category findById(long id){
        return entityManager.find(Category.class, id);
    }

    public void update(Category category){
        entityManager.merge(category);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ? category : entityManager.merge(category));
    }

    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c").getResultList();
    }

}
