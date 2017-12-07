package InnerClass;
/**
 * 현재 날씨를 객체화 하기위한 클래스
 * @author SungChul Moon
 *
 */
public class NowWeatherObject {
	/**현재 온도 문자열*/
	String temp;
	/**현재 최고 온도 문자열*/
	String Maxtemp;
	/**현재 최저 온도 문자열*/
	String Mintemp;
	/**현재 날씨 온도 문자열*/
	String main;
	/**현재 지역 온도 문자열*/
	String location;
	/**
	 * 현재날씨의 객체 생성자
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
	/** 현재 온도를 받아오는 메소드*/
	public String getTemp() {
		return temp;
	}
	/** 현재 최고 온도를 받아오는 메소드*/
	public String getMaxtemp() {
		return Maxtemp;
	}
	/** 현재 최저 온도를 받아오는 메소드*/
	public String getMintemp() {
		return Mintemp;
	}
	/** 현재 날씨 온도를 받아오는 메소드*/
	public String getMain() {
		return main;
	}
	/** 현재 지역 온도를 받아오는 메소드*/
	public String getLocation() {
		return location;
	}
	
}
