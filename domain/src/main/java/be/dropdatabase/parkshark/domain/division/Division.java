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
    @ManyToOne
    @JoinColumn(name = "PARENT_DIVISION_ID")
    private Division parentDivision;

    public Division() {
    }
    private Division(DivisionBuilder divisionBuilder) {
        this.divisionName = divisionBuilder.divisionName;
        this.originalName = divisionBuilder.originalName;
        this.director = divisionBuilder.director;
        this.parentDivision = divisionBuilder.parentDivision;
    }


    public Division getParentDivision() {
        return parentDivision;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }

    public static class DivisionBuilder{
        private String divisionName;
        private String originalName;
        private String director;
        private  Division parentDivision;

        public DivisionBuilder withDivisionName(String divisionName){
            this.divisionName = divisionName;
            return this;
        }

        public DivisionBuilder withOriginalName(String originalName){
            this.originalName = originalName;
            return this;
        }
        public DivisionBuilder withDirector(String director){
            this.director = director;
            return this;
        }
        public DivisionBuilder withParentDivision(Division division){
            this.parentDivision=division;
            return this;
        }
        public Division build(){
            return new Division(this);
        }
    }

    public long getDivisionId() {
        return divisionId;
    }

    @Override
    public String toString() {
        return "Division{" +
                "divisionId=" + divisionId +
                ", divisionName='" + divisionName + '\'' +
                ", originalName='" + originalName + '\'' +
                ", director='" + director + '\'' +
                ", parentDivision=" + parentDivision +
                '}';
    }
}
