package be.dropdatabase.parkshark.service.division;


import be.dropdatabase.parkshark.domain.division.Division;
import be.dropdatabase.parkshark.domain.division.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class DivisionService {

    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division createDivision(Division division) {
        if (isADivisionFieldNull(division)) {
            throw new IllegalArgumentException("All fields must be set!");
        }

        divisionRepository.createDivision(division);
        return division;
    }

    public boolean isADivisionFieldNull(Division division) {
        return division.getDivisionName() == null
                || division.getOriginalName() == null
                || division.getDirector() == null;
    }


    public List<Division> getAllDivisions() {
        return divisionRepository.getAllDivisions();
    }

    public Division findById(long parentDivisionId) {
        return divisionRepository.findById(parentDivisionId);
    }
}
