import java.util.*;
import java.io.*;

public class Question {
	private String prompt;
	private String answer;
	private String catagory;
	
	public Question(String prompt,String answer,String catagory) {
		this.prompt=prompt;
		this.answer=answer;
		this.catagory=catagory;
	}
	public Question (String prompt,String catagory) {
		this.prompt=prompt;
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
	public String printQuestion() {
		return this.prompt;
	}
	public String printAnswer() {
		return this.answer;
	}
	public String printCatagory() {
		return this.catagory;
	}
}
