package Project.studentGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private TextDataCheck textDataCheck;

    private Login login = new Login();
    private Register register = new Register();

    private JPanel loginPanel = new JPanel();
    private JPanel registerPanel = new JPanel();

    private String userIdData;
    private StringBuffer userPwData = new StringBuffer();
    private StringBuffer userPwCheck = new StringBuffer();
    private String schoolData;
    private String userPwDataString;
    private String userPwCheckString;

    private char[] userPw;
    private char[] userCheck;
    Main(){
        this.setTitle("학생관리프로그램");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(500,560);
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
    }

    private void eventHandler() {
        for(int i = 0; i < login.getLoginBtn().length; i++){
            login.getLoginBtn()[i].addActionListener(this);
        }
        for(int i = 0; i < register.getRegisterBtn().length; i++){
            register.getRegisterBtn()[i].addActionListener(this);
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

        } else if(e.getActionCommand().equals("회원가입")){
            loginPanel.setVisible(false);
            registerPanel.setVisible(true);
            login.getUserNameData().setText("");
            login.getPassWordData().setText("");
        } else if(e.getActionCommand().equals("가입하기")){
            if(register.getUserNameData().getText().length() == 0 || register.getUserNameData().getText() == null){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","id");
                textDataCheck.setVisible(true);
                return;
            }
            userIdData = register.getUserNameData().getText();
            if(register.getPassWordData().getPassword().length == 0 || register.getPassWordData().getPassword() == null){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","pw");
                textDataCheck.setVisible(true);
                return;
            }
            userPw = register.getPassWordData().getPassword();
            for(int i = 0; i < userPw.length; i++){
                userPwData.append(userPw[i]);
            }
            if(register.getPassWordDataCheck().getPassword().length == 0 || register.getPassWordDataCheck().getPassword() == null){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","check");
                textDataCheck.setVisible(true);
                return;
            }
            userCheck = register.getPassWordDataCheck().getPassword();
            for(int i = 0; i < userCheck.length; i++){
                userPwCheck.append(userCheck[i]);
            }
            if(register.getSchoolInfoData().getText().length() == 0 || register.getSchoolInfoData().getText() == null){
                threadSleep();
                textDataCheck = new TextDataCheck(this,"","school");
                textDataCheck.setVisible(true);
                return;
            }
            schoolData = register.getSchoolInfoData().getText();

            userPwDataString = userPwData.toString();
            userPwCheckString = userPwCheck.toString();

            if(userPwDataString.equals(userPwCheckString)){
                //DB 커넥트
            }

        } else if(e.getActionCommand().equals("취소")){
            loginPanel.setVisible(true);
            registerPanel.setVisible(false);
            register.getUserNameData().setText("");
            register.getPassWordData().setText("");
            register.getPassWordDataCheck().setText("");
            register.getSchoolInfoData().setText("");
        }
    }
}
