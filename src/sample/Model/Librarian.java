package sample.Model;

import java.sql.SQLException;

public class Librarian extends Person {


    public Librarian(String username, String password, String firstName, String lastName) throws SQLException {
        super(username, password, firstName, lastName);
    }

    @Override
    public void login() {


    }

    @Override
    public void register() {

    }


}
