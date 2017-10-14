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
	/*Checking whether given inputs by player is win configuration or not*/
	public boolean isWin(int mark){
		return ((board[0][0]+board[0][1]+board[0][2] == 3*mark)||	//row 0
				(board[1][0]+board[1][1]+board[1][2] == 3*mark)||	//row 1
				(board[2][0]+board[2][1]+board[2][2] == 3*mark)||	//row 2
				(board[0][0]+board[1][0]+board[2][0] == 3*mark)||	//column 0
				(board[0][1]+board[1][1]+board[2][1] == 3*mark)||	//column 1
				(board[0][2]+board[1][2]+board[2][2] == 3*mark)||	//column 2
				(board[0][0]+board[1][1]+board[2][2] == 3*mark)||	//Main diagonal
				(board[0][2]+board[1][1]+board[2][0] == 3*mark)		//reverse diagonal
				);
	}
	/*Puts X or O mark on the board position i,j*/
	public void putMark(int i,int j){
		if((i<0)||(i>2)||(j<0)||(j>2))
			throw new IllegalArgumentException("Invalid board position");
		if(board[i][j] != EMPTY)
			throw new IllegalArgumentException("Board position not empty,position occupied");
		board[i][j] = player;	//place the mark on position i,j for current player
		player = -player;		//Switching player given that O = -X 
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
	/*Returns character string showing current board*/
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				switch(board[i][j]){
				case X:
					sb.append("X");
					break;
				case O:
					sb.append("O");
					break;
				case EMPTY:
					sb.append(" ");
					break;
				}
				if(j<2)			//column boundary
					sb.append("|");					
			}
			if(i<2)
				sb.append("\n-----\n");
		}
		return sb.toString();
	}
	/*Test run for the game*/
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		
		/*X Moves*/						/*O Moves*/
		game.putMark(1, 0);				game.putMark(0, 2);
		game.putMark(0, 1);				game.putMark(1, 2);
		game.putMark(2, 1); 			game.putMark(0, 0); 
		game.putMark(1, 1);
		System.out.println(game);
		int winningPlayer = game.winner();
		String []outcome = {"O wins","Tie","X wins"};	//rely on ordering
		System.out.println(outcome[1+winningPlayer]);

	}

}
