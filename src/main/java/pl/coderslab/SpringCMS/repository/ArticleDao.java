package pl.coderslab.SpringCMS.repository;

import org.springframework.stereotype.Repository;
import pl.coderslab.SpringCMS.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveArticle (Article article) {
        entityManager.persist(article);
    }

    public Article findById(long id){
        return entityManager.find(Article.class, id);
    }

    public void update(Article article){
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }
    public List<Article> articles(){
        Query query = entityManager.createQuery("select a from Article a");
        return query.getResultList();
    }

    public List<Article> fiveLastAddedArticle(){
        return entityManager.createQuery("select a from Article a order by updated_on desc ", Article.class)
                .setMaxResults(5).getResultList();
    }

    public void deleteArticleFromInputAutor(long authorId){
        entityManager.createQuery("delete from Article where author.id =:id").setParameter("id",authorId);
    }


}
