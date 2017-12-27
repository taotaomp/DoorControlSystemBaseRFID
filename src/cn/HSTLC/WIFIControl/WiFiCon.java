package cn.HSTLC.WIFIControl;

import cn.HSTLC.ToolConst.Const;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class WiFiCon {
    private Socket socket = null;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public WiFiCon(String IP){
        setSocket(new Socket());
        InetSocketAddress inetSocketAddress = new InetSocketAddress(IP,Const.GPort);
        try {
            socket.connect(inetSocketAddress,3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
