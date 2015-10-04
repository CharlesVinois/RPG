package com.game.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.game.button.Parametres;
import com.game.rpg.Position;

public class ActioBar extends JPanel{
	private static final long serialVersionUID = 1L;
	private int width_;
	private int height_;
	private JPanel persbar;
	private JPanel menu_;
	private JPanel mapi_;
	private JLabel combat;
	private Display dis_;
	private ArrayList<Cell> celign_;
	private ArrayList<ArrayList<Cell>> cells_;
	public ActioBar(int w, int h, JFrame dad){
		width_=w;
		height_=h;//(h*30)/100;
		persbar=new JPanel();
		menu_=new JPanel();
		mapi_=new JPanel();
		dis_=(Display) dad.getContentPane().getComponent(0);
		Cell ce=null;
		JButton me1=null;
		JButton me2=null;
		celign_ = new ArrayList<Cell>();
		cells_ = new ArrayList<ArrayList<Cell>>();
		cells_.add(celign_);
		this.setSize(width_, height_);
		for(int j=0;j<28;j++)
		{
			Position p =new Position(1, j);
			ce=new Cell(dis_,cells_, p, 0, null, null);
			ce.setBorder(null);
			celign_.add(ce);
			persbar.add(ce);
		}
		cells_.add(celign_);
		persbar.setBounds(5, 175, 155, 250);
		/*JProgressBar bar  = new JProgressBar(0, 100);
		bar.setStringPainted(true);
	    bar.setString("Pv");
	    bar.setValue(75);
	    bar.repaint();
	    Dimension prefSize = bar.getPreferredSize();
	    prefSize.width = 530;
	    prefSize.height = 20;
	    bar.setPreferredSize(prefSize);
	    bar.setBounds(5, 5, 430, 40);*/
			me1 = new JButton(new ImageIcon("src/Icon/Affichage.png"));
			me1.setSize(18, 18);
			me1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dis_.getParam().setVisible(true);
					dis_.getParam().setStat();
					dis_.getParam().setComp();
					dis_.getTim().stopAnim();
				}
			});
			menu_.add(me1);
			me2 = new JButton(new ImageIcon("src/Icon/Parametre.png"));
			me2.setSize(18, 18);
			me2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dis_.add(new Parametres(dis_));
				}
			});
			menu_.add(me2);
		menu_.setBounds(5, 5, 150, 40);
		
		ImageIcon imgm = new ImageIcon("src/Map/Mapi.png");
		JLabel mapp=new JLabel(imgm);
		mapi_.add(mapp);
		mapi_.setBounds(5, 425, 155, 155);
		
		add(menu_);
	   // add(bar);
	    add(persbar);
	    add(mapi_);
		//add Image perso
	    
	    this.setBackground(Color.gray);
		this.setSize(width_, height_);
		this.setBounds(581, 0, width_, height_);
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
		repaint();
	}
	public void setFight()
	{
		combat=new JLabel();
		combat.setBounds(5, 46, 180, 60);
		JButton endF=null;
		JButton endT=null;
		JLabel Pa=new JLabel(new ImageIcon("src/Icon/Pa.png"));
		JLabel t=new JLabel(String.valueOf(dis_.getPers(0).getStats().getPa()));
		Pa.setSize(58, 40);
		t.setBounds(29, 11, 15, 15);
		Pa.add(t);
		Pa.setBounds(60, 0, 58, 40);
		combat.add(Pa);
		JLabel Pm=new JLabel(new ImageIcon("src/Icon/Pm.png"));
		JLabel t1=new JLabel(String.valueOf(dis_.getPers(0).getStats().getPm()));
		t1.setBounds(29, 11, 15, 15);
		Pm.setSize(58, 40);
		Pm.setBounds(120, 0, 58, 40);
		Pm.add(t1);
		combat.add(Pm);
		endF = new JButton(new ImageIcon("src/Icon/endFight.png"));
		endF.setSize(60, 20);
		endF.setBounds(0, 0, 60, 20);
		endF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dis_.endFight();
				combat.setVisible(false);
				setnullIcon();
			}
		});
		combat.add(endF);
		endT = new JButton(new ImageIcon("src/Icon/endTurn.png"));
		endT.setSize(60, 20);
		endT.setBounds(0, 20, 60, 20);
		endT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//dis_.endTurn();
			}
		});
		combat.add(endT);
		add(combat);
		combat.repaint();
		setIcon();
		//dis_.getPers(0).getAttaque().getComp().get(i).getName()
	}
	public void setIcon()
	{
		celign_.get(0).setIma(new ImageIcon("src/Icon/Dagues.png"));
		celign_.get(1).setIma(new ImageIcon("src/Icon/epee.png"));
		celign_.get(2).setIma(new ImageIcon("src/Icon/Lancer.png"));
		celign_.get(0).repaintcel();
		celign_.get(1).repaintcel();
		celign_.get(2).repaintcel();
	}
	public void setnullIcon()
	{
		celign_.get(0).setNullIcon();
		celign_.get(1).setNullIcon();
		celign_.get(2).setNullIcon();
	}
	public int getCompCliqued()
	{
		for(int i=0;i<3;i++)
		if(celign_.get(i).getCmbt()>0)
			return celign_.get(i).getCmbt();
		return 0;
	}
}
