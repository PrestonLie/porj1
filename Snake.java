

public class Snake 
{
   private int length;
   private int speed;
   private String color;
   private int direction;
   private String directionString;
   public String[][] terrain;
   public int gridSize;

   public Snake(int l, int s, String c, int d, int x, int y)
   {
      length = l;
      speed = s;
      color = c;
      direction = d;
      updateDirectionString();
      terrain = new String[y][x];
      initializeTerrain();
      gridSize = calcGridSize();
   }

   public void initializeTerrain()
   {
      for(int i = 0; i < terrain.length; i++)
      {
         for(int j = 0; j < terrain[0].length; j++)
         {
            int rand = (int) (Math.random()*4);
            if(rand == 0)
            {
               terrain[i][j] = "grassy";
            }
            else if(rand == 1)
            {
               terrain[i][j] = "marshy";
            }
            else if(rand == 2)
            {
               terrain[i][j] = "muddy";
            }
            else
            {
               terrain[i][j] = "sandy";
            }
         }
      }
      System.out.println("A " + terrain.length + " x " + terrain[0].length +" grid with 1 of 4 different terrain types at each coordinate has been created.");
   }

   public void canHide(int x, int y)
   {

      if(mainTerrainTypeOf(x, y).equalsIgnoreCase("grassy"))
      {
         if(color.equalsIgnoreCase("green"))
         {
            System.out.println("The terrain here is " + mainTerrainTypeOf(x, y));
            System.out.println("The snake can hide on the coordinates (" + x + ", " + y + ") if the snake coils up.");
         }
         else
         {
            System.out.println("The snake cannot hide on the coordinates (" + x + ", " + y + ") since the snake is " + color + " and the terrain at the coordinates is mainly " + mainTerrainTypeOf(x, y));
         }
      }
      else if(mainTerrainTypeOf(x, y).equalsIgnoreCase("marshy"))
      {
         if(color.equalsIgnoreCase("gray") || color.equalsIgnoreCase("grey"))
         {
            System.out.println("The terrain here is " + terrain[y][x]);
            System.out.println("The snake can hide on the coordinates (" + x + ", " + y + ") if the snake coils up.");
         }
         else
         {
            System.out.println("The snake cannot hide on the coordinates (" + x + ", " + y + ") since the snake is " + color + " and the terrain at the coordinates is mainly " + mainTerrainTypeOf(x, y));
         }
      }
      else if(mainTerrainTypeOf(x, y).equalsIgnoreCase("muddy"))
      {
         if(color.equalsIgnoreCase("brown"))
         {
            System.out.println("The terrain here is " + terrain[y][x]);
            System.out.println("The snake can hide on the coordinates (" + x + ", " + y + ") if the snake coils up.");
         }
         else
         {
            System.out.println("The snake cannot hide on the coordinates (" + x + ", " + y + ") since the snake is " + color + " and the terrain at the coordinates is mainly " + mainTerrainTypeOf(x, y));
         }
      }
      else if(mainTerrainTypeOf(x, y).equalsIgnoreCase("sandy"))
      {
         if(color.equalsIgnoreCase("yellow") || color.equalsIgnoreCase("orange"))
         {
            System.out.println("The terrain here is " + terrain[y][x]);
            System.out.println("The snake can hide on the coordinates (" + x + ", " + y + ") if the snake coils up.");
         }
         else
         {
            System.out.println("The snake cannot hide on the coordinates (" + x + ", " + y + ") since the snake is " + color + " and the terrain at the coordinates is mainly " + mainTerrainTypeOf(x, y));
         }
      }
      else if(mainTerrainTypeOf(x, y).equalsIgnoreCase("mixed"))
      {
         System.out.println("The snake cannot hide on the coordinates (" + x + ", " + y + ") since the snake is " + color + " and the terrain at the coordinates is mainly " + mainTerrainTypeOf(x, y));
      }
      else
      {
         System.out.println("The x or y values selected do not fit on the terrain grid.");
      }
   }
   

