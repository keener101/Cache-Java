# Cache-Java

BACKGROUND:

This Cache project was made in a 300-level Data Structures course. I alone coded this project.

OVERVIEW:

 Cache implements a one-level or two-level cache in Java using the LinkedList<T> library
 class. Cache records the amount of first-level and  second-level hits and references and
 can output statistics. Cache is  implemented with generics to handle any object and 
 allows the user to specify the storage size for each level. 


INCLUDED FILES:

 Cache.java - source file
 Test.java – source file, driver class for testing Cache
 README - this file


BUILDING AND RUNNING:
 
 Navigate to the directory containing all the source files. To check
 that you are in the correct directory, you can check the contents with
 the command:
 
 $ ls

 Compile all the .java files with the command:
 
 $ javac *.java

 Afterwards, you can test the compiled Cache class with the command format, depending on
 if the user wants a one-level or two-level cache:
 
 $ java Test 1 <first level size> <file location>
 or
 $ java Test 2 <first level size> <second level size> <file location>
 
 
 If the arguments are entered incorrectly, an error message will print to the console
 with these directions.
 
 

PROGRAM DESIGN:

 Cache utilizes the LinkedList<T> class from the Java libraries to implement either a 
 one-level or a two-level cache. The user specifies the size of each level during the 
 construction of the cache. When the cache is searched for an object, the first level 
 is searched, and if it does not contain the target, the second level is searched (if it
 exists). If the target is found on either of the levels, it is moved to the front of 
 each level. If it is not found on either level, it is added to the front of each level.
 By doing this, the cache ensures that it maintains multilevel inclusion property,
 where the second level always contains the first level. 
 

TESTING:

 Test is the primary mechanism for testing Cache. Test takes in a given text file, and 
 separates each word and adds it to the specified one or two-level cache. Tester outputs
 error messages and prints instructions if a input error is detected. Afterwards, Test
 prints Cache statistics to the console globally and for each level. Test outputs 
 references, or how many times the cache has been searched, hits, or how many times 
 the target has been found in the cache, and the ratio of hits/ references. 


DISCUSSION:
 
 This was a deceptively challenging project! At first blush I thought it would be very 
 simple to implement, but small errors seemed to pop up everywhere. I encountered three
 major problems. First, I encountered an error where my output values (hits and 
 references) were very far off. After swearing up and down that my code was correct, I
 realized some logic was nested incorrectly, and fixing this helped tremendously. In
 the future, I have to figure out how to manage my nested levels more efficiently. 
 
 The second error I had was very bizarre. I was getting the correct value of global 
 references, but my first and second level hits were off by about 200,000 - in different
 directions. I eventually figured out that there was an error with my logic implementing
 the multilevel inclusion property. When my cache found the target in the first level, 
 it moved it to the front of the first level, but failed to move it in the second level. 
 Fixing this brought me to almost perfect results.
 
 My third error I have yet to find an explanation for. I have multiple off-by-one 
 errors in the total output of global references and hits. For the 1k/2k cache, I expect 
 to have 1,347,451 references total - instead, I have 1,347,450. This can be seen with 
 level-one hits (expected 837,461 but output 837,462) and level-two hits (expected 
 70,483 but output 70,844). This is such a small error I assume the project used a
 slightly different way of parsing the textfile. Talking to other students, they said 
 that if they used regular expressions instead of scanner that they got the correct 
 value. I left my original implementation in because the error is so minuscule - I would 
 be interested in knowing exactly where this difference is coming from!

