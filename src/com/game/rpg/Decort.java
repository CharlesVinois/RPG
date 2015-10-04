package com.game.rpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.PaintContext;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import com.game.combat.Competance;

//import java.awt.Image;
public class Decort extends JLabel implements ActionListener{
	private int size_;
	private Position pos_;//position x
	private int type_;//0 normal, 1 Mineral, 2 Vegetal, 3 case d'effet, 4 case start
	private String name_;//ex:(Rocher, arbre, piege, buff)
	private boolean iswalkable_;//1 on peut marcher dessu, 2 non
	private boolean isoveralbe_;//1 on peut attaquer a travers, 2 non
	private boolean issomebody_;//1 il y a un pers sur la case, 2 personne
	private List<Competance> comp_;//Si c'est une case trape ou si la case est attaqué(transfert de degat) */
	private ImageIcon img_;
	private Timer dec_;
	public Decort(Position p){
		size_=1;
		pos_=p;
		type_=0;
		name_="";
		iswalkable_=true;
		isoveralbe_=true;
		issomebody_=false;
		comp_=new ArrayList<Competance>();
		try {
			BufferedImage im = ImageIO.read(new File("src/Map/Sol.png"));
		img_=new ImageIcon(makeColorTransparent(im, new Color(im.getRGB(0, 0))));
		setIcon(img_);
		repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dec_=new Timer(100, this);
		dec_.start();
	}
	public Decort(int siz, Position p, int typ, String name, boolean isw, boolean iso, boolean iss, ImageIcon img){
		size_=siz;
		pos_=p;
		type_=typ;
		name_=name;
		iswalkable_=isw;
		isoveralbe_=iso;
		issomebody_=iss;
		comp_=new ArrayList<Competance>();
		img_=img;
		setBounds(p.getPosx(), p.getPosy(), img.getIconWidth(), img.getIconHeight());
		BufferedImage bi = new BufferedImage( img.getIconWidth(), img.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		// paint the Icon to the BufferedImage.
		img.paintIcon(null, g, 0,0);
		g.dispose();
		//BufferedImage im = ImageIO.read(new File("src/Map/Sol.png"));
		img_=new ImageIcon(makeColorTransparent(bi, new Color(bi.getRGB(0, 0))));
		setIcon(img_);
		repaint();
		//this.setBackground(new Color(0,0,0,0));
		//repaint();
		this.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e) {
				//repaint();
			}
			public void mouseMoved(MouseEvent e) {
				setIcon(img_);
				repaint();
			}
		});
		dec_=new Timer(100, this);
		dec_.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(img_.getImage(), 0, 0, null);
	};
	private static BufferedImage imageToBufferedImage(final Image image)  
	   {  
	      final BufferedImage bufferedImage =  
	         new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);  
	      final Graphics2D g2 = bufferedImage.createGraphics();  
	      g2.drawImage(image, 0, 0, null);  
	      g2.dispose();  
	      return bufferedImage;  
	    }  
	  
	   /** 
	    * Make provided image transparent wherever color matches the provided color. 
	    * 
	    * @param im BufferedImage whose color will be made transparent. 
	    * @param color Color in provided image which will be made transparent. 
	    * @return Image with transparency applied. 
	    */  
	   public static Image makeColorTransparent(final BufferedImage im, final Color color)  
	   {  
	      final ImageFilter filter = new RGBImageFilter()  
	      {  
	         // the color we are looking for (white)... Alpha bits are set to opaque  
	         public int markerRGB = color.getRGB() | 0xFFFFFFFF;  
	  
	         public final int filterRGB(final int x, final int y, final int rgb)  
	         {  
	            if ((rgb | 0xFF000000) == markerRGB)  
	            {  
	               // Mark the alpha bits as zero - transparent  
	               return 0x00FFFFFF & rgb;  
	            }  
	            else  
	            {  
	               // nothing to do  
	               return rgb;  
	            }  
	         }  
	      };  
	  
	      final ImageProducer ip = new FilteredImageSource(im.getSource(), filter);  
	      return Toolkit.getDefaultToolkit().createImage(ip);  
	   }  
	public int getSiz(){
		return size_;
	}
	public void setSize(int siz){
		size_=siz;
	}
	public Position getPos(){
		return pos_;
	}
	public void setPos(Position pos){
		pos_=pos;
	}
	public int getType(){
		return type_;
	}
	public void setType(int type){
		type_=type;
	}
	public boolean getIsw(){
		return iswalkable_;
	}
	public void setIsw(boolean isw){
		iswalkable_=isw;
	}
	public boolean getIso(){
		return isoveralbe_;
	}
	public void setIso(boolean iso ){
		isoveralbe_=iso;
	}
	public boolean getIss(){
		return issomebody_;
	}
	public void setIss(boolean iss){
		issomebody_=iss;
	}
	public List<Competance> getComp(){
		if(comp_!=null)
			return comp_;
		return null;
	}
	public void setComp(Competance comp){
		comp_.add(comp);
	}
	public ImageIcon getImg(){
		return img_;
	}
	public void setImg(ImageIcon img){
		img_=img;
	}
	
}