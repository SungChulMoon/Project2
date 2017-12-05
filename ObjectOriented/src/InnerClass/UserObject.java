package InnerClass;
/**
 * 유저에 대한 정보를 가지는 객체를 만들 클래스
 * @author Moon light
 *
 */
public class UserObject {
	String id;
	String pass;
	String name;
	String location;
	String gender;
	String body;
	String sty_str;
	String sty_size;
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
	public void setLocation(String location) {
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSty_str() {
		return sty_str;
	}
	public void setSty_str(String sty_str) {
		this.sty_str = sty_str;
	}
	public String getSty_size() {
		return sty_size;
	}
	public void setSty_size(String sty_size) {
		this.sty_size = sty_size;
	}
}
