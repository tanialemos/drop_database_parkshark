package be.dropdatabase.parkshark.api;

import be.dropdatabase.parkshark.domain.division.DivisionRepository;
import org.assertj.core.api.Assertions;

import be.dropdatabase.parkshark.api.division.DivisionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static be.dropdatabase.parkshark.api.division.DivisionDto.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DivisionControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    public void createDivision() {
        DivisionDto divisionDto = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "divisions"),
                        DivisionDto().withDivisionName("ho").withOriginalName("hey").withDirector("mr. pink"),
                        DivisionDto.class);

        assertThat(divisionDto.divisionId).isNotNull();
        assertThat(divisionDto.divisionName).isEqualTo("ho");
        assertThat(divisionDto.originalName).isEqualTo("hey");
        assertThat(divisionDto.director).isEqualTo("mr. pink");
    }


    @Test
    public void getAllDivisions() {
        DivisionDto divisionDto = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "divisions"),
                        DivisionDto().withDivisionName("ho").withOriginalName("hey").withDirector("mr. pink"),
                        DivisionDto.class);

        DivisionDto divisionDto2 = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "divisions"),
                        DivisionDto().withDivisionName("hey").withOriginalName("ho").withDirector("mr. grey"),
                        DivisionDto.class);

        DivisionDto[] divisions = new TestRestTemplate()
                .getForObject(String.format("http://localhost:%s/%s", port, "divisions"),DivisionDto[].class);

        Assertions.assertThat(divisions).hasSize(2);
        Assertions.assertThat(divisions).extracting("divisionName").contains("ho","hey");
        Assertions.assertThat(divisions).extracting("originalName").contains("ho","hey");
        Assertions.assertThat(divisions).extracting("director").contains("mr. pink","mr. grey");

    }
}
