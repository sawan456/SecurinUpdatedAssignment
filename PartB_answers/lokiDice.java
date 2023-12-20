package PartB_answers;

import java.util.Arrays;

public class lokiDice {

    public static void main(String[] args) {
        int[] Dice_A = {1, 2, 3, 4, 5, 6};
        int[] Dice_B = {1, 2, 3, 4, 5, 6};
        int[] output = undoomDices(Dice_A, Dice_B);
        System.out.println("New Dice_A: " + Arrays.toString(output));
    }
//---------------------------------UndoomDices Logic Start---------------------------------------------------------------

    static int[] undoomDices(int[] Dice_A, int[] Dice_B) {
        // Count occurrences of each sum for the original dice
        int[] originalCounts = new int[13];
        Arrays.fill(originalCounts, 0);

        for (int i : Dice_A) {
            for (int j : Dice_B) {
                originalCounts[i + j]++;
            }
        }

        // Placeholder transformation - ensuring no face has more than 4 spots
        int[] newDice_A = Arrays.copyOf(Dice_A, Dice_A.length);
        for (int i = 0; i < newDice_A.length; i++) {
            newDice_A[i] = Math.min(4, newDice_A[i]);
        }

        // Adjust the transformation to satisfy the condition
        int excessSpots = Arrays.stream(Dice_A).sum() - Arrays.stream(newDice_A).sum();
        for (int i = 0; i < excessSpots; i++) {
            int indexOfMax = indexOfMaxValue(newDice_A);
            newDice_A[indexOfMax]--;
        }

        // Check if the transformed dice maintain the same probabilities
        int[] transformedCounts = new int[13];
        Arrays.fill(transformedCounts, 0);

        for (int i : newDice_A) {
            for (int j : Dice_B) {
                transformedCounts[i + j]++;
            }
        }

        // Compare original and transformed probabilities
        for (int i = 2; i <= 12; i++) {
            if (transformedCounts[i] != originalCounts[i]) {
                System.out.println("Transformation Error: Probabilities do not match.");
                return Dice_A; // Return original dice in case of error
            }
        }

        return newDice_A;
    }

//----------------------------------UndoomDices Logic End---------------------------------------------------------------


//-----------------Below is the code to find maximum value and its index---------------------------------------------------------------

    static int indexOfMaxValue(int[] array) {
        int maxIndex = 0;
        int maxValue = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        
        return maxIndex;
    }
}
