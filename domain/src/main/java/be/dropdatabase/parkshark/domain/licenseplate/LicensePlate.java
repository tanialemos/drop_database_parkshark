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

    public LicensePlate(String licensePlateNumber, String issuingCountry) {
        this.licensePlateNumber = licensePlateNumber;
        this.issuingCountry = issuingCountry;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }
}
