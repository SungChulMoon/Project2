package InnerClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * DB에 정보를 넣거나 빼오는 역할을 하는 클래스
 * 
 * @author Moon light
 * 
 */
public class DBmethod {
	/**DB와의 연결을 하는 길과 같은 연결을 하는 conn*/
	static Connection conn;
	/**Sqlite와 연결이 필요한 이름과 connection을하는 DB를 지정하는 메소드*/
	public static void getInfo() throws Exception {
	
		if (conn == null) {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:resource/Data.db");
			System.out.println("sqlite 사용");
		}

	}
	/**파싱되고 정제된 현재 날씨가 저장된 현재날씨, 현재 온도, 현재 최고온도, 현재 최저온도를 테이블에서 불러오는 메소드*/
	public static nowWeather getNowweatherParsed() throws Exception {
		getInfo();
		ArrayList<nowWeather> nowlist = new ArrayList<>();
		PreparedStatement pst = conn.prepareStatement("select * from nowweatherparsed");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			nowlist.add(new nowWeather(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5)));

		}
		return nowlist.get(nowlist.size() - 1);
	}
	/**파싱한 날씨를 정제하여 nowweatherparsed라는 테이블에 각각 저장하는 메소드
	 * @param getTemp 현재 온도
	 * @param getMaxtemp 현재 최고온도
	 * @param getMaxtemp 현재 최저온도
	 * @param getMaxtemp 현재 날씨
	 * */
	public static int addParseredWeather(String getTemp, String getMaxtemp, String getMintemp, String getmain,
			String getLocation) throws Exception {
		getInfo();
		PreparedStatement pst = conn.prepareStatement("insert into nowweatherparsed values(?,?,?,?,?)");
		pst.setString(1, getTemp);
		pst.setString(2, getMaxtemp);
		pst.setString(3, getMintemp);
		pst.setString(4, getmain);
		pst.setString(5, getLocation);
		int cnt = pst.executeUpdate();
		return cnt;
	}
	/**userinfo라는 테이블 내에서 로그인시 매칭하는 아이디를 불러오는 메소드*/
	public static ArrayList<String> getUserId() throws Exception {
		getInfo();
		ArrayList<String> id = new ArrayList<>();
		PreparedStatement pst = conn.prepareStatement("select * from userinfo");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			id.add(rs.getString(1));
		}
		return id;
	}
	/**userinfo라는 테이블 내에서 로그인시 매칭하는 패스워드를 불러오는 메소드*/
	public static ArrayList<String> getUserPass() throws Exception {
		getInfo();
		ArrayList<String> id = new ArrayList<>();
		PreparedStatement pst = conn.prepareStatement("select * from userinfo");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			id.add(rs.getString(2));
		}
		return id;
	}
	/**회원가입시 사용자의 정보를 얻어와 userinfo 테이블에 저장하는 메소드 
	 * @param id 사용자의 아이디
	 * @param password 사용자의 패스워드
	 * @param name 사용자의 이름
	 * @param location 사용자의 위치
	 * @param gender 사용자의 성별
	 * @param body 사용자의 체형
	 * @param style_str 사용자가 선택한 스타일 모음
	 * @param style_size 사용자가 선택한 스타일의 갯수
	 * */
	public static int addUserInfo(String id, String password, String name, String location, String gender, String body,
			String style_str, String style_size) throws Exception {
		getInfo();
		PreparedStatement pst = conn.prepareStatement("insert into userinfo values(?,?,?,?,?,?,?,?)");
		pst.setString(1, id);
		pst.setString(2, password);
		pst.setString(3, name);
		pst.setString(4, location);
		pst.setString(5, gender);
		pst.setString(6, body);
		pst.setString(7, style_str);
		pst.setString(8, style_size);
		int cnt = pst.executeUpdate();
		return cnt;
	}
	/**Main프레임에서 사용할 사용자의 정보를 얻어오는 메소드 
	 * @param id 사용자의 아이디
	 * */
	public static UserObject getUserinfo(String id) throws Exception {
		getInfo();
		UserObject us = null;
		PreparedStatement pst = conn.prepareStatement("select * from userinfo");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			if (id.equals(rs.getString(1))) {
				us = new UserObject(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			}
		}
		return us;
	}
	/**현재 저장된 팁을 확인하기 위한 메소드
	 * */
	public static ArrayList<tipObject> checktip() throws Exception {
		getInfo();
		ArrayList<tipObject> arr = new ArrayList<>();
		PreparedStatement pst = conn.prepareStatement("select * from livingtip");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String weather = rs.getString(1);
			String tip = rs.getString(2);
			String link = rs.getString(3);
			arr.add(new tipObject(tip, link));
		}
		return arr;
	}
	/**관리자 페이지에서 날씨에 따른 팁과 링크를 추가하는 메소드 
	 * @param weather 선택한 날씨
	 * @param tip 추가할 팁
	 * @param tiplink 추가한 팁의 링크
	 * */
	public static int addtip(String weather, String tip, String tiplink) throws Exception {
		getInfo();
		PreparedStatement pst = conn.prepareStatement("insert into livingtip values(?,?,?)");

		pst.setString(1, weather);
		pst.setString(2, tip);
		pst.setString(3, tiplink);
		int cnt = pst.executeUpdate();
		return cnt;
	}
	/**Main 프레임에서 사용할 팁을 날씨에 맞게 불러오기 위한 메소드 
	 * @param weather 현재 날씨를 불러온다.
	 * */
	public static ArrayList<tipObject> selecttip(String weather) throws Exception {
		getInfo();
		ArrayList<tipObject> arr = new ArrayList<>();
		PreparedStatement pst = conn.prepareStatement("select * from livingtip where weather=?");
		pst.setString(1, weather);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String tip = rs.getString(2);
			String link = rs.getString(3);
			arr.add(new tipObject(tip, link));
			System.out.println("in db"+tip);
		}
		return arr;
	}


}
