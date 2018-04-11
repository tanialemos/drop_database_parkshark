package be.dropdatabase.parkshark.domain.address;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESSES")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESSES_SEQ")
    @SequenceGenerator(name = "ADDRESSES_SEQ", sequenceName = "ADDRESSES_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "ADDRESS_ID")
    private long addressId;
    @Column(name = "STREET_NAME")
    private String streetName;
    @Column(name = "STREET_NUMBER")
    private String streetNumber;
    @ManyToOne
    @JoinColumn(name = "POSTALCODE_ID")
    private PostalCode postalCode;

    public Address() {
    }

    public Address(String streetName, String streetNumber, PostalCode postalCode) {
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
