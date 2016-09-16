<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page import="java.sql.*"%>





<center>
<h1>User_Registration</h1>
</center>
<html:form action="/user_reg">
 <table border="0">
     <tbody>
		
 
 
	
                 <tr>
				<td>
				First Name *:
				</td>
                                <td> <html:text property="f_name"/>
				</td>
				</tr>
	
                <tr>
				<td>
				Last Name *: 
				</td>
				<td><html:text property="l_name"/>
				</td>
				</tr>
				 
                <tr><td>Gender *: 
				</td>
                                <td><html:radio property="gen" value="M" />Male
                                    <html:radio property="gen" value="F" />Female</td></tr>  
                
                
                <tr><td>Date of Birth *: 
				</td>
                                <td><html:text property="dob" />
				</td></tr>  
                
				
				<tr><td>Email *: 
				</td>
				<td><html:text property="email"/>
				</td></tr>  
                

				<tr><td>Mobile No.: 
				</td>
				<td><html:text property="mob"/></td></tr>  
                
				
				<tr><td>Address *: 
				</td>
                                <td><html:textarea property="address"/></td></tr>  
                
				
				<tr><td>Postal Code *: 
				</td>
                                <td><html:text property="pin"/></td></tr>  
                
				
				<tr><td>Security Questions*: 
				</td>
                                <td><html:select property="s_ques" >  
                                        <html:option value="Choose" />
                                        <html:option value="Pet Name" />
                                            </html:select>  
                </td>
				</tr>
				
				<tr><td>Answers*: 
				</td>
                                <td><html:text property="ans" /></td></tr>  
                
				
				
                
				
				<tr><td>Account Type *: 
				</td>
                                <td><html:select property="accnt_type">
                                        <%
                                            Class.forName("oracle.jdbc.driver.OracleDriver");
                                            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
                                            Statement stmt=con.createStatement();
                                            ResultSet x=stmt.executeQuery("SELECT * FROM account_type");
                                            while(x.next())
                                            {
                                                    out.println("<option value='"+x.getString("TYPE_ID")+"'>"+x.getString("Type_name")+"</option>");
                                            }
                                        %>
                                        
                                    </html:select>
                                    </td></tr>  
                
				
				<tr><td>Reference Account Number *: 
				</td>
                                <td><html:text property="ref_accnt" /></td></tr>  
                
				
				<tr><td>Password *: 
				</td>
                                <td><html:password property="password" /></td></tr>  
                
				
				<tr><td>Confirm Password*: 
				</td>
                                <td><html:password property="c_password" /></td></tr>  
                
				
                                <tr><td><html:button property="reset" value="Clear" /></td>
                                    <td><html:submit property="submit" value="Confirm" /></td></tr> 
                                    </tbody>
</table>
                 </html:form>
 
                
                
 
