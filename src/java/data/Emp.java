/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
    
}
