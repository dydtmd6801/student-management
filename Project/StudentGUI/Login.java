package Project.StudentGUI;

import javax.swing.*;
import java.awt.*;

public class Login {
    private JTextField userNameData = new JTextField(10);
    private JTextField passWordData = new JTextField(10);

    private JLabel userNameText = new JLabel("아이디");
    private JLabel passWordText = new JLabel("비밀번호");

    private JPanel loginPanel = new JPanel();
    private JPanel centerPanel = new JPanel();

    private JButton[] loginRegiBtn = new JButton[2];
    private String[] btnText = {"로그인", "회원가입"};

    private Font textFieldFont = new Font("한컴 고딕",Font.BOLD, 14);

    private int posX = 40;

    public Component loginDesign() {
        loginPanel.setLayout(null);
        centerPanel.setLayout(null);
        centerPanel.setBounds(130,80,240,200);
        centerPanel.setBackground(Color.white);
        userNameText.setBounds(40,20, 160, 15);
        userNameText.setFont(textFieldFont);
        centerPanel.add(userNameText);
        userNameData.setBounds(40,40,160,30);
        centerPanel.add(userNameData);
        passWordText.setBounds(40,80,160,15);
        passWordText.setFont(textFieldFont);
        centerPanel.add(passWordText);
        passWordData.setBounds(40,100,160,30);
        centerPanel.add(passWordData);
        for(int i = 0; i < loginRegiBtn.length; i++) {
            loginRegiBtn[i] = new JButton(btnText[i]);
            loginRegiBtn[i].setBounds(posX, 150, 70, 25);
            posX += 90;
            loginRegiBtn[i].setFont(new Font("한컴 고딕", Font.PLAIN, 9));
            loginRegiBtn[i].setFocusPainted(false);
            loginRegiBtn[i].setBorderPainted(false);
            loginRegiBtn[i].setBackground(Color.black);
            loginRegiBtn[i].setForeground(Color.white);
            centerPanel.add(loginRegiBtn[i]);
        }
        loginPanel.add(centerPanel);
        loginPanel.setBackground(Color.black);
        return loginPanel;
    }

    public void eventHandler(){

    }
}
