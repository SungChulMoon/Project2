package InnerClass;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.logging.Handler;
/**
 * Thread를 통하여 5일간의 예상 날씨를 가지고 있는 Json값을 읽어 오기 위한 클래스
 * @author SungChulMoon
 * @see Thread
 */

public class AsyncDownThread2 extends Thread {

	private String addr;
	Location sl = new Location();
	/**
	 * 스레드 생성자를 통해서 주소값을 받아들이는 생성자
	 * @param addr 스레드 생성자 생성시 받아오는 html주소 값 
	 */

	public AsyncDownThread2(String addr) {
		this.addr = addr;

	}
	/**
	 * 스레드를 돌릴때 실행되는 메소드로 downloadHtml 메소드를 사용하여 html의 결과값을 받아 들인다
	 *
	 */
	public void run() {
		String result = downloadHtml(addr);
		try {
		//	if(DBmethod.foreWeather(result)>0) {
			//	System.out.println("예측:"+result);
			//}
			sl.setfromThread2(result);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 주소값을 읽어 들어와 html과 connection한 후 html내의 작성된 값을 String으로 변경하여 리턴한다.
	 * @param addr 스레드 생성자 생성시 받아오는 html주소 값 
	 */
	private String downloadHtml(String addr) {
		StringBuilder html = new StringBuilder();
		try {
			URL url = new URL(addr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(10000);
				// 10초 동안 url가 연결이 안되면 끊어 버려라
				conn.setUseCaches(false);
				// 캐쉬 삭제
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					// 버퍼 사용해서 속도 상승
					BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					while (true) {
						String line = br.readLine();
						if (line == null)
							break;//문장이 없으면 끝내라
						html.append(line+"\n");
						
					}
					br.close();
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return html.toString();
	}
}
