

<?xml version="1.0" encoding="UTF-8"?>
<!--  
  ✨ Momentology Studio ✨
  XSL Stylesheet for sprog5.xml
  Domain: Photography | Branding | Motion Art
  Design: Neon gradient table with dark cinematic feel
-->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/">
<html>
<head>
<title>Momentology Studio | Photography & Branding</title>
<style>
  body {
    font-family: 'Poppins', sans-serif;
    background: radial-gradient(circle at top, #0a0a0a, #000000);
    color: #ffffff;
    text-align: center;
    padding: 50px;
  }

  h1 {
    font-size: 2.8em;
    background: linear-gradient(90deg, #ff007f, #ffd200, #00e1ff);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    animation: glow 3s infinite alternate;
  }

  @keyframes glow {
    0% { text-shadow: 0 0 10px #ff007f; }
    100% { text-shadow: 0 0 25px #00e1ff; }
  }

  .subtext {
    color: #ccc;
    margin-bottom: 40px;
    font-style: italic;
  }

  table {
    width: 85%;
    margin: 30px auto;
    border-collapse: collapse;
    background: rgba(255,255,255,0.05);
    box-shadow: 0 0 40px rgba(255,255,255,0.1);
    border-radius: 15px;
    overflow: hidden;
  }

  th {
    background: linear-gradient(90deg, #ff007f, #ffd200, #00e1ff);
    color: #000;
    font-weight: bold;
    padding: 15px;
  }

  td {
    padding: 15px;
    border-bottom: 1px solid rgba(255,255,255,0.2);
    color: #fff;
  }

  tr:hover {
    background: rgba(255,255,255,0.1);
    transform: scale(1.02);
    transition: all 0.3s ease;
  }

  .footer {
    margin-top: 40px;
    color: #aaa;
    font-size: 0.9em;
  }
</style>
</head>
<body>

  <h1><xsl:value-of select="studio/studio-info/name"/></h1>
  <div class="subtext">
    Founded by <xsl:value-of select="studio/studio-info/founder"/> |
    <xsl:value-of select="studio/studio-info/tagline"/>
    <br/>
    <em><xsl:value-of select="studio/studio-info/quote"/></em>
  </div>

  <table>
    <tr>
      <th>ID</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Nickname</th>
      <th>Role</th>
      <th>Speciality</th>
      <th>Salary</th>
    </tr>

    <xsl:for-each select="studio/team/member">
      <tr>
        <td><xsl:value-of select="@id"/></td>
        <td><xsl:value-of select="firstname"/></td>
        <td><xsl:value-of select="lastname"/></td>
        <td><xsl:value-of select="nickname"/></td>
        <td><xsl:value-of select="role"/></td>
        <td><xsl:value-of select="speciality"/></td>
        <td><xsl:value-of select="salary"/></td>
      </tr>
    </xsl:for-each>
  </table>

  <div class="footer">
    ✨ <xsl:value-of select="studio/contact/instagram"/> | 
    <xsl:value-of select="studio/contact/website"/> ✨
    <br/> © 2025 Momentology Studio
  </div>

</body>
</html>
</xsl:template>
</xsl:stylesheet>
