package com.n3qa.lecture14.testng.a1_assertions;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AssertEqualsDemonstration {


    @Test
    public void verifyTheCalculationsAreTheSome(){
        int contractPrice = 2+2;
        int craftManneeds = 2+2+1;

        assertEquals(contractPrice,craftManneeds);
    }

    @Test
    public void verifyTheDoulbeNumberAreTheSome(){
        double expectedConstructionWorks = 2+2.65;
        String craftManNeeds = "2+2+1";

        assertEquals(expectedConstructionWorks,craftManNeeds);

    };

    @Test
    public void verifyTheWordsAreTheSome(){
        String firstWording = "Hello Adam";
        String secondWording = "Hello Adam";

        assertEquals(firstWording,secondWording);

    };

    @Test
    public void verifyTheFirstNumberIsBigger(){
        int firstNumber = 175;
        int  secondNumber = 877;

        boolean isFirstBigger = firstNumber>secondNumber;

        assertEquals(true,isFirstBigger);
    };




}
