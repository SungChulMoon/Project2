package weatherCodination;

import weatherCodination.*;
import java.util.Random;

/**
 * 완성된 코디 객체
 * 
 * @author 지우
 * @see clothObject
 */
public class codiObject {
	/**랜덤 수를 생성하기 위한 랜덤 객체*/
	Random random=new Random();
	
	/**
	 * 코디 완료된 outer객체
	 * */
	outer codiOuter;
	/**코디 완료된 top객체
	 * */
	top codiTop;
	
	/**코디 완료된 pants객체*/
	pants codiPants;
	/**코디 완료된 shoes객체*/
	shoes codiShoes;
	
	
	/**
	 * 완성코디 객체를 생성하기 위한 생성자
	 * 랜덤으로 우선 순위 매트릭스에서 값을 추출해서 코디를 완성한다.
	 * */
	codiObject(matchCloth match) {
		codiOuter=initialFileCloth.clo_outer.get(match.priorityMatrix[0][random.nextInt(3)]);
		codiTop=initialFileCloth.clo_top.get(match.priorityMatrix[1][random.nextInt(3)]);
		codiPants=initialFileCloth.clo_pants.get(match.priorityMatrix[2][random.nextInt(3)]);
		codiShoes=initialFileCloth.clo_shoes.get(match.priorityMatrix[3][random.nextInt(3)]);

	}
}
