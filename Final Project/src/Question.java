import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Question {
	private String prompt;
	private String answer;
	private String catagory;
	
	public Question(String prompt,String answer,String catagory) {
		this.prompt=prompt;
		this.answer=answer;
		this.catagory=catagory;
	}
	public String getPrompt() {
		return this.prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt=prompt;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	public void setAnswer(String answer) {
		this.answer=answer;
	}
	
	public String catagory() {
		return this.catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory=catagory;
	}
	public void printQuestion() {
		System.out.println(this.prompt);
	}
}
