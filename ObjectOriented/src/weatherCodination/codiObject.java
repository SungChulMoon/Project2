package weatherCodination;

import weatherCodination.*;
import java.util.Random;

/**
 * �ϼ��� �ڵ� ��ü
 * 
 * @author ����
 * @see clothObject
 */
public class codiObject {
	/**���� ���� �����ϱ� ���� ���� ��ü*/
	Random random=new Random();
	
	/**
	 * �ڵ� �Ϸ�� outer��ü
	 * */
	outer codiOuter;
	/**�ڵ� �Ϸ�� top��ü
	 * */
	top codiTop;
	
	/**�ڵ� �Ϸ�� pants��ü*/
	pants codiPants;
	/**�ڵ� �Ϸ�� shoes��ü*/
	shoes codiShoes;
	
	
	/**
	 * �ϼ��ڵ� ��ü�� �����ϱ� ���� ������
	 * �������� �켱 ���� ��Ʈ�������� ���� �����ؼ� �ڵ� �ϼ��Ѵ�.
	 * */
	codiObject(matchCloth match) {
		codiOuter=initialFileCloth.clo_outer.get(match.priorityMatrix[0][random.nextInt(3)]);
		codiTop=initialFileCloth.clo_top.get(match.priorityMatrix[1][random.nextInt(3)]);
		codiPants=initialFileCloth.clo_pants.get(match.priorityMatrix[2][random.nextInt(3)]);
		codiShoes=initialFileCloth.clo_shoes.get(match.priorityMatrix[3][random.nextInt(3)]);

	}
}
