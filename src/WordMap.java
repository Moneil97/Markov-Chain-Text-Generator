import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class WordMap {

	HashMap<Word, Integer> map = new HashMap<Word, Integer>();
	float total = 0;
	
	public WordMap() {
		
	}
	
	public void add(Word word){
	
		total++;
		
		if (map.containsKey(word))
			map.replace(word, map.get(word)+1);
		else
			map.put(word, 1);
	}
	
	public Word getNext(){
		
		//say("getting next from: " + map);
		
		int rand = getIntBetween(0, 100);
		int counter = 0;
		
		//say("rand: " + rand);
		
		for(Entry<Word, Integer> entry : map.entrySet()) {
			
			int value = entry.getValue();
			float percent = value/total * 100;
			
			if (percent + counter > rand){
				//say(percent + " + " + counter + " > " + rand);
				return entry.getKey();
			}
			else{
				//say(percent + " + " + counter + " < " + rand);
				counter += percent;
			}
			
		}
		
		return null;
		
	}
	
//	public static void main(String args[]){
		
//		
//		say(new Word("hi").hashCode());
//		say(new Word("hi").hashCode());
//		
//		say(new Word("hi").equals(new Word("hi")));
//		say(new Word("hi") == new Word("hi"));
//		
//		WordMap words = new WordMap();
//		
//		for (String word : "This is a test sentence. This is also a test sentence.".split(" ")){
//			
//			words.add(new Word(word));
//			
//		}
//		
//		say(words.map);
//		say(words.map.containsKey(new Word("is")));
//		
		
//	}
	
	@Override
	public String toString() {
		return map.toString();
	}
	
	private static void say(Object o) {
		System.out.println(o);
	}
	
	
	
	public static Integer getIntBetween(int lower, int upper){
		
		return Math.round((float)(Math.random() * (upper - lower)) + lower);
	}
	
}
