package be.dropdatabase.parkshark.api.division;

import be.dropdatabase.parkshark.domain.division.Division;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class DivisionMapperTest {


    private DivisionMapper divisionMapper;

    @Before
    public void instantiateMapper() {
        divisionMapper = new DivisionMapper();
    }

    @Test
    public void toDto() {
        //given
        Division division = new Division.DivisionBuilder()
                .withDivisionName("Division Name")
                .withOriginalName("Original Compaby Name")
                .withDirector("John Doe")
                .withParentDivision(null)
                .build();
        //when
        DivisionDto divisionDto = divisionMapper.toDto(division);
        //that
        Assertions.assertThat(divisionDto.getDivisionName()).isEqualTo("Division Name");
        Assertions.assertThat(divisionDto.getOriginalName()).isEqualTo("Original Compaby Name");
        Assertions.assertThat(divisionDto.getDirector()).isEqualTo("John Doe");
        Assertions.assertThat(divisionDto.getParentDivisionId()).isEqualTo(null);
    }
}