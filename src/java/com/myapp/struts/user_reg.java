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
public class user_reg extends org.apache.struts.action.ActionForm {
    
    private String f_name;
    private String l_name;
    private String gen;
    private String dob;
    private String email;
    private String mob;
    private String address;
    private String pin;
    private String s_ques;
    private String ans;
    private String accnt_type;
    private String ref_accnt;
    private String password;
    private String c_password;

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

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getS_ques() {
        return s_ques;
    }

    public void setS_ques(String s_ques) {
        this.s_ques = s_ques;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getAccnt_type() {
        return accnt_type;
    }

    public void setAccnt_type(String accnt_type) {
        this.accnt_type = accnt_type;
    }

    public String getRef_accnt() {
        return ref_accnt;
    }

    public void setRef_accnt(String ref_accnt) {
        this.ref_accnt = ref_accnt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getC_password() {
        return c_password;
    }

    public void setC_password(String c_password) {
        this.c_password = c_password;
    }

   
}
