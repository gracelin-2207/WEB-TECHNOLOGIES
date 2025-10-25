<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html>
    <head>
        <title>Momentology Studio | Photography Projects</title>
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                background: radial-gradient(circle at top, #0f0f0f, #1a1a1a, #000);
                color: #fff;
                text-align: center;
                padding: 40px;
            }
            h1 {
                font-size: 2.5em;
                background: linear-gradient(90deg, #ff007f, #ffd200, #00e1ff);
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                animation: glowTitle 3s infinite alternate;
                margin-bottom: 40px;
            }
            @keyframes glowTitle {
                0% { text-shadow: 0 0 10px #ff007f; }
                100% { text-shadow: 0 0 25px #00e1ff; }
            }
            table {
                width: 85%;
                margin: auto;
                border-collapse: collapse;
                background: rgba(255,255,255,0.05);
                border-radius: 15px;
                box-shadow: 0 0 40px rgba(255,255,255,0.1);
                overflow: hidden;
                backdrop-filter: blur(10px);
            }
            th, td {
                padding: 15px;
                border-bottom: 1px solid rgba(255,255,255,0.2);
                font-size: 1em;
            }
            th {
                background: linear-gradient(90deg, #ff007f, #ffd200, #00e1ff);
                color: #000;
                font-weight: 700;
                letter-spacing: 1px;
            }
            tr:hover {
                background: rgba(255,255,255,0.1);
                transition: all 0.3s ease;
            }
            .footer {
                margin-top: 30px;
                color: #aaa;
            }
        </style>
    </head>
    <body>
        <h1>📸 Momentology Studio | Photography Projects</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Project Title</th>
                <th>Description</th>
                <th>Camera</th>
                <th>Lens</th>
                <th>Location</th>
            </tr>
            <xsl:for-each select="quiz/item">
                <tr>
                    <td><xsl:value-of select="id"/></td>
                    <td><xsl:value-of select="title"/></td>
                    <td><xsl:value-of select="description"/></td>
                    <td><xsl:value-of select="camera"/></td>
                    <td><xsl:value-of select="lens"/></td>
                    <td><xsl:value-of select="location"/></td>
                </tr>
            </xsl:for-each>
        </table>
        <div class="footer">
            © 2025 Momentology Studio | Creative Photography
        </div>
    </body>
</html>
</xsl:template>
</xsl:stylesheet>
