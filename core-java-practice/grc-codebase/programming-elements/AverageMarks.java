//Sam’s mark in Maths is 94, Physics is 95 and Chemistry is 96 out of 100. Find the average percent mark in PCM.


public class AverageMarks{
    public static void main(String [] args){
	    int mathMarks = 94;
	    int physicsMarks = 95;
		int chemistryMarks = 96;
		int average = (mathMarks + physicsMarks + chemistryMarks)/3;
		System.out.println("Sam's average mark in PCM is " + average);
	}
}