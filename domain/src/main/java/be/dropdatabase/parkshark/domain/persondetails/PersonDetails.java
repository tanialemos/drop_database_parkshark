package be.dropdatabase.parkshark.domain.persondetails;

import be.dropdatabase.parkshark.domain.address.Address;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_DETAILS")
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_DETAILS_SEQ")
    @SequenceGenerator(name = "PERSON_DETAILS_SEQ", sequenceName = "PERSON_DETAILS_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "PERSON_DETAILS_ID")
    private long personDetailsId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;
    @Column(name = "FIXED_PHONE")
    private String fixedPhone;

    public PersonDetails(){}

    private PersonDetails(long personDetailsId, String firstName, String lastName, String email, Address address, String mobilePhone, String fixedPhone) {
        this.personDetailsId = personDetailsId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.mobilePhone = mobilePhone;
        this.fixedPhone = fixedPhone;
    }

    public long getPersonDetailsId() {
        return personDetailsId;
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

    public String getFixedPhone() {
        return fixedPhone;
    }

    public static class PersonDetailsBuilder {
        private long personDetailsId;
        private String firstName;
        private String lastName;
        private String email;
        private Address address;
        private String mobilePhone;
        private String fixedPhone;

        public static PersonDetailsBuilder personDetailsBuilder() {
            return new PersonDetailsBuilder();
        }


        public PersonDetailsBuilder setPersonDetailsId(long personDetailsId) {
            this.personDetailsId = personDetailsId;
            return this;
        }

        public PersonDetailsBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonDetailsBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonDetailsBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonDetailsBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public PersonDetailsBuilder setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public PersonDetailsBuilder setFixedPhone(String fixedPhone) {
            this.fixedPhone = fixedPhone;
            return this;
        }

        public PersonDetails createPersonDetails() {
            return new PersonDetails(personDetailsId, firstName, lastName, email, address, mobilePhone, fixedPhone);
        }
    }
}
