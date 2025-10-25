import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p12_db3 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/momentology_db", "root", "");

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO brand_info VALUES (?, ?, ?)");
            pstmt.setString(1, request.getParameter("brandid"));
            pstmt.setString(2, request.getParameter("brandname"));
            pstmt.setInt(3, Integer.parseInt(request.getParameter("projects")));
            pstmt.executeUpdate();

            out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'>");
            out.println("<title>Momentology | Brand Info 🏷️</title>");
            out.println("<style>");
            out.println("body {font-family: 'Poppins', sans-serif; background: radial-gradient(circle at top, #141414, #0a0a0a); color:white; padding:30px;}");
            out.println("h2 {color:#00e676; text-align:center;}");
            out.println(".card {background: rgba(255,255,255,0.07); border-radius:12px; padding:18px; margin:15px auto; width:60%; box-shadow: 0 0 20px rgba(255,255,255,0.1);}");
            out.println(".card b {color:#00e676;}");
            out.println(".success {text-align:center; font-size:1.3em; margin-bottom:30px; color:#76ff03;}");
            out.println("</style></head><body>");

            out.println("<div class='success'>✅ Brand Info Inserted Successfully!</div>");
            out.println("<h2>🏢 Current Branding Partners – Momentology Studio</h2><hr style='border:1px solid #00e676;'>");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM brand_info");

            while (rs.next()) {
                out.println("<div class='card'>");
                out.println("<p><b>🏷️ Brand ID:</b> " + rs.getString("BrandID") + "<br>");
                out.println("<b>📛 Brand Name:</b> " + rs.getString("BrandName") + "<br>");
                out.println("<b>📸 Projects:</b> " + rs.getInt("Projects") + "</p>");
                out.println("</div>");
            }

            out.println("<div style='text-align:center; margin-top:40px; color:#aaa;'>© 2025 Momentology – Branding Beyond Frames 🎥</div>");
            out.println("</body></html>");

            conn.close();
        } catch (Exception e) {
            out.println("<p style='color:red;'>❌ Error: " + e + "</p>");
        }
    }
}
