package com.game.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import com.game.rpg.Position;

public class Timers implements ActionListener{
	private Timer dec_;
	private Display dis_;
	private int b;
	public Timers(Display dis){
		dis_=dis;
		dec_=new Timer(900, this);
		dec_.start();
		b=0;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Timer tim=(Timer) arg0.getSource();
		if(tim.getDelay()%300==0)
		{
			//dis_.rerepainter(0);
			//dis_.rerepainter(1);
		}
		b++;
		Position pos=new Position(dis_.getPers(1).getPos().getPosx(), dis_.getPers(1).getPos().getPosy());
		if(b==1||b==2)
			pos=new Position(dis_.getPers(1).getPos().getPosx()+32, dis_.getPers(1).getPos().getPosy());
		else if(b==3||b==4)
			pos=new Position(dis_.getPers(1).getPos().getPosx(), dis_.getPers(1).getPos().getPosy()+32);
		else if(b==5||b==6)
			pos=new Position(dis_.getPers(1).getPos().getPosx()-32, dis_.getPers(1).getPos().getPosy());
		else if(b==7||b==8)
			pos=new Position(dis_.getPers(1).getPos().getPosx(), dis_.getPers(1).getPos().getPosy()-32);
		else
			b=0;
		dis_.deplacer(pos, 1);
	}
	public void stopAnim(){
		dec_.stop();
	}
	public void startAnim(){
		dec_.start();
	}
}
