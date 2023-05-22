package jpaMaven;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
// INSERINDO E EXCLUINDO DADOS
public class Principal {

	 private static Principal instance;
     protected EntityManager entityManager;

     public static Principal getInstance(){
       if (instance == null){
          instance = new Principal();
       }

       return instance;
     }

     private Principal() {
       entityManager = getEntityManager();
     }

     private EntityManager getEntityManager() {
      EntityManagerFactory factory =
      Persistence.createEntityManagerFactory("dbjpa");
      if (entityManager == null) {
        entityManager = factory.createEntityManager();
      }

      return entityManager;
     }

     public Pessoa getById(final int id) {
       return entityManager.find(Pessoa.class, id);
     }

     @SuppressWarnings("unchecked")
     public List<Pessoa> findAll() {
       return entityManager.createQuery("FROM " +
       Pessoa.class.getName()).getResultList();
     }

     public void persist(Pessoa pessoa) {
       try {
          entityManager.getTransaction().begin();
          entityManager.persist(pessoa);
          entityManager.getTransaction().commit();
       } catch (Exception ex) {
          ex.printStackTrace();
          entityManager.getTransaction().rollback();
       }
     }

     public void remove(Pessoa pessoa) {
       try {
          entityManager.getTransaction().begin();
          pessoa = entityManager.find(Pessoa.class, pessoa.getId());
          entityManager.remove(pessoa);
          entityManager.getTransaction().commit();
       } catch (Exception ex) {
          ex.printStackTrace();
          entityManager.getTransaction().rollback();
       }
     }
}
