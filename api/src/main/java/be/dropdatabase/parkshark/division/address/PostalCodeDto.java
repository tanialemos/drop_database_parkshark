package be.dropdatabase.parkshark.division.address;

public class PostalCodeDto {

    private String postalCode;
    private String postalCodeLabel;

    public static PostalCodeDto postalCodeDto(){
        return new PostalCodeDto();
    }

    public PostalCodeDto withPostalCode(String postalCode){
        this.postalCode = postalCode;
        return this;
    }

    public PostalCodeDto withPostalCodeLabel(String postalCodeLabel){
        this.postalCodeLabel = postalCodeLabel;
      return this;
   }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPostalCodeLabel() {
        return postalCodeLabel;
    }
}
