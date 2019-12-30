package main.java;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Sample {
	
	public static void main(String[] args) {
		
		   int i =0;		  
		   int k =0;
		   
		      ArrayList<String> dup_ids = new ArrayList<String>();
		      ArrayList<Integer> inloop = new ArrayList<Integer>();
		      
		      String prv_Ids = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50";
		      System.out.println("ID to Check :- "+prv_Ids);
		      StringTokenizer prv_Ids_st = new StringTokenizer(prv_Ids, ",");
		      
		      while (prv_Ids_st.hasMoreTokens()) {
		    	  String token1 =	prv_Ids_st.nextToken();
		    	  i++;
		    	  String new_ids =	"51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100"; 
		    	  System.out.println("ID's bunch :- "+new_ids);
		    	  StringTokenizer new_ids_st = new StringTokenizer(new_ids, ",");
		    	  int j = 0;
		    	  while (new_ids_st.hasMoreTokens()) {
		    		  j++;
		    		  String token2 =	new_ids_st.nextToken();
		    		  System.out.println("--->dup_ids	=	>	:");
		    		  if(token1.equalsIgnoreCase(token2)) {
		    			  
		    			  dup_ids.add(new_ids_st.nextToken()) ;
		    			  System.out.println(token2+", ");
		    			  k++;
		    			  break;
		    		  }
		    		  if (dup_ids.size()==0) {
		    			  System.out.println("	No Match Found ");
		    		  }
			      }
		    	  inloop.add(j);
		      }
		      
		      for (String data : dup_ids) { 		      
		           System.out.println(data); 		
		      }
	}

}
