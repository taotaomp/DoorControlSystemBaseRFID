package cn.HSTLC.Activity;

import cn.HSTLC.ToolConst.Const;

public class MainActivity implements Runnable {

    //用于线程间传递消息的中间变量
    public static String readCardID_From_RFIDCardReadActivity = Const.NoResult;  //存放从RFID卡片读取活动中获取的卡号的容器，会被数据库活动读取
    public static String staffInfo_From_DBActivity = Const.NoResult;    //存放从数据库活动中获取的员工信息的容器，会被主窗体活动读取
    public static boolean mainFrameIsClickRunButton = false;    //存放从主窗体中获取的是否点击启动按钮的标志的容器，会被主（本）活动读取
    public static boolean RFIDCardReadActivityIsWait ;

    @Override
    public void run() {
        Thread mainFrame = new Thread(new MainFrameActivity());         //创建主窗体活动线程实例
        Thread DB = new Thread(new DBActivity());                       //创建数据库活动线程实例
        Thread RFIDCardRead = new Thread(new RFIDCardReadActivity());   //创建卡读取活动线程实例

        mainFrame.start();  //启动主窗体活动线程
        DB.start(); //启动数据库活动线程


        while (true) {   //循环执行两项监听
            //监听用户是否点击运行
            while (true) {
                try {
                    Thread.sleep(500);
                    if (mainFrameIsClickRunButton && !RFIDCardRead.isAlive()) {
                        synchronized (readCardID_From_RFIDCardReadActivity) {
                            RFIDCardRead.start();
                        }
                    }
                    if(mainFrameIsClickRunButton && RFIDCardReadActivityIsWait){
                        synchronized (readCardID_From_RFIDCardReadActivity){
                            readCardID_From_RFIDCardReadActivity.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread main = new Thread(new MainActivity());   //创建主活动线程实例
        main.start();   //启动主活动
    }

}
