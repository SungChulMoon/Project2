package InnerClass;
/**
 * ���� ������ ������ ��ü�� ���� Ŭ����
 * @author Moon light
 *
 */
public class ForeWeatherObject {
	/** ���� �ð� ����*/
	String main;
	/** ���� �Ϸ� �µ�*/
	String temp;
	/** ���� �Ϸ� �ð�*/
	String array0;
	/** ���� �Ϸ� �ְ� �µ�*/
	double max;
	/** ���� �Ϸ� ���� �µ�*/
	double min;

	/** ���� ���� ��ü ������
	 * @param main
	 * @param temp
	 * @param array0
	 * @param max
	 * @param min
	 * 
	 * */
	public ForeWeatherObject(String main, String temp, String array0, double max, double min) {
		super();
		this.main = main;
		this.temp = temp;
		this.array0 = array0;
		this.max = max;
		this.min = min;
	}
	/** ���� �ð� ���� ��� �޼ҵ�*/
	public String getMain() {
		return main;
	}
	/** ���� �Ϸ� �µ� ��� �޼ҵ�*/
	public String getTemp() {
		return temp;
	}
	/** ���� �Ϸ� �ð� ��� �޼ҵ�*/
	public String getArray0() {
		return array0;
	}
	/** �����Ϸ� �ְ� �µ� ��� �޼ҵ�*/
	public double getMax() {
		return max;
	}
	/** �����Ϸ� ���� �µ� ��� �޼ҵ�*/
	public double getMin() {
		return min;
	}

}
