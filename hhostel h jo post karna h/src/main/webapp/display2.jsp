<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Accounts</title>
    <style>
        body {
            font-family: 'Courier New', Courier, monospace;
            margin: 0;
            padding: 0;
            background-image: url('bg.png');
            background-size: cover;
            background-position: center;
            color: #00ff00;
            text-align: center;
            padding-top: 100px;
        }

        h2 {
            font-size: 36px;
            margin-bottom: 20px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #00ff00;
        }

        th {
            background-color: #007f00;
        }

        tr:nth-child(even) {
            background-color: rgba(0, 255, 0, 0.1);
        }
    </style>
</head>
<body>
    <h2>Display Accounts</h2>
    <table>
        <thead>
            <tr>
                <th>Account Number</th>
                <th>Name</th>
                <th>Balance</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${accounts}">
                <tr>
                    <td>${account.num}</td>
                    <td>${account.name}</td>
                    <td>${account.balance}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
