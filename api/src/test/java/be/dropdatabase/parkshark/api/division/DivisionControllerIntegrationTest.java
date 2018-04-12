package be.dropdatabase.parkshark.division;

import be.dropdatabase.parkshark.division.division.DivisionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static be.dropdatabase.parkshark.division.division.DivisionDto.DivisionDto;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DivisionControllerIntegrationTest {

    @LocalServerPort
    private int port;


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
}
