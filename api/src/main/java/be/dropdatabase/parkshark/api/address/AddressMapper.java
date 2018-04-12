package be.dropdatabase.parkshark.api.address;

import be.dropdatabase.parkshark.domain.address.Address;
import be.dropdatabase.parkshark.domain.address.PostalCode;
import org.springframework.beans.factory.annotation.Autowired;

import static be.dropdatabase.parkshark.domain.address.Address.AddressBuilder.buildAddress;

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
        return buildAddress()
                .withStreetName(addressDto.getStreetName())
                .withStreetNumber(addressDto.getStreetNumber())
                .withPostalCode(postalCodeMapper.mapToDomain(addressDto.getPostalCode()))
                .createAddress();
    }

}
