package weatherCodination;

import java.awt.Image;


/** 
 * 코디에 필요한 옷 클래스
 * 이 클래스는 코디에 필요한 옷 객체를 생성한다.
 * 
 * @author 지우
 * 
 */

public class clothObject {
	/**계절감을 나타내는 int 변수*/
	int weather;
	/**두께감을 나타내는 int 변수*/
	int thick;
	/**스타일을 나타내는 int배열 변수*/
	int[] style=new int [4];
	/**스타일을 나타내는 int배열 변수*/
	int[] body=new int [4];
	/**옷의 이미지를 나타내는 Image 변수*/
	Image image;
	/**쇼핑몰 링크를 나타내는 String 변수*/
	String link;
	
	/**
	 * 옷 객체의 생성자
	 * 
	 * @param wt 옷의 계절감
	 * @param th 옷의 두께감
	 * @param st 옷의 스타일 배열
	 * @param img 옷 이미지
	 * @param lk 쇼핑몰 링크
	 */
	clothObject(int wt,int th, int[] st, int[] bd, Image img, String lk) {
		weather=wt;
		thick=th;
		for(int i=0; i<4; i++) style[i]=st[i];
		for(int i=0; i<4; i++) bd[i]=bd[i];

		image=img;
		link=lk;
	}
}


/**
 * 겉옷의 정보를 담는 outer클래스.
 * 
 * @author 지우
 * @see clothObject
 */
class outer extends clothObject{
	
	outer(int wt,int th, int[] st,int[] bd, Image img, String link) {
		super(wt, th, st, bd, img, link);
	}
};
/**
 * 상의의 정보를 담는 top클래스.
 * 
 * @author 지우
 * @see clothObject
 */
class top extends clothObject{
	top(int wt, int th, int[] st,int[] bd, Image img, String link) {
		super(wt, th, st, bd,img, link);
	}
};
/**
 * 하의의 정보를 담는 pants클래스.
 * 
 * @author 지우
 * @see clothObject
 */
class pants extends clothObject{
	pants(int wt, int th, int[] st,int[] bd, Image img, String link) {
		super(wt, th, st, bd,img, link);
	}
};
/**
 * 신발의 정보를 담는 shoes클래스.
 * 
 * @author 지우
 * @see clothObject
 */
class shoes extends clothObject{
	shoes(int wt, int th, int[] st, int[] bd,Image img, String link) {
		super(wt, th, st, bd,img, link);
	}
};