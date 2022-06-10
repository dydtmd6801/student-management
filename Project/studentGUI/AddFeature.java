package Project.studentGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFeature extends JDialog implements ActionListener {
    private int checkState = 0;

    public AddFeature(JFrame frame, String title, String context) {
        super(frame, title, true);
        JButton[] menuBtn = new JButton[2];
        String[] btnText = {"검색하기", "계산하기"};
        int posX = 25;
        setLayout(null);
        setSize(240, 120);
        for (int i = 0; i < menuBtn.length; i++) {
            menuBtn[i] = new JButton(btnText[i]);
            menuBtn[i].setBounds(posX, 30, 80, 30);
            posX += 100;
            menuBtn[i].setFont(new Font("한컴 고딕", Font.PLAIN, 9));
            menuBtn[i].setFocusPainted(false);
            menuBtn[i].setBorderPainted(false);
            menuBtn[i].setBackground(new Color(12, 18, 44, 243));
            menuBtn[i].setOpaque(true);
            menuBtn[i].setForeground(Color.white);
            menuBtn[i].addActionListener(this);
            add(menuBtn[i]);
        }
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("검색하기")){
            checkState = 1;
            setVisible(false);
        } else if (e.getActionCommand().equals("계산하기")){
            checkState = 2;
            setVisible(false);
        }
    }

    public int getCheckState(){
        return checkState;
    }
}
