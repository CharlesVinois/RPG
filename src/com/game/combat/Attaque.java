package com.game.combat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.game.rpg.Classes;
import com.game.rpg.Races;

public class Attaque {
	private List<Competance> comp_;
	public Attaque(Races ra, Classes cl) {
		comp_= new ArrayList<Competance>();
		//1 humain,2 Elf, 3 orcs
		if((ra.getRaces()==1))
		{
			//1 Assassin, 2 Guerrier, 3 Archer
			//TODO ajouter si le sort peut traverser un decort et/ou un personnage
			if(cl.getClasse()==1)
			{
				comp_.add(new Competance("Assaut", 1, true, 2, "epee", "Donne un coup d'�p�e", 30, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de dague", 1, true, 2, "lvl2;dague;epee", "Attaque avec ses dagues", 18, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup empoisone", 1, true, 2, "lvl5;dague;epee", "Inflige un coup empoison� et retire 1PM", 6, 1, 1, 3, 1, 3, 2, 3, 2));
				comp_.add(new Competance("Lanc� de couteau", 1, true, 3, "lvl7dague;epee", "Lance une dague qui fait saigner la cible", 10, 1, 3, 3, 1, 3, 3, 2, 3));
				comp_.add(new Competance("Canibalisme", 1, true, 2, "lvl10;dos", "Saute sur la cible et vol de la vie", 23, 1, 2, 2, 1, 3, 1, 4, 3));
				comp_.add(new Competance("Pas l�gers", 1, true, 1, "lvl12;none", "Transfert l'energie dans vos jambes +1PM", 0, 0, 0, 0, 0, 0, 1, 2, 2));
				comp_.add(new Competance("Aide d�moniaque", 1, true, 2, "lvl15;dague;eppe", "Coup puissant mais -10% PV", 40, 1, 1, 3, 1, 3, 1, 5, 2));
				comp_.add(new Competance("Clone", 1, true, 1, "lvl20", "Invoque un clone qui marche vers l'enemi le plus proche et explose � sa mort", 6, 1, 1, 3, 1, 3, 3, 4, 4));
				comp_.add(new Competance("Swap", 1, true, 3, "lvl25;clone", "Echange de place avec votre clone", 0, 1, 5, 3, 1, 3, 1, 4, 3));
				comp_.add(new Competance("Plan de secours", 1, true, 3, "lvl30", "Fait explos� un fumig�ne, rend invisible si immobile", 0, 0, 3, 1, 3, 1, 3, 4, 4));
				comp_.add(new Competance("Murder", 1, false, 1, "dos", "Augmente de 30% dmg", 0,0,0,0,0,0,0,0,0));
				comp_.add(new Competance("Fury", 1, false, 1, "2*CR", "Prochaine sort � des chance de CR augment� de 50%", 0,0,0,0,0,0,0,0,0));
			}	
			else if(cl.getClasse()==2)
			{
				comp_.add(new Competance("Assaut", 2, true, 2, "epee", "Donne un coup d'�p�e", 28, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de dague", 2, true, 2, "lvl2;dague;epee", "Attaque avec ses dagues", 15, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de bouclier", 2, true, 2, "lvl5;bouclier", "Donne un coup de bouclier -50% AG", 10, 1, 1, 3, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Bond", 2, true, 3, "lvl7", "Saute sur la cible", 6, 1, 2, 3, 1, 3, 1, 4, 3));
				comp_.add(new Competance("Protection", 2, true, 1, "lvl10;bouclier", "L�ve le bouclier (augmente 40% AR, 30% AG), (baisse 40% AD, 20% CR)", 0, 0, 0, 0, 0, 0, 3, 2, 2));
				comp_.add(new Competance("Fr�n�sie", 2, true, 2, "lvl15;epee", "Donne un coup d'�p�e (dmg*Pv(perdu))", 20, 1, 1, 3, 1, 3, 1, 5, 1));
				comp_.add(new Competance("Coup large", 2, true, 2, "lvl17;eppe", "Donne un coup large", 25, 1, 1, 1, 3, 4, 1, 4, 2));
				comp_.add(new Competance("Faille", 2, true, 2, "lvl20;epee", "Frape le sol et envoie une onde de choc", 15, 1, 1, 1, 3, 5, 1, 4, 2));
				comp_.add(new Competance("Sauvetage", 2, true, 2, "lvl25", "Echange de place avec un alli�", 0, 1, 1, 1, 1, 1, 1, 4, 3));
				comp_.add(new Competance("Lancer de bouclier", 2, true, 3, "lvl30;bouclier", "Lance le bouclier et ramene la cible de 2PM", 6, 2, 4, 2, 1, 3, 1, 4, 1));
				comp_.add(new Competance("Courage", 2, false, 1, "face", "Augmente de 30% AD", 0, 0, 0, 0, 0, 0, 0, 0, 0));
				comp_.add(new Competance("Coup puissant", 2, false, 1, "none", "Chande de reduire l'agillit� de 30%", 0, 0, 0, 0, 0, 0, 0, 0, 0));
			}
			else if(cl.getClasse()==3)
			{
				//String name, int cl, boolean act, int typ, String reqi, String descri, int dmg, int pmin, int pmax, int fp, int taoe, int faoe, int duef, int cop, int cld
				comp_.add(new Competance("Fleche direct", 3, true, 3, "arc", "Tire une fleche", 25, 1, 4, 1, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de poing", 3, true, 2, "lvl2", "Donne un coup de poing qui etourdi 1 tour et +20% AG", 6, 1, 1, 3, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Coup de dague", 3, true, 2, "lvl5;dague", "Attaque avec ses dagues", 15, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Puissance", 3, true, 1, "lvl7", "Augmente l'attaque", 0, 0, 0, 0, 0, 0, 2, 2, 2));
				comp_.add(new Competance("Fleche d'immobilisation", 3, true, 3, "lvl10;arc", "Tire une fleche qui immobilise", 10, 2, 4, 3, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Oeuil de lynx", 3, true, 1, "lvl15", "Augmente la port�e", 0, 0, 0, 0, 0, 0, 2, 2, 2));
				comp_.add(new Competance("Fleche de recule", 3, true, 3, "lvl17", "Fait reculer l'enemi de 2PM", 0, 1, 3, 2, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Fleche de l'ombre", 3, true, 3, "lvl20", "Retire 1PA", 6, 1, 3, 1, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Fleche perssante", 3, true, 3, "lvl25", "Tire une puissante fleche", 35, 1, 4, 1, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Fleche explosive", 3, true, 3, "lvl30", "Tire une fleche qui explose", 35, 2, 4, 1, 3, 1, 1, 4, 2));
				comp_.add(new Competance("Sniper", 3, false, 1, "3PM", "Augmente de 30% les dmg", 0, 0, 0, 0, 0, 0, 0, 0, 0));
				comp_.add(new Competance("Savon", 3, false, 1, "-50% Pv", "Plus la vie baisse plus ES augmente", 0, 0, 0, 0, 0, 0, 0, 0, 0));
			}
		}
		else if((ra.getRaces()==2))
		{
			if(cl.getClasse()==1)
			{
				comp_.add(new Competance("Assaut", 1, true, 2, "epee", "Donne un coup d'�p�e", 30, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de dague", 1, true, 2, "lvl2;dague;epee", "Attaque avec ses dagues", 18, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup empoisone", 1, true, 2, "lvl5;dague;epee", "Inflige un coup empoison� et retire 1PM", 6, 1, 1, 3, 1, 3, 2, 3, 2));
				comp_.add(new Competance("Lanc� de couteau", 1, true, 3, "lvl7dague;epee", "Lance une dague qui fait saigner la cible", 10, 1, 3, 3, 1, 3, 3, 2, 3));
				comp_.add(new Competance("Canibalisme", 1, true, 2, "lvl10;dos", "Saute sur la cible et vol de la vie", 23, 1, 2, 2, 1, 3, 1, 4, 3));
				comp_.add(new Competance("Pas l�gers", 1, true, 1, "lvl12;none", "Transfert l'energie dans vos jambes +1PM", 0, 0, 0, 0, 0, 0, 1, 2, 2));
				comp_.add(new Competance("Aide d�moniaque", 1, true, 2, "lvl15;dague;eppe", "Coup puissant mais -10% PV", 40, 1, 1, 3, 1, 3, 1, 5, 2));
				comp_.add(new Competance("Clone", 1, true, 1, "lvl20", "Invoque un clone qui marche vers l'enemi le plus proche et explose � sa mort", 6, 1, 1, 3, 1, 3, 3, 4, 4));
				comp_.add(new Competance("Swap", 1, true, 3, "lvl25;clone", "Echange de place avec votre clone", 0, 1, 5, 3, 1, 3, 1, 4, 3));
				comp_.add(new Competance("Plan de secours", 1, true, 3, "lvl30", "Fait explos� un fumig�ne, rend invisible si immobile", 0, 0, 3, 1, 3, 1, 3, 4, 4));
				comp_.add(new Competance("Murder", 1, false, 1, "dos", "Augmente de 30% dmg", 0,0,0,0,0,0,0,0,0));
				comp_.add(new Competance("Fury", 1, false, 1, "2*CR", "Prochaine sort � des chance de CR augment� de 50%", 0,0,0,0,0,0,0,0,0));
			}	
			else if(cl.getClasse()==2)
			{
				comp_.add(new Competance("Assaut", 2, true, 2, "epee", "Donne un coup d'�p�e", 28, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de dague", 2, true, 2, "lvl2;dague;epee", "Attaque avec ses dagues", 15, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de bouclier", 2, true, 2, "lvl5;bouclier", "Donne un coup de bouclier -50% AG", 10, 1, 1, 3, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Bond", 2, true, 3, "lvl7", "Saute sur la cible", 6, 1, 2, 3, 1, 3, 1, 4, 3));
				comp_.add(new Competance("Protection", 2, true, 1, "lvl10;bouclier", "L�ve le bouclier (augmente 40% AR, 30% AG), (baisse 40% AD, 20% CR)", 0, 0, 0, 0, 0, 0, 3, 2, 2));
				comp_.add(new Competance("Fr�n�sie", 2, true, 2, "lvl15;epee", "Donne un coup d'�p�e (dmg*Pv(perdu))", 20, 1, 1, 3, 1, 3, 1, 5, 1));
				comp_.add(new Competance("Coup large", 2, true, 2, "lvl17;eppe", "Donne un coup large", 25, 1, 1, 1, 3, 4, 1, 4, 2));
				comp_.add(new Competance("Faille", 2, true, 2, "lvl20;epee", "Frape le sol et envoie une onde de choc", 15, 1, 1, 1, 3, 5, 1, 4, 2));
				comp_.add(new Competance("Sauvetage", 2, true, 2, "lvl25", "Echange de place avec un alli�", 0, 1, 1, 1, 1, 1, 1, 4, 3));
				comp_.add(new Competance("Lancer de bouclier", 2, true, 3, "lvl30;bouclier", "Lance le bouclier et ramene la cible de 2PM", 6, 2, 4, 2, 1, 3, 1, 4, 1));
				comp_.add(new Competance("Courage", 2, false, 1, "face", "Augmente de 30% AD", 0, 0, 0, 0, 0, 0, 0, 0, 0));
				comp_.add(new Competance("Coup puissant", 2, false, 1, "none", "Chande de reduire l'agillit� de 30%", 0, 0, 0, 0, 0, 0, 0, 0, 0));
			}
			else if(cl.getClasse()==3)
			{
				//String name, int cl, boolean act, int typ, String reqi, String descri, int dmg, int pmin, int pmax, int fp, int taoe, int faoe, int duef, int cop, int cld
				comp_.add(new Competance("Fleche direct", 3, true, 3, "arc", "Tire une fleche", 25, 1, 4, 1, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de poing", 3, true, 2, "lvl2", "Donne un coup de poing qui etourdi 1 tour et +20% AG", 6, 1, 1, 3, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Coup de dague", 3, true, 2, "lvl5;dague", "Attaque avec ses dagues", 15, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Puissance", 3, true, 1, "lvl7", "Augmente l'attaque", 0, 0, 0, 0, 0, 0, 2, 2, 2));
				comp_.add(new Competance("Fleche d'immobilisation", 3, true, 3, "lvl10;arc", "Tire une fleche qui immobilise", 10, 2, 4, 3, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Oeuil de lynx", 3, true, 1, "lvl15", "Augmente la port�e", 0, 0, 0, 0, 0, 0, 2, 2, 2));
				comp_.add(new Competance("Fleche de recule", 3, true, 3, "lvl17", "Fait reculer l'enemi de 2PM", 0, 1, 3, 2, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Fleche de l'ombre", 3, true, 3, "lvl20", "Retire 1PA", 6, 1, 3, 1, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Fleche perssante", 3, true, 3, "lvl25", "Tire une puissante fleche", 35, 1, 4, 1, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Fleche explosive", 3, true, 3, "lvl30", "Tire une fleche qui explose", 35, 2, 4, 1, 3, 1, 1, 4, 2));
				comp_.add(new Competance("Sniper", 3, false, 1, "3PM", "Augmente de 30% les dmg", 0, 0, 0, 0, 0, 0, 0, 0, 0));
				comp_.add(new Competance("Savon", 3, false, 1, "-50% Pv", "Plus la vie baisse plus ES augmente", 0, 0, 0, 0, 0, 0, 0, 0, 0));
			}
		}
		else if((ra.getRaces()==3))
		{
			if(cl.getClasse()==1)
			{
				comp_.add(new Competance("Assaut", 1, true, 2, "epee", "Donne un coup d'�p�e", 30, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de dague", 1, true, 2, "lvl2;dague;epee", "Attaque avec ses dagues", 18, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup empoisone", 1, true, 2, "lvl5;dague;epee", "Inflige un coup empoison� et retire 1PM", 6, 1, 1, 3, 1, 3, 2, 3, 2));
				comp_.add(new Competance("Lanc� de couteau", 1, true, 3, "lvl7dague;epee", "Lance une dague qui fait saigner la cible", 10, 1, 3, 3, 1, 3, 3, 2, 3));
				comp_.add(new Competance("Canibalisme", 1, true, 2, "lvl10;dos", "Saute sur la cible et vol de la vie", 23, 1, 2, 2, 1, 3, 1, 4, 3));
				comp_.add(new Competance("Pas l�gers", 1, true, 1, "lvl12;none", "Transfert l'energie dans vos jambes +1PM", 0, 0, 0, 0, 0, 0, 1, 2, 2));
				comp_.add(new Competance("Aide d�moniaque", 1, true, 2, "lvl15;dague;eppe", "Coup puissant mais -10% PV", 40, 1, 1, 3, 1, 3, 1, 5, 2));
				comp_.add(new Competance("Clone", 1, true, 1, "lvl20", "Invoque un clone qui marche vers l'enemi le plus proche et explose � sa mort", 6, 1, 1, 3, 1, 3, 3, 4, 4));
				comp_.add(new Competance("Swap", 1, true, 3, "lvl25;clone", "Echange de place avec votre clone", 0, 1, 5, 3, 1, 3, 1, 4, 3));
				comp_.add(new Competance("Plan de secours", 1, true, 3, "lvl30", "Fait explos� un fumig�ne, rend invisible si immobile", 0, 0, 3, 1, 3, 1, 3, 4, 4));
				comp_.add(new Competance("Murder", 1, false, 1, "dos", "Augmente de 30% dmg", 0,0,0,0,0,0,0,0,0));
				comp_.add(new Competance("Fury", 1, false, 1, "2*CR", "Prochaine sort � des chance de CR augment� de 50%", 0,0,0,0,0,0,0,0,0));
			}	
			else if(cl.getClasse()==2)
			{
				comp_.add(new Competance("Assaut", 2, true, 2, "epee", "Donne un coup d'�p�e", 28, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de dague", 2, true, 2, "lvl2;dague;epee", "Attaque avec ses dagues", 15, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de bouclier", 2, true, 2, "lvl5;bouclier", "Donne un coup de bouclier -50% AG", 10, 1, 1, 3, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Bond", 2, true, 3, "lvl7", "Saute sur la cible", 6, 1, 2, 3, 1, 3, 1, 4, 3));
				comp_.add(new Competance("Protection", 2, true, 1, "lvl10;bouclier", "L�ve le bouclier (augmente 40% AR, 30% AG), (baisse 40% AD, 20% CR)", 0, 0, 0, 0, 0, 0, 3, 2, 2));
				comp_.add(new Competance("Fr�n�sie", 2, true, 2, "lvl15;epee", "Donne un coup d'�p�e (dmg*Pv(perdu))", 20, 1, 1, 3, 1, 3, 1, 5, 1));
				comp_.add(new Competance("Coup large", 2, true, 2, "lvl17;eppe", "Donne un coup large", 25, 1, 1, 1, 3, 4, 1, 4, 2));
				comp_.add(new Competance("Faille", 2, true, 2, "lvl20;epee", "Frape le sol et envoie une onde de choc", 15, 1, 1, 1, 3, 5, 1, 4, 2));
				comp_.add(new Competance("Sauvetage", 2, true, 2, "lvl25", "Echange de place avec un alli�", 0, 1, 1, 1, 1, 1, 1, 4, 3));
				comp_.add(new Competance("Lancer de bouclier", 2, true, 3, "lvl30;bouclier", "Lance le bouclier et ramene la cible de 2PM", 6, 2, 4, 2, 1, 3, 1, 4, 1));
				comp_.add(new Competance("Courage", 2, false, 1, "face", "Augmente de 30% AD", 0, 0, 0, 0, 0, 0, 0, 0, 0));
				comp_.add(new Competance("Coup puissant", 2, false, 1, "none", "Chande de reduire l'agillit� de 30%", 0, 0, 0, 0, 0, 0, 0, 0, 0));
			}
			else if(cl.getClasse()==3)
			{
				//String name, int cl, boolean act, int typ, String reqi, String descri, int dmg, int pmin, int pmax, int fp, int taoe, int faoe, int duef, int cop, int cld
				comp_.add(new Competance("Fleche direct", 3, true, 3, "arc", "Tire une fleche", 25, 1, 4, 1, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Coup de poing", 3, true, 2, "lvl2", "Donne un coup de poing qui etourdi 1 tour et +20% AG", 6, 1, 1, 3, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Coup de dague", 3, true, 2, "lvl5;dague", "Attaque avec ses dagues", 15, 1, 1, 3, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Puissance", 3, true, 1, "lvl7", "Augmente l'attaque", 0, 0, 0, 0, 0, 0, 2, 2, 2));
				comp_.add(new Competance("Fleche d'immobilisation", 3, true, 3, "lvl10;arc", "Tire une fleche qui immobilise", 10, 2, 4, 3, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Oeuil de lynx", 3, true, 1, "lvl15", "Augmente la port�e", 0, 0, 0, 0, 0, 0, 2, 2, 2));
				comp_.add(new Competance("Fleche de recule", 3, true, 3, "lvl17", "Fait reculer l'enemi de 2PM", 0, 1, 3, 2, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Fleche de l'ombre", 3, true, 3, "lvl20", "Retire 1PA", 6, 1, 3, 1, 1, 3, 1, 3, 2));
				comp_.add(new Competance("Fleche perssante", 3, true, 3, "lvl25", "Tire une puissante fleche", 35, 1, 4, 1, 1, 3, 1, 3, 1));
				comp_.add(new Competance("Fleche explosive", 3, true, 3, "lvl30", "Tire une fleche qui explose", 35, 2, 4, 1, 3, 1, 1, 4, 2));
				comp_.add(new Competance("Sniper", 3, false, 1, "3PM", "Augmente de 30% les dmg", 0, 0, 0, 0, 0, 0, 0, 0, 0));
				comp_.add(new Competance("Savon", 3, false, 1, "-50% Pv", "Plus la vie baisse plus ES augmente", 0, 0, 0, 0, 0, 0, 0, 0, 0));
			}
		}
	}
	public List<Competance> getComp(){
		return comp_;
	}
	public Competance getTheComp(int i){
		return comp_.get(i);
	}
	public void setComp(Competance comp){
		comp_.add(comp);
	}
}
