package be.dropdatabase.parkshark.domain.address;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {PostalCodeRepository.class})
@EnableAutoConfiguration()
public class PostalCodeRepositoryTest {

    @Autowired
    private PostalCodeRepository postalCodeRepository;

    @Test
    @Transactional
    public void save_isPersistedToDatabase(){
        PostalCode savedPostalCode = postalCodeRepository.save(new PostalCode());
        Assertions.assertThat(savedPostalCode.getPostalCodeId()).isNotNull();
    }

}