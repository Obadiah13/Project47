package application;

public class Test {
	
	public static void main(String[] args) {
		//.equals() -> important when comparing the chars by str
		//.toCharArray() -> important to place the strings into char to compare to chars
		
		
		int counter = 0;		
		int i = 0;
		//int a = 0;
		String str = "hello";
		String chars = "hlew";
		
		int wordLength = str.length(); 
		//char[] word = str.toCharArray();
		//char[] characters = chars.toCharArray();		
		
		
		while (wordLength > 0){
			//char x = str.charAt(i);
			char y = chars.charAt(i);
			
			//if(x == y) {
				//System.out.println(x + " " + y);
				//counter++;
			//}
			
			if (i < chars.length()){
				System.out.println("i count: "+ i + " letter: " + y);
				i++;	
			
			wordLength--;
			}
		}
		System.out.println(counter + " " + chars + " is how many characters appeared in " + str);
	}
}