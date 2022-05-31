package Project.common;

import java.sql.*;

public class JdbcUtil {
    public static Connection getConnection() {
        String server = "jdbc:mysql://localhost:3306/java_project?useSSL=false";
        String userId = "root";
        String passwd = "abc123";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(server, userId, passwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(PreparedStatement stmt, Connection conn) {
        if(stmt != null){
            try{
                if(!stmt.isClosed())
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
        }
        if(conn != null) {
            try{
                if(!conn.isClosed())
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        if(rs != null){
            try{
                if(!rs.isClosed())
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }
        if(stmt != null){
            try{
                if(!stmt.isClosed())
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
        }
        if(conn != null) {
            try{
                if(!conn.isClosed())
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
