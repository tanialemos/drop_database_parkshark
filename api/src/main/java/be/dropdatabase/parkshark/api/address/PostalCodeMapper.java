package be.dropdatabase.parkshark.api.address;

import be.dropdatabase.parkshark.domain.address.PostalCode;

import static be.dropdatabase.parkshark.domain.address.PostalCode.PostalCodeBuilder.buildPostalCode;

public class PostalCodeMapper {

    public PostalCodeDto mapToDto(PostalCode postalCode){
        return PostalCodeDto.postalCodeDto()
                .withPostalCode(postalCode.getPostalCode())
                .withPostalCodeLabel(postalCode.getPostalCodeLabel());
    }

    public PostalCode mapToDomain(PostalCodeDto postalCodeDto){
        return buildPostalCode()
                .withPostalCode(postalCodeDto.getPostalCode())
                .withPostalCodeLabel(postalCodeDto.getPostalCodeLabel())
                .createPostalCode();
    }

}
