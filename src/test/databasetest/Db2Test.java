import bean.db.Db2;
import org.junit.Test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by t on 2017/1/7.
 */
//@RunWith(Suite.class)
//@Suite.SuiteClasses({
//Db2.class ,Db2Test.class
//})
public class Db2Test {

    /**
     * 数据查询正常
     */
    @Test
    public void db2QueryTest() {
        Db2 db2 = new Db2();
        String name = "\"" + "田峰" + "\"";
        String sql = "select * from student_info where sname="+name;
        db2.connectMysql();

        ResultSet rs = db2.query(sql);

        try {
            while (rs.next()) {
                System.out.println(rs.getString("sname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db2.closeDb2();
        }
    }

    /**
     * 数据插入正常
     */
    @Test
    public void db2UpdateTest(){
        Db2 db2 = new Db2();
        db2.connectMysql();
//        String sql1="update student_info set sname= ? where sname = ?";
//        db2.update(sql1,"a","b");
        Date now = new Date(System.currentTimeMillis());
        String sql2="insert into student_info(sno,sname,sex,age,identify,tel,car_type,enroll_time,leave_time,scondition,s_text) values " +
                "(?,?,?,?,?,?,?,?,?,?,?)";
        db2.update(sql2,"666666","插入","男","26","6666666","66666666","小汽车",now.toString(),now.toString(),"学习"," ");
        db2.closeDb2();

    }


}
