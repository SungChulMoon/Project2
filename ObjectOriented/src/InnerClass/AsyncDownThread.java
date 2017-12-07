package InnerClass;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.logging.Handler;

/**
 * Thread를 통하여 현재날씨를 가지고 있는 Json값을 읽어 오기 위한 클래스
 * @author SungChulMoon
 * @see Thread
 */

public class AsyncDownThread extends Thread {

	private String addr;
	/** Thread를 멈추고 Synchronized 메소드를 호출하기 위한 Location 객체 호출
	 */
	Location sl = new Location();
	/**
	 * 스레드 생성자를 통해서 주소값을 받아들이는 생성자
	 * @param addr 스레드 생성자 생성시 받아오는 html주소 값 
	 */

	public AsyncDownThread(String addr) {
		this.addr = addr;

	}
	/**
	 * Thread를 돌린 결과값을 syncronize 한다.
	 */
	public void run() {
		String result = downloadHtml(addr);
		try {
	
			sl.setfromThread(result);
			
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
