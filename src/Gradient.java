import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;  
import java.awt.Graphics;  
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;  
public class Gradient extends JPanel   
{  
 public void paint(Graphics g)   
 {  
  super.paint(g);  
  
  Graphics2D graph = (Graphics2D) g;  
 //GradientPaint gp1 = new GradientPaint(0, 0, new Color(200,200,255), 820, 620, new Color(30,254,152));  
  
  GradientPaint paint = new GradientPaint(0, 620, new Color(195,55,100), 820, 0, new Color(29,38,113));  
  
  graph.setPaint(paint);  
  graph.fillRect(00, 00, 820, 620);
 
 } 
 
 public static void main(String[] args)   
 {  
  JFrame frame = new JFrame();  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
  frame.setSize(820, 620);  
  frame.setVisible(true);
  JPanel h = new Gradient();
  frame.add(h);
  frame.setVisible(true);

 }


} 
