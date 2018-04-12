package be.dropdatabase.parkshark.domain.division;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DivisionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Division createDivision(Division division){
        entityManager.persist(division);
        return division;
    }

    public Division findByName(String divisionName){
        return entityManager.createQuery("from Division where divisionName = :divisionName", Division.class)
                .setParameter("divisionName", divisionName)
                .getSingleResult();
    }
}
