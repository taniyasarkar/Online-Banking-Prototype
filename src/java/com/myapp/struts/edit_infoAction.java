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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Soumen
 */
public class edit_infoAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FALIURE = "faliure";

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
        
        edit_info info=(edit_info) form;
        String data=info.getData();
        String act=info.getAct();
        HttpSession hs=request.getSession();
        String cid=hs.getAttribute("ss_cid").toString();
        
        Class.forName("oracle.jdbc.driver.OracleDriver");   
       Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
       Statement stmt=con.createStatement();
       
       if(act.equals("mob"))
       {
           stmt.executeUpdate("update user_details set mob='"+data+"' where cid='"+cid+"'");
           
           con.commit();
           return mapping.findForward(SUCCESS);
       }
       else if(act.equals("email"))
       {
           stmt.executeUpdate("update user_details set email='"+data+"' where cid='"+cid+"'");
           con.commit();
           return mapping.findForward(SUCCESS);
       }
       
       
       
        
        return mapping.findForward(FALIURE);
    }
}
