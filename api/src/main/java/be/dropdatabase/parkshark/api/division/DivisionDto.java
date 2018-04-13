package be.dropdatabase.parkshark.api.division;

public class DivisionDto {

    public Long divisionId;
    public String divisionName;
    public String originalName;
    public String director;
    public Long parentDivisionId;

    public Long getDivisionId() {
        return divisionId;
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

    public static DivisionDto DivisionDto() {
        return new DivisionDto();
    }

    public Long getParentDivisionId() {
        return parentDivisionId;
    }

    public DivisionDto withDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public DivisionDto withId(Long divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    public DivisionDto withOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public DivisionDto withDirector(String director) {
        this.director = director;
        return this;
    }

    public DivisionDto withParentDivisionId(Long parentDivisionId) {
        this.parentDivisionId = parentDivisionId;
        return this;
    }
}
