/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import data.Emp;
import data.Sec;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author j-knakagami2
 */
public class JspBean {
    private List<Emp> emps;
    private List<Sec> secs;

    public JspBean() {
        emps = new ArrayList<>();
        secs = new ArrayList<>();
        Emp aEmp = new Emp("E001", "123", "森本", "もりもと", "S001");
        emps.add(aEmp);
        aEmp = new Emp("E002", "123", "中上", "なかがみ", "S002");
        emps.add(aEmp);
        
        Sec aSec = new Sec("S001", "広コン");
        secs.add(aSec);
        aSec = new Sec("S002", "ＪＢ");
        secs.add(aSec);
        aSec = new Sec("S003", "公務員");
        secs.add(aSec);
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public List<Sec> getSecs() {
        return secs;
    }
    
    //社員登録処理　ここから
    public synchronized void empAdd(Emp aEmp){
        if(!empIdDupCheck(aEmp.getEmpId()))
            emps.add(aEmp);
    }
    
    public boolean empIdDupCheck(String wEmpId){
        boolean flg = false;
        for(Emp a : emps){
            if(a.getEmpId().equals(wEmpId)){
                flg=true;
                break;
            }
        }
        return flg;
    }
    //社員登録処理　ここまで
    
    //部署登録　ここから
    public boolean secIdDupCheck(String wId){
        boolean flg = false;
        for(Sec a : secs){
            if(a.getSecId().equals(wId)) {//secId重複
                flg = true;
                break;
            }
        }
        return flg;
    }
    
    public synchronized void secAdd(Sec aSec){
        if(!secIdDupCheck(aSec.getSecId())){ //secId重複なし
            secs.add(aSec);
        }
    }
    //部署登録　ここまで
}
