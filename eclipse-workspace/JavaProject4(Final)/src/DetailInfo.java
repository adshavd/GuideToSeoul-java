/**
 * DetailInfo.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class DetailInfo extends JFrame {
	
	private JPanel detailInfoPanel;														//GuideToSeoul 측면 패널로 쓰일 패널 객체 생성
	private ArrayList<DetailObject> objectList;											//DetailObject 에서 생성될 버튼들을 담을 ArrayList 생성
	
	public DetailInfo() {
		
		detailInfoPanel = new JPanel();													//패널 객체 초기화
		detailInfoPanel.setBackground(Color.white);
		detailInfoPanel.setLayout(new GridLayout(Restaurant.restaurantName.length,1));	//패널 Layout 설정
		objectList = new ArrayList<DetailObject>();										//objectList 초기화
	}
	public void setDetailContents(String Contents, double myLat, double myLng) {		//사용자와의 거리를 고려하여 버튼 설정및 추가가 이루어짐
		objectList.clear();																//objectList 내용 모두 지우기
		
		if(Contents == "Restaurant")													//식당 옵션
			for(int i=0; i<Restaurant.restaurantCount; i++)
	  	    {
				double distanceKiloMeter =0;
				//거리 계산
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Restaurant.restaurantLA[i]), Double.parseDouble(Restaurant.restaurantLO[i]), "kilometer");	
				if(distanceKiloMeter<5)		//거리가 5km이하일 경우 리스트에 추가
				{
				objectList.add(new DetailObject("Restaurant",Restaurant.restaurantName[i],Restaurant.restaurantPhoneNum[i],Restaurant.restaurantAddress[i], i,distanceKiloMeter));
	  	   
				}
	  	    }
		
		if(Contents == "Hotel")															//호텔 옵션
			for(int i=0; i<Hotel.hotelCount; i++)
	  	    {	
				double distanceKiloMeter =0;
				//거리 계산
	  	    	distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Hotel.hotelLA[i]), Double.parseDouble(Hotel.hotelLO[i]), "kilometer");	
	  	    	if(distanceKiloMeter<5)//거리가 5km이하일 경우 리스트에 추가
				{
				objectList.add(new DetailObject("Hotel",Hotel.hotelName[i],Hotel.hotelAddress[i],"", i,distanceKiloMeter));
	  	   
				}
	  	    }
		
		if(Contents == "Road")															//길 옵션
			for(int i=0; i<Road.roadCount; i++)
	  	    {
				double distanceKiloMeter =0;
				//거리 계산
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Road.roadLA[i]), Double.parseDouble(Road.roadLO[i]), "kilometer");	
		  	  	if(distanceKiloMeter<5)//거리가 5km이하일 경우 리스트에 추가
				{	
		  	  		objectList.add(new DetailObject("Road",Road.roadName[i],Road.roadAddress[i],"", i,distanceKiloMeter));
				}
	  	    }
		
		if(Contents == "Hospital")														//병원 옵션
			for(int i=0; i<Hospital.hospitalCount; i++)
	  	    {
				double distanceKiloMeter =0;
				//거리 계산
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Hospital.hospitalLA[i]), Double.parseDouble(Hospital.hospitalLO[i]), "kilometer");	
	  	    	if(distanceKiloMeter<5)//거리가 5km이하일 경우 리스트에 추가
				{
	  	    		objectList.add(new DetailObject("Hospital",Hospital.hospitalName[i],Hospital.hospitalAddress[i],"", i,distanceKiloMeter));
				}
	  	    }
	}
	
	public void setLabelPos() {
		detailInfoPanel.removeAll();													//이전 패널에 남아있던 모든 내용을 지움
		for(int i=1; i<objectList.size(); i++)											//List 에 있는 버튼들을 순차적으로 패널에 붙임.
  	    {
			detailInfoPanel.add(objectList.get(i).getDetailButton());
  	    }
	}
	public void setInitial()															//Panel 및 objectList 초기화
	{
		objectList.clear();
		detailInfoPanel.removeAll();	
	}
	
	public JPanel getPanel() {															//Panel 반환
		return detailInfoPanel;
	}
	
	
}
