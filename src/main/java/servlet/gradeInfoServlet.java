package servlet;

import bean.db.DB;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.net.URLDecoder.decode;

/**
 * Created by t on 2017/1/5.
 */
public class gradeInfoServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,HTTPException
    {
        if (request.getParameter("Event").equals("gradeChange"))
        {

            String name=decode(request.getParameter("name"),"UTF-8");
            String finalname="\""+name+"\"";
//            String finalname=name;
            String grade=request.getParameter("grade");
            String cno=request.getParameter("con");
//            System.out.println(name+grade+cno);
            DB db=new DB();
            db.connectMySQL();
            String sql1="select * from student_info where sname = "+finalname+" ";
            try {
                ResultSet rs1=db.query(sql1);
                while (rs1.next())
                {
                    String sno=rs1.getString("sno");
                    String sql2="update  grade_info set grade="+grade+" where sno="+sno+" and cno="+cno;
                    db.creatStatement();
                    db.update(sql2);
                    db.closeStatement();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    db.closeDB();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
