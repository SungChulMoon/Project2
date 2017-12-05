package weatherCodination;

import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

import InnerClass.CodiOb;
import InnerClass.DBmethod;


/** 
 * 옷 객체를 생성하는 클래스
 * 
 * @author 지우
 * 
 */
public class initialCloth {
	/**파일과 관련된 옷 객체를 담고 있는 ArrayList*/
	static public ArrayList<CodiOb> clothArr=new ArrayList<CodiOb>();
	/**아우터 객체를 담고 있는 ArrayList*/
	static public ArrayList<outer> clo_outer = new ArrayList<outer>();
	/**상의 객체를 담고 있는 ArrayList*/
	static public ArrayList<top> clo_top = new ArrayList<top>();
	/**하의 객체를 담고 있는 ArrayList*/
	static public ArrayList<pants> clo_pants = new ArrayList<pants>();
	/**신발 객체를 담고 있는 ArrayList*/
	static public ArrayList<shoes> clo_shoes = new ArrayList<shoes>();

	/**이미지 경로를 담아두는 String*/
	String imgPath = "src/clothes/";
	String sex;
	/**
	 * addCloth의 생성자
	 * 
	 * */
	initialCloth(String sex, String body) {
		
		this.sex=sex;
		
		try {
			clothArr=DBmethod.selectCodi(sex);
		}catch(Exception e) {
			System.out.println("cloth File is empty.");
		}
		
		this.initialOuter();
		this.initialTop();
		this.initialPants();
		this.initialShoes();
	}

	
	/**
	 * 초기 outer객체를 생성해 ArrayList인 clo_outer에 삽입하는 함수
	 * */
	public void initialOuter() {
		
		String[] m_initialOuter= {"outer1.PNG","outer2.PNG","outer3.PNG","outer4.PNG","outer5.PNG",
								"w_outer1.PNG","w_outer2.PNG","w_outer3.PNG","w_outer4.PNG"};
		String[] w_initialOuter={"cardigan1.PNG", "coat1.PNG","coat2.PNG","coat3.PNG","coat4.PNG",
				"coat5.PNG","pd1.PNG","pd2.PNG","pd3.PNG","pd4.PNG",
				"w_outer1.PNG","w_outer2.PNG","w_outer3.PNG","w_outer0.PNG"};
		
		String[] w_link= {"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/item/7767169","https://codibook.net/item/7786366",
						"https://ko.codibook.net/item/7786180","https://codibook.net/item/7780295?recStrategy=004061","https://codibook.net/codi/7502288","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/"};
		String[] m_link= {"http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/",
						"http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/"};
		
		int[] w_thick={1,3,3,3,4,3,5,5,3,2,3,3,3,5};
		int[] m_thick= {5,5,5,3,5,5,3,3,5};
		
		int[][] w_style= {{3,0,1,3},{5,0,2,2},{5,0,2,4},{5,0,5,2},{0,5,0,5},
						{2,3,0,5},{3,3,0,3},{0,5,0,3},{3,4,0,3},{2,2,0,5},
						{0,5,0,2},{5,1,3,2},{1,4,0,5},{5,5,5,5}};
		int[][] m_style= {{5,0,5,1},{5,3,0,3},{5,3,5,5},{5,5,0,5},{5,0,5,0},
						{5,5,5,5},{2,5,0,5},{5,5,0,5},{5,0,3,3}};
		
		int[] w_weather= {2,2,2,2,2,2,2,2,2,2,1,1,1,1};
		int[] m_weather= {2,2,2,2,2,1,1,1,1,1};
		
		int[][] w_body= {{5,5,1,0},{3,3,2,1},{3,3,3,4},{3,3,3,5},{3,3,3,3},
				{2,3,0,0},{3,3,0,3},{0,5,0,0},{3,4,0,0},{2,2,0,0},
				{3,3,3,3},{3,3,3,3},{3,3,3,3},{3,3,3,3}};
		int[][] m_body= {{5,3,3,1},{3,3,3,3},{3,3,3,3},{3,3,3,2},{3,3,3,0},
				{3,3,3,3},{3,3,3,3},{3,3,3,3},{3,3,3,3}};
		
		String outerPath=null;

		if(sex.equals("남자")) {
			outerPath=imgPath + "outer/man/";
			
			for (int i = 0; i < m_initialOuter.length; i++) {
				ImageIcon icon = new ImageIcon(outerPath + m_initialOuter[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				outer tmp = new outer(m_weather[i], m_thick[i],  m_style[i], m_body[i] ,changedImg, m_link[i]);
				clo_outer.add(tmp);
			}
		}else {
			outerPath=imgPath + "outer/";
			for (int i = 0; i < w_initialOuter.length; i++) {
				ImageIcon icon = new ImageIcon(outerPath + w_initialOuter[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				outer tmp = new outer(w_weather[i], w_thick[i], w_style[i], w_body[i], changedImg, w_link[i]);
				clo_outer.add(tmp);
			}
		}
	}	
	
	/**
	 * 초기 top객체를 생성해 ArrayList인 clo_top에 삽입하는 함수
	 * */
	public void initialTop()  {
		String topPath;
		
		String[] w_initialtop= {"mtm1.PNG", "nt1.PNG","nt2.PNG","nt3.PNG","nt4.PNG",
								"nt5.PNG","nt6.PNG","nt6.PNG","nt8.PNG","shirts1.PNG",
								"shirts2.PNG","shirts3.PNG","t1.PNG","w_top1.PNG","w_top2.PNG",
								"w_top3.PNG","w_top4.PNG","w_top5.PNG","w_top6.PNG","w_top7.PNG"};
		String[] m_initialTop= {"top1.PNG","top2.PNG","top3.PNG","top4.PNG","top5.PNG",
				"top6.PNG","w_top1.PNG","w_top2.PNG","w_top3.PNG","w_top4.PNG",
				"w_top5.PNG","w_top6.PNG","w_top7.PNG"};
		
		int[] w_thick={3,4,4,5,5,
					3,5,4,4,2,
					2,2,2,5,3,
					4,2,3,1,2};
		int[] m_thick={3,3,5,5,2,2,
				5,5,5,5,5,3,3};
		int[][] w_style= {{3,3,0,3},{3,3,3,2},{5,0,5,3},{2,3,0,3},{3,3,0,4},
						{0,5,0,0},{1,5,0,0},{3,3,3,2},{0,2,0,5},{5,0,5,5},
						{5,0,3,3},{3,0,0,5},{3,3,3,3},{3,2,5,3},{1,4,2,1},
						{5,5,1,2},{1,3,0,4},{5,1,5,2},{0,5,1,1},{5,0,2,2}};
		int[][] m_style= {{5,2,3,3},{5,5,0,2},{5,2,5,2},{5,3,5,2},{5,3,3,2},
						{5,5,5,3},{5,5,5,3},{5,5,5,3},{5,5,1,3},{5,5,3,3},
						{5,2,5,3},{5,3,5,3},{5,3,5,3}};
		
		String[] w_link= {"https://codibook.net/item/7780475?recStrategy=004061","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/",
				"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/",
				"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/"};
		String[] m_link= {"http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/"};
		
		int[] w_weather= {2,2,2,2,2,
						2,2,2,2,2,
						2,2,2,1,1,
						1,1,1,1,1};
		int[] m_weather= {2,2,2,2,2,2,1,1,1,1,1,1,1};
		
		int[][] w_body= {{3,3,0,3},{3,3,3,2},{5,0,5,3},{2,3,0,3},{3,3,0,4},
				{0,5,0,0},{1,5,0,0},{3,3,3,2},{0,2,0,5},{5,0,5,5},
				{5,0,3,3},{3,0,0,5},{3,3,3,3},{3,2,5,3},{1,4,2,1},
				{5,5,1,2},{1,3,0,4},{5,1,5,2},{0,5,1,1},{5,0,2,2}};
		int[][] m_body= {{5,2,3,3},{5,5,0,2},{5,2,5,2},{5,3,5,2},{5,3,3,2},
				{5,5,5,3},{5,5,5,3},{5,5,5,3},{5,5,1,3},{5,5,3,3},
				{5,2,5,3},{5,3,5,3},{5,3,5,3}};
		

		if(sex.equals("남자")) {
			topPath=imgPath + "top/man/";
			
			for (int i = 0; i < m_initialTop.length; i++) {
				ImageIcon icon = new ImageIcon(topPath + m_initialTop[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				top tmp = new top(m_weather[i], m_thick[i], m_style[i], m_body[i],changedImg, m_link[i]);
				clo_top.add(tmp);
			}
			
		}else {
			topPath=imgPath+"top/";
			
			for (int i = 0; i < w_initialtop.length; i++) {
				ImageIcon icon = new ImageIcon(topPath + w_initialtop[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				top tmp = new top(w_weather[i], w_thick[i], w_style[i], w_body[i],changedImg, w_link[i]);
				clo_top.add(tmp);
			}
			
		}
	}
	/**
	 * 초기 pants객체를 생성해 ArrayList인 clo_pants에 삽입하는 함수
	 * */
	public void initialPants()  {
		String pantsPath;
		
		String[] initialPants= {"pants1.PNG","pants2.PNG","pants3.PNG","pants4.PNG","pants5.PNG",
				"skt1.PNG","skt2.PNG","skt3.PNG","skt4.PNG","skt5.PNG",
				"w_pants1.PNG","w_pants2.PNG","w_pants3.PNG","w_pants4.PNG","w_pants5.PNG",
				"w_pants6.PNG","w_pants7.PNG","w_pants8.PNG","w_pants9.PNG","w_pants10.PNG"};
		String[] m_initialPants= {"pants1.PNG","pants2.PNG","pants3.PNG","pants4.PNG","pants5.PNG",
				"w_pants1.PNG","w_pants2.PNG","w_pants3.PNG","w_pants4.PNG","w_pants5.PNG"};
		
		String[] link= {"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/item/7774804","https://codibook.net/item/7639641",
				"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/"};
		String[] m_link= {"http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/"};
		
		
		int[] thick={3,3,3,3,3,
					4,4,4,4,3,
					4,4,5,3,2,
					2,2,2,2,2};
		int[] m_thick= {3,3,3,3,3,3,3,3,3,3};
		
		int[][] style= {{5,2,3,3},{3,2,3,4},{0,0,0,5},{3,2,0,5},{5,2,2,3},
						{2,5,5,0},{2,0,0,5},{4,0,2,3},{0,5,3,5},{5,0,4,1},
						{4,3,5,1},{1,5,3,0},{3,3,3,3},{2,2,0,2},{3,5,3,0},
						{2,4,4,0},{5,2,4,3},{5,2,2,2},{2,0,0,5},{5,0,1,2}};
		int[][] m_style= {{3,3,3,3},{3,3,3,3},{5,3,5,3},{3,3,3,3},{3,3,3,3},
						{3,3,3,3},{3,3,3,3},{3,3,3,3},{3,3,3,3},{3,3,3,3}};
		int[] weather= {2,2,2,2,2,2,2,2,2,2,
						1,1,1,1,1,1,1,1,1,1};
		int[] m_weather= {2,2,2,2,2,1,1,1,1,1};
		
		int[][] w_body = { { 5, 2, 3, 3 }, { 3, 2, 3, 4 }, { 0, 0, 0, 5 }, { 3, 2, 0, 5 }, { 5, 2, 2, 3 },
				{ 2, 5, 5, 0 }, { 2, 0, 0, 5 }, { 4, 0, 2, 3 }, { 0, 5, 3, 5 }, { 5, 0, 4, 1 }, { 4, 3, 5, 1 },
				{ 1, 5, 3, 0 }, { 3, 3, 3, 3 }, { 2, 2, 0, 2 }, { 3, 5, 3, 0 }, { 2, 4, 4, 0 }, { 5, 2, 4, 3 },
				{ 5, 2, 2, 2 }, { 2, 0, 0, 5 }, { 5, 0, 1, 2 } };
		int[][] m_body = { { 3, 3, 3, 3 }, { 3, 3, 3, 3 }, { 5, 3, 5, 3 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 },
				{ 3, 3, 3, 3 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 }, { 3, 3, 3, 3 } };
		
		if(sex.equals("남자")) {	
			pantsPath=imgPath + "pants/man/";
			
			for (int i = 0; i < m_initialPants.length; i++) {
				ImageIcon icon = new ImageIcon(pantsPath + m_initialPants[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				pants tmp = new pants(m_weather[i], m_thick[i], m_style[i], m_body[i], changedImg, m_link[i]);
				clo_pants.add(tmp);
			}
		}else {
			pantsPath=imgPath+"pants/";
			
			for (int i = 0; i < initialPants.length; i++) {
				ImageIcon icon = new ImageIcon(pantsPath + initialPants[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				pants tmp = new pants(weather[i], thick[i], style[i], w_body[i],changedImg, link[i]);
				clo_pants.add(tmp);
			}
		}
	}
	
	/**
	 * 초기 shoes객체를 생성해 ArrayList인 clo_shoes에 삽입하는 함수
	 * */
	public void initialShoes()  {
		String shoesPath;
		String[] initialShoes= {"sh1.PNG","sh2.PNG","sh3.PNG","sh4.PNG","sh5.PNG","sh6.PNG",
								"w_shoes1.PNG","w_shoes2.PNG","w_shoes3.PNG","w_shoes4.PNG","w_shoes5.PNG","w_shoes6.PNG","w_shoes7.PNG"};
		String[] m_initialShoes= {"shoes1.PNG","shoes2.PNG","shoes3.PNG","shoes4.PNG","shoes5.PNG","w_shoes1.PNG","w_shoes2.PNG","w_shoes3.PNG","w_shoes4.PNG"};
		
		int[] thick={2,3,4,3,5,3,3,3,4,3,3,5,3};
		int[] m_thick= {3,3,3,5,3,5,5,3,3};
		
		int[][] style= {{1,5,3,2},{5,1,2,5},{5,0,0,5},{5,5,0,5},{3,3,3,2},
						{4,4,1,4},{5,5,0,5},{5,5,0,5},{0,3,3,0},{5,5,0,5},{5,5,0,5},{5,2,0,5},{5,0,5,0}};
		int[][] m_style= {{3,1,5,1},{3,3,2,3},{3,3,3,3},{3,1,3,3},{3,3,3,3},{3,3,1,3},{3,3,1,3},{3,3,3,3},{3,3,3,3}};
		
		String[] link={"https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/","https://codibook.net/"};
		String[] m_link= {"http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/","http://store.musinsa.com/"};
		
		int[] weather= {2,2,2,2,2,2,1,1,1,1,1,1,1};
		int[] m_weather= {2,2,2,2,2,1,1,1,1};
		
		int[][] body= {{1,5,3,2},{5,1,2,5},{5,0,0,5},{5,5,0,5},{3,3,3,2},
				{4,4,1,4},{5,5,0,5},{5,5,0,5},{0,3,3,0},{5,5,0,5},{5,5,0,5},{5,2,0,5},{5,0,5,0}};
		int[][] m_body= {{3,1,5,1},{3,3,2,3},{3,3,3,3},{3,1,3,3},{3,3,3,3},{3,3,1,3},{3,3,1,3},{3,3,3,3},{3,3,3,3}};

		if(sex.equals("남자")) {		
			shoesPath=imgPath + "shoes/man/";
			
			for (int i = 0; i < m_initialShoes.length; i++) {
				ImageIcon icon = new ImageIcon(shoesPath + m_initialShoes[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				shoes tmp = new shoes(m_weather[i], m_thick[i], m_style[i], m_body[i], changedImg, m_link[i]);
				clo_shoes.add(tmp);
			}
			
		}else {
			shoesPath = imgPath + "shoes/";
			for (int i = 0; i < initialShoes.length; i++) {
				ImageIcon icon = new ImageIcon(shoesPath + initialShoes[i]);
				Image img = icon.getImage();
				Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);

				shoes tmp = new shoes(weather[i], thick[i], style[i],body[i], changedImg, link[i]);
				clo_shoes.add(tmp);
			}
		}
	}
}
