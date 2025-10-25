import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class clsprg1 extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set encodings
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        // ✅ Get parameters from HTML form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String event = request.getParameter("event");

        // ✅ Handle empty/null inputs gracefully
        if (name == null || name.trim().isEmpty()) name = "Not Provided";
        if (email == null || email.trim().isEmpty()) email = "Not Provided";
        if (phone == null || phone.trim().isEmpty()) phone = "Not Provided";
        if (event == null || event.trim().isEmpty()) event = "Not Selected";

        // ✅ Generate response HTML
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head><meta charset='UTF-8'>");
        out.println("<title>Momentology | Booking Confirmation 🌟</title>");
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
        out.println(".highlight {color:#fff176; font-weight:700;}");
        out.println(".info {margin-top:20px; text-align:left; font-size:1.1em; line-height:1.6;}");
        out.println(".info p {margin:8px 0;}");
        out.println(".btn {background-color:#fff8e1; color:#1c1c1c; padding:14px 30px; border:none; border-radius:10px;");
        out.println("cursor:pointer; font-weight:bold; font-size:1.1em; transition:0.4s; text-decoration:none; display:inline-block; margin-top:25px;}");
        out.println(".btn:hover {background-color:#fff176; transform:scale(1.08); box-shadow:0 0 20px rgba(255,255,255,0.5);}");
        out.println("</style></head><body>");

        // ✅ Floating emojis
        out.println("<div class='float' style='left:10%;animation-delay:0s;'>📸</div>");
        out.println("<div class='float' style='left:30%;animation-delay:2s;'>✨</div>");
        out.println("<div class='float' style='left:60%;animation-delay:4s;'>🎨</div>");
        out.println("<div class='float' style='left:80%;animation-delay:1s;'>💫</div>");

        // ✅ Main confirmation card
        out.println("<div class='card'>");
        out.println("<h2>Hey <span class='highlight'>" + escapeHtml(name) + "</span> 👋</h2>");
        out.println("<p>Welcome to <b>Momentology</b> — where every moment becomes a masterpiece 🎨✨</p>");
        out.println("<p>Here are the details we received from your booking:</p>");
        out.println("<div class='info'>");
        out.println("<p><strong>📧 Email:</strong> " + escapeHtml(email) + "</p>");
        out.println("<p><strong>📱 Phone:</strong> " + escapeHtml(phone) + "</p>");
        out.println("<p><strong>🎯 Service:</strong> " + escapeHtml(event) + "</p>");
        out.println("</div>");
        out.println("<a href='Sprgm1.html' class='btn'>← Back to Home</a>");
        out.println("</div>");

        out.println("</body></html>");
    }

    // ✅ For GET requests (redirect to POST logic)
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    // ✅ Helper: escape special HTML characters to prevent injection
    private String escapeHtml(String text) {
        if (text == null) return "";
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#x27;");
    }
}
