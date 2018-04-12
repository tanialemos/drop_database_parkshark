package be.dropdatabase.parkshark.domain.persondetails;

import be.dropdatabase.parkshark.domain.address.Address;
import be.dropdatabase.parkshark.domain.address.AddressRepository;
import be.dropdatabase.parkshark.domain.address.PostalCode;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;


public class AddressRepositoryTest {

//    private AddressRepository addressRepository;
//
//    @Autowired
//    public AddressRepositoryTest(AddressRepository addressRepository){
//        this.addressRepository = addressRepository;
//    }
//
//    @Test
//    @Transactional
//    public void save_willSaveAddressToDatabase() {
//        PostalCode pc = new PostalCode("5000", "Mons");
//        Address actualAddress = new AddressBuilder().setStreetName("Rue de la Montagne").setStreetNumber("25").setPostalCode(pc).createAddress();
//        addressRepository.save(actualAddress);
//
//        Assertions.assertThat(actualAddress.getAddressId()).isNotNull();
//    }

}