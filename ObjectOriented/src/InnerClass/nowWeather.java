package InnerClass;
/**
 * 현재 날씨를 객체화 하기위한 클래스
 * @author Moon light
 *
 */
public class nowWeather {
	String temp;
	String Maxtemp;
	String Mintemp;
	String main;
	String location;
	public nowWeather(String temp, String maxtemp, String mintemp, String main, String location) {
		super();
		this.temp = temp;
		Maxtemp = maxtemp;
		Mintemp = mintemp;
		this.main = main;
		this.location = location;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getMaxtemp() {
		return Maxtemp;
	}
	public void setMaxtemp(String maxtemp) {
		Maxtemp = maxtemp;
	}
	public String getMintemp() {
		return Mintemp;
	}
	public void setMintemp(String mintemp) {
		Mintemp = mintemp;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
