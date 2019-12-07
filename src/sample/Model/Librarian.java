package sample.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Librarian extends Person {


    public Librarian(String username, String password, String firstName, String lastName) throws SQLException {
        super(username, password, firstName, lastName);
    }

    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * from Librarian;";
        return exists(username, password, query);
    }




    @Override
    public void register() {

    }


}
