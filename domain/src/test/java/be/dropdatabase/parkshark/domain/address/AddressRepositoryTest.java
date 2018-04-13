package be.dropdatabase.parkshark.domain.address;

import be.dropdatabase.parkshark.domain.address.Address;
import be.dropdatabase.parkshark.domain.address.AddressRepository;
import be.dropdatabase.parkshark.domain.address.PostalCode;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {AddressRepository.class})
@EnableAutoConfiguration
public class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    @Transactional
    public void save_willSaveAddressToDatabase() {
        PostalCode pc = new PostalCode("5000", "Mons");

        Address actualAddress = new Address.AddressBuilder().withStreetName("Rue de la Montagne").withStreetNumber("25").withPostalCode(pc).createAddress();

        addressRepository.save(actualAddress);

        Assertions.assertThat(actualAddress.getAddressId()).isNotNull();
    }
}
