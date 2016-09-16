<%-- 
    Document   : user_dashBoard
    Created on : Aug 7, 2016, 11:56:54 PM
    Author     : Soumen
--%>

<%@page import="java.sql.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.myapp.struts.UserLoginChecker"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="update_info.jsp">
            Update A/C Info
            </a>
        
        &nbsp;
        <a href="transfer.jsp">
            Transfer
            </a>
        <HR color="red" height="20">
        <br>
        <br>
        
            <%
                // UserLoginChecker s1=new UserLoginChecker();
               //  String cid=s1.loginStatus();
                String cid=session.getAttribute("ss_cid").toString();
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
                Statement stmt=con.createStatement();
                ResultSet x=stmt.executeQuery("SELECT * FROM user_details WHERE CID='"+cid+"'");
                while(x.next())
                {
                    out.println("<br> A/C No. : "+x.getString("ACCNT_NO"));
                    out.println("<br> CID No. : "+x.getString("CID"));
                    out.println("<br> Name. : "+x.getString("F_NAME")+" "+x.getString("L_NAME"));
                    out.println("<br> D.O.B. : "+x.getString("DATE_OF_BIRTH"));
                    out.println("<br> Address : "+x.getString("ADDRESS"));
                    out.println("<br> Contact No. : "+x.getString("MOB"));
                    out.println("<br> E-mail : "+x.getString("EMAIL"));
                }
                 
            %>
           </body>
</html>
