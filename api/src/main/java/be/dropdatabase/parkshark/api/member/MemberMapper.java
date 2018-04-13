package be.dropdatabase.parkshark.api.member;

import be.dropdatabase.parkshark.api.licenseplate.LicensePlateMapper;
import be.dropdatabase.parkshark.domain.member.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
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
