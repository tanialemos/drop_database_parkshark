package be.dropdatabase.parkshark.division.persondetails;

import be.dropdatabase.parkshark.division.address.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static be.dropdatabase.parkshark.division.persondetails.PersonDetails.PersonDetailsBuilder.personDetailsBuilder;

public class PersonDetailsMapper {

    @Autowired
    private PersonDetailsMapper personDetailsMapper;
    private AddressMapper addressMapper;

    public PersonDetailsDto mapToDto(PersonDetails personDetails){
        return new PersonDetailsDto()
                .withFirstName(personDetails.getFirstName())
                .withLastName(personDetails.getLastName())
                .withEmail(personDetails.getEmail())
                .withAddressDto(addressMapper.mapToDto(personDetails.getAddress()))
                .withFixedPhone(personDetails.getFixedPhone())
                .withMobilePhone(personDetails.getMobilePhone());
    }

    public PersonDetails mapToDomain(PersonDetailsDto personDetailsDto){
        return personDetailsBuilder()
                .setFirstName(personDetailsDto.getFirstName())
                .setLastName(personDetailsDto.getLastName())
                .setEmail(personDetailsDto.getEmail())
                .setAddress(addressMapper.mapToDomain(personDetailsDto.getAddress()))
                .setFixedPhone(personDetailsDto.getFixedPhone())
                .setMobilePhone(personDetailsDto.getMobilePhone())
                .createPersonDetails();

    }
}
