package be.dropdatabase.parkshark.division.member;

import be.dropdatabase.parkshark.division.licenseplate.LicensePlate;
import be.dropdatabase.parkshark.division.persondetails.PersonDetails;

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



}
