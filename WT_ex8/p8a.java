
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p8a extends HttpServlet {

    public synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        ServletContext context = getServletContext();
        HttpSession session = request.getSession(true);

        // ✅ Retrieve global counter from ServletContext
        Integer totalVisitors = (Integer) context.getAttribute("totalVisitors");
        if (totalVisitors == null) {
            totalVisitors = 0;
        }

        // ✅ Check if user has already been counted in this session
        Boolean counted = (Boolean) session.getAttribute("counted");
        if (counted == null || !counted) {
            totalVisitors++;
            context.setAttribute("totalVisitors", totalVisitors);
            session.setAttribute("counted", true);
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Momentology Visitor Counter</title>");
        out.println("<style>");
        out.println("*{margin:0;padding:0;box-sizing:border-box;}body{font-family:'Poppins',sans-serif;background:radial-gradient(circle at top,#0f0f0f,#000);color:#fff;display:flex;justify-content:center;align-items:center;min-height:100vh;overflow:hidden;}");
        out.println(".glow{background:rgba(255,255,255,0.08);padding:50px 60px;border-radius:30px;text-align:center;backdrop-filter:blur(20px);border:1px solid rgba(255,255,255,0.2);box-shadow:0 0 50px rgba(255,0,100,0.2);}");
        out.println("h1{font-size:2.4em;background:linear-gradient(90deg,#ffae00,#ff0066);-webkit-background-clip:text;-webkit-text-fill-color:transparent;margin-bottom:10px;}");
        out.println(".count-box{margin-top:30px;background:rgba(255,255,255,0.1);border-radius:15px;padding:25px 20px;border:1px solid rgba(255,255,255,0.2);}");
        out.println(".count{font-size:3.5em;color:#ffae00;text-shadow:0 0 20px #ff0066;font-weight:bold;}");
        out.println(".tag{color:#ccc;font-style:italic;margin-top:15px;font-size:1.1em;}");
        out.println("a{display:inline-block;margin-top:30px;padding:14px 35px;background:linear-gradient(135deg,#ffae00,#ff0066);color:#fff;text-decoration:none;border-radius:30px;font-weight:bold;transition:0.3s;}a:hover{transform:scale(1.05);}");
        out.println("</style></head><body>");
        out.println("<div class='glow'>");
        out.println("<h1>Momentology Studio</h1>");
        out.println("<p>Total visitors (all users):</p>");
        out.println("<div class='count-box'><div class='count'>" + totalVisitors + "</div><p class='tag'>Unique Visitors</p></div>");
        out.println("<a href='p8b.html'>View My Personal Stats ➡️</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
