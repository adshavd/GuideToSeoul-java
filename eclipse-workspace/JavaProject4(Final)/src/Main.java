/**
 * Main.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */
public class Main {
	
	public final static int SCREEN_WIDTH = 1500;					//프레임 가로 길이
	public final static int SCREEN_HEIGHT = 830;					//프레임 세로 길이
	
	public static GuideToSeoul ex;									//GuideToSeoul.class 객체 생성
	
	public static void main(String[] args)
	{
		ex = new GuideToSeoul();									//GuideToSeoul.class 객체 선언 
	}
}