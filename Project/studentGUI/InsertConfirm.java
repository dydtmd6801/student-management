package Project.studentGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertConfirm extends JDialog implements ActionListener {
    private int confirmState = 0;
    public InsertConfirm(JFrame frame, String title, String context) {
        super(frame, title, true);
        JLabel text = new JLabel("등록을 계속 하시겠습니까?", JLabel.CENTER);
        JButton[] confirm = new JButton[2];
        String[] btnText = {"예","아니요"};
        int posX = 50;
        setLayout(null);
        setSize(240, 120);
        text.setBounds(0,0,240,30);
        for(int i = 0; i < confirm.length; i++){
            confirm[i] = new JButton(btnText[i]);
            confirm[i].setBounds(posX,30,60,30);
            posX += 80;
            confirm[i].setFont(new Font("한컴 고딕", Font.PLAIN, 9));
            confirm[i].setFocusPainted(false);
            confirm[i].setBorderPainted(false);
            confirm[i].setBackground(new Color(12,18,44,243));
            confirm[i].setOpaque(true);
            confirm[i].setForeground(Color.white);
            confirm[i].addActionListener(this);
            add(confirm[i]);
        }
        add(text);
        setLocationRelativeTo(null);
        text.setFont(new Font("한컴 고딕", Font.BOLD, 12));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("예")){
            confirmState = 1;
            setVisible(false);
        } else if(e.getActionCommand().equals("아니요")){
            confirmState = 2;
            setVisible(false);
        }
    }

    public int getConfirmState(){
        return confirmState;
    }
}