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
        } else if (context.equals("0")){
            state = new JLabel("학번을 입력해주세요!", JLabel.CENTER);
        } else if (context.equals("1")){
            state = new JLabel("이름을 입력해주세요!", JLabel.CENTER);
        } else if (context.equals("2")){
            state = new JLabel("과목을 입력해주세요!", JLabel.CENTER);
        } else if (context.equals("3")){
            state = new JLabel("점수를 입력해주세요!", JLabel.CENTER);
        } else if (context.equals("regi_okay")){
            state = new JLabel("정보등록이 완료되었습니다!", JLabel.CENTER);
        } else if (context.equals("overlap")){
            state = new JLabel("중복된 정보가 있습니다!", JLabel.CENTER);
        } else if (context.equals("not_school")){
            state = new JLabel("학교 정보를 입력해주세요!", JLabel.CENTER);
        } else if (context.equals("not_digit")){
            state = new JLabel("숫자를 입력해주세요!", JLabel.CENTER);
        } else if (context.equals("score_overflow")){
            state = new JLabel("점수를 올바르게 입력하세요!", JLabel.CENTER);
        }
        setLayout(new BorderLayout());
        setSize(200, 100);
        add(state, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        state.setFont(new Font("한컴 고딕", Font.BOLD, 12));
    }
}