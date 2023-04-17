package kb.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login", "/logout"}, loadOnStartup = 1,
    initParams = {
        @WebInitParam(name = "id", value = "hee"),
        @WebInitParam(name = "pwd", value = "1234")
    } // 환경설정으로 전달된다
)
public class LoginCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String dbId, dbPwd; // DB 대신 사용할 변수

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 서버가 시작되면서 loginCheckServlet이 생성될 때 자동으로 딱 한 번 호출된다
        dbId = config.getInitParameter("id"); // 멤버 필드에 저장
        dbPwd = config.getInitParameter("pwd");
        System.out.print("dbId = " + dbId);
        System.out.println(", dbPwd = " + dbPwd); // id, pwd가 고정값이 된다
    }

    // 로그인의 경우
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("로그인되었습니다.");
        // post 방식 인코딩 설정
        req.setCharacterEncoding("UTF-8");

        // 파라미터로 전송되는 데이터 3개 받기
        String userId = req.getParameter("userId"); // ID의 name
        String userPwd = req.getParameter("userPwd");
        String userName = req.getParameter("userName");

        // (userId.equals(dbId) && userPwd.equals(userId)) : 아래 코드가 훨씬 좋다!
        // dbId는 내가 직접 지정한 값이기 때문에 절대로 null일 수 없다.
        // 근데 userId, userPwd는 사용자로부터 넘어오는 값이기 때문에 공백일 수 있다
        // 사용자로부터 넘어오는 값은 사용자가 어떤 값을 넣어 보낼 수 없기 때문에 안정적이지 않음
        // - nullpointerException이 날 여지가 있음
        if(dbId.equals(userId) && dbPwd.equals(userPwd)){
            // 성공 - 정보를 저장하고 ok.jsp로 이동
            // 전달할 정보가 많기 때문에 Customer 객체를 만들어 담아 전달
            Customer customer = new Customer(userName, 20, "선릉역", "111-2222"); // 나중에는 DB에서 전달받을 것

            // customer 가지고 이동
            // getParameter는 무조건 String밖에 못 받는데 지금은 Object를 보내야 하는 상황
            // request.set... 에 저장
            req.setAttribute("cu", customer); // request가 유지되는 동안 사용 가능하다
            req.getRequestDispatcher("LoginOk.jsp").forward(req, resp); // ok.jsp로 간다

        } else {
            // 실패 - 오류 메시지 출력 후 폼으로 이동
            resp.sendRedirect("LoginForm.html"); // 반환할 값이 없기 때문에 sendRedirect
        }
    }

    // 로그아웃의 경우
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("로그아웃되었습니다.");
    }


}
