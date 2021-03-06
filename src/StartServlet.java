import servlestDB.ConnectDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.sql.SQLException;

/**
 * Created by Пользователь on 17.03.2015.
 */
public class StartServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        String nextJSP = "/top.jsp";

        String login = req.getParameter("login").toString();
        String password = req.getParameter("password").toString();

        try
        {
            ConnectDB.instance().init(login, password);
            req.getRequestDispatcher(nextJSP).forward(req, resp);
        }
        catch (SQLException e)
        {
            String message = "Ошибка подключения к БД";
            printErrorPage(message, resp);
            e.printStackTrace();
        }
    }

    private void printErrorPage(String message, HttpServletResponse resp)
    {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw = null;

        try
        {
            pw = new PrintWriter(resp.getWriter());

            pw.println(message);
            pw.println("<br>");
            pw.println("<a href=\"index.jsp\">Назад</a>");
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
