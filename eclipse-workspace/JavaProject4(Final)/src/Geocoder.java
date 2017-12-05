/**
 * Geocoder.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;

public class Geocoder
{
	private String lat;								//위도 변수 선언
	private String lng;								//경도 변수 선언
	public Geocoder(String userLocation)			//사용자 위치를 가져옴
	{
		lat ="";
		lng ="";
		
		try
		{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	//버퍼리더 객체 생성 및 선언
			    String latLongs[] = getLatLongPositions(userLocation);							//위도 경도 임시 저장 배열 선언 및 초기화 getLetLongPositions로 부터 위도 경도를 받음/
			    lat = latLongs[0];					//위도 저장
			    lng = latLongs[1];					//경도 저장
			    
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
  
  
  public static String[] getLatLongPositions(String address) throws Exception			
  {
    int responseCode = 0;
    String api = "http://maps.googleapis.com/maps/api/geocode/xml?address=" + URLEncoder.encode(address, "UTF-8") + "&sensor=true";	//api 변수에 사용자 위치가 담긴 URL 주소 저장
    URL url = new URL(api);
    HttpURLConnection httpConnection = (HttpURLConnection)url.openConnection();														//웹브라우져 연결
    httpConnection.connect();																										//웹 연결
    responseCode = httpConnection.getResponseCode();																				//응답 코드 받음
    
    //responseCode가 200 일떄 google 상 xml 데이터 승인을 받았다는 뜻.
    if(responseCode == 200)
    {
    	//데이터 수령 과정
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();;
      Document document = builder.parse(httpConnection.getInputStream());
      XPathFactory xPathfactory = XPathFactory.newInstance();
      XPath xpath = xPathfactory.newXPath();
      XPathExpression expr = xpath.compile("/GeocodeResponse/status");
      String status = (String)expr.evaluate(document, XPathConstants.STRING);
      
      //위도 경도 웹상 계산 요청 및 Local로 인수 받는 과정.
      if(status.equals("OK"))
      {
         expr = xpath.compile("//geometry/location/lat");
         String latitude = (String)expr.evaluate(document, XPathConstants.STRING);
         expr = xpath.compile("//geometry/location/lng");
         String longitude = (String)expr.evaluate(document, XPathConstants.STRING);
    
         return new String[] {latitude, longitude};
      }
      else	//실패시 오류 메세지
      {
         throw new Exception("Error from the API - response status: "+status);
      }
    }
    return null;
  }
  public void setLocation(String location)																//사용자 위치 변경시 사용하는 메소드 (생성자와 동일)
  {
	  	lat ="";
		lng ="";	
		try
		{
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			    String latLongs[] = getLatLongPositions(location);
			    System.out.println(latLongs[0] + latLongs[1]);
			    lat = latLongs[0];
			    lng = latLongs[1];
			    
		}catch(Exception e)
		{
			e.printStackTrace();
		}
  }
  public String getLng()			//위도 반환
  {
	  return lng;
  }
  public String getLat()			//경도 반환
  {
	  return lat;
  }

}