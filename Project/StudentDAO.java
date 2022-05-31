package Project;

import Project.common.JdbcUtil;
import Project.studentGUI.Register;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement stmt = null;
    private char[] passWord;
    private StringBuffer passWordData = new StringBuffer();

    private final String USER_REGISTER = "INSERT INTO adminuser (id,pw,school) VALUES (?,?,?)";

    public StudentDAO() {
    }

    public int registerUser(Register register){
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(USER_REGISTER);
            stmt.setString(1,register.getUserNameData().getText());
            System.out.println(register.getUserNameData().getText());
            passWord = register.getPassWordData().getPassword();
            passWordData = new StringBuffer();
            for(int i = 0; i < passWord.length; i++){
                passWordData.append(passWord[i]);
            };
            stmt.setString(2,passWordData.toString());
            stmt.setString(3,register.getSchoolInfoData().getText());
            System.out.println(stmt);
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
}
