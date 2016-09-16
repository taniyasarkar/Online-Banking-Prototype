<%-- 
    Document   : admin_dashboard
    Created on : Aug 15, 2016, 12:55:40 PM
    Author     : Soumen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        
        <table border="0">
            
                <tr>
        
            <%
               
                String emp_id=session.getAttribute("emp_id").toString();
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
                Statement stmt=con.createStatement();
                ResultSet x=stmt.executeQuery("SELECT * FROM bank_staff WHERE EMP_ID='"+emp_id+"'");
                while(x.next())
                {
                    out.println("Hello "+x.getString("NAME")+"<br><hr><br>");
                    
                }
                x=stmt.executeQuery("SELECT REG_ID, F_NAME, L_NAME FROM user_reg");
                
                while(x.next())
                {
                    String reg=x.getString("REG_ID");
                    out.println("<td>"+reg+"</td>");
                    out.println("<td>"+x.getString("F_NAME")+"</td>");
                    out.println("<td>"+x.getString("L_NAME")+"</td>");
                    %>
                    
                    <td>
                        <a href="reg_details.jsp?reg_id=<%out.println(reg);%>"> View </a>
                    </td>
                    <td>
                    
                    </td>
                    <%
                }
                %>
               
                        
                     
             </tr>
            
        </table>
                    
        
    </body>
</html>
