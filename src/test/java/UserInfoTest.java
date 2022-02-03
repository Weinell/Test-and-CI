import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

class UserInfoTest {

    UserInfo userInfo;

    @BeforeEach
    void setUp() {

        userInfo = new UserInfo("Oliver", "Hempel");
        List userList = new List();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void seeUserNames() {

        setUp();

        String name = userInfo.getName();

        System.out.println(name);
    }

    @Test
    void seeUserDetails()   {

        setUp();

        String info = userInfo.getInfo();

        System.out.println(info);
    }



}