# ForLoopSpeedTest
This class is used as a demonstration of speed of execution differences between 
various looping alternatives, from the original (pre JDK 5) for-loop to modern 
stream/lambda techniques. 

While these tests are open to vagaries caused by 
things like warm-up time, fit-for-purpose, amount and difficulty of work done, 
etc., they are still useful in contemplating which technique you may want to 
use.

It should come as no surprise that the original for-loop is almost always the 
fastest, with the one exception being the Lambda Stream loop in the Double 
test.

For best results run the tests multiple times. You will get different results 
each time, though the overall ranking will be the same. You should also change 
the size of the collection (mostly smaller) to again see different results, 
though not as great as you might expect.