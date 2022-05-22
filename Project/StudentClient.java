package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentClient extends JFrame implements ActionListener {

    private JPanel btnPanel = new JPanel();
    private JPanel mainPanel = new JPanel();

    private JPanel titlePanel = new JPanel();
    private JPanel insertPanel = new JPanel();
    private JPanel searchPanel = new JPanel();

    private JPanel insertTitlePanel = new JPanel();
    private JPanel insertDetailPanel = new JPanel();
    private JPanel[] insertComponentPanel = new JPanel[4];

    private JLabel title = new JLabel("학생관리프로그램");
    private JLabel insertTitle = new JLabel("등록하기");
    private JLabel[] insertDetailLabel = new JLabel[4];

    private JTextField[] insertTextField = new JTextField[4];

    private JButton[] mainBtn = new JButton[5];

    private String[] mainBtnText = {"등록하기","조회하기","내보내기","불러오기","종료하기"};
    private String[] insertLabel = {"학번","이름","과목","점수"};

    private Font btnFont = new Font("맑은 고딕", Font.BOLD, 12);
    private Font subTitleFont = new Font("맑은 고딕", Font.BOLD, 24);

    StudentClient(){
        this.setTitle("학생관리프로그램");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.formDesign();
        this.eventHandler();
        this.setSize(500,400);
        this.setVisible(true);
    }

    private void formDesign() {
        btnPanel.setLayout(new GridLayout(1,5,3,0));
        for(int i = 0; i < mainBtn.length; i++){
            mainBtn[i] = new JButton();
            mainBtn[i].setText(mainBtnText[i]);
            mainBtn[i].setBorderPainted(false);
            mainBtn[i].setFocusPainted(false);
            mainBtn[i].setMargin(new Insets(8,10,8,10));
            mainBtn[i].setBackground(Color.black);
            mainBtn[i].setForeground(Color.white);
            mainBtn[i].setFont(btnFont);
            btnPanel.add(mainBtn[i]);
        }
        this.add(btnPanel, BorderLayout.NORTH);

        title.setFont(new Font("맑은 고딕",Font.BOLD,48));
        title.setForeground(Color.black);

        mainPanel.setLayout(new CardLayout());

        titlePanel.setLayout(new GridBagLayout());
        titlePanel.add(title);
        mainPanel.add(titlePanel);

        insertTitle.setFont(subTitleFont);
        insertTitle.setForeground(Color.black);

        insertPanel.setLayout(new BorderLayout());
        insertPanel.add(insertTitlePanel, BorderLayout.NORTH);
        insertTitlePanel.add(insertTitle);
        insertPanel.add(insertDetailPanel, BorderLayout.CENTER);
        insertDetailPanel.setLayout(new BoxLayout(insertDetailPanel, BoxLayout.LINE_AXIS));
        for(int i = 0; i < 4; i++){
            insertComponentPanel[i] = new JPanel();
            insertTextField[i] = new JTextField(10);
            insertTextField[i].setFont(new Font("맑은 고딕", Font.PLAIN, 12));
            insertDetailLabel[i] = new JLabel();
            insertDetailLabel[i].setText(insertLabel[i]);
            insertDetailLabel[i].setFont(new Font("맑은 고딕",Font.BOLD, 12));
            insertComponentPanel[i].add(insertDetailLabel[i]);
            insertComponentPanel[i].add(insertTextField[i]);
            insertDetailPanel.add(insertComponentPanel[i]);
        }
        mainPanel.add(insertPanel);

        mainPanel.add(searchPanel);

        this.add(mainPanel, BorderLayout.CENTER);
    }

    private void eventHandler() {
        for(int i = 0; i < mainBtn.length; i++){
            mainBtn[i].addActionListener(this);
        }
    }

    public static void main(String[] args) {
        new StudentClient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("등록하기")){
            titlePanel.setVisible(false);
            insertPanel.setVisible(true);
            searchPanel.setVisible(false);
            selectBtn(0);
        }
        else if(e.getActionCommand().equals("조회하기")){
            titlePanel.setVisible(false);
            insertPanel.setVisible(false);
            searchPanel.setVisible(true);
            selectBtn(1);
        }
        else if(e.getActionCommand().equals("내보내기")){
            selectBtn(2);
        }
    }

    public void selectBtn(int idx) {
        for(int i = 0; i < mainBtn.length; i++){
            if(i == idx){
                mainBtn[i].setBackground(Color.black);
            } else {
                mainBtn[i].setBackground(Color.lightGray);
            }
        }
    }
}
