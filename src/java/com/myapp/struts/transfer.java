/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Soumen
 */
public class transfer extends org.apache.struts.action.ActionForm {
    
    private String cid;
    private String cac_no;
    private String f_name;
    private String l_name;
    private String amnt;
    private String dac;

    public String getDac() {
        return dac;
    }

    public void setDac(String dac) {
        this.dac = dac;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCac_no() {
        return cac_no;
    }

    public void setCac_no(String cac_no) {
        this.cac_no = cac_no;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getAmnt() {
        return amnt;
    }

    public void setAmnt(String amnt) {
        this.amnt = amnt;
    }
    

   
}
