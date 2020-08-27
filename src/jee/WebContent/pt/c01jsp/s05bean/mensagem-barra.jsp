<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="umaBarra" scope="page"
             class="pt.c01jsp.s05bean.Barra" />

<html>

<head>
  <meta charset="UTF-8">
  <title>Usando um bean barra</title>
</head>

<body>
  <jsp:setProperty name="umaBarra" property="tamanho" value="10"/>

  <h2>O dinossauro</h2>
  <%= umaBarra.monta() %>
  <h2>pulou na lama</h2>
</body>

</html>
