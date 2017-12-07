package InnerClass;
/**
 * �ڵ� ���� �����͸� �����ͺ��̽��� �߰��ϱ����� �ڵ� ��ü
 * @author SungChulMoon
 * 
 */
public class CodiOb {
	/**�߰��� �ڵ��� �̹����� �̸�	*/
	String filename;
	/**�߰��� �ڵ��� �̹����� ���� ���	*/
	String filepath;
	/**�߰��� �ڵ��� ���� */
	String season;
	/**�߰��� �ڵ��� ���� �β�	*/
	String thick;
	/**�߰��� �ڵ��� �̹����� ����*/
	String gender;
	/**�߰��� �ڵ��� �̹����� ��ũ*/
	String link;
	/**�߰��� �ڵ��� �̹����� ���� ����*/
	String type;
	/**�߰��� �ڵ��� ù ��Ÿ���� ����ġ*/
	String style1;
	/**�߰��� �ڵ��� �� �� ° ��Ÿ���� ����ġ*/
	String style2;
	/**�߰��� �ڵ��� �� �� ° ��Ÿ���� ����ġ*/
	String style3;
	/**�߰��� �ڵ��� �� �� ° ��Ÿ���� ����ġ*/
	String style4;
	/**�߰��� �ڵ��� ù ü���� ����ġ*/
	String body1;
	/**�߰��� �ڵ��� �� ��° ��Ÿ���� ����ġ*/
	String body2;
	/**�߰��� �ڵ��� �� ��° ��Ÿ���� ����ġ*/
	String body3;
	/**�߰��� �ڵ��� �� ��° ��Ÿ���� ����ġ*/
	String body4;
	/**�ڵ� ��ü�� ������
	 * @param filename
	 * @param filepath
	 * @param season
	 * @param thick
	 * @param gender
	 * @param link
	 * @param type
	 * @param style1
	 * @param style2
	 * @param style3
	 * @param style4
	 * @param body1
	 * @param body2
	 * @param body3
	 * @param body4
	 * 
	 * */
	public CodiOb(String filename, String filepath, String season, String thick, String gender, String link,
			String type, String style1, String style2, String style3, String style4, String body1, String body2,
			String body3, String body4) {
		super();
		this.filename = filename;
		this.filepath = filepath;
		this.season = season;
		this.thick = thick;
		this.gender = gender;
		this.link = link;
		this.type = type;
		this.style1 = style1;
		this.style2 = style2;
		this.style3 = style3;
		this.style4 = style4;
		this.body1 = body1;
		this.body2 = body2;
		this.body3 = body3;
		this.body4 = body4;
	}
	/**���ϸ��� ��� �� ��� ���� �޼ҵ�*/
	public String getFilename() {
		return filename;
	}
	/**���� ��θ� ��� �� ��� ���� �޼ҵ�*/
	public String getFilepath() {
		return filepath;
	}
	/**������ ������ ��� �� ��� ���� �޼ҵ�*/
	public String getSeason() {
		return season;
	}
	/**�β����� ��� �� ��� ���� �޼ҵ�*/
	public String getThick() {
		return thick;
	}
	/**������ ��� �� ��� ���� �޼ҵ�*/
	public String getGender() {
		return gender;
	}
	/**��ũ�� ��� �� ��� ���� �޼ҵ�*/
	public String getLink() {
		return link;
	}
	/**���� Ÿ���� ��� �� ��� ���� �޼ҵ�*/
	public String getType() {
		return type;
	}
	/**ù ��Ÿ���� ����ġ�� ��� �� ��� ���� �޼ҵ�*/
	public String getStyle1() {
		return style1;
	}
	/**�� ��° ��Ÿ���� ����ġ�� ��� �� ��� ���� �޼ҵ�*/
	public String getStyle2() {
		return style2;
	}
	/**�� ��° ��Ÿ���� ����ġ�� ��� �� ��� ���� �޼ҵ�*/
	public String getStyle3() {
		return style3;
	}
	/**�� ��° ��Ÿ���� ����ġ�� ��� �� ��� ���� �޼ҵ�*/
	public String getStyle4() {
		return style4;
	}
	/**ù ü���� ����ġ�� ��� �� ��� ���� �޼ҵ�*/
	public String getBody1() {
		return body1;
	}
	/**�� ��° ü���� ����ġ�� ��� �� ��� ���� �޼ҵ�*/
	public String getBody2() {
		return body2;
	}
	/**�� ��° ü���� ����ġ�� ��� �� ��� ���� �޼ҵ�*/
	public String getBody3() {
		return body3;
	}
	/**�� ��° ü���� ����ġ�� ��� �� ��� ���� �޼ҵ�*/
	public String getBody4() {
		return body4;
	}
}
