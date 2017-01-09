package bean.db;

import java.sql.*;

public class DB
{
    Connection conn=null;
    ResultSet rs=null;
    Statement stat=null;
    public void connectMySQL(){
        String url="jdbc:mysql://localhost:3306/drivingschool?&characterEncoding=UTF-8";
        String user="root";
        String password="root";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
            System.out.println("连接数据库服务器成功");
            stat=conn.createStatement();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void creatStatement(){

        try {
            stat=conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void closeStatement(){
        try {
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //query()通过调用executeQuery(sql)来执行SELECT语句

    public ResultSet query(String sql) throws SQLException{
        if (sql==null||sql.equals(""))
        {
            return null;
        }
         rs=stat.executeQuery(sql);
        return rs;
    }
    //update()方法通过调用executeUpdate(sql)来执行INSERT,UPDATE,DELETE语句
    public int update(String sql) throws SQLException{
        int i;
        if (sql==null||sql.equals("")){
            return 0;
        }
        i=stat.executeUpdate(sql);
        return i;
    }
    //可以执行以上四种方法，返回值为TRUE或FALSE
    public ResultSet excute(String sql) throws SQLException{
        boolean t;
        if (sql==null||sql.equals("")){
            return null;
        }
        //如果t为true,则其执行了SELECT方法
        t=stat.execute(sql);
        if (t)
        {
            rs=stat.getResultSet();
            return rs;
        }
        //如果t为false，则其执行了UPDATE,DELETE或INSERT
        else {
            int i=stat.getUpdateCount();
            System.out.println("更新的记录数是"+i);
            return null;
        }
    }
    public void closeDB() throws SQLException{
        if (rs!=null)
        {
            rs.close();
            stat=null;
        }
        if (conn!=null)
        {
            conn.close();
            conn=null;
        }
    }
}