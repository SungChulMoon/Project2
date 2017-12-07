package InnerClass;
/**
 * ���� ������ ��üȭ �ϱ����� Ŭ����
 * @author SungChul Moon
 *
 */
public class NowWeatherObject {
	/**���� �µ� ���ڿ�*/
	String temp;
	/**���� �ְ� �µ� ���ڿ�*/
	String Maxtemp;
	/**���� ���� �µ� ���ڿ�*/
	String Mintemp;
	/**���� ���� �µ� ���ڿ�*/
	String main;
	/**���� ���� �µ� ���ڿ�*/
	String location;
	/**
	 * ���糯���� ��ü ������
	 * @param temp
	 * @param maxtemp
	 * @param mintemp
	 * @param main
	 * @param location
	 * 
	 * */
	public NowWeatherObject(String temp, String maxtemp, String mintemp, String main, String location) {
		super();
		this.temp = temp;
		Maxtemp = maxtemp;
		Mintemp = mintemp;
		this.main = main;
		this.location = location;
	}
	/** ���� �µ��� �޾ƿ��� �޼ҵ�*/
	public String getTemp() {
		return temp;
	}
	/** ���� �ְ� �µ��� �޾ƿ��� �޼ҵ�*/
	public String getMaxtemp() {
		return Maxtemp;
	}
	/** ���� ���� �µ��� �޾ƿ��� �޼ҵ�*/
	public String getMintemp() {
		return Mintemp;
	}
	/** ���� ���� �µ��� �޾ƿ��� �޼ҵ�*/
	public String getMain() {
		return main;
	}
	/** ���� ���� �µ��� �޾ƿ��� �޼ҵ�*/
	public String getLocation() {
		return location;
	}
	
}
