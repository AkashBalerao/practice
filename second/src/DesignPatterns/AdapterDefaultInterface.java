package DesignPatterns;

interface Player{
	void playmp3();
	void playmp4();
	void playgame();
}

abstract class AdapterPalyer implements Player{
	public void playmp3() {};
	public void playmp4() {};
	public void playgame() {};
}

class BasicMp3Player2 extends AdapterPalyer{
	public void playmp3()
	{
		System.out.println("Playing mp3 through basicmp3player...");
	}
}

public class AdapterDefaultInterface {
	
	public static void main(String [] args)
	{
		BasicMp3Player2 mp3player = new BasicMp3Player2();
		
		mp3player.playmp3();
	}

}
