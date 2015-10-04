package com.game.ihm;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.game.rpg.Position;
import com.game.rpg.Stats;
public class Combat extends JPanel{
	private static final long serialVersionUID = 1L;
	private int width_;
	

	private int height_;
	private int tours_;//nbr de tours depuis le debut
	private boolean engage_;//true equip 1 agro, false equip 2
	private boolean isend_;
	private ArrayList<Cell> celign_;
	private ArrayList<Integer> Pmleft_;
	private ArrayList<ArrayList<Cell>> cells_;
	public Combat(Display jp, boolean engage){
		//nouvelle fenetre avec les menus de combats
		engage_=engage;
		tours_=0;
		width_=586;
		height_=586;//(h*30)/100;
		isend_=false;
		Cell ce=null;
		cells_ = new ArrayList<ArrayList<Cell>>();
		this.setSize(width_, height_);
			for(int i=0;i<18;i++)
			{	
				celign_ = new ArrayList<Cell>();
				for(int j=0;j<18;j++)
				{
					Position p =new Position(j, i);
					ce=new Cell(jp, cells_, p, 4, null, null);
					celign_.add(ce);
					this.add(ce);
				}
				cells_.add(celign_);
			}
			repaint();
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
		/*while(!isend_)
		{
			boolean endturn=false;
			Stats stat1=jp.getPers(0).getStats();
			Stats stat2=jp.getPers(1).getStats();
			if(engage_==true)
			{
				//Joueur1
				int Pm=stat1.getPm();
				int Pa=stat1.getPa();
				for(int i=0;i<30;i++)
				{
					if(endturn)
						break;
					if(stat1.getPv()<=0)
						isend_=true;
					System.out.println("Time left : "+(30-i));
				}
			}
			else
			{
				//Joueur2
				int Pm=stat2.getPm();
				int Pa=stat2.getPa();
				for(int i=0;i<30;i++)
				{
					if(endturn)
						break;
					if(stat2.getPv()<=0)
						isend_=true;
					System.out.println("Time left : "+(30-i));
				}
			}
			tours_++;
		}*/
	}
		//int reputation_win;
		//boucle de tours de jeux tanqu'il rest min un personnage dans chaque equipes
		/*
		while(!pers1_.isEmpty() || !pers2_.isEmpty()){
			int nbpers=pers1_.size()+pers2_.size();
			//on verifi chaque pers1
			for (int index=0; index < pers1_.size(); index++)
			{
				//si le pers1 est attaqué
				pers1_.get(index).updateCaseModif();//Actualise les stats du perso par rapport a la case
				
				//si le pers1 attaque
				//if(pers1_.get(index).isattaquing())
				//pers1_.get(index).attaquer(getSelectedComp(), getSelectedPos()); 
									
				//si le pers1 est mort
				//if(pers1_.get(index).getPv()==0)
				//{
				//	pers1_.remove(index);
				//	nbpers--;
				//	}
				
				//si le pers1 se deplace
				Position dep=null;
				//if(dep=getSelectedPos())	
					pers1_.get(index).deplacer(map_, pers1_.get(index).getPos(), dep);
				//}
					
				//si le personnage passe son tour
				//if(pers1_.get(index).ispass())
				//	pass le tour
					
			}	
			//on verifi chaque pers2
			for (int indexx=0; indexx < pers2_.size(); indexx++) {
				//si le pers2 est attaqué
				//if(pers2_.get(index).isattaqued())
				//	pers2_.get(index).setPv()-=dmgs2;
				
				//si le pers2 attaque
				//if(pers2_.get(index).isattaquing())
				//	dmgs1=pers2_.get(index).getAt().getDmg();
				//	efpa1=pers2_.get(index).getAt().getPa();
				//	efpm1=pers2_.get(index).getAt().getPm();
				
				//si le pers2 est mort
				//if(pers2_.get(index).getPv()==0)
				//	pers2_.remove(index);
				
				//si le pers2 se deplace
				//if(pers2_.get(index).ismoving())
				//	pers2_.get(index_).move(this.getMousePos());
			}
			tours_++;
		}
		*/
		//Ferme la fenetre de combat et renvoie le compte rendu du combat
		/*
		int winner;//1 equipe 1, 2 epuipe2, 
		int losser;//0 defeat, 1 slane, 2 surrender, 3 self-killing
		int xp_win;
		int money_win;
		int objet_win;
		*/
	
	/*
	public void setPers1(List<Personnage> per){
		pers1_=per;
	}
	public List<Personnage> getPers1(){
		return pers1_;
	}
	public void setPers2(List<Personnage> per){
		pers2_=per;
	}
	public List<Personnage> getPers2(){
		return pers2_;
	}
	public int getTour(){
		return tours_;
	}
	public void setTour(int tour){
		tours_=tour;
	}
	*/
	public Cell getCell(int i, int j){
		if(i<0)
			return cells_.get(0).get(j);
		else if (j<0)
			return cells_.get(i).get(0);
		return cells_.get(i).get(j);
	}
	public int getWidth_() {
		return width_;
	}

	public void setWidth_(int width_) {
		this.width_ = width_;
	}

	public int getHeight_() {
		return height_;
	}

	public void setHeight_(int height_) {
		this.height_ = height_;
	}

	public int getTours_() {
		return tours_;
	}

	public void setTours_(int tours_) {
		this.tours_ = tours_;
	}

	public boolean isEngage_() {
		return engage_;
	}

	public void setEngage_(boolean engage_) {
		this.engage_ = engage_;
	}

	public boolean isIsend_() {
		return isend_;
	}

	public void setIsend_(boolean isend_) {
		this.isend_ = isend_;
	}

	public ArrayList<Cell> getCelign_() {
		return celign_;
	}

	public void setCelign_(ArrayList<Cell> celign_) {
		this.celign_ = celign_;
	}

	public ArrayList<Integer> getPmleft_() {
		return Pmleft_;
	}

	public void setPmleft_(ArrayList<Integer> pmleft_) {
		Pmleft_ = pmleft_;
	}

	public ArrayList<ArrayList<Cell>> getCells_() {
		return cells_;
	}

	public void setCells_(ArrayList<ArrayList<Cell>> cells_) {
		this.cells_ = cells_;
	}
}