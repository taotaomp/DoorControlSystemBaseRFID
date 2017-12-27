package cn.HSTLC.UI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JFrame mainFrame = new JFrame();
    private Container container = null;

    private JLabel label_noCard = new JLabel("未获取到卡片信息");

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

    private JButton button_functionSwitch = new JButton("运行");     //开关

    /**
     * 构造方法，构造UI界面
     */
    public MainFrame() {
        container = mainFrame.getContentPane();         //设置Container实例
        frameSet();                                     //mainFrame窗体属性设置
        setObjectsPosition();                           //各控件位置设定
        setObjectsFont();                               //各控件字体设定
        controlTextsReadOnly(false);                //设置各text文本框内容不可手动更改
        objectsAdd();                                   //向container中添加各控件
    }

    /**
     * 设置各控件的位置
     */
    private void setObjectsPosition() {
        label_noCard.setBounds(mainFrame.getWidth()/2-150,mainFrame.getHeight()/2-50,300,100);

        label_name.setBounds(100, 80, 60, 30);
        label_sex.setBounds(100, 120, 60, 30);
        label_jobNum.setBounds(100, 160, 60, 30);
        label_department.setBounds(100, 200, 60, 30);
        label_position.setBounds(100, 240, 60, 30);
        label_cardID.setBounds(100, 280, 60, 30);
        label_date.setBounds(80, 320, 80, 30);

        text_name.setBounds(180, 80, 150, 30);
        text_sex.setBounds(180, 120, 150, 30);
        text_jobNum.setBounds(180, 160, 150, 30);
        text_department.setBounds(180, 200, 150, 30);
        text_position.setBounds(180, 240, 150, 30);
        text_cardID.setBounds(180, 280, 150, 30);
        text_date.setBounds(180, 320, 150, 30);

        button_functionSwitch.setBounds(360,200,90,45);
    }

    /**
     * 向container中添加各控件
     */
    private void objectsAdd() {
        container.add(label_noCard);

        container.add(label_name);
        container.add(label_sex);
        container.add(label_jobNum);
        container.add(label_department);
        container.add(label_position);
        container.add(label_cardID);
        container.add(label_date);

        container.add(text_name);
        container.add(text_sex);
        container.add(text_jobNum);
        container.add(text_department);
        container.add(text_position);
        container.add(text_cardID);
        container.add(text_date);

        container.add(button_functionSwitch);
    }

    /**
     * Frame窗体属性设置
     */
    private void frameSet() {
        mainFrame.setTitle("门禁控制系统");
        mainFrame.setVisible(true);
        mainFrame.setBounds(0, 0, 500, 500);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameStartLocationSet();
    }

    /**
     * 窗体初始位置设定
     */
    private void frameStartLocationSet() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = mainFrame.getSize();
        int x = screenSize.width / 2 - frameSize.width / 2;
        int y = screenSize.height / 2 - frameSize.height / 2;
        mainFrame.setLocation(x, y);
    }

    /**
     * 控制各控件显示与否的方法
     * @param bool true为显示，false为不显示
     */
    private void setObjectsVisiable(boolean bool) {
        label_noCard.setVisible(!bool);

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

    /**
     * 控制Text框是否为可手动更改方法
     * @param bool true为可，false为不可
     */
    private void controlTextsReadOnly(boolean bool){
        text_name.setEnabled(bool);
        text_sex.setEnabled(bool);
        text_jobNum.setEnabled(bool);
        text_department.setEnabled(bool);
        text_position.setEnabled(bool);
        text_cardID.setEnabled(false);      //卡号始终不可手动更改
        text_date.setEnabled(bool);
    }

    /**
     * 设置控件字体的方法
     */
    private void setObjectsFont() {
        label_noCard.setFont(new Font("宋体", Font.PLAIN, 24));

        label_name.setFont(new Font("宋体", Font.PLAIN, 20));
        label_sex.setFont(new Font("宋体", Font.PLAIN, 20));
        label_jobNum.setFont(new Font("宋体", Font.PLAIN, 20));
        label_department.setFont(new Font("宋体", Font.PLAIN, 20));
        label_position.setFont(new Font("宋体", Font.PLAIN, 20));
        label_cardID.setFont(new Font("宋体", Font.PLAIN, 20));
        label_date.setFont(new Font("宋体", Font.PLAIN, 20));

        text_name.setFont(new Font("宋体", Font.PLAIN, 20));
        text_sex.setFont(new Font("宋体", Font.PLAIN, 20));
        text_jobNum.setFont(new Font("宋体", Font.PLAIN, 20));
        text_department.setFont(new Font("宋体", Font.PLAIN, 20));
        text_position.setFont(new Font("宋体", Font.PLAIN, 20));
        text_cardID.setFont(new Font("宋体", Font.PLAIN, 20));
        text_date.setFont(new Font("宋体", Font.PLAIN, 20));

        button_functionSwitch.setFont(new Font("宋体", Font.PLAIN, 20));
    }

    /**
     * 设置文本框控件内容的方法
     * @param str 要显示的内容的打包字符串，以“#”分隔
     */
    private void setTextsContent(String str){
        String[] temp = str.split("#");
        text_name.setText(temp[0]);
        text_sex.setText(temp[1]);
        text_jobNum.setText(temp[2]);
        text_department.setText(temp[3]);
        text_position.setText(temp[4]);
        text_cardID.setText(temp[5]);
        text_date.setText(temp[6]);
    }

    /**
     * 无卡时显示的界面
     */
    public void noCardUI(){
        setObjectsVisiable(false);
        setTextsContent("");
    }

    /**
     * 有卡时显示的界面
     * @param info 要显示的内容的打包字符串，以“#”分隔
     */
    public void haveCardUI(String info){
        setObjectsVisiable(true);
        setTextsContent(info);
    }

}
