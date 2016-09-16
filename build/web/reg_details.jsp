<%-- 
    Document   : reg_details
    Created on : Aug 19, 2016, 10:59:57 PM
    Author     : Soumen
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page  import="javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String reg=request.getParameter("reg_id");
            
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
                Statement stmt=con.createStatement();
                ResultSet x=stmt.executeQuery("SELECT * FROM USER_REG WHERE REG_ID='"+reg+"'");
                x.next();
                String reg_id=x.getString("REG_ID");
                 String fname=x.getString("F_NAME");
                 String lname=x.getString("L_NAME");
                 String dob=x.getString("date_of_birth");
                 String add=x.getString("address");
                 String mob=x.getString("mob");
                 String email=x.getString("email");
                 String ref=x.getString("ref_account");
                 String a_type=x.getString("accnt_type");
                 String pass=x.getString("password");
               
                
                 out.println("<br>Name: "+fname+" "+lname);
                 out.println("<br>DOB: "+dob);
                 out.println("<br>Address: "+add);
                 out.println("<br>Contact No.: "+mob);
                 out.println("<br>E-Mail: "+email);
                 out.println("<br>Reference Account: "+ref);
                 out.println("<br>Account type: "+a_type);
              
               
        %>
        <html:form action="confirm">
            <html:hidden property="reg" value="<%= reg %>" />
            <html:submit value="Confirm" />
        </html:form>
                
    </body>
</html>
