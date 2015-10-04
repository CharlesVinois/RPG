package com.game.rpg;
//import android.media.Image;
public class Objets {
	private Stats st_;
	//private Image img_;
	private String name_;
	public Objets(Stats st, String name){
		st_=st;
		name_=name;
	}
	public Stats getStats(){
		return st_;
	}
	public String getName(){
		return name_;
	}
}
