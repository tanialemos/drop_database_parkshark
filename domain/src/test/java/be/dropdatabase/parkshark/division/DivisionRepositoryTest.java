package be.dropdatabase.parkshark.division;

import be.dropdatabase.parkshark.division.division.Division;
import be.dropdatabase.parkshark.division.division.DivisionRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = {DivisionRepository.class})
@EnableAutoConfiguration()
public class DivisionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DivisionRepository divisionRepository;

    @After
    public void cleanUp() {
      entityManager.getEntityManager().createQuery("delete from Division").executeUpdate();
    }


    @Test
    public void saveDivision() {
        Division savedDivision = divisionRepository.createDivision(new Division.DivisionBuilder()
                .withDivisionName("Pomme")
                .withOriginalnName("Poire")
                .withDirector("John Malkovik")
                .withParentDivision(null).build());
        assertThat(savedDivision.getDivisionId()).isNotNull();
        assertThat(savedDivision.getDivisionName()).isEqualTo("Pomme");
        assertThat(savedDivision.getDirector()).isEqualTo("John Malkovik");
        assertThat(savedDivision.getOriginalName()).isEqualTo("Poire");
    }

    @Test
    public void getByID() {
        Division savedDivision = divisionRepository.createDivision(new Division
                .DivisionBuilder().withDivisionName("Pomme")
                .withOriginalnName("Poire")
                .withDirector("John Malkovik")
                .withParentDivision(null).build());
        System.out.println(savedDivision.getDivisionId());
        Division searchecDivision = divisionRepository.findByName("Pomme");
        assertThat(savedDivision).isEqualToComparingFieldByFieldRecursively(searchecDivision);
        System.out.println(searchecDivision.toString());
    }

    @Test
    public void getAllDivisions() {
        Division division1 = divisionRepository.createDivision(new Division
                .DivisionBuilder().withDivisionName("dude")
                .withOriginalnName("dudy")
                .withDirector("dude1")
                .withParentDivision(null).build());
        Division division2 = divisionRepository.createDivision(new Division
                        .DivisionBuilder().withDivisionName("Pomme")
                        .withOriginalnName("Poire")
                        .withDirector("John Malkovik")
                        .withParentDivision(null).build());

        assertThat(divisionRepository.getAllDivisions())
                .size()
                .isEqualTo(2)
                .returnToIterable()
                .contains(division1,division2);
    }


}
