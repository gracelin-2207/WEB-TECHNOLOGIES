/* Sessions -1*/
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SProg7 extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res) {
    try {
      res.setContentType("text/html; charset=UTF-8");
      PrintWriter out = res.getWriter();

      String name = req.getParameter("userName");
      String pass = req.getParameter("userPassword");

      if (name == null) name = "Guest";

      HttpSession session = req.getSession();
      session.setAttribute("uname", name);
      session.setAttribute("upass", pass);

      // Pink-toned Unsplash image (hosted) — no download required
      String bgUrl = "https://images.unsplash.com/photo-1524504388940-b1c1722653e1?auto=format&fit=crop&w=1400&q=80";

      out.println("<!doctype html>");
      out.println("<html lang='en'>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'/>");
      out.println("<meta name='viewport' content='width=device-width,initial-scale=1'/>");
      out.println("<title>Momentology — Welcome</title>");
      out.println("<style>");
      out.println("  :root{--pink:#f48fb1;--deep:#4a148c;}");
      out.println("  html,body{height:100%;margin:0;font-family:Inter, Poppins, sans-serif;}");
      out.println("  body{background:url('" + bgUrl + "') center/cover fixed no-repeat; display:flex;align-items:center;justify-content:center;color:var(--deep);}");
      out.println("  .overlay{position:fixed;inset:0;background:rgba(255,244,247,0.45);backdrop-filter: blur(6px);}"); // soft pink overlay
      out.println("  .card{position:relative;z-index:2;max-width:760px;width:85%;background:rgba(255,255,255,0.72);padding:42px;border-radius:20px;border:1px solid rgba(244,143,177,0.6);box-shadow:0 12px 40px rgba(76,0,92,0.12);text-align:center;animation:pop 700ms ease forwards}");
      out.println("  @keyframes pop{from{opacity:0;transform:translateY(18px) scale(.98)}to{opacity:1;transform:translateY(0) scale(1)}}");
      out.println("  h1{margin:0 0 8px 0;color:var(--deep);font-size:28px;letter-spacing:0.6px;text-shadow:0 6px 18px rgba(244,143,177,0.12)}");
      out.println("  p.lead{margin:6px 0 18px;color:#6a1b9a;font-size:15px}");
      out.println("  .art-emoji{display:inline-block;font-size:34px;margin:8px;opacity:0.98;animation:float 5s ease-in-out infinite}");
      out.println("  @keyframes float{0%{transform:translateY(0)}50%{transform:translateY(-12px)}100%{transform:translateY(0)}}");
      out.println("  .btn{display:inline-block;margin-top:18px;padding:12px 22px;border-radius:12px;background:linear-gradient(90deg,var(--pink),#ec407a);color:#fff;text-decoration:none;font-weight:600;box-shadow:0 8px 24px rgba(244,143,177,0.18);transition:transform .18s}");
      out.println("  .btn:hover{transform:translateY(-3px)}");
      out.println("  .flash{pointer-events:none;position:fixed;inset:0;background:white;opacity:0;animation:flash .42s ease forwards}");
      out.println("  @keyframes flash{0%{opacity:1}100%{opacity:0}}");
      out.println("</style>");
      out.println("</head>");
      out.println("<body>");
      // small one-time camera flash effect on first render
      out.println("<div class='overlay'></div>");
      out.println("<div class='card'>");
      out.println("  <h1>Welcome to Momentology, " + escapeHtml(name) + " \u2728</h1>"); // ✨
      out.println("  <p class='lead'>Your creative session is live. We’ll keep things safe and beautiful ✨</p>");
      out.println("  <div>");
      out.println("    <span class='art-emoji' title='camera'>&#x1F4F8;</span>"); // 📸
      out.println("    <span class='art-emoji' title='flower'>&#x1F337;</span>"); // 🌷
      out.println("    <span class='art-emoji' title='sparkles'>&#x2728;</span>"); // ✨
      out.println("  </div>");
      out.println("  <a class='btn' href='SP8'>Proceed to your creative details ➜</a>");
      out.println("</div>");
      // add a subtle flash when the page first loads
      out.println("<div id='flash' class='flash' style='animation-delay:0.02s'></div>");
      out.println("<script>setTimeout(()=>document.getElementById('flash').style.display='none',700);</script>");
      out.println("</body>");
      out.println("</html>");

      out.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  // small helper to avoid crude injection in simple demo
  private String escapeHtml(String s){
    if(s==null) return "";
    return s.replace("&","&amp;").replace("<","&lt;").replace(">","&gt;").replace("\"","&quot;");
  }
}



