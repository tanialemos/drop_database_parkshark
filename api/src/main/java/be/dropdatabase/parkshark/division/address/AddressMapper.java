package be.dropdatabase.parkshark.division.address;

import org.springframework.beans.factory.annotation.Autowired;

import static be.dropdatabase.parkshark.division.address.Address.AddressBuilder.buildAddress;

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
