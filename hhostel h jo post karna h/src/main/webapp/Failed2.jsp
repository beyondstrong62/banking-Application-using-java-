<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Failed</title>
    <style>
        body {
            font-family: 'Courier New', Courier, monospace;
            margin: 0;
            padding: 0;
            background-image: url('bg.png'); /* Hacker/cybersecurity background image */
            background-size: cover;
            background-position: center;
            color: #ff0000; /* Red text color */
            text-align: center;
            padding-top: 100px;
        }

        h1 {
            font-size: 48px;
            margin-bottom: 30px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Text shadow for better readability */
        }

        p {
            font-size: 24px;
            margin-bottom: 20px;
        }

        a {
            color: #00ff00; /* Light green link color */
            text-decoration: none;
            border-bottom: 1px solid #00ff00; /* Light green underline */
            transition: border-bottom 0.3s;
        }

        a:hover {
            border-bottom: 2px solid #00ff00; /* Light green thicker underline on hover */
        }
    </style>
</head>
<body>
    <h1>Failed!</h1>
    <p>Registration/login failed. Please try again.</p>
    <p><a href="home2.html">Go to Home</a></p>
</body>
</html>
