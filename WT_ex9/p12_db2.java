import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p12_db2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String category = request.getParameter("category");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/momentology_db", "root", "");

            out.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'>");
            out.println("<title>Momentology | Category View 🎨</title>");
            out.println("<style>");
            out.println("body {font-family: 'Poppins', sans-serif; background: linear-gradient(180deg, #0d0d0d, #1c1c1c); color: white; padding: 30px;}");
            out.println("h2 {color: #76ff03; text-align:center;}");
            out.println(".card {background: rgba(255,255,255,0.08); border-radius: 10px; padding: 18px; margin: 15px auto; width: 60%; box-shadow: 0 0 15px rgba(255,255,255,0.1);}");
            out.println(".card b {color: #cddc39;}");
            out.println(".no-result {text-align:center; margin-top:20px; color:#ff7043;}");
            out.println("</style></head><body>");

            out.println("<h2>🎨 Momentology Projects – Category: " + category + "</h2><hr style='border:1px solid #76ff03;'>");

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM portfolio WHERE Category=?");
            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                out.println("<div class='card'>");
                out.println("<p><b>🎞️ Title:</b> " + rs.getString("Title") + "<br>");
                out.println("<b>👥 Client:</b> " + rs.getString("Client") + "<br>");
                out.println("<b>⭐ Rating:</b> " + rs.getDouble("Rating") + "</p>");
                out.println("</div>");
            }

            if (!found) {
                out.println("<p class='no-result'>⚠️ No projects found in this category.</p>");
            }

            out.println("<div style='text-align:center; margin-top:40px; color:#aaa;'>© Momentology Studio – Creative Photography & Branding 📸</div>");
            out.println("</body></html>");

            conn.close();
        } catch (Exception e) {
            out.println("<p style='color:red;'>❌ Error: " + e + "</p>");
        }
    }
}
