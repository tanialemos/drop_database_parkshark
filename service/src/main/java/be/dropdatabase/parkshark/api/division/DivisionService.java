package be.dropdatabase.parkshark.api.division;

import be.dropdatabase.parkshark.domain.division.Division;
import be.dropdatabase.parkshark.domain.division.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class DivisionService {

    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository){
        this.divisionRepository = divisionRepository;
    }

    public Division createDivision(Division division){
        if(isADivisionFieldNull(division)){
            throw new IllegalArgumentException("All field must be set!");
        }
        return divisionRepository.createDivision(division);
    }

    public boolean isADivisionFieldNull(Division division){
        return division.getDivisionName()==null
                || division.getOriginalName()==null
                || division.getDirector()==null
                || division.getDivisionName()==null;
    }



}
