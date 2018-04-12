package be.dropdatabase.parkshark.api.address;

public class PostalCodeDto {

    private String postalCode;
    private String postalCodeLabel;

    public PostalCodeDto(String postalCode, String postalCodeLabel) {
        this.postalCode = postalCode;
        this.postalCodeLabel = postalCodeLabel;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPostalCodeLabel() {
        return postalCodeLabel;
    }
}
