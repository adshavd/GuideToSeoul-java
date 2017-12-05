/**
 * WebPageOpen.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */
import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.awt.Desktop; 

public class WebPageOpen {			
	
	public WebPageOpen(String address, String name)				// 주소, 이름 Parameter로 받고 생성자 선언
	{
		try 
		{
			Desktop.getDesktop().browse(new URI("http://www.google.com/search?q=" + URLEncoder.encode(address, "UTF-8") + "+" +	//브라우져 실행 및 google 검색 실시
			URLEncoder.encode(name, "UTF-8"))); 
		}
		catch (Exception e) 
		{ e.printStackTrace(); }	

	}
	
}
