package kb.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HobbyCheckServlet extends HttpServlet {
    public HobbyCheckServlet(){
        System.out.println("Constructor of HobbyCheckServlet");
    }

    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
    } // 넘어온 값이 url에 표시된다

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");

    } // 값이 넘어오지만 눈에 보이지는 않는다*/

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // post 방식으로 전송되는 한글 인코딩 설정
        request.setCharacterEncoding("UTF-8");

        // 전송된 데이터 받기
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        // String hobby = request.getParameter("hobby");
        // 하나의 이름으로 값이 여러 개 전송될 때
        String[] hobbys = request.getParameterValues("hobby"); // return type : String[]
        
        // 브라우저로 출력
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head><title>Servlet 연습</title></head>");
        out.println("<body>");

        out.println("<h3>이름 : " + name + "</h3>");
        out.println("<h3>나이 : " + age + "</h3>");

        out.println("<h3>취미 : ");
        for(String h : hobbys){
            out.print(h + ", ");
        }
        out.println("</h3>");

        out.println("</body>");
        out.print("</html>");
    }
}
