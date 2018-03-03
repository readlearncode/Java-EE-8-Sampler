package servlet4.pushbuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;
import java.io.IOException;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@WebServlet("/obtainpushbuilder")
public class ObtainPushBuilder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PushBuilder pushBuilder = request.newPushBuilder();

        if (pushBuilder != null) {
            pushBuilder.path("images/hero-banner.jpg").push();
            pushBuilder.path("css/menu.css").push();
            pushBuilder.path("js/marquee.js").push();
        }

        getServletContext().getRequestDispatcher("/duke.jsp").forward(request, response);

    }
}