package be.dropdatabase.parkshark.domain.division;

import javax.persistence.*;

@Entity
@Table(name = "DIVISIONS")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIVISIONS_SEQ")
    @SequenceGenerator(name = "DIVISIONS_SEQ", sequenceName = "DIVISIONS_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "DIVISION_ID")
    private long divisionId;
    @Column(name="DIVISION_NAME")
    private String divisionName;
    @Column(name = "ORIGINAL_NAME")
    private String originalName;
    @Column(name = "DIRECTOR")
    private String director;
    @Column(name = "PARENT_DIVISION_ID")
    private Division parentDivision;

    public Division() {
    }
    public Division(String divisionName, String originalName, String director, Division parentDivision) {
        this.divisionName = divisionName;
        this.originalName = originalName;
        this.director = director;
        this.parentDivision = parentDivision;
    }
}
