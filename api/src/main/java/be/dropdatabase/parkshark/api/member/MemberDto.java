package be.dropdatabase.parkshark.api.member;

import be.dropdatabase.parkshark.api.licenseplate.LicensePlateDto;
import be.dropdatabase.parkshark.domain.member.Member;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class MemberDto {

    private LicensePlateDto licensePlate;
    @JsonFormat(pattern = "YYYY-MM-DD")
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private LocalDateTime registrationDate;

    public static MemberDto memberDto(){
        return new MemberDto();
    }

    public MemberDto withLicensePlateDto(LicensePlateDto licensePlateDto){
        this.licensePlate = licensePlateDto;
        return this;
    }

    public MemberDto withRegistrationDate(LocalDateTime registrationDate){
        this.registrationDate = registrationDate;
        return this;
    }

    public LicensePlateDto getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
