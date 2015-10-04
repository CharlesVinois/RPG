package com.game.ihm;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.game.rpg.Position;
public class Screen extends JPanel{
	private static final long serialVersionUID = 1L;
	private int width_;
	private int height_;
	private ArrayList<Cell> celign_;
	private ArrayList<ArrayList<Cell>> cells_;
	public Screen(int w, int h, Display jp){
		width_=w;
		height_=h;//(h*30)/100;
		Cell ce=null;
		cells_ = new ArrayList<ArrayList<Cell>>();
		this.setSize(width_, height_);
		for(int i=0;i<18;i++)
		{	
			celign_ = new ArrayList<Cell>();
			for(int j=0;j<18;j++)
			{
				Position p =new Position(j, i);
				ce=new Cell(jp, cells_, p, 1, new ImageIcon("src/Map/Sol.png"), new ImageIcon("src/Map/Solp.png"));
				celign_.add(ce);
				this.add(ce);
			}
			cells_.add(celign_);
		}
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
	}
	public Cell getCell(int i, int j){
		if(i<0)
			return cells_.get(0).get(j);
		else if (j<0)
			return cells_.get(i).get(0);
		return cells_.get(i).get(j);
	}
	public Position getCellsCliqued(){
		for(int i=0;i<18;i++)
			for(int j=0;j<18;j++)	
				if(cells_.get(i).get(j).getCliqued())
					return new Position(i, j);
		return null;
	}
}