   public String mainTerrainTypeOf(int x, int y){

      int sandCount = 0;
      int marshCount = 0;
      int grassCount = 0;
      int mudCount = 0;
      try
      {
         for(int i = y - gridSize/2; i <= y + gridSize/2; i++)
         {
            for(int j = x - gridSize/2; j <= x + gridSize/2; j++)
            {
               if(terrain[i][j].equals("marshy"))
               {
                  marshCount++;
               }
               else if(terrain[i][j].equals("sandy"))
               {
                  sandCount++;
               }
               else if(terrain[i][j].equals("muddy"))
               {
                  mudCount++;
               }
               else if(terrain[i][j].equals("grassy"))
               {
                  grassCount++;
               }
            }
         }
      
         if(findMax(marshCount, sandCount, mudCount, grassCount) > gridSize*gridSize/2 && marshCount == findMax(marshCount, sandCount, mudCount, grassCount))
         {
            return "marshy";
         } 
         else if(findMax(marshCount, sandCount, mudCount, grassCount) > gridSize*gridSize/2 && sandCount == findMax(marshCount, sandCount, mudCount, grassCount))
         {
            return "sandy";
         }
         else if(findMax(marshCount, sandCount, mudCount, grassCount) > gridSize*gridSize/2 && mudCount == findMax(marshCount, sandCount, mudCount, grassCount))
         {
            return "muddy";
         }
         else if(findMax(marshCount, sandCount, mudCount, grassCount) > gridSize*gridSize/2 && grassCount == findMax(marshCount, sandCount, mudCount, grassCount))
         {
            return "grassy";
         }
         else
         {
            return "mixed";
         }
      }  
      catch(Exception e)
      {
         return "error";
      }

      
   }
   
   public int calcGridSize(){
      int count = 0;
      for(int i = length; i > 0; i/=10){
         count ++;
      }
      return count*2 - 1;
   }

   public int findMax(int a, int b, int c, int d){
      int max = a;
      max = Math.max(max, b);
      max = Math.max(max, c);
      max = Math.max(max, d);
      return max;
   }

   public void updateDirectionString()
   {
      if(direction%360 == 90)
      {
         directionString = "north";
      } 
      else if(direction%360 == 0)
      {
         directionString = "west";
      } 
      else if(direction%360 == 180)
      {
         directionString = "east";
      } 
      else if(direction%360 == 270)
      {
         directionString = "south";
      }
   }
   
   public void travel(int xFrom, int yFrom, int xTo, int yTo)
   {

      String directionX;
      String directionY;

      if(xFrom-xTo > 0)
      {
         directionX = "west";
         direction = 180;
         updateDirectionString();
      } 
      else if(xFrom-xTo < 0) 
      {
         directionX = "east";
         direction = 0;
         updateDirectionString();
      } 
      else
      {
         directionX = "";
      }

      if(yFrom-yTo > 0)
      {
         directionY = "south";
         direction = 270;
         updateDirectionString();
      } 
      else if(yFrom-yTo < 0) 
      {
         directionY = "north";
         direction = 90;
         updateDirectionString();
      } 
      else
      {
         directionY = "";
      }

      if(!directionX.equals("") && !directionY.equals(""))
      {
         System.out.println("The snake moves toward the " + directionX + " for " + (double)(Math.abs(xFrom-xTo))/speed + " seconds, covering " + Math.abs(xFrom-xTo) + " feet.");
         System.out.println("The snake moves toward the " + directionY + " for " + (double)(Math.abs(yFrom-yTo))/speed + " seconds, covering " + Math.abs(yFrom-yTo) + " feet.");
      }
      else if(directionX.equals("") && !directionY.equals(""))
      {
         System.out.println("The snake moves toward the " + directionY + " for " + (double)(Math.abs(yFrom-yTo))/speed + " seconds, covering " + Math.abs(yFrom-yTo) + " feet.");
      }
      else if(!directionX.equals("") && directionY.equals(""))
      {
         System.out.println("The snake moves toward the " + directionX + " for " + (double)(Math.abs(xFrom-xTo))/speed + " seconds, covering " + Math.abs(xFrom-xTo) + " feet.");
      }
      else
      {
         System.out.println("The snake stays still, facing " + directionString + ".");
      }

      System.out.println("The snake is currently facing " + directionString + ".");
   }

   public String toString()
   {

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

   public String getTerrainType(int x, int y)
   {
      return terrain[y][x];
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

   // public void forward(double time)
   // {
   //    System.out.println("Snake has gone" + speed * time + "feet forward.");
   //    updateDirectionString();
   //    System.out.println("The snake is facing " + directionString + ".");
   // }
   // public void back(double time)
   // {
   //    System.out.println("Snake has gone" + speed * time + "feet backward.");
   //    direction -= 180;
   //    updateDirectionString();
   //    System.out.println("The snake is facing " + directionString + ".");
   // }
   // public void right(int time)
   // {
   //    System.out.println("Snake has gone" + speed * time + "feet to the right");
   //    direction -= 90;
   //    updateDirectionString();
   //    System.out.println("The snake is facing " + directionString + ".");
   // }
   // public void left(int time)
   // {
   //    System.out.println("Snake has gone" + speed * time + "feet to the left");
   //    direction += 90;
   //    updateDirectionString();
   //    System.out.println("The snake is facing " + directionString + ".");
   // }
   

}
