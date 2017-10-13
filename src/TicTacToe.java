/*Simulation of TicTacToe Game
 * Two human player,no computer player*/

public class TicTacToe {
	/*Player are represented as X and O with values 1 and -1 respectively*/
	public static final int X = 1,O = -1; 
	//Empty board
	public static final int EMPTY = 0;
	//Game board
	private int [][]board = new int[3][3];
	//Current Player
	private int player;
	//Constructor
	public TicTacToe(){
		clearBoard();		//Clearing board while starting new game
	}
	//Clearing the board by assigning empty cells
	public void clearBoard(){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				board[i][j] = EMPTY;
		player = X;			//First player is 'X'
	}
	/*Checking whether given inputs by player is win config or not*/
	public boolean isWin(int mark){
		
	}
	/*Returns winning player's code or 0 to indicate a tie game or unfinished game*/
	public int winner(){
		if(isWin(X))
			return X;
		else if(isWin(O))
			return O;
		else
			return 0;		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
