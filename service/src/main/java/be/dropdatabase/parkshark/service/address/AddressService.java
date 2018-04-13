package be.dropdatabase.parkshark.service.address;

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
        postalCodeRepository.save(address.getPostalCode());
        return addressRepository.save(address);
    }

//    public PostalCode findPostalCodeByPostalCode(String postalCode){
//        return entityManager.createQuery("from PostalCode p where postalCode = :postalCode", PostalCode.class)
//                .setParameter("postalCode", postalCode)
//                .getSingleResult();
//    }

}
