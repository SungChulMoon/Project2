package weatherCodination;

import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;

import InnerClass.CodiOb;
import InnerClass.DBmethod;


/** 
 * ��� �����ͷκ��� �� ��ü�� �����ϴ� Ŭ����
 * 
 * @author ����
 * 
 */
public class initialFileCloth {
	/**���ϰ� ���õ� �� ��ü�� ��� �ִ� ArrayList*/
	static public ArrayList<CodiOb> clothArr=new ArrayList<CodiOb>();
	/**�ƿ��� ��ü�� ��� �ִ� ArrayList*/
	static public ArrayList<outer> clo_outer = new ArrayList<outer>();
	/**���� ��ü�� ��� �ִ� ArrayList*/
	static public ArrayList<top> clo_top = new ArrayList<top>();
	/**���� ��ü�� ��� �ִ� ArrayList*/
	static public ArrayList<pants> clo_pants = new ArrayList<pants>();
	/**�Ź� ��ü�� ��� �ִ� ArrayList*/
	static public ArrayList<shoes> clo_shoes = new ArrayList<shoes>();

	/**�̹��� ��θ� ��Ƶδ� String*/
	String imgPath = "src/clothes/";
	String sex;
	/**
	 * addCloth�� ������
	 * 
	 * */
	initialFileCloth(String sex) {
		
		this.sex=sex;
		
		try {
			clothArr=DBmethod.selectCodi(sex);
		}catch(Exception e) {
			System.out.println("cloth File is empty.");
		}
		
		initialFile();

	}
	
	public static void cloclear() {
		clothArr.clear();
		clo_outer.clear();
		clo_pants.clear();
		clo_shoes.clear();
		clo_top.clear();
	}

	public void initialFile() {
		int[] tmpStyle=new int[4];
		int[] tmpBody=new int[4];

			
			for(int i=0; i<clothArr.size() ; i++) {
				
					ImageIcon icon = new ImageIcon(clothArr.get(i).getFilepath());
					Image img = icon.getImage();
					Image changedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
					
					
					tmpStyle[0]=sti(clothArr.get(i).getStyle1());
					tmpStyle[1]=sti(clothArr.get(i).getStyle2());
					tmpStyle[2]=sti(clothArr.get(i).getStyle3());
					tmpStyle[3]=sti(clothArr.get(i).getStyle4());
					
					tmpBody[0]=sti(clothArr.get(i).getBody1());
					tmpBody[1]=sti(clothArr.get(i).getBody2());
					tmpBody[2]=sti(clothArr.get(i).getBody3());
					tmpBody[3]=sti(clothArr.get(i).getBody4());
					
					if(clothArr.get(i).getType()=="outer") {
					outer tmp = new outer(clothArr.get(i).getSeason(),sti(clothArr.get(i).getThick()), tmpStyle, tmpBody, 
							changedImg, clothArr.get(i).getFilepath());
					clo_outer.add(tmp);
					}else if(clothArr.get(i).getType()=="top") {
						top tmp = new top(clothArr.get(i).getSeason(), 
								sti(clothArr.get(i).getThick()), tmpStyle, tmpBody, changedImg, clothArr.get(i).getFilepath());
						clo_top.add(tmp);
					}else if(clothArr.get(i).getType()=="pants") {
						pants tmp = new pants(clothArr.get(i).getSeason(), 
								sti(clothArr.get(i).getThick()), tmpStyle, tmpBody, changedImg, clothArr.get(i).getFilepath());
						clo_pants.add(tmp);
					}else {
						shoes tmp = new shoes(clothArr.get(i).getSeason(), 
								sti(clothArr.get(i).getThick()), tmpStyle, tmpBody, changedImg, clothArr.get(i).getFilepath());
						clo_shoes.add(tmp);
					}
						
			}
	
	}
	
	public int sti(String s) {
		return Integer.parseInt(s);
	}
}
