package be.dropdatabase.parkshark.service.member;

import be.dropdatabase.parkshark.domain.address.Address;
import be.dropdatabase.parkshark.domain.address.PostalCode;
import be.dropdatabase.parkshark.domain.licenseplate.LicensePlate;
import be.dropdatabase.parkshark.domain.member.Member;
import be.dropdatabase.parkshark.domain.member.MemberRepository;
import be.dropdatabase.parkshark.domain.persondetails.PersonDetails;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void saveMemberAndLicensePlate_willSaveMemberToDatabase() {
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

        when(memberService.saveMemberAndLicensePlate(member, licensePlate)).thenReturn(member);

        Assertions.assertThat(memberService.saveMemberAndLicensePlate(member, licensePlate)).isEqualTo(member);
    }
}