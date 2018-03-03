package servlet4.hashtag100DaysOfJavaEE8;

/**
 * A simple POC use of the Server Push feature.
 *
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */


        /*
        Servlets 4.0 introduces support for HTTP/2 feature
        ServerPush. What happens when a request is made to the
        URI /duke over an insecure connection. i.e. over HTTP
        connection?
         */

//        @WebServlet("/duke")
//        public class ServerPushExample extends HttpServlet {
//            @Override
//            protected void doGet(HttpServletRequest request,
//                                 HttpServletResponse response)
//                    throws ServletException, IOException {
//
//                request.newPushBuilder()
//                        .path("resources/images/java-ee-logo.png")
//                        .push();
//
//                getServletContext()
//                        .getRequestDispatcher("/duke.jsp")
//                        .forward(request, response);
//            }
//        }



