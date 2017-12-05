/**
 * Parsing.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Parsing {		

	public Parsing()										//Parsing 생성자
	{
		try {
			parsing();										//parsing 메소드 실시
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void parsing() throws Exception
	{
		Document documentHospital;							//병원 데이터 문서 객체 선언
		Document documentRoad;								//길 데이터 문서 객체 선언
		Document documentRest;								//식당 데이터 문서 객체 선언
		
		XPath xpath = XPathFactory.newInstance().newXPath();	//Path 객체 선언
		
		//OpenAPI 데이터를 가져올 URL 주소 각 문서 별 저장
		documentHospital =DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("http://openapi.seoul.go.kr:8088/754763706a6c7368313031616d657975/xml/InfoEmrrmLc/1/1000/");
		documentRoad =DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("http://openapi.seoul.go.kr:8088/754763706a6c7368313031616d657975/xml/SebcTourStreetEng/1/1000/");
		documentRest =DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("http://openapi.seoul.go.kr:8088/754763706a6c7368313031616d657975/xml/CrtfcUpsoInfo/1/300/");

		int dataCount =0;																									//데이터 개수 Count 변수 선언
		
		
		//병원--------------------------------------------------------------------------------------------------------------------
		//병원 항목별 노드 리스트 생성
		NodeList WGS84_LO = (NodeList)xpath.evaluate("//row//WGS84_LO", documentHospital, XPathConstants.NODESET);			//경도
		NodeList WGS84_LA = (NodeList)xpath.evaluate("//row//WGS84_LA", documentHospital, XPathConstants.NODESET);			//위도
		NodeList ADRESS = (NodeList)xpath.evaluate("//row//INSTT_ADRES", documentHospital, XPathConstants.NODESET);			//주소	
		NodeList NAME = (NodeList)xpath.evaluate("//row//INSTT_NM", documentHospital, XPathConstants.NODESET);				//이름
		
		
		for(int idx=0; idx< NAME.getLength(); idx++ )										//Parsing 된 데이터 Hospital 객체 내부 데이터에 저장
		{
			Hospital.hospitalName[idx] = NAME.item(idx).getTextContent();
			Hospital.hospitalAddress[idx] = ADRESS.item(idx).getTextContent();
			Hospital.hospitalLO[idx] = WGS84_LO.item(idx).getTextContent();
			Hospital.hospitalLA[idx] = WGS84_LA.item(idx).getTextContent();
			dataCount+=1;
		}
		
		Hospital.hospitalCount = dataCount;
		
		dataCount =0;
	

		//길--------------------------------------------------------------------------------------------------------------------
		//길 항목별 노드 리스트 생성
		NodeList H_ENG_CITY = (NodeList)xpath.evaluate("//row//H_ENG_CITY", documentRoad, XPathConstants.NODESET);		//도시이름
		NodeList H_ENG_GU = (NodeList)xpath.evaluate("//row//H_ENG_GU", documentRoad, XPathConstants.NODESET);			//구
		NodeList H_ENG_DONG = (NodeList)xpath.evaluate("//row//H_ENG_DONG", documentRoad, XPathConstants.NODESET);		//동
		NodeList roadNAME = (NodeList)xpath.evaluate("//row/NAME_ENG", documentRoad, XPathConstants.NODESET);			//길 이름
		NodeList WGS84_X = (NodeList)xpath.evaluate("//row/WGS84_X", documentRoad, XPathConstants.NODESET);				//경도
		NodeList WGS84_Y = (NodeList)xpath.evaluate("//row/WGS84_Y", documentRoad, XPathConstants.NODESET);				//위도
		
		
		for(int idx=0; idx< roadNAME.getLength(); idx++ )							//Parsing 된 데이터 Road 객체 내부 데이터에 저장
		{
			Road.roadAddress[idx] = "Seoul " + H_ENG_GU.item(idx).getTextContent() + " " + H_ENG_DONG.item(idx).getTextContent() + " " + roadNAME.item(idx).getTextContent();
			Road.roadName[idx] = roadNAME.item(idx).getTextContent();
			Road.roadCount = roadNAME.getLength();
			Road.roadLO[idx] = WGS84_X.item(idx).getTextContent();
			Road.roadLA[idx] = WGS84_Y.item(idx).getTextContent();
			dataCount +=1;
		}
		Road.roadCount = dataCount;
			
		dataCount =0;
		
		//식당--------------------------------------------------------------------------------------------------------------------
		//식당 항목별 노드 리스트 생성
		NodeList rest_X = (NodeList)xpath.evaluate("//row/X_CNTS", documentRest, XPathConstants.NODESET);				//경도
		NodeList rest_Y = (NodeList)xpath.evaluate("//row/Y_DNTS", documentRest, XPathConstants.NODESET);				//위도
		NodeList rest_address = (NodeList)xpath.evaluate("//row//RDN_CODE_NM", documentRest, XPathConstants.NODESET);	//주소
		NodeList rest_name = (NodeList)xpath.evaluate("//row/UPSO_NM", documentRest, XPathConstants.NODESET);			//이름
		NodeList rest_phoneNum = (NodeList)xpath.evaluate("//row/TEL_NO", documentRest, XPathConstants.NODESET);		//전화번호
		NodeList rest_email = (NodeList)xpath.evaluate("//row/CRTFC_CHR_ID", documentRest, XPathConstants.NODESET);		//email
		NodeList rest_menu = (NodeList)xpath.evaluate("//row/FOOD_MENU", documentRest, XPathConstants.NODESET);			//메뉴
		NodeList rest_subject = (NodeList)xpath.evaluate("//row/BIZCND_CODE_NM", documentRest, XPathConstants.NODESET);	//카테고리
		
		for(int idx =0; idx<rest_name.getLength(); idx++)
		{
			if(rest_X.item(idx).getTextContent().equals("0") || rest_Y.item(idx).getTextContent().equals("0"))			//위도, 경도 데이터가 없을 경우 패쓰
			{
				continue;
			}
			else	//위도 경도 데이터가 있는 경우 데이터 저장
			{
				Restaurant.restaurantName[dataCount] = rest_name.item(idx).getTextContent();
				Restaurant.restaurantAddress[dataCount] = rest_address.item(idx).getTextContent();
				Restaurant.restaurantPhoneNum[dataCount] = rest_phoneNum.item(idx).getTextContent();
				Restaurant.restaurantEmail[dataCount] = rest_email.item(idx).getTextContent();
				Restaurant.restaurantMenu[dataCount] = rest_menu.item(idx).getTextContent();
				Restaurant.restaurantSubject[dataCount] = rest_subject.item(idx).getTextContent();
				Restaurant.restaurantLO[dataCount]=rest_X.item(idx).getTextContent();
				Restaurant.restaurantLA[dataCount]=rest_Y.item(idx).getTextContent();
				
				dataCount +=1;
			}
		}
		Restaurant.restaurantCount = dataCount;	
	}
	
}
