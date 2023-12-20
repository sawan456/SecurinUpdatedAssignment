package PartA_answers;

public class answer2 {
    public static void main(String[] args) {
        int[] diceFaces = {1, 2, 3, 4, 5, 6};
        System.out.println("Distribution of Combinations:");
        for (int row : diceFaces) {
            for (int col : diceFaces) {
                System.out.print((row + col) + " ");
            }
            System.out.println();
        }
    }
}
