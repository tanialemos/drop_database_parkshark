package be.dropdatabase.parkshark.domain.licenseplate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LicensePlate {

    @Column(name = "LICENSE_PLATE_NUMBER")
    private String licensePlateNumber;
    @Column(name = "ISSUING_COUNTRY")
    private String issuingCountry;

    public LicensePlate() {}

    private LicensePlate(String licensePlateNumber, String issuingCountry) {
        this.licensePlateNumber = licensePlateNumber;
        this.issuingCountry = issuingCountry;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public static class LicensePlateBuilder {
        private String licensePlateNumber;
        private String issuingCountry;

        public static LicensePlateBuilder licensePlateBuilder(){
            return new LicensePlateBuilder();
        }

        public LicensePlateBuilder withLicensePlateNumber(String licensePlateNumber) {
            this.licensePlateNumber = licensePlateNumber;
            return this;
        }

        public LicensePlateBuilder withIssuingCountry(String issuingCountry) {
            this.issuingCountry = issuingCountry;
            return this;
        }

        public LicensePlate createLicensePlate() {
            return new LicensePlate(licensePlateNumber, issuingCountry);
        }
    }
}
