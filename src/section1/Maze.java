package section1;

public class Maze {
	private static int N = 8; //출구는 N-1, N-1
	private static int[][] maze = {
			{0, 0, 0, 0, 0, 0, 0, 1},
			{0, 1, 1, 0, 1, 1, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 0, 1, 1, 0, 0},
			{0, 1, 1, 1, 0, 0, 1, 1},
			{0, 1, 0, 0, 0, 1, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 1},
			{0, 1, 1, 1, 0, 1, 0, 0},
	};
	
	private static final int PATHWAY_COLOR = 0; 
	private static final int WALL_COLOR = 1; 
	private static final int BLOCKED_COLOR = 2; // visited 이며 출구로 가는 경로상에 있지 않음이 밝혀짐
	private static final int PATH_COLOR = 3;  //visited이며 아직 출구로 가능 경로일 가능성이 있음
	
	public static boolean findMazePath(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N)
			return false;
		else if(maze[x][y] != PATHWAY_COLOR)
			return false;
		else if(x==N-1 && y==N-1) {
			maze[x][y] = PATH_COLOR;
			return true;
		}
		else {
			maze[x][y] = PATH_COLOR;
			if(findMazePath(x-1, y) || findMazePath(x, y+1) 
					|| findMazePath(x+1, y) || findMazePath(x, y-1))
				return true;
			maze[x][y] = BLOCKED_COLOR;
			return false;
		}
	}
	
	public static void main(String[] args) {
		findMazePath(0, 0);
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j<maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}
}

