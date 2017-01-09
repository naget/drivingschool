package servlet;

import bean.db.Db2;
import bean.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by t on 2017/1/8.
 */
public class PersonalInfoServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws HTTPException,IOException {
        String name = request.getAttribute("name").toString();
        Db2 db2 = new Db2();
        db2.connectMysql();
        Student student=new Student();
        String sql="select * from student_info where sname = ?";
        ResultSet rs=db2.query(sql,name);
        try {
            while (rs.next())
            {
                student.setSname(rs.getString("sname"));
                student.setText(rs.getString("s_text"));
                student.setScondition(rs.getString("scondition"));
                student.setTel(rs.getString("tel"));
                student.setSno(Integer.valueOf(rs.getString("sno")));
                student.setAge(Integer.valueOf(rs.getString("age")));
                student.setCarType(rs.getString("car_type"));
                student.setIdentify(rs.getString("identify"));
                student.setEnrollTime(Date.valueOf(rs.getString("enroll_time")));
                student.setSex(rs.getString("sex"));
                request.setAttribute("studentInfo",student);


            }
            request.getRequestDispatcher("jsp/user.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
