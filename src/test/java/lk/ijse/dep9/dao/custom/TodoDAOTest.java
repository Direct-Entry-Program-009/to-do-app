package lk.ijse.dep9.dao.custom;

import lk.ijse.dep9.dao.DAOFactory;
import lk.ijse.dep9.dao.DAOTypes;
import lk.ijse.dep9.entity.Todo;
import lk.ijse.dep9.util.ConnectionUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoDAOTest {

    private Connection connection;
    private TodoDAO todoDAO;

    @BeforeEach
    void setUp() throws SQLException, URISyntaxException, IOException {
        connection = DriverManager.getConnection("jdbc:h2:mem:");
        String dbScript = new String(getClass().getResourceAsStream
                ("/db-script.sql").readAllBytes());
        connection.createStatement().execute(dbScript);
        todoDAO = DAOFactory.getInstance().getDAO(connection, DAOTypes.TODO);
    }

    @AfterEach
    void tearDown() throws SQLException {
        connection.close();
    }

    @Test
    void count() {
        long count = todoDAO.count();
        assertEquals(0, count);
    }

    @Test
    void existsById() {
    }

    @Test
    void findAll() {
        List<Todo> all = todoDAO.findAll();
        assertEquals(2,all.size());
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
        todoDAO.deleteAll();
        long count = todoDAO.count();
        assertEquals(0, count);
    }
}