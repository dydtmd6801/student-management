package Project.StudentGUI;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private Login login = new Login();

    Main(){
        this.setTitle("학생관리프로그램");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(500,400);
        this.setVisible(true);
    }

    private void formDesign() {
        this.setLayout(new CardLayout());
        this.add(login.loginDesign());
    }

    private void eventHandler() {
    }

    public static void main(String[] args) {
        new Main();
    }
}
