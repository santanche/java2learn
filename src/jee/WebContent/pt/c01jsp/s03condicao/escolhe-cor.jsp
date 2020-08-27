<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
  <meta charset="UTF-8">
  <title>Escolha de cor</title>
</head>

<body>

  <%! int cor = 0;
      String fonte = ""; %>

  <% if (cor == 0) 
         fonte = "#FF0000";
     else
         fonte = "#0000FF"; %>

  <h2><span style="color:<%= fonte %>">O dinossauro pulou na lama.</span></h2>

</body>
</html>
