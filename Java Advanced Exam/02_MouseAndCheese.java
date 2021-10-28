package com.company;

import java.util.Scanner;

public class Mouse {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        char[][] matrix = new char[size][size];

        int pRow = 0;
        int pCol = 0;

        int nRow = 0;
        int nCol = 0;

        for (int i = 0; i < size; i++) {
            String line = scan.nextLine();
            if (line.contains("M")) {
                pRow = i;
                pCol = line.indexOf("M");
            }
            matrix[i] = line.toCharArray();
        }


        int cheese = 0;
        String command = scan.nextLine();

        boolean bonus = false;

        while (!command.equals("end")) {

            switch (command) {
                case "up":
                    nRow = pRow - 1;
                    nCol = pCol;
                    break;

                case "down":
                    nRow = pRow + 1;
                    nCol = pCol;
                    break;

                case "left":
                    nRow = pRow;
                    nCol = pCol - 1;
                    break;

                case "right":
                    nRow = pRow;
                    nCol = pCol + 1;
                    break;
            }


            if (outOfBounds(nRow, nCol, matrix)) {
                System.out.println("Where is the mouse?");
                matrix[pRow][pCol] = '-';
                //matrix[nRow][nCol] = 'M';
                break;
            }


             if (matrix[nRow][nCol] == 'B') {
                switch (command) {
                    case "up":
                        nRow = pRow - 2;
                        nCol = pCol;

                        matrix[pRow - 1][pCol] = '-';
                        break;

                    case "down":
                        nRow = pRow + 2;
                        nCol = pCol;

                        matrix[pRow + 1][pCol] = '-';
                        break;

                    case "left":
                        nRow = pRow;
                        nCol = pCol - 2;

                        matrix[pRow][pCol - 1] = '-';
                        break;

                    case "right":
                        nRow = pRow;
                        nCol = pCol + 2;

                        matrix[pRow][pCol + 1] = '-';
                        break;
                }

            }



            if (outOfBounds(nRow, nCol, matrix)) {
                System.out.println("Where is the mouse?");
                matrix[pRow][pCol] = '-';
                //matrix[nRow][nCol] = 'M';
                break;
            }

            char symbol = matrix[nRow][nCol];

            if (matrix[nRow][nCol] == 'c') {
                cheese++;
            }

            matrix[pRow][pCol] = '-';
            matrix[nRow][nCol] = 'M';
            pRow = nRow;
            pCol = nCol;

            //printMatrix(matrix);

            command = scan.nextLine();
        }

        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        }


        printMatrix(matrix);
    }

    private static boolean outOfBounds(int r, int c, char[][] matrix) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
