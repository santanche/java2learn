<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="diasVida" scope="page"
             class="pt.c01jsp.s07beanentrada.CalculaDias" />

<html>

<head>
  <meta charset="UTF-8">
  <title>Página de cálculo de dias de vida</title>
</head>

<body>
  <jsp:setProperty name="diasVida" property="*"/>

  <h2>Você tem aproximadamente <%= diasVida.calcula() %> dias de vida.</h2>
</body>

</html>
