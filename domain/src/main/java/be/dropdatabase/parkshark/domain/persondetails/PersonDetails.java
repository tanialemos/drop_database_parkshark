package be.dropdatabase.parkshark.domain.persondetails;

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

    public PersonDetails(long personDetailsId, String firstName, String lastName, String email, Address address, String mobilePhone, String fixedPhone) {
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
}
