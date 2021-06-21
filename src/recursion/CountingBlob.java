package recursion;

public class CountingBlob {
	
	private static int BACKGROUND_COLOR = 0; 
	private static int IMAGE_COLOR = 1; 
	private static int VISITED_COLOR = 2; 
	private static int N = 8;
	private static int COUNT = 0;
	private static int[][] maze = {
			{1, 0, 0, 0, 0, 0, 0, 1},
			{0, 1, 1, 0, 0, 1, 0, 0},
			{1, 1, 0, 0, 1, 0, 1, 0},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{0, 1, 0, 1, 0, 1, 0, 0},
			{0, 1, 0, 1, 0, 1, 0, 0},
			{1, 0, 0, 0, 1, 0, 0, 1},
			{0, 1, 1, 0, 0, 1, 1, 1},
	};
	
	public static int countingBlob(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N)
			return 0;
		else if(maze[x][y] == BACKGROUND_COLOR || maze[x][y] == VISITED_COLOR)
			return 0;
		else {
			maze[x][y] = VISITED_COLOR;
			
			return 1 + countingBlob(x-1, y-1)
			+ countingBlob(x-1, y)
			+ countingBlob(x-1, y+1)
			+ countingBlob(x, y-1)
			+ countingBlob(x, y+1)
			+ countingBlob(x+1, y-1)
			+ countingBlob(x+1, y)
			+ countingBlob(x+1, y+1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(countingBlob(5, 3));
	}

}
