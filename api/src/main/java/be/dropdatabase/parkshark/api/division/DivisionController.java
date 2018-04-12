package be.dropdatabase.parkshark.api.division;

import be.dropdatabase.parkshark.domain.division.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/divisions")
public class DivisionController {

    private DivisionService divisionService;
    private DivisionMapper divisionMapper;

    @Autowired
    public DivisionController(DivisionService divisionService, DivisionMapper divisionMapper){
        this.divisionService = divisionService;
        this.divisionMapper = divisionMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDto createDivision(@RequestBody DivisionDto division){
        return divisionMapper.divisionTodivisionDtoWithoutParentCompanyName(divisionService.createDivision(divisionMapper
                .divisionDtoTodivisionObject(division)));
    }
}