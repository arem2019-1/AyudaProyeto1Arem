/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reflexiontest;

import com.sun.corba.se.impl.oa.poa.AOMEntry;
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

            //Class c = Class.forName("com.mycompany.reflexiontest.Calculadora");
            Class c=Class.class;

            File f = new File("target/classes/com/mycompany/reflexiontest");
            if (f.exists()) {
                File[] ficheros = f.listFiles();
                System.out.println("Mostraremos ficheros");
                /**
                for(File re:ficheros){
                    //System.out.println("miremos a fonod : "+re.toPath().toString());
                    String temp1=re.toPath().toString();
                    String temp2=temp1.replace(".class", "");
                    String temp3=temp2.replace("target\\classes\\","");
                    String temp4=temp3.replace("\\", ".");
                    Class q = Class.forName(temp4);
                    System.out.println("miremos q : "+q);
                }
                   */     
          
                 System.out.println("lomng : "+ficheros.length);
                for (File re:ficheros) {
                    String temp1=re.toPath().toString();
                    String temp2=temp1.replace(".class", "");
                    String temp3=temp2.replace("target\\classes\\","");
                    String temp4=temp3.replace("\\", ".");
                    c = Class.forName(temp4);
                    System.out.println("miremos "+c);

                    //Method[] m=temp.getMethods();
                    for(Method m : c.getMethods()){
                        //System.out.println("popo");
                        if(m.isAnnotationPresent(Web.class)){
                            dicWeb.put(temp4,c);
                            System.out.println("si tiene anota web "+m.getName());
                            try{
                                System.out.println("lolol");
                                System.out.println("Miremos resultado . "+m.invoke(null,30));
                                
                            
                            }catch(Throwable ex){
                                System.out.println("Fallo por puto");
                            
                            }
                                
                        
                        }
                    
                    }
                }
            }else {
                System.out.println("No hub nada");
            }
            System.out.println("qu es: ");
            //Class r = (Class)dicWeb.get("com.mycompany.reflexiontest.Calculadora");
            Class r = (Class)dicWeb.get("com.mycompany.reflexiontest.Suma");
            //com.mycompany.reflexiontest.Suma
            System.out.println("loco  ooooo");
            System.out.println(r.toGenericString());
            
            Method[] ml = r.getDeclaredMethods();
            for (Method m : ml) {
                System.out.println(m);
            }
            String temp="cuadrado";
            String temp2="suma";
            
            Method m = r.getDeclaredMethod(temp2, int.class);
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
