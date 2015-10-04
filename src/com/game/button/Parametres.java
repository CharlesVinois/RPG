package com.game.button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.game.ihm.Display;

public class Parametres extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Display jpapa;
	private JLabel pers;
	private JLabel stat;
	private JLabel equip;
	private JLabel comps;
	private JScrollPane comp;
	private JLabel map;
	public Parametres(Display dad) {
		// TODO Auto-generated constructor stub
		jpapa=dad;
		
		setIcon(new ImageIcon("src/Icon/Menu_fond.png"));
		setSize(437, 512);
		setBounds(90, 60, 437, 512);
		//JPanel param=new JPanel();
		//jpapa.getTim().stopAnim();
		JButton quit = new JButton(new ImageIcon("src/Icon/quit.png"));
		quit.setSize(18, 18);
		quit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			jpapa.getTim().startAnim();
		}
	});
		this.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {repaint();}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				repaint();
			}
			public void mouseReleased(MouseEvent e) {
				repaint();
			}
		});
		add(quit);
		pers=new JLabel();
		stat=new JLabel();
		equip=new JLabel();
		comps=new JLabel();
		comps.setMaximumSize(new Dimension(510, 512));
		map=new JLabel();
		comp=new JScrollPane(comps);
		comp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//comp.getHorizontalScrollBar().setUnitIncrement(15);
		comp.setViewportView(comps);
		//comp.setAutoscrolls(true);
		comps.setPreferredSize(new Dimension(512,512));
		comps.setSize(512, 512);
		comps.setLocation(10, 25);
		comps.setLayout(null);
		JLabel at=new JLabel();
		JLabel mes=new JLabel();
		JLabel ech=new JLabel();
		JLabel det=new JLabel();
		JLabel p1=new JLabel();
		JLabel p2=new JLabel();
		JLabel p3=new JLabel();
		pers.setBounds(102, 0, 335, 512);
		stat.setBounds(102, 0, 335, 512);
		equip.setBounds(102, 0, 335, 512);
		comps.setBounds(0, 0, 512, 512);
		comp.setBounds(102, 0, 335, 512);
		map.setBounds(102, 0, 335, 512);

		at.setBounds(0, 0, 102, 42);
		mes.setBounds(0, 37, 102, 42);
		ech.setBounds(0, 74, 102, 42);
		det.setBounds(0, 111, 102, 42);
		p1.setBounds(0, 148, 102, 42);
		p2.setBounds(0, 185, 102, 42);
		p3.setBounds(0, 222, 102, 42);
		add(at);
		add(mes);
		add(ech);
		add(det);
		add(p1);
		add(p2);
		add(p3);
		add(stat);
		add(pers);
		add(equip);
		add(comp);
		add(map);
		repaint();
		stat.setVisible(false);
		pers.setVisible(false);
		equip.setVisible(false);
		comp.setVisible(false);
		map.setVisible(false);
		setVisible(false);
		at.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Menu_Personnage.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		at.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				stat.setVisible(false);
				pers.setVisible(true);
				equip.setVisible(false);
				comp.setVisible(false);
				map.setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		mes.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Menu_Stat.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		mes.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				stat.setVisible(true);
				pers.setVisible(false);
				equip.setVisible(false);
				comp.setVisible(false);
				map.setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		ech.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Menu_Equipement.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		ech.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				stat.setVisible(false);
				pers.setVisible(false);
				equip.setVisible(true);
				comp.setVisible(false);
				map.setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		det.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Menu_Competance.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		det.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				stat.setVisible(false);
				pers.setVisible(false);
				equip.setVisible(false);
				comp.setVisible(true);
				map.setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		p1.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Menu_Map.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		p1.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				stat.setVisible(false);
				pers.setVisible(false);
				equip.setVisible(false);
				comp.setVisible(false);
				map.setVisible(true);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		p2.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Menu_fond1.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		p2.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){

			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		p3.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Menu_fond2.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		p3.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){

			}
			public void mouseReleased(MouseEvent e) {
			}
		});
	}
	public void setStat()
	{
		JLabel text1;
		text1=new JLabel("Name :");
		text1.setBounds(0, 0, 60, 20);
		stat.add(text1);
		JLabel text2;
		text2=new JLabel(String.valueOf("Pv :"));
		text2.setBounds(0, 20, 60, 20);
		stat.add(text2);
		JLabel text3;
		text3=new JLabel(String.valueOf("Lvl :"));
		text3.setBounds(0, 40, 60, 20);
		stat.add(text3);
		JLabel text4;
		text4=new JLabel(String.valueOf("Pa :"));
		text4.setBounds(0, 60, 60, 20);
		stat.add(text4);
		JLabel text5;
		text5=new JLabel(String.valueOf("Pm :"));
		text5.setBounds(0, 80, 60, 20);
		stat.add(text5);
		JLabel text6;
		text6=new JLabel(String.valueOf("Ad :"));
		text6.setBounds(0,100, 60, 20);
		stat.add(text6);
		JLabel text7;
		text7=new JLabel(String.valueOf("Ag :"));
		text7.setBounds(0, 120, 60, 20);
		stat.add(text7);
		JLabel text8;
		text8=new JLabel(String.valueOf("Ar :"));
		text8.setBounds(0, 140, 60, 20);
		stat.add(text8);
		JLabel text9;
		text9=new JLabel(String.valueOf("Cr :"));
		text9.setBounds(0, 160, 60, 20);
		stat.add(text9);
		
		JLabel text11;
		text11=new JLabel("Hibou");
		text11.setBounds(120, 0, 60, 20);
		stat.add(text11);
		JLabel text21;
		text21=new JLabel(String.valueOf(jpapa.getPers(0).getStats().getPv()));
		text21.setBounds(120, 20, 60, 20);
		stat.add(text21);
		JLabel text31;
		text31=new JLabel(String.valueOf(jpapa.getPers(0).getStats().getLvl()));
		text31.setBounds(120, 40, 60, 20);
		stat.add(text31);
		JLabel text41;
		text41=new JLabel(String.valueOf(jpapa.getPers(0).getStats().getPa()));
		text41.setBounds(120, 60, 60, 20);
		stat.add(text41);
		JLabel text51;
		text51=new JLabel(String.valueOf(jpapa.getPers(0).getStats().getPm()));
		text51.setBounds(120, 80, 60, 20);
		stat.add(text51);
		JLabel text61;
		text61=new JLabel(String.valueOf(jpapa.getPers(0).getStats().getAd()));
		text61.setBounds(120,100, 60, 20);
		stat.add(text61);
		JLabel text71;
		text71=new JLabel(String.valueOf(jpapa.getPers(0).getStats().getAg()));
		text71.setBounds(120, 120, 60, 20);
		stat.add(text71);
		JLabel text81;
		text81=new JLabel(String.valueOf(jpapa.getPers(0).getStats().getAr()));
		text81.setBounds(120, 140, 60, 20);
		stat.add(text81);
		JLabel text91;
		text91=new JLabel(String.valueOf(jpapa.getPers(0).getStats().getCr()));
		text91.setBounds(120, 160, 60, 20);
		stat.add(text91);
	}
	public void setPers()
	{
		
	}
	public void setEquip()
	{
		
	}
	public void setComp()
	{		
		JLabel text11;
		text11=new JLabel("Name");
		text11.setBounds(10, 0, 60, 20);
		comps.add(text11);
		int j=20;
		for(int i=0;i<11;i++)
		{
			JLabel text21=new JLabel(String.valueOf(jpapa.getPers(0).getAttaque().getComp().get(i).getName()));
			text21.setBounds(10, j, 120, 20);
			comps.add(text21);
			j=j+20;
		}
		JLabel text12;
		text12=new JLabel("Damage");
		text12.setBounds(130, 0, 60, 20);
		comps.add(text12);
		j=20;
		for(int i=0;i<11;i++)
		{
			JLabel text22=new JLabel(String.valueOf(jpapa.getPers(0).getAttaque().getComp().get(i).getDmg()));
			text22.setBounds(130, j, 120, 20);
			comps.add(text22);
			j=j+20;
		}
		JLabel text13;
		text13=new JLabel("Cout Pa");
		text13.setBounds(250, 0, 60, 20);
		comps.add(text13);
		j=20;
		for(int i=0;i<11;i++)
		{
			JLabel text23;
			text23=new JLabel(String.valueOf(jpapa.getPers(0).getAttaque().getComp().get(i).getCop()));
			text23.setBounds(250, j, 120, 20);
			comps.add(text23);
			j=j+20;
		}
		JLabel text14;
		text14=new JLabel("Description");
		text14.setBounds(370, 0, 60, 20);
		comps.add(text14);
		j=20;
		for(int i=0;i<11;i++)
		{
			JLabel text24;
			text24=new JLabel(String.valueOf(jpapa.getPers(0).getAttaque().getComp().get(i).getDescri()));
			text24.setBounds(370, j, 120, 20);
			comps.add(text24);
			j=j+20;
		}
	}
	public void setMap()
	{
		
	}
}