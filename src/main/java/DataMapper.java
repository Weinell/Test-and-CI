import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DataMapper {

        public List<User> getAllUsers() {
                List<User> persons = new ArrayList();
                try {
                        Connection con = DBconnector.connection();
                        String SQL = "SELECT id, fname, lname, pw, phone, address FROM usertable";
                        PreparedStatement ps = con.prepareStatement(SQL);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                                String fname = rs.getString("fname");
                                String lname = rs.getString("lname");
                                String pw = rs.getString("pw");
                                String phone = rs.getString("phone");
                                String address = rs.getString("address");
                                int id = (int) rs.getInt("id");
                                persons.add(new User(id, fname, lname, pw, phone, address));
                        }

                } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                }
                return persons;
        }
}
