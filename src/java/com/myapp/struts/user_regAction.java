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


/**
 *
 * @author Soumen
 */
public class user_regAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

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
        user_reg formBean= (user_reg) form;
        String fname= formBean.getF_name();
        String lname= formBean.getL_name();
        String gen= formBean.getGen();
        String dob= formBean.getDob();
        String email= formBean.getEmail();
        String mob= formBean.getMob();
        String add= formBean.getAddress();
        String pin= formBean.getPin();
        String sques= formBean.getS_ques();
        String ans= formBean.getAns();
        String accnt_type= formBean.getAccnt_type();
        String pass= formBean.getPassword();
        String c_pas= formBean.getC_password();
        String ref= formBean.getRef_accnt();
        
        
        try
        {
         Class.forName("oracle.jdbc.driver.OracleDriver");   
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
        Statement stmt=con.createStatement();
        String q1="select ACCNT_NO from user_details";
        ResultSet rs=stmt.executeQuery(q1);
        int reg = 0;
        while(rs.next())
        {
                 reg= rs.getInt("ACCNT_NO");
                
        }
       
        q1="insert into user_reg(reg_id, f_name, l_name, date_of_birth, address, mob, email, ref_account, accnt_type, password)"
                + "values("+reg+"+1, '"+fname+"', '"+lname+"', to_date( '"+dob+"','DD/MM/YYYY'), '"+add+" PIN- "+pin+"', '"+mob+"', '"+email+"', "+ref+", '"+accnt_type+"','"+pass+"' )";
        int x=stmt.executeUpdate(q1);
          
        
        
      
        
        
       
        
        return mapping.findForward(SUCCESS);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     return mapping.findForward(SUCCESS);   
    }
}
