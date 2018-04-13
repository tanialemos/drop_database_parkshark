package be.dropdatabase.parkshark.domain.address;

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

    public PostalCode(String postalCode, String postalCodeLabel) {
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

    public static class PostalCodeBuilder {
        private String postalCode;
        private String postalCodeLabel;

        public static PostalCodeBuilder buildPostalCode(){
            return new PostalCodeBuilder();
        }

        public PostalCodeBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public PostalCodeBuilder withPostalCodeLabel(String postalCodeLabel) {
            this.postalCodeLabel = postalCodeLabel;
            return this;
        }

        public PostalCode createPostalCode() {
            return new PostalCode(postalCode, postalCodeLabel);
        }
    }
}
