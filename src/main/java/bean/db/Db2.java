package bean.db;

import java.sql.*;

/**
 * Created by t on 2017/1/6.
 */
public class Db2 {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    public void connectMysql(){
        String user="root";
        String password="root";
        String url="jdbc:mysql://localhost:3306/drivingschool?characterEncoding=UTF-8";
        String driver="com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
            System.out.println("连接数据库成功！");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet query(String sql){

        try {
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet query(String sql, Object index1){
        try {
            pst = conn.prepareStatement(sql);
            pst.setObject(1,index1);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet query(String sql,String index1,String index2){
        try {
            pst =conn.prepareStatement(sql);
            pst.setObject(1,index1);
            pst.setObject(2,index2);
            rs=pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet query(String sql,String index1,String index2,String index3){
        try {
            pst=conn.prepareStatement(sql);
            pst.setObject(1,index1);
            pst.setObject(2,index2);
            pst.setObject(3,index3);
            rs=pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public int update(String sql,String index1,String index2,String index3,String index4,String index5,String index6,String index7,String index8,String index9,String index10,String index11){
        int t=0;
        try {
            pst=conn.prepareStatement(sql);
            pst.setObject(1,index1);
            pst.setObject(2,index2);
            pst.setObject(3,index3);
            pst.setObject(4,index4);
            pst.setObject(5,index5);
            pst.setObject(6,index6);
            pst.setObject(7,index7);
            pst.setObject(8,index8);
            pst.setObject(9,index9);
            pst.setObject(10,index10);
            pst.setObject(11,index11);
            t=pst.executeUpdate();
            System.out.println("更新了"+t+"条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public int update(String sql){
        int t=0;
        try {
            pst=conn.prepareStatement(sql);
            t=pst.executeUpdate();
            System.out.println("更新了"+t+"条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public int update(String sql, Object index1){
        int t=0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setObject(1,index1);
            t = pst.executeUpdate();
            System.out.println("更新了"+t+"条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public int update(String sql,String index1,String index2){
        int t=0;
        try {
            pst =conn.prepareStatement(sql);
            pst.setObject(1,index1);
            pst.setObject(2,index2);
            t=pst.executeUpdate();
            System.out.println("更新了"+t+"条数据");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public int update(String sql,String index1,String index2,String index3){
        int t=0;
        try {
            pst=conn.prepareStatement(sql);
            pst.setObject(1,index1);
            pst.setObject(2,index2);
            pst.setObject(3,index3);
            t=pst.executeUpdate();
            System.out.println("更新了"+t+"条数据");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;

    }
    public void closeDb2()
    {
        try {
            if (rs!=null)
            {
                rs.close();

            }
            if (conn!=null)
            {
                conn.close();
                conn=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
