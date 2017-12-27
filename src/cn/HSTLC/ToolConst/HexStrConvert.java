package cn.HSTLC.ToolConst;

public class HexStrConvert {
    /**
     * 将指定字符串src，以每两个字符分割转换为16进制形式
     * 如："2B 44 EF D9" --> byte[]{0x2B, 0x44, 0xEF, 0xD9}
     * @param src String
     * @return byte[]
     **/
    public static byte[] hexStringToByte(String src)  {
        src = src.replaceAll(" ", "");// 去掉空格
        byte[] ret = new byte[src.length() /2];
        byte[] tmp = src.getBytes();
        for(int i=0; i<src.length()/2; i++)  {
            ret[i] = uniteBytes(tmp[i*2], tmp[i*2+1]);
        }
        return ret;
    }

    /**
     * 将两个ASCII字符合成一个字节；
     * 如："EF"--> 0xEF
     * @param src0 byte
     * @param src1 byte
     * @return byte
     **/
    private static byte uniteBytes(byte src0, byte src1)  {
        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0})).byteValue();
        _b0 = (byte)(_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1})).byteValue();
        byte ret = (byte)(_b0 ^ _b1);
        return ret;
    }

    /**
     * 字节数组转换成十六进制字符串
     * 例如：0x1a 0x1c -> "1a1c"
     * @param bArray
     * @return HexString
     */
    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());//转成大写
            sb.append(" ");
        }
        return sb.toString();
    }
}
