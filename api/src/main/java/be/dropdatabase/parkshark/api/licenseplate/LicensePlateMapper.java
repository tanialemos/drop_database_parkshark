package be.dropdatabase.parkshark.api.licenseplate;

import be.dropdatabase.parkshark.domain.licenseplate.LicensePlate;

import javax.inject.Named;

@Named
public class LicensePlateMapper {

    public LicensePlateDto mapToDto(LicensePlate licensePlate){
        return LicensePlateDto.licensePlateDto()
                .withLicensePlateDto(licensePlate.getLicensePlateNumber())
                .withIssuingCountry(licensePlate.getIssuingCountry());
    }

    public LicensePlate mapToDomain(LicensePlateDto licensePlateDto){
        return new LicensePlate.LicensePlateBuilder()
                .withLicensePlateNumber(licensePlateDto.getLicensePlateNumber())
                .withIssuingCountry(licensePlateDto.getIssuingCoutnry())
                .createLicensePlate();
    }
}
