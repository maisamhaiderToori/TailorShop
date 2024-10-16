/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.junia.tailorshop.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author maisa
 */
public class Utils {
    
    
    public static void println(String text){
        System.out.println(text);
    }
    
    
    public static void print(String text){
        System.out.println(text);
    }
    public static int currentTime(){
       return Integer.parseInt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH")));
     }
    
}
