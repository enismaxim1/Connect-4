package test;
public class ConnectFourAgainGUI {
	static int turn;
	static int[][] board = new int[6][7];
	static int whichRow(int j) {
		for (int i=5; i>=0; i--) {
			if (board[i][j]==0) {
				if (turn%2==0) {
					board[i][j]=1;
				} else {    
					board[i][j]=2;
				}
				return i;
			}
		} 
		return -1;
	}
	static int testDiagonal1(int i, int j, int n){//The following code is a series of recursions that make up the win-checking engine
        if (n == 3) {
            return 1;
        }
        if (board[i][j]!=0 && n<3){
            if ((i+1)<6 && (j+1)<7 && board[i+1][j+1] == board[i][j]){
                return testDiagonal1(i+1, j+1, n+1);
            } else {
            	return 0;
            }
        } else {
        	return 0;
        }
    }
    static int testDiagonal2(int i, int j, int n){
        if (n == 3) {
            return 1;
        }
        if (board[i][j]!=0 && n<3){
            if ((i+1)<6 && (j-1)>=0 && board[i+1][j-1] == board[i][j]){
                return testDiagonal2(i+1, j-1, n+1);
            } else {
            	return 0;
            }
        } else {
        	return 0;
        }
    }
    static int testRow(int i, int j, int n){
        if (n == 3) {
            return 1;
        }
        if (board[i][j]!=0 && n<3){
            if ((j+1)<7 && board[i][j+1] == board[i][j]){
                return testRow(i, j+1, n+1);
            } else {
            	return 0;
            }
        } else {
        	return 0;
        }
    }
    static int testColumn(int i, int j, int n){
        if (n == 3) {
            return 1;
        }
        if (board[i][j]!=0 && n<3){
            if ((i+1)<6 && board[i+1][j] == board[i][j]){
                return testColumn(i+1, j, n+1);
            } else {
            	return 0;
            }
        } else {
        	return 0;
        }
    }
    static boolean gameEnd() {
    	for (int i=0; i<6; i++) {
    		for (int j=0; j<7; j++) {
    			if (testRow(i, j, 0)==1||testColumn(i, j, 0)==1||testDiagonal1(i, j, 0)==1||testDiagonal2(i, j, 0)==1) {
    				return true;
    			}
    		}
    	}
    	return false;   
    }
    public static void nextTurn(){
        turn++;
        
    }
	public static void main(String[] args) {
		GUI gui = new GUI();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                gui.createAndShowGUI();
            }
        });
	}
}
