package be.dropdatabase.parkshark.domain.member;

import be.dropdatabase.parkshark.domain.address.Address;
import be.dropdatabase.parkshark.domain.address.PostalCode;
import be.dropdatabase.parkshark.domain.licenseplate.LicensePlate;
import be.dropdatabase.parkshark.domain.persondetails.PersonDetails;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {MemberRepository.class})
@EntityScan(basePackages = "be.dropdatabase.parkshark.domain")
@EnableAutoConfiguration()
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    public void save_willSaveMemberToDatabase() {
        LicensePlate licensePlate = LicensePlate.LicensePlateBuilder.licensePlateBuilder()
                .withLicensePlateNumber("B-456-598")
                .withIssuingCountry("Belgium")
                .createLicensePlate();

        Address address = Address.AddressBuilder.buildAddress()
                .withStreetName("Rue de la misère")
                .withStreetNumber("13")
                .withPostalCode(new PostalCode("8000", "Liège"))
                .createAddress();

        PersonDetails details = PersonDetails.PersonDetailsBuilder.personDetailsBuilder()
                .setFirstName("Luke")
                .setLastName("Skywalker")
                .setAddress(address)
                .setEmail("luke.skywalker@gmail.com")
                .setFixedPhone("00322256558")
                .setMobilePhone("0032498585623")
                .createPersonDetails();

        Member member = Member.MemberBuilder.memberBuilder()
                .withPersonDetails(details)
                .withLicensePlate(licensePlate)
                .withRegistrationDate(LocalDateTime.of(2018,2,15,8,30))
                .createMember();

        memberRepository.save(member, licensePlate);

        Assertions.assertThat(member.getMemberId()).isNotNull();
    }

    @Test
    public void findById() {
    }
}