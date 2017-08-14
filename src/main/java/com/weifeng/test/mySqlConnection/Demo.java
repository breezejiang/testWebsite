package main.java.com.weifeng.test.mySqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select *from alligator_tm_user";// SQL语句
        db1 = new DBHelper(sql);// 创建DBHelper对象

        try {
            ret = db1.pst.executeQuery();// 执行语句，得到结果集
            while (ret.next()) {
                String uid = ret.getString(1);
                String uaccount = ret.getString(2);
                String upwd = ret.getString(3);
                String uemail = ret.getString(4);
                String ucreateDate = ret.getString(5);
                String ucreator = ret.getString(6);
                String uupdateDate = ret.getString(7);
                String uupdator = ret.getString(8);
                String ueable = ret.getString(9);
                System.out.println(uid + "\t" + uaccount + "\t" + upwd + "\t" + uemail + "\t" + ucreateDate + "\t" + ucreator + "\t" + uupdateDate
                        + "\t" + uupdator + "\t" + ueable);
            } // 显示数据
            ret.close();
            db1.close();// 关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
