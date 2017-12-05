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
 *코디를 디스플레이 해주는 클래스
 * 
 * @author 지우
 * @see JPanel
 */
public class codiDisplay extends JPanel {
	/**outer 이미지 라벨*/
	JLabel imageOuterLabel;
	/**top 이미지 라벨*/
	JLabel imageTopLabel;
	/**pants 이미지 라벨*/
	JLabel imagePantsLabel;
	/**shoes 이미지 라벨*/
	JLabel imageShoesLabel;
	
	/**쇼핑몰 링크를 담을 String 배열*/
	String[] link=new String[4];
	/**코디를 디스플레이 해주는 패널*/
	codiPanel panel;
	String temp = "";
	String stylest="";
	String sizest="";

	
	  
	
	/**
	 * codiDisplay 생성자
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
	 * 완성된 코디를 담을 패널 클래스
	 * 
	 * @author 지우
	 * @see JPanel
	 */
	class codiPanel extends JPanel {
		JPanel subPanel;
		matchCloth testMatchCloth;
		
		/**
		 * 코디 패널의 생성자
		 * 
		 * @param temp 현재 기온 int
		 * @param stylest 회원의 스타일 String
		 * @param sizest 회원의 스타일 갯수 int
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
		 * 코디를 새로 고침해주는 메소드
		 * 
		 * @param temp 현재 기온 int
		 * @param stylest 회원의 스타일 String
		 * @param sizest 회원의 스타일 갯수 int
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
	 * 마우스 클릭시 해당 쇼핑몰로 이동해주는 클래스
	 * 
	 * @author 지우
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
