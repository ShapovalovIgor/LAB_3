package searchServlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Пользователь on 30.03.2015.
 */
public class FirstSearchServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String selectTable = req.getParameter("selectTable");
        String button_1 = req.getParameter("submit_1");
        String button_2 = req.getParameter("submit_2");
        req.setAttribute("table", selectTable);

        HttpSession session = req.getSession();
        session.setAttribute("table", selectTable);

        if(button_1 != null)
        {
            session.setAttribute("submit", button_1);
            req.getRequestDispatcher("searchPages/secondSearchPage.jsp").forward(req, resp);
        }
        else if(button_2 != null)
        {
            session.setAttribute("submit", button_2);
            req.getRequestDispatcher("searchPages/threeSearchPage.jsp").forward(req,resp);
        }
    }
}
