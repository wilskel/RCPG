package rngcp;

public class Chord {
	
	String basekey; int basenum, isSharp;
	
	static Chord[] keys = {
			new Chord("c", 0), //1
			new Chord("c#", 1),
			new Chord("d", 2), //2
			new Chord("d#", 3),
			new Chord("e", 4),
			new Chord("f", 5), //4
			new Chord("f#", 6),
			new Chord("g", 7), //5
			new Chord("g#", 8),
			new Chord("a", 9), //6
			new Chord("a#", 10),
			new Chord("b", 11),//7
	};
	
	public Chord(String key, int num)
	{
		basekey = key;
		basenum = num;
		isSharp = 0;
	}
	
	public String getKey() {
		return basekey;
	}
	
	static public int convertToNum(String key)
	{
		key = key.toLowerCase();
		System.out.println(key);
		int convert = -1;
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
		int[] c2  = new int[] {0,5,2,9};
		int[] c3a = new int[] {2,5,7,11};
		int[] c3b = new int[] {2,5};
		int[] c4  = new int[] {7,11};
		int[] c5  = new int[] {0,9};
		int s2, s3, s4, s5;
		
		s2 = base + c2[(int)(Math.random() * c2.length)];
		if (s2 == (base + 9)){
			s3 = base + c3b[(int)(Math.random() * c3b.length)];
		} else {
			s3 = base + c3a[(int)(Math.random() * c3a.length)];
		}
		s4 = base + c4[(int)(Math.random() * c4.length)];
		System.out.println("got here 1");
		s5 = base + c5[(int)(Math.random() * c5.length)];
		System.out.println("got here 2");
		
		s2 = s2%12; s3 = s3%12; s4 = s4%12; s5 = s5%12;
		
		String[] returnarray = new String[] {keys[s2].getKey(), keys[s3].getKey(), keys[s4].getKey(), keys[s5].getKey()};
		return returnarray;
	}
}
