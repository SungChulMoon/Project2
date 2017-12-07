package InnerClass;
/**
 * 유저에 대한 정보를 가지는 객체를 만들 클래스
 * @author Moon light
 *
 */
public class UserObject {
	/**유저 아이디*/
	String id;
	/**유저 비밀번호*/
	String pass;
	/**유저 이름*/
	String name;
	/**유저 지역*/
	String location;
	/**유저 성별*/
	String gender;
	/**유저 체형*/
	String body;
	/**유저 스타일*/
	String sty_str;
	/**유저 스타일 수*/
	String sty_size;
	/**유저 객체의 생성자
	 * @param id
	 * @param pass
	 * @param name
	 * @param location
	 * @param gender
	 * @param body
	 * @param sty_str
	 * @param sty_size
	 * 
	 * */
	public UserObject(String id, String pass, String name,String location, String gender, String body, String sty_str, String sty_size) {
		super();
		this.location =location;
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.gender = gender;
		this.body = body;
		this.sty_str = sty_str;
		this.sty_size = sty_size;
	}
	public String getLocation() {
		return location;
	}
	public String getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getBody() {
		return body;
	}
	public String getSty_str() {
		return sty_str;
	}
	public String getSty_size() {
		return sty_size;
	}
}
