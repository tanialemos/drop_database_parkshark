package be.dropdatabase.parkshark.division.division;

import be.dropdatabase.parkshark.utilities.exceptions.ParkSharkIllegalFieldFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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
    public DivisionDto createDivision(@RequestBody DivisionDto division) {
            Division division1 = divisionService.createDivision(divisionMapper
                    .divisionDtoTodivisionObject(division));
            return divisionMapper.divisionTodivisionDtoWithoutParentCompanyName(division1);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDto> getAllDivisions(){
        List<Division> divisions = divisionService.getAllDivisions();
        return divisions
                .stream()
                .map(x->divisionMapper.divisionTodivisionDtoWithoutParentCompanyName(x))
                .collect(Collectors.toList());
    }
}
