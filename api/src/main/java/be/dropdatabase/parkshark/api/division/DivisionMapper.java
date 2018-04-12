package be.dropdatabase.parkshark.api.division;

import be.dropdatabase.parkshark.domain.division.Division;

import javax.inject.Named;

@Named
public class DivisionMapper {

    public Division divisionDtoTodivisionObject(DivisionDto divisionDto){
        return new Division.DivisionBuilder()
                .withDivisionName(divisionDto.divisionName)
                .withOriginalnName(divisionDto.originalName)
                .withDirector(divisionDto.director)
                .build();
    }

    public DivisionDto divisionTodivisionDtoWithoutParentCompanyName(Division division){
        return new DivisionDto()
                .withDivisionName(division.getDivisionName())
                .withOriginalName(division.getOriginalName())
                .withDirector(division.getDirector());
    }
    public DivisionDto divisionTodivisionDtoWithParentCompanyName(Division aDivision){
        return new DivisionDto()
                .withDivisionName(aDivision.getDivisionName())
                .withOriginalName(aDivision.getOriginalName())
                .withDirector(aDivision.getDirector())
                .withParentDivisionName(aDivision.getDivisionName());
    }


}
