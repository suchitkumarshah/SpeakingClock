/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.suchitkumar.java.speaking_clock_application.Interface;

/**
 *
 * @author ADMIN
 */
public interface SpeakingClock
{
    String convert(final String time);
    void validate(final String time);
    String convertInt(final Integer number);
}
