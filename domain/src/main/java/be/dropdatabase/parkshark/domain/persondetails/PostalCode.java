package be.dropdatabase.parkshark.domain.persondetails;

import javax.persistence.*;

@Entity
@Table(name = "POSTALCODE")
public class PostalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTALCODE_SEQ")
    @SequenceGenerator(name = "POSTALCODE_SEQ", sequenceName = "POSTALCODE_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "POSTALCODE_ID")
    private long postalCodeId;

    @Column(name = "POSTALCODE")
    private String postalCode;

    @Column(name = "POSTALCODE_LABEL")
    private String postalCodeLabel;

    public PostalCode() {
    }

    public PostalCode(long postalCodeId, String postalCode, String postalCodeLabel) {
        this.postalCodeId = postalCodeId;
        this.postalCode = postalCode;
        this.postalCodeLabel = postalCodeLabel;
    }

    public long getPostalCodeId() {
        return postalCodeId;
    }

    public String getPostalCodeLabel() {
        return postalCodeLabel;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
