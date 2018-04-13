package be.dropdatabase.parkshark.api.licenseplate;

public class LicensePlateDto {

    private String licensePlateNumber;
    private String issuingCoutnry;

    public static LicensePlateDto licensePlateDto(){
        return new LicensePlateDto();
    }

    public LicensePlateDto withLicensePlateDto(String licensePlateNumber){
        this.licensePlateNumber = licensePlateNumber;
        return this;
    }

    public LicensePlateDto withIssuingCountry(String issuingCountry){
        this.issuingCoutnry = issuingCountry;
        return this;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getIssuingCoutnry() {
        return issuingCoutnry;
    }
}
