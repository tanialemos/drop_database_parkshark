package be.dropdatabase.parkshark.domain.persondetails;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;


public class AddressRepositoryTest {

    private AddressRepository addressRepository;

    @Autowired
    public AddressRepositoryTest(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Test
    @Transactional
    public void save_willSaveAddressToDatabase() {
        PostalCode pc = new PostalCode("5000", "Mons");
        Address actualAddress = new Address("Rue de la Montagne", "25", pc);
        addressRepository.save(actualAddress);

        List<Address> addresses = addressRepository.findByStreetName("Rue de la Montagne");

        Assertions.assertThat(addresses).contains(actualAddress);

    }

//    @Test
//    public void findById() {
//    }
}