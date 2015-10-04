package com.game.rpg;

public class Equipement {
	private Objets bo_;//Botte
	private Objets ja_;//Jambe
	private Objets to_;//Torse
	private Objets te_;//Tete
	private Objets ep_;//Epaule
	private Objets po_;//Poignet
	private Objets ma_;//Main
	private Objets ba1_;//Bague1
	private Objets ba2_;//Bague2
	private Objets co_;//Collier
	private Objets arm1_;//Arme1
	private Objets arm2_;//Arme2
	private Stats st_;
	public Equipement(){
		st_ = new Stats();
		bo_ = new Objets(new Stats(), "Botte");
		ja_ = new Objets(new Stats(), "Jambe");
		to_ = new Objets(new Stats(), "Torse");
		te_ = new Objets(new Stats(), "Tete");
		ep_ = new Objets(new Stats(), "Epaule");
		po_ = new Objets(new Stats(), "Poignet");
		ma_ = new Objets(new Stats(), "Main");
		ba1_ = new Objets(new Stats(), "Bague1");
		ba2_ = new Objets(new Stats(), "Bague2");
		co_ = new Objets(new Stats(), "Collier");
		arm1_ = new Objets(new Stats(), "Arme1");
		arm2_ = new Objets(new Stats(), "Arme2");
	}
	public Stats getStats(){
		//calcule les stats cummul�e par les objets
		st_.add(bo_.getStats());
		st_.add(ja_.getStats());
		st_.add(to_.getStats());
		st_.add(te_.getStats());
		st_.add(ep_.getStats());
		st_.add(po_.getStats());
		st_.add(ma_.getStats());
		st_.add(ba1_.getStats());
		st_.add(ba2_.getStats());
		st_.add(co_.getStats());
		st_.add(arm1_.getStats());
		st_.add(arm2_.getStats());
		return st_;
	}
	public Objets getBotte(){
		st_ = getStats();
		return bo_;
	}
	public void setBotte(Objets b){
		st_ = getStats();
		bo_=b;
	}
	public Objets getJambe(){
		st_ = getStats();
		return ja_;
	}
	public void setJambe(Objets b){
		st_ = getStats();
		ja_=b;
	}
	public Objets getTorse(){
		st_ = getStats();
		return to_;
	}
	public void setTorse(Objets b){
		st_ = getStats();
		to_=b;
	}
	public Objets getTete(){
		st_ = getStats();
		return te_;
	}
	public void setTete(Objets b){
		st_ = getStats();
		te_=b;
	}
	public Objets getEpaule(){
		st_ = getStats();
		return ep_;
	}
	public void setEpaule(Objets b){
		st_ = getStats();
		ep_=b;
	}
	public Objets getPoignet(){
		st_ = getStats();
		return po_;
	}
	public void setPoignet(Objets b){
		st_ = getStats();
		po_=b;
	}
	public Objets getMain(){
		st_ = getStats();
		return ma_;
	}
	public void setMain(Objets b){
		st_ = getStats();
		ma_=b;
	}
	public Objets getBague1(){
		st_ = getStats();
		return ba1_;
	}
	public void setBague1(Objets b){
		st_ = getStats();
		ba1_=b;
	}
	public Objets getBague2(){
		st_ = getStats();
		return ba2_;
	}
	public void setBague2(Objets b){
		st_ = getStats();
		ba2_=b;
	}
	public Objets getCollier(){
		st_ = getStats();
		return co_;
	}
	public void setCollier(Objets b){
		st_ = getStats();
		co_=b;
	}
	public Objets getArme1(){
		st_ = getStats();
		return arm1_;
	}
	public void setArme1(Objets b){
		st_ = getStats();
		arm1_=b;
	}
	public Objets getArme2(){
		st_ = getStats();
		return arm2_;
	}
	public void setArme2(Objets b){
		st_ = getStats();
		arm2_=b;
	}
}
