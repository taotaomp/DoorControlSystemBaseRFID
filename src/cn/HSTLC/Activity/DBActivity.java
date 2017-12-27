package cn.HSTLC.Activity;

import cn.HSTLC.DB.StaffBase;
import cn.HSTLC.ToolConst.Const;

import java.sql.SQLException;

public class DBActivity implements Runnable {

    private String tempCardIDToAvoidDBExecuteRepeat = Const.NoResult;      //创建临时储存卡号的字符串，作为避免数据库重复读取的重要判断标志
    private StaffBase staffBase;

    public DBActivity() {
        staffBase = new StaffBase();      //设置员工数据库实例
    }

    @Override
    public void run() {
        while (true) {
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!tempCardIDToAvoidDBExecuteRepeat.equals(MainActivity.readCardID_From_RFIDCardReadActivity)) {
                    tempCardIDToAvoidDBExecuteRepeat = MainActivity.readCardID_From_RFIDCardReadActivity;
                    break;
                }
            }
            try {
                if (staffBase.checkStaff(tempCardIDToAvoidDBExecuteRepeat)) {
                    MainActivity.staffInfo_From_DBActivity = staffBase.staffInfoPack(tempCardIDToAvoidDBExecuteRepeat);
                } else {
                    MainActivity.staffInfo_From_DBActivity = Const.NoResult;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

