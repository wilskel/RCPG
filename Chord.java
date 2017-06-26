package rngcp;

public class Chord {
	
	String basekey; int basenum;
	
	static Chord[] keys = {
			new Chord("C", 0), //1
			new Chord("C#", 1),
			new Chord("D", 2), //2
			new Chord("D#", 3),
			new Chord("E", 4),
			new Chord("F", 5), //4
			new Chord("F#", 6),
			new Chord("G", 7), //5
			new Chord("G#", 8),
			new Chord("A", 9), //6
			new Chord("A#", 10),
			new Chord("B", 11),//7
	};
	
	public Chord(String key, int num)
	{
		basekey = key;
		basenum = num;
	}
	
	public String getKey() {
		return basekey;
	}
	
	static public int convertToNum(String key)
	{
		key = key.toUpperCase();
		int convert = -1;
		
		//Returns basenum if input is valid
		for(int i = 0; i < keys.length; i++)
		{
			if (key.equals(keys[i].getKey()))
			{
				convert = i;
			} 
		}
		return convert;
	}
	
	static public String[] generateProg(int base)
	{
		//Theory
		int[] c2  = new int[] {0,5,2,9};
		int[] c3a = new int[] {2,5,7,11};
		int[] c3b = new int[] {2,5};
		int[] c4  = new int[] {7,11};
		int[] c5  = new int[] {0,9};
		int s2, s3, s4, s5;
		
		//Generating Chords
		s2 = base + c2[(int)(Math.random() * c2.length)];
		if (s2 == (base + 9)){
			s3 = base + c3b[(int)(Math.random() * c3b.length)];
		} else {
			s3 = base + c3a[(int)(Math.random() * c3a.length)];
		}
		s4 = base + c4[(int)(Math.random() * c4.length)];
		s5 = base + c5[(int)(Math.random() * c5.length)];
		
		//Converting to 0-11
		s2 = s2%12; s3 = s3%12; s4 = s4%12; s5 = s5%12;
		
		//Sending to ChordPanel
		String[] returnarray = new String[] {keys[s2].getKey(), keys[s3].getKey(), keys[s4].getKey(), keys[s5].getKey()};
		return returnarray;
	}
}
