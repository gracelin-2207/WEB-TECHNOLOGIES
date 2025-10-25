/* Sessions -2*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg8 extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    try {
      res.setContentType("text/html; charset=UTF-8");
      PrintWriter out = res.getWriter();

      HttpSession session = req.getSession(false);
      String name = (session != null) ? (String) session.getAttribute("uname") : "Guest";
      String pass = (session != null) ? (String) session.getAttribute("upass") : "(none)";

      // Pink-toned background image hosted online
      //String bgUrl = "https://images.unsplash.com/photo-1520975910598-5b3c49eb6b6a?auto=format&fit=crop&w=1400&q=80";
      String bgUrl = "https://source.unsplash.com/1400x900/?pink,photography,studio";

      out.println("<!doctype html>");
      out.println("<html lang='en'>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'/>");
      out.println("<meta name='viewport' content='width=device-width,initial-scale=1'/>");
      out.println("<title>Momentology — Details</title>");
      out.println("<style>");
      out.println("  :root{--pink:#f48fb1;--deep:#4a148c;}");
      out.println("  html,body{height:100%;margin:0;font-family:Inter, Poppins, sans-serif;}");
      out.println("  body{background-image:url('https://source.unsplash.com/1600x900/?pink,photography,studio'); background-size:cover; background-position:center; background-attachment:fixed; display:flex; align-items:center; justify-content:center; color:var(--deep); height:100vh; margin:0;}");
      out.println("  .veil{position:fixed;inset:0;background:linear-gradient(rgba(255,255,255,0.62), rgba(255,245,247,0.48));backdrop-filter:blur(6px);}");
      out.println("  .overlay{position:fixed;inset:0;background:rgba(255,244,247,0.15);backdrop-filter: blur(2px);}");
      out.println("  .panel{position:relative;z-index:2;background:rgba(255,255,255,0.78);padding:46px;border-radius:18px;max-width:820px;width:86%;text-align:center;border:1px solid rgba(244,143,177,0.5);box-shadow:0 18px 50px rgba(76,0,92,0.14)}");
      out.println("  h1{margin:0 0 6px;color:var(--deep);font-size:30px;text-shadow:0 6px 18px rgba(244,143,177,0.12)}");
      out.println("  p{color:#6a1b9a;margin:8px 0;font-size:17px}");
      out.println("  .note{margin-top:18px;font-weight:600;color:#880e4f}");
      out.println("  .decor{margin-top:14px;display:flex;gap:14px;justify-content:center;align-items:center}");
      out.println("  .icon{font-size:28px;transform-origin:center;animation:swirl 9s linear infinite}");
      out.println("  @keyframes swirl{0%{transform:rotate(0)}100%{transform:rotate(360deg)}}");
      out.println("</style>");
      out.println("</head>");
      out.println("<body>");
      out.println("<div class='veil'></div>");
      out.println("<div class='panel'>");
      out.println("  <h1>\uD83C\uDF38 Hello, " + escapeHtml(name) + "!</h1>"); // 🌸
      out.println("  <p><strong>Username:</strong> " + escapeHtml(name) + "</p>");
      out.println("  <p><strong>Password:</strong> " + (pass==null? "(none)": escapeHtml(pass)) + "</p>");
      out.println("  <div class='note'>Thank you — your details are now part of the Momentology story. We’ll be in touch. \u2728</div>"); // ✨
      out.println("  <div class='decor'>");
      out.println("    <div class='icon' title='camera'>&#x1F4F8;</div>"); // 📸
      out.println("    <div class='icon' title='sparkles'>&#x2728;</div>"); // ✨
      out.println("    <div class='icon' title='heart'>&#x2764;&#xFE0F;</div>"); // ❤️
      out.println("  </div>");
      out.println("</div>");
      out.println("</body></html>");

      out.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private String escapeHtml(String s){
    if(s==null) return "";
    return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;").replace("\"","&quot;");
  }
}


