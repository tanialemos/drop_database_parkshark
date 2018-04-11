package be.dropdatabase.parkshark.domain.persondetails;

public class Address {

    private long addressId;
    private String streetName;
    private String streetNumber;
    private PostalCode postalCode;

    public Address(long addressId, String streetName, String streetNumber, PostalCode postalCode) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    public long getAddressId() {
        return addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public PostalCode getPostalCode() {
        return postalCode;
    }
}
