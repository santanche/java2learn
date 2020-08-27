<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
  <meta charset="UTF-8">
  <title>Página de cálculo de dias de vida</title>
</head>

<body>

  <%! int diasVida; %>

  <%
    String idadeString = request.getParameter("idade");
    int idade = Integer.parseInt(idadeString);
    diasVida = idade * 365;
  %>

  <h2>Você tem aproximadamente <%= diasVida %> dias de vida.</h2>

</body>

</html>
