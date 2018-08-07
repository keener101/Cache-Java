import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver class for testing Cache class
 * Goes through a text file and adds each word to a String cache
 * Outputs data on hits and references at the end
 * 
 * @author Keener
 *
 */

public class Test {

	public static void main(String[] args){

		File textFile = null;
		Cache<String> lev1Cache = null;
		Cache<String> lev2Cache = null;

		if(args.length == 3 || args.length == 4){					//make sure expected # of arguments are given
			if(args[0].equals("1") || args[0].equals("2")){			//make sure that the first argument is either 1 or 2
				if(args[0].equals("1")){							//if 1 level cahce
					try{
						int size = Integer.parseInt(args[1]);		//make sure second argument is an integer (for size)

						lev1Cache = new Cache<String>(size);		//make a cache with given parameters

						textFile = new File(args[2]);				//try to make a file with the third argument

					} catch (NumberFormatException e) {				//if NFE, throw exception and print instructions
						System.out.println("Non-integer detected in size field");
						printInstructions();
					}
				}

				if(args[0].equals("2")){							//if two level cache

					try{
						int size1 = Integer.parseInt(args[1]);		//test if second and third arguments are integers (for size)
						int size2 = Integer.parseInt(args[2]);

						lev2Cache = new Cache<String>(size1, size2); //make level 2 cache with given parameters

						textFile = new File(args[3]);				// try to make file with fourth argument

					} catch (NumberFormatException e) {			//if NFE, throw exception and print instructions
						System.out.println("Non-integer detected in size field");
						printInstructions();
					} catch (Exception e){		//if other exception, print instructions
						printInstructions();
					}
				}


			}else {								//if incorrect format, print instructions
				printInstructions();
			}

			if(!textFile.equals(null)){						//if a textFile has been loaded
				try {
					Scanner scan = new Scanner(textFile);			//start a scanner

					if(lev2Cache.equals(null)){						//if 1 level cache
						while(scan.hasNext()){						//scan each token, and search cache for it
							lev1Cache.getObject(scan.next());
							

						}
						
						System.out.println("Global Hit Ratio: " + lev1Cache.getGlobalHitRatio());
						System.out.println("Level 1 Hit Ratio: " + lev1Cache.getHitRatio1());
						
					} else {										//if 2 level cache
						while(scan.hasNext()){
						
							lev2Cache.getObject(scan.next());		//scan each token, and search cache for it
							


						}
						
						System.out.println("Global Hit Ratio: " + lev2Cache.getGlobalHitRatio());
						System.out.println("Level 1 Hit Ratio: " + lev2Cache.getHitRatio1());
						System.out.println("Level 2 Hit Ratio: " + lev2Cache.getHitRatio2());
						
						
					}

					scan.close();								//close scanner


				} catch (FileNotFoundException e) {		//if any other exceptions, print stack trace
					e.printStackTrace();
				}



			}
		} else {										//if invalid number of arguments, print error and instructions
			System.out.println("Invalid number of command line parameters entered");
			printInstructions();
		}
		
		
	}
	
	/**
	 * Prints instructions for proper command line entry to the console.
	 */

	public static void printInstructions(){
		System.out.println("Please use:\n"
				+ "java Test 1 <cache size> <input textfile name>\n"
				+ "or\n"
				+ "java Test 2 <1st level cache size> <2nd level cache size> <input textfile name>");

	}

}
