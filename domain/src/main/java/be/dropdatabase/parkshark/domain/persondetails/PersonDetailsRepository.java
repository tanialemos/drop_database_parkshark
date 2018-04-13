package be.dropdatabase.parkshark.domain.persondetails;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonDetails save(PersonDetails personDetails){
        entityManager.persist(personDetails);
        return personDetails;
    }

    public PersonDetails findById(long personDetailsId){
        return entityManager.find(PersonDetails.class, personDetailsId);
    }
}
