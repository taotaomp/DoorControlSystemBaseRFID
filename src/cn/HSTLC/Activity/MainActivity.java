package cn.HSTLC.Activity;

import cn.HSTLC.ToolConst.Const;

public class MainActivity implements Runnable{

    //用于线程间传递消息的中间变量
    public static String readCardID_From_RFIDCardReadActivity = Const.NoResult;  //存放从RFID卡片读取活动中获取的卡号的容器，会被数据库活动读取
    public static String staffInfo_From_DBActivity = Const.NoResult;    //存放从数据库活动中获取的员工信息的容器，会被主窗体活动读取
    public static boolean mainFrameIsClickRunButton = false;    //存放从主窗体中获取的是否点击启动按钮的标志的容器，会被主（本）活动读取

    @Override
    public void run() {
        Thread mainFrame = new Thread(new MainFrameActivity());         //创建主窗体活动线程实例
        Thread DB = new Thread(new DBActivity());                       //创建数据库活动线程实例
        Thread RFIDCardRead = new Thread(new RFIDCardReadActivity());   //创建卡读取活动线程实例

        mainFrame.start();  //启动主窗体活动线程

        while (true){   //循环执行两项监听
            while (true){   //监听用户是否点击运行
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (mainFrameIsClickRunButton) {
                    if (!DB.isAlive()) {    //判断线程是否处于活动状态,下同
                        DB.start();         //非活动则开始线程
                    }else {
                        DB.notify();        //活动则唤醒线程
                    }
                    if(!RFIDCardRead.isAlive()){
                        RFIDCardRead.start();
                    }else {
                        RFIDCardRead.notify();
                    }
                    break;
                }
            }
            while (true){   //监听用户是否点击停止
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (!mainFrameIsClickRunButton){
                    try {
                        synchronized (DB){
                            DB.wait();
                        }
                        synchronized (RFIDCardRead){
                            RFIDCardRead.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        Thread main = new Thread(new MainActivity());   //创建主活动线程实例
        main.start();   //启动主活动
    }

}
