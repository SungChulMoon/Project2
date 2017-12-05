package weatherCodination;

import java.awt.Image;


/** 
 * 
 * �ڵ� �ʿ��� �� Ŭ����
 * �� Ŭ������ �ڵ� �ʿ��� �� ��ü�� �����Ѵ�.
 * 
 * @author ����
 * 
 */

public class clothObject {
	/**�������� ��Ÿ���� int ����*/
	String weather;
	/**�β����� ��Ÿ���� int ����*/
	int thick;
	/**��Ÿ���� ��Ÿ���� int�迭 ����*/
	int[] style=new int [4];
	/**ü���� ��Ÿ���� int�迭 ����*/
	int[] body=new int [4];
	/**���� �̹����� ��Ÿ���� Image ����*/
	Image image;
	/**���θ� ��ũ�� ��Ÿ���� String ����*/
	String link;
	
	/**
	 * �� ��ü�� ������
	 * 
	 * @param wt ���� ������
	 * @param th ���� �β���
	 * @param st ���� ��Ÿ�� �迭
	 * @param img �� �̹���
	 * @param lk ���θ� ��ũ
	 */
	clothObject(String wt,int th, int[] st, int[] bd, Image img, String lk) {
		weather=wt;
		thick=th;
		for(int i=0; i<4; i++) style[i]=st[i];
		
		for(int i=0; i<4; i++) {
			body[i]=bd[i];
		}

		image=img;
		link=lk;
	}
}


/**
 * �ѿ��� ������ ��� outerŬ����.
 * 
 * @author ����
 * @see clothObject
 */
class outer extends clothObject{
	
	outer(String wt,int th, int[] st,int[] bd, Image img, String link) {
		super(wt, th, st, bd, img, link);
	}
};
/**
 * ������ ������ ��� topŬ����.
 * 
 * @author ����
 * @see clothObject
 */
class top extends clothObject{
	top(String wt, int th, int[] st,int[] bd, Image img, String link) {
		super(wt, th, st, bd,img, link);
	}
};
/**
 * ������ ������ ��� pantsŬ����.
 * 
 * @author ����
 * @see clothObject
 */
class pants extends clothObject{
	pants(String wt, int th, int[] st,int[] bd, Image img, String link) {
		super(wt, th, st, bd,img, link);
	}
};
/**
 * �Ź��� ������ ��� shoesŬ����.
 * 
 * @author ����
 * @see clothObject
 */
class shoes extends clothObject{
	shoes(String wt, int th, int[] st, int[] bd,Image img, String link) {
		super(wt, th, st, bd,img, link);
	}
};