package InnerClass;
/**팁과 링크를 함께 묶기위한 객체를 생성하기 위한 클래스
 * 
 * */
public class TipObject {
	/**팁*/
	String tip;
	/**링크*/
	String link;
	/**팁과 링크 객체의 생성자
	 * @param tip
	 * @param link
	 * */
	public TipObject(String tip, String link) {
		super();
		this.tip = tip;
		this.link = link;
	}
	public String getTip() {
		return tip;
	}
	public String getLink() {
		return link;
	}

	
}
