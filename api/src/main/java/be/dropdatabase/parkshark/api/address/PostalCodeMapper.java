package be.dropdatabase.parkshark.api.address;

import be.dropdatabase.parkshark.domain.address.PostalCode;

public class PostalCodeMapper {

    public PostalCodeDto mapToDto(PostalCode postalCode){
        return new PostalCodeDto(
                postalCode.getPostalCode(),
                postalCode.getPostalCodeLabel()
        );
    }

    public PostalCode mapToDomain(PostalCodeDto postalCodeDto){
        return new PostalCode(
                postalCodeDto.getPostalCode(),
                postalCodeDto.getPostalCode()
        );
    }

}
