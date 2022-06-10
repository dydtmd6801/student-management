package Project.studentGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Search {
    private JPanel searchPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    
    private JButton[] searchBtn = new JButton[6];
    private String[] searchBtnText = {"전체조회","수정하기","삭제하기","부가기능","파일관리","돌아가기"};
    
    private JTextArea systemMsg = new JTextArea("테스트");
    
    private JLabel people = new JLabel();
    private JLabel school = new JLabel();

    private Font textFont = new Font("한컴 고딕", Font.BOLD, 12);

    private String[] tableHeader = {"학번","이름","과목","점수"};

    private DefaultTableModel tableModel = new DefaultTableModel(tableHeader, 0);
    private JTable table = new JTable(tableModel);
    private JScrollPane scroll = new JScrollPane(table);

    private int posY = 20;
    
    private void searchDesign(){
        searchPanel.setLayout(null);
        searchPanel.setBounds(0,0,500,430);
        searchPanel.setBackground(new Color(12,18,44,243));
        searchPanel.setOpaque(true);
        searchPanel.add(centerPanel);
        centerPanel.setBounds(55,40,380,320);
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.white);
        people.setFont(textFont);
        people.setBounds(20, 20, 80, 30);
        centerPanel.add(people);
        school.setFont(textFont);
        school.setBounds(100, 20, 150, 30);
        centerPanel.add(school);
        table.getTableHeader().setFont(textFont);
        table.setEnabled(false);
        table.setFont(textFont);
        table.setAutoCreateRowSorter(true);
        scroll.setBounds(20, 60, 250, 190);
        centerPanel.add(scroll);
        systemMsg.setBackground(Color.lightGray);
        systemMsg.setFont(textFont);
        systemMsg.setBounds(20,270,250,30);
        centerPanel.add(systemMsg);
        for(int i = 0; i < searchBtn.length; i++){
            searchBtn[i] = new JButton(searchBtnText[i]);
            searchBtn[i].setBounds(290,posY,70,30);
            posY += 50;
            searchBtn[i].setFont(new Font("한컴 고딕", Font.PLAIN, 9));
            searchBtn[i].setFocusPainted(false);
            searchBtn[i].setBorderPainted(false);
            searchBtn[i].setBackground(new Color(12,18,44,243));
            searchBtn[i].setOpaque(true);
            searchBtn[i].setForeground(Color.white);
            centerPanel.add(searchBtn[i]);
        }
        searchBtn[2].setEnabled(false);
    }

    public JPanel getSearchPanel() {
        searchDesign();
        return searchPanel;
    }

    public JButton[] getSearchBtn() {
        return searchBtn;
    }

    public JLabel getSchool() {
        return school;
    }

    public JLabel getPeople() {
        return people;
    }

    public void setTableModel(String[][] studentData){
        tableModel.setNumRows(0);
        for(int i = 0; i < studentData.length; i++){
            tableModel.addRow(studentData[i]);
        }
    }

    public void setTextArea(String[] data){
        systemMsg.setText(data[1] + "의 평균 : "+ data[0]);
    }

    public JTable getTable(){
        return table;
    }

    public DefaultTableModel getTableModel(){
        return tableModel;
    }
}
