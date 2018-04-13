package be.dropdatabase.parkshark.domain.persondetails;

import be.dropdatabase.parkshark.domain.address.Address;
import be.dropdatabase.parkshark.domain.address.PostalCode;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {PersonDetailsRepository.class})
@EntityScan(basePackages = "be.dropdatabase.parkshark.domain")
@EnableAutoConfiguration
public class PersonDetailsRepositoryTest {

    @Autowired
    private PersonDetailsRepository personDetailsRepository;

    @Test
    @Transactional
    public void save_willSavePersonDetailsToDatabase() {
        Address address = Address.AddressBuilder.buildAddress()
                .withStreetName("Rue de l'ignorance")
                .withStreetNumber("15")
                .withPostalCode(new PostalCode("2775", "Ath"))
                .createAddress();

        PersonDetails personDetails = PersonDetails.PersonDetailsBuilder.personDetailsBuilder()
                .setFirstName("Barack")
                .setLastName("Obama")
                .setAddress(address)
                .setEmail("barack.obama@gmail.com")
                .setFixedPhone("0115965483")
                .setMobilePhone("0032489656963")
                .createPersonDetails();

        personDetailsRepository.save(personDetails);

        Assertions.assertThat(personDetails.getPersonDetailsId()).isNotNull();
    }

}