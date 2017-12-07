package InnerClass;
/**
 * 코디에 대한 데이터를 데이터베이스에 추가하기위한 코디 객체
 * @author SungChulMoon
 * 
 */
public class CodiOb {
	/**추가할 코디의 이미지의 이름	*/
	String filename;
	/**추가할 코디의 이미지의 저장 경로	*/
	String filepath;
	/**추가할 코디의 날씨 */
	String season;
	/**추가할 코디의 옷의 두께	*/
	String thick;
	/**추가할 코디의 이미지의 성별*/
	String gender;
	/**추가할 코디의 이미지의 링크*/
	String link;
	/**추가할 코디의 이미지의 옷의 종류*/
	String type;
	/**추가할 코디의 첫 스타일의 가중치*/
	String style1;
	/**추가할 코디의 두 번 째 스타일의 가중치*/
	String style2;
	/**추가할 코디의 세 번 째 스타일의 가중치*/
	String style3;
	/**추가할 코디의 네 번 째 스타일의 가중치*/
	String style4;
	/**추가할 코디의 첫 체형의 가중치*/
	String body1;
	/**추가할 코디의 두 번째 스타일의 가중치*/
	String body2;
	/**추가할 코디의 세 번째 스타일의 가중치*/
	String body3;
	/**추가할 코디의 네 번째 스타일의 가중치*/
	String body4;
	/**코디 객체의 생성자
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
	/**파일명을 얻어 올 경우 쓰는 메소드*/
	public String getFilename() {
		return filename;
	}
	/**파일 경로를 얻어 올 경우 쓰는 메소드*/
	public String getFilepath() {
		return filepath;
	}
	/**저장한 날씨를 얻어 올 경우 쓰는 메소드*/
	public String getSeason() {
		return season;
	}
	/**두께감을 얻어 올 경우 쓰는 메소드*/
	public String getThick() {
		return thick;
	}
	/**성별을 얻어 올 경우 쓰는 메소드*/
	public String getGender() {
		return gender;
	}
	/**링크를 얻어 올 경우 쓰는 메소드*/
	public String getLink() {
		return link;
	}
	/**옷의 타입을 얻어 올 경우 쓰는 메소드*/
	public String getType() {
		return type;
	}
	/**첫 스타일의 가중치를 얻어 올 경우 쓰는 메소드*/
	public String getStyle1() {
		return style1;
	}
	/**두 번째 스타일의 가중치를 얻어 올 경우 쓰는 메소드*/
	public String getStyle2() {
		return style2;
	}
	/**세 번째 스타일의 가중치를 얻어 올 경우 쓰는 메소드*/
	public String getStyle3() {
		return style3;
	}
	/**네 번째 스타일의 가중치를 얻어 올 경우 쓰는 메소드*/
	public String getStyle4() {
		return style4;
	}
	/**첫 체형의 가중치를 얻어 올 경우 쓰는 메소드*/
	public String getBody1() {
		return body1;
	}
	/**두 번째 체형의 가중치를 얻어 올 경우 쓰는 메소드*/
	public String getBody2() {
		return body2;
	}
	/**세 번째 체형의 가중치를 얻어 올 경우 쓰는 메소드*/
	public String getBody3() {
		return body3;
	}
	/**네 번째 체형의 가중치를 얻어 올 경우 쓰는 메소드*/
	public String getBody4() {
		return body4;
	}
}
