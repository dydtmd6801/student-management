package Project.studentGUI;

import Project.StudentDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private TextDataCheck textDataCheck = null;

    private Login login = new Login();
    private Register register = new Register();
    private Select select = new Select();
    private Insert insert = new Insert();
    private UserInfo userInfo = new UserInfo();
    private StudentDAO dao = new StudentDAO();

    private JPanel loginPanel = new JPanel();
    private JPanel registerPanel = new JPanel();
    private JPanel selectPanel = new JPanel();
    private JPanel insertPanel = new JPanel();
    private JPanel personInfoPanel = new JPanel();

    private StringBuffer userPwData = new StringBuffer();
    private StringBuffer userPwCheck = new StringBuffer();

    private char[] userPw;
    private char[] userCheck;

    private int regiState;
    private int loginState;
    private int insertState;
    Main(){
        this.setTitle("학생관리프로그램");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(500,430);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    private void formDesign() {
        this.setLayout(new CardLayout());
        this.add(loginPanel);
        loginPanel.setLayout(null);
        loginPanel.setVisible(true);
        loginPanel.add(login.getLoginPanel());
        this.add(registerPanel);
        registerPanel.setLayout(null);
        registerPanel.setVisible(false);
        registerPanel.add(register.getRegisterPanel());
        this.add(selectPanel);
        selectPanel.setLayout(null);
        selectPanel.setVisible(false);
        selectPanel.add(select.getBtnPanel());
        this.add(insertPanel);
        insertPanel.setLayout(null);
        insertPanel.setVisible(false);
        insertPanel.add(insert.getInsertPanel());
        this.add(personInfoPanel);
        personInfoPanel.setLayout(null);
        personInfoPanel.setVisible(false);
        personInfoPanel.add(userInfo.getUserInfoPanel());
    }

    private void eventHandler() {
        for(int i = 0; i < login.getLoginBtn().length; i++){
            login.getLoginBtn()[i].addActionListener(this);
        }
        for(int i = 0; i < register.getRegisterBtn().length; i++){
            register.getRegisterBtn()[i].addActionListener(this);
        }
        for(int i = 0; i < select.getSelectBtn().length; i++){
            select.getSelectBtn()[i].addActionListener(this);
        }
        for(int i = 0; i < insert.getSubmitBtn().length; i++){
            insert.getSubmitBtn()[i].addActionListener(this);
        }
        for(int i = 0; i < userInfo.getUserInfoBtn().length; i++){
            userInfo.getUserInfoBtn()[i].addActionListener(this);
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    private void threadSleep() {
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e12) {}
                textDataCheck.dispose();
            }
        }).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("로그인")){
            loginState = dao.checkUser(login);
            if(loginState == 1){
                threadSleep();
                textDataCheck = new TextDataCheck(this, "","login_Success");
                textDataCheck.setVisible(true);
            } else if(loginState == 2){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","login_fail");
                textDataCheck.setVisible(true);
                return;
            }
            loginPanel.setVisible(false);
            registerPanel.setVisible(false);
            selectPanel.setVisible(true);
            insertPanel.setVisible(false);
            personInfoPanel.setVisible(false);
            login.getUserNameData().setText("");
            login.getPassWordData().setText("");
        } else if(e.getActionCommand().equals("회원가입")){
            loginPanel.setVisible(false);
            registerPanel.setVisible(true);
            selectPanel.setVisible(false);
            insertPanel.setVisible(false);
            personInfoPanel.setVisible(false);
            login.getUserNameData().setText("");
            login.getPassWordData().setText("");
        } else if(e.getActionCommand().equals("가입하기")){
            if(register.getUserNameData().getText().length() == 0 || register.getUserNameData().getText() == null){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","id");
                textDataCheck.setVisible(true);
                return;
            }
            if(register.getPassWordData().getPassword().length == 0 || register.getPassWordData().getPassword() == null){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","pw");
                textDataCheck.setVisible(true);
                return;
            }
            if(register.getPassWordDataCheck().getPassword().length == 0 || register.getPassWordDataCheck().getPassword() == null){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","check");
                textDataCheck.setVisible(true);
                return;
            }
            if(register.getSchoolInfoData().getText().length() == 0 || register.getSchoolInfoData().getText() == null){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","school");
                textDataCheck.setVisible(true);
                return;
            }
            userPw = register.getPassWordData().getPassword();
            for(int i = 0; i < userPw.length; i++){
                userPwData.append(userPw[i]);
            }
            userCheck = register.getPassWordDataCheck().getPassword();
            for(int i = 0; i < userCheck.length; i++){
                userPwCheck.append(userCheck[i]);
            }
            if(!userPwData.toString().equals(userPwCheck.toString())){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","not_match");
                textDataCheck.setVisible(true);
                userPwData = new StringBuffer();
                userPwCheck = new StringBuffer();
                return;
            }
            regiState = dao.registerUser(register);
            if(regiState == 2) {
                threadSleep();
                textDataCheck = new TextDataCheck(this, "", "sql_error");
                textDataCheck.setVisible(true);
            } else if (regiState == 1){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","register");
                textDataCheck.setVisible(true);
                loginPanel.setVisible(true);
                registerPanel.setVisible(false);
                insertPanel.setVisible(false);
                personInfoPanel.setVisible(false);
                dao.initRegister(register);
            }
        } else if(e.getActionCommand().equals("취소")){
            loginPanel.setVisible(true);
            registerPanel.setVisible(false);
            selectPanel.setVisible(false);
            insertPanel.setVisible(false);
            personInfoPanel.setVisible(false);
            dao.initRegister(register);
        } else if(e.getActionCommand().equals("등록하기")){
            loginPanel.setVisible(false);
            registerPanel.setVisible(false);
            selectPanel.setVisible(false);
            insertPanel.setVisible(true);
            personInfoPanel.setVisible(false);
        } else if(e.getActionCommand().equals("조회하기")){

        } else if(e.getActionCommand().equals("개인정보")){
            userInfo.getUserInfoData()[0].setText(StudentDAO.idInfo);
            userInfo.getUserInfoData()[1].setText(StudentDAO.schoolInfo);
            userInfo.getUserInfoData()[0].setEditable(false);
            userInfo.getUserInfoData()[1].setEditable(false);
            loginPanel.setVisible(false);
            registerPanel.setVisible(false);
            selectPanel.setVisible(false);
            insertPanel.setVisible(false);
            personInfoPanel.setVisible(true);
        } else if(e.getActionCommand().equals("종료하기")){
            System.exit(0);
            return;
        } else if(e.getActionCommand().equals("정보등록")){
            insertState = dao.overlapCheck(insert);
            for (int i = 0; i < insert.getInsertData().length; i++) {
                if (insert.getInsertData()[i].getText() == null || insert.getInsertData()[i].getText().length() == 0) {
                    threadSleep();
                    textDataCheck = new TextDataCheck(this, "", Integer.toString(i));
                    textDataCheck.setVisible(true);
                    return;
                }
            }
            if(insertState == 2){
                dao.insertData(insert);
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","regi_okay");
                textDataCheck.setVisible(true);
                loginPanel.setVisible(false);
                registerPanel.setVisible(false);
                selectPanel.setVisible(true);
                insertPanel.setVisible(false);
                personInfoPanel.setVisible(false);
                for(int i = 0; i < insert.getInsertData().length; i++){
                    insert.getInsertData()[i].setText("");
                }
            } else if (insertState == 1){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","overlap");
                textDataCheck.setVisible(true);
            }
        } else if(e.getActionCommand().equals("돌아가기")){
            loginPanel.setVisible(false);
            registerPanel.setVisible(false);
            selectPanel.setVisible(true);
            insertPanel.setVisible(false);
            personInfoPanel.setVisible(false);
            dao.initInsert(insert);
        } else if(e.getActionCommand().equals("학교수정")){
            userInfo.getUserInfoData()[1].setEditable(true);
            userInfo.getUserInfoData()[1].setText("");
            userInfo.getUserInfoBtn()[0].setText("수정완료");
        } else if(e.getActionCommand().equals("수정완료")){
            if(userInfo.getUserInfoData()[1].getText() == null || userInfo.getUserInfoData()[1].getText().length() == 0){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","not_school");
                textDataCheck.setVisible(true);
            } else {
                dao.updateSchool(userInfo);
                userInfo.getUserInfoBtn()[0].setText("학교수정");
                userInfo.getUserInfoData()[1].setEditable(false);
            }
        }
    }
}
