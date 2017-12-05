package weatherCodination;

import java.util.*;

enum tempState {WARM_4,WARM_3,WARM_2,WARM_1,COLD_1,COLD_2,COLD_3,COLD_4} 

/**
 * 날씨에서 얻은 데이터로 옷을 매칭하는 클래스
 * 
 * @author 지우
 *
 */
public class matchCloth {		
	/**기온에 따라 나눈 상태를 저장하는 변수*/
	tempState tempST;
	/**우선순위를 정하기 위해 두께감에 두는 가중치*/
	static int thick_weight;
	/**우선순위를 정하기 위해 스타일에 두는 가중치*/
	static int style_weight;
	/**옷마다 가중치에 따라 계산된 결과를 저장할 옷 매트릭스*/
	public static int[][] clothMatrix=new int [4][];
	/**옷 매트릭스를 통해서 나온 값을 통해 우선순위 1~3까지 저장한 우선순위 매트릭스*/
	public static int[][] priorityMatrix=new int[4][3];
	/**DB를 통해 들어온 스타일 String을 저장할 String 배열*/
	String[] styleArray;
	/**DB를 통해 들어온 체형의 가중치를 담고 있을  int 변수*/
	int bd;
	
	
	/**옷 매칭 클래스를 생성하는 생성자
	 * 
	 * @param temp 현재 기온
	 * @param styleSt String값으로 들어오는 style 문자열
	 * @param sizeSt 선택한 style갯수 문자열
	 * */
	matchCloth(int temp, String styleSt, String sizeSt, String body) {
		parameterTranslate(styleSt, sizeSt, body);
		weightAssignment(temp);
		produceClothMatrix();
		priorityMatrix();
	}
	
	/**
	 * DB를 통해 들어온 매개변수를 쓰기 편하게 변형하는 함수 
	 * @param styleSt DB를 통해서 들어오는 style 문자열
	 * @param sizeSt DB를 통해서 들어오는 선택한 style 갯수 문자열
	 */
	public void parameterTranslate(String styleSt, String sizeSt, String body){
		int size=Integer.parseInt(sizeSt);
		
		styleArray=new String [size];
		StringTokenizer tokens = new StringTokenizer(styleSt);
		
		for(int i=0; i<size; i++) {
			styleArray[i]=tokens.nextToken(",");
		}
		
		if(body.contains("1")) {
			bd=0;
		}else if(body.contains("2")) {
			bd=1;
		}else if(body.contains("3")) {
			bd=2;
		}else {
			bd=3;
		}
	}
	
