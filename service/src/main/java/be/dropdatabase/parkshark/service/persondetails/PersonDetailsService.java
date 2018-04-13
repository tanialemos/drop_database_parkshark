package be.dropdatabase.parkshark.service.persondetails;

import be.dropdatabase.parkshark.domain.address.AddressRepository;
import be.dropdatabase.parkshark.domain.address.PostalCodeRepository;
import be.dropdatabase.parkshark.domain.persondetails.PersonDetails;
import be.dropdatabase.parkshark.domain.persondetails.PersonDetailsRepository;
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
