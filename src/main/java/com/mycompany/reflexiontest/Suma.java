/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reflexiontest;
import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;
/**
 *
 * @author 2098325
 */
public class Suma {
    
        @Web("/val") public static int suma(int val){
    
        return val+val;
    }
}
