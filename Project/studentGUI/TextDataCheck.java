package Project.studentGUI;

import javax.swing.*;
import java.awt.*;

class TextDataCheck extends JDialog {
    public TextDataCheck(JFrame frame, String title, String context) {
        super(frame, title, true);
        System.out.println(context);
        JLabel state = null;
        if (context.equals("id")) {
            state = new JLabel("아이디를 입력하세요!");
        } else if (context.equals("pw")) {
            state = new JLabel("비밀번호를 입력하세요!");
        } else if (context.equals("check")) {
            state = new JLabel("비밀번호 확인을 입력하세요!");
        } else if (context.equals("school")) {
            state = new JLabel("학교를 입력하세요!");
        }
        setLayout(new FlowLayout());
        setSize(200, 80);
        add(state);
        setLocationRelativeTo(null);
        state.setFont(new Font("한컴 고딕", Font.BOLD, 14));
    }
}