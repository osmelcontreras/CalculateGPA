import java.util.Arrays; 
public class StudentUtil {

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
       
			char A = 52; //utc for 4
			char B = 51;
			char C = 50;
			
			char gradeValueA =  'z'; 
			char gradeValueB = 'y';
			char gradeValueC = 'x';
			String studentGradeLetters = " ";
			int studentId = 0;
			int countA = 0; 
			int prevCountA = 0; 
			int rowCountA = 0;
			int countB = 0; 
			int prevCountB = 0; 
			int countC = 0; 
			int prevCountC = 0;
			double calcGPA = 0;
			//double[] calcGPA = new double[2];
			int calcGPAforB = 0;
			int calcGPAforC = 0;
			
			char[] studentG = new char[] {};
			double[] gpaArray = new double[] {};
			
			for(int row = 0, i = 0; row < studentsGrades.length && i < studentIdList.length; row++, i++){
				
					//System.out.println("\n\nDisplaying grades of student "+ studentIdList[i]);
					 
					studentId = studentIdList[i];
					//student = studentIdList[i];
					//System.out.println("row: " + row);
					//	System.out.println("i: " + i);
					studentG = new char[] {};
					countA = 0;
					countB = 0;
					countC = 0;
					
				for(char col = 0; col < studentsGrades[row].length & col <= studentIdList[i]; col++){
						//	System.out.println("\nrow on loop2: " + row);
						//	System.out.println("i: " + i);
						
						
						//System.out.print(studentsGrades[row][col]);
						studentG = Arrays.copyOf(studentG, studentG.length + 1);
						studentG[studentG.length - 1] = studentsGrades[i][col];
						
					
						if(studentsGrades[row][col] == 'A') {
						//	gradeValueA = studentsGrades[row][col] ; //50 value for 2 
						//prevCountA = countA;
						
						countA++;
						//rowCountA = row;
						//studentId = studentIdList[i];
						}
						
						if(studentsGrades[row][col] == 'B') {
						//	gradeValueA = studentsGrades[row][col] ; //50 value for 2 
						countB++;
						}
						
						if(studentsGrades[row][col] == 'C') {
						//	gradeValueA = studentsGrades[row][col] ; //50 value for 2 
						countC++;
						}
						
			
							}
							
							
							
							/* prevCountA = countA - prevCountA; 
							prevCountB = countB - prevCountB; 
							prevCountC = countC - prevCountC; 
							
							double totalCount = prevCountA + prevCountB + prevCountC; 
							double gpaCalc = (prevCountA * 4) + (prevCountB * 3) + (prevCountC * 2); */ 
							
							double totalCount = countA + countB + countC; 
							double gpaCalc = (countA * 4) + (countB * 3) + (countC * 2);  
							calcGPA = gpaCalc/totalCount; 
							 
							
							/* System.out.println("\nprevCountA: " + prevCountA);
							System.out.println("\nprevCountB: " + prevCountB);
							System.out.println("\nprevCountC: " + prevCountC);
							System.out.println("\n"); */
							
							/* System.out.println("\ncountA: " + countA);
							System.out.println("\ncountB: " + countB);
							System.out.println("\ncountC: " + countC);
							System.out.println("\ncalcGPA: " + calcGPA);
							System.out.println("\nstudentGrades: " + Arrays.toString(studentG)); */
							
							//Pass GPAs to double array
							gpaArray = Arrays.copyOf(gpaArray, gpaArray.length + 1);
							gpaArray[gpaArray.length - 1] = calcGPA;
						
			}
			
/* 			System.out.println("\nstudentGrades: " + Arrays.toString(gpaArray));	
			System.out.println("\n.......End of calculateGPA method.......");				 */
			
	return gpaArray;
	}
	
  
     public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
		int[] result = new int[]{};
		int inBetweenGpa = 0;
		
		System.out.println("\n\n.......Starting of getStudentsByGPA method.......");
		
		//Parameter Validation 
		
		if ( (lower > higher) || (lower < 0) || (higher <0) || (studentIdList == null) || (studentsGrades == null)) {
			
			System.out.println("NUlL");
			return null;
		
		} else{
			
		
		//Calculate  GPAs
		double[] gpaList = calculateGPA(studentIdList, studentsGrades);
		System.out.println("\ngpaList: " + Arrays.toString(gpaList));
		
		
		for(int i = 0, s = 0;  i < gpaList.length && s < studentIdList.length; i++, s++){
			if ((lower <= gpaList[i]) &&  (gpaList[i] <= higher)){
				inBetweenGpa = studentIdList[i];
			}
		}
		System.out.println("\ngpaList: " + (inBetweenGpa));
			
		result = Arrays.copyOf(result, result.length + 1);
		result[result.length - 1] = inBetweenGpa;
		
		return result; 
		}
	} 
	
	public static void main(String[] args){
		double lower = 3.8;
		double higher = 3.5;
		int[] studentIdList = {1001, 1002, 1003};
		char[][] studentsGrades = {{'A','A','A','B'},{'B','B','B', 'A'}, {'A','A','B'}};
		
		calculateGPA(studentIdList, studentsGrades);
		getStudentsByGPA(lower, higher, studentIdList, studentsGrades);
		
	}
    
}