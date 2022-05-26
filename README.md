# porj1
Simply run the program and the prompts should explain what it does. 
Some things that may need to be cleared up: 
1. Grid size in Snake.java is calculated with the calcGridSize() method, which spits out an integer side length depending on how many digits the snake's length has,
using the equation 2n - 1, where n is the number of digits.
2. Snake colors that blend in with their respective environments: green with grassy, brown with muddy, gray/grey with mossy, and yellow/orange with sandy.
3. The method mainTerrainTypeOf() returns the dominant terrain type in the grid (the size of which is determined by the length of the snake) around the specified
coordinates, if there is one. If no terrain type takes up more than half the squares in the grid, then a mixed terrain type is returned and no snake of the predetermined
length can hide at those coordinates, no matter its color.
