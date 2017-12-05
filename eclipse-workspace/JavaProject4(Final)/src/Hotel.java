/**
 * Hotel.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */
public class Hotel {
	
	public static int hotelCount = 26;								//호텔총개수
	public static String [] hotelName = new String[200];			//호텔 이름
	public static String [] hotelAddress = new String[200];			//호텔 주소
	public static String [] hotelLO=new String[200];				//호텔 경도
	public static String [] hotelLA=new String[200];				//호텔 위도
	public static String [] hotelPrice = new String[200];			//호텔 등급
	public static String [] hotelNum = new String[200];				//호텔 전화번호
	
	public Hotel()													//호텔 생성자 및 하드 코딩 실시.
	{
		hotelName[0] = "롯데 호텔 서울";
		hotelAddress[0] ="서울 중구 을지로";
		hotelLO[0] = "126.9809";
		hotelLA[0] = "37.5653";
		hotelPrice[0] = "5성급";
		hotelNum[0] = "02-771-1000";
		
		hotelName[1] = "호텔 이비스 앰배서더 명동";
		hotelAddress[1] ="서울 중구 명동 남대문로 78";
		hotelLO[1] = "126.982750";
		hotelLA[1] = "37.564191";
		hotelPrice[1] = "3성급";
		hotelNum[1] = "02-6361-8888";
		
		
		hotelName[2] = "신라스테이 광화문";
		hotelAddress[2] ="서울특별시 종로구 수송동 율곡로4길 63";
		hotelLO[2] = "126.981081";
		hotelLA[2] = "37.572758";
		hotelPrice[2] = "4성급";
		hotelNum[2] = "02-6060-9000";
		
		hotelName[3] = "포시즌스 호텔 서울";
		hotelAddress[3] ="서울특별시 종로구 사직동 새문안로 97";
		hotelLO[3] = "126.975453";
		hotelLA[3] = "37.570465";
		hotelPrice[3] = "5성급";
		hotelNum[3] = "02-6388-5000";
		
		hotelName[4] = "호텔 가온 종로";
		hotelAddress[4] ="서울특별시 종로구 종로1.2.3.4가동 삼일대로 401-8";
		hotelLO[4] = "126.987024";
		hotelLA[4] = "37.570537";
		hotelPrice[4] = "3성급";
		hotelNum[4] = "02-723-0284";
		
		hotelName[5] = "르와지르 호텔 서울 명동";
		hotelAddress[5] ="서울특별시 중구 명동 퇴계로 115";
		hotelLO[5] = "126.984531";
		hotelLA[5] = "37.561227";
		hotelPrice[5] = "4성급";
		hotelNum[5] = "02-6936-6000";
		
		hotelName[6] = "프레지던트 호텔";
		hotelAddress[6] ="서울특별시 중구 프레지던트호텔";
		hotelLO[6] = "126.979431";
		hotelLA[6] = "37.565643";
		hotelPrice[6] = "4성급";
		hotelNum[6] = "02-753-3131";
		
		hotelName[7] = "해밀톤 호텔";
		hotelAddress[7] ="서울특별시 용산구 이태원1동 이태원로 179";
		hotelLO[7] = "126.993674";
		hotelLA[7] = "37.534853";
		hotelPrice[7] = "3성급";
		hotelNum[7] = "02-6393-1000";
		
		hotelName[8] = "임피리얼 팰리스 부티크 호텔";
		hotelAddress[8] ="서울특별시 용산구 한남동 737-32";
		hotelLO[8] = "126.998260";
		hotelLA[8] = "37.535333";
		hotelPrice[8] = "4성급";
		hotelNum[8] = "02-3702-8000";
		
		hotelName[9] = "그랜드 하얏트 서울";
		hotelAddress[9] ="서울특별시 용산구 이태원2동 소월로 322";
		hotelLO[9] = "126.997104";
		hotelLA[9] = "37.539348";
		hotelPrice[9] = "5성급";
		hotelNum[9] = "02-797-1234";
		
		hotelName[10] = "서울 신라호텔";
		hotelAddress[10] ="서울특별시 중구 장충동2가 동호로 249";
		hotelLO[10] = "127.006232";
		hotelLA[10] = "37.556460";
		hotelPrice[10] = "5성급";
		hotelNum[10] = "02-2233-3131";
		
		hotelName[11] = "동서울호텔";
		hotelAddress[11] ="서울특별시 광진구 구의동 595";
		hotelLO[11] = "127.091862";
		hotelLA[11] = "37.534124";
		hotelPrice[11] = "3성급";
		hotelNum[11] = "02-455-1100";
		
		hotelName[12] = "세종호텔";
		hotelAddress[12] ="서울특별시 중구 명동 퇴계로 145";
		hotelLO[12] = " 126.987941";
		hotelLA[12] = "37.561312";
		hotelPrice[12] = "4성급";
		hotelNum[12] = "02-773-6000";
		
		hotelName[13] = "이비스 스타일 앰배서더 서울 명동";
		hotelAddress[13] ="서울특별시 중구 명동 삼일대로 302";
		hotelLO[13] = "126.989206";
		hotelLA[13] = "37.561798";
		hotelPrice[13] = "4성급";
		hotelNum[13] = "02-6370-1101";
		
		hotelName[14] = "벤허호텔";
		hotelAddress[14] ="서울특별시 영등포구 여의도동 13-18";
		hotelLO[14] = "126.920456";
		hotelLA[14] = "37.530331";
		hotelPrice[14] = "3성급";
		hotelNum[14] = "02-783-2233";
		
		hotelName[15] = "호텔 노보텔 앰배서더 강남";
		hotelAddress[15] ="서울특별시 강남구 역삼1동 봉은사로 130";
		hotelLO[15] = "127.028899";
		hotelLA[15] = "37.505242";
		hotelPrice[15] = "5성급";
		hotelNum[15] = "02-567-1101";
		
		hotelName[16] = "르메르디앙 서울 호텔";
		hotelAddress[16] ="서울특별시 강남구 역삼1동 봉은사로 120";
		hotelLO[16] = "127.027170";
		hotelLA[16] = "37.504856";
		hotelPrice[16] = "5성급";
		hotelNum[16] = "02-3451-8000";
		
		hotelName[17] = "JW메리어트호텔 서울";
		hotelAddress[17] ="176 Sinbanpo-ro, 반포4동 Seocho-gu, Seoul";
		hotelLO[17] = "127.004624";
		hotelLA[17] = "37.503789";
		hotelPrice[17] = "5성급";
		hotelNum[17] = "02-6282-6262";
		
		hotelName[18] = "Sheraton Seoul PaLOce Gangnam hotel";
		hotelAddress[18] ="Seoul 서울특별시 Seoul 반포4동 160 Sapyeong-daero Seocho-gu";
		hotelLO[18] = "127.001653";
		hotelLA[18] = "37.500857";
		hotelPrice[18] = "5성급";
		hotelNum[18] = "02-532-5000";
		
		hotelName[19] = "오클라우드 호텔";
		hotelAddress[19] ="서울특별시 서초구 서초4동 사평대로58길 12";
		hotelLO[19] = "127.023730";
		hotelLA[19] = "37.503055";
		hotelPrice[19] = "4성급";
		hotelNum[19] = "1899-9994";
		
		hotelName[20] = "파크 하얏트 서울";
		hotelAddress[20] ="서울특별시 강남구 대치2동 테헤란로 606";
		hotelLO[20] = "127.064111";
		hotelLA[20] = "37.508501";
		hotelPrice[20] = "5성급";
		hotelNum[20] = "02-2016-1234";
		
		hotelName[21] = "그랜드 인터컨티넨탈 서울 파르나스";
		hotelAddress[21] ="521 Teheran-ro, 삼성1동 Gangnam-gu, Seoul";
		hotelLO[21] = "127.060755";
		hotelLA[21] = "37.509177";
		hotelPrice[21] = "5성급";
		hotelNum[21] = "02-555-5656";
		
		hotelName[22] = "호텔 페이토 삼성 hotel PEYTO SAMSEONG";
		hotelAddress[22] ="서울특별시 강남구 삼성1동 테헤란로87길 9";
		hotelLO[22] = "127.058688";
		hotelLA[22] = "37.508385";
		hotelPrice[22] = "4성급";
		hotelNum[22] = "02-6936-9700";
		
		hotelName[23] = "롯데호텔월드";
		hotelAddress[23] ="서울특별시 송파구 잠실3동 올림픽로 240";
		hotelLO[23] = "127.099873";
		hotelLA[23] = "37.511493";
		hotelPrice[23] = "4성급";
		hotelNum[23] = "02-419-7000";
		
		hotelName[24] = "롯데시티호텔 마포";
		hotelAddress[24] ="서울특별시 마포구 공덕동 마포대로 109";
		hotelLO[24] = "126.950493";
		hotelLA[24] = "37.544696";
		hotelPrice[24] = "4성급";
		hotelNum[24] = "02-6009-1000";
		
		hotelName[25] = "Nine Tree Premier hotel Myeongdong II";
		hotelAddress[25] ="서울특별시 중구 초동 마른내로 28";
		hotelLO[25] = "126.990763";
		hotelLA[25] = "37.564318";
		hotelPrice[25] = "4성급";
		hotelNum[25] ="02-6967-0999";
		
	}
	
}
