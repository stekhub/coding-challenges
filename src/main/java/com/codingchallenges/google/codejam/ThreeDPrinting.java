package com.codingchallenges.google.codejam;

import java.util.Arrays;

/*
3D Printing

You are part of the executive committee of the Database Design Day festivities. You are in charge of promotions and
want to print three D's to create a logo of the contest. You can choose any color you want to print them, but all three
have to be printed in the same color.

You were given three printers and will use each one to print one of the D's. All printers use ink from 4
individual cartridges of different colors (cyan, magenta, yellow, and black) to form any color. For these printers,
a color is uniquely defined by 4 non-negative integers c, m, y, and k, which indicate the number of ink units of cyan,
magenta, yellow, and black ink (respectively) needed to make the color.

The total amount of ink needed to print a single D is exactly 10^6 units. For example, printing a D in pure yellow
would use 10^6 units of yellow ink and 0 from all others. Printing a D in the Code Jam red uses 0 units of cyan ink,
500000 units of magenta ink, 450000 units of yellow ink, and 50000 units of black ink.

To print a color, a printer must have at least the required amount of ink for each of its 4
color cartridges. Given the number of units of ink each printer has in each cartridge, output any color, defined as 4
non-negative integers that add up to 106, such that all three printers have enough ink to print it.
 */
public class ThreeDPrinting {

    private static Integer[][] PRINTERS =  {
            { 1337, 999999, 0, 10000 },
            { 666, 999999, 0, 150000 },
            { 101, 999999, 300000, 0 }
    };

    private static Integer PRINTING_UNIT_CONSUMPTION_PER_LETTER = 1_000_000;

    public static void main(String args[]) throws Exception {
        Integer[] minimumPrintingUnitsPerColor = new Integer[4];

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if (minimumPrintingUnitsPerColor[j] == null || PRINTERS[i][j] < minimumPrintingUnitsPerColor[j])
                    minimumPrintingUnitsPerColor[j] = PRINTERS[i][j];
            }
        }

        Integer sumOfMinimumAvailablePrintingUnits =
                Arrays.stream(minimumPrintingUnitsPerColor).reduce(0, Integer::sum);

        if (sumOfMinimumAvailablePrintingUnits < PRINTING_UNIT_CONSUMPTION_PER_LETTER) {
            throw new Exception("Not enough printing units available to print the letter.");
        } else if (sumOfMinimumAvailablePrintingUnits > PRINTING_UNIT_CONSUMPTION_PER_LETTER) {
            Integer unitsUsed = 0;
            Integer[] result = {0, 0, 0, 0};

            for (int i = 0; i < 4; i++) {
                unitsUsed += minimumPrintingUnitsPerColor[i];

                if (unitsUsed < PRINTING_UNIT_CONSUMPTION_PER_LETTER) {
                    result[i] = minimumPrintingUnitsPerColor[i];
                } else {
                    result[i] = minimumPrintingUnitsPerColor[i] - (unitsUsed - PRINTING_UNIT_CONSUMPTION_PER_LETTER);
                    break;
                }
            }

            printResult(result);
        } else {
            printResult(minimumPrintingUnitsPerColor);
        }
    }

    private static void printResult(Integer[] result) {
        System.out.println(Arrays.toString(result));
    }
}
