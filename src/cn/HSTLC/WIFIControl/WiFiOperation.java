package cn.HSTLC.WIFIControl;

import cn.HSTLC.ToolConst.Const;
import cn.HSTLC.ToolConst.HexStrConvert;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class WiFiOperation {

    /**
     * 套接字命令发送方法
     * @param cmd 命令字符串
     * @param socket 套接字实例
     * @return true：成功 false：失败
     */
    public static boolean commandSender(String cmd, Socket socket){
        byte[] bytes = HexStrConvert.hexStringToByte(cmd);
        try {
            OutputStream os = socket.getOutputStream();
            os.write(bytes);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 套接字数据接收方法
     * @param socket 套接字实例
     * @return NaN：接收失败 否则成功
     */
    public static String messageReceiver(Socket socket){
        byte[] bytes;
        try {
            InputStream is = socket.getInputStream();
            bytes = new byte[is.available()];
            is.read(bytes);
            return HexStrConvert.bytesToHexString(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
            return Const.NoResult;
        }

    }
}
