	import java.lang.Math.*;
	import java.util.Scanner;
	import java.util.Map;
	import java.util.HashMap;
	import java.util.ArrayList;
	import java.io.*;
	import java.io.File;
	import java.io.PrintWriter;
	import java.io.FileWriter;
	import java.io.FileReader;
	import java.io.BufferedWriter;
	import java.io.BufferedReader;

	public class QandA{
		
		public static void main(String[] args)throws Exception{
		
			File f = new File("QandA_Data.txt");
			BufferedReader reader = new BufferedReader(new FileReader(f));
			int lines = 0;
			while (reader.readLine() != null) lines++;
			reader.close();
			String UE = "", OUE = "", a;
			int i = 1;
			String[] Why = new String[]{"Because.", "Just Because.", "Why yourself."};
			Map<String, String[]> Questions = new HashMap<>();
			Questions.put("Why", Why);
			Scanner k = new Scanner(System.in);
			
			while (true){
				if (f.exists() && f.length() > 0){
					System.out.println();
					Scanner input = new Scanner(f);
					for (int c = 0; c < lines/4; c++){
						a = input.nextLine();
						Questions.put(a, new String[]{input.nextLine(),
						input.nextLine(),
						input.nextLine()});
					}
				}
				System.out.println(" Ask a question! ");
				UE = k.nextLine(); 
				UE = UE.toLowerCase();
				if(Questions.keySet().stream().filter(UE::equalsIgnoreCase).findFirst().isPresent()) {
					i = (int) Math.floor(Math.random()*3);
					System.out.println("\n"+Questions.get(UE)[i]);
				} else {
					System.out.println(" Question Not Found. Enter 3 answers to the question: ");
					OUE = k.nextLine();
					
					OUE = OUE.toLowerCase();
					Questions.put(UE, new String[3]);
					Questions.get(UE)[0] = OUE;
					OUE = k.nextLine();
					OUE = OUE.toLowerCase();
					Questions.get(UE)[1] = OUE;
					OUE = k.nextLine();
					OUE = OUE.toLowerCase();
					Questions.get(UE)[2] = OUE;
					
					PrintWriter PW = new PrintWriter(new BufferedWriter(new FileWriter(f, true))); 
					PW.println(UE.toLowerCase());
					for(int c = 0; c < 3; c++){
						PW.println(Questions.get(UE)[c].toLowerCase());
					}
					PW.close();
				}  
			}
		}
	}
