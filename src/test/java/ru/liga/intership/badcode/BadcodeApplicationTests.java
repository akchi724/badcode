package ru.liga.intership.badcode;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.liga.intership.badcode.service.DataBaseConnector;
import ru.liga.intership.badcode.service.PersonService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BadcodeApplicationTests {
    PersonService pS;
    DataBaseConnector dBC;

    @Before
    public void before() {
        pS = new PersonService();
        dBC = new DataBaseConnector();
    }

    @Test
    public void getImtTest() {
        Assertions.assertThat(pS.getImt(9, 300)).isEqualTo(1.0);
    }
	@Test
	public void getHeightInMetersTest() {
		Assertions.assertThat(pS.getHeightInMeters(100)).isEqualTo(1);
	}
	@Test
	public void getAdultMaleUsersAverageTest() throws SQLException {
		Assertions.assertThat(pS.getAdultMaleUsersAverageBMI(dBC.getExecuteQuery(dBC.getStatement()))).isEqualTo(25.774209960992707);
	}


}

