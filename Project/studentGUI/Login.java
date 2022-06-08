package Project.studentGUI;

import javax.swing.*;
import java.awt.*;

public class Login {
    private JTextField userNameData = new JTextField(10);
    private JPasswordField passWordData = new JPasswordField(10);

    private JLabel userNameText = new JLabel("아이디");
    private JLabel passWordText = new JLabel("비밀번호");

    private JPanel loginPanel = new JPanel();
    private JPanel centerPanel = new JPanel();

    private JButton[] loginBtn = new JButton[2];
    private String[] btnText = {"로그인", "회원가입"};

    private Font textFieldFont = new Font("한컴 고딕",Font.BOLD, 12);

    private int posX = 40;

    private void loginDesign() {
        loginPanel.setLayout(null);
        loginPanel.setBounds(0,0,500,430);
        centerPanel.setLayout(null);
        centerPanel.setBounds(130,80,240,210);
        centerPanel.setBackground(Color.white);
        userNameText.setBounds(40,30, 160, 15);
        userNameText.setFont(textFieldFont);
        centerPanel.add(userNameText);
        userNameData.setBounds(40,50,160,30);
        userNameData.setFont(textFieldFont);
        centerPanel.add(userNameData);
        passWordText.setBounds(40,90,160,15);
        passWordText.setFont(textFieldFont);
        centerPanel.add(passWordText);
        passWordData.setBounds(40,110,160,30);
        centerPanel.add(passWordData);
        for(int i = 0; i < loginBtn.length; i++) {
            loginBtn[i] = new JButton(btnText[i]);
            loginBtn[i].setBounds(posX, 155, 70, 25);
            posX += 90;
            loginBtn[i].setFont(new Font("한컴 고딕", Font.PLAIN, 9));
            loginBtn[i].setFocusPainted(false);
            loginBtn[i].setBorderPainted(false);
            loginBtn[i].setBackground(new Color(12,18,44,243));
            loginBtn[i].setOpaque(true);
            loginBtn[i].setForeground(Color.white);
            centerPanel.add(loginBtn[i]);
        }
        loginPanel.add(centerPanel);
        loginPanel.setBackground(new Color(12,18,44,243));
        loginPanel.setOpaque(true);
    }

    public JPanel getLoginPanel(){
        loginDesign();
        return loginPanel;
    }

    public JButton[] getLoginBtn() {
        return loginBtn;
    }

    public JTextField getUserNameData() {
        return userNameData;
    }

    public JPasswordField getPassWordData() {
        return passWordData;
    }
}
