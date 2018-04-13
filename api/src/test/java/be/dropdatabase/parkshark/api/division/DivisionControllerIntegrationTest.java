package be.dropdatabase.parkshark.api.division;

import be.dropdatabase.parkshark.api.Application;
import be.dropdatabase.parkshark.domain.division.DivisionRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static be.dropdatabase.parkshark.api.division.DivisionDto.DivisionDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.SqlConfig.TransactionMode.ISOLATED;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(statements = "delete from divisions", config = @SqlConfig(transactionMode = ISOLATED),
        executionPhase = AFTER_TEST_METHOD)
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
                .getForObject(String.format("http://localhost:%s/%s", port, "divisions"), DivisionDto[].class);

        Assertions.assertThat(divisions).hasSize(2);
        Assertions.assertThat(divisions).extracting("divisionName").contains("ho", "hey");
        Assertions.assertThat(divisions).extracting("originalName").contains("ho", "hey");
        Assertions.assertThat(divisions).extracting("director").contains("mr. pink", "mr. grey");

    }

    @Test
    public void createADivisionWithAParent_HappyPath() {
        // given
        DivisionDto parentDivisionDto = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "divisions"),
                        DivisionDto().withDivisionName("hey").withOriginalName("ho").withDirector("mr. grey"),
                        DivisionDto.class);
        DivisionDto childDivisionDto = new TestRestTemplate()
                .postForObject(String.format("http://localhost:%s/%s", port, "divisions"),
                        DivisionDto().withDivisionName("ho").withOriginalName("hey").withDirector("mr. pink").withParentDivisionId(1L),
                        DivisionDto.class);
        // then
        Assertions.assertThat(childDivisionDto.getParentDivisionId()).isEqualTo(1);

    }
}
