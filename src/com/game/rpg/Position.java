package com.game.rpg;

public class Position {
	private int x_;
	private int y_;
	public Position(int x, int y){
		x_=x;
		y_=y;
	}
	public int getPosx(){
		return x_;
	}
	public int getPosy(){
		return y_;
	}
	public void setPosx(int x){
		x_=x;
	}
	public void setPosy(int y){
		y_=y;
	}
	public boolean isEq(Position p)
	{
		if(p.getPosx()==x_&&p.getPosy()==y_)
			return true;
		return false;
	}
}
