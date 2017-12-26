package cn.HSTLC.DB;

import cn.HSTLC.ToolConst.Const;

import java.sql.*;

public class DataBase {

    private Connection conn;

    /**
     * 数据库连接获取方法
     * @return true成功 false失败
     */
    public boolean getConnection(){
        try {
            Class.forName(Const.dbDriver);          //装载数据库驱动
            conn = DriverManager.getConnection(Const.url,Const.usr,Const.passwd);   //连接数据库
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 数据库参数修改方法
     * @param url 连接
     * @param usr 用户
     * @param passwd 密码
     */
    public void dbConfig(String url,String usr,String passwd){
        Const.passwd = passwd;
        Const.url = url;
        Const.usr = usr;
    }

    /**
     * 查询全部信息的方法，使用前请先检测返回值是否为空
     * @return ResultSet数据集
     * @throws SQLException
     */
    public ResultSet infoRead(String where) throws SQLException {
        ResultSet rs = null;
        if(!conn.isClosed()){   //检测数据库连接
            Statement statement = conn.createStatement();
            if(where.equals("")){
                statement.execute("select * from "+Const.dbTableName+";");
            }else {
                statement.execute("select * from "+Const.dbTableName+" where ");
            }

            rs = statement.getResultSet();
        }
        return rs;
    }

    /**
     * 执行数据库除查询外的语句
     * @param sql
     * @return 语句执行影响的行数，-1为执行失败
     * @throws SQLException
     */
    public int infoOperate(String sql) throws SQLException {
        if (!conn.isClosed()){
            Statement statement = conn.createStatement();
            return statement.executeUpdate(sql);
        }else {
            return -1;
        }
    }

    /**
     * 关闭数据库连接方法
     * @return true成功 false失败
     */
    public boolean closeConnection(){
        try {
            if (!conn.isClosed()){
                conn.close();
                return true;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
