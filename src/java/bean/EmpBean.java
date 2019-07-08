/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.Emp;
import gen.Md;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j-knakagami2
 */
public class EmpBean {
    private String empId,empPass,empName,empKana,empSec;

    public EmpBean() {
    }

    public EmpBean(String empId, String empPass, String empName, String empKana, String empSec) {
        this.empId = empId;
        this.empPass = empPass;
        this.empName = empName;
        this.empKana = empKana;
        this.empSec = empSec;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpPass() {
        return empPass;
    }

    public void setEmpPass(String empPass) {
        this.empPass = empPass;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpKana() {
        return empKana;
    }

    public void setEmpKana(String empKana) {
        this.empKana = empKana;
    }

    public String getEmpSec() {
        return empSec;
    }

    public void setEmpSec(String empSec) {
        this.empSec = empSec;
    }
    
    public boolean loginCheck(List<Emp> emps) throws NoSuchAlgorithmException{
        boolean flg=false;
        
        for(Emp a  : emps){
            if(a.getEmpId().equals(empId) &&
                    a.getEmpPass().equals(Md.sha256(empPass))){
                flg = true;
                empName = a.getEmpName();
                empKana = a.getEmpKana();
                empSec = a.getEmpKana();
            }
        }
        return flg;
    }
}
