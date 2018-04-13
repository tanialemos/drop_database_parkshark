package be.dropdatabase.parkshark.service.licenseplate;

import be.dropdatabase.parkshark.domain.licenseplate.LicensePlate;
import be.dropdatabase.parkshark.domain.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LicensePlateService {

    private MemberRepository memberRepository;

    @Autowired
    public LicensePlateService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
