/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.sql.*;
import com.myapp.struts.user_session;
import javax.servlet.http.HttpSession;




/**
 *
 * @author Soumen
 */
public class user_loginAction extends org.apache.struts.action.Action 
{

    /* forward name="success" path="" */
    private static final String SUCCESS = "s";
    private static final String FALIURE = "f";
     

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    
    
    
  
    
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        
        user_login formBean=(user_login) form;
      
        
        String email=formBean.getEmail();
        String password=formBean.getPassword();
        HttpSession hs=request.getSession();
     
       Class.forName("oracle.jdbc.driver.OracleDriver");   
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
    // Statement stmt=con.createStatement();
       PreparedStatement ps=con.prepareStatement("select cid from user_details where EMAIL=? AND PASSWORD=?");
     //ResultSet x=stmt.executeQuery("select cid from user_details where EMAIL='"+email+"' AND PASSWORD='"+password+"'");
       ps.setString(1, email);
       ps.setString(2, password);
       ResultSet rs=ps.executeQuery();
       //perform validation
        if( rs.next())
        {
            String cid=rs.getString(1);
            // user_session ses= new user_session();
            hs.setAttribute("ss_cid", cid);
       // ses.s1=x.getString("CID");
        
        return mapping.findForward(SUCCESS);
           
        }
         
            return mapping.findForward(FALIURE);
       
    }
   
        
    
}
