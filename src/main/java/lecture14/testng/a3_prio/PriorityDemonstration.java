package com.n3qa.lecture14.testng.a3_prio;

import org.testng.annotations.Test;

public class PriorityDemonstration {

    @Test(priority = 44)
    public void firstPriorityTestCase(){
        System.out.println("PRIORITY !!! 1 !!!  Verify user can login");
    }

    @Test(priority = 68)
    public void secondPriorityTestCase(){
        System.out.println("PRIORITY  @@@ 2 @@@   Verify user can login");
    };

    @Test(priority = 3)
    public void thirdPriorityTestCase(){
        System.out.println("PRIORITY  ### 3 ###  Verify user can login");
    };

}
