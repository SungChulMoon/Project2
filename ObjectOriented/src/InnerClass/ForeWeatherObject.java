package InnerClass;
/**
 * 예측 날씨를 저장할 객체를 만들 클래스
 * @author Moon light
 *
 */
public class ForeWeatherObject {
	/** 예측 시간 날씨*/
	String main;
	/** 예측 하루 온도*/
	String temp;
	/** 예측 하루 시간*/
	String array0;
	/** 예측 하루 최고 온도*/
	double max;
	/** 예측 하루 최저 온도*/
	double min;

	/** 예측 날씨 객체 생성자
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
	/** 예측 시간 날씨 얻는 메소드*/
	public String getMain() {
		return main;
	}
	/** 예측 하루 온도 얻는 메소드*/
	public String getTemp() {
		return temp;
	}
	/** 예측 하루 시간 얻는 메소드*/
	public String getArray0() {
		return array0;
	}
	/** 예측하루 최고 온도 얻는 메소드*/
	public double getMax() {
		return max;
	}
	/** 예측하루 최저 온도 얻는 메소드*/
	public double getMin() {
		return min;
	}

}
