package be.dropdatabase.parkshark.domain.address;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static java.util.Objects.isNull;

@Repository
@Transactional
public class PostalCodeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PostalCode save(PostalCode postalCode){
        entityManager.persist(postalCode);
        return postalCode;
    }

    public PostalCode findPostalCodeById(long id){
        return entityManager.find(PostalCode.class, id);
    }

    public PostalCode findPostalCodeByPostalCode(String postalCode){
        return entityManager.createQuery("from PostalCode p where postalCode = :postalCode", PostalCode.class)
                .setParameter("postalCode", postalCode)
                .getSingleResult();
    }
}
