package be.dropdatabase.parkshark.api.address;

import be.dropdatabase.parkshark.domain.address.Address;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class AddressMapper {

    @Autowired
    private PostalCodeMapper postalCodeMapper;

    public AddressDto mapToDto(Address address){
        return new AddressDto()
                .withStreetName(address.getStreetName())
                .withStreetNumber(address.getStreetNumber())
                .withPostalCodeDto(postalCodeMapper.mapToDto(address.getPostalCode()));
    }

    public Address mapToDomain(AddressDto addressDto){
        return new Address.AddressBuilder()
                .withStreetName(addressDto.getStreetName())
                .withStreetNumber(addressDto.getStreetNumber())
                .withPostalCode(postalCodeMapper.mapToDomain(addressDto.getPostalCode()))
                .createAddress();
    }

}
