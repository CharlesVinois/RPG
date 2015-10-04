package com.game.rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.game.combat.Attaque;
import com.game.combat.Competance;

public class Personnage extends JLabel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Races ra_;
	private Classes cl_;
	private int lvl_;
	private Equipement eq_;
	private Position po_;
	private Lieu li_;
	//private Status sta_;
	private int etat_;//1 Normal, 2 En combat, 3 Mort, 4 en echange, 5 en dialogue, 6 Magasin, 7 Repos 
	private Attaque at_;
	private Stats st_;
	private ImageIcon img_;
	private Image imgs_;
	private Timer dec_;
	public Personnage(Races ra, Classes cl, Lieu li, Position p, ImageIcon img, boolean ispers){
		ra_=ra;
		cl_=cl;
		li_=li;
		po_=p;
		lvl_=1;
		etat_=1;
		at_= new Attaque(ra, cl);
		eq_ = new Equipement();
		st_ = cl.getStats();
		setLocation(po_.getPosx(), po_.getPosy());
		setImg(img);
		dec_=new Timer(100, this);
		dec_.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(imgs_, 0, 0, null);
	};
	public static Image makeColorTransparent(final BufferedImage im, final Color color)  
	{  
      final ImageFilter filter = new RGBImageFilter()  
      {  
         // the color we are looking for (white)... Alpha bits are set to opaque  
         public int markerRGB = color.getRGB() | 0xFFFFFFFF;  
         public final int filterRGB(final int x, final int y, final int rgb)  
         {  
            if ((rgb | 0xFF000000) == markerRGB)  
               // Mark the alpha bits as zero - transparent  
               return 0x00FFFFFF & rgb;  
            else  
               return rgb;  
         }  
      };  
      final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);  
      return Toolkit.getDefaultToolkit().createImage(ip);  
   }  
	public Races getRaces(){
		return ra_;
	}
	public Classes getClasses(){
		return cl_;
	}
	public void setClasses(Classes cl){
		cl_ =cl;
	}
	public int getLvl(){
		return lvl_;
	}
	public void setLvl(int lvl){
		lvl_=lvl;
	}
	public Equipement getEq(){
		return eq_;
	}
	public void setEq(Equipement eq){
		eq_=eq;
	}
	public Position getPos(){
		return po_;
	}
	public void setPos(Position po){
		po_=po;
	}
	public Lieu getLieu(){
		return li_;
	}
	public void setLieu(Lieu li){
		li_=li;
	}
	public Attaque getAttaque(){
		return at_;
	}
	public void setAttaque(Attaque at){
		at_=at;
	}
	public Stats getStats(){
		return st_;
	}
	public void setStats(Stats st){
		st_=st;
	}
	public int getEtat(){
		return etat_;
	}
	public void setEtat(int eta){
		etat_=eta;
	}
	public Position getSelectedPos(){
		return null;
		//return interface_.on_mouse_clicked();
	}
	public Competance getSelectedComp(){
		return null;
		//return interface_.on_mouse_clicked();
	}
	public ImageIcon getImageIcon(){
		return img_;
	}
	public Image getImage(){
		return imgs_;
	}
	public void setImg(ImageIcon img)
	{
		img_=img;
		setSize(img_.getIconWidth(), img_.getIconHeight());
		BufferedImage bi = new BufferedImage( img_.getIconWidth(), img_.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		// paint the Icon to the BufferedImage.
		img_.paintIcon(null, g, 0,0);
		g.dispose();
		img_ =new ImageIcon(makeColorTransparent(bi, new Color(bi.getRGB(0, 0))));
		imgs_=img_.getImage();
		setIcon(img_);

	}
	public void setLifeBar()
	{
		ImageIcon pers=img_;
		ImageIcon bar=new ImageIcon("src/Icon/LifeBar.png");
		BufferedImage bi = new BufferedImage( img_.getIconWidth(), img_.getIconHeight()+10, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		g.drawImage(bar.getImage(), 0, 0, this);
		g.drawImage(pers.getImage(), 0, 10, this);
		g.dispose();
		img_ =new ImageIcon(makeColorTransparent(bi, new Color(bi.getRGB(0, 0))));
		imgs_=img_.getImage();
		setIcon(img_);
	}
	public int getPv(){
		return st_.getPv();
	}
	public void decPm(){
		int pm=st_.getPm();
		st_.setPm(--pm);
		System.out.println(st_.getPm());
	}
	/*
	//Update player status per rapport to the case
	public void updateCaseModif(){
		if(etat_==2)
		{
		for(int i=0;i<map_.getDecort().size();i++)
			if(map_.getDecort().get(i).getPos() == po_)
			{	
				for(int j=0;j<map_.getDecort().get(i).getComp().size();j++)
					st_.setPv(st_.getPv()-map_.getDecort().get(i).getComp().get(j).getDmg());
					//si perd pa
					//si perd pm
					//si saigmement
			}
		}
	}
	public boolean attaquer(int index, Position po){
		//index : position de la competance dans la liste
		Competance comp = at_.getComp().get(index);
		int tmp = comp.getPmax();
		int k=0, i=0, j=0, l=0;
		for(i=po_.getPosx()-tmp;i<=(tmp*2);i++)
		{
			if(l==0 && (i!=po_.getPosx()-tmp))
				k++;
			else if(l==1 && (i!=po_.getPosx()-tmp))
				k--;
			if(i==po_.getPosx())
				l=1;
			for(j=po_.getPosy()-k;j<=po_.getPosy()+k;j++)
			{	if((i==po.getPosx())&&(j==po.getPosy()))
				{
				for(int m=0;m<map_.getDecort().size();m++)
					if(map_.getDecort().get(m).getPos() == po)
					{	
						map_.getDecort().get(m).setComp(comp);
						return true;
					}
				}
			}
		}
		return false;
	}*/
/*	public void updateEtatModif(){
		Personnage mob=null;//= clic_attaque();
		if(etat_==1)//1 Normal
		{	
			//Change image joueur
				if clic action
			//		if clic/select menu
			 			//display menu
			//		if clic inventaire
			 			//display bag
			//		if(dep=clic deplacement)
			 		deplacer(map_, po_, dep);
			 		if(clic dialogue)
			 	//display dialogue box
			/
			if(mob.getClass()==mob)
					{
						etat_=2;
					}
			
		}	
		if(etat_==2)//2 En combat
		{	
			//display the screen of fight
			
			List<Personnage> listp = new ArrayList<Personnage>();
			listp.add(this);
			List<Personnage> listm = new ArrayList<Personnage>();
			listm.add(mob);
			//new Combat(map_, listp, listm, true);
			if(this.getPv()==0)
				etat_=3;//si mort a la fin du comnbat
		}
		if(etat_==3)//3 Mort 
		{
			//change Img pour spectre
			//Impossible de faire autre chose que d'aller se res
		}
		if(etat_==4)//4 en echange
		{
			//affichage du menu echange
		}
		if(etat_==5)//5 en dialogue
		{
			//affiche fenetre dialogue
		}
		if(etat_==6)//6 Magasin
		{
			//	ffiche le magsin
		}
		if(etat_== 7)//7 Repos
		{
			//change Img pour assis
		}				
	/
	//boucle qui attend les evenement du jeu
	//	if agro mog
	/	boucle qui attend si la position se prend des damages(change d'etats)
	//		boucle qui attend le tour du perso
	//			boucle qui attend le choix de l'action(attaque, d�placement)
	//	if change map
	// 	if move sur la map
	//  if dialogue joueur
	//boucle qui attend les changements d'etat (potion, buff)
	
	}*/
}