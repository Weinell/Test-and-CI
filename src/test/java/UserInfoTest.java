import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInfoTest {

    User user;
    Connection con;
    DataMapper dataMapper;

    @BeforeEach
    void setUp() {

        dataMapper = new DataMapper();

        try {
            con = DBconnector.connection();
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5,"Rolighedsvej 3");
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {


        try {
            con = DBconnector.connection();
            String dropTable = "DROP TABLE IF EXISTS startcode_test.usertable";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    void getAllUsers()  {

        List<User> users = dataMapper.getAllUsers();


        assertEquals("Hans",users.get(1).getFname());

    }


    @Test
    void seeUserNames() {



        List<User> users = new ArrayList<>();



        //assertEquals(expected,actual);
    }

    @Test
    void seeUserDetails()   {

        setUp();
        String expected = "poop4211111Hempel";
        //String actual = user.getInfo();

        //assertEquals(expected, actual);
    }

    @Test
    void changeOwnInfo()    {

        setUp();

        //user.setInfo("Foo","42670043", "Fysikvej");


        String expected = "Foo42670043Fysikvej";
        //String actual = user.getInfo();

       // assertEquals(expected, actual);
    }


}