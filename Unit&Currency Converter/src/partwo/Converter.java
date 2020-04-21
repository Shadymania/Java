package partwo;
/* 	Developer:
	Nabin Atreya Sunar
	C7202333
	The British College
*/
		
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

		public class Converter extends JPanel {
			
				public Converter(){
					JFrame frame = new JFrame("Conversion Tool");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);
					
					JLabel con=new JLabel("<html> 🅒🅞🅝🅥🅔🅡🅢🅘🅞🅝 <html>");
					con.setFont(new Font("Black Square",Font.ITALIC,40));
					con.setBackground(Color.white);
					
					con.setBounds(390, 0, 600, 50);
					frame.getContentPane().add(con);
					// calling the another class
					MainPanel panel = new MainPanel();
					
					// adding compound border to the MainPanel
					panel.setBackground(Color.YELLOW);
					panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "Unit Conversion", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
					panel.setBounds(25, 70, 1450, 300);
					
					// adding compound border to CurrencyPanel
					CurrencyPanel currency_panel = new CurrencyPanel();
					currency_panel.setBackground(Color.YELLOW);
					currency_panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 0, 0), 1, true), "Currency Conversion", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
					currency_panel.setBounds(25, 400, 1450, 300);

					// adding colors to the panels
					panel.setBackground(Color.decode("#297ca0"));
					currency_panel.setBackground(Color.decode("#46b3e6"));
				
					frame.setJMenuBar(panel.setupMenu());	
					ImageIcon convertimg=new ImageIcon("../C7202333/convert.png");
					frame.setIconImage(convertimg.getImage());	
					frame.getContentPane().add(panel);
					frame.getContentPane().add(currency_panel);
					frame.getContentPane().setBackground(Color.decode("#dedef0"));
					frame.setSize(1500, 800);
					
					ImageIcon image=new ImageIcon("../c7202333/convert.png");
					frame.setIconImage(image.getImage());	
					
					frame.setVisible(true);
				
				}
		}
