package Project.studentGUI;

import javax.swing.*;
import java.awt.*;

public class Insert {
    private JPanel insertPanel = new JPanel();
    private JPanel dataPanel = new JPanel();

    private Font labelFont = new Font("한컴 고딕", Font.BOLD, 12);

    private JTextField[] insertData = new JTextField[4];
    private JLabel[] labelTitle = new JLabel[4];
    private String[] labelText = {"학번","이름","과목","점수"};

    private int posY = 30;
    private int posX = 40;

    private JButton[] submitBtn = new JButton[2];
    private String[] btnText = {"정보등록","돌아가기"};

    private void insertDesign(){
        insertPanel.setLayout(null);
        insertPanel.setBounds(0,0,500,430);
        dataPanel.setBackground(Color.white);
        dataPanel.setBounds(130,24,240,340);
        dataPanel.setLayout(null);
        for(int i = 0; i < insertData.length; i++){
            insertData[i] = new JTextField(10);
            labelTitle[i] = new JLabel(labelText[i]);
            labelTitle[i].setFont(labelFont);
            labelTitle[i].setBounds(40,posY,160,15);
            posY += 20;
            insertData[i].setBounds(40,posY,160,30);
            insertData[i].setFont(labelFont);
            posY += 40;
            dataPanel.add(labelTitle[i]);
            dataPanel.add(insertData[i]);
        }
        for(int i = 0; i < submitBtn.length; i++){
            submitBtn[i] = new JButton(btnText[i]);
            submitBtn[i].setBorderPainted(false);
            submitBtn[i].setFocusPainted(false);
            submitBtn[i].setOpaque(true);
            submitBtn[i].setBackground(new Color(12,18,44,243));
            submitBtn[i].setForeground(Color.white);
            submitBtn[i].setFont(new Font("한컴 고딕", Font.PLAIN, 9));
            submitBtn[i].setBounds(posX,278,70,25);
            posX += 90;
            dataPanel.add(submitBtn[i]);
        }
        insertPanel.add(dataPanel);
        insertPanel.setBackground(new Color(12,18,44,243));
        insertPanel.setOpaque(true);
    }

    public JPanel getInsertPanel(){
        insertDesign();
        return insertPanel;
    }

    public JButton[] getSubmitBtn(){
        return submitBtn;
    }

    public JTextField[] getInsertData() {
        return insertData;
    }
}
