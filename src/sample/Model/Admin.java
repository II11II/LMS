package sample.Model;

import java.sql.SQLException;

public class Admin extends Person {
    public Admin(String username, String password, String firstName, String lastName) throws SQLException {
        super(username, password, firstName, lastName);
    }

    @Override
    public void login(String username, String password) {

    }


    @Override
    public void register() {

    }

}
