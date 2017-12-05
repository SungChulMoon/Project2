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
 * �о�� ������ ����, �����带 �����Ű�� ���߱� ���� Ŭ����
 * 
 * @author Moon light
 *
 */
public class Location {
	public static AsyncDownThread thread;
	public static AsyncDownThread2 thread2;
	static String now;
	static String fore;
	
	public synchronized void setfromThread(String result) {
		now = result;
		System.out.println("syn���� �޾ƿ� ��"+now);
	}

	public String getResult() {
		if (now != null) {
			return now;
		} else {
			return "�����尪 ���� ���߽��ϴ�.";
		}
	}
	public synchronized void setfromThread2(String result) {
		fore = result;
		System.out.println("syn���� �޾ƿ� ����"+fore);
	}
	public String getResult2() {
		if(fore !=null) {
			return fore;
		}
		else
		{
			return "���� �����尪�� ���� ���߽��ϴ�.";
		}
	}
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

	public static void stopThread() {
		thread.interrupt();
		thread2.interrupt();
	}

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
