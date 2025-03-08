import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydatabases";
        String username = "root";
        String password = "----"
        String query = "select * from employees";
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
            ResultSet rs = stmt.executeQuery(query);
            //Printing
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println("**********************");
                System.out.println("Id:-"+id);
                System.out.println("Name:-"+name);
                System.out.println("job_title:-"+job_title);
                System.out.println("Salary:-"+salary);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
}
