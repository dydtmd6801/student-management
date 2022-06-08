package Project.studentGUI;

import Project.StudentDAO;

import javax.swing.*;
import java.awt.*;

public class UserInfo {
    private JPanel userInfoPanel = new JPanel();
    private JPanel centerPanel = new JPanel();

    private JLabel[] userInfoTitle = new JLabel[2];
    private String[] userInfoTitleData = {"아이디", "학교"};
    private JTextField[] userInfoData = new JTextField[2];
    
    private JButton[] userInfoBtn = new JButton[2];
    private String[] btnText = {"학교수정","돌아가기"};

    private Font infoFont = new Font("한컴 고딕",Font.BOLD, 12);

    private int posY = 30;
    private int posX = 40;

    private void infoDesign(){
        userInfoPanel.setLayout(null);
        userInfoPanel.setBounds(0,0,500,430);
        userInfoPanel.setBackground(new Color(12,18,44,243));
        userInfoPanel.setOpaque(true);
        userInfoPanel.add(centerPanel);
        centerPanel.setBounds(130,80,240,210);
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.white);
        for(int i = 0; i < userInfoTitle.length; i++){
            userInfoTitle[i] = new JLabel(userInfoTitleData[i]);
            userInfoTitle[i].setBounds(40, posY, 160,15);
            userInfoTitle[i].setFont(infoFont);
            posY += 20;
            userInfoData[i] = new JTextField(10);
            userInfoData[i].setBounds(40,posY,160,30);
            userInfoData[i].setFont(infoFont);
            posY += 40;
            centerPanel.add(userInfoTitle[i]);
            centerPanel.add(userInfoData[i]);
            userInfoBtn[i] = new JButton(btnText[i]);
            userInfoBtn[i].setBounds(posX, 155, 70, 25);
            posX += 90;
            userInfoBtn[i].setFont(new Font("한컴 고딕", Font.PLAIN, 9));
            userInfoBtn[i].setFocusPainted(false);
            userInfoBtn[i].setBorderPainted(false);
            userInfoBtn[i].setBackground(new Color(12,18,44,243));
            userInfoBtn[i].setOpaque(true);
            userInfoBtn[i].setForeground(Color.white);
            centerPanel.add(userInfoBtn[i]);
        }
    }

    public JPanel getUserInfoPanel(){
        infoDesign();
        return userInfoPanel;
    }

    public JTextField[] getUserInfoData(){
        return userInfoData;
    }

    public JButton[] getUserInfoBtn(){
        return userInfoBtn;
    }

}
