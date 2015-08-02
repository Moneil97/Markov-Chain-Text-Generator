import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StringGenerator {

	WordMap starters = new WordMap();
	HashMap<String, Word> words = new HashMap<String, Word>();
	
	public StringGenerator() {
		
		String in = getInput();
		
		String[] sentences = toSentences(in);
		
		for (String sentence : sentences){
			String[] wrds = toWords(sentence);
			
			//Load all words from sentence into words hashmap
			for (int i=0; i <wrds.length; i++){
				if (!words.containsKey(wrds[i])){
					words.put(wrds[i], new Word(wrds[i]));
				}
			}
			
			//add wrds[0] to starters
			starters.add(words.get(wrds[0]));
			for (int i=1; i <wrds.length; i++){
				words.get(wrds[i-1]).add(words.get(wrds[i]));
			}
			
		}
		
		//say("words: " + words);
		//say("starters: " + starters);
		
		for (int i=0; i < 10; i++)
			generateSentence();
		
	}
	
	private void generateSentence(){
		Word word = starters.getNext();
		
		while (word != null){
			System.out.print(word + " ");
			//System.out.println(word + " : " + word.next);
			word = word.getNext();
		}
		
		say("");
	}
	
	private String[] toSentences(String in){
		
		List<String> sentences = new ArrayList<String>();
		String sentence = "";
		char[] chars = in.toCharArray();
		for (int i=0; i < chars.length; i++){
			
			if (chars[i] == '.' || chars[i] == '!' || chars[i] == '?'){
				sentence += chars[i];
				sentences.add(sentence);
				sentence = "";
				i++; //to remove the space at start of next sentence
			}
			else
				sentence += chars[i];
			
		}
		
		//say("sentences: " + sentences);
		return sentences.toArray(new String[sentences.size()]);
		
	}
	
	private String[] toWords(String sentence){

		List<String> words = new ArrayList<String>();
		String word = "";
		char[] chars = sentence.toCharArray();
		for (int i=0; i < chars.length-1; i++){
			
			if (chars[i] != ' ')
				word += chars[i];
			else{
				if (!word.equals("")){
					words.add(word);
					word = "";
				}
				
			}
			
		}
		
		words.add(word);
		words.add(String.valueOf(chars[chars.length-1]));
		//say("Words: " + words);
		return words.toArray(new String[words.size()]);
		
	}

	private void say(Object o) {
		System.out.println(o);
	}

	private String getInput() {
		//return "This is a test sentence. This is also a test sentence. Different starting word is different.";
		//return "This is a test sentence. This is also a test sentence. Different starting word is different. Here we have a sentence with a comma, I wonder what will happen.";
		
		String input = "";
		
		Scanner scan = new Scanner(this.getClass().getResourceAsStream("input2.txt"));
		
		while (scan.hasNextLine())
			input += scan.nextLine() + " ";
		
		//say("input:" + input);
		
		scan.close();
		
		return input;
	}

	public static void main(String[] args) {
		new StringGenerator();
	}

}
