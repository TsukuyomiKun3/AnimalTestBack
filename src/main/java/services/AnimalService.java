package services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import models.Animal;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;

import java.util.List;

@ApplicationScoped
public class AnimalService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Animal> findAll() {
        return em.createQuery("SELECT a FROM Animal a", Animal.class).getResultList();
    }

    @Transactional
    public Animal findById(int id) {
        return em.find(Animal.class, id);
    }

    @Transactional
    public Animal add(Animal entity) {
        em.persist(entity);
        return entity;
    }

    @Transactional
    public Animal delete(int id) {
        Animal animal = em.find(Animal.class, id);
        if (animal!=null) {
            em.remove(animal);
            return animal;
        } else {
            return new Animal();
        }
    }

    @Transactional
    public void update(Animal entity) {
        em.merge(entity);
    }

//    @Transactional
//    public List<Animal> search(String searchTerm) {
//        SearchSession searchSession = Search.session(em);
//
//        return searchSession.search(Animal.class)
//                .where(f -> f.match().fields("type").matching(searchTerm))
//                .fetchHits(20);
//    }
}
