/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Soumen
 */
public class transferAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    private static final String FAIL = "failure";

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
        
        transfer formbean=(transfer) form;
        String cid=formbean.getCid();
        String cac=formbean.getCac_no();
        String fname=formbean.getF_name();
        String lname=formbean.getL_name();
        String amt=formbean.getAmnt();
        String c=null;
        String dac=formbean.getDac();
        
        
        
        
        Class.forName("oracle.jdbc.driver.OracleDriver");   
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
        Statement stmt=con.createStatement();
       ResultSet x=stmt.executeQuery("select * from transaction");
       
       
        while(x.next())
        {
            c=x.getString("trnsc_id");
        }
        
        
        String q= "insert into transaction(trnsc_id, trnsc_date, debt_accnt, credit_accnt, amnt, method)\n" +
"values("+Integer.parseInt(c)+1+", to_date(sysdate,'dd/mm/yyyy'), "+Integer.parseInt(dac)+", "+Integer.parseInt(cac)+", "+Integer.parseInt(amt)+", 'online transfer')";
        stmt.executeQuery(q);
        con.commit();
        
        
        return mapping.findForward(SUCCESS);
    }
}
