
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class p8b extends HttpServlet {
    private Map<String, Integer> visitorCount = new HashMap<>();

    public synchronized void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        if (userName == null || userName.trim().isEmpty()) {
            userName = "Guest";
        }

        int count = visitorCount.getOrDefault(userName, 0) + 1;
        visitorCount.put(userName, count);

        // 🌈 Start HTML
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'><head>");
        out.println("<meta charset='UTF-8'><title>Momentology Studio Tracker</title>");
        out.println("<style>");
        out.println("*{margin:0;padding:0;box-sizing:border-box;font-family:'Poppins',sans-serif;}");
        out.println("body{height:100vh;display:flex;justify-content:center;align-items:center;overflow:hidden;position:relative;color:#fff;}");
        
        // Background slideshow
        out.println(".bg{position:absolute;top:0;left:0;width:100%;height:100%;background-size:cover;background-position:center;transition:opacity 1.5s ease-in-out;opacity:0;z-index:0;}");
        out.println(".bg.active{opacity:1;}");

        // Floating icons
        out.println(".float{position:absolute;font-size:2em;opacity:0.8;animation:float 6s ease-in-out infinite;}");
        out.println(".icon1{top:40px;left:40px;animation-delay:0s;}");
        out.println(".icon2{top:50%;right:50px;animation-delay:2s;}");
        out.println(".icon3{bottom:40px;left:60px;animation-delay:4s;}");
        out.println("@keyframes float{0%,100%{transform:translateY(0);}50%{transform:translateY(-15px);}}");

        // Glass card
        out.println(".card{z-index:2;background:rgba(255,255,255,0.15);border-radius:25px;padding:60px 70px;text-align:center;backdrop-filter:blur(10px);box-shadow:0 8px 40px rgba(0,0,0,0.4);animation:fadeIn 1.5s ease;}");
        out.println("@keyframes fadeIn{from{opacity:0;transform:scale(0.95);}to{opacity:1;transform:scale(1);}}");

        out.println("h1{font-size:2.3em;color:#00bcd4;text-shadow:0 0 15px rgba(0,188,212,0.8);margin-bottom:15px;}");
        out.println(".username{font-size:1.4em;font-weight:bold;color:#ffe57f;}");
        out.println(".counter{margin:25px 0;font-size:3em;color:#fff176;text-shadow:0 0 15px rgba(255,255,150,0.7);font-weight:bold;}");
        out.println(".message{font-size:1.1em;margin-bottom:20px;font-style:italic;color:#e3f2fd;}");

        // Animated progress bar
        out.println(".progress{width:100%;height:10px;background:rgba(255,255,255,0.3);border-radius:10px;overflow:hidden;margin-top:20px;}");
        out.println(".bar{height:100%;width:0;background:linear-gradient(90deg,#00bcd4,#2196f3,#82b1ff);animation:load 3s forwards;}");
        out.println("@keyframes load{from{width:0;}to{width:100%;}}");

        // Button
        out.println(".btn{display:inline-block;margin-top:35px;padding:14px 40px;background:linear-gradient(135deg,#00bcd4,#2196f3);border:none;border-radius:30px;color:white;text-decoration:none;font-weight:bold;font-size:1em;transition:all 0.3s ease;box-shadow:0 5px 25px rgba(33,150,243,0.5);}");
        out.println(".btn:hover{transform:scale(1.05);background:linear-gradient(135deg,#2196f3,#00bcd4);}");

        // Subtle flashes
        out.println(".flash{position:absolute;width:80px;height:80px;border-radius:50%;background:radial-gradient(circle,rgba(255,255,255,0.8) 10%,transparent 70%);animation:flash 6s ease-in-out infinite;pointer-events:none;}");
        out.println(".flash1{top:30%;left:25%;animation-delay:1s;}");
        out.println(".flash2{bottom:25%;right:30%;animation-delay:3s;}");
        out.println("@keyframes flash{0%,100%{opacity:0;}50%{opacity:1;}}");
        out.println("</style></head><body>");

        // Background slideshow images
        out.println("<div class='bg active' style=\"background-image:url('https://images.unsplash.com/photo-1526170375885-4d8ecf77b99f?auto=format&fit=crop&w=1600&q=80');\"></div>");
        out.println("<div class='bg' style=\"background-image:url('https://images.unsplash.com/photo-1519183071298-a2962be90b8e?auto=format&fit=crop&w=1600&q=80');\"></div>");
        out.println("<div class='bg' style=\"background-image:url('https://images.unsplash.com/photo-1508675801603-4f3e0d6e6b63?auto=format&fit=crop&w=1600&q=80');\"></div>");

        // Floating icons and light effects
        out.println("<div class='flash flash1'></div>");
        out.println("<div class='flash flash2'></div>");
        out.println("<div class='float icon1'>📸</div>");
        out.println("<div class='float icon2'>🎨</div>");
        out.println("<div class='float icon3'>💡</div>");

        // Card content
        out.println("<div class='card'>");
        out.println("<h1>Welcome to Momentology Studio</h1>");
        out.println("<div class='username'>Hi " + userName + "! 👋</div>");
        out.println("<div class='counter'>Visits: " + count + "</div>");

        String message;
        if (count == 1)
            message = "✨ Your first creative capture! Welcome to the gallery of imagination.";
        else if (count < 5)
            message = "🎬 You’re crafting your visual identity, one click at a time.";
        else if (count < 10)
            message = "🌈 Your artistic presence is growing brighter!";
        else
            message = "🏆 You’re now a star of Momentology — pure creative mastery!";

        out.println("<p class='message'>" + message + "</p>");
        out.println("<div class='progress'><div class='bar'></div></div>");
        out.println("<a href='/WT_4034/p8b.html' class='btn'>Return to Studio 🎞️</a>");
        out.println("</div>");

        // JS for background slideshow
        out.println("<script>");
        out.println("const bgs=document.querySelectorAll('.bg');let i=0;setInterval(()=>{bgs[i].classList.remove('active');i=(i+1)%bgs.length;bgs[i].classList.add('active');},7000);");
        out.println("</script>");

        out.println("</body></html>");
    }
}
