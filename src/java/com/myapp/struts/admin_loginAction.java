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
import javax.servlet.http.*;

/**
 *
 * @author Soumen
 */
public class admin_loginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FALIURE = "failed";
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
            throws Exception
    
    {
        
        
        admin_login formBean= (admin_login) form;
        String email=formBean.getEmail();
        String pass=formBean.getPassword();
        HttpSession hs=request.getSession();
        
        Class.forName("oracle.jdbc.driver.OracleDriver");   
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
       PreparedStatement ps=con.prepareStatement("select emp_id from bank_staff where EMAIL=? AND PASSWORD=?");
        ps.setString(1, email);
       ps.setString(2, pass);
       ResultSet rs=ps.executeQuery();
       
        if( rs.next())
        {
            String emp_id=rs.getString(1);
            // user_session ses= new user_session();
            hs.setAttribute("emp_id", emp_id);
       // ses.s1=x.getString("CID");
        
        return mapping.findForward(SUCCESS);
           
        }
         
            return mapping.findForward(FALIURE);
       
    }
       
       
}
