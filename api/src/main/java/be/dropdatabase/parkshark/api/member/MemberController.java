package be.dropdatabase.parkshark.api.member;

import be.dropdatabase.parkshark.api.licenseplate.LicensePlateDto;
import be.dropdatabase.parkshark.api.licenseplate.LicensePlateMapper;
import be.dropdatabase.parkshark.domain.member.Member;
import be.dropdatabase.parkshark.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/member")
public class MemberController {

    private MemberService memberService;
    private MemberMapper memberMapper;
    private LicensePlateMapper licensePlateMapper;

    @Autowired
    public MemberController(MemberService memberService, MemberMapper memberMapper, LicensePlateMapper licensePlateMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
        this.licensePlateMapper = licensePlateMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto createMember(MemberDto memberDto){
        Member member = memberService.saveMemberAndLicensePlate(memberMapper.mapToDomain(memberDto),licensePlateMapper.mapToDomain(memberDto.getLicensePlate()));
        return memberMapper.mapToDto(member);
    }
}
