package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycleServlet extends HttpServlet {
    public LifeCycleServlet(){
        System.out.println("Constructor of LifeCycleServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("doGet");

        PrintWriter out = response.getWriter();
        out.println("<h1>LifeCycleServlet입니다</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
    }*/

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }
}
