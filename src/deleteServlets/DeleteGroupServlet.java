package deleteServlets;

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
public class DeleteGroupServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String group_id = req.getParameter("group_id");

        if(group_id != null)
        {
            try
            {
                ConnectDB.instance().deleteGroup(group_id);
                createPage("Группа удалилась!", resp);
            }
            catch (SQLException e)
            {
                createPage("Не удалось удалить группу", resp);
                e.printStackTrace();
            }
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
