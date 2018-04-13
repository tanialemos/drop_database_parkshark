package be.dropdatabase.parkshark.api.persondetails;

import be.dropdatabase.parkshark.api.address.AddressDto;

public class PersonDetailsDto {

    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
    private String mobilePhone;
    private String fixedPhone;

    public static PersonDetailsDto personDetailsDto(){
        return new PersonDetailsDto();
    }

    public PersonDetailsDto withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public PersonDetailsDto withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public PersonDetailsDto withEmail(String email){
        this.email = email;
        return this;
    }

    public PersonDetailsDto withAddressDto(AddressDto addressDto){
        this.address = addressDto;
        return this;
    }

    public PersonDetailsDto withMobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
        return this;
    }

    public PersonDetailsDto withFixedPhone(String fixedPhone){
        this.fixedPhone = fixedPhone;
        return this;
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

    public AddressDto getAddress() {
        return address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }
}
