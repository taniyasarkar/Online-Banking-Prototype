/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Soumen
 */
public class UserLoginChecker extends HttpServlet 
{
    
    String s1;
    
    public String loginStatus()
    {
        UserLoginChecker sts = new UserLoginChecker();
        return(sts.s1);
    }
   public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
    {
        
       

        try 
        {
            HttpSession ses=req.getSession();
            String s1 = (String)ses.getAttribute("CID");
            this.s1=s1;
        }
        catch(Exception e){}
        
   }
}
    