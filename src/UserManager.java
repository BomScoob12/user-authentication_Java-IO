import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserManager {

    private String URL = "jdbc:mysql://localhost:3306/userauthentication";
    private String username = "root";
    private String password = "BomScoob112004@";
    Connection connection;
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        }
    }

    public void registerUser(User user){
        String sql = "INSERT INTO users VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public List<String> listAllUser(){
        String sql = "SELECT * FROM users";
        try{
            LinkedList<String> listAllUser = new LinkedList<>();
            ResultSet result = connection.createStatement().executeQuery(sql);
            while (result.next()){
                String user = result.getString(1) + " "
                        + result.getString(2) + " "
                        + result.getString(3);
                listAllUser.add(user);
            }
            return listAllUser;

        } catch (SQLException e){
            e.getStackTrace();
        }
        return null;
    }
    public boolean loginUser(User user){
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                if(result.getString(2).equalsIgnoreCase(user.getUsername()) && result.getString(3).equals(user.getPassword())){
                    return true;
                }
            }
        } catch(SQLException e){
            e.getStackTrace();
        }
        return false;
    }

    public void deleteUserByID(String userID){
        String sql = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
