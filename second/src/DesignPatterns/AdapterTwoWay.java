package DesignPatterns;

interface Mp3Player{
	void playmp3(String filename);
}

interface Mp4Player
{
	void playmp4(String filename);
}

class BasicMp3Player implements Mp3Player{
	public void playmp3(String filename)
	{
		System.out.println("Mp3 Player playing: "+filename);
	}
}

class BasicMp4Player implements Mp4Player{
	public void playmp4(String filename)
	{
		System.out.println("Mp4 Player playing: "+filename);
	}
}

class Adapter implements Mp3Player, Mp4Player{
	
	private Mp3Player mp3p;
	private Mp4Player mp4p;
	
	Adapter(Mp3Player mp3p)
	{
		this.mp3p = mp3p;
	}
	
	Adapter(Mp4Player mp4p){
		this.mp4p = mp4p;
	}
	
	public void playmp3(String filename)
	{
		if(mp3p!= null)
		{
			mp3p.playmp3(filename);
		}else {
			mp4p.playmp4(filename);
		}
	}
	
	public void playmp4(String filename)
	{
		if(mp4p!= null)
		{
			mp4p.playmp4(filename);
		}else {
			mp3p.playmp3(filename);
		}
	}
}

public class AdapterTwoWay {
	public static void main(String [] args)
	{
		BasicMp3Player basicmp3 = new BasicMp3Player();
		BasicMp4Player basicmp4 = new BasicMp4Player();

		Adapter adapter1 = new Adapter(basicmp4);
		adapter1.playmp3("song.mp4");

		Adapter adapter2 = new Adapter(basicmp3);
		adapter2.playmp4("song.mp3");
	}
}
