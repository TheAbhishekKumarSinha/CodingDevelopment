package geeksforgeek.practice;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Sudoku {
	private static int singleHitCount =0;
	private static int[][] mappedValues =new int[9][9];
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int noOfInputs =  scan.nextInt();
		for( int sudokuInput =0;sudokuInput<noOfInputs;sudokuInput++) {
			int[][] sudukuInput = readSudoku(scan);
			solveSudoku(sudukuInput);
		}
	}

	private static void solveSudoku(int[][] sudukuInput) {
		ArrayList<Integer> missingNumberA = new ArrayList<Integer>();
		ArrayList<Integer> missingNumberB = new ArrayList<Integer>();
		ArrayList<Integer> missingNumberC = new ArrayList<Integer>();
		ArrayList<Integer> missingNumberD = new ArrayList<Integer>();
		ArrayList<Integer> missingNumberE = new ArrayList<Integer>();
		ArrayList<Integer> missingNumberF = new ArrayList<Integer>();
		ArrayList<Integer> missingNumberG = new ArrayList<Integer>();
		ArrayList<Integer> missingNumberH = new ArrayList<Integer>();
		ArrayList<Integer> missingNumberI = new ArrayList<Integer>();

		ArrayList<Integer> missingIndexesA = new ArrayList<Integer>();
		ArrayList<Integer> missingIndexesB = new ArrayList<Integer>();
		ArrayList<Integer> missingIndexesC = new ArrayList<Integer>();
		ArrayList<Integer> missingIndexesD = new ArrayList<Integer>();
		ArrayList<Integer> missingIndexesE = new ArrayList<Integer>();
		ArrayList<Integer> missingIndexesF = new ArrayList<Integer>();
		ArrayList<Integer> missingIndexesG = new ArrayList<Integer>();
		ArrayList<Integer> missingIndexesH = new ArrayList<Integer>();
		ArrayList<Integer> missingIndexesI = new ArrayList<Integer>();

		printSuduku(sudukuInput);

		missingNumberA= getNonetsMissingNumber(sudukuInput,0,0,missingIndexesA); 
		missingNumberB=getNonetsMissingNumber(sudukuInput,0,3,missingIndexesB); 
		missingNumberC=getNonetsMissingNumber(sudukuInput,0,6,missingIndexesC); 
		missingNumberD=getNonetsMissingNumber(sudukuInput,3,0,missingIndexesD); 
		missingNumberE=getNonetsMissingNumber(sudukuInput,3,3,missingIndexesE);  
		missingNumberF=getNonetsMissingNumber(sudukuInput,3,6,missingIndexesF); 
		missingNumberG=getNonetsMissingNumber(sudukuInput,6,0,missingIndexesG); 
		missingNumberH=getNonetsMissingNumber(sudukuInput,6,3,missingIndexesH); 
		missingNumberI=getNonetsMissingNumber(sudukuInput,6,6,missingIndexesI); 
		do{
			do {


				singleHitCount =0;
				findForSingleHits(sudukuInput,missingNumberA,missingIndexesA,0,0);
				findForSingleHits(sudukuInput,missingNumberB,missingIndexesB,0,3);
				findForSingleHits(sudukuInput,missingNumberC,missingIndexesC,0,6);
				findForSingleHits(sudukuInput,missingNumberD,missingIndexesD,3,0);
				findForSingleHits(sudukuInput,missingNumberE,missingIndexesE,3,3);
				findForSingleHits(sudukuInput,missingNumberF,missingIndexesF,3,6);
				findForSingleHits(sudukuInput,missingNumberG,missingIndexesG,6,0);
				findForSingleHits(sudukuInput,missingNumberH,missingIndexesH,6,3);
				findForSingleHits(sudukuInput,missingNumberI,missingIndexesI,6,6);
			}while(singleHitCount!=0);
			/*printSuduku(sudukuInput);*/
			do {
				singleHitCount =0;
				findByPencilIn(sudukuInput,missingNumberA,missingIndexesA,0,0);
				findByPencilIn(sudukuInput,missingNumberB,missingIndexesB,0,3);
				findByPencilIn(sudukuInput,missingNumberC,missingIndexesC,0,6);
				findByPencilIn(sudukuInput,missingNumberD,missingIndexesD,3,0);
				findByPencilIn(sudukuInput,missingNumberE,missingIndexesE,3,3);
				findByPencilIn(sudukuInput,missingNumberF,missingIndexesF,3,6);
				findByPencilIn(sudukuInput,missingNumberG,missingIndexesG,6,0);
				findByPencilIn(sudukuInput,missingNumberH,missingIndexesH,6,3);
				findByPencilIn(sudukuInput,missingNumberI,missingIndexesI,6,6);
			}while(singleHitCount!=0);
			do {
				singleHitCount =0;
				findUniqueNumber(sudukuInput,missingNumberA,missingIndexesA,0,0,mappedValues);
				findUniqueNumber(sudukuInput,missingNumberB,missingIndexesB,0,3,mappedValues);
				findUniqueNumber(sudukuInput,missingNumberC,missingIndexesC,0,6,mappedValues);
				findUniqueNumber(sudukuInput,missingNumberD,missingIndexesD,3,0,mappedValues);
				findUniqueNumber(sudukuInput,missingNumberE,missingIndexesE,3,3,mappedValues);
				findUniqueNumber(sudukuInput,missingNumberF,missingIndexesF,3,6,mappedValues);
				findUniqueNumber(sudukuInput,missingNumberG,missingIndexesG,6,0,mappedValues);
				findUniqueNumber(sudukuInput,missingNumberH,missingIndexesH,6,3,mappedValues);
				findUniqueNumber(sudukuInput,missingNumberI,missingIndexesI,6,6,mappedValues);
				printSuduku(mappedValues);
				printSuduku(sudukuInput);

			}while(singleHitCount!=0);
		}while(missingNumberA.size()!=0||missingIndexesB.size()!=0||missingIndexesC.size()!=0||missingIndexesD.size()!=0||missingIndexesE.size()!=0||missingIndexesF.size()!=0||missingIndexesG.size()!=0||missingIndexesH.size()!=0||missingIndexesI.size()!=0);
		/*printSuduku(mappedValues);*/
		printSuduku(sudukuInput);

	}



	private static void findUniqueNumber(int[][] sudukuInput, ArrayList<Integer> missingNumber,
			ArrayList<Integer> missingIndexes, int startOfI, int startOfJ, int[][] mappedValues) {
		Map<Integer,Integer> numberPresent = new HashMap<>();
		ArrayList<Integer> removeItem = new ArrayList<>();
		if(missingNumber.size()>0) {
			for(int i =startOfI;i<startOfI+3;i++) {
				for(int j =startOfJ;j<startOfJ+3;j++) {
					int number = mappedValues[i][j];
					int actualNumber = 0;
					while(number!=0) {
						int count =0;
						actualNumber=number%10;
						number= number/10;
						if(numberPresent.containsKey(actualNumber))
							count= numberPresent.get(actualNumber);
						count++;
						numberPresent.put(actualNumber,count);
					}
				}
			}
			/*System.out.println(numberPresent);*/
			for (java.util.Map.Entry<Integer, Integer> entry : numberPresent.entrySet()) {
				if (entry.getValue()==1) {
					for(int i =startOfI;i<startOfI+3;i++) {
						for(int j =startOfJ;j<startOfJ+3;j++) {
							/*if(entry.getKey()) {

							}*/

							int number = mappedValues[i][j];
							int actualNumber = 0;
							while(number!=0) {
								actualNumber=number%10;
								number= number/10;
								if(actualNumber==entry.getKey()) {
									missingNumber.remove(entry.getKey());
									removeItem.add(i*10+j);
									InsertValueOnPosition(i, j, entry.getKey(), sudukuInput);
									mappedValues[i][j]=0;
								}
							}


						}
					}

				}
			}missingIndexes.removeAll(removeItem);
		}



	}

	private static void findByPencilIn(int[][] sudukuInput, ArrayList<Integer> missingNumber,
			ArrayList<Integer> missingIndexes, int startOfI, int startOfJ) {
		int count =0;
		if(missingNumber.size()>0) {
			for(int i =startOfI;i<(startOfI+3);i++) {
				for(int j= startOfJ; j<(startOfJ+3);j++) {
					if(sudukuInput[i][j]==0)
						validateAllNumber(i,j,missingNumber,missingIndexes,sudukuInput);
				}
			}

		}
	}

	private static void validateAllNumber(int i, int j, ArrayList<Integer> missingNumber, ArrayList<Integer> missingIndexes, int[][] sudukuInput) {
		ArrayList<Integer> presentNumber = new ArrayList<>();
		ArrayList<Integer> missNumberRemoval = new ArrayList<>();
		ArrayList<Integer> missingIndexesRemoval = new ArrayList<>();
		for(int number: missingNumber) {
			ArrayList<Integer> removeNumber = new ArrayList<>(missingNumber);
			for(int k=0;k<9;k++) {
				if(sudukuInput[i][k]==number) {
					presentNumber.add(number);
				}if(sudukuInput[k][j]==number) {
					presentNumber.add(number);
				}
			}
			removeNumber.removeAll(presentNumber);
			if(removeNumber.size()==1) {
				InsertValueOnPosition(i, j, removeNumber.get(0), sudukuInput);
				mappedValues[i][j]= 0; 
				missNumberRemoval.addAll(removeNumber);
				missingIndexesRemoval.add(i*10+j);
			}else {
				Collections.sort(removeNumber);
				int numbers = 0;
				for(Integer value :removeNumber) {
					numbers= numbers*10;
					numbers= numbers+value;					
				}
				if(sudukuInput[i][j]==0)
					mappedValues[i][j]= numbers; 
			}
		}
		missingNumber.removeAll(missNumberRemoval);
		missingIndexes.removeAll(missingIndexesRemoval);
	}

	private static void printSuduku(int[][] sudukuInput) {
		System.out.println("");
		for(int i =0;i<9;i++) {
			for(int j =0;j<9;j++) {
				System.out.print(sudukuInput[i][j]+"\t\t"); 
			}System.out.println(""); 
		}

	}

	private static void findForSingleHits(int[][] sudukuInput, ArrayList<Integer> missingNumber,
			ArrayList<Integer> missingIndexes,int i ,int j) {
		ArrayList<Integer> numberFound = new ArrayList<>();
		for(Integer number :missingNumber) {
			boolean singleHit= false;
			singleHit = numberIJ(i,j,number,sudukuInput,missingIndexes);
			if(singleHit)
				numberFound.add(number);

		}
		missingNumber.removeAll(numberFound);
	}

	private static void InsertValueOnPosition(int i, int j, int number, int[][] sudukuInput) {

		//System.out.println("Hurray Single Index Hit ["+i+"]["+j+"] = ["+number+"]" );
		sudukuInput[i][j]=number;
		singleHitCount++;



	}
	private static boolean numberIJ(int startOfI, int startOfJ, Integer number, int[][] sudukuInput, ArrayList<Integer> missingIndexes) {
		boolean singleHit = false;
		int[] arrayHits = new int[6];
		int count=0;
		for(int i =startOfI,j=startOfJ;i<startOfI+3 && j<startOfJ+3;i++,j++)
			for(int k=0;k<9;k++) {
				if(sudukuInput[i][k]==number) {
					arrayHits[count]=i*10+k;
					count++;
				}
				if(sudukuInput[k][j]==number) {
					arrayHits[count]=k*10+j;
					count++;
				}
			}
		singleHit= validatingIJ(arrayHits,missingIndexes,number,sudukuInput);
		/*if(singleHit) {
			System.out.println("Hurray Single Index Hit ["+startOfI+"]["+j+"]");
			InsertValueOnPosition(i,j,missingNumber,sudukuInput);
		}*/return singleHit;
	}

	private static boolean validatingIJ(int[] arrayHits, ArrayList<Integer> missingIndexes,int number, int[][] sudukuInput) {
		int i =0,j=0;
		boolean singleHit = false;
		ArrayList<Integer> emptyIndex = new ArrayList<Integer>(missingIndexes);
		for(int indexes :arrayHits) {
			i= indexes/10;
			j=indexes%10;
			if(indexes!=0) {
				emptyIndex = validateIJ(i,j,emptyIndex);
			}

		}if(emptyIndex.size()==1) {
			i= emptyIndex.get(0)/10;
			j=emptyIndex.get(0)%10;
			/*System.out.println("Hurray Single Index Hit ["+i+"]["+j+"]");*/
			InsertValueOnPosition(i,j,number,sudukuInput);
			missingIndexes.remove(emptyIndex.get(0));
			singleHit=true;
		}
		return singleHit;
	}

	private static ArrayList<Integer> validateIJ(int i, int j, ArrayList<Integer> missingIndexes) {
		ArrayList<Integer> presentList = new ArrayList<Integer>();
		ArrayList<Integer> RemoveFromList = new ArrayList<Integer>(missingIndexes);
		for(int index:missingIndexes) {
			int foundI = index/10;
			int foundJ = index%10;
			if(foundI == i) {
				presentList.add(index);
			}if(foundJ == j) {
				presentList.add(index);
			}
		}
		RemoveFromList.removeAll(presentList);
		return RemoveFromList;
	}


	private static ArrayList<Integer> getNonetsMissingNumber(int[][] sudukuInput, int startOfI, int startOfJ,  ArrayList<Integer> missingIndexes) {
		Integer a[] = {1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> allNumbers= new ArrayList<>(Arrays.asList(a));
		ArrayList<Integer> presentNumber = new ArrayList<Integer>();
		ArrayList<Integer> missingNumber = new ArrayList<Integer>();
		for(int i =startOfI;i<(startOfI+3);i++) {
			for(int j= startOfJ; j<(startOfJ+3);j++) {
				if(sudukuInput[i][j]==0) {
					missingIndexes.add((i*10)+j);
				}
				if(allNumbers.contains(sudukuInput[i][j]) && sudukuInput[i][j]!=0) {
					presentNumber.add(sudukuInput[i][j]);
				}
			}
		}
		allNumbers.removeAll(presentNumber);
		missingNumber = allNumbers;
		return missingNumber;
	}

	private static int[][] readSudoku(Scanner scan) {
		int[][] sudukuInput = new int[9][9];
		for(int i =0;i<9;i++) {
			for(int j =0;j<9;j++) {
				sudukuInput[i][j] = scan.nextInt();
			}
		}
		return sudukuInput;
	}

}
