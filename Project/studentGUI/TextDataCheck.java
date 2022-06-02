package Project.studentGUI;

import javax.swing.*;
import java.awt.*;

class TextDataCheck extends JDialog {
    public TextDataCheck(JFrame frame, String title, String context) {
        super(frame, title, true);
        JLabel state = null;
        if (context.equals("id")) {
            state = new JLabel("아이디를 입력하세요!", JLabel.CENTER);
        } else if (context.equals("pw")) {
            state = new JLabel("비밀번호를 입력하세요!", JLabel.CENTER);
        } else if (context.equals("check")) {
            state = new JLabel("비밀번호 확인을 입력하세요!", JLabel.CENTER);
        } else if (context.equals("school")) {
            state = new JLabel("학교를 입력하세요!", JLabel.CENTER);
        } else if (context.equals("not_match")) {
            state = new JLabel("비밀번호가 맞지 않습니다!", JLabel.CENTER);
        } else if (context.equals("register")) {
            state = new JLabel("회원가입이 완료되었습니다!", JLabel.CENTER);
        } else if (context.equals("sql_error")){
            state = new JLabel("아이디가 중복입니다!", JLabel.CENTER);
        } else if (context.equals("login_Success")){
            state = new JLabel("로그인이 되었습니다!", JLabel.CENTER);
        } else if (context.equals("login_fail")){
            state = new JLabel("로그인 정보가 맞지않습니다!", JLabel.CENTER);
        }
        setLayout(new BorderLayout());
        setSize(200, 100);
        add(state, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        state.setFont(new Font("한컴 고딕", Font.BOLD, 12));
    }
}