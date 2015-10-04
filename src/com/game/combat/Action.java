package com.game.combat;

public class Action {
	private int x_;//coordonées de l'action
	private int y_;//	"			"
	private int dmg_;//damages
	private int efpa_;//effet retrait pa
	private int efpm_;//effet retrait pm
	public Action(int x, int y, int dmg, int efpa, int efpm){
		x_=x;
		y_=y;
		dmg_=dmg;
		efpa_=efpa;
		efpm_=efpm;
	}
	public int getX(){
		return x_;
	}
	public void setX(int x){
		x_=x;
	}
	public int getY(){
		return y_;
	}
	public void setY(int y){
		y_=y;
	}
	public int getDmg(){
		return dmg_;
	}
	public void setDmg(int dmg){
		dmg_=dmg;
	}
	public int getEfpa(){
		return efpa_;
	}
	public void setEfpa_(int efpa){
		efpa_=efpa;
	}
	public int getEfpm(){
		return efpm_;
	}
	public void set(int efpm){
		efpm_=efpm;
	}
}
