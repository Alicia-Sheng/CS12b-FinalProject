import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Question {
	private String prompt;
	private String answer;
	private String category;

	public Question(String prompt, String answer, String category) {
		this.prompt = prompt;
		this.answer = answer;
		this.category = category;
	}

	public String getPrompt() {
		return this.prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String category() {
		return this.category;
	}

	public void setCatagory(String category) {
		this.category = category;
	}

	public void printQuestion() {
		System.out.println(this.prompt);
	}
}