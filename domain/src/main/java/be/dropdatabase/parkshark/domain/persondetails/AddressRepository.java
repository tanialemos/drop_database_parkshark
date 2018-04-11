package be.dropdatabase.parkshark.domain.persondetails;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AddressRepository() {
    }

    public Address save(Address address){
        entityManager.persist(address);
        return address;
    }

    public Address findById(long id){
         return entityManager.find(Address.class, id);
    }

    public List<Address> findByStreetName(String streetName){
        return entityManager.createQuery("from Address e where streetName = :streetName", Address.class)
                .setParameter("streetName", streetName)
                .getResultList();
    }

}
