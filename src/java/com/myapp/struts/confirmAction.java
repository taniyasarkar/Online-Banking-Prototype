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
public class confirmAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failed";

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
        confirm formBean=(confirm) form;
        String reg=formBean.getReg();
        int reg2=Integer.parseInt(reg);
        Class.forName("oracle.jdbc.driver.OracleDriver");   
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
        Statement stmt=con.createStatement();
        
        ResultSet x=stmt.executeQuery("SELECT * FROM USER_REG WHERE REG_ID="+reg2);
                x.next();
                    String fname=x.getString("F_NAME");
                    int reg_id=Integer.parseInt(x.getString("reg_id"));
                 
                 String lname=x.getString("L_NAME");
                 String dob=x.getString("date_of_birth");
                 String add=x.getString("address");
                 String mob=x.getString("mob");
                 String email=x.getString("email");
                 String ref=x.getString("ref_account");
                 String a_type=x.getString("accnt_type");
                 String pass=x.getString("password");
                 String cid="STS0"+reg_id;
                
                
        
        String q="insert into user_details(accnt_no, cid, f_name, l_name, date_of_birth, address, mob, email, ref_account, account_type, password)"
                + "values("+reg_id+", '"+cid+"', '"+fname+"', '"+lname+"', '"+dob+"', '"+add+"', '+mob+', '"+email+"', "+ref+", '"+a_type+"', '"+pass+"')";
         x=stmt.executeQuery(q);
         stmt.executeQuery("delete from user_reg where reg_id="+reg2);
        con.commit();
        
        
        return mapping.findForward(SUCCESS);
        
    }
}
