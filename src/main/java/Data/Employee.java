package Data;

import DBCon.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    DBConnection db = new DBConnection();
    final Connection connection = db.getConnection();

    public void getEmployees() {
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareCall("SELECT * FROM bug.employee");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int employeeNo = resultSet.getInt("employeeNo");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                System.out.println(employeeNo + " " + firstName + " " + lastName);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getEmployeesbyId(int id) {
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        String lastName = null;
        String firstName = null;
        try {
            preparedStatement = connection.prepareCall("SELECT * FROM bug.employee where employee.employeeNo = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int employeeNo = resultSet.getInt("employeeNo");
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return firstName+" "+lastName;
    }

}
