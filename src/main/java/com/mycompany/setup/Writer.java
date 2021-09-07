/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.setup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Minky
 */
public class Writer {
    private static ByteArrayOutputStream baos;
    
    public static void setSystemOut(){
        baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
    }

    public static ByteArrayOutputStream getBaos() {
        return baos;
    }
    
}
