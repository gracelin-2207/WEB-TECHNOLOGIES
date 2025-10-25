<!-- <?php
$xml_data = simplexml_load_file("users.xml");
$search_id = $_POST['id'];
$found = false;

echo '<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Momentology Studio | Project Result</title>
    <style>
        body {
            font-family: "Poppins", sans-serif;
            background: radial-gradient(circle at top, #0f0f0f, #1a1a1a, #000);
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .card {
            background: rgba(255,255,255,0.05);
            border-radius: 20px;
            padding: 40px;
            text-align: center;
            box-shadow: 0 0 30px rgba(255,255,255,0.1);
            backdrop-filter: blur(10px);
            width: 450px;
        }
        .card h2 {
            background: linear-gradient(90deg, #ff007f, #ffd200, #00e1ff);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            animation: glowTitle 3s infinite alternate;
            margin-bottom: 25px;
        }
        @keyframes glowTitle {
            0% { text-shadow: 0 0 10px #ff007f; }
            100% { text-shadow: 0 0 25px #00e1ff; }
        }
        p { font-size: 1.1em; margin: 12px 0; }
        b { color: #ffd200; }
        .not-found {
            background: linear-gradient(90deg, #ff4c4c, #ff007f);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 0 25px rgba(255,0,127,0.5);
            text-align: center;
            font-size: 1.2em;
            width: 400px;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #00e1ff;
            font-weight: 600;
            transition: color 0.3s;
        }
        a:hover { color: #ffd200; }
    </style>
</head>
<body>';

if ($xml_data !== false) {
    foreach ($xml_data->children() as $item) {
        if ($item->id == $search_id) {
            echo '<div class="card">';
            echo '<h2>📸 Project ID: ' . htmlspecialchars($search_id) . '</h2>';
            echo '<p><b>Title:</b> ' . htmlspecialchars($item->title) . '</p>';
            echo '<p><b>Description:</b> ' . htmlspecialchars($item->description) . '</p>';
            echo '<p><b>Camera:</b> ' . htmlspecialchars($item->camera) . '</p>';
            echo '<p><b>Lens:</b> ' . htmlspecialchars($item->lens) . '</p>';
            echo '<p><b>Location:</b> ' . htmlspecialchars($item->location) . '</p>';
            echo '<a href="Xml_search.html">🔙 Back to Search</a>';
            echo '</div>'; // properly close div
            $found = true;
            break;
        }
    }
}

if (!$found) {
    echo '<div class="not-found">';
    echo '<h3>❌ No Project Found for ID: ' . htmlspecialchars($search_id) . '</h3>';
    echo '<a href="Xml_search.html">Try Again</a>';
    echo '</div>';
}

echo '</body></html>';
?> -->
<?php
$xml_data = simplexml_load_file("users.xml");
$search_id = $_POST['id'];
$found = false;

echo '<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Momentology Studio | Project Result</title>
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap");
        body {
            font-family: "Poppins", sans-serif;
            background:
                linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.85)),
                url("https://images.unsplash.com/photo-1506157786151-b8491531f063?auto=format&fit=crop&w=1600&q=80");
            background-size: cover;
            background-position: center;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
            text-align: center;
        }
        .card {
            background: rgba(255,255,255,0.1);
            border-radius: 20px;
            padding: 40px 50px;
            text-align: center;
            box-shadow: 0 0 35px rgba(255,255,255,0.15);
            backdrop-filter: blur(10px);
            width: 480px;
            animation: fadeIn 1.2s ease;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(30px); }
            to { opacity: 1; transform: translateY(0); }
        }
        .card h2 {
            background: linear-gradient(90deg, #ff007f, #ffd200, #00e1ff);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            animation: glowTitle 4s infinite alternate;
            margin-bottom: 25px;
        }
        @keyframes glowTitle {
            0% { text-shadow: 0 0 15px #ff007f; }
            50% { text-shadow: 0 0 25px #ffd200; }
            100% { text-shadow: 0 0 35px #00e1ff; }
        }
        p { font-size: 1.1em; margin: 10px 0; }
        b { color: #ffd200; }
        .not-found {
            background: rgba(255,0,100,0.15);
            border: 1px solid rgba(255,0,100,0.4);
            border-radius: 15px;
            box-shadow: 0 0 35px rgba(255,0,100,0.4);
            text-align: center;
            padding: 35px;
            width: 400px;
            backdrop-filter: blur(10px);
            animation: shake 0.4s ease;
        }
        @keyframes shake {
            0%, 100% { transform: translateX(0); }
            25% { transform: translateX(-8px); }
            75% { transform: translateX(8px); }
        }
        a {
            display: inline-block;
            margin-top: 25px;
            text-decoration: none;
            color: #00e1ff;
            font-weight: 600;
            transition: color 0.3s, transform 0.3s;
        }
        a:hover { color: #ffd200; transform: scale(1.05); }
    </style>
</head>
<body>';

if ($xml_data !== false) {
    foreach ($xml_data->children() as $item) {
        if ($item->id == $search_id) {
            echo '<div class="card">';
            echo '<h2>📸 Project ID: ' . htmlspecialchars($search_id) . '</h2>';
            echo '<p><b>Title:</b> ' . htmlspecialchars($item->title) . '</p>';
            echo '<p><b>Description:</b> ' . htmlspecialchars($item->description) . '</p>';
            echo '<p><b>Camera:</b> ' . htmlspecialchars($item->camera) . '</p>';
            echo '<p><b>Lens:</b> ' . htmlspecialchars($item->lens) . '</p>';
            echo '<p><b>Location:</b> ' . htmlspecialchars($item->location) . '</p>';
            echo '<a href="Xml_search.html">🔙 Back to Search</a>';
            echo '</div>';
            $found = true;
            break;
        }
    }
}

if (!$found) {
    echo '<div class="not-found">';
    echo '<h3>❌ No Project Found for ID: ' . htmlspecialchars($search_id) . '</h3>';
    echo '<a href="Xml_search.html">Try Again</a>';
    echo '</div>';
}

echo "</body></html>";
?>
