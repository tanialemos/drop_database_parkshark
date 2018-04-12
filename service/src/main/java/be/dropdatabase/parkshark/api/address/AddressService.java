package be.dropdatabase.parkshark.api.address;

import be.dropdatabase.parkshark.domain.address.Address;
import be.dropdatabase.parkshark.domain.address.AddressRepository;
import be.dropdatabase.parkshark.domain.address.PostalCodeRepository;
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
        return addressRepository.save(address);
    }

}
