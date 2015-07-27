import java.util.HashMap;

public class Word {

	String word;
	
	//HashMap<Word, Integer> next = new HashMap<Word, Integer>();
	WordMap next = new WordMap();
	
	public Word(String word) {
		 this.word = word;
	}
	
	public void add(Word word){
		
		next.add(word);
		
//		if (next.containsKey(word))
//			next.replace(word, next.get(word)+1);
//		else
//			next.put(word, 0);
	}
	
	public Word getNext(){
		return next.getNext();
	}
	
	@Override
	public boolean equals(Object obj) {
		return word == ((Word)obj).word;
	}
	
	@Override
	public int hashCode() {
		return word.hashCode();
	}
	
	@Override
	public String toString() {
		return word;
	}

}
