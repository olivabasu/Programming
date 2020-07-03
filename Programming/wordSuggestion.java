package Programming;

import java.io.File;
import java.util.*;

public class wordSuggestion {

	public static void main(String[] args) throws Exception 
	{
    Scanner sc = new Scanner(System.in);
    System.out.println("What do you want to search for?");
	String str1=sc.nextLine();            //Enter the word to search in dictionary
	Set<String> set=new HashSet<>();      //an empty string is declared
	System.out.println("Did you mean?");
	int k=str1.length(),n=0;
	while(n<5)   //display until the top 5 closest words
	{
		for(int i=str1.length();i>=1;i--)
		{
			String s1=str1.substring(0,i);             //the searched keyword divided into severl segments to generate suggested words accordingly
			Scanner s = new Scanner(new File("CSVDictionary.csv"));   // Scanner class provides a constructor that produces values scanned from the specified file,it breaks data into the token form
			while (n<5 && s.hasNext())                                 //returns a boolean value  
			{ 
				String str2=s.next();
				str2=str2.substring(0,str2.length()-1);       //to eliminate the commas as delimiter has not been used here
				if(str2.contains(s1) && !(set.contains(str2)) && str2.length()==k)   //if the searched keyword is similar to words in csv file then they are printed in order of relevance
				{
					set.add(str2);                 //set used to keep track of already displayed words
					System.out.println(str2);      //similar words are printed in the output
					n++;    //number of similar words displayed incremented
				}
			} 
			s.close();                 //closes the scanner 
		}
		k++;                    //incrementing to the next most similar set of words
	}
	sc.close();                  //closes the scanner                           
	}

}
