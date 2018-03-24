package java.geeksforgeek.practice;

public class Contains123 {
    /*
     * 
     * void PrintMinNumberForPattern(String arr) { StringBuilder sb = new StringBuilder(); int
     * curr_max = 0; int last_entry = 0;
     * 
     * int j;
     * 
     * for (int i=0; i<arr.length(); i++) { int noOfNextD = 0;
     * 
     * switch(arr.charAt(i)) { case 'N':
     * 
     * j = i+1; while (arr.charAt(j) == 'M' && j < arr.length()) { noOfNextD++; j++; }
     * 
     * if (i==0) { curr_max = noOfNextD + 2;
     * 
     * 
     * sb.append(++last_entry); sb.append(curr_max);
     * 
     * last_entry = curr_max; } else { curr_max = curr_max + noOfNextD + 1;
     * 
     * last_entry = curr_max; sb.append(last_entry); } for (int k=0; k<noOfNextD; k++) {
     * sb.append(--last_entry); i++; } break;
     * 
     * // If letter is 'D' case 'M': if (i == 0) { j = i+1; while (arr.charAt(j) == 'M' && j <
     * arr.length()) { noOfNextD++; j++; }
     * 
     * 
     * curr_max = noOfNextD + 2; sb.append(curr_max +" " + (curr_max - 1)); last_entry = curr_max -
     * 1; } else { sb.append(last_entry - 1); last_entry--; } break; } } return
     * Integer.parseInt(sb.toString());
     * 
     * }
     * 
     * 
     * public static void main (String[] args) throws IOException { String abc
     * ="3142,8769,6241,2143"; findPossibleSmallestNumberMatchingPattern(abc); }
     * 
     * 
     */}
