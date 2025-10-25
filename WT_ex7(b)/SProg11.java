/* URLREWRITING-1 Enhanced */
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class SProg11 extends HttpServlet {    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {  
        try {  
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();  
            
            String userName = request.getParameter("userName");  
            
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Creative Studio Alpha - Welcome</title>");
            out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&family=Space+Grotesk:wght@400;500;700&display=swap' rel='stylesheet'>");
            out.println("<style>");
            
            // Enhanced CSS with photography theme
            out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
            out.println("body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, rgba(253, 230, 138, 0.4), rgba(252, 165, 165, 0.4), rgba(196, 181, 253, 0.4)), url('data:image/svg+xml;utf8,<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 1200 800\"><defs><pattern id=\"lens\" patternUnits=\"userSpaceOnUse\" width=\"150\" height=\"150\"><circle cx=\"75\" cy=\"75\" r=\"35\" fill=\"none\" stroke=\"rgba(139,92,246,0.1)\" stroke-width=\"3\"/><circle cx=\"75\" cy=\"75\" r=\"20\" fill=\"none\" stroke=\"rgba(236,72,153,0.1)\" stroke-width=\"2\"/><path d=\"M45 45l60 60M105 45l-60 60\" stroke=\"rgba(59,130,246,0.1)\" stroke-width=\"1\"/></pattern><pattern id=\"aperture\" patternUnits=\"userSpaceOnUse\" width=\"100\" height=\"100\"><polygon points=\"50,20 70,40 50,60 30,40\" fill=\"none\" stroke=\"rgba(16,185,129,0.1)\" stroke-width=\"2\"/><circle cx=\"50\" cy=\"40\" r=\"8\" fill=\"rgba(245,158,11,0.1)\"/></pattern></defs><rect width=\"100%\" height=\"100%\" fill=\"url(%23lens)\"/><rect width=\"100%\" height=\"100%\" fill=\"url(%23aperture)\" opacity=\"0.7\"/></svg>'), radial-gradient(circle at 30% 70%, rgba(167, 243, 208, 0.3) 0%, transparent 50%), radial-gradient(circle at 70% 30%, rgba(254, 202, 202, 0.3) 0%, transparent 50%); background-size: cover, 200px 200px, 800px 800px, 600px 600px; background-attachment: fixed; color: #374151; min-height: 100vh; display: flex; align-items: center; justify-content: center; animation: backgroundFlow 25s ease infinite; overflow-x: hidden; }");
            out.println("@keyframes backgroundFlow { 0%, 100% { background-position: 0% 0%, 0% 0%, 0% 0%, 100% 100%; } 25% { background-position: 25% 25%, 25% 25%, 20% 80%, 80% 20%; } 50% { background-position: 50% 50%, 50% 50%, 80% 20%, 20% 80%; } 75% { background-position: 75% 75%, 75% 75%, 60% 60%, 40% 40%; } }");
            
            out.println(".studio-container { background: rgba(255, 255, 255, 0.92); backdrop-filter: blur(30px); border: 3px solid transparent; border-radius: 35px; padding: 60px; width: 100%; max-width: 650px; text-align: center; box-shadow: 0 30px 80px rgba(139, 92, 246, 0.15), 0 0 0 1px rgba(255, 255, 255, 0.8), inset 0 2px 0 rgba(255, 255, 255, 0.9); position: relative; animation: stationFloat 8s ease-in-out infinite; overflow: hidden; background-image: radial-gradient(circle at 20% 20%, rgba(236, 72, 153, 0.05) 0%, transparent 40%), radial-gradient(circle at 80% 80%, rgba(59, 130, 246, 0.05) 0%, transparent 40%); }");
            out.println("@keyframes stationFloat { 0%, 100% { transform: translateY(0px) rotateX(0deg); box-shadow: 0 30px 80px rgba(139, 92, 246, 0.15), 0 0 0 1px rgba(255, 255, 255, 0.8); } 25% { transform: translateY(-12px) rotateX(1deg); } 50% { transform: translateY(-8px) rotateX(0deg); box-shadow: 0 40px 100px rgba(139, 92, 246, 0.2), 0 0 0 1px rgba(255, 255, 255, 0.9); } 75% { transform: translateY(-15px) rotateX(-1deg); } }");
            
            out.println(".studio-container::before { content: ''; position: absolute; top: -3px; left: -3px; right: -3px; bottom: -3px; background: linear-gradient(45deg, #fbbf24, #f472b6, #8b5cf6, #06b6d4, #10b981); border-radius: 35px; z-index: -1; animation: borderGradient 8s ease infinite; }");
            out.println("@keyframes borderGradient { 0%, 100% { background-position: 0% 50%; opacity: 0.6; } 50% { background-position: 100% 50%; opacity: 0.8; } }");
            
            out.println(".camera-icon { position: absolute; top: 25px; right: 35px; font-size: 3rem; opacity: 0.2; animation: cameraFloat 4s ease-in-out infinite; z-index: 1; }");
            out.println("@keyframes cameraFloat { 0%, 100% { transform: rotate(0deg) scale(1); } 50% { transform: rotate(5deg) scale(1.1); } }");
            
            out.println(".studio-header { font-family: 'Space Grotesk', sans-serif; font-size: 3rem; font-weight: 700; background: linear-gradient(135deg, #8b5cf6, #ec4899, #06b6d4); -webkit-background-clip: text; -webkit-text-fill-color: transparent; background-clip: text; margin-bottom: 20px; animation: headerGlow 5s ease-in-out infinite alternate; position: relative; z-index: 2; }");
            out.println("@keyframes headerGlow { from { filter: drop-shadow(0 0 15px rgba(139, 92, 246, 0.3)); } to { filter: drop-shadow(0 0 25px rgba(236, 72, 153, 0.4)); } }");
            
            out.println(".welcome-text { font-size: 1.4rem; color: #6b7280; margin-bottom: 15px; font-weight: 400; position: relative; z-index: 2; }");
            out.println(".user-name { font-family: 'Space Grotesk', sans-serif; font-size: 2.2rem; background: linear-gradient(135deg, #7c2d12, #be185d, #1e40af); -webkit-background-clip: text; -webkit-text-fill-color: transparent; background-clip: text; font-weight: 700; margin: 25px 0; filter: drop-shadow(0 2px 4px rgba(124, 45, 18, 0.1)); position: relative; z-index: 2; }");
            
            out.println(".status-panel { background: linear-gradient(135deg, rgba(167, 243, 208, 0.2), rgba(254, 202, 202, 0.2)); border: 2px solid rgba(16, 185, 129, 0.3); border-radius: 20px; padding: 25px; margin: 35px 0; backdrop-filter: blur(10px); position: relative; z-index: 2; }");
            out.println(".status-title { font-family: 'Space Grotesk', sans-serif; font-size: 1.3rem; color: #059669; font-weight: 600; margin-bottom: 15px; }");
            out.println(".status-list { font-size: 1.1rem; color: #374151; line-height: 2; text-align: left; }");
            
            out.println(".next-studio-btn { display: inline-block; background: linear-gradient(135deg, #a855f7, #ec4899, #06b6d4); border: none; padding: 22px 50px; border-radius: 30px; color: white; font-size: 1.4rem; font-weight: 600; font-family: 'Space Grotesk', sans-serif; text-decoration: none; text-transform: uppercase; letter-spacing: 2px; transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1); position: relative; overflow: hidden; margin-top: 25px; box-shadow: 0 20px 40px rgba(168, 85, 247, 0.3), 0 8px 20px rgba(236, 72, 153, 0.2); z-index: 2; }");
            
            out.println(".next-studio-btn:hover { transform: translateY(-5px) scale(1.03); box-shadow: 0 30px 60px rgba(168, 85, 247, 0.4), 0 12px 30px rgba(236, 72, 153, 0.3); text-decoration: none; color: white; }");
            
            out.println(".next-studio-btn::before { content: ''; position: absolute; top: 0; left: -100%; width: 100%; height: 100%; background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.4), transparent); transition: left 0.7s cubic-bezier(0.4, 0, 0.2, 1); }");
            out.println(".next-studio-btn:hover::before { left: 100%; }");
            
            out.println(".floating-elements { position: absolute; width: 100%; height: 100%; pointer-events: none; z-index: 1; }");
            out.println(".floating-element { position: absolute; opacity: 0.1; animation: elementFloat 12s infinite linear; }");
            out.println("@keyframes elementFloat { 0% { transform: translateY(100vh) rotate(0deg) scale(0.8); opacity: 0; } 10% { opacity: 0.1; } 90% { opacity: 0.1; } 100% { transform: translateY(-100vh) rotate(360deg) scale(1.2); opacity: 0; } }");
            
            out.println("@media (max-width: 600px) { .studio-container { padding: 40px 30px; margin: 20px; } .studio-header { font-size: 2.4rem; } .user-name { font-size: 1.8rem; } .next-studio-btn { padding: 18px 40px; font-size: 1.2rem; } .camera-icon { top: 15px; right: 20px; font-size: 2.5rem; } }");
            
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            // Floating elements
            out.println("<div class='floating-elements'>");
            String[] elements = {"📷", "🎨", "✨", "💫", "🌈"};
            for (int i = 0; i < 6; i++) {
                int elementIndex = i % elements.length;
                int leftPosition = 10 + (i * 15);
                int delay = i * 2;
                out.println("<div class='floating-element' style='left: " + leftPosition + "%; font-size: 2rem; animation-delay: " + delay + "s;'>" + elements[elementIndex] + "</div>");
            }
            out.println("</div>");
            
            out.println("<div class='studio-container'>");
            out.println("<div class='camera-icon'>📸</div>");
            out.println("<h1 class='studio-header'>CREATIVE STUDIO ALPHA</h1>");
            out.println("<p class='welcome-text'>Digital Identity Authenticated</p>");
            out.println("<div class='user-name'>" + userName + "</div>");
            
            out.println("<div class='status-panel'>");
            out.println("<div class='status-title'>🎯 Session Status</div>");
            out.println("<div class='status-list'>");
            out.println("✓ Creative profile initialized<br>");
            out.println("✓ URL rewriting protocol active<br>");
            out.println("✓ Data transmission encrypted<br>");
            out.println("🚀 Ready for Studio Beta transfer");
            out.println("</div>");
            out.println("</div>");
            
            // URL rewriting - appending the username in the query string  
            //out.println("<a href='SP12?uname=" + userName + "' class='next-studio-btn'>");
            out.println("<a href='SP12?uname=" + userName + "' class='btn'>Enter Studio Beta ➡</a>");

            out.println("<span>Enter Studio Beta</span>");
            out.println("</a>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
                    
            out.close();                  
        } catch(Exception e) {
            System.out.println("Error in SProg11: " + e.getMessage());
            e.printStackTrace();
        }  
    }   
}