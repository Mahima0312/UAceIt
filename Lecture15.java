public class Lecture15 {

	public static void main(String[] args) {
	
		
		NQueenProblem(new boolean[8][8],0, 0, 8,"");
		Nknight(new boolean[2][2], 0, 0, 0, 2,"");
		char[][] board= {{'O','X','O','O'},{
				'O','O','O','X'},{
				'X','O','X','O'},{
				'X','O','O','X'},{
				'X','X','O','O'}};
		ratchasescheese(board, 0,0,new int[board.length][board[0].length]);


	}
	
	//Reversing LL using Recursion
	//Reversing Queue using Recursion 
	//Reversing Stack using Recursion
	
	public static void NQueenProblem(boolean[][] board, int cr, int placedQueens, int n,String answer) {
		//base case
		if(placedQueens==n)
		{
			System.out.println(answer);
			return;
		}
		
		//negative base case
		if(cr==board.length)
			return;
		
		for(int i=0;i<board[0].length;i++) // for all columns
		{
			if(itissafe(board,cr,i)) // whether you can place there or not
			{
				//placing a queen
				board[cr][i]=true; //placing the queen
				NQueenProblem(board, cr+1, placedQueens+1, n, answer+"{"+cr+"-"+i+"}"); // can i place the rest?
				board[cr][i]=false; //undo 
				
			}
		}
		// all work for columns (current row) has been done 
		
		NQueenProblem(board, cr+1, placedQueens,n,answer); //repeat the process for the whole grid
		
	}
	public static boolean itissafe(boolean[][] board, int row, int column)
	{
		//rows shouldnt be same
		// cols
		//diagnols
		//checking vertically up
		int r=row-1;
		while(r>=0)
		{
			if(board[r][column]==true)
				return false;
			r--;
		}
		//checking horizantally left
		r=row;
		int c=column-1;
		while(c>=0)
		{
			if(board[r][c]==true)
				return false;
			c--;
		}
		
		//checking diagnoal left
		r=row-1;
		c=column-1;
		while(r>=0 && c>=0)
		{
			if(board[r][c]==true)
				return false;
			r--;
			c--;
		}
		
		//checking diagnol right
		r=row-1;
		c=column+1;
		while(r>=0 && c<board[0].length)
		{
			if(board[r][c]==true)
				return false;
			r--;
			c++;
		}
		
		return true;
		

		
		
	}
	
	//0,0-> 0,1 0,2,0,3
	//0,0,-> 0,1
	public static void Nknight(boolean[][] board, int cr, int cc, int knightsPlaced, int n, String ans) {

		if (knightsPlaced == n) {

			System.out.println(ans);
			return;
		}
		if (cr == board.length) {
			return;
		}
		if (cc == board[0].length) {
			Nknight(board, cr + 1, 0, knightsPlaced, n, ans);
			return;
		}
		
		if (isitsafeforknight(board, cr, cc)) {
			board[cr][cc] = true;
			Nknight(board, cr, cc + 1, knightsPlaced + 1, n, ans + "[" + cr + "-" + cc + "]");
			board[cr][cc] = false;
		}
		Nknight(board, cr, cc + 1, knightsPlaced, n, ans);

	}

	public static boolean isitsafeforknight(boolean[][] board, int row, int col) {
		int r = row;
		int c = col;

		if (r == row - 2 && c == col - 1 && board[r][c]) {
			return false;
		}
		if (r == row - 2 && c == col + 1 && board[r][c]) {
			return false;
		}

		if (r == row - 1 && c == col - 2 && board[r][c]) {
			return false;
		}

		if (r == row - 1 && c == col + 2 && board[r][c]) {
			return false;
		}

		return true;
	}

	public static void ratchasescheese(char[][] board, int row, int col, int[][] visited) {
		
		//positive base case
		if(row==board.length-1 && col==board[0].length-1)
		{
			visited[row][col]=1;
			printArray(visited);
			return;
		}
		
		
		if(row==board.length || row<0 || col<0 || col==board[0].length || visited[row][col]==1 || board[row][col]=='X')
			return;
		
		
		visited[row][col]=1;
		
		ratchasescheese(board, row+1, col, visited);
        ratchasescheese(board, row-1, col, visited);
        ratchasescheese(board, row, col+1, visited);
        ratchasescheese(board, row, col-1, visited);
        
        visited[row][col]=0;

      
    }
	public static void printArray(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}



}
