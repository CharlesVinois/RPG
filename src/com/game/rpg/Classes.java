package com.game.rpg;

public class Classes {
	//1 Assassin, 2 Guerrier, 3 Archer
	private int cla_;
	private Races ra_;
	private Stats st_;
	public Classes(int cl, Races r){
		cla_=cl;
		ra_=r;
		st_=new Stats();
		if(cl==1){
			st_.setAd(13);
			st_.setAg(10);
			st_.setAr(13);
			st_.setCr(13);
			st_.setEs(15);
			st_.setPa(6);
			st_.setPm(3);
			st_.setPv(108);
		}
		else if(cl==2)
		{
			st_.setAd(10);
			st_.setAg(13);
			st_.setAr(15);
			st_.setCr(10);
			st_.setEs(13);
			st_.setPa(6);
			st_.setPm(3);
			st_.setPv(110);
		}
		else if(cl==3)
		{
			st_.setAd(15);
			st_.setAg(13);
			st_.setAr(10);
			st_.setCr(15);
			st_.setEs(10);
			st_.setPa(6);
			st_.setPm(3);
			st_.setPv(105);
		}
	}
	public void setclasse(int cl, Races r){
		cla_=cl;
		ra_=r;
		if(cl==1){
			st_.setAd(13);
			st_.setAg(10);
			st_.setAr(13);
			st_.setCr(13);
			st_.setEs(15);
			st_.setPa(6);
			st_.setPm(3);
			st_.setPv(108);
		}
		else if(cl==2)
		{
			st_.setAd(10);
			st_.setAg(13);
			st_.setAr(15);
			st_.setCr(10);
			st_.setEs(13);
			st_.setPa(6);
			st_.setPm(3);
			st_.setPv(110);
		}
		else if(cl==3)
		{
			st_.setAd(15);
			st_.setAg(13);
			st_.setAr(10);
			st_.setCr(15);
			st_.setEs(10);
			st_.setPa(6);
			st_.setPm(3);
			st_.setPv(105);
		}
	}
	public int getClasse(){
		return cla_;
	}
	public Stats getStats(){
		return st_;
	}
}
