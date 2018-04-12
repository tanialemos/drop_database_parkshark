package be.dropdatabase.parkshark.division.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService {

    private AddressRepository addressRepository;
    private PostalCodeRepository postalCodeRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, PostalCodeRepository postalCodeRepository) {
        this.addressRepository = addressRepository;
        this.postalCodeRepository = postalCodeRepository;
    }

    public Address saveAddress(Address address){
        postalCodeRepository.save(address.getPostalCode());
        return addressRepository.save(address);
    }

}
