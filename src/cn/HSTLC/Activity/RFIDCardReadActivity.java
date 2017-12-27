package cn.HSTLC.Activity;

import cn.HSTLC.RFIDControl.CardRead;

public class RFIDCardReadActivity implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
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
