package servlet;

import bean.db.Db2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by t on 2017/1/8.
 */
public class PresonalChangeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,HTTPException{
        String sno=request.getParameter("sno");
        String index=request.getParameter("index");
        String newcontent=request.getParameter("newcontent");
        System.out.println("sno="+sno+"index="+index+"newcontent="+newcontent);
        String sname=null;

        String sql="update student_info set "+index+" = ? where sno=?";
        Db2 db2=new Db2();
        db2.connectMysql();
        if(index.equals("sname"))
        {
            String sql0="select * from student_info where sno=?";
            ResultSet rs=db2.query(sql0,sno);
            try {
                while (rs.next())
                {
                    sname=rs.getString("sname");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String sql00="update user set name=? where name=?";
            db2.update(sql00,newcontent,sname);
        }

        db2.update(sql,newcontent,sno);
        db2.closeDb2();
    }
}
