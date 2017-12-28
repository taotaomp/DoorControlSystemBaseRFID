package cn.HSTLC.ToolConst;

import java.sql.Connection;

public class Const {
    //数据库常量
    public static String url = "jdbc:mysql://localhost:3306/sys";
    public static String usr = "root";
    public static String passwd = "hu1song2tao3";
    public static final String dbDriver = "com.mysql.jdbc.Driver";
    public static String dbTableName = "rfiddoorcontrolsys";

    //Wifi常量
    public static String CardIP = "192.168.0.162";
    public static String DoorIP = "192.168.0.166";
    public static int GPort = 4001;

    //RFID常量
    public static String DoorOpenCmd = "0C 10 00 78 00 01 02 00 01 35 78";
    public static String CardReadCmd = "FFFF0A";
    public static String DoorDepartment = "";

    //其他常量
    public static final String NoResult= "NoResult";
}
