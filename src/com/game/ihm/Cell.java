package com.game.ihm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.rpg.Position;

public class Cell extends JLabel{
	private static final long serialVersionUID = 1L;
	private BufferedImage bi_;
	private ArrayList<ArrayList<Cell>> cel_;
	private boolean port, next;
	private int cmbt;
	private int ismap;//1 Sort, 2 Objet, 3 case normal, 4 case combat
	private Position poo_;
	private ImageIcon ima_;
	private ImageIcon imap_;
	private JLabel that;
	private Display jp_;
	public Cell(Display jp,ArrayList<ArrayList<Cell>> cel, Position po, int ism, ImageIcon ima, ImageIcon imap){
		poo_=po;
		jp_=jp;
		port=false;
		next=false;
		cmbt=0;
		ismap=ism;
		cel_ = cel;
		ima_=ima;
		imap_=imap;
		that=this;
		if(ima_==null)
			setNullIcon();
		else if(poo_.getPosx()==0&&poo_.getPosy()==8)
			ima_=new ImageIcon("src/Map/Sol_G.png");
		else if(poo_.getPosx()==8&&poo_.getPosy()==0)
			ima_=new ImageIcon("src/Map/Sol_H.png");
		else if(poo_.getPosx()==17&&poo_.getPosy()==8)
			ima_=new ImageIcon("src/Map/Sol_D.png");
		else if(poo_.getPosx()==8&&poo_.getPosy()==17)
			ima_=new ImageIcon("src/Map/Sol_B.png");
		this.setIcon(ima_);
		repaint();
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				if(ismap==1)
				{
					setCliqued(true);
					rerepaint(imap_.getImage());
				}
				else if(ismap==4)
				{
					int pv=jp_.getPers(1).getStats().getPv();
					if(cmbt>0)
						jp_.getPers(1).getStats().setPv(pv-jp_.getPers(0).getAttaque().getComp().get(cmbt).getDmg());
					
					for(int i=0;i<18;i++)
						for(int j=0;j<18;j++)
							jp_.getCombat().getCells_().get(i).get(j).setCmbt(0);
					System.out.println(pv);
				}
				else if(ismap==0)
				{
					rerepaint(imap_.getImage());
					if(poo_.getPosx()==1&&poo_.getPosy()==0)
					{
						for(int i=0;i<18;i++)
							for(int j=0;j<18;j++)
								jp_.getCombat().getCells_().get(i).get(j).setCmbt(1);
					}
					else if(poo_.getPosx()==1&&poo_.getPosy()==1)
					{
						for(int i=0;i<18;i++)
							for(int j=0;j<18;j++)
								jp_.getCombat().getCells_().get(i).get(j).setCmbt(2);					}
					else if(poo_.getPosx()==1&&poo_.getPosy()==2)
					{
						for(int i=0;i<18;i++)
							for(int j=0;j<18;j++)
								jp_.getCombat().getCells_().get(i).get(j).setCmbt(3);					}
				}
			}
			public void mouseReleased(MouseEvent e) {
				if(ismap==1)
				{
					rerepaint(ima_.getImage());
					jp_.deplacer(poo_, 0);
					jp_.actioner(null, poo_, 1);
					setCliqued(false);
				}
				else if(ismap==4)	
				{
					jp_.deplacer(poo_, 0);
				}
				else if(ismap==0)
					rerepaint(ima_.getImage());
			}
		});
		this.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e) {
			}
			public void mouseMoved(MouseEvent e) {
				if((ismap==4)&&cmbt==1)
				{
					if(next)
					{
						for(int i=0;i<18;i++)
							for(int j=0;j<18;j++)	
								if(jp_.getCombat().getCell(i, j).getCliqued())
									jp_.getCombat().getCell(i, j).repaintcel();
						
						for(int i=0;i<18;i++)
							for(int j=0;j<18;j++)
								jp_.getCombat().getCells_().get(i).get(j).setNext(false);
					}
					else
					{
						for(int i=0;i<18;i++)
							for(int j=0;j<18;j++)
								jp_.getCombat().getCells_().get(i).get(j).setNext(true);					
					}
					setCliqued(true);
					rerepaint(ima_.getImage());
					rerepaint(imap_.getImage());
				}
				else if((ismap==4)&&isperscanmov()&&jp_.getPmcb()<3&&!getCliqued())
				{
					setCliqued(true);
					rerepaint(ima_.getImage());
					rerepaint(imap_.getImage());
					jp_.setPmcbPP();
				}
				else if((ismap==4)&&isperscanmov()&&jp_.getPmcb()>=3)
				{
					jp_.setPmcb(0);
					
					for(int i=0;i<18;i++)
						for(int j=0;j<18;j++)	
							if(jp_.getCombat().getCell(i, j).getCliqued())
								jp_.getCombat().getCell(i, j).repaintcel();
					
					for(int i=0;i<18;i++)
						for(int j=0;j<18;j++)	
							if(jp_.getCombat().getCell(i, j).getCliqued())
								jp_.getCombat().getCell(i, j).setCliqued(false);
				}
				//else if(ismap==0)
					
			}
		});
	}
	public boolean isperscanmov(){
		Position to = getPos();
		if(jp_.ismove(jp_.getPers(0).getPos(), jp_.setCalibr(new Position(to.getPosx(), to.getPosy()), 4), 1, 1))
			return true;
		if(jp_.ismove(jp_.getPers(0).getPos(), jp_.setCalibr(new Position(to.getPosx(), to.getPosy()), 4), 2, 1))
			return true;
		if(jp_.ismove(jp_.getPers(0).getPos(), jp_.setCalibr(new Position(to.getPosx(), to.getPosy()), 4), 3, 1))
			return true;
		if(jp_.ismove(jp_.getPers(0).getPos(), jp_.setCalibr(new Position(to.getPosx(), to.getPosy()), 4), 4, 1))
			return true;
		return false;
	}
	public void rerepaint(Image im){
		Graphics g=getGraphics();
		g.drawImage(im, 1, 1, this);
	}
	public void repaintcel(){
			rerepaint(ima_.getImage());
	}
	public BufferedImage getBuff(){
		return bi_;
	}
	public void setCliqued(boolean bo){
		port=bo;
	}
	public boolean getCliqued(){
		return port;
	}
	public void setIma(ImageIcon ima){
		ima_=ima;
	}
	public Position getPos(){
		return poo_;
	}
	public void setCmbt(int cb){
		cmbt=cb;
	}
	public int getCmbt()
	{
		return cmbt;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public void setColor(int col, BufferedImage bi){
		for(int k = 0; k < 30; k++)
		{
			for(int l = 0; l < 30; l++)
				bi.setRGB(k, l, col);
		}
		repaint();
	}
	public void setAllnull(){
		for(int i=0;i<18;i++)
		{	
			for(int j=0;j<18;j++)
			{
				cel_.get(i).get(j).setNullIcon();
			}
		}
	}
	public void setNullIcon(){
		bi_ = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
		for(int i = 0; i < 30; ++i)
			for(int j = 0; j < 30; ++j)
				bi_.setRGB(i, j, 0xFFFFFFFF);
		ImageIcon img1 = new ImageIcon(bi_);
		ima_=img1;
		this.setIcon(img1);
		BufferedImage bii = new BufferedImage(30, 30, BufferedImage.TYPE_INT_ARGB);
		for(int i = 0; i < 30; ++i)
			for(int j = 0; j < 30; ++j)
				bii.setRGB(i, j, 0x11111111);
		ImageIcon img2 = new ImageIcon(bii);
		imap_=img2;
	}
}
