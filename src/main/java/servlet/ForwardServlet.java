package servlet;

import bean.db.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by t on 2016/12/27.
 */
public class ForwardServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB db = new DB();
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
//        name = "\""+name+"\"";
        String pwd = request.getParameter("pwd");
        if (name != null && pwd != null && !(name.equals("")) && !(pwd.equals(""))) ;
        {
            db.connectMySQL();
            String sql = "select * from user where name=" + name;
            try {
                ResultSet set = db.query(sql);

//                request.getSession().setAttribute("rs", set);//将结果集处理封装为JAVABEANE才是正确姿势

                if (set.next()) {

                    if (set.getString("name").equals(name) && set.getString("password").equals(pwd)) {
                        String role=set.getString("role");
                        request.setAttribute("name",set.getString("name"));
                        if (role.equals("1"))//user用户
                        {
                            request.getRequestDispatcher("/getPersonalGrade").forward(request, response);
                        }
                        else if (role.equals("2"))//管理员用户
                        {
                            request.getRequestDispatcher("jsp/admin.jsp").forward(request,response);
                        }
//                        String sql2="select * from grade_view where name="+name;
//                        ResultSet set2=db.query(sql2);

//                        response.sendRedirect("jsp/info.jsp");//resultset会关闭
                    }else{
                        response.sendRedirect("jsp/login.jsp");
                    }

                }else {
                    response.sendRedirect("jsp/error.jsp");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    db.closeDB();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
