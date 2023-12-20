package PartA_answers;

import java.util.Arrays;

public class answer3 {
    public static void main(String[] args) {
        int Total_Combinations = 6 * 6;
        int[] probabilities = new int[13];
        Arrays.fill(probabilities, 0);

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                probabilities[i + j]++;
            }
        }

        System.out.println("\nProbability of Sums:");
        for (int i = 2; i <= 12; i++) {
            System.out.println("P(Sum = " + i + ") = " + probabilities[i] + "/" + Total_Combinations);
        }
    }
}
