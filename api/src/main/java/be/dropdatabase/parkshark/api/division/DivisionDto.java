package be.dropdatabase.parkshark.division.division;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DivisionDto {

    public long divisionId;
    public String divisionName;
    public String originalName;
    public String director;
    public String parentDivisionName;


    public static DivisionDto DivisionDto(){
        return new DivisionDto();
    }

    public DivisionDto withDivisionName(String divisionName){
        this.divisionName = divisionName;
        return this;
    }

    public DivisionDto withId(long divisionId){
        this.divisionId = divisionId;
        return this;
    }
    public DivisionDto withOriginalName(String originalName){
        this.originalName = originalName;
        return this;
    }
    public DivisionDto withDirector(String director){
        this.director = director;
        return this;
    }
    public DivisionDto withParentDivisionName(String parentDivisionName){
        this.parentDivisionName = parentDivisionName;
        return this;
    }
}
