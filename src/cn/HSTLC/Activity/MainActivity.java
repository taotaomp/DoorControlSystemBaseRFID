package cn.HSTLC.Activity;

import cn.HSTLC.UI.MainFrame;

public class MainActivity implements Runnable{

    private String readCardID_From_RFIDCardReadActivity;

    @Override
    public void run() {
        Thread mainFrame = new Thread(new MainFrameActivity());
        mainFrame.start();

    }

    public static void main(String[] args){
        Thread main = new Thread(new MainActivity());
        main.start();

    }

}
