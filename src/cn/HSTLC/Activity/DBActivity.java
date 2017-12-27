package cn.HSTLC.Activity;

import cn.HSTLC.DB.StaffBase;
import cn.HSTLC.ToolConst.Const;

import java.sql.SQLException;

public class DBActivity implements Runnable {
    private StaffBase staffBase;

    private String cardID;
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    private String staffInfo = "";
    public String getStaffInfo() {
        return staffInfo;
    }

    public DBActivity() {
        staffBase = new StaffBase();      //设置员工数据库实例
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (staffBase.checkStaff(cardID)) {
                    staffInfo = staffBase.staffInfoPack(cardID);
                }else{
                    staffInfo = Const.NoResult;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
