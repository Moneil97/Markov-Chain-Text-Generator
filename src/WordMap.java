import java.util.HashMap;
import java.util.Map.Entry;

public class WordMap {

	HashMap<Word, Integer> map = new HashMap<Word, Integer>();
	float total = 0;
	
	public WordMap() {}
	
	public void add(Word word){
	
		total++;
		
		if (map.containsKey(word))
			map.replace(word, map.get(word)+1);
		else
			map.put(word, 1);
	}
	
	public Word getNext(){
		
		float rand= (float) Math.random();
		float counter = 0;
		
		for(Entry<Word, Integer> entry : map.entrySet()) {
			
			int value = entry.getValue();
			float percent = value/total;
			
			if (percent + counter >= rand){
				return entry.getKey();
			}
			else{
				//say(percent + counter + " >= " + rand);
				counter += percent;
			}
			
		}
		
		return null;
		
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
	
	public void say(Object o) {
		System.out.println(o);
	}
	
}
