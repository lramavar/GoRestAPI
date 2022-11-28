package gorest.usermanagement.models;

public class User {
    public int id;
    public String name;
    public String email;
    public String gender;
    public String status;

    @Override
    public String toString() {
        return("ID : " + id
                + "\n Name : " + name
                + "\n Email : " + email
                + "\n Gender : " + gender
                + "\n Status : " + status);
    }
}
