package Data;

import DBCon.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bug {
    DBConnection db = new DBConnection();
    final Connection connection = db.getConnection();
    public void getBugs() {
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        Product p = new Product();
        Employee emp = new Employee();
        try {
            preparedStatement = connection.prepareCall("SELECT * FROM bug.bug");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int bugNo = resultSet.getInt("bugNo");
                int productNo = resultSet.getInt("productNo");
                int employeeNo = resultSet.getInt("employeeNo");
                String bugDescription = resultSet.getString("bugDescription");
                String fixDescription = resultSet.getString("fixDescription");
                String dateRaised = resultSet.getString("dateRaised");
                String dateClosed = resultSet.getString("dateClosed");
                System.out.println(bugNo + " " + p.getProductbyId(productNo) + " " + emp.getEmployeesbyId(employeeNo) + " " + bugDescription + " " + fixDescription + " " + dateRaised + " " + dateClosed);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //not sure it works
    public boolean addBug(int productNo, int employeeNo, String bugDescription) {
        PreparedStatement preparedStatement;
        int i = -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO bug.bug(productNo, employeeNo, bugDescription, dateRaised) VALUES (?, ?, ?, CURRENT_DATE())");
            preparedStatement.setInt(1, productNo);
            preparedStatement.setInt(2, employeeNo);
            preparedStatement.setString(3, bugDescription);
            i = preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if(i > 0 ) return true;
        else return false;
    }
}
