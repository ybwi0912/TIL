package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ParameterServlet extends HttpServlet {
    public ParameterServlet(){
        System.out.println("Constructor of ParameterServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println("doGet() of ParameterServlet");

        String job = req.getParameter("job");
        String pageNo = req.getParameter("pageNo");
        String searchWord = req.getParameter("searchWord");

        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.println("<body>");

        out.println("<h3>job : " + job + "</h3>");
        out.println("<h3>pageNo : " + pageNo + "</h3>");
        out.println("<h3>searchWord : " + searchWord + "</h3>");

        out.println("</body>");
        out.print("</html>");

        System.out.println("job : " + job);
        System.out.println("pageNo : " + pageNo);
        System.out.println("searchWord : " + searchWord);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        System.out.println("doPost() of ParameterServlet");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String[] hobby = req.getParameterValues("hobby");
        String[] favorite = req.getParameterValues("favorite");
        String desc = req.getParameter("desc");

        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.println("<body>");

        out.println("<h3>name : " + name + "</h3>");
        out.println("<h3>email : " + email + "</h3>");
        out.println("<h3>gender : " + gender + "</h3>");
        out.println("<h3>hobby : ");
        for(String h : hobby){
            out.print(h + " ");
        }
        out.println("</h3>");
        out.println("<h3>favorite : ");
        for(String f : favorite){
            out.print(f + " ");
        }
        out.println("</h3>");
        out.println("<h3>desc : " + desc + "</h3>");
        out.println("</body>");
        out.print("</html>");

        System.out.println("name : " + name);
        System.out.println("email : " + email);
        System.out.println("gender : " + gender);
        System.out.print("hobby : ");
        for(String h : hobby){
            System.out.print(h + " ");
        }
        System.out.println();
        System.out.print("favorite : ");
        for(String f : favorite){
            System.out.print(f + " ");
        }
        System.out.println();
        System.out.println("desc : " + desc);
    }

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
    }*/

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
