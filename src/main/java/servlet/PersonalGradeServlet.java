package servlet;

import bean.db.Db2;
import bean.model.StudentGrade;

import javax.servlet.ServletException;
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
public class PersonalGradeServlet extends HttpServlet{
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,HTTPException{
    Db2 db2=new Db2();
    StudentGrade studentGrade=new StudentGrade();
    String sno=null;
    String name=request.getAttribute("name").toString();
    studentGrade.setName(name);
    db2.connectMysql();
    String sql1="select sno from student_info where sname=?";
    ResultSet rs1=db2.query(sql1,name);
    try {
        while (rs1.next())
        {
            sno=rs1.getString("sno");
        }
        String sql2="select * from grade_info where sno=?";
        ResultSet rs2=db2.query(sql2,sno);
        while (rs2.next())
        {
            int cno=Integer.valueOf(rs2.getString("cno"));
            switch (cno)
            {
                case 1:
                    studentGrade.setClassone(rs2.getString("grade"));
                    break;
                case 2:
                    studentGrade.setClasstwo(rs2.getString("grade"));
                    break;
                case 3:
                    studentGrade.setClassthree(rs2.getString("grade"));
                    break;
                case 4:
                    studentGrade.setClassfore(rs2.getString("grade"));
                    break;
            }
        }
        request.setAttribute("studentGrade",studentGrade);
        request.getRequestDispatcher("/getPersonalInfo").forward(request,response);
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ServletException e) {
        e.printStackTrace();
    }

}
}
