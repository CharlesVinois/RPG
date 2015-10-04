package com.game.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.game.ihm.Display;
import com.game.rpg.Personnage;

public class InfoPers extends JLabel{
	private ImageIcon impers_;
	private JLabel name_;
	private JLabel pa_;
	private JLabel pm_;
	private JLabel pv_;
	private Personnage pers_;
	private Display jpapa_;
	public InfoPers(Display dad){
		setSize(360, 360);
		name_=new JLabel("Skell");
		name_.setBounds(25, 15, 60, 20);
		add(name_);
		jpapa_=dad;
		JButton quit = new JButton(new ImageIcon("src/Icon/quit.png"));
		quit.setSize(18, 18);
		quit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			jpapa_.getTim().startAnim();
		}
	});
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				repaint();
			}
			public void mouseReleased(MouseEvent e) {
				repaint();
			}
		});
	setIcon(new ImageIcon("src/Menu/Details_skell.png"));
	add(quit);
	add(name_);
	setBounds(90, 90, 360, 360);
	setVisible(false);
}
	public void setPers(Personnage pers)
	{
		pers_=pers;
		pv_=new JLabel(String.valueOf(pers_.getStats().getPv()));
		pv_.setBounds(85, 70, 40, 20);
		add(pv_);
		pa_=new JLabel(String.valueOf(pers_.getStats().getPa()));
		pa_.setBounds(85, 90, 40, 20);
		add(pa_);
		pm_=new JLabel(String.valueOf(pers_.getStats().getPm()));
		pm_.setBounds(85, 110, 40, 20);
		add(pm_);
		
		//pm_=;
		//pv_=;
	}
}
