import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class TestRun {
	//readQuestions
	public static DoublyLinkedList readFile(String fileName,String catagory)throws FileNotFoundException {
		Scanner file=new Scanner(new File(fileName));
		DoublyLinkedList storeQuestion=new DoublyLinkedList();
	
		while (file.hasNextLine()){
			String onePrompt="";
			for (int i=0;i<=4;i++) {
				String line=file.nextLine();
				onePrompt+=line+"\n";
			}
			Question question=new Question(onePrompt,catagory);
			storeQuestion.insertEnd(question);
		}
		/**
		System.out.println(prompts.size());
		for (int i=0;i<prompts.size();i++) {
			System.out.println(prompts.get(i));
		}
		**/
		return storeQuestion;
	}

	public static void main(String[] arg) throws FileNotFoundException{
		DoublyLinkedList biologyQuestion=readFile("src/Biology.txt","Biology");
		biologyQuestion.readAnswerFile("src/BiologyAnswer.txt");
		
		DoublyLinkedList javaQuestion=readFile("src/Java.txt","Java");
		javaQuestion.readAnswerFile("src/JavaAnswer.txt");
		
		DoublyLinkedList movieQuestion=readFile("src/Movie.txt","Movie");
		movieQuestion.readAnswerFile("src/MovieAnswer.txt");
		
		DoublyLinkedList encyQuestion=readFile("src/Java.txt","Encylopedia");
		encyQuestion.readAnswerFile("src/EncyAnswer.txt");
		//traverse to test code
				Node current=movieQuestion.head;
				while (movieQuestion.hasNext(current)) {
					System.out.println(current.question.printQuestion());
					System.out.println(current.question.printAnswer());
					System.out.println(current.question.printCatagory());
					current=current.next;
				}
	}
}
