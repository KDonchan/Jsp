/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import gen.Md;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j-knakagami2
 */
public class Emp {
    private String empId,empPass,empName,empKana,empSec;

    public Emp() {
    }

    public Emp(String empId, String empPass, String empName, String empKana, String empSec) {
        this.empId = empId;
        try {
            this.empPass = Md.sha256(empPass);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Empコンストラクタ　sha256エラー："+ex.getMessage());
        }
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
        try {
            this.empPass = Md.sha256(empPass);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Emp.setEmpPass sha256エラー："+ex.getMessage());
        }
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
    
}
