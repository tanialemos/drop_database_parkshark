package be.dropdatabase.parkshark.service.address;

import be.dropdatabase.parkshark.domain.address.Address;
import be.dropdatabase.parkshark.domain.address.AddressRepository;
import be.dropdatabase.parkshark.domain.address.PostalCode;
import be.dropdatabase.parkshark.domain.address.PostalCodeRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;
    @Mock
    private PostalCodeRepository postalCodeRepository;

    @InjectMocks
    private AddressService addressService;

    @Test
    public void saveAddress_happyPath() {
        Address address = Address.AddressBuilder.buildAddress()
                .withStreetName("Rue du désespoir")
                .withStreetNumber("5")
                .withPostalCode(new PostalCode("1090", "Jette"))
                .createAddress();

        when(addressRepository.save(address)).thenReturn(address);

        Assertions.assertThat(addressService.saveAddress(address)).isEqualTo(address);
    }
}