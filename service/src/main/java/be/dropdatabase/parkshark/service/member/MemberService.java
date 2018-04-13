package be.dropdatabase.parkshark.service.member;

import be.dropdatabase.parkshark.domain.licenseplate.LicensePlate;
import be.dropdatabase.parkshark.domain.member.Member;
import be.dropdatabase.parkshark.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member saveMemberAndLicensePlate(Member member, LicensePlate licensePlate){
        return memberRepository.save(member, licensePlate);
    }

}
