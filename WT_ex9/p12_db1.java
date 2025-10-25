import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p12_db1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ✅ Ensure UTF-8 output (for emojis)
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/momentology_db", "root", "");

            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'><head><meta charset='UTF-8'>");
            out.println("<title>Momentology | Portfolio Showcase 📸</title>");
            out.println("<style>");
            out.println("body {font-family: 'Poppins', sans-serif; background: radial-gradient(circle at top, #0a0a0a, #1b1b1b); color: #fff; margin: 0; padding: 30px;}");
            out.println("h2 {color: #ffb400; text-align: center;}");
            out.println(".card {background: rgba(255,255,255,0.05); border-radius: 12px; padding: 20px; margin: 20px auto; width: 60%; box-shadow: 0 0 20px rgba(255,255,255,0.1);}");
            out.println(".card b {color: #ffeb3b;}");
            out.println(".footer {margin-top: 30px; text-align: center; color: #aaa; font-size: 0.9em;}");
            out.println("</style></head><body>");

            out.println("<h2>📸 Momentology Studio – Portfolio Gallery</h2><hr style='border:1px solid #ffb400;'>");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM portfolio");

            while (rs.next()) {
                out.println("<div class='card'>");
                out.println("<p><b>🆔 Photo ID:</b> " + rs.getString("PhotoID") + "<br>");
                out.println("<b>🎞️ Title:</b> " + rs.getString("Title") + "<br>");
                out.println("<b>📂 Category:</b> " + rs.getString("Category") + "<br>");
                out.println("<b>👥 Client:</b> " + rs.getString("Client") + "<br>");
                out.println("<b>⭐ Rating:</b> " + rs.getDouble("Rating") + "</p>");
                out.println("</div>");
            }

            out.println("<div class='footer'>© 2025 Momentology Studio – Capturing Stories Through Lenses 🎬</div>");
            out.println("</body></html>");

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            out.println("<p style='color:red;'>❌ Error: " + e + "</p>");
        }
    }
}
