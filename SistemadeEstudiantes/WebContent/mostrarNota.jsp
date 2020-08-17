<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.html"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Grade System</title>
<body>
<img src="logo.png"  align="left"width="100" height="100">
<center><img src="dgi.png" width="100" height="100">
<img src="apj sir.png" align="right"  width="100" height="100"></center>
<div class="w3-container">
  <div class="w3-bar w3-black">
    <a href="adminEstudiante?action=nuevo" class="w3-bar-item w3-button tablink">Nuevo Estudiante</a>
    <a href="adminNota?action=nuevo" class="w3-bar-item w3-button tablink">Ingresar Notas</a>
    <a href="adminEstudiante?action=mostrar" class="w3-bar-item w3-button tablink">Registro de Estudiantes</a>
     <a href="adminNota?action=mostrar" class="w3-bar-item w3-button tablink">Todas las Notas</a>
     <a href="adminLogin.html" class="w3-bar-item w3-button tablink">Salir</a>
  </div>
  
  <div id="London" class="w3-container w3-border city">
  <br>
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
	<h1>Lista de Notas</h1>

<section>
  <!--for demo wrap-->
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
      <tr>
		 <td class="text-center">CODIGO</td>
		 <td class="text-center">EXAMEN 1</td>
		 <td class="text-center">EVAL. CONTINUA 1</td>
		 <td class="text-center">EXAMEN 2</td>
		 <td class="text-center">EVAL. CONTINUA 2</td>
		 <td class="text-center">EXAMEN 3</td>
		 <td class="text-center">EVAL. CONTINUA 3</td>
		  <td class="text-center" colspan=2>ACCIONES</td>
		 </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
		<c:forEach var="nota" items="${lista}">
			<tr>
				<td class="font-weight-bold" ><c:out value="${nota.rollNo}"/></td>
				<td class="font-weight-bold" ><c:out value="${nota.s1}"/></td>
				<td class="font-weight-bold"><c:out value="${nota.s2}"/></td>
				<td class="font-weight-bold"><c:out value="${nota.s3}"/></td>
				<td class="font-weight-bold"><c:out value="${nota.s4}"/></td>
				<td class="font-weight-bold"><c:out value="${nota.s5}"/></td>
				<td class="font-weight-bold"><c:out value="${nota.s6}"/></td>		
				<td class="font-weight-bold"><a class="btn btn-primary" href="adminNota?action=showedit&rollNo=<c:out value="${nota.rollNo}" />">Editar</a></td>
				<td><a class="btn btn-danger" href="adminNota?action=eliminar&rollNo=<c:out value="${nota.rollNo}"/>">Eliminar</a> </td>			
			</tr>
		</c:forEach>
	</table>
  </div>
</section>
</div>
</body>
</html>