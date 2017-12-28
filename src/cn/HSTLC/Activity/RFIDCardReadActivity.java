package cn.HSTLC.Activity;

import cn.HSTLC.RFIDControl.CardRead;

public class RFIDCardReadActivity implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                System.out.println("Rfid活动运行中");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                if (!MainActivity.mainFrameIsClickRunButton) {
                    synchronized (MainActivity.readCardID_From_RFIDCardReadActivity){
                        System.out.println("Rfid活动停止");
                        MainActivity.RFIDCardReadActivityIsWait = true;
                        MainActivity.readCardID_From_RFIDCardReadActivity.wait();
                    }
                }
                CardRead cardRead = new CardRead();
                cardRead.sendReadCardCmd();
                Thread.sleep(300);
                MainActivity.readCardID_From_RFIDCardReadActivity = cardRead.receiveCardMessage();
                Thread.sleep(300);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
