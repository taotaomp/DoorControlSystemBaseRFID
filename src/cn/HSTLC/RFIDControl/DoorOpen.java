package cn.HSTLC.RFIDControl;

import cn.HSTLC.ToolConst.Const;
import cn.HSTLC.WIFIControl.WiFiCon;
import cn.HSTLC.WIFIControl.WiFiOperation;

import java.net.Socket;

public class DoorOpen {
    private Socket socket = new WiFiCon(Const.DoorIP).getSocket();

    /**
     * 发送开门命令
     * @return true：成功 false：失败
     */
    public boolean sendOpenDoorCmd(){
        return WiFiOperation.commandSender(Const.DoorOpenCmd,socket);
    }
}
