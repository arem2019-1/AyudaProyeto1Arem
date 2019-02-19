/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reflexiontest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.sun.xml.internal.ws.model.ReflectAnnotationReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2098325
 */
public class ReflexionTest {

    public static void main(String args[]) throws IOException {

        try {

            Hashtable<String, Object> dicWeb = new Hashtable<String, Object>();

            Class c = Class.forName("com.mycompany.reflexiontest.Calculadora");

            File f = new File("target/classes/com/mycompany/reflexiontest");
            if (f.exists()) {
                File[] ficheros = f.listFiles();
                System.out.println("siii");
                        System.out.println("lomng : "+ficheros.length);
                for (int x = 0; x < ficheros.length; x++) {
                    System.out.println(ficheros[x].getName());
                    File t=ficheros[x];
                    
                    System.out.println("miremos "+t.getPath());
                    
                    
                    //Class temp=ficheros[x].getName().getClass();    
                    Class temp=t.getPath().getClass();
                    System.out.println("nombre clase "+temp);
                    //Method[] m=temp.getMethods();
                    for(Method m : temp.getMethods()){
                        System.out.println("popo");
                        if(m.isAnnotationPresent(Web.class)){
                            System.out.println("si tiene anota web "+m.getName());
                            try{
                                m.invoke(null);
                                System.out.println("lolol");
                            
                            }catch(Throwable ex){
                                System.out.println("Fallo por puto");
                            
                            }
                                
                        
                        }
                    
                    }
                    //if()){
                    
                    
                    //}
                }
            }else {
                System.out.println("No hub nada");
            }

            System.out.println(c.toGenericString());
            Method[] ml = c.getDeclaredMethods();
            for (Method m : ml) {
                System.out.println(m);
            }
            Method m = c.getDeclaredMethod("cuadrado", int.class);
            System.out.println(m);
            System.out.println(m.invoke(null, 25));


        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ReflexionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ReflexionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReflexionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReflexionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ReflexionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ReflexionTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
