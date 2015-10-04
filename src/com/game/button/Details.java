package com.game.button;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.ihm.Display;
import com.game.rpg.Position;

public class Details extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Position pos_;
	private int type;
	private Display jpapa;
	public Details(Display dad){
		jpapa=dad;
		setIcon(new ImageIcon("src/Icon/Details.png"));
		setSize(60, 160);
		setVisible(false);
		JLabel at=new JLabel();
		JLabel mes=new JLabel();
		JLabel ech=new JLabel();
		JLabel det=new JLabel();
		JLabel p1=new JLabel();
		JLabel p2=new JLabel();
		JLabel p3=new JLabel();
		this.add(at);
		this.add(mes);
		this.add(ech);
		this.add(det);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		at.setBounds(0, 0, 60, 20);
		mes.setBounds(0, 20, 60, 20);
		ech.setBounds(0, 40, 60, 20);
		det.setBounds(0, 60, 60, 20);
		p1.setBounds(0, 80, 60, 20);
		p2.setBounds(0, 100, 60, 20);
		p3.setBounds(0, 120, 60, 20);
		at.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Details_attack.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		at.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				jpapa.inFight();
				jpapa.getDet().setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		mes.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Details_mes.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		mes.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				jpapa.getDet().setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		ech.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Details_echange.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		ech.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				jpapa.getDet().setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		det.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Details_details.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		det.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				jpapa.getDeta().setVisible(true);
				jpapa.getTim().stopAnim();
				jpapa.getDet().setVisible(false);
				jpapa.rerepainter(0);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		p1.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Details_1.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		p1.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				jpapa.getDet().setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		p2.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Details_2.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		p2.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				jpapa.getDet().setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
		p3.addMouseMotionListener(new MouseMotionListener(){
			@Override public void mouseMoved(MouseEvent arg0) {setIcon(new ImageIcon("src/Icon/Details_3.png"));}
			@Override	public void mouseDragged(MouseEvent arg0) {}
		});
		p3.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				jpapa.getDet().setVisible(false);
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
	}
	public void setPos(Position p){
		setBounds(p.getPosx(), p.getPosy()+15, 60, 160);
		pos_=p;
	}
}
