<%-- 
    Document   : transfer
    Created on : Aug 25, 2016, 11:11:34 PM
    Author     : Soumen
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<% String cid=session.getAttribute("ss_cid").toString();
Class.forName("oracle.jdbc.driver.OracleDriver");   
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
        
        PreparedStatement y=con.prepareStatement("select accnt_no from user_details where cid=?");
        y.setString(1, cid);
        ResultSet rs=y.executeQuery();
        rs.next();
        String dac=rs.getString("accnt_no");
%>
<html:form action="transfer">
    <table>
        <tbody>
            <tr>
                <td><u>Transfer To</u>
                </td>
            </tr>
            <tr>
                <td>
                    Account No.:
                </td>
                <td>
                    <html:text property="cac_no" value="Enter Account No."/>
                </td>       
            </tr>
            <tr>
                <td>
                    Account Holder Name:
                </td>
                <td>
                    <html:text property="f_name" value="Enter First Name"/>
                </td>
                
                <td>
                    <html:text property="l_name" value="Enter Last Name"/>
                </td>
            </tr>
            
            <tr>
                <td>
                    Amount:
                </td>
                <td>
                    <html:text property="amnt" value="Enter Amount"/>
                </td>       
            </tr>
            </tbody>
</table>
                    <html:hidden property="cid" value="<% out.println(dac);%>"/>
                    
                    <html:submit value="Submit" />
                    
</html:form>
