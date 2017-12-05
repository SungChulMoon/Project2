package weatherCodination;

import java.awt.*;

import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

import InnerClass.DBmethod;

import java.util.*;

/**
 *�ڵ� ���÷��� ���ִ� Ŭ����
 * 
 * @author ����
 * @see JPanel
 */
public class codiDisplay extends JPanel {
	/**outer �̹��� ��*/
	JLabel imageOuterLabel;
	/**top �̹��� ��*/
	JLabel imageTopLabel;
	/**pants �̹��� ��*/
	JLabel imagePantsLabel;
	/**shoes �̹��� ��*/
	JLabel imageShoesLabel;
	
	/**���θ� ��ũ�� ���� String �迭*/
	String[] link=new String[4];
	/**�ڵ� ���÷��� ���ִ� �г�*/
	codiPanel panel;
	String temp = "";
	String stylest="";
	String sizest="";

	/**
	 * codiDisplay ������
	 */
	public codiDisplay(String sex, String id, String temp, String stylest, String sizest){
		setLayout(null);
		
		initialCloth testAddCloth=new initialCloth(sex);
		
		panel=new codiPanel(Integer.parseInt(temp), stylest, sizest);
		panel.setLocation(0,0);
		panel.setSize(1000,250);
		add(panel);
		
		ImageIcon buttonIcon=new ImageIcon("src/clothes/refresh.png");
		JButton btn=new JButton(buttonIcon);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.refreshCodi(Integer.parseInt(temp), stylest, sizest);
				panel.updateUI();
			}
		});
		btn.setOpaque(false);
		btn.setLocation(1010,200);
		btn.setSize(40,40);
		
		add(btn);
	}
	
	/**
	 * �ϼ��� �ڵ� ���� �г� Ŭ����
	 * 
	 * @author ����
	 * @see JPanel
	 */
	class codiPanel extends JPanel {
		JPanel subPanel;
		matchCloth testMatchCloth;
		
		/**
		 * �ڵ� �г��� ������
		 * 
		 * @param temp ���� ��� int
		 * @param stylest ȸ���� ��Ÿ�� String
		 * @param sizest ȸ���� ��Ÿ�� ���� int
		 */
		codiPanel(int temp, String stylest,String sizest){
		
			testMatchCloth=new matchCloth(temp, stylest, sizest);
						
			subPanel=new JPanel();
			subPanel.setLayout(new GridLayout(1,4));
			
			codiObject codi;
			codi= new codiObject();
			
			subPanel=new JPanel();
			subPanel.setLayout(new GridLayout(1,4));
			
			link[0]=codi.codiOuter.link;
			ImageIcon outer=new ImageIcon(codi.codiOuter.image);
			imageOuterLabel=new JLabel(outer);
			imageOuterLabel.addMouseListener(new LinkMouseListener());
			
			link[1]=codi.codiTop.link;
			ImageIcon top=new ImageIcon(codi.codiTop.image);
			imageTopLabel=new JLabel(top);
			imageTopLabel.addMouseListener(new LinkMouseListener());
			
			link[2]=codi.codiPants.link;
			ImageIcon pants=new ImageIcon(codi.codiPants.image);
			imagePantsLabel=new JLabel(pants);
			imagePantsLabel.addMouseListener(new LinkMouseListener());
			
			link[3]=codi.codiShoes.link;
			ImageIcon shoes=new ImageIcon(codi.codiShoes.image);
			imageShoesLabel=new JLabel(shoes);
			imageShoesLabel.addMouseListener(new LinkMouseListener());
			
			add(subPanel);
			subPanel.add(imageOuterLabel);
			subPanel.add(imageTopLabel);
			subPanel.add(imagePantsLabel);
			subPanel.add(imageShoesLabel);
		}
		
		/**
		 * �ڵ� ���� ��ħ���ִ� �޼ҵ�
		 * 
		 * @param temp ���� ��� int
		 * @param stylest ȸ���� ��Ÿ�� String
		 * @param sizest ȸ���� ��Ÿ�� ���� int
		 */
		private void refreshCodi(int temp, String stylest,String sizest){
			codiObject codi;
			testMatchCloth=new matchCloth(temp, stylest, sizest);
						
			subPanel=new JPanel();
			subPanel.setLayout(new GridLayout(1,4));
			
			codi= new codiObject();
			
			subPanel=new JPanel();
			subPanel.setLayout(new GridLayout(1,4));
			
			link[0]=codi.codiOuter.link;
			ImageIcon outer=new ImageIcon(codi.codiOuter.image);
			imageOuterLabel=new JLabel(outer);
			imageOuterLabel.addMouseListener(new LinkMouseListener());
			
			link[1]=codi.codiTop.link;
			ImageIcon top=new ImageIcon(codi.codiTop.image);
			imageTopLabel=new JLabel(top);
			imageTopLabel.addMouseListener(new LinkMouseListener());
			
			link[2]=codi.codiPants.link;
			ImageIcon pants=new ImageIcon(codi.codiPants.image);
			imagePantsLabel=new JLabel(pants);
			imagePantsLabel.addMouseListener(new LinkMouseListener());
			
			link[3]=codi.codiShoes.link;
			ImageIcon shoes=new ImageIcon(codi.codiShoes.image);
			imageShoesLabel=new JLabel(shoes);
			imageShoesLabel.addMouseListener(new LinkMouseListener());
			
			add(subPanel);
			subPanel.add(imageOuterLabel);
			subPanel.add(imageTopLabel);
			subPanel.add(imagePantsLabel);
			subPanel.add(imageShoesLabel);
		}
	}
	
	
	/**
	 * ���콺 Ŭ���� �ش� ���θ��� �̵����ִ� Ŭ����
	 * 
	 * @author ����
	 *
	 */
	class LinkMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			JLabel la = (JLabel)e.getSource();
			URI uri;
			if(e.getClickCount()>0) {
				if(Desktop.isDesktopSupported()) {
					Desktop desktop=Desktop.getDesktop();
					try {
						if(la.equals(imageOuterLabel)) {
							uri = new URI(link[0]);
							desktop.browse(uri);
						}else if(la.equals(imageTopLabel)) {
							uri = new URI(link[1]);
							desktop.browse(uri);
						}else if(la.equals(imagePantsLabel)) {
							uri = new URI(link[2]);
							desktop.browse(uri);
						}else if(la.equals(imageShoesLabel)){
							uri = new URI(link[3]);
							desktop.browse(uri);
						} 
					}catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
}
