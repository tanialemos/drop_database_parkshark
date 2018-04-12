package be.dropdatabase.parkshark.division;

import be.dropdatabase.parkshark.division.division.DivisionService;
import be.dropdatabase.parkshark.division.division.Division;
import be.dropdatabase.parkshark.division.division.DivisionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DivisionServiceTest {

    @Mock
    private DivisionRepository divisionRepository;

    @InjectMocks
    private DivisionService divisionService;

    @Test
    public  void createDivision_whenANullValueIsProvided_throwsException(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->divisionService.createDivision(new Division
                        .DivisionBuilder()
                        .withDivisionName("hey").withDirector("ho")
                        .build()));
    }

    @Test
    public void createDivision_whenAllFielAreSetExceptedParentDivision_createADivision(){
        Division division = new Division.DivisionBuilder().withDivisionName("hey")
                .withDirector("ho").withOriginalName("hoho").build();
        when(divisionRepository.createDivision(division)).thenReturn(division);

        assertThat(divisionService.createDivision(division)).isEqualTo(division);
    }

    @Test
    public void getAllDivisions_whenCalled_callGetAllDivisionsInRepository(){
        divisionService.getAllDivisions();
        verify(divisionRepository,times(1)).getAllDivisions();
    }

}