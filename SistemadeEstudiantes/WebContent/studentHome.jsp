<%@ page import="com.conexion.Conexion" %>
<%@ page import="java.sql.*" %>
<%
try{
	String rollNo=request.getParameter("rollNo");
	Connection con=Conexion.getCon();
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select *from student inner join result where student.rollNo=result.rollNo and student.rollNo='"+rollNo+"'");
	if(rs.next()){
%>

<img src="logo.png"  align="left"width="150" height="150">
<center><img src="dgi.png" width="150" height="150">
<img src="apj sir.png" align="right"  width="150" height="150"></center>
    <a href="dgiOneView.html">Back</a>
  <hr class="new1">
<style>
table{
  width:100%;
  table-layout: fixed;
}
th{
  padding: 20px 15px;
  text-align: left;
  font-weight: 500;
  font-size: 12px;
  color: #fff;
  text-transform: uppercase;
 border: 2px solid rgba(255,255,255,0.3);
}


/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Roboto', sans-serif;
}
</style>
<head> <title>Grade System</title>
  <!--for demo wrap-->
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>Computer Science</th>
          <th>Semestre: <%=rs.getString(1)%></th>
          <th>Curso: <%=rs.getString(2)%></th>
          <th><center>Codigo: <%=rs.getString(3)%></center></th>
        </tr>
      </thead>
      <thead>
        <tr>
          <th>Nombres: <%=rs.getString(4)%></th>
          <th>Apellidos: <%=rs.getString(5)%></th>
          <th>Genero: <%=rs.getString(6)%></th>
          <th><a titlt="print screen" alt="print screen" onclick="window.print();" target="_blank" style="cursor:pointer;"><center><img src="print.png"></center></a></th>
        </tr>
      </thead>
    </table>
  </div>
<style>
html {
  font-family:arial;
  font-size: 25px;
}

td {
  border: 2px solid #726E6D;
  padding: 15px;
  color:black;
  text-align:center;
}

thead{
  font-weight:bold;
  text-align:center;
  background: #625D5D;
  color:white;
}

table {
  border-collapse: collapse;
}

.footer {
  text-align:right;
  font-weight:bold;
}

tbody >tr:nth-child(odd) {
  background: #D1D0CE;
}

</style>
<head>
  <hr class="new1">
</head>
<body>
  <table>
    <thead>
      <tr>
        <td colspan="3">Curso</td>
        <td rowspan="2">Tipo</td>
        <td rowspan="2">Nota Maxima</td>
        <td rowspan="2">Nota Minima</td>
        <td rowspan="2">Nota Obtenida</td>
        
      </tr>
      <tr>
        <td>Codigo </td>
        <td colspan="2"> Evaluacion </td>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>CS1101</td>
        <td colspan="2">Examen 1 </td>
        <td>Teoria</td>
        <td>20</td>
        <td>10.5 </td>
        <td><%=rs.getString(8)%></td>
      </tr>
      <tr>
        <td>CS1102</td>
        <td colspan="2">Eval. Continua 1</td>
        <td>Practica</td>
        <td>20</td>
        <td>10.5 </td>
        <td><%=rs.getString(9)%> </td>
      </tr>
      <tr>
        <td>CS1103</td>
        <td colspan="2">Examen 2 </td>
        <td>Teoria</td>
        <td>20</td>
        <td>10.5 </td>
        <td><%=rs.getString(10)%></td>
      </tr>
      <tr>
        <td>CS1104</td>
        <td colspan="2">Eval. Continua 2 </td>
        <td>Practica</td>
        <td>20</td>
        <td>10.5 </td>
        <td> <%=rs.getString(11)%></td>
      </tr>
      <tr>
        <td>CS1105</td>
        <td colspan="2">Examen 3</td>
        <td>Teoria</td>
        <td>20</td>
        <td>10.5 </td>
        <td> <%=rs.getString(12)%> </td>
      </tr>
      <tr>
        <td>CS1106</td>
        <td colspan="2">Eval. Continua 3</td>
        <td>Practica</td>
        <td>20</td>
        <td>10.5 </td>
        <td> <%=rs.getString(13)%> </td>
      </tr>

    </tbody>
    <tfoot>
      <tr>
        <td colspan="4" class="footer">Total</td>
        <td>120</td>
        <td>63</td>
        <td><% int sum=rs.getInt(8)+rs.getInt(9)+rs.getInt(10)+rs.getInt(11)+rs.getInt(12)+rs.getInt(13); out.println(sum); %> </td>
      </tr>
      <tr>
        <td colspan="4" class="footer">Promedio</td>
        <td colspan="3"><% out.println((sum*20)/120);%></td>
      </tr>
  </table>
</body>

<%}
else{
	response.sendRedirect("errorDgiOneView.html");
	}
}
catch(Exception e){}
%>