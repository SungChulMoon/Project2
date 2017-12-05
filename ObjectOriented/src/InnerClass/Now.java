
package InnerClass;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * 현재 날씨를 읽어온것을 Json타입에서 String타입으로 변경해주는 클래스
 * @author Moon light
 *
 */
public class Now {
	/** 로그인하거나 새로운 지역을 검색할 때 현재 날씨를 
	 * */
	public static void addParsingNowWeather() {
		Location sl = new Location();
		try {
			String temp;
			String temp_max;
			String temp_min;
			String getWeather = null;
			String str = sl.getResult();
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(str);

			JSONObject order = (JSONObject) obj;

			// Object obj2 = order.get("main");
			String getlocation = (String) order.get("name");
			System.out.println(getlocation);// 성공
			// JSONObject main2 = (JSONObject)obj;

			JSONObject main2 = (JSONObject) order.get("main");

			String absoltemp = String.valueOf(main2.get("temp"));
			System.out.println(absoltemp);
			String absoltemp_max = String.valueOf(main2.get("temp_max"));

			String absoltemp_min = String.valueOf(main2.get("temp_min"));
			String gethum = String.valueOf(main2.get("humidity"));

			int temp2 = (int) (Double.parseDouble(absoltemp) - 273.15);
			int temp_max2 = (int) (Double.parseDouble(absoltemp_max) - 273.15);
			int temp_min2 = (int) (Double.parseDouble(absoltemp_min) - 273.15);
			temp = String.valueOf(temp2);
			System.out.println(temp);
			temp_max = String.valueOf(temp_max2);
			System.out.println(temp_max2);
			temp_min = String.valueOf(temp_min2);
			System.out.println(temp_min2);

			Object obj3 = order.get("weather");

			JSONArray weather1 = (JSONArray) obj3;

			JSONObject weatherarr1 = (JSONObject) (weather1).get(0);
			getWeather = (String) (weatherarr1).get("main");

			System.out.println(getWeather);
			
			if(DBmethod.addParseredWeather(temp, temp_max, temp_max, getWeather,getlocation)>0) {
				System.out.println("파싱된 현재 날씨 정보를 저장 하였습니다.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
