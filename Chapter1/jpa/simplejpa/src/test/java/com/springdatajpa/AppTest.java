package com.springdatajpa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    Date date = null;
    {
        date = new Date();

    }
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void showDate(){
        System.out.println(date);
    }
}
