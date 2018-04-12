package be.dropdatabase.parkshark.division.persondetails;

import be.dropdatabase.parkshark.division.address.AddressRepository;
import be.dropdatabase.parkshark.division.address.PostalCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonDetailsService {

    private PersonDetailsRepository personDetailsRepository;
    private AddressRepository addressRepository;
    private PostalCodeRepository postalCodeRepository;

    @Autowired
    public PersonDetailsService(PersonDetailsRepository personDetailsRepository, AddressRepository addressRepository, PostalCodeRepository postalCodeRepository) {
        this.personDetailsRepository = personDetailsRepository;
        this.addressRepository = addressRepository;
        this.postalCodeRepository = postalCodeRepository;
    }

    public PersonDetails savePersonDetails(PersonDetails personDetails){
        return personDetailsRepository.save(personDetails);
    }
}
