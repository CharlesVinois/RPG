package com.game.ihm;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.button.Details;
import com.game.button.InfoPers;
import com.game.button.Parametres;
import com.game.rpg.Classes;
import com.game.rpg.Decort;
import com.game.rpg.Map;
import com.game.rpg.Personnage;
import com.game.rpg.Position;
import com.game.rpg.Races;

public class Display extends JPanel{
	private static final long serialVersionUID = 1L;
	private Screen sc_;
	private Combat cb_;
	private Map init_;
	private Details det_;
	private int oldposx;
	private int oldposy;
	private int place;
	private int pmcb;
	private Parametres param;
	private Timers tim_;
	private InfoPers detail_;
	private JFrame dad_;
	private ArrayList<Map> word_;
	private ArrayList<Personnage> pers1_;
	private ArrayList<Personnage> pers2_;
	public Display(JFrame dad) {
		oldposx=300;
		oldposy=200;
		place=0;
		pmcb=0;
		dad_=dad;
		word_=new ArrayList<Map>();
		init_ = new Map(new Position(0, 0));
		word_.add(init_);
		sc_=new Screen(586, 586, this);
		det_=new Details(this);
		detail_=new InfoPers(this);
		param=new Parametres(this);
		this.add(param);
		this.add(detail_);
		this.add(det_);
		setPlayer();
		addToScreen(0);
		this.add(sc_);
		tim_=new Timers(this);
		this.setSize(586, 586);
		setLayout(null);
	}
	public void inFight(){
		Personnage pers1, pers2;
		pers1=init_.getPers().get(0);
		pers2=init_.getPers().get(1);
		tim_.stopAnim();
		cb_= new Combat(this, true);
		init_.getPers().get(0).setEtat(2);
		oldposx=pers1.getPos().getPosx();
		oldposy=pers1.getPos().getPosy();
		sc_.setVisible(false);
		((ActioBar) dad_.getContentPane().getComponent(1)).setFight();
		this.add(cb_);
		//pers1.setLifeBar();
		//pers2.setLifeBar();
		pers1.setPos(setCalibr(new Position(0, 8), 4));
		pers2.setPos(setCalibr(new Position(17, 8), 4));
		pers1.setLocation(setCalibr(new Position(0, 8), 4).getPosx(), setCalibr(new Position(0, 8), 4).getPosy());
		pers2.setLocation(setCalibr(new Position(17, 8), 4).getPosx(), setCalibr(new Position(17, 8), 4).getPosy());
		pers1.setVisible(true);
		pers2.setVisible(true);
	}
	public void endFight(){
		Personnage pers1, pers2;
		init_.getPers().get(0).setEtat(1);
		sc_.setVisible(true);
		cb_.setVisible(false);
		tim_.startAnim();
		pers1=init_.getPers().get(0);
		pers2=init_.getPers().get(1);
		pers1.setPos(setCalibr(new Position(7, 5), 4));
		pers2.setPos(setCalibr(new Position(10, 7), 4));
		pers1.setLocation(setCalibr(new Position(7, 5), 4).getPosx(), setCalibr(new Position(7, 5), 4).getPosy());
		pers2.setLocation(setCalibr(new Position(10, 7), 4).getPosx(), setCalibr(new Position(10, 7), 4).getPosy());
		pers1.setVisible(true);
		pers2.setVisible(true);
	}
	public void setPlayer()
	{
		pers1_= new ArrayList<Personnage>();
		pers2_= new ArrayList<Personnage>();
		ArrayList<Personnage> pers_= new ArrayList<Personnage>();
		Personnage pers1 = new Personnage(new Races(1), new Classes(1, new Races(1)), null, setCalibr(new Position(6, 4), 4), new ImageIcon("src/Pers/Hibou_Icon.png"), true);
		pers1.setEtat(1);
		pers_.add(pers1);
		pers1_.add(pers1);
		this.add(pers1);
		Personnage pers2 = new Personnage(new Races(1), new Classes(1, new Races(1)), null, setCalibr(new Position(9, 6), 4), new ImageIcon("src/Pers/CoteGaucheIcon.png"), false);
		pers_.add(pers2);
		pers2_.add(pers2);
		this.add(pers2);
		init_.setPers(pers_);
	}
	public void addToScreen(int mapp){
		for(int i=0;i<word_.get(mapp).getDecort().size();i++)
			this.add(word_.get(mapp).getDecort().get(i));
	}
	public void deplacer(Position to, int num){
		Personnage pers1=init_.getPers().get(num);
		pers1.setVisible(false);
		Position too=new Position(0, 0);
		if(num==0)
			too= setCalibr(new Position(to.getPosx(), to.getPosy()), 4);
		else
			too=to;
		if(setUnsign(too.getPosx())>586||setUnsign(too.getPosx())>586)
			return;
		else
		{
				Position ppoo= new Position(pers1.getPos().getPosx(), pers1.getPos().getPosy());
				int nxc=ppoo.getPosx()-too.getPosx();
				int nyc=ppoo.getPosy()-too.getPosy();
				int unx=setUnsign(nxc);
				int uny=setUnsign(nyc);
				if(nxc<=0&&nyc<=0)
				{	
					if(pers1.getEtat()==2&&!ismove(pers1.getPos(), too, 1, num))
							return;
					else
						mover(unx, uny, ppoo.getPosx(), ppoo.getPosy(), too, 1, pers1, num, true);
					//System.out.println("Case<=&&<=");
				}
				else if(nxc>=0&&nyc>=0)
				{
					if(pers1.getEtat()==2&&!ismove(pers1.getPos(), too, 4, num))
						return;
					else
						mover(unx, uny, ppoo.getPosx(), ppoo.getPosy(), too, 4, pers1, num, true);
					//System.out.println("Case>=&&>=");
				}
				else if(nxc>=0&&nyc<=0)
				{
					if(pers1.getEtat()==2&&!ismove(pers1.getPos(), too, 3, num))
						return;
					else
						mover(unx, uny, ppoo.getPosx(), ppoo.getPosy(), too, 3, pers1, num, true);
					//System.out.println("Case>=&&<=");
				}
				else if(nxc<=0&&nyc>=0)
				{	
					if(pers1.getEtat()==2&&!ismove(pers1.getPos(), too, 2, num))
						return;
					else
						mover(unx, uny, ppoo.getPosx(), ppoo.getPosy(), too, 2, pers1, num, true);
					//System.out.println("Case<=&&>=");
				}
		}
	}
	public void mover( int ii, int jj, int px, int py, Position in, int cases, Personnage pe, int index, boolean typ){
		int unx=ii;
		int uny=jj;
		int ppx=px;
		int ppy=py;
		int caze=cases;
		int i=0;
		int j=0;
		boolean xy=true;
		for(int k=0;k<2;k++)
		{
			if(xy)
			{
				for(;i<unx;i=i+32)
				{
						oldposx=pe.getPos().getPosx();
						oldposy=pe.getPos().getPosy();
						if(caze==1)
						{
							Position p=new Position(ppx+i+32, ppy+j);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=false;
								break;
							}
						}
						else if(caze==2)
						{	
							Position p=new Position(ppx+i+32, ppy-j);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=false;
								break;
							}
						}
						else if(caze==3)
						{	Position p=new Position(ppx-i, ppy+j);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=false;
								break;
							}
						}
						else if(caze==4)
						{	Position p=new Position(ppx-i-32, ppy-j);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=false;
								break;
							}
						}
						else
							System.out.println("unbound pos ppx i ppy j");
						rerepainter(index);
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
				//System.out.println("xy");
			}
			if(xy)
			{
				for(;j<uny;j=j+32)
				{
						oldposx=pe.getPos().getPosx();
						oldposy=pe.getPos().getPosy();
						if(caze==1)
						{
							Position p=new Position(ppx+i, ppy+j+32);
							if(init_.isplacable(p)&&typ)	
								pe.setPos(p);
							else
							{
								xy=false;
								break;
							}
							
						}
						else if(caze==2)
						{
							Position p=new Position(ppx+i, ppy-j-32);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=false;
								break;
							}
						}
						else if(caze==3)
						{
							Position p=new Position(ppx-i, ppy+j+32);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=false;
								break;
							}
						}
						else if(caze==4)
						{
							Position p=new Position(ppx-i, ppy-j-32);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=false;
								break;
							}
						}
						else
							System.out.println("unbound pos ppx i ppy j");
						rerepainter(index);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}
				//System.out.println("xy");
			}
			else if(!xy)
			{
				for(;j<uny;j=j+32)
				{
						oldposx=pe.getPos().getPosx();
						oldposy=pe.getPos().getPosy();
						if(caze==1)
						{
							Position p=new Position(ppx+i, ppy+j+32);
							if(init_.isplacable(p)&&typ)	
								pe.setPos(p);
							else
							{
								xy=true;
								break;
							}
						}
						else if(caze==2)
						{
							Position p=new Position(ppx+i, ppy-j-32);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=true;
								break;
							}
						}
						else if(caze==3)
						{
							Position p=new Position(ppx-i, ppy+j+32);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=true;
								break;
							}
						}
						else if(caze==4)
						{
							Position p=new Position(ppx-i, ppy-j-32);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=true;
								break;
							}
						}
						else
							System.out.println("unbound pos ppx i ppy j");
						rerepainter(index);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					//System.out.println("yx");
				}
			}
			if(!xy)
			{
				for(;i<unx;i=i+32)
				{
						oldposx=pe.getPos().getPosx();
						oldposy=pe.getPos().getPosy();
						if(caze==1)
						{
							Position p=new Position(ppx+i+32, ppy+j);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=true;
								break;
							}
						}
						else if(caze==2)
						{	
							Position p=new Position(ppx+i+32, ppy-j);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=true;
								break;
							}
						}
						else if(caze==3)
						{	Position p=new Position(ppx-i, ppy+j);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=true;
								break;
							}
						}
						else if(caze==4)
						{	Position p=new Position(ppx-i-32, ppy-j);
							if(init_.isplacable(p)&&typ)
								pe.setPos(p);
							else
							{
								xy=true;
								break;
							}
						}
						else
							System.out.println("unbound pos ppx i ppy j");
						rerepainter(index);
						
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
				}	
				//System.out.println("yx");
			}
		}
		rerepainter(index);
	}
	public void actioner(Map ma, Position to, int index){
		Position too= setCalibr(new Position(to.getPosx(), to.getPosy()), 4);
		if(init_.getPers().size()>1&&init_.getPers().get(index).getPos().getPosx()==too.getPosx() && init_.getPers().get(index).getPos().getPosy()==too.getPosy())
		{
			detail_.setPers(init_.getPers().get(index));
			det_.setPos(too);
			det_.setVisible(true);
		}
		else
			det_.setVisible(false);
		Position md= setCalibr(new Position(17, 8), 4);
		Position mg= setCalibr(new Position(0, 8), 4);
		Position mh= setCalibr(new Position(8, 0), 4);
		Position mb= setCalibr(new Position(8, 17), 4);
		
		if(too.getPosx()==md.getPosx() && too.getPosy()==md.getPosy())
		{
			moveMap(4);
		}
		else if(too.getPosx()==mg.getPosx() && too.getPosy()==mg.getPosy())
		{
			moveMap(3);
		}
		else if(too.getPosx()==mh.getPosx() && too.getPosy()==mh.getPosy())
		{
			moveMap(1);
		}
		else if(too.getPosx()==mb.getPosx() && too.getPosy()==mb.getPosy())
		{
			moveMap(2);
		}
	}
	public void rerepainter(int index){
		Personnage p=init_.getPers().get(index);
		Graphics g=getGraphics();
		g.fillRect(oldposx, oldposy, p.getImageIcon().getIconWidth(), p.getImageIcon().getIconHeight());
		if(p.getEtat()==1)
		{
			sc_.getCell(((oldposy+45)/32)-1, ((oldposx+25)/32)-1).repaintcel();
			sc_.getCell(((oldposy+45)/32)-2, ((oldposx+25)/32)-1).repaintcel();
		}
		else
		{
			cb_.getCell(((oldposy+45)/32)-1, ((oldposx+25)/32)-1).repaintcel();
			cb_.getCell(((oldposy+45)/32)-2, ((oldposx+25)/32)-1).repaintcel();
			
			for(int i=0;i<18;i++)
				for(int j=0;j<18;j++)	
				{	
					if(cb_.getCell(i, j).getCliqued())
						cb_.getCell(i, j).repaintcel();
				}
		}
		getGraphics().drawImage(p.getImage(), p.getPos().getPosx(), p.getPos().getPosy(), null);
	}
	public void moveMap(int direction){
		//1haut, 2bas, 3gauche et 4droite
		Personnage pers1;
		Map map;
		place++;
		pers1=init_.getPers().get(0);
		tim_.stopAnim();
		oldposx=pers1.getPos().getPosx();
		oldposy=pers1.getPos().getPosy();
		sc_.setVisible(false);
		ArrayList<Personnage> pers=new ArrayList<Personnage>();
		if(direction==1)
		{
			map=new Map(new Position(init_.getLocat().getPosx()-1, init_.getLocat().getPosy()));
			pers1.setPos(setCalibr(new Position(8, 17), 4));
			pers1.setLocation(setCalibr(new Position(8, 17), 4).getPosx(), setCalibr(new Position(8, 17), 4).getPosy());
		}
		else if(direction==2)
		{
			map=new Map(new Position(init_.getLocat().getPosx()+1, init_.getLocat().getPosy()));
			pers1.setPos(setCalibr(new Position(8, 0), 4));
			pers1.setLocation(setCalibr(new Position(8, 0), 4).getPosx(), setCalibr(new Position(8, 0), 4).getPosy());
		}
		else if(direction==3)
		{
			map=new Map(new Position(init_.getLocat().getPosx(), init_.getLocat().getPosy()+1));
			pers1.setPos(setCalibr(new Position(17, 8), 4));
			pers1.setLocation(setCalibr(new Position(17, 8), 4).getPosx(), setCalibr(new Position(17, 8), 4).getPosy());
		}
		else// if(direction==4)
		{
			
			map=new Map(new Position(init_.getLocat().getPosx(), init_.getLocat().getPosy()-1));
			pers1.setPos(setCalibr(new Position(0, 8), 4));
			pers1.setLocation(setCalibr(new Position(0, 8), 4).getPosx(), setCalibr(new Position(0, 8), 4).getPosy());
		}
		pers.add(pers1);
		word_.add(map);
		word_.get(place-1).setInvis();
		addToScreen(place);
		sc_=new Screen(586, 586, this);
		init_=map;
		init_.setPers(pers);
		add(sc_);
		pers1.setVisible(true);
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
	public int setUnsign(int in){
		if (in < 0)
			return (-in);
		return in;
	}
	public boolean ismove(Position fr, Position to, int caze, int index){
		int tmp=init_.getPers().get(index).getStats().getPm()*32;
		int k=-32, i=0, j=0;
		if(caze==1)
		{
			for(i=fr.getPosx();i<=fr.getPosx()+tmp;i++)
			{
				for(j=fr.getPosy();j<=fr.getPosy()+tmp;j++)
				{	
					if((i==to.getPosx())||(j==to.getPosy()))
						k++;
					if((i==to.getPosx())&&(j==to.getPosy())&&k<=tmp)
					{
						return true;
					}
				}
			}
		}
		else if(caze==3)
		{
			for(i=fr.getPosx();i>=fr.getPosx()-tmp;i--)
			{
				for(j=fr.getPosy();j<=fr.getPosy()+tmp;j++)
				{	
					if((i==to.getPosx())||(j==to.getPosy()))
						k++;
					if((i==to.getPosx())&&(j==to.getPosy())&&k<=tmp)
					{
						return true;
					}
				}
			}
		}
		else if(caze==2)
		{
			for(i=fr.getPosx();i<=fr.getPosx()+tmp;i++)
			{
				for(j=fr.getPosy();j>=fr.getPosy()-tmp;j--)
				{	
					if((i==to.getPosx())||(j==to.getPosy()))
						k++;
					if((i==to.getPosx())&&(j==to.getPosy())&&k<=tmp)
					{
						return true;
					}
				}
			}
		}
		else
		{
			for(i=fr.getPosx();i>=fr.getPosx()-tmp;i--)
			{
				for(j=fr.getPosy();j>=fr.getPosy()-tmp;j--)
				{	
					if((i==to.getPosx())||(j==to.getPosy()))
						k++;
					if((i==to.getPosx())&&(j==to.getPosy())&&k<=tmp)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	public Personnage getPers(int index){
		return init_.getPers().get(index);
	}
	public Screen getScreen(){
		return sc_;
	}
	public Combat getCombat(){
		return cb_;
	}
	public Details getDet(){
		return det_;
	}
	public InfoPers getDeta(){
		return detail_;
	}
	public Parametres getParam()
	{
		return param;
	}
	public Timers getTim() {
		return tim_;
	}
	public void setTim(Timers tim_) {
		this.tim_ = tim_;
	}
	public void setPmcb(int val){
		pmcb=val;
	}
	public void setPmcbPP(){
		pmcb++;
		System.out.println(pmcb);
	}
	public int getPmcb(){
		return pmcb;
	}
}