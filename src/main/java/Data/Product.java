package Data;

import DBCon.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    DBConnection db = new DBConnection();
    final Connection connection = db.getConnection();

    public void getProducts() {
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareCall("SELECT * FROM bug.product");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int productNo = resultSet.getInt("productNo");
                String productName = resultSet.getString("productName");
                String productDetails = resultSet.getString("productDetails");
                System.out.println(productNo + " " + productName + " " + productDetails);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getProductbyId(int id) {
        PreparedStatement preparedStatement;
        ResultSet resultSet = null;
        String productName = null;
        String productDetails = null;
        try {
            preparedStatement = connection.prepareCall("SELECT * FROM bug.product where product.productNo = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int productNo = resultSet.getInt("productNo");
                productName = resultSet.getString("productName");
                productDetails = resultSet.getString("productDetails");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return productName+" "+productDetails;

    }

    public boolean addProduct(String productName, String productDetails) {
        PreparedStatement preparedStatement;
        int i = -1;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO bug.product(productName, productDetails) VALUES (?, ?)");
            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, productDetails);
            i = preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if(i > 0 ) return true;
        else return false;
    }

    public boolean deleteProduct(int productNo) {
        PreparedStatement preparedStatement;
        int i = -1;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM bug.product WHERE product.productNo = ? LIMIT 1");
            preparedStatement.setInt(1, productNo);
            i = preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if(i > 0 ) return true;
        else return false;
    }

    public boolean updateProduct(int productNo, String productName, String productDetails) {

        PreparedStatement preparedStatement;
        int i = -1;
        try {
            preparedStatement = connection.prepareStatement("UPDATE bug.product SET product.productName = ?, product.productDetails = ? WHERE product.productNo = ?");
            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, productDetails);
            preparedStatement.setInt(3,  productNo);
            i = preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        if(i > 0 ) return true;
        else return false;
    }
}
