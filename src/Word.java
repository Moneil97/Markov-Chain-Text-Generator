public class Word {

	String word;
	
	WordMap next = new WordMap();
	
	public Word(String word) {
		 this.word = word;
	}
	
	public void add(Word word){
		next.add(word);
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
