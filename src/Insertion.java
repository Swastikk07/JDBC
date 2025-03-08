import java.sql.*;
public class Insertion {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydatabases";
        String username = "root";
        String password = "----"
        String query1 = "insert into employees(id,name,job_title,salary) values (3,'pegasus','FS devloper',87000)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded!!!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection Successfull!!!");
            Statement stmt = con.createStatement();
            int rowsaffected= stmt.executeUpdate(query1);

            if(rowsaffected>0) {
                System.out.println("Rows affected : " + rowsaffected + " row(s)");
            }else{
                System.out.println("insertion failed!!!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}
