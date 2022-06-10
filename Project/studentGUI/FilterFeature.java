package Project.studentGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class FilterFeature extends JDialog implements ActionListener {
    JTextField filterData = new JTextField(10);
    public FilterFeature(JFrame frame, String title, String context) {
        super(frame, title, true);
        Font textFont = new Font("한컴 고딕", Font.BOLD, 12);
        JLabel label = new JLabel("");
        if(context == "search") {
            label = new JLabel("검색할 학번을 입력해주세요", JLabel.CENTER);
        } else if(context == "average"){
            label = new JLabel("계산할 학번을 입력해주세요", JLabel.CENTER);
        }
        JButton filter = new JButton("검색");
        setLayout(null);
        setSize(240, 120);
        label.setBounds(0,0,240,30);
        label.setFont(textFont);
        filterData.setBounds(170,30,60,30);
        filter.setBounds(140,30,50,30);
        filter.setFocusPainted(false);
        filter.setBorderPainted(false);
        filter.setBackground(new Color(12,18,44,243));
        filter.setOpaque(true);
        filter.setForeground(Color.WHITE);
        filter.setFont(new Font("한컴 고딕",Font.BOLD,9));
        filter.addActionListener(this);
        add(label);
        add(filter);
        add(filterData);
        filterData.setBounds(30,30,100,30);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("검색")){
            setVisible(false);
        }
    }

    public String getIdData(){
        return filterData.getText();
    }
}
