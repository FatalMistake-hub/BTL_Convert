<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="model.bean.PDF" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
  	<link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;400;700;900&family=Mukta:wght@300;400;600;700;800&family=Noto+Sans:wght@400;700&display=swap" rel="stylesheet">

	 <style>
    *,
    *::before,
    *::after {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }

    body {
    	
      font-family: Mukta, sans-serif;
      justify-content: center;
      align-items: center;
      color: #4f546c;
      font-size: 0.9rem;
      background-color: #f9fbff;
      display:grid;
      flex-flow:wrap;
      left:30%;
    }

    table {
      border-collapse: collapse;
      box-shadow: 0 5px 10px #e1e5ee;
      background-color: white;
      text-align: left;
      overflow: hidden;
    }
    thead {
      box-shadow: 0 5px 10px #e1e5ee;
    }

    th {
      padding: 1rem 2rem;
      text-transform: uppercase;
      letter-spacing: 0.1rem;
      font-size: 0.7rem;
      font-weight: 900;
    }

    td {
      padding: 1rem 2rem;
    }

    a {
      text-decoration: none;
      color: #2962ff;
    }

    .Success {
      border-radius: 0.2rem;
      background-color: #c8e6c9;
      padding: 0.2rem 1rem;
      text-align: center;
    }
    .Converting {
      border-radius: 0.2rem;
      background-color: #fff0c2;
      padding: 0.2rem 1rem;
      text-align: center;
    }
    .Pending {
      border-radius: 0.2rem;
      background-color: #fff0c2;
      padding: 0.2rem 1rem;
      text-align: center;
    }
    .Error {
      border-radius: 0.2rem;
      background-color:  #ffcdd2;
      padding: 0.2rem 1rem;
      text-align: center;
    }
    pending {
      background-color: #fff0c2;
      color: #a68b00;
    }

    paid {
      background-color: #c8e6c9;
      color: #c62828;
    }

    unpaid {
      background-color: #ffcdd2;
      color: #c62828;
    }

    .amount {
      text-align: right;
    }

    tr:nth-child(even) {
      background-color: #f4f6fb;
    }

  </style>
</head>
<body>
    <table>
        <caption>
        	<h1>Home</h1>
        	<h3>User : <%= request.getSession().getAttribute("user") == null ? "Unknown" : request.getSession().getAttribute("user").toString() %></h3>
        </caption>
        <thead>
        <tr>
            <!-- <th>ID</th> -->
            <th>Source name</th>
            <th>Status</th>
            <th>Download</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<PDF> data = (ArrayList<PDF>)request.getAttribute("data");
            for (int i = 0; i < data.size(); i++) {
        %>
            <tr>
                <%-- <td><%= data.get(i).getID() %></td> --%>
                <td><%= data.get(i).getFileName() %></td>
                <td><p class="<%= data.get(i).getResultString() %>"><%= data.get(i).getResultString() %></p></td>
                <td><a href="download?id=<%= data.get(i).getID() %>">Download</a></td>
            </tr>
        <% } %>
        </tbody>
        
    </table>
    <br>
    <table>
	<tr>
            <th><a href="Home">Refresh</a></th>
            <th><a href="upload">Convert new file</a></th>
            <th><a href="logout">Logout</a></th>

        </tr>    
    </table>

    
</body>
</html>


