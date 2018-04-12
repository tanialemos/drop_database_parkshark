package be.dropdatabase.parkshark.division.address;

public class AddressDto {

    private String streetName;
    private String streetNumber;
    private PostalCodeDto postalCode;

    public static AddressDto addressDto(){
        return new AddressDto();
    }

    public AddressDto withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AddressDto withStreetNumber(String streetNumber){
        this.streetNumber = streetNumber;
        return this;
    }

    public AddressDto withPostalCodeDto(PostalCodeDto postalCodeDto){
        this.postalCode = postalCodeDto;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public PostalCodeDto getPostalCode() {
        return postalCode;
    }
}
