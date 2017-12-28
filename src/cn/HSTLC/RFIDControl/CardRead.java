package cn.HSTLC.RFIDControl;

import cn.HSTLC.ToolConst.Const;
import cn.HSTLC.WIFIControl.WiFiCon;
import cn.HSTLC.WIFIControl.WiFiOperation;

import java.io.IOException;
import java.net.Socket;

public class CardRead {
    private Socket socket = new WiFiCon(Const.CardIP).getSocket();;

    /**
     * 发送读卡命令
     * @return true：成功 false：失败
     */
    public boolean sendReadCardCmd(){
        return WiFiOperation.commandSender(Const.CardReadCmd,socket);
    }

    /**
     * 接收返回的卡号信息
     * @return NoResult：接收失败 否则成功
     */
    public String receiveCardMessage(){
        return WiFiOperation.messageReceiver(socket);
    }

    /**
     * 释放socket连接
     * @throws IOException
     */
    public void releaseSocket() throws IOException {
        socket.close();
    }
}
