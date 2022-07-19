package org.example.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class GameV01 {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    final String BG_RED = "\u001b[41m";
    final String BG_GREEN = "\u001b[42m";
    final String BG_WHITE = "\033[0;107m";
    final String BG_RESET = "\u001b[0m";
    final String TX_WHITE_BOLD = "\033[1;97m";
    final String TX_BLACK_BOLD = "\033[1;90m";
    final String FEATURE = "―";
    String BG_COLOR;
    String options[][] = new String[3][3];
    String board[][] = new String[3][3];
    String turn = "      ";
    String saveTurn[] = {turn, turn, turn, turn, turn, turn, turn, turn, turn}; //〇 ⨉
    String question = "\t Digite um número para marcar a posição: ";
    String bar;
    String tab;
    byte count = 1;
    byte rounds = 0;
    byte optionNumber[] = new byte[9];
    byte markedNumber;
    byte countSave = 0;
    boolean test = false;

    public void boardOptions() {


        do {
            System.out.println("\n");

            for (byte i = 0; i < board.length; i++) {
                for (byte j = 0; j < board.length; j++) {
                    if (saveTurn[countSave] == turn) {
                        board[i][j] = turn;
                    } else {
                        board[i][j] = "    " + TX_BLACK_BOLD + saveTurn[countSave] + "    ";
                    }

                    if (j == 0 || count == 3 || count == 6) {
                        tab = "\t\t\t\t";
                    } else {
                        tab = "  ";
                    }                       //tab

                    if (j == 2 || j == 5 || j == 8) {
                        bar = "";
                    } else {
                        bar = "  |";
                    }                               //bar

                    System.out.print((tab + BG_WHITE + board[i][j] + BG_RESET) + bar);             //Print
                    countSave++;
                }

                for (byte x = 0; x < options.length; x++) {
                    options[i][x] = "  " + TX_WHITE_BOLD + count + "  ";

                    if (count == 1 || count == 4 || count == 7) {
                        tab = "\t\t\t\t";
                    } else {
                        tab = "  ";
                    }                   //tab

                    if (count == 3 || count == 6 || count == 9) {
                        bar = "";
                    } else {
                        bar = "  |";
                    }                   //bar

                    for (byte op : optionNumber) {
                        if (op == count) {
                            BG_COLOR = BG_RED;
                            break;

                        } else {
                            BG_COLOR = BG_GREEN;
                        }
                    }                                                   //BGCOLOR

                    System.out.print((tab + BG_COLOR + options[i][x] + BG_RESET) + bar);           //Print
                    count++;
                }

                System.out.println();
                if (count < 9) {
                    System.out.println("\t\t\t\t" + FEATURE.repeat(20) + "\t\t\t\t" + FEATURE.repeat(15)); // linha
                }                                                               //Dividing Line

            }

            if (turn != "⨉" || turn != "〇" || turn == null) {
                int player = random.nextInt(2);
                if (player == 1) {
                    turn = "⨉";
                } else {
                    turn = "〇";
                }
            } else if (turn == "⨉") {
                turn = "〇";
            } else {
                turn = "⨉";
            }

            System.out.println();

            while(test == false) {
                System.out.print("\t\t" + question);
                markedNumber = scanner.nextByte();
                System.out.println();

                for (byte op : optionNumber) {
                    if (markedNumber == op) {
                        test = false;
                        question = "\t\t   Oops.. Essa posição já foi marcada.\n\t\t\t Escolha uma que tenha o fundo verde: ";
                        break;
                    } else {
                        test = true;
                        question = "\t Digite um número para marcar a posição: ";
                    }
                }
            }
            saveTurn[rounds] = turn;
            optionNumber[rounds] = markedNumber;
            rounds++;
            count = 1;
            countSave = 0;
            test = false;

        } while (rounds < 9);
    }
}
