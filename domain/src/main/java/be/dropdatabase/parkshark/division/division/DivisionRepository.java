package be.dropdatabase.parkshark.division.division;

import org.hibernate.JDBCException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Repository
public class DivisionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Division createDivision(Division division) throws PersistenceException{

        entityManager.persist(division);
        return division;
    }

    public Division findByName(String divisionName){
        return entityManager.createQuery("from Division where divisionName = :divisionName", Division.class)
                .setParameter("divisionName", divisionName)
                .getSingleResult();
    }

    public List<Division> getAllDivisions(){
        return entityManager.createQuery("from Division",Division.class).getResultList();
    }
}
