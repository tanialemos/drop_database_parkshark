package be.dropdatabase.parkshark.api.division;

import be.dropdatabase.parkshark.domain.division.Division;
import be.dropdatabase.parkshark.service.division.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class DivisionMapper {

    @Autowired
    private DivisionService divisionService;

    public Division toDomain(DivisionDto divisionDto) {
        Division parentDivision = null;
        if (divisionDto.getParentDivisionId() != null) {
            //todo throw proper exception with GlobalControllerAdvice
            parentDivision = divisionService.findById(divisionDto.parentDivisionId);
        }
        return new Division.DivisionBuilder()
                .withDivisionId(divisionDto.getDivisionId())
                .withDivisionName(divisionDto.getDivisionName())
                .withOriginalName(divisionDto.getOriginalName())
                .withDirector(divisionDto.getDirector())
                .withParentDivision(parentDivision)
                .build();
    }

    public DivisionDto toDto(Division aDivision) {
        Long parentDivisionId = null;
        if (aDivision.getParentDivision() != null) {
            parentDivisionId = aDivision.getParentDivision().getDivisionId();
        }
        return new DivisionDto()
                .withId(aDivision.getDivisionId())
                .withDivisionName(aDivision.getDivisionName())
                .withOriginalName(aDivision.getOriginalName())
                .withDirector(aDivision.getDirector())
                .withParentDivisionId(parentDivisionId);
    }


}
