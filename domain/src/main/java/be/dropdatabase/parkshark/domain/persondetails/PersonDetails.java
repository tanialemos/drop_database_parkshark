package be.dropdatabase.parkshark.domain.persondetails;

public class PersonDetails {

    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String mobilePhone;
    private String landPhone;

    public PersonDetails(String firstName, String lastName, String email, Address address, String mobilePhone, String landPhone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.landPhone = landPhone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getLandPhone() {
        return landPhone;
    }
}
