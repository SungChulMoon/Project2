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
	codiObject() {
		System.out.println(random.nextInt(3));
		
		codiOuter=initialCloth.clo_outer.get(matchCloth.priorityMatrix[0][random.nextInt(3)]);
		codiTop=initialCloth.clo_top.get(matchCloth.priorityMatrix[1][random.nextInt(3)]);
		codiPants=initialCloth.clo_pants.get(matchCloth.priorityMatrix[2][random.nextInt(3)]);
		codiShoes=initialCloth.clo_shoes.get(matchCloth.priorityMatrix[3][random.nextInt(3)]);

	}
}
