package Project.studentGUI;

import javax.swing.*;
import java.awt.*;

public class Select {
    private JPanel btnPanel = new JPanel();

    private JButton[] btnSelect = new JButton[4];
    private String[] btnText = {"등록하기","조회하기","개인정보","종료하기"};

    private Font btnTextFont = new Font("한컴 고딕",Font.BOLD, 12);

    private void selectDesign(){
        btnPanel.setLayout(null);
        btnPanel.setBounds(0,0,500,430);
        btnPanel.setBackground(new Color(12,18,44,243));
        btnPanel.setOpaque(true);
        for(int i = 0; i < btnSelect.length; i++){
            btnSelect[i] = new JButton(btnText[i]);
            btnSelect[i].setBackground(Color.white);
            btnSelect[i].setFont(btnTextFont);
            btnSelect[i].setFocusPainted(false);
            btnSelect[i].setBorderPainted(false);
            btnPanel.add(btnSelect[i]);
        }
        btnSelect[0].setBounds(150,150,90,40);
        btnSelect[1].setBounds(260,150,90,40);
        btnSelect[2].setBounds(150,210,90,40);
        btnSelect[3].setBounds(260,210,90,40);
    }

    public JPanel getBtnPanel(){
        selectDesign();
        return btnPanel;
    }

    public JButton[] getSelectBtn() {
        return btnSelect;
    }
}
