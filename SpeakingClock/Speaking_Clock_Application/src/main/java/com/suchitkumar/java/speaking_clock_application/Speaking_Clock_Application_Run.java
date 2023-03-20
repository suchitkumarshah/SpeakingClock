/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suchitkumar.java.speaking_clock_application;

import com.suchitkumar.java.speaking_clock_application.Exception.SpeakingClockTimeException;
import com.suchitkumar.java.speaking_clock_application.Service.Speaking_Clock_Service;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Speaking_Clock_Application_Run 
{
   
    public static void main(String[] args)
    {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Enter the Time");
         String time = scanner.next();
         Speaking_Clock_Service speakingClockService= new Speaking_Clock_Service();
         speakingClockService.convert(time);
        
        
    }

    public Object convert(String string) throws SpeakingClockTimeException 
    {
        Object o = string;
        if(o==null)
        {
            o=string;
        }
        return o;
    }

   
    
}
