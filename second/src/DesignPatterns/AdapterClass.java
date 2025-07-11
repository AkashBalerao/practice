package DesignPatterns;

interface NewCar{
	void playMusic();
}

class OldCar{
	void playOldMusic()
	{
		System.out.println("Playing music.....");
	}
}

class MusicSystem extends OldCar implements NewCar{
	public void playMusic()
	{
		playOldMusic();
	}
}

public class AdapterClass {
	
	public static void main(String [] args)
	{
		MusicSystem m1 = new MusicSystem();
		
		m1.playMusic();
	}
}
