/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author j-knakagami2
 */
public class Md {
    
    public static String sha256(String wPass) throws NoSuchAlgorithmException{
        StringBuilder shaString = new StringBuilder();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] shaByte = null;
        shaByte = md.digest(wPass.getBytes());
        
        for(byte b : shaByte){
            shaString.append(String.format("%02X", b));
        }
        //return DatatypeConverter.printHexBinary(shaByte);
        return shaString.toString();
    }
        
    }
