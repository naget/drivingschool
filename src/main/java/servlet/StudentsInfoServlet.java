package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;

/**
 * Created by t on 2017/1/4.
 */
public class StudentsInfoServlet extends HttpServlet{

    @Override
    protected void doGet( HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse)throws HTTPException,IOException
    {
        httpServletResponse.sendRedirect("jsp/studentsInfo.jsp");
    }

}
