package com.aurionpro.test;

import java.util.Scanner;

public class TicTacToe {
	
	public static void main(String[] args) {
		
		char board[][]=new char[3][3];
		
		initializeBoard(board);
		Scanner sc=new Scanner(System.in);
		boolean gameEnds=false;
		boolean player1Turn=true;
		System.out.print("Enter Player 1 name : ");
		String player1=sc.nextLine();
		System.out.print("Enter Player 2 name : ");
		String player2=sc.nextLine();
		
		while(!gameEnds) {
			
			showBoard(board);
			
			char storeValue='-';
			if(player1Turn) {
				System.out.println(player1 + "'s Turn (X):");
			} else {
				System.out.println(player2 + "'s Turn (O):");
			}
			
			if(player1Turn) {
				storeValue = 'X';
			} else {
				storeValue = 'O';
			}
			
			int row=0,col=0;
			while(true) {
				System.out.print("enter your move (row[1-3] column[1-3]):");
				row=sc.nextInt();
				col=sc.nextInt();
				if(row<0 || col<0 || row>2 || col>2) {
					System.out.println("PLEASE ENTER VALID VALUES!");
				}
				else if(board[row][col]!='-'){
					System.out.println("THIS POSITION ALREADY TAKEN! ENTER AGAIN");
				}
				else {
					break;
				}
			}
			board[row][col]=storeValue;
			
			if(playerWon(board) == 'X') {
				System.out.println(player1 + " has won!");
				gameEnds = true;
			} else if(playerWon(board) == 'O') {
				System.out.println(player2 + " has won!");
				gameEnds = true;
			} else {
				if(boardIsFull(board)) {
					System.out.println("It's a tie!");
					gameEnds = true;
				} else {
					//the players alternate each turn
					player1Turn = !player1Turn;
				}
			}
			
		}
		showBoard(board);
	}

	private static void initializeBoard(char[][] board) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]='-';
			}
		}
	}
	
	
	private static char playerWon(char[][] board) {
		for(int i=0;i<3;i++) {
			if(board[i][0]==board[i][1] && board[i][1]==board[i][2] && board[i][0]!='-') {
				return board[i][0];
			}
		}
		
		for(int j=0;j<3;j++) {
			if(board[0][j]==board[1][j] && board[1][j]==board[2][j] && board[0][j]!='-') {
				return board[0][j];
			}
		}
		
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
			return board[0][0];
		}
		if(board[2][0] == board[1][1] && board[1][1] ==  board[0][2] && board[2][0] != '-') {
			return board[2][0];
		}
		
		return ' ';
	}
	
	private static boolean boardIsFull(char[][] board) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}
	
	private static void showBoard(char[][] board) {
		System.out.println("Board : ");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(board[i][j]+"\t");
			}
			System.out.println();
		}
	}

}