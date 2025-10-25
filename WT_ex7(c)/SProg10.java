/* Momentology - Hidden Form Fields (Step 2) */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg10 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            // Ensure UTF-8 encoding
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();
            String n = request.getParameter("uname");

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Momentology | Step 3 ✨</title>");
            out.println("<style>");
            out.println("@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap');");
            out.println("body {font-family: 'Poppins', sans-serif; margin:0; color:white; text-align:center;");
            out.println("background: linear-gradient(135deg, #6b5bff, #ff6b6b, #ffb400, #1c1c1c); background-size:600% 600%;");
            out.println("animation: bgShift 10s ease infinite; overflow:hidden;}");
            out.println("@keyframes bgShift {0%{background-position:0% 50%;}50%{background-position:100% 50%;}100%{background-position:0% 50%;}}");
            out.println(".card {background:rgba(255,255,255,0.15); padding:50px 70px; border-radius:25px; margin-top:120px;");
            out.println("box-shadow:0 0 40px rgba(255,255,255,0.3); display:inline-block; backdrop-filter:blur(10px);}");
            out.println(".btn {background-color:#fff8e1; color:#1c1c1c; padding:14px 35px; border:none; border-radius:12px;");
            out.println("font-weight:bold; font-size:1.1em; margin-top:25px; cursor:pointer; transition:0.4s;}");
            out.println(".btn:hover {background-color:#fff176; transform:scale(1.08); box-shadow:0 0 20px rgba(255,255,255,0.6);}");
            out.println(".float {position:absolute; font-size:2em; opacity:0.5; animation: floatUp 9s linear infinite;}");
            out.println("@keyframes floatUp {0%{transform:translateY(100vh) rotate(0deg);}100%{transform:translateY(-10vh) rotate(360deg);}}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            // floating symbols
            out.println("<div class='float' style='left:15%;animation-delay:0s;'>📷</div>");
            out.println("<div class='float' style='left:35%;animation-delay:3s;'>💫</div>");
            out.println("<div class='float' style='left:70%;animation-delay:1s;'>✨</div>");
            out.println("<div class='float' style='left:85%;animation-delay:5s;'>🎞️</div>");

            // main content
            out.println("<div class='card'>");
            out.println("<h2>Welcome back, " + n + " 🌈</h2>");
            out.println("<p>We’ve carried your name silently through our creative flow using hidden fields ✨</p>");
            out.println("<p>Now you’re ready to explore personalized photography & branding with <b>Momentology</b> 💫</p>");
            out.println("<button class='btn' onclick=\"alert('Your creative journey begins soon! 🎨📸✨')\">Get Inspired 🚀</button>");
            out.println("</div>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}