package be.dropdatabase.parkshark.api.member;

import be.dropdatabase.parkshark.api.licenseplate.LicensePlateDto;
import be.dropdatabase.parkshark.domain.member.Member;

import java.time.LocalDateTime;

public class MemberDto {

    private LicensePlateDto licensePlate;
    private String registrationDate;

    public static MemberDto memberDto(){
        return new MemberDto();
    }

    public MemberDto withLicensePlate(LicensePlateDto licensePlateDto){
        this.licensePlate = licensePlateDto;
        return this;
    }

    public MemberDto withRegistrationDate(String registrationDate){
        this.registrationDate = registrationDate;
        return this;
    }

    public LicensePlateDto getLicensePlate() {
        return licensePlate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }
}
