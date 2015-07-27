import java.util.HashMap;

public class StringGenerator {

	WordMap starters = new WordMap();
	HashMap<String, Word> words = new HashMap<String, Word>();
	
	public StringGenerator() {
		
		String in = getInput();
		
		String[] sentences = in.split("\\.");
		
		for (String sentence : sentences){
			String[] wrds = sentence.trim().split(" ");
			
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
		
		say("words: " + words);
		say("starters: " + starters);
		//say(starters.getNext());
		
		Word word = starters.getNext();
		say(word);
		for (int i=0; i < 5; i++){
			word = word.getNext();
			say(word);
		}
		
		
	}
	
	private void generateSentence(){
		
	}

	private void say(Object o) {
		System.out.println(o);
	}

	private String getInput() {
		return "This is a test sentence. This is also a test sentence. Different starting word is different.";
	}

	public static void main(String[] args) {
		new StringGenerator();
	}

}
