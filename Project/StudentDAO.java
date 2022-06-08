package Project;

import Project.common.JdbcUtil;
import Project.studentGUI.Insert;
import Project.studentGUI.Login;
import Project.studentGUI.Register;
import Project.studentGUI.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    public static String schoolInfo = new String();
    public static String idInfo = new String();

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement stmt = null;
    private char[] passWord;
    private StringBuffer passWordData = new StringBuffer();
    private char[] loginPassWd;
    private StringBuffer loginPassWdData = new StringBuffer();

    private final String USER_REGISTER = "INSERT INTO adminuser (id,pw,school) VALUES (?,?,?)";
    private final String USER_LOGIN = "SELECT * FROM adminuser WHERE id=? AND pw=?";
    private final String STUDENT_INSERT = "INSERT INTO student (id, name, subject, score, school) VALUES (?,?,?,?,?)";
    private final String DATA_CHECK = "SELECT * FROM student WHERE id=? AND subject=?";
    private final String USER_UPDATE = "UPDATE adminuser SET school=? WHERE id=?";
    private final String DATA_UPDATE = "UPDATE student SET school=? WHERE school=?";

    public int registerUser(Register register){
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(USER_REGISTER);
            stmt.setString(1,register.getUserNameData().getText());
            passWord = register.getPassWordData().getPassword();
            passWordData = new StringBuffer();
            for(int i = 0; i < passWord.length; i++){
                passWordData.append(passWord[i]);
            };
            stmt.setString(2,passWordData.toString());
            stmt.setString(3,register.getSchoolInfoData().getText());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            return 2;
        } finally {
            JdbcUtil.close(stmt,conn);
        }
    }

    public void initRegister(Register register){
        register.getUserNameData().setText("");
        register.getPassWordData().setText("");
        register.getPassWordDataCheck().setText("");
        register.getSchoolInfoData().setText("");
    }

    public void initInsert(Insert insert){
        for(int i = 0; i < insert.getInsertData().length; i++){
            insert.getInsertData()[i].setText("");
        }
    }

    public int checkUser(Login login){
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(USER_LOGIN);
            stmt.setString(1, login.getUserNameData().getText());
            loginPassWd = login.getPassWordData().getPassword();
            loginPassWdData = new StringBuffer();
            for(int i = 0; i < loginPassWd.length; i++){
                loginPassWdData.append(loginPassWd[i]);
            };
            stmt.setString(2,loginPassWdData.toString());
            rs = stmt.executeQuery();
            if(rs.next()){
                idInfo = rs.getString("ID");
                schoolInfo = rs.getString("SCHOOL");
                return 1;
            } else {
                return 2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, stmt, conn);
        }
        return 0;
    }

    public void insertData(Insert insert){
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(STUDENT_INSERT);
            for(int i = 0; i < insert.getInsertData().length; i++){
                stmt.setString(i + 1, insert.getInsertData()[i].getText());
            }
            stmt.setString(5, schoolInfo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(stmt, conn);
        }
    }
    
    public int overlapCheck(Insert insert){
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(DATA_CHECK);
            stmt.setString(1, insert.getInsertData()[0].getText());
            stmt.setString(2, insert.getInsertData()[2].getText());
            rs = stmt.executeQuery();
            if(rs.next()){
                return 1;
            } else {
                return 2;
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, stmt, conn);
        }
        return 0;
    }

    public void updateSchool(UserInfo userInfo){
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(USER_UPDATE);
            stmt.setString(1, userInfo.getUserInfoData()[1].getText());
            stmt.setString(2, idInfo);
            stmt.executeUpdate();
            stmt = conn.prepareStatement(DATA_UPDATE);
            stmt.setString(1, userInfo.getUserInfoData()[1].getText());
            stmt.setString(2, schoolInfo);
            stmt.executeUpdate();
            schoolInfo = userInfo.getUserInfoData()[1].getText();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(stmt, conn);
        }
    }
}
