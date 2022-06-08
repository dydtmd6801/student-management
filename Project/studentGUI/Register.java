package Project.studentGUI;

import javax.swing.*;
import java.awt.*;

public class Register {

    private JPanel registerPanel = new JPanel();
    private JPanel centerPanel = new JPanel();

    private JLabel userNameText = new JLabel("아이디");
    private JLabel passWordText = new JLabel("비밀번호");
    private JLabel passWordTextCheck = new JLabel("비밀번호 확인");
    private JLabel schoolInfoText = new JLabel("학교");

    private JTextField userNameData = new JTextField(10);
    private JPasswordField passWordData = new JPasswordField(10);
    private JPasswordField passWordDataCheck = new JPasswordField(10);
    private JTextField schoolInfoData = new JTextField(10);

    private JButton[] registerBtn = new JButton[2];
    private String[] btnText = {"가입하기", "취소"};

    private Font textFieldFont = new Font("한컴 고딕",Font.BOLD, 12);
    
    private int posX = 40;

    private void registerDesign(){
        registerPanel.setLayout(null);
        registerPanel.setBounds(0,0,500,430);
        centerPanel.setLayout(null);
        centerPanel.setBounds(130,24,240,340);
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
        passWordData.setFont(textFieldFont);
        centerPanel.add(passWordData);
        passWordTextCheck.setBounds(40,150,160,15);
        passWordTextCheck.setFont(textFieldFont);
        centerPanel.add(passWordTextCheck);
        passWordDataCheck.setBounds(40,170,160,30);
        passWordDataCheck.setFont(textFieldFont);
        centerPanel.add(passWordDataCheck);
        schoolInfoText.setBounds(40,210,160,15);
        schoolInfoText.setFont(textFieldFont);
        centerPanel.add(schoolInfoText);
        schoolInfoData.setBounds(40,230,160,30);
        schoolInfoData.setFont(textFieldFont);
        centerPanel.add(schoolInfoData);

        for(int i = 0; i < registerBtn.length; i++) {
            registerBtn[i] = new JButton(btnText[i]);
            registerBtn[i].setBounds(posX, 278, 70, 25);
            posX += 90;
            registerBtn[i].setFont(new Font("한컴 고딕", Font.PLAIN, 9));
            registerBtn[i].setFocusPainted(false);
            registerBtn[i].setBorderPainted(false);
            registerBtn[i].setBackground(new Color(12,18,44,243));
            registerBtn[i].setOpaque(true);
            registerBtn[i].setForeground(Color.white);
            centerPanel.add(registerBtn[i]);
        }
        registerPanel.add(centerPanel);
        registerPanel.setBackground(new Color(12,18,44,243));
        registerPanel.setOpaque(true);
    }

    public JPanel getRegisterPanel(){
        registerDesign();
        return registerPanel;
    }

    public JButton[] getRegisterBtn() {
        return registerBtn;
    }

    public JTextField getUserNameData() {
        return userNameData;
    }

    public JPasswordField getPassWordData() {
        return passWordData;
    }

    public JPasswordField getPassWordDataCheck() {
        return passWordDataCheck;
    }

    public JTextField getSchoolInfoData() {
        return schoolInfoData;
    }
}
