import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Thiseas{
    public static void main(String[] args) {

        
        try {//reads file from console
            
            //this scanner is to count the dimensions of the maze
            Scanner scan = new Scanner(new File(args[0])); 

            //this scanner is to read the values from the file to the maze
            Scanner sc = new Scanner(new File(args[0]));              
             

            //Took the coordinates of the maze
            String[] maze_coord = scan.nextLine().split(" ");  

            //Took the coordinates of the starting point
            String[] Ecoord = scan.nextLine().split(" ");
            
            
            //r counts how many lines there are in the maze
            int r = 1;
            //array that has its value (1 or 0 or E) for elements
            String [] col = scan.nextLine().split(" ");
            //loop to count the lines
            while(scan.hasNextLine()){
                scan.nextLine();
                r++;
            }
            
            //Initialize our 2D array for the maze
            String[][] maze = new String[r][col.length];  

            //Initialize our 2D array for the visited path
            boolean[][] visited = new boolean[r][col.length];




            //set visited array's elements equal to true
            for (int i = 0; i < visited.length; i++)
            {
                for (int j = 0; j < visited[i].length; j++)
                {
                    visited[i][j] = true;
                }
            }


            //skip 2 first lines
            sc.nextLine();
            sc.nextLine();


            //Register data from file to a 2D array
            while (sc.hasNextLine()){                       
                for (int i = 0; i < maze.length; i++) {                             
                    String[] line = sc.nextLine().trim().split(" ");      
                    for (int j = 0; j < line.length; j++) {
                        maze[i][j] = line [j];
                    }
                }
            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

     //function that returns true if the maze containts "E" in it and has the correct dimensions of the maze
     static boolean isSafe(String[][] maze,int x,int y) throws FileNotFoundException{
        //reads file


        //check if the maze in the text has correct numbers
        if(x!=maze.length||y!=maze[0].length){
            System.out.println("Error: The dimensions given on the first line are not the same with the size of the Maze!");
            return false;
        }
        //check if there is "E" in the maze
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j].contains("E")){
                    return true;
                }
                }
            }
            System.out.println("Error: Maze does not contain the starting point \"E\"!");
            return false;
        }
}