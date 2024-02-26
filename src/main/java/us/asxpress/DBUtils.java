package us.asxpress;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    public static Connection connect (String dbName, String login, String password) {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, login, password);
        }catch (Exception e){
            throw new RuntimeException("Connection failed " + e);
        }
        return connection;
    }

    public static void createTable (String login, String password){
        try(Connection conn = connect("parts", login, password);
            Statement statement = conn.createStatement()){
            String sqlCommand = readFile("/table.sql");
            statement.executeUpdate(sqlCommand);
        } catch (SQLException e) {
            throw new RuntimeException("Problem during table creation" + e);
        }
    }

    private static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();

        try (InputStream inputStream = DBUtils.class.getResourceAsStream(fileName);
             InputStreamReader streamReader = new InputStreamReader(inputStream);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            throw new RuntimeException("File reader occasion " + fileName + e);
        }
        return sb.toString();
    }
}
