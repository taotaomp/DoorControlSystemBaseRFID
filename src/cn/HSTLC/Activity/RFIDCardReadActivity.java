package cn.HSTLC.Activity;

import cn.HSTLC.RFIDControl.CardRead;

public class RFIDCardReadActivity implements Runnable {

    public String getReadCardId() {
        return ReadCardId;
    }

    private String ReadCardId;

    @Override
    public void run() {
        while (true) {
            try {
                CardRead cardRead = new CardRead();
                cardRead.sendReadCardCmd();
                Thread.sleep(300);
                ReadCardId = cardRead.receiveCardMessage();
                Thread.sleep(300);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
