package com.game.ihm;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.game.rpg.Map;
import com.game.rpg.Position;
@SuppressWarnings("serial")
public class Game extends JFrame{
	private Display sc_;
	private ActioBar ab_;
	//private Menu MParam_;
	public Game(){
		setTitle("Rpg"); //On donne un titre a l'application
		setSize(752,615); //On donne une taille a notre fenetre
		setLocationRelativeTo(null); //On centre la fenetre sur l'ecran
		setResizable(false); //On interdit le redimensionnement de la fenetre
		//setMinimumSize(new Dimension(540, 580));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit a l'application de se fermer lors du clic
		//if(lauded)else
		sc_ = new Display(this);
		getContentPane().add(sc_, BorderLayout.WEST);
		ab_ = new ActioBar(165, 586, this);
		getContentPane().add(ab_, BorderLayout.EAST);
		setLayout(null);
	    setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) throws InterruptedException {
		//JFrame frame = 
				new Game();
	}
}