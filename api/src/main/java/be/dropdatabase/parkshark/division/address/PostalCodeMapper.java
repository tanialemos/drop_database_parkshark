package be.dropdatabase.parkshark.division.address;

import static be.dropdatabase.parkshark.division.address.PostalCode.PostalCodeBuilder.buildPostalCode;

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
