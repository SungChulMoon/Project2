package InnerClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * DB�� ������ �ְų� ������ ������ �ϴ� Ŭ����
 * 
 * @author Moon light
 * 
 */
public class DBmethod {
	/**DB���� ������ �ϴ� ��� ���� ������ �ϴ� conn*/
	static Connection conn;
	/**Sqlite�� ������ �ʿ��� �̸��� connection���ϴ� DB�� �����ϴ� �޼ҵ�*/
	public static void getInfo() throws Exception {
	
		if (conn == null) {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:resource/Data.db");
			System.out.println("sqlite ���");
		}

	}
	/**�Ľ̵ǰ� ������ ���� ������ ����� ���糯��, ���� �µ�, ���� �ְ�µ�, ���� �����µ��� ���̺��� �ҷ����� �޼ҵ�*/
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
	/**�Ľ��� ������ �����Ͽ� nowweatherparsed��� ���̺� ���� �����ϴ� �޼ҵ�
	 * @param getTemp ���� �µ�
	 * @param getMaxtemp ���� �ְ�µ�
	 * @param getMaxtemp ���� �����µ�
	 * @param getMaxtemp ���� ����
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
	/**userinfo��� ���̺� ������ �α��ν� ��Ī�ϴ� ���̵� �ҷ����� �޼ҵ�*/
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
	/**userinfo��� ���̺� ������ �α��ν� ��Ī�ϴ� �н����带 �ҷ����� �޼ҵ�*/
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
	/**ȸ�����Խ� ������� ������ ���� userinfo ���̺� �����ϴ� �޼ҵ� 
	 * @param id ������� ���̵�
	 * @param password ������� �н�����
	 * @param name ������� �̸�
	 * @param location ������� ��ġ
	 * @param gender ������� ����
	 * @param body ������� ü��
	 * @param style_str ����ڰ� ������ ��Ÿ�� ����
	 * @param style_size ����ڰ� ������ ��Ÿ���� ����
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
	/**Main�����ӿ��� ����� ������� ������ ������ �޼ҵ� 
	 * @param id ������� ���̵�
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
	/**���� ����� ���� Ȯ���ϱ� ���� �޼ҵ�
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
	/**������ ���������� ������ ���� ���� ��ũ�� �߰��ϴ� �޼ҵ� 
	 * @param weather ������ ����
	 * @param tip �߰��� ��
	 * @param tiplink �߰��� ���� ��ũ
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
	/**Main �����ӿ��� ����� ���� ������ �°� �ҷ����� ���� �޼ҵ� 
	 * @param weather ���� ������ �ҷ��´�.
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
	public static int insertcodi(CodiOb co)throws Exception {
		getInfo();
		PreparedStatement pst = conn.prepareStatement("insert into codi values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1, co.getFilename());
		pst.setString(2, co.getFilepath());
		pst.setString(3, co.getSeason());
		pst.setString(4, co.getThick());
		pst.setString(5, co.getGender());
		pst.setString(6, co.getLink());
		pst.setString(7, co.getType());
		pst.setString(8, co.getStyle1());
		pst.setString(9, co.getStyle2());
		pst.setString(10, co.getStyle3());
		pst.setString(11, co.getStyle4());
		pst.setString(12, co.getBody1());
		pst.setString(13, co.getBody2());
		pst.setString(14, co.getBody3());
		pst.setString(15, co.getBody4());
		int cnt = pst.executeUpdate();
		return cnt;
	}
	
	public static ArrayList<CodiOb> selectCodi(String gender)throws Exception{
		getInfo();
		ArrayList<CodiOb> coarr =new ArrayList<>();
		PreparedStatement pst = conn.prepareStatement("select * from codi where gender=?");
		pst.setString(1, gender);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			coarr.add(new CodiOb(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
					rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),rs.getString(15)));
		}
		return coarr;
	}


}
