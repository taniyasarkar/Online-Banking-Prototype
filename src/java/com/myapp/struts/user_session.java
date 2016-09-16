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
public class user_session extends HttpServlet 
{
        String s1;
        
        void initiator(String s1)
        {
            
            this.s1=s1;
            user_session x=new user_session();
        }
        
        
        

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException
    {
           
       try
        {
            HttpSession ses=req.getSession();//Establishing a session
            ses.setAttribute("CID",s1);
            
        }
        catch(Exception e){}

      }
    
    
   
    }

  
