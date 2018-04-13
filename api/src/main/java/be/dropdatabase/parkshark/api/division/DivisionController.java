package be.dropdatabase.parkshark.api.division;


import be.dropdatabase.parkshark.domain.division.Division;
import be.dropdatabase.parkshark.service.division.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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
                    .toDomain(division));
            return divisionMapper.toDto(division1);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDto> getAllDivisions(){
        List<Division> divisions = divisionService.getAllDivisions();
        return divisions
                .stream()
                .map(x->divisionMapper.toDto(x))
                .collect(Collectors.toList());
    }
}
