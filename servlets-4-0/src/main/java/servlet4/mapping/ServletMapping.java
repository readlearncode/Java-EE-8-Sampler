package servlet4.mapping;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
@WebServlet({"/path/", "/path/to/*", "*.ext", "/path/file.ext"})
public class ServletMapping extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpServletMapping servletMapping = request.getHttpServletMapping();
        response.getWriter()
                .append("<html><body>")
                .append("Value Matched: <b>").append(servletMapping.getMatchValue())
                .append("</b><br/>")
                .append("Pattern Used: <b>").append(servletMapping.getPattern())
                .append("</b><br/>")
                .append("Mapping Matched: <b>").append(servletMapping.getMappingMatch().name())
                .append("</b><br/>")
                .append("Servlet Name: <b>").append(servletMapping.getServletName())
                .append("</b><br/>")
                .append("</body></html>");
    }
}