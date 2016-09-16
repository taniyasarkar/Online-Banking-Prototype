<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page  import="javax.servlet.http.* " %>

<body  vlink="blue">

<html:form action="/user_login">
    <% 
    
    String s=request.getParameter("sts");
if(s.contentEquals("failed"))
    out.println("<br><font color=red>Invalid Email or Password</font><br>");
%>
    <table border="0">
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
            <tr>
                <td>
                    <html:link href="user_reg.jsp" >New User?</html:link>
                </td>
                <td>
                <html:link href="admin_login.jsp">Corporate Login</html:link>
                </td>
            </tr>
        </tbody>
    </table>
</html:form>
</body>