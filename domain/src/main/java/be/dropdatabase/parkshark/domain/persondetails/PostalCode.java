package be.dropdatabase.parkshark.domain.persondetails;

public class PostalCode {

    private String postalCode;
    private String label;

    public PostalCode(String postalCode, String label) {
        this.postalCode = postalCode;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
