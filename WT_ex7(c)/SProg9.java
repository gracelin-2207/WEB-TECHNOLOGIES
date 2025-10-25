import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg9 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Ensure UTF-8 encoding before writing output
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();
            String n = request.getParameter("userName");

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Momentology | Step 2 🌟</title>");
            out.println("<style>");
            out.println("@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');");
            out.println("body {margin:0; font-family: 'Poppins', sans-serif; color:white; text-align:center;");
            out.println("background: linear-gradient(270deg, #ffb400, #ff6b6b, #6b5bff, #1c1c1c); background-size:800% 800%; animation: gradientFlow 10s ease infinite; overflow:hidden;}");
            out.println("@keyframes gradientFlow {0%{background-position:0% 50%;}50%{background-position:100% 50%;}100%{background-position:0% 50%;}}");
            out.println(".float {position:absolute; font-size:2em; opacity:0.4; animation: floatUp 8s linear infinite;}");
            out.println("@keyframes floatUp {0%{transform:translateY(100vh) rotate(0deg);}100%{transform:translateY(-10vh) rotate(360deg);}}");
            out.println(".card {background: rgba(255,255,255,0.15); padding:40px 60px; border-radius:25px;");
            out.println("box-shadow:0 0 40px rgba(255,255,255,0.3); display:inline-block; backdrop-filter: blur(12px); margin-top:100px;}");
            out.println("h2 {font-size:2em; margin-bottom:15px;}");
            out.println(".btn {background-color:#fff8e1; color:#1c1c1c; padding:14px 30px; border:none; border-radius:10px;");
            out.println("cursor:pointer; font-weight:bold; font-size:1.1em; transition:0.4s;}");
            out.println(".btn:hover {background-color:#fff176; transform:scale(1.08); box-shadow:0 0 20px rgba(255,255,255,0.5);}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            // floating emoji elements
            out.println("<div class='float' style='left:10%;animation-delay:0s;'>📸</div>");
            out.println("<div class='float' style='left:30%;animation-delay:2s;'>✨</div>");
            out.println("<div class='float' style='left:60%;animation-delay:4s;'>🎨</div>");
            out.println("<div class='float' style='left:80%;animation-delay:1s;'>💫</div>");

            // main card
            out.println("<div class='card'>");
            out.println("<h2>Hey " + n + " 👋</h2>");
            out.println("<p>Welcome to <b>Momentology</b> — where every moment becomes a masterpiece 🎨✨</p>");
            out.println("<p>We’ll remember your name secretly 🤫 using a hidden field as you move forward.</p>");
            out.println("<form action='SP10' method='POST'>");
            out.println("<input type='hidden' name='uname' value='" + n + "'>");
            out.println("<input type='submit' class='btn' value='Proceed to My Style Survey ➡️'>");
            out.println("</form>");
            out.println("</div>");

            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}