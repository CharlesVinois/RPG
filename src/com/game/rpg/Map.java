package com.game.rpg;
//import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class Map {
	private int size_;//local size (square map)
	private String namer_;//name region
	private String namel_;//name zone
	private Position locat_;//general location
	private ArrayList<Decort> decorts_;
	private ArrayList<Position> pos_;
	private ArrayList<Personnage> pers_;
	//private Image img_;
	public Map(Position loc){
		size_=15;
		namer_="";
		namel_="";
		locat_=loc;
		decorts_= new ArrayList<Decort>();
		pers_= new ArrayList<Personnage>();
		pos_= new ArrayList<Position>();
		JLabel dec3 = new Decort(16, setCalibr(new Position(10, 3), 1), 1, "Rocher", false, false, true, new ImageIcon("src/Map/Rocher_Grand_Icon.png"));
		decorts_.add((Decort)dec3);
		JLabel dec5 = new Decort(16, setCalibr(new Position(5, 12), 1), 1, "Rocher", false, false, true, new ImageIcon("src/Map/Rocher_Grand_Icon.png"));
		decorts_.add((Decort)dec5);
		JLabel dec6 = new Decort(61, setCalibr(new Position(12, 12), 5), 1, "Arbre", false, false, true, new ImageIcon("src/Map/Arbre_Grand_Icon.png"));
		decorts_.add((Decort)dec6);
		JLabel dec7 = new Decort(1, setCalibr(new Position(10, 10), 3), 1, "Buisson", false, false, true, new ImageIcon("src/Map/Buisson_Icon.png"));
		decorts_.add((Decort)dec7);
		JLabel dec8 = new Decort(1, setCalibr(new Position(6, 6), 3), 1, "Buisson", false, false, true, new ImageIcon("src/Map/Buisson_Icon.png"));
		decorts_.add((Decort)dec8);
		JLabel dec9 = new Decort(1, setCalibr(new Position(1, 10), 3), 1, "Buisson", false, false, true, new ImageIcon("src/Map/Buisson_Icon.png"));
		decorts_.add((Decort)dec9);
		JLabel dec10 = new Decort(1, setCalibr(new Position(1, 5), 3), 1, "Buisson", false, false, true, new ImageIcon("src/Map/Buisson_Icon.png"));
		decorts_.add((Decort)dec10);
		setPosR();
		JLabel dec1 = new Decort(16, getPaddedPos(16), 1, "Rocher", false, false, true, new ImageIcon("src/Map/Rocher_Grand_Icon.png"));
		decorts_.add((Decort)dec1);
		JLabel dec4 = new Decort(61, getPaddedPos(61), 1, "Arbre", false, false, true, new ImageIcon("src/Map/Arbre_Grand_Icon.png"));
		decorts_.add((Decort)dec4);
	}
	public Position getRandPos(){
		Position pos;
		Random rand=new Random();
		pos=new Position(rand.nextInt(15)+1, rand.nextInt(15)+1);
		return pos;
	}
	public Position setCalibr(Position pos, int typ){
		//if typ = 1 roocher/ =2 arbre / =3 buisson/ =4 pers
		Position posed=new Position(0, 0);
		int x,y;
		int typ_=typ;
		if(typ_==1)
		{
			x=((pos.getPosy()+1)*32)-59;
			y=((pos.getPosx()+1)*32)-59;
		}
		else if(typ_==2)
		{
			x=((pos.getPosy()+1)*32)-86;
			y=((pos.getPosx()+1)*32)-58;
		}
		else if(typ_==3)
		{
			x=((pos.getPosy()+1)*32)-65;
			y=((pos.getPosx()+1)*32)-60;
		}
		else if(typ_==4)
		{
			x=((pos.getPosy()+1)*32)-45;
			y=((pos.getPosx()+1)*32)-25;
		}
		else if(typ==5)
		{
			x=((pos.getPosy()+1)*32)-120;
			y=((pos.getPosx()+1)*32)-58;
		}
		else
		{	x=((pos.getPosy()+1)*32)-32;
			y=((pos.getPosx()+1)*32)-32;
		}
		posed.setPosy(x);
		posed.setPosx(y);
		return posed;
	}	
	public void setMap(int siz, String namer, String namel, Position loc, ArrayList<Decort> decorts){
		size_=siz;
		namer_=namer;
		namel_=namel;
		locat_=loc;
		decorts_=decorts;
	}
	public void setPosR(){
		for(int i=0;i<decorts_.size();i++)
		{
			if(decorts_.get(i).getSiz()==1)
			{
				Position p1=new Position(decorts_.get(i).getPos().getPosx()+3, decorts_.get(i).getPos().getPosy()-12);
					pos_.add(p1);
			}
			if(decorts_.get(i).getSiz()==61)
			{
				Position p2=new Position(decorts_.get(i).getPos().getPosx()+1, decorts_.get(i).getPos().getPosy()-21);
					pos_.add(p2);
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+1, decorts_.get(i).getPos().getPosy()-21+32));
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+1, decorts_.get(i).getPos().getPosy()-21+64));
				
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+1+32, decorts_.get(i).getPos().getPosy()-21));
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+1+32, decorts_.get(i).getPos().getPosy()-21+32));
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+1+32, decorts_.get(i).getPos().getPosy()-21+64));
			}
			if(decorts_.get(i).getSiz()==16)
			{
				Position p3=new Position(decorts_.get(i).getPos().getPosx()+2, decorts_.get(i).getPos().getPosy()+14-32);
					pos_.add(p3);
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+2+32, decorts_.get(i).getPos().getPosy()+14-32));
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+2+64, decorts_.get(i).getPos().getPosy()+14-32));
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+2+96, decorts_.get(i).getPos().getPosy()+14-32));
	
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+2, decorts_.get(i).getPos().getPosy()+14));
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+2+32, decorts_.get(i).getPos().getPosy()+14));
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+2+64, decorts_.get(i).getPos().getPosy()+14));
					pos_.add(new Position(decorts_.get(i).getPos().getPosx()+2+96, decorts_.get(i).getPos().getPosy()+14));
			}
		}
	}
	public Position getPaddedPos(int typ){
		Position pp=getRandPos();
		Position p=null;
		while(!isplacable(pp))
			pp=getRandPos();
		
		if(typ==1)
		{
			p=setCalibr(pp, 3);
			Position p1=new Position(p.getPosx()+3, p.getPosy()-12);
				pos_.add(p1);
		}
		if(typ==61)
		{
			p=setCalibr(pp, 5);
			Position p2=new Position(p.getPosx()+1, p.getPosy()-21);
				pos_.add(p2);
				pos_.add(new Position(p.getPosx()+1, p.getPosy()-21+32));
				pos_.add(new Position(p.getPosx()+1, p.getPosy()-21+64));
			
				pos_.add(new Position(p.getPosx()+1+32, p.getPosy()-21));
				pos_.add(new Position(p.getPosx()+1+32, p.getPosy()-21+32));
				pos_.add(new Position(p.getPosx()+1+32, p.getPosy()-21+64));
		}
		if(typ==16)
		{
			p=setCalibr(pp, 1);
			Position p3=new Position(p.getPosx()+2, p.getPosy()+14-32);
				pos_.add(p3);
				pos_.add(new Position(p.getPosx()+2+32, p.getPosy()+14-32));
				pos_.add(new Position(p.getPosx()+2+64, p.getPosy()+14-32));
				pos_.add(new Position(p.getPosx()+2+96, p.getPosy()+14-32));

				pos_.add(new Position(p.getPosx()+2, p.getPosy()+14));
				pos_.add(new Position(p.getPosx()+2+32, p.getPosy()+14));
				pos_.add(new Position(p.getPosx()+2+64, p.getPosy()+14));
				pos_.add(new Position(p.getPosx()+2+96, p.getPosy()+14));
		}
		return p;
	}
	public boolean isplacable(Position po){
		for(int i=0;i<pos_.size();i++)
			if(pos_.get(i).isEq(po))
					return false;
			return true;
	}
	public int getSize(){
		return size_;
	}
	public void setSize(int siz){
		size_=siz;
	}
	public String getNamer(){
		return namer_;
	}
	public void setNamer(String nar){
		namer_=nar;
	}
	public String getNamel(){
		return namel_;
	}
	public void setNamel(String nal){
		namel_=nal;
	}
	public Position getLocat(){
		return locat_;
	}
	public void setLocatx(Position loc){
		locat_=loc;
	}
	public ArrayList<Decort> getDecort(){
		return decorts_;
	}
	public void setDecort(ArrayList<Decort> ld){
		decorts_=ld;
	}
	public ArrayList<Personnage> getPers(){
		return pers_;
	}
	public void setPers(ArrayList<Personnage> pers){
		pers_=pers;
	}
	public ArrayList<Position> getPos() {
		return pos_;
	}
	public void setPos(ArrayList<Position> pos_) {
		this.pos_ = pos_;
	}
	public void setInvis(){
		for(int i=0;i<decorts_.size();i++)
			decorts_.get(i).setVisible(false);
	}
}
