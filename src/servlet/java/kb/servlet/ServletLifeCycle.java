package kb.servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletLifeCycle extends HttpServlet{
    public ServletLifeCycle(){
        System.out.println("Constructor of ServletLifeCycle");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // 문서의 형태 | encoding 방식

        System.out.println("doGet");

        // 브라우저에 출력
        PrintWriter out = response.getWriter(); // 브라우저에 보내기 위한 출력 스트림
        out.print("<html>");
        out.print("<head><title>Servlet 연습</title></head>");
        out.println("<body>");

        out.println("<h1 style='color:red'>Servlet 첫 수업!</h1>");

        out.println("우와~"); // println을 쓰던가 아니면 세미콜론을 다 찍어줘야 된다.. 안 찍어주면 JS 쓸 때 오류 남..!

        out.println("</body>");
        out.print("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
