import java.util.Scanner;
import java.lang.Integer;

public class SnakeRunner{

    public static void main(String args[]){
        System.out.println("Welcome! This is a program meant to represent a snake and its properties. The snake object has 4 initial attributes: length, speed, color, and initial direction. \nAdditionally, a grid representing a map of different terrain types will be randomly generated, and this grid has dimensions that can be set.");
        System.out.println("Without further ado, lets set the attributes of our new snake object.");

        Snake mySnake = new Snake(Integer.parseInt(prompt("Please enter the integer length of the snake, in feet:")), Integer.parseInt(prompt("Please enter the integer speed of the snake, in feet per second:")), prompt("Please enter the color of the snake:"), Integer.parseInt(prompt("Please enter the integer direction of the snake, with 90 being North and 270 being South:")), Integer.parseInt(prompt("Please enter the width of the terrain grid:")), Integer.parseInt(prompt("Please enter the height of the terrain grid:")));
        System.out.println("The following method will be a determination of whether or not our custom lengthed snake can hide at specific coordinates on the terrain grid. \nIf the snake's length is 1 digit long, only the terrain of at the base coordinates are checked. If the snake's length is 2 digits long, the 3x3 grid around the coordinates will be checked for a terrain majority. \nIf the snake's length is 3 digits long, the 5x5 grid will be checked, so on and so forth. This is done to reflect the fact that longer snakes take up more space when coiled up.");
        mySnake.canHide(Integer.parseInt(prompt("Please enter the integer x coordinate: ")), Integer.parseInt(prompt("Please enter the integer y coordinate: ")));


        System.out.println("Now let's begin testing the travel method of the snake class. This method takes in the x and y values of the starting coordinates and the ending coordinates and narrates the snake's trip from the starting point to the ending point.");
        mySnake.travel(Integer.parseInt(prompt("Please enter the integer starting x coordinate: ")),Integer.parseInt(prompt("Please enter the integer starting y coordinate: ")),Integer.parseInt(prompt("Please enter the integer ending x coordinate: ")),Integer.parseInt(prompt("Please enter the integer ending y coordinate: ")));
    }

    public static String prompt(String promptText)
    {

      Scanner sc = new Scanner(System.in);
      System.out.println(promptText);
      return sc.nextLine();

    }
}