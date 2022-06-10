package Project;

import Project.common.JdbcUtil;
import Project.studentGUI.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.sql.*;

public class StudentDAO {
    public static String schoolInfo;
    public static String idInfo;
    public static int allStudent;

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement stmt = null;
    private char[] passWord;
    private StringBuffer passWordData = new StringBuffer();
    private char[] loginPassWd;
    private StringBuffer loginPassWdData = new StringBuffer();
    private String[][] studentData;
    private String[][] filterData;
    private int cnt = 0;
    private int rows = 0;
    private JFileChooser fileChooser = new JFileChooser();
    private String saveRow;

    private final String USER_REGISTER = "INSERT INTO adminuser (id,pw,school) VALUES (?,?,?)";
    private final String USER_LOGIN = "SELECT * FROM adminuser WHERE id=? AND pw=?";
    private final String STUDENT_INSERT = "INSERT INTO student (id, name, subject, score, school) VALUES (?,?,?,?,?)";
    private final String DATA_CHECK = "SELECT * FROM student WHERE id=? AND subject=?";
    private final String USER_UPDATE = "UPDATE adminuser SET school=? WHERE id=?";
    private final String DATA_UPDATE = "UPDATE student SET school=? WHERE school=?";
    private final String STUDENT_DATA = "SELECT * FROM student WHERE school=?";
    private final String STUDENT_COUNT = "SELECT COUNT(*) FROM student WHERE school=?";
    private final String STUDENT_COUNT_ALL = "SELECT COUNT(DISTINCT name) FROM student WHERE school=?";
    private final String DELETE_DATA = "DELETE FROM student WHERE id=? AND subject=?";
    private final String UPDATE_DATA = "UPDATE student SET id=?, name=?, subject=?, score=? WHERE id=? AND subject=?";
    private final String FILTER_DATA = "SELECT * FROM student WHERE id=? AND school=?";
    private final String FILTER_DATA_COUNT = "SELECT COUNT(*) FROM student WHERE id=? AND school=?";

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

    public String[][] studentData(){
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(STUDENT_COUNT);
            stmt.setString(1, schoolInfo);
            rs = stmt.executeQuery();
            if(rs.next()){
                rows = rs.getInt(1);
            }
            cnt = 0;
            studentData = new String[rows][4];
            stmt = conn.prepareStatement(STUDENT_DATA);
            stmt.setString(1, schoolInfo);
            rs = stmt.executeQuery();
            while(rs.next()){
                studentData[cnt][0] = rs.getString("ID");
                studentData[cnt][1] = rs.getString("NAME");
                studentData[cnt][2] = rs.getString("SUBJECT");
                studentData[cnt][3] = rs.getString("SCORE");
                cnt++;
            }
            return studentData;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, stmt, conn);
        }
        return null;
    }

    public String[][] filterData(String filter){
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(FILTER_DATA_COUNT);
            stmt.setString(1, filter);
            stmt.setString(2, schoolInfo);
            rs = stmt.executeQuery();
            if(rs.next()){
                rows = rs.getInt(1);
            }
            cnt = 0;
            studentData = new String[rows][4];
            stmt = conn.prepareStatement(FILTER_DATA);
            stmt.setString(1, filter);
            stmt.setString(2, schoolInfo);
            rs = stmt.executeQuery();
            while(rs.next()){
                studentData[cnt][0] = rs.getString("ID");
                studentData[cnt][1] = rs.getString("NAME");
                studentData[cnt][2] = rs.getString("SUBJECT");
                studentData[cnt][3] = rs.getString("SCORE");
                cnt++;
            }
            return studentData;
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, stmt, conn);
        }
        return null;
    }

    public String[] averageData(String filter){
        int sum = 0;
        String name = new String();
        String[] outputResult = new String[2];
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(FILTER_DATA);
            stmt.setString(1, filter);
            stmt.setString(2, schoolInfo);
            rs = stmt.executeQuery();
            rs.last();
            int rowData = rs.getRow();
            rs.beforeFirst();
            while(rs.next()){
                sum += Integer.parseInt(rs.getString("SCORE"));
                name = rs.getString("NAME");
            }
            outputResult[0] = Integer.toString(sum/rowData);
            outputResult[1] = name;
            return outputResult;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteData(DefaultTableModel tableModel, JTable table){
        int[] selecteds = table.getSelectedRows();
        int selected = table.getSelectedRow();
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(DELETE_DATA);
            if(selecteds.length != 1){
                for(int i = 0; i < selecteds.length; i++){
                    stmt.setString(1,tableModel.getValueAt(selecteds[i],0).toString());
                    stmt.setString(2,tableModel.getValueAt(selecteds[i],2).toString());
                    stmt.executeUpdate();
                }
            } else {
                stmt.setString(1, tableModel.getValueAt(selected,0).toString());
                stmt.setString(2, tableModel.getValueAt(selected,2).toString());
                stmt.executeUpdate();
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JdbcUtil.close(stmt, conn);
        }
        if(selecteds.length != 1){
            tableModel.removeRow(selecteds[0]);
            for(int i = 1; i < selecteds.length; i++){
                tableModel.removeRow(selecteds[i]-i);
            }
        } else {
            tableModel.removeRow(selected);
        }
    }

    public void updateData(JTable table){
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(UPDATE_DATA);
            for(int i = 0; i < table.getRowCount(); i++){
                stmt.setString(1, table.getValueAt(i,0).toString());
                stmt.setString(2, table.getValueAt(i,1).toString());
                stmt.setString(3, table.getValueAt(i,2).toString());
                stmt.setString(4, table.getValueAt(i,3).toString());
                stmt.setString(5, table.getValueAt(i,0).toString());
                stmt.setString(6, table.getValueAt(i,2).toString());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int saveFile(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT Text","txt");
        fileChooser.setFileFilter(filter);

        fileChooser.setCurrentDirectory(new File(".\\"));
        int ret = fileChooser.showSaveDialog(null);
        if(ret != JFileChooser.APPROVE_OPTION){
            return 2;
        }
        String filePath = fileChooser.getSelectedFile().getPath();
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(STUDENT_DATA);
            stmt.setString(1, schoolInfo);
            rs = stmt.executeQuery();
            while(rs.next()){
                saveRow = new String();
                saveRow += rs.getString("ID")  + ",";
                saveRow += rs.getString("NAME") + ",";
                saveRow += rs.getString("SUBJECT") + ",";
                saveRow += rs.getString("SCORE") + ",";
                saveRow += rs.getString("SCHOOL") + "\n";
                bw.write(saveRow);
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(stmt, conn);
        }
        return 0;
    }

    public int loadFile(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT Text","txt");
        fileChooser.setFileFilter(filter);

        fileChooser.setCurrentDirectory(new File(".\\"));
        int ret = fileChooser.showSaveDialog(null);
        if(ret != JFileChooser.APPROVE_OPTION){
            return 2;
        }
        String filePath = fileChooser.getSelectedFile().getPath();
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(STUDENT_INSERT);
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String row;
            while((row = br.readLine()) != null) {
                String[] textData = row.split(",");
                for(int i = 0; i < textData.length; i++){
                    stmt.setString(i+1, textData[i]);
                }
                stmt.executeUpdate();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(stmt, conn);
        }
        return 0;
    }

    public void studentAllCount(){
        try{
            conn = JdbcUtil.getConnection();
            stmt = conn.prepareStatement(STUDENT_COUNT_ALL);
            stmt.setString(1, schoolInfo);
            rs = stmt.executeQuery();
            if(rs.next()){
                System.out.println(rs.getInt(1));
                allStudent = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
