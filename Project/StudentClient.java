package Project;

import javax.swing.*;

public class StudentClient extends JFrame {

    StudentClient(){
        this.setTitle("학생관리프로그램");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(500,400);
        this.setVisible(true);
    }

    private void formDesign() {
    }

    private void eventHandler() {
    }

    public static void main(String[] args) {
        new StudentClient();
    }
}
