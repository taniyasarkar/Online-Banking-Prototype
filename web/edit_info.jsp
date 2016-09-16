<%-- 
    Document   : update_status
    Created on : Aug 14, 2016, 8:16:33 PM
    Author     : Soumen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page  import="javax.servlet.http.*" %>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <html:form action="edit_info" >
        <html:text property="data" />
        
        <%
            String act=request.getParameter("act");
            if(act.contentEquals("mob"))
            {
                out.println("Enter your new Mobile no.");
                %>
                <html:hidden property="act" value="mob" />
                <%
            } 
            else
            {
                out.println("Enter your new E-mail id");
                %>
                <html:hidden property="act" value="mob" />
                <%
            }
        %>
        
            
            
            <html:submit/>
        </html:form>
             
            
                
            
        
 

