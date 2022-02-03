import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInfoTest {

    UserInfo userInfo;

    @BeforeEach
    void setUp() {

        userInfo = new UserInfo("1","Oliver", "Hempel");
        List userList = new List();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void seeUserNames() {

        setUp();

        String expected = "Oliver";
        String actual = userInfo.getName();

        assertEquals(expected,actual);
    }

    @Test
    void seeUserDetails()   {

        setUp();
        String expected = "Hempel";
        String actual = userInfo.getInfo();

        assertEquals(expected, actual);
    }

    @Test
    void changeOwnInfo()    {

        setUp();
        
        userInfo.setInfo("Foo");

        String expected = "Foo";
        String actual = userInfo.getInfo();

        assertEquals(expected, actual);
    }


}