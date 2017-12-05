/**
 * Javascript.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */

public class Javascript {
	
	private String myLocation;									//GuideToSeoul.class 로 부터 받을 사용자 위치 변수
	private String offset;										//(javascript)기본 옵션
	private String markers;										//(javascript)마커 (아이콘) 옵션
	private String others;										//(javascript)별도 옵션
	private String src;											//(javascript)필수 옵션
	
	public Javascript() {
		myLocation = new String("");
		offset = new String("");
		markers = new String("");
		others = new String("");
		src = new String("");
	}
	public String getScript() {									//javascript 코드 반환
		String script = new String(offset+markers+others+src);
		return script;
	}
	
	public void setMain(String place) {
		myLocation = place;
		offset = new String(
				"document.body.style.padding = 0;"+
				"document.body.style.margin = 0;"+
				"var infowindow;\r\n" + 
				"var map;\r\n" + 		
				"var maps = document.getElementById('map');\r\n" + 
  	            "maps.style.width = '100%';\r\n" + 
  	            "maps.style.height = '100%';" +     
  	            "var geocoder;\r\n " +
  	            "var seoul = {lat: 37.566, lng: 126.978};\r\n" + 							//지도 중앙 위치 초기화
  	            "function initMap() {\r\n" + 
  	            "	map = new google.maps.Map(document.getElementById('map'), {\r\n" + 		//googeAPI map 으로 설정
  	            "       zoom: 12," + 														//zoom 범위 1-20 중 12설정
  	            "       center: seoul"+														//중앙은 서울로 지정
  	            "   });\r\n" +	
  	          "var icon1 = {\r\n" + 														//병원 아이콘 옵션 지정
				"    url:'https://d30y9cdsu7xlg0.cloudfront.net/png/1363373-200.png',\r\n" + 
				"    scaledSize: new google.maps.Size(50, 50) \r\n" + 
				"};"+
				"var icon2 = {\r\n" + 														//서울길 아이콘 옵션 지정
				"    url: 'https://d30y9cdsu7xlg0.cloudfront.net/png/1363377-200.png',\r\n" + 
				"    scaledSize: new google.maps.Size(50, 50) \r\n" + 
				"};"+
				"var icon3 = {\r\n" + 														//식당 아이콘 옵션 지정
				"    url:'https://d30y9cdsu7xlg0.cloudfront.net/png/1363382-200.png'," + 
				"    scaledSize: new google.maps.Size(50, 50) \r\n" + 
				"};"+
				"var icon4 = {\r\n" + 														//숙박 아이콘 옵션 지정
				"    url: 'https://d30y9cdsu7xlg0.cloudfront.net/png/1363379-200.png',\r\n" + 
				"    scaledSize: new google.maps.Size(50, 50) \r\n" + 
				"};"
  	            );
		markers = new String("");
  	  
		others = new String(
				"	geocoder = new google.maps.Geocoder();"+								//googleAPI에서 제공하는 geocoder 객체 생성
  	            "	geocodeAddress(geocoder, map);"+										//지도중앙을 중심으로 위도 경도 계산
  	            "}" +
  	            " function callback(results, status) {\r\n" + 								//마커를 순차 생성할 함수						
  	            "        if (status == google.maps.places.PlacesServiceStatus.OK) {\r\n" + 
  	            "          for (var i = 0; i < results.length; i++) {\r\n" + 
  	            "            createMarker(results[i]);\r\n" + 								//마커 생성
  	            "          }\r\n" + 
  	            "        }\r\n" + 
  	            "      }\r\n" + 
  	            "\r\n" + 
  	            "      function createMarker(place) {\r\n" + 								//마커 생성 함수
  	            "        var placeLoc = place.geometry.location;\r\n" + 
  	            "        var marker = new google.maps.Marker({\r\n" + 
  	            "     	icon: 'http://maps.google.com/mapfiles/kml/pal2/icon28.png',\r\n" + //해당 URL의 커스텀 아이콘 사용
  	            "          map: map,\r\n" + 												//지도에 붙이기
  	            "          position: place.geometry.location\r\n" + 
  	            "        });\r\n" + 
  	            "\r\n" + 
  	            "        google.maps.event.addListener(marker, 'click', function() {\r\n" + 
  	            "          infowindow.setContent(place.name);\r\n" + 
  	            "          infowindow.open(map, this);\r\n" + 
  	            "        });\r\n" + 
  	            "      }" +
  	            "function geocodeAddress(geocoder, resultsMap) {\r\n" + 					//명령어, 지도 parameter 로 받음
  	            "   var address = \"" + myLocation +"\";" + 								//사용자 위치 기본 위치로 설정
  	            "   geocoder.geocode({'address': address}, function(results, status) {\r\n" + 
  	            "      if (status === 'OK') {\r\n" + 
  	            "       resultsMap.setCenter(results[0].geometry.location);\r\n" +
  	            "   	var marker = new google.maps.Marker({\r\n" + 						//사용자 위치에 마커 생성
		    	"		animation: google.maps.Animation.DROP," +							//애니메이션 효과 추가
		    	"   	position: results[0].geometry.location,\r\n" + 
		    	"   	icon: 'http://maps.google.com/mapfiles/kml/shapes/man.png',\r\n" + 
				"       map: resultsMap\r\n" + 
				"   	});\n" +
                "      } else {\r\n" + 
  	            "         alert('Geocode was not successful for the following reason: ' + status);\r\n" + 
  	            "      }\r\n" + 
  	            "   });\r\n" + 
  	            "}\r\n" +
  	            " function calculateAndDisplayRoute(directionsService, directionsDisplay) {\r\n" + 
  	            "        directionsService.route({\r\n" + 
  	            "          origin:'seoul',\r\n" + 
  	            "          destination: 'busan',\r\n" + 
  	            "          travelMode: 'DRIVING'\r\n" + 
  	            "        }, function(response, status) {\r\n" + 
  	            "          if (status === 'OK') {\r\n" + 
  	            "            directionsDisplay.setDirections(response);\r\n" + 
  	            "          } else {\r\n" + 
  	            "            window.alert('Directions request failed due to ' + status);\r\n" + 
  	            "          }\r\n" + 
  	            "        });\r\n" + 
  	            "      }"
				);
		
		src = new String("function includeJs(jsFilePath)\r\n" + 							//googleAPI의 javascript 코드를 원격으로 사용할수 있는 권한 설정
                "{ var js = document.createElement(\"script\")\r\n" + 
                "\r\n" + 
                "js.type = \"text/javascript\";\r\n" + 
                "js.src = jsFilePath;\r\n" + 
                "\r\n" + 
                "document.body.appendChild(js);\r\n" + 
                "}\r\n" + 
                "includeJs(\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDu5LHktof5c2e81HbeiMy3tm4vIfkEs9c&libraries=places&callback=initMap\");\r\n");
	}
	public void setMarker(String marker , double myLat, double myLng){						//마커 설정
	
		markers = "";
		if(marker.equals("Hospital"))
		{
			for(int i=0; i<Hospital.hospitalCount; i++)										//병원 옵션
			{
				double distanceKiloMeter =0;
				
				//데이터 자료와 사용자간 거리 계산
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Hospital.hospitalLA[i]), Double.parseDouble(Hospital.hospitalLO[i]), "kilometer");	
	  		   	if(distanceKiloMeter <5)													//거리가 5km 미만일 경우 좌표 표시
	  		   	{
					markers = markers+
			    	"   var h = {lat: "+Hospital.hospitalLA[i]+", lng: "+Hospital.hospitalLO[i]+"};\r\n" + 
			    	"   var marker = new google.maps.Marker({\r\n" + 
			    	"	animation: google.maps.Animation.DROP," +
					"   	position: h,\r\n" + 
					"   	icon: icon1,\r\n" + 
					"       map: map\r\n" + 
					"   });\n";
			  		    
	  		   	}
			}
		}
		else if(marker.equals("Road"))
		{
			for(int i=0; i<Road.roadCount; i++)												//길 옵션
	  	    {
				double distanceKiloMeter =0;
				//데이터 자료와 사용자간 거리 계산
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Road.roadLA[i]), Double.parseDouble(Road.roadLO[i]), "kilometer");	
	  		   	if(distanceKiloMeter <5)													//거리가 5km 미만일 경우 좌표 표시
	  		   	{	
					markers = markers+
			    	"  var h = {lat: "+Road.roadLA[i]+", lng: "+Road.roadLO[i]+"};\r\n" + 
			    	"   var marker = new google.maps.Marker({\r\n" + 
			    	"	animation: google.maps.Animation.DROP," +
			    	"   	position: h,\r\n" + 
			    	"   	icon: icon2,\r\n" +
			    	"       map: map,\r\n" + 
					"   });\n";
					
	  		   	}
	  	    }
		}
		else if(marker.equals("Restaurant"))
		{
			for(int i=0; i<Restaurant.restaurantCount; i++)									//식당 옵션
	  	    {
				double distanceKiloMeter =0;												
				//데이터 자료와 사용자간 거리 계산
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Restaurant.restaurantLA[i]), Double.parseDouble(Restaurant.restaurantLO[i]), "kilometer");	
				if(distanceKiloMeter <5)													//거리가 5km 미만일 경우 좌표 표시
				{
		  		    markers = markers+
			    	"  var h = {lat: " + Restaurant.restaurantLA[i] +", lng: "+Restaurant.restaurantLO[i]+"};\r\n" + 
			    	"   var marker = new google.maps.Marker({\r\n" + 
			    	"	animation: google.maps.Animation.DROP," +
			    	"   	position: h,\r\n" + 
			    	"   	icon: icon3,\r\n" + 
			    	"       map: map\r\n" + 
					"   });\n";
		  			
				}
	  	    }
		}
		else if(marker.equals("Hotel"))
		{
			for(int i=0; i<Hotel.hotelCount; i++)											//호텔 옵션
	  	    {
				double distanceKiloMeter =0;
				
				distanceKiloMeter =DistanceCalculation.distance(myLat, myLng, Double.parseDouble(Hotel.hotelLA[i]), Double.parseDouble(Hotel.hotelLO[i]), "kilometer");	
				if(distanceKiloMeter<5)														//거리가 5km 미만일 경우 좌표 표시
				{
		  		    markers = markers+
			    	"  var h = {lat: "+Hotel.hotelLA[i]+", lng: "+Hotel.hotelLO[i]+"};\r\n" + 
			    	"   var marker = new google.maps.Marker({\r\n" + 
			    	"	animation: google.maps.Animation.DROP," +
			    	"   	position: h,\r\n" + 
			    	"   	icon: icon4,\r\n" + 
			    	"       map: map,\r\n" + 
					"   });\n";
				}
	  	    }
		}
	}

	public void setDetailMain(String dstLat, String dstLng)	//ClonedDetailFrame 에서 사용할 함수 javascript에 필요한 코드를 한번에 생성
	{
		offset = new String(		"document.body.style.padding = 0;"+								//지도 초기화
				"document.body.style.margin = 0;"+
				"var infowindow;\r\n" + 
				"var map;\r\n" + 		
				"var maps = document.getElementById('map');\r\n" + 
  	            "maps.style.width = '100%';\r\n" + 
  	            "maps.style.height = '100%';" +     
  	            "var seoul = {lat:"+ dstLat +", lng:"+ dstLng + "};\r\n" + 
  	            "function initMap() {\r\n" + 
  	            "	map = new google.maps.Map(document.getElementById('map'), {\r\n" + 
  	            "       zoom: 13," + 
  	            "       center: seoul"+
  	            "   });\r\n"
  	            );
		markers = new String(
				"   var h = {lat: "+dstLat+", lng: "+ dstLng+"};\r\n" + 							//목적지 위도 경도  설정
		    	"   var marker = new google.maps.Marker({\r\n" + 
		    	"	animation: google.maps.Animation.DROP," +
				"   	position: h,\r\n" + 														//위도 경도 위치 설정
				"       map: map\r\n" + 															//맵에 붙여넣기
				"   });\n" +
				"   var h = {lat: "+Double.toString(GuideToSeoul.myLat) +", lng: "+ Double.toString(GuideToSeoul.myLng)+"};\r\n" + //사용자 위도 경도 설정
		    	"   var marker = new google.maps.Marker({\r\n" +									//사용자 위치 마커 설정 
		    	"	animation: google.maps.Animation.DROP," +	
				"   	position: h,\r\n" + 
				"   	icon: 'http://maps.google.com/mapfiles/kml/shapes/man.png',\r\n" +			//사용자 마커 커스텀
				"       map: map\r\n" + 
				"   });\n"
				);
		others = new String(
				"  var flightPlanCoordinates = [\r\n" + 											//사용자 위치와 목적지 위치 직선 긋기
				"          {lat: "+dstLat+", lng: "+ dstLng+"},\r\n" + 
				"          {lat: "+Double.toString(GuideToSeoul.myLat) +", lng: "+ Double.toString(GuideToSeoul.myLng)+"}\r\n" + 
				"        ];\r\n" + 
				"        var flightPath = new google.maps.Polyline({\r\n" + 
				"          path: flightPlanCoordinates,\r\n" + 
				"          geodesic: true,\r\n" + 
				"          strokeColor: '#FF0000',\r\n" + 
				"          strokeOpacity: 1.0,\r\n" + 
				"          strokeWeight: 2\r\n" + 
				"        });\r\n" + 
				"\r\n" + 
				"        flightPath.setMap(map);" +													//직선 세팅
				"}"
				);
		src = new String("function includeJs(jsFilePath)\r\n" + 									//googleAPI의 javascript 코드를 원격으로 사용할수 있는 권한 설정
                "{ var js = document.createElement(\"script\")\r\n" + 
                "\r\n" + 
                "js.type = \"text/javascript\";\r\n" + 
                "js.src = jsFilePath;\r\n" + 
                "\r\n" + 
                "document.body.appendChild(js);\r\n" + 
                "}\r\n" + 
                "includeJs(\"https://maps.googleapis.com/maps/api/js?key=AIzaSyDu5LHktof5c2e81HbeiMy3tm4vIfkEs9c&libraries=places&callback=initMap\");\r\n");
	}
}
