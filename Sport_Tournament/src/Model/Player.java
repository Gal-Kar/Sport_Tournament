package Model;

public class Player {
	private String name;
	private int num;
	private int gamePlayed=0;
	private boolean isPlaying;
	
	public Player(String pName,int pNum) {
		name=pName;
		num=pNum;
		isPlaying=true;
	}
	public void play() {
		gamePlayed++;
	}
	public void lose() {
		isPlaying=false;
	}
	public void setNum(int n) {
		num=n;
	}
	public boolean getIsPlaying() {
		return isPlaying;
	}
	public int getGamePlayed() {
		return gamePlayed;
	}
	public String getName() {
		return name;
	}
	public int getNum() {
		return num;
	}
}
