package be.dropdatabase.parkshark.api.member;

import be.dropdatabase.parkshark.api.licenseplate.LicensePlateDto;
import be.dropdatabase.parkshark.api.licenseplate.LicensePlateMapper;
import be.dropdatabase.parkshark.domain.member.Member;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberMapper {

    @Autowired
    private LicensePlateMapper licensePlateMapper;

    public MemberDto mapToDto(Member member){
        return MemberDto.memberDto()
                .withLicensePlateDto(licensePlateMapper.mapToDto(member.getLicensePlate()))
                .withRegistrationDate(member.getRegistrationDate());
    }


    public Member mapToDomain(MemberDto memberDto){
        return new Member.MemberBuilder()
                .withLicensePlate(licensePlateMapper.mapToDomain(memberDto.getLicensePlate()))
                .withRegistrationDate(memberDto.getRegistrationDate())
                .createMember();
    }
}
