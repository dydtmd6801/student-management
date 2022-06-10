package Project.studentGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileCheck extends JDialog implements ActionListener {
    private int checkState = 0;

    public FileCheck(JFrame frame, String title, String context) {
        super(frame, title, true);
        JButton[] confirm = new JButton[2];
        String[] btnText = {"불러오기", "내보내기"};
        int posX = 25;
        setLayout(null);
        setSize(240, 120);
        for (int i = 0; i < confirm.length; i++) {
            confirm[i] = new JButton(btnText[i]);
            confirm[i].setBounds(posX, 30, 80, 30);
            posX += 100;
            confirm[i].setFont(new Font("한컴 고딕", Font.PLAIN, 9));
            confirm[i].setFocusPainted(false);
            confirm[i].setBorderPainted(false);
            confirm[i].setBackground(new Color(12, 18, 44, 243));
            confirm[i].setOpaque(true);
            confirm[i].setForeground(Color.white);
            confirm[i].addActionListener(this);
            add(confirm[i]);
        }
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("불러오기")){
            checkState = 1;
            setVisible(false);
        } else if (e.getActionCommand().equals("내보내기")){
            checkState = 2;
            setVisible(false);
        }
    }

    public int getCheckState(){
        return checkState;
    }
}
