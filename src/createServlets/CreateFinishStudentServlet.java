package createServlets;

import servlestDB.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Пользователь on 04.04.2015.
 */
public class CreateFinishStudentServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");
        String st_group_id = req.getParameter("group");

        try
        {
            ConnectDB.instance().createStudent(fname, lname, st_group_id);
            createPage("Студента добавили!", resp);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            createPage("Не удалось добавить студента", resp);
        }
    }

    private void createPage(String text, HttpServletResponse resp)
    {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;

        try
        {
            pw = new PrintWriter(resp.getWriter());
            pw.println(text);
            pw.println("<br>");
            pw.println("<a href=\"/top.jsp\">Назад</a>");
            pw.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if(pw != null)
            pw.close();
    }

}
