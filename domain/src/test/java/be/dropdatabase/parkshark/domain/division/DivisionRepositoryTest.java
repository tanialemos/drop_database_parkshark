package be.dropdatabase.parkshark.domain.division;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {DivisionRepository.class})
@EnableAutoConfiguration()
public class DivisionRepositoryTest {

    @Autowired
    private DivisionRepository divisionRepository;


    @Test
    public void saveDivision() {
        Division savedDivision = divisionRepository.createDivision(new Division());
        System.out.println(savedDivision.getDivisionId());
        Assertions.assertThat(savedDivision.getDivisionId()).isNotNull();
    }
    @Test
    public void getByID() {
        Division savedDivision = divisionRepository.createDivision(new Division("Pomme","Poire","John Malkovik", null));
        System.out.println(savedDivision.getDivisionId());
        Division searchecDivision = divisionRepository.findByName("Pomme");
        Assertions.assertThat(savedDivision).isEqualToComparingFieldByFieldRecursively(searchecDivision);
        System.out.println(searchecDivision.toString());
    }


}
