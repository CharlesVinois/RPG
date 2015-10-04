package com.game.rpg;

public class Stats {
	private int lvl_;//Niveau
	private int pv_;//Vie
	private int ad_;//Attaque damage
	private int ar_;//Armure
	private int ag_;//Agillit�
	private int es_;//Esquive
	private int cr_;//Critique
	private int pm_;//points de mouvement
	private int pa_;//point d'attaque
	public Stats(){
		lvl_=1;
		pv_=0;
		ad_=0;
		ar_=0;
		ag_=0;
		es_=0;
		cr_=0;
		pm_=0;
		pa_=0;
	}
	public void setLvl(int i){
		lvl_=i;
	}
	public int getLvl(){
		return lvl_;
	}	
	public void setPv(int i){
		pv_=i;
	}
	public int getPv(){
		return pv_;
	}	
	public void setAd(int i){
		ad_=i;
	}
	public int getAd(){
		return ad_;
	}	
	public void setAr(int i){
		ar_=i;
	}
	public int getAr(){
		return ar_;
	}	
	public void setAg(int i){
		ag_=i;
	}
	public int getAg(){
		return ag_;
	}	
	public void setEs(int i){
		es_=i;
	}
	public int getEs(){
		return es_;
	}	
	public void setCr(int i){
		cr_=i;
	}
	public int getCr(){
		return cr_;
	}	
	public void setPm(int i){
		pm_=i;
	}
	public int getPm(){
		return pm_;
	}	
	public void setPa(int i){
		pa_=i;
	}
	public int getPa(){
		return pa_;
	}	
	public Stats add(Stats s){
		pv_+=s.getPv();
		ad_+=s.getAd();
		ar_+=s.getAr();
		ag_+=s.getAg();
		es_+=s.getEs();
		cr_+=s.getCr();
		pm_+=s.getPm();
		pa_+=s.getPa();
		return this;
	}
	public Stats sub(Stats s){
		pv_-=s.getPv();
		ad_-=s.getAd();
		ar_-=s.getAr();
		ag_-=s.getAg();
		es_-=s.getEs();
		cr_-=s.getCr();
		pm_-=s.getPm();
		pa_-=s.getPa();
		return this;
	}
	public Stats egg(Stats s){
		pv_=s.getPv();
		ad_=s.getAd();
		ar_=s.getAr();
		ag_=s.getAg();
		es_=s.getEs();
		cr_=s.getCr();
		pm_=s.getPm();
		pa_=s.getPa();
		return this;
	}
}
