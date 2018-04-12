package be.dropdatabase.parkshark.division.division;

import be.dropdatabase.parkshark.utilities.exceptions.ParkSharkIllegalFieldFoundException;
import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
}
