import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class TestRun {
	//readQuestion
	public static ArrayList<String> readFile(String fileName)throws FileNotFoundException {
		Scanner file=new Scanner(new File(fileName));
		ArrayList<String> prompts=new ArrayList<String>();
		
		while (file.hasNextLine()){
			String onePrompt="";
			for (int i=0;i<=4;i++) {
				String line=file.nextLine();
				onePrompt+=line+"\n";
			}
			prompts.add(onePrompt);
			
		}
		/**
		System.out.println(prompts.size());
		for (int i=0;i<prompts.size();i++) {
			System.out.println(prompts.get(i));
		}
		**/
		return prompts;
	}
	public static void main(String[] arg) throws FileNotFoundException{
		ArrayList<String> prompts=readFile("src/a.txt");
	
		DoublyLinkedList questions=new DoublyLinkedList();
		for (int i=0;i<prompts.size();i++) {
			String prompt=prompts.get(i);
			Question question=new Question(prompt,"a","b");
			questions.addNode(question);
		}
		Node current=questions.getHead();
		while (current!=null) {
			current.getQuestion().printQuestion();
			current=current.getNext();
		}	
	}
}
