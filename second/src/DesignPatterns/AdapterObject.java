package DesignPatterns;

interface NewMusicPlayer{
	void play();
}

class OldMusicPlayer{
	void playMusic()
	{
		System.out.println("Playing Music....");
	}
}

class MediaPlayer implements NewMusicPlayer{
	
	private OldMusicPlayer omp;
	
	MediaPlayer(OldMusicPlayer omp)
	{
		this.omp = omp;
	}
	
	public void play()
	{
		omp.playMusic();
	}
}

public class AdapterObject {
	public static void main(String [] args)
	{
		OldMusicPlayer omp = new OldMusicPlayer();
		NewMusicPlayer nmp = new MediaPlayer(omp);
		
		nmp.play();
	}
}
