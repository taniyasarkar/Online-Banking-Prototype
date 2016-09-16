<%-- 
    Document   : update_info
    Created on : Aug 12, 2016, 11:14:21 PM
    Author     : Soumen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
               
                String cid=session.getAttribute("ss_cid").toString();
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
                Statement stmt=con.createStatement();
                ResultSet x=stmt.executeQuery("SELECT * FROM user_details WHERE CID='"+cid+"'");
       %>
       
       <%
                while(x.next())
                {
                    
                    out.println("<br> Contact No. : "+x.getString("MOB"));
       %>
       <html:link href="edit_info.jsp?act=mob">Edit</html:link>
       <%
                    out.println("<br> E-mail : "+x.getString("EMAIL"));
                    
                }
                 
            %>
            <html:link href="edit_info.jsp?act=email">Edit</html:link>
            <%
                out.println(request.getParameter("sts"));
            %>
                
    </body>
</html>
