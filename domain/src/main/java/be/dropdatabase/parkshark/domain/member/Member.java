package be.dropdatabase.parkshark.domain.member;


import be.dropdatabase.parkshark.domain.licenseplate.LicensePlate;
import be.dropdatabase.parkshark.domain.persondetails.PersonDetails;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "MEMBERS")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBERS_SEQ")
    @SequenceGenerator(name = "MEMBERS_SEQ", sequenceName = "MEMBERS_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "MEMBER_ID")
    private long memberId;
    @OneToOne
    @JoinColumn(name = "PERSON_DETAILS_ID")
    private PersonDetails personDetails;
    @Embedded
    private LicensePlate licensePlate;
    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    public Member() {
    }

    private Member(long memberId, PersonDetails personDetails, LicensePlate licensePlate, LocalDateTime registrationDate) {
        this.memberId = memberId;
        this.personDetails = personDetails;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
    }

    public long getMemberId() {
        return memberId;
    }

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public static class MemberBuilder {
        private long memberId;
        private PersonDetails personDetails;
        private LicensePlate licensePlate;
        private LocalDateTime registrationDate;

        public static MemberBuilder memberBuilder() {
            return new MemberBuilder();
        }


        public MemberBuilder withMemberId(long memberId) {
            this.memberId = memberId;
            return this;
        }

        public MemberBuilder withPersonDetails(PersonDetails personDetails) {
            this.personDetails = personDetails;
            return this;
        }

        public MemberBuilder withLicensePlate(LicensePlate licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public MemberBuilder withRegistrationDate(LocalDateTime registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Member createMember() {
            return new Member(memberId, personDetails, licensePlate, registrationDate);
        }
    }
}
