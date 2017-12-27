package cn.HSTLC.DB;

import cn.HSTLC.ToolConst.Const;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffBase {

    private ResultSet staffContainer;
    private DataBase dataBase;

    /**
     * 构造员工数据库实例，构造同时自动检测数据库连接
     */
    public StaffBase(){
        dataBase = new DataBase();
        try {
            staffContainer = dataBase.infoRead("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 检查卡号是否在数据库中
     * @param cardID
     * @return true:在 false:不在
     * @throws SQLException
     */
    public boolean checkStaff(String cardID) throws SQLException {
        while (staffContainer.next()){
            String cardIDTemp= staffContainer.getString(DBColumn.CardID.toString());
            if(cardID.equals(cardIDTemp)){
                return true;
            }
        }
        return false;
    }

    /**
     * 封装读到的员工信息
     * @param cardID
     * @return 员工信息，各项用‘#’分隔 如失败则返回NaN
     */
    public String staffInfoPack(String cardID) throws SQLException {
        ResultSet resultSet = dataBase.infoRead(cardID);
        StringBuffer temp = new StringBuffer();
        if(resultSet.next()) {
            temp.append(
                     resultSet.getString(DBColumn.Name.toString())+'#'
                    +resultSet.getString(DBColumn.Sex.toString())+'#'
                    +resultSet.getString(DBColumn.JobNum.toString())+'#'
                    +resultSet.getString(DBColumn.Department.toString())+'#'
                    +resultSet.getString(DBColumn.Position.toString())+'#'
                    +resultSet.getString(DBColumn.CardID.toString())+'#'
                    +resultSet.getString(DBColumn.Date.toString())
            );
            return temp.toString();
        }
        else {
            return "NaN";
        }
    }

    /**
     * 储存员工信息的方法
     * @param staffInfo 封装好的员工信息
     * @return true:成功 false:不成功
     * @throws SQLException
     */
    public boolean staffInfoReleaseStore(String staffInfo) throws SQLException {
        String[] staffInfoPart = staffInfo.split("#");
        String sql = "insert into "+ Const.dbTableName + " values("+
                "\'"+ staffInfoPart[0] +"\'"+
                "\'"+ staffInfoPart[1] +"\'"+
                "\'"+ staffInfoPart[2] +"\'"+
                "\'"+ staffInfoPart[3] +"\'"+
                "\'"+ staffInfoPart[4] +"\'"+
                "\'"+ staffInfoPart[5] +"\'"+
                "\'"+ staffInfoPart[6] +"\'"+
                ");";
        if (dataBase.infoOperate(sql)>0) {
            return true;
        }else {
            return false;
        }
    }

}
