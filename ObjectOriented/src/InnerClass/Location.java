package InnerClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import javax.swing.SwingUtilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 읽어올 지역을 변경, 스레드를 실행시켜 정보를 얻어오고 스레드를  멈추기 위한 클래스
 * 
 * @author Moon light
 *
 */
public class Location {
	/**현재 날씨값을 돌릴 스레드 선언*/
	public static AsyncDownThread thread;
	/**예측할 5일 날씨의 스레드 선언*/
	public static AsyncDownThread2 thread2;
	/**현재 날씨 스레드에서 실행된 결과값을 받을 문자열*/
	static String now;
	/**예측 날씨 스레드에서 실행된 결과값을 받을 문자열*/
	static String fore;
	
	/**현재 날씨 스레드 결과 값을 얻어오는 메소드
	 * @param result 스레드의 결과값
	 * */
	public synchronized void setfromThread(String result) {
		now = result;
		System.out.println("syn에서 받아온 값"+now);
	}
	/**현재 날씨 스레드에서 넘어온 값이 null인지 체크하기 위한 메소드*/
	public String getResult() {
		if (now != null) {
			return now;
		} else {
			return "스레드값 얻지 못했습니다.";
		}
	}
	/**예측 날씨 스레드 결과 값을 얻어오는 메소드
	 * @param result
	 * */
	public synchronized void setfromThread2(String result) {
		fore = result;
		System.out.println("syn에서 받아온 예상값"+fore);
	}
	/**예측 날씨 스레드에서 넘어온 값이 null인지 체크하기 위한 메소드*/
	public String getResult2() {
		if(fore !=null) {
			return fore;
		}
		else
		{
			return "예상 스레드값을 얻지 못했습니다.";
		}
	}
	/**원하는 지역을 받아와 지역과 매칭하여 현재 날씨 스레드와 예측날씨 스레드를 시작시키는 메소드
	 * @param location 스레드의 결과값
	 * */
	public static void setlocal(String location) {
		String nowaddr = String.format(
				"http://api.openweathermap.org/data/2.5/weather?q=%s&appid=b2efbf057210a805e02a0f8787bc627a", location);
		thread = new AsyncDownThread(nowaddr);

		thread.start();

		String foreaddr = String.format(
				"http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=b2efbf057210a805e02a0f8787bc627a",
				location);
		thread2 = new AsyncDownThread2(foreaddr);
		thread2.start();

	}
	/**현재 실행중인 두 개의 스레드를 멈추기 위한 메소드*/
	public static void stopThread() {
		thread.interrupt();
		thread2.interrupt();
	}
	/**스레드의 결과값을 얻어오기 위해 스레드를 멈추기를 기다리는 메소드*/
	public static void joinThread() {
		try {
			thread.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
