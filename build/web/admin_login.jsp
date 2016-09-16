<%-- 
    Document   : admin_login
    Created on : Aug 15, 2016, 12:09:00 PM
    Author     : Soumen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>

<html:form action="/admin_login">
    
<table>
    
    <tbody>
            <tr>
                <td>
                    Enter Your email:
            </td>
                <td>
                    <html:text property="email" />
                </td>
            </tr>
             <tr>
                <td>
                    Enter Your Password:
                </td>
                <td>
                    <html:password property="password" />
                </td>
            </tr>
            <tr>
                <td>
                    <html:submit value="Login" />
                </td>
                
            </tr>
           
        </tbody>
    </table>
</html:form>
