package InnerClass;
/**
 * 현재 날씨를 저장할 객체를 만들 클래스
 * @author Moon light
 *
 */
public class NowWeatherObject {
	String main;
	String temp;
	String array0;
	double max;
	double min;

	public NowWeatherObject(String main, String temp, String array0, double max, double min) {
		super();
		this.main = main;
		this.temp = temp;
		this.array0 = array0;
		this.max = max;
		this.min = min;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getArray0() {
		return array0;
	}

	public void setArray0(String array0) {
		this.array0 = array0;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

}
