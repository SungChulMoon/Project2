package InnerClass;
/**
 * ������ ���� ������ ������ ��ü�� ���� Ŭ����
 * @author Moon light
 *
 */
public class UserObject {
	/**���� ���̵�*/
	String id;
	/**���� ��й�ȣ*/
	String pass;
	/**���� �̸�*/
	String name;
	/**���� ����*/
	String location;
	/**���� ����*/
	String gender;
	/**���� ü��*/
	String body;
	/**���� ��Ÿ��*/
	String sty_str;
	/**���� ��Ÿ�� ��*/
	String sty_size;
	/**���� ��ü�� ������
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
