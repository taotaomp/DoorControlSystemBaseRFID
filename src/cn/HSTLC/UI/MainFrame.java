package cn.HSTLC.UI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private JFrame mainFrame = new JFrame();
    private Container container = null;
    private JLabel label_name = new JLabel("姓名");
    private JLabel label_sex = new JLabel("性别");
    private JLabel label_jobNum = new JLabel("工号");
    private JLabel label_department = new JLabel("部门");
    private JLabel label_position = new JLabel("职位");
    private JLabel label_cardID = new JLabel("卡号");
    private JLabel label_date = new JLabel("入职日期");

    private JTextField text_name = new JTextField();
    private JTextField text_sex = new JTextField();
    private JTextField text_jobNum = new JTextField();
    private JTextField text_department = new JTextField();
    private JTextField text_position = new JTextField();
    private JTextField text_cardID = new JTextField();
    private JTextField text_date = new JTextField();

    public MainFrame() {
        container = mainFrame.getContentPane();
        frameSet();
        objectsPosition();
        setObjectsFont();
        objectsAdd();

    }

    private void objectsPosition(){
        label_name.setBounds(0,0,60,20);
        label_sex.setBounds(0,20,200,20);
        label_jobNum.setBounds(0,10,200,20);
        label_department.setBounds(0,10,200,20);
        label_position.setBounds(0,10,200,20);
        label_cardID.setBounds(0,10,200,20);
        label_date.setBounds(0,10,200,20);

        text_name.setBounds(0,0,200,20);
        text_sex.setBounds(0,0,200,20);
        text_jobNum.setBounds(0,0,200,20);
        text_department.setBounds(0,0,200,20);
        text_position.setBounds(0,0,200,20);
        text_cardID.setBounds(0,0,200,20);
        text_date.setBounds(0,0,200,20);
    }

    private void objectsAdd(){
        container.add(label_name);
        container.add(label_sex);
        container.add(label_jobNum);
        container.add(label_department);
        container.add(label_position);
        container.add(label_cardID);
        container.add(label_date);
    }

    private void frameSet(){
        mainFrame.setTitle("门禁控制系统");
        mainFrame.setVisible(true);
        mainFrame.setBounds(0,0,500,500);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void setObjectsVisiable(boolean bool){
        label_name.setVisible(bool);
        label_sex.setVisible(bool);
        label_jobNum.setVisible(bool);
        label_department.setVisible(bool);
        label_position.setVisible(bool);
        label_cardID.setVisible(bool);
        label_date.setVisible(bool);

        text_name.setVisible(bool);
        text_sex.setVisible(bool);
        text_jobNum.setVisible(bool);
        text_department.setVisible(bool);
        text_position.setVisible(bool);
        text_cardID.setVisible(bool);
        text_date.setVisible(bool);
    }

    private void setObjectsFont(){
        label_name.setFont(new Font("宋体",Font.PLAIN,20));
        label_sex.setFont(new Font("宋体",Font.PLAIN,20));
        label_jobNum.setFont(new Font("宋体",Font.PLAIN,20));
        label_department.setFont(new Font("宋体",Font.PLAIN,20));
        label_position.setFont(new Font("宋体",Font.PLAIN,20));
        label_cardID.setFont(new Font("宋体",Font.PLAIN,20));
        label_date.setFont(new Font("宋体",Font.PLAIN,20));

        text_name.setFont(new Font("宋体",Font.PLAIN,20));
        text_sex.setFont(new Font("宋体",Font.PLAIN,20));
        text_jobNum.setFont(new Font("宋体",Font.PLAIN,20));
        text_department.setFont(new Font("宋体",Font.PLAIN,20));
        text_position.setFont(new Font("宋体",Font.PLAIN,20));
        text_cardID.setFont(new Font("宋体",Font.PLAIN,20));
        text_date.setFont(new Font("宋体",Font.PLAIN,20));
    }
}
