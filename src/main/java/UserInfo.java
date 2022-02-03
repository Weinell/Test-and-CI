public class UserInfo {

    private String fname;
    private String lname;
    private String pw;
    private String phone;
    private String address;

    public UserInfo(String fname, String lname, String pw, String phone, String address)  {

        this.fname = fname;
        this.lname = lname;
        this.pw = pw;
        this.phone = phone;
        this.address = address;

    }


    public String getName() {
        return fname + " " + lname;
    }

    public String getInfo() {

        return pw + phone + address;
    }

    public void setInfo(String pw, String phone, String address) {

            this.pw = pw;
            this.phone = phone;
            this.address = address;
    }
}
