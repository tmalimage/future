package com.itch.future;

import com.itch.future.controller.Manager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Manager.sequentialCalculate();
        Manager.parallelCalculate();
    }
}
