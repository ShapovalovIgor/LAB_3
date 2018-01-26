package updateServlets;

import servlestDB.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Пользователь on 05.04.2015.
 */
public class UpdateFinishGroupServlet extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String course = req.getParameter("course");

        if(id != "" && name != "" && course != "")
        {
            try
            {
                ConnectDB.instance().updateGroup(id, name, course);
                createPage("Группа обновилась!", resp);
            }
            catch (SQLException e)
            {
                createPage("Не удалось обновить группу", resp);
                e.printStackTrace();
            }
        }
        else
        {
            createPage("Не все поля заполнены", resp);
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
