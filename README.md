# BBC-Technical-Test
Game of Life Implementation for BBC application

Assumptions made:

We get the size of the board by the user inputted rows and columns.
We also allow the user to decide how many times the board is evolved, but we halt the evolutions
when the whole board is dead as it cannot be revived and so there's no point to evolving anymore.

I have uploaded an implementation in C and java.
My C implementation comes from an assignment in 2nd year and I haven't tested it since, so I
decided to implement it again in java instead, using the same ideas found in the C implementation.

The GameMain class holds the main method, which takes in user input to create the board and run
the evolutions a number of times, using methods in the GameOfLife class.

