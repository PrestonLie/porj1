import java.util.Scanner;

public class Snake {
   private int length;
   private int speed;
   private String color;
   private int direction;
   private String directionString;

   public Snake(int l, int s, String c, int d){
      length = l;
      speed = s;
      color = c;
      direction = d;
      updateDirectionString();
   }

   public void updateDirectionString(){
      if(direction%360 == 90){
         directionString = "North";
      } else if(direction%360 == 0){
         directionString = "West";
      } else if(direction%360 == 180){
         directionString = "East";
      } else if(direction%360 == 270){
         directionString = "South";
      }
   }

   public String prompt(String promptText){

      Scanner sc = new Scanner(System.in);
      System.out.println(promptText);
      return sc.nextLine();

   }
   
   public void travel(int xFrom, int yFrom, int xTo, int yTo){

      String directionX;
      String directionY;

      if(xFrom-xTo > 0){
         directionX = "west";
         direction = 180;
         updateDirectionString();
      } else if(xFrom-xTo < 0) {
         directionX = "east";
         direction = 0;
         updateDirectionString();
      } else{
         directionX = "";
      }

      if(yFrom-yTo > 0){
         directionY = "south";
         direction = 270;
         updateDirectionString();
      } else if(yFrom-yTo < 0) {
         directionY = "north";
         direction = 90;
         updateDirectionString();
      } else{
         directionY = "";
      }

      if(!directionX.equals("") && !directionY.equals("")){
         System.out.println("The snake moves toward the " + directionX + " for " + (double)(Math.abs(xFrom-xTo))/speed + " seconds, covering " + Math.abs(xFrom-xTo) + " feet.");
         System.out.println("The snake moves toward the " + directionY + " for " + (double)(Math.abs(yFrom-yTo))/speed + " seconds, covering " + Math.abs(yFrom-yTo) + " feet.");
      }else if(directionX.equals("") && !directionY.equals("")){
         System.out.println("The snake moves toward the " + directionY + " for " + (double)(Math.abs(yFrom-yTo))/speed + " seconds, covering " + Math.abs(yFrom-yTo) + " feet.");
      }else if(!directionX.equals("") && directionY.equals("")){
         System.out.println("The snake moves toward the " + directionX + " for " + (double)(Math.abs(xFrom-xTo))/speed + " seconds, covering " + Math.abs(xFrom-xTo) + " feet.");
      }else{
         System.out.println("The snake stays still, facing " + directionString + ".");
      }
   }

   public String toString(){
      return "This snake is " + length + " feet long, goes at " + speed + " feet per second, is " + color + ", and is heading toward the " + directionString + ".";
   }

   public void setDirection(int d)
   {
      direction = d;
   }

   public void setColor(String c)
   {
      color = c;
   }

   public void setSpeed(int s)
   {
      speed = s;
   }

   public void setLength(int l)
   {
      length = l;
   }

   public String getColor()
   {
      return color;
   }

   public int getLength()
   {
      return length;
   }

   public String getDirection()
   {
      return directionString;
   }

   public int getSpeed()
   {
      return speed;
   }

   public void forward(double time)
   {
      System.out.println("Snake has gone" + speed * time + "feet forward.");
      updateDirectionString();
      System.out.println("The snake is facing " + directionString + ".");
   }
   public void back(double time)
   {
      System.out.println("Snake has gone" + speed * time + "feet backward.");
      direction -= 180;
      updateDirectionString();
      System.out.println("The snake is facing " + directionString + ".");
   }
   public void right(int time)
   {
      System.out.println("Snake has gone" + speed * time + "feet to the right");
      direction -= 90;
      updateDirectionString();
      System.out.println("The snake is facing " + directionString + ".");
   }
   public void left(int time)
   {
      System.out.println("Snake has gone" + speed * time + "feet to the left");
      direction += 90;
      updateDirectionString();
      System.out.println("The snake is facing " + directionString + ".");
   }
   

}
