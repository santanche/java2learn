<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
  <meta charset="UTF-8">
  <title>Contagem de 1 a 5</title>
</head>

<body>

  <% int i = 1;
     while (i <= 5) { %>

  <H2> <%= i %> </H2>

  <%   i++;
     }
  %>

</body>
</html>
