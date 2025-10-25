/* To set cookies for Momentology brand style */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg5 extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
        // Set encoding before getting writer
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter pwriter = response.getWriter();
        String stylePref = request.getParameter("style");
        
        // Save branding style in cookie
        Cookie c = new Cookie("BrandStyle", stylePref);      
        c.setMaxAge(60 * 60 * 24 * 30); // 30 days
        response.addCookie(c);
        
        // Styled HTML with better font support
        pwriter.println("<!DOCTYPE html>");
        pwriter.println("<html lang='en'>");
        pwriter.println("<head>");
        pwriter.println("<meta charset='UTF-8'>");
        pwriter.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        pwriter.println("<title>Momentology – Style Saved</title>");
        pwriter.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap' rel='stylesheet'>");
        pwriter.println("<style>");
        
        pwriter.println("* { box-sizing: border-box; }");
        pwriter.println("body { margin:0; font-family:'Poppins',Arial,sans-serif; background: linear-gradient(135deg,#0f0f0f,#1a1a1a,#2c2c2c); color:#f1f1f1; display:flex; justify-content:center; align-items:center; min-height:100vh; padding:20px; }");
        pwriter.println(".card { background: rgba(255,255,255,0.05); backdrop-filter: blur(10px); padding:40px; border-radius:20px; text-align:center; box-shadow:0 8px 25px rgba(0,0,0,0.4); width:100%; max-width:450px; animation: fadeIn 1s ease-in-out; border: 1px solid rgba(255,255,255,0.1); }");
        pwriter.println(".card h3 { font-size:1.8rem; color:#ffd369; margin-bottom:15px; font-weight:600; }");
        pwriter.println(".card p { font-size:1rem; color:#ddd; margin:10px 0; line-height:1.5; }");
        pwriter.println(".highlight { color:#ffb347; font-weight:bold; font-size:1.2rem; padding:10px; background:rgba(255,179,71,0.1); border-radius:8px; margin:15px 0; }");
        pwriter.println(".footer { margin-top:20px; font-size:0.85rem; color:#aaa; font-weight:300; }");
        pwriter.println(".icon { font-size:2rem; margin-bottom:10px; display:block; }");
        pwriter.println(".camera-icon { color:#ffd369; }");
        pwriter.println(".sparkle-icon { color:#ffb347; }");
        pwriter.println(".palette-icon { color:#ff6b6b; }");
        pwriter.println("@keyframes fadeIn { from {opacity:0; transform:translateY(-20px);} to {opacity:1; transform:translateY(0);} }");
        pwriter.println("@media (max-width: 480px) { .card { padding:30px 20px; } .card h3 { font-size:1.5rem; } }");
        pwriter.println("</style>");
        pwriter.println("</head>");
        pwriter.println("<body>");
        
        pwriter.println("<div class='card'>");
        pwriter.println("<span class='icon camera-icon'>&#128248;</span>"); // Camera emoji as HTML entity
        pwriter.println("<h3>Welcome to Momentology!</h3>");
        pwriter.println("<p>Your preferred photography & branding style has been saved as a cookie:</p>");
        pwriter.println("<div class='highlight'>");
        pwriter.println("<span class='sparkle-icon'>&#10024;</span> " + stylePref + " <span class='sparkle-icon'>&#10024;</span>");
        pwriter.println("</div>");
        pwriter.println("<p>We'll use this to personalize your visual branding journey <span class='palette-icon'>&#127912;</span></p>");
        pwriter.println("<div class='footer'>Momentology – Capturing Stories with Style</div>");
        pwriter.println("</div>");
        pwriter.println("</body>");
        pwriter.println("</html>");
        
        pwriter.close();
     } catch(Exception exp){
       System.out.println("Error in SProg5: " + exp.getMessage());
       exp.printStackTrace();
     }
   }
}