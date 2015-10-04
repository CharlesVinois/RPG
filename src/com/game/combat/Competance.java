package com.game.combat;

import javax.swing.ImageIcon;

//import android.media.Image;
public class Competance {
	private int cl_;//Classes Assassin, etc..
	private String name_;
	private ImageIcon ima_;
	private boolean etat_;//0 disable, 1 enable
	private boolean actif_;//0 passif, 1 actif
	private int type_;//1 Self, 2 Mel�e, 3 Distance, 4 Magic
	private int lvl_;//niveau du sort
	private String requi_;//ex: arc, epee, etc ..
	private String descri_;
	private int dmg_;
	private int pmin_;//portee min / lanceur
	private int pmax_;//OO self,11 Melee,24 Min 2 Max 4
	private int fportee_;//1 all, 2 croix, 3 une case
	private int taoe_;//zone de l'attaque / portee
	private int faoe_;////1 all, 2 croix, 3 une case (ex:bome fragmentation xd), 4 ligneh, 5 lignev
	private int durefet_;//O instantanee, 1 tour, 2 tour
	private int coutpa_;//cout en pa
	private int couldown_;//temps de recharge du sort
	public Competance(String name, int cl, boolean act, int typ, String reqi, String descri, int dmg, int pmin, int pmax, int fp, int taoe, int faoe, int duef, int cop, int cld){
		cl_=cl;
		name_=name;
		etat_=false;
		actif_=act;
		type_=typ;
		lvl_=1;
		requi_=reqi;
		descri_=descri;
		dmg_=dmg;
		pmin_=pmin;
		pmax_=pmax;
		fportee_=fp;
		taoe_=taoe;
		faoe_=faoe;
		durefet_=duef;
		coutpa_=cop;
		couldown_=cld;
	}
	public int getCl(){return cl_;}
	public String getName(){return name_;}
	public boolean getEtat(){return etat_;}
	public void setEtat(boolean et){
		etat_=et;
	}
	public boolean getActif(){
		return actif_;
	}
	public int getTyp(){
		return type_;
	}
	public int getLvl(){
		return lvl_;
	}
	public void setLvl(int lv){
		lvl_=lv;
	}
	public String getReqi(){
		return requi_;
	}
	public void setRequi(String req){
		requi_=req;
	}
	public String getDescri(){
		return descri_;
	}
	public void setDescri(String des){
		descri_=des;
	}
	public int getDmg(){
		return dmg_;
	}
	public void setDmg(int dm){
		dmg_=dm;
	}
	public int getPmin(){
		return pmin_;
	}
	public void setPmin(int pm){
		pmin_=pm;
	}
	public int getPmax(){
		return pmax_;
	}
	public void setPmax(int pm){
		pmax_=pm;
	}
	public int getFp(){
		return fportee_;
	}
	public void setFp(int f){
		fportee_=f;
	}
	public int getTaoe(){
		return taoe_;
	}
	public void setTaoe(int ta){
		taoe_=ta;
	}
	public int getFaoe(){
		return faoe_;
	}
	public void setFaoe(int fa){
		faoe_=fa;
	}
	public int getDuef(){
		return durefet_;
	}
	public void setDuef(int du){
		durefet_=du;
	}
	public int getCop(){
		return coutpa_;
	}
	public void setCop(int co){
		coutpa_=co;
	}
	public int getCould(){
		return couldown_;
	}
	public void setCould(int cld){
		couldown_=cld;
	}
	public void setImage(ImageIcon img)
	{
		ima_=img;
	}
}
