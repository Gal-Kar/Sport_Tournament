package Model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;

public class Model {
	private List<Player> Particepent;
	private String sport;

	public Model() {
		Particepent=new ArrayList<Player>();
	}

	public void loadInfo(List<TextField> ParticepentTF,String game) {
		sport=game;
		for(int i=0;i<ParticepentTF.size();i++) {
			Particepent.add(new Player(ParticepentTF.get(i).getText(), i));
		}
	}

	public String getSport() {
		return sport;
	}

	public boolean canAddParticepent(String name) {
		for(int i=0;i<Particepent.size();i++) {
			if (Particepent.get(i).getName().toLowerCase().equals(name.toLowerCase())) {

				return false;
			}
		}
		if(Particepent.size()<8) {
			return true;
		}
		return false;
	}

	public String addParticepent(int num,String name) {
		if(name.equals("")) {
			Player p=new Player("player"+ (num+1), Particepent.size());
			Particepent.add(p);
			return p.getName();
		}
		Player p=new Player(name, Particepent.size());
		Particepent.add(p);
		return name;
	}

	public boolean isFull() {
		if(Particepent.size()==8)
			return true;
		return false;
	}

	public int play(String p1,String p2,List<TextField> scoreP1,List<TextField>scoreP2){
		List<Integer> sP1 = new ArrayList<Integer>();
		List<Integer> sP2 = new ArrayList<Integer>();
		try{	
			for(int i=0;i<scoreP1.size();i++) {
				sP1.add(Integer.parseInt(scoreP1.get(i).getText()));
				sP2.add(Integer.parseInt(scoreP2.get(i).getText()));
			}
		}catch(Exception e) {
			return -1;//error
		}
		return checkScore(p1, p2, sP1, sP2);

	}

	public int checkScore(String p1,String p2,List<Integer> scoreP1,List<Integer>scoreP2) {
		if(sport=="Tennis")
			return playTennis(p1,p2,scoreP1,scoreP2);
		int countP1 = 0,countP2=0;
		for(int i=0;i<scoreP1.size();i++) {
			countP1+=scoreP1.get(i);
			countP2+=scoreP2.get(i);
		}
		if(countP1>countP2) {
			getLoserAndWinner(p1,p2);
			return 1;//p1 win
		}
		if(countP2>countP1) {
			getLoserAndWinner(p2,p1);
			return 2;//p2 win
		}
		else
			return 3;//open next tabs
	}

	public void getLoserAndWinner(String winner,String loser) {
		removeLoser(loser);
		addToGameCount(winner);
	}

	public void removeLoser(String name) {
		for(int i=0;i<Particepent.size();i++) {
			if(name.equals(Particepent.get(i))) {
				Particepent.get(i).lose();
				break;	
			}
		}
	}

	public void addToGameCount(String name) {
		for(int i=0;i<Particepent.size();i++)
			if(Particepent.get(i).getName().equals(name))
				Particepent.get(i).play();
	}

	public int playTennis(String p1,String p2,List<Integer> scoreP1,List<Integer>scoreP2) {
		int winCountP1=0,winCountP2=0;
		for(int i=0;i<scoreP1.size();i++) {
			if(scoreP1.get(i)<6&&scoreP2.get(i)<6) {
				return -3;//tennis game can't end before someone reach 6 or higher
			}
			if(scoreP1.get(i)>6||scoreP2.get(i)>6) {
				if(Math.abs(scoreP1.get(i)-scoreP2.get(i))!=1)
					return -4;//if someone finish with more than 6 points the other player score must be a following number
			}
			if(scoreP1.get(i)==scoreP2.get(i))
				return -2;//tie error in tennis
			if(scoreP1.get(i)>scoreP2.get(i))
				winCountP1++;
			else
				winCountP2++;
		}
		if(winCountP1==3&&winCountP2==0) {
			getLoserAndWinner(p1,p2);
			return 1;//p1 win
		}
		if(winCountP1==0&&winCountP2==3) {
			getLoserAndWinner(p2,p1);
			return 2;//p2 win
		}
		if(winCountP1==4&&winCountP2==1) {
			getLoserAndWinner(p1,p2);
			return 1;//p1 win
		}
		if(winCountP1==1&&winCountP2==3) {
			getLoserAndWinner(p2,p1);
			return 2;//p2 win
		}
		if(winCountP1==3&&winCountP2==2) {
			getLoserAndWinner(p1,p2);
			return 1;//p1 win
		}
		if(winCountP1==2&&winCountP2==3) {
			getLoserAndWinner(p2,p1);
			return 2;//p2 win
		}
		return 3;//open next tab
	}	

	public String getP1Name(int butNun) {
		return getPlayer((butNun*2)).getName();
	}


	public String getP2Name(int butNun) {
		return getPlayer((butNun*2)+1).getName();
	}

	public Player getPlayer(int num) {
		for(int i=num;i<Particepent.size();i++) {
			if(Particepent.get(i).getIsPlaying()) {
				return Particepent.get(i);
			}
		}
		return null;
	}

	public Player getPlayerByName(String name) {
		for(int i=0;i<Particepent.size();i++)
			if(Particepent.get(i).getName().equals(name)) {
				return Particepent.get(i);
			}
		return null;
	}

	public boolean canPlay(String sP1,String sP2) {
		Player p1=getPlayerByName(sP1);
		Player p2=getPlayerByName(sP2);
		if(p1!=null&&p2!=null)
			if(!p1.getName().equals("")&&!p2.equals(""))
				return true;
		return false;
	}
}
