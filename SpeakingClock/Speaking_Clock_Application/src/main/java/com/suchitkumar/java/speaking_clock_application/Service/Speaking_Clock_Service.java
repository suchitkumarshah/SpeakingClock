/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suchitkumar.java.speaking_clock_application.Service;

import com.suchitkumar.java.speaking_clock_application.Interface.SpeakingClock;
import com.suchitkumar.java.speaking_clock_application.Exception.SpeakingClockTimeException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author ADMIN
 */
public class Speaking_Clock_Service implements SpeakingClock
{
    
     /*private static final String[] UNITS_ARRAY = {"zero","one","two","three","four", "five","six","seven",
												 "eight","nine","ten", "eleven","twelve","thirteen","fourteen",

  "fifteen", "sixteen","seventeen","eighteen","nineteen"};*/
    
     private static final List<String> UnitArrayList= new ArrayList<String>();
     private static final String[] TENS_ARRAY = {"","","twenty","thirty","forty","fifty"};
	
    public Speaking_Clock_Service()
    {
    UnitArrayList.add("zero");
    UnitArrayList.add("one");
    UnitArrayList.add("two");
    UnitArrayList.add("three");
    UnitArrayList.add("four");
    UnitArrayList.add("five");
    UnitArrayList.add("six");
    UnitArrayList.add("seven");
    UnitArrayList.add("eight");
    UnitArrayList.add("nine");
    UnitArrayList.add("ten");
    UnitArrayList.add("eleven");
    UnitArrayList.add("twelve");
    UnitArrayList.add("thirteen");
    UnitArrayList.add("fouteen");
    
    
    
    
    
    
    
    
    
    
    
    
  
    }

    @Override
    public String convert(String time) throws SpeakingClockTimeException
    {
        String s = null;
        this.validate(time);
		
		
		StringBuilder sb = new StringBuilder("It's ");
         switch (time)
         {
             case "00:00":
                 sb.append("Midnight");
                 System.out.println("Output is to be :"+sb.toString());
                 break;
             case "12:00":
                 sb.append("Midday");
                 System.out.println("Output is to be :"+sb.toString());
                 break;
             default:
                 String[] timeSplit = time.split(":");
                 Integer hours = Integer.parseInt(timeSplit[0]);
                 String hoursStr = this.convertInt(hours);
                 sb.append(hoursStr).append(" ");
                 System.out.println("Output is to be :"+sb.toString());
                 Integer minutes = Integer.parseInt(timeSplit[1]);
                 String minutesStr = this.convertInt(minutes);
                 sb.append(minutesStr);
                 System.out.println("Output is to be :"+sb.toString());
                 break;
         }
		
		return sb.toString();
             
           }

     @Override
    public void validate(String time) throws SpeakingClockTimeException
    {
        
		if(StringUtils.isBlank(time))
                { 
			throw new SpeakingClockTimeException("Time is blank");
		}
		if(time.length() != 5 || !time.contains(":")) 
                {
			throw new SpeakingClockTimeException("Invalid Time format, should be HH:mm");
		}
		String[] timeSplit = time.split(":");
		Integer hours = 0;
		try {
			hours = Integer.parseInt(timeSplit[0]);
		} catch(NumberFormatException e) {
			throw new SpeakingClockTimeException("Invalid Hours");
		}
		if(hours < 0 || hours > 23) {
			throw new SpeakingClockTimeException("Invalid Hours");
		}
		Integer minutes = 0;
		try {
			minutes = Integer.parseInt(timeSplit[1]);
		} catch(NumberFormatException e) {
			throw new SpeakingClockTimeException("Invalid Minutes");
		}
		
		
		if(minutes < 0 || minutes > 59) {
			throw new SpeakingClockTimeException("Invalid Minutes");
		}
       
    }
     @Override
    public String convertInt(Integer number) throws SpeakingClockTimeException
    {
       
       if(number < 20) return UnitArrayList.get(number);
		return TENS_ARRAY[number/10] + ((number % 10 > 0) ? " " + convertInt(number % 10):"");
    }
    
}
