package main.java.com.weifeng.test.mySqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select *from alligator_tm_user";// SQL���
        db1 = new DBHelper(sql);// ����DBHelper����

        try {
            ret = db1.pst.executeQuery();// ִ����䣬�õ������
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
            } // ��ʾ����
            ret.close();
            db1.close();// �ر�����
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
