/**
 * DistanceCalculation.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */
public class DistanceCalculation {
	
	/*
	 거리 계산을 위해 위도 와 경도 각각 2개씩 받고, 옵션을 받습니다. 여기서 사용하는 옵션은 km 단위 이며 meter 단위 도 가능합니다.
	 구체적인 계산 원리는 
	 
	 http://www.geodatasource.com/developers/java
	 http://transition.fcc.gov/mb/audio/bickel/DDDMMSS-decimal.html
	 http://egloos.zum.com/metashower/v/313035
	 
	 를 참고하시기 바랍니다.
	 */
	 public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {	
	      
		  	double theta = lon1 - lon2;
	        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + 
	        		Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
	         
	        dist = Math.acos(dist);
	        dist = rad2deg(dist);
	        dist = dist * 60 * 1.1515;
	      
	        if (unit == "kilometer") {
	            dist = dist * 1.609344;
	        } else if(unit == "meter"){
	            dist = dist * 1609.344;
	        }
	 	
	        return (dist);
	  }
	  public static double deg2rad(double deg) {
	      return (double)(deg * Math.PI / (double)180.0d);
	  }
	   
	  public static double rad2deg(double rad) {
	      return (double)(rad * (double)180d / Math.PI);
	  }
}