		/**
		 * 현재 온도에 따라  상태를 나눈 후 가중치를 부여하는 함수
		 * @param temp 현재 온도
		 */
	public void weightAssignment(int temp) {	
		if(temp>27) tempST= tempState.WARM_4;
		else if(temp<=27 && temp>23) tempST= tempState.WARM_3;
		else if(temp<=23 && temp>20) tempST= tempState.WARM_2;
		else if(temp<=20 && temp>15) tempST= tempState.WARM_1;
		else if(temp<=15 && temp>12) tempST= tempState.COLD_1;
		else if(temp<=12 && temp>10) tempST= tempState.COLD_2;
		else if(temp<=12 && temp>6) tempST= tempState.COLD_3;
		else  tempST= tempState.COLD_4;
		
		switch(tempST) {
		case WARM_4:
			thick_weight=80;
			break;
		case WARM_3:
			thick_weight=60;
			break;
		case WARM_2:
			thick_weight=40;
			break;
		case WARM_1:
			thick_weight=20;
			break;
		case COLD_1:
			thick_weight=20;
			break;
		case COLD_2:
			thick_weight=40;
			break;
		case COLD_3:
			thick_weight=60;
			break;
		case COLD_4:
			thick_weight=80;
			break;
		}
		
		style_weight=100-thick_weight;
	}
	/**
	 * 가중치에 따라 값을 계산한 값을 갖는 옷 매트릭스
	 */
	private void produceClothMatrix() {
		int cnt=0;
		int style;
		int n;
		
		clothMatrix[0]=new int[initialCloth.clo_outer.size()];
		clothMatrix[1]=new int[initialCloth.clo_top.size()];
		clothMatrix[2]=new int[initialCloth.clo_pants.size()];
		clothMatrix[3]=new int[initialCloth.clo_shoes.size()];
		
		
		Random random=new Random();
		n=random.nextInt(styleArray.length);
		
		if(styleArray[n].equals("시크")) {
			style=0;
		}else if(styleArray[n].equals("큐티")){
			style=1;
		}else if(styleArray[n].equals("섹시") || styleArray[n].equals("댄디")){
			style=2;
		}else	style=3;
		

	
		for(int i=0; i<initialCloth.clo_outer.size(); i++) {
			int score=0;
			
			if((tempST==tempState.WARM_4 || tempST==tempState.WARM_3||tempST==tempState.WARM_2||tempST==tempState.WARM_1)
					&& initialCloth.clo_outer.get(i).weather==1) score+=100;
			else if((tempST==tempState.COLD_1 || tempST==tempState.COLD_2||tempST==tempState.COLD_3||tempST==tempState.COLD_4)
					&& initialCloth.clo_outer.get(i).weather==2) score+=100;
			else score-=100;
			
			score+=(initialCloth.clo_outer.get(i).body[bd]*10);
			
			score+=(int)(initialCloth.clo_outer.get(i).thick*matchCloth.thick_weight+initialCloth.clo_outer.get(i).style[style]*matchCloth.style_weight)/10;
			clothMatrix[0][i]=score;
		}
		
		for(int i=0; i<initialCloth.clo_top.size(); i++) {
			int score=0;
			
			if((tempST==tempState.WARM_4 || tempST==tempState.WARM_3||tempST==tempState.WARM_2||tempST==tempState.WARM_1)
					&& initialCloth.clo_top.get(i).weather==1) score+=100;
			else if((tempST==tempState.COLD_1 || tempST==tempState.COLD_2||tempST==tempState.COLD_3||tempST==tempState.COLD_4) 
					&& initialCloth.clo_top.get(i).weather==2) score+=100;
			else score-=100;
			
			score+=(initialCloth.clo_top.get(i).body[bd]*10);
			
			score+=(int)(initialCloth.clo_top.get(i).thick*matchCloth.thick_weight+initialCloth.clo_top.get(i).style[style]*matchCloth.style_weight)/10;
			clothMatrix[1][i]=score;
		}
		
		for(int i=0; i<initialCloth.clo_pants.size(); i++) {
			int score=0;
			
			if((tempST==tempState.WARM_4 || tempST==tempState.WARM_3||tempST==tempState.WARM_2||tempST==tempState.WARM_1) 
					&& initialCloth.clo_pants.get(i).weather==1) score+=100;
			else if((tempST==tempState.COLD_1 || tempST==tempState.COLD_2||tempST==tempState.COLD_3||tempST==tempState.COLD_4) 
					&& initialCloth.clo_pants.get(i).weather==2) score+=100;
			else score-=100;
			
			score+=(initialCloth.clo_pants.get(i).body[bd]*10);
			
			score+=(int)(initialCloth.clo_pants.get(i).thick*matchCloth.thick_weight+initialCloth.clo_pants.get(i).style[style]*matchCloth.style_weight)/10;
			clothMatrix[2][i]=score;
		}
		for(int i=0; i<initialCloth.clo_shoes.size(); i++) {
			int score=0;
			
			if((tempST==tempState.WARM_4 || tempST==tempState.WARM_3||tempST==tempState.WARM_2||tempST==tempState.WARM_1)
					&& initialCloth.clo_shoes.get(i).weather==1) score+=100;
			else if((tempST==tempState.COLD_1 || tempST==tempState.COLD_2||tempST==tempState.COLD_3||tempST==tempState.COLD_4)
					&& initialCloth.clo_shoes.get(i).weather==2) score+=100;
			else score-=100;
			
			score+=(initialCloth.clo_shoes.get(i).body[bd]*10);
			
			score+=(int)(initialCloth.clo_shoes.get(i).thick*matchCloth.thick_weight+initialCloth.clo_shoes.get(i).style[style]*matchCloth.style_weight)/10;
			clothMatrix[3][i]=score;
		}
	}
	/**
	 * 우선순위 매트릭스를 만드는 클래스
	 * 
	 * @param n 옷마다의 행
	 */
	private void producePriorityMatrix(int n) {
		priorityMatrix[n][0]=0;
		
		for(int i=1; i<clothMatrix[n].length; i++) {
			if(clothMatrix[n][priorityMatrix[n][0]]<=clothMatrix[n][i]) {
				for(int j=1; j<3; j++) {
					priorityMatrix[n][3-j]=priorityMatrix[n][3-j-1];
				}
				priorityMatrix[n][0]=i;
			}else if(clothMatrix[n][priorityMatrix[n][1]]<=clothMatrix[n][i] && clothMatrix[n][priorityMatrix[n][2]]>clothMatrix[n][i]) {
				priorityMatrix[n][2]=priorityMatrix[n][1];
				priorityMatrix[n][1]=i;
			}else if(clothMatrix[n][priorityMatrix[n][2]]<=clothMatrix[n][i]) {
				priorityMatrix[n][2]=i;
			}
		}
	}
	/**
	 * 우선순위 매트릭스를 초기화 하고, 우선순위 매트릭스를 생성하는 함수를 호출하는 함수
	 */
	private void priorityMatrix() {	
		for(int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				priorityMatrix[i][j]=0;
			}
		}
			
		producePriorityMatrix(0);
		producePriorityMatrix(1);
		producePriorityMatrix(2);
		producePriorityMatrix(3);	
	
	}
	
}
