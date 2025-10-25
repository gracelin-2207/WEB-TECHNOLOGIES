/* URL REWRITING -2 Enhanced */
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  

public class SProg12 extends HttpServlet {    
    public void doGet(HttpServletRequest request, HttpServletResponse response) {  
        try {  
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();  
            
            // Getting value from the query string  
            String userName = request.getParameter("uname");  
            
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<title>Creative Studio Beta - Journey Complete</title>");
            out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&family=Space+Grotesk:wght@400;500;700&display=swap' rel='stylesheet'>");
            out.println("<style>");
            
            // Enhanced completion page CSS
            out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
            out.println("body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, rgba(167,243,208,0.4), rgba(254,202,202,0.4), rgba(196,181,253,0.4)), "
                      + "url('data:image/svg+xml;utf8,"
                      + "<svg xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 1200 800\">"
                      + "<defs>"
                      + "<pattern id=\"gallery\" patternUnits=\"userSpaceOnUse\" width=\"120\" height=\"120\">"
                      + "<rect x=\"20\" y=\"20\" width=\"80\" height=\"60\" rx=\"5\" fill=\"none\" stroke=\"rgba(139,92,246,0.1)\" stroke-width=\"2\"/>"
                      + "<circle cx=\"35\" cy=\"35\" r=\"5\" fill=\"rgba(236,72,153,0.1)\"/>"
                      + "<path d=\"M30 70l20-15 15 10 15-8\" stroke=\"rgba(59,130,246,0.1)\" stroke-width=\"2\" fill=\"none\"/>"
                      + "</pattern>"
                      + "<pattern id=\"trophy\" patternUnits=\"userSpaceOnUse\" width=\"100\" height=\"100\">"
                      + "<path d=\"M30 30h40v25l-5 10h-30l-5-10z\" fill=\"none\" stroke=\"rgba(245,158,11,0.1)\" stroke-width=\"2\"/>"
                      + "<circle cx=\"50\" cy=\"25\" r=\"8\" fill=\"rgba(16,185,129,0.1)\"/>"
                      + "</pattern>"
                      + "</defs>"
                      + "<rect width=\"1200\" height=\"800\" fill=\"url(%23gallery)\"/>"
                      + "<rect width=\"1200\" height=\"800\" fill=\"url(%23trophy)\"/>"
                      + "</svg>'); "
                      + "background-size: cover; min-height: 100vh; display: flex; justify-content: center; align-items: center; }");
            out.println(".card { background: white; border-radius: 20px; padding: 40px; max-width: 600px; width: 90%; text-align: center; box-shadow: 0 10px 30px rgba(0,0,0,0.1); }");
            out.println(".card h1 { font-family: 'Space Grotesk', sans-serif; font-size: 2.5rem; font-weight: 700; color: #4f46e5; margin-bottom: 20px; }");
            out.println(".card p { font-size: 1.1rem; color: #374151; margin-bottom: 30px; }");
            out.println(".card .btn { display: inline-block; padding: 12px 25px; background: linear-gradient(90deg, #6366f1, #ec4899); color: white; border-radius: 30px; text-decoration: none; font-weight: 600; transition: 0.3s ease; }");
            out.println(".card .btn:hover { background: linear-gradient(90deg, #ec4899, #6366f1); transform: scale(1.05); }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<div class='card'>");
            out.println("<h1>🎉 Congratulations, " + (userName != null ? userName : "Guest") + "!</h1>");
            out.println("<p>Your creative journey with <strong>Creative Studio Beta</strong> is now complete. Keep exploring, keep innovating!</p>");
            //out.println("<a href='http://localhost:8080/WT_4034/URLRewriteForm.html?uname=" + (userName != null ? userName : "") + "' class='btn'>⬅ Back to Start</a>");
            out.println("<a href='SP11?uname=" + (userName != null ? userName : "Guest") + "' class='btn'>⬅ Back to Start</a>");
            out.println("</div>");
        
            
            out.println("</body>");
            out.println("</html>");
            
        } catch(Exception e) { 
            e.printStackTrace(); 
        }  
    }  
}
