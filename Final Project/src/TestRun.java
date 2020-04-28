import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class TestRun {
	//readQuestion
	public static ArrayList<String> readPromptFile(String fileName)throws FileNotFoundException {
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
	//readAnswers
	public static ArrayList<String> readAnswerFile(String fileName)throws FileNotFoundException{
		Scanner file=new Scanner(new File(fileName));
		ArrayList<String> answers=new ArrayList<String>();
		
		while (file.hasNextLine()) {
			String line=file.nextLine();
			answers.add(line);
		}
		return answers;
	}
	
	public static DoublyLinkedList storeQuestions(String catagory,String fileName1, String fileName2) throws FileNotFoundException {	
		ArrayList<String> prompts=readPromptFile(fileName1);
		ArrayList<String> answers=readAnswerFile(fileName2);
		DoublyLinkedList questions=new DoublyLinkedList();
		for (int i=0;i<prompts.size();i++){
			String prompt=prompts.get(i);
			String answer=answers.get(i);
			Question question=new Question(prompt,answer,catagory);
			questions.addNode(question);
		}	
		return questions;
	}
	
	public static void main(String[] arg) throws FileNotFoundException{
		DoublyLinkedList questions=storeQuestions("biology","src/a.txt","src/BiologyAnswer.txt");
		Node current=questions.getHead();
		while (current!=null) {
			System.out.println(current.getQuestion().printQuestion());
			System.out.println(current.getQuestion().printAnswer());
			current=current.getNext();
		}
	}
}
