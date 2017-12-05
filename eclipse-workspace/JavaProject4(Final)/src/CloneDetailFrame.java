/**
 * CloneDetailFrame.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일s
 * 최종 수정일: 2017년 12월 7일
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserCommandEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserListener;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserNavigationEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowOpeningEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowWillOpenEvent;


public class CloneDetailFrame extends JFrame{
	
	private JLabel detailBar = new JLabel(new ImageIcon(Main.class.getResource("images/detailInfoBar.png")));				//detailInfoFrame 메뉴바 라벨 설정
	private ImageIcon detailExitButtonEnteredImage = new ImageIcon(Main.class.getResource("images/exitButtonEntered.png"));	//detailInfoFrame 끝내기 버튼 Hover 이미지 객체 생성
	private ImageIcon detailExitButtonBasicImage = new ImageIcon(Main.class.getResource("images/exitButtonBasic.png"));		//detailInfoFrame 끝내기 버튼 기본 이미지 객체 생성
	private ImageIcon searchButtonBasicImage = new ImageIcon(Main.class.getResource("images/searchBasic.png"));				//detailInfoFrame 지도 출력 버튼 기본 이미지 객체 생성
	private ImageIcon searchButtonEnteredImage = new ImageIcon(Main.class.getResource("images/searchEntered.png"));			//detailInfoFrame 지도 출력 버튼 Hover 이미지 객체 생성
	private ImageIcon internetBasic = new ImageIcon(Main.class.getResource("images/internetButtonBasic.png"));				//detailInfoFrame 웹 연결 버튼 기본 이미지 객체 생성
	private ImageIcon internetEntered = new ImageIcon(Main.class.getResource("images/internetButtonEntered.png"));			//detailInfoFrame 웹 연결 버튼 Hover 이미지 객체 생성
	
	
	private JPanel subPanel;							// primary 패널 메뉴바 부분을 제외한 모든 frame 부분을 덮는 패널
	private JPanel subInfo;								// subPanel 의 지도 하단 에 붙여질 패널
	private Javascript javascript;						// Javascript 객체 생성
	private JButton connectInternetButton;				// 인터넷 연결 버튼 객체 생성
	
	//라벨 생성
	private JLabel name;								//detailInfo 이름
	private JLabel address;								//detailInfo 주소
	private JLabel Lat;									//detailInfo 위도
	private JLabel Lng;									//detailInfo 경도
	private JLabel phoneNum;							//detailInfo 전화번호
	private JLabel menu;								//detailInfo 메뉴
	private JLabel subject;								//detailInfo 카테고리
	private JLabel level;								//detailInfo 호텔 등급 
	private JLabel distanceLabel;						//detailInfo 거리 출력 라벨
	
	
	private JButton detailExitButton;					//나가기 버튼 생성
	private JButton executeJavascriptButton;			//지도 출력 버튼 생성
	
	private int mouseX, mouseY;							//마우스 위치 변수 선언
	
	private String options;								//detailInfo 4개항목 중 1개를 저장할 변수
	private int index;									//항목에 해당하는 정보의 인덱스 값을 저장할 변수
	
  protected static final String LS = System.getProperty("line.separator");		//html 문서 개행 명령어
  public CloneDetailFrame(String option, int ind, double distance)
  {

	  options = option;
	  index = ind;
	  
	  //전체 패널 선언 및 옵션 설정
	  subPanel = new JPanel();
	  subPanel.setLayout(null);
	  subPanel.setBounds(0,30,700,700);
	  subPanel.setBackground(new Color(255,200,0));
	  
	  //하위 패널 선언 및 옵션 설정
	  subInfo = new JPanel();
	  subInfo.setLayout(null);
	  subInfo.setBounds(10,450,680,300);
	  subInfo.setBackground(new Color(255,200,0));
	  
	  //이름 라벨 선언 및 옵션 설정
	  name = new JLabel();
	  name.setBounds(0,0,680,20);
	  name.setFont(new Font("나눔고딕", Font.BOLD, 20));
	  name.setForeground(Color.black);
	
	  //주소 라벨 선언 및 옵션 설정
	  address= new JLabel();
	  address.setBounds(0,25,680,20);
	  address.setFont(new Font("나눔고딕", Font.BOLD, 20));
	  address.setForeground(Color.black);
	  
	  //위도 라벨 선언 및 옵션 설정
	  Lat= new JLabel();
	  Lat.setBounds(0,50,680,20);
	  Lat.setFont(new Font("나눔고딕", Font.BOLD, 20));
	  Lat.setForeground(Color.black);
	
	  //경도 라벨 선언 및 옵션 설정
	  Lng = new JLabel();
	  Lng.setBounds(0,75,680,20);
	  Lng.setFont(new Font("나눔고딕", Font.BOLD, 20));
	  Lng.setForeground(Color.black);

	  //전화번호 라벨 선언 및 옵션 설정
	  phoneNum= new JLabel();
	  phoneNum.setBounds(0,100,680,20);
	  phoneNum.setFont(new Font("나눔고딕", Font.BOLD, 20));
	  phoneNum.setForeground(Color.black);
	  
	  //호텔 등급 라벨 선언 및 옵션 설정
	  level= new JLabel();
	  level.setBounds(0,125,680,20);
	  level.setFont(new Font("나눔고딕", Font.BOLD, 20));
	  level.setForeground(Color.black);
	   
	  //식당 카테고리 라벨 선언 및 옵션 설정
	  subject= new JLabel();
	  subject.setBounds(0,125,680,20);
	  subject.setFont(new Font("나눔고딕", Font.BOLD, 20));
	  subject.setForeground(Color.black);
	  
	  //식당 주메뉴 라벨 선언 및 옵션 설정
	  menu= new JLabel();
	  menu.setBounds(0,150,680,20);
	  menu.setFont(new Font("나눔고딕", Font.BOLD, 20));
	  menu.setForeground(Color.black);
	  
	  //거리 출력라벨 선언 및 옵션 설정
	  distanceLabel= new JLabel("Distance: "+ distance + " KM");
	  distanceLabel.setBounds(0,220,680,20);
	  distanceLabel.setFont(new Font("나눔고딕", Font.BOLD, 20));
	  distanceLabel.setForeground(Color.black);
	  
		
	if(option == "Hospital")							//옵션이 병원일 경우
	  {
		//병원에 해당하는 세부 정보 각 라벨에 저장후 subInfo 패널에 추가
		name.setText("Name: " + Hospital.hospitalName[ind]);
		address.setText("Address: " +Hospital.hospitalAddress[ind]);
		Lat.setText("Latitude(위도): " + Hospital.hospitalLA[ind]);
		Lng.setText("Longitude(경도): " + Hospital.hospitalLO[ind]);
		
		subInfo.add(name);
		subInfo.add(address);
		subInfo.add(Lat);
		subInfo.add(Lng);
		
	  }
	  else if(option == "Road")							//옵션이 길일 경유
	  {

		//길에 해당하는 세부 정보 각 라벨에 저장후 subInfo 패널에 추가
		  name.setText("Name: " + Road.roadName[ind]);
		  address.setText("Address: " +Road.roadAddress[ind]);
		  Lat.setText("Latitude(위도): " + Road.roadLA[ind]);
		  Lng.setText("Longitude(경도): " + Road.roadLO[ind]);
		  subInfo.add(name);
			subInfo.add(address);
			subInfo.add(Lat);
			subInfo.add(Lng);
			
	  }
	  else if(option == "Restaurant")					//옵션이 식당일 경우
	  {
		//식당에 해당하는 세부 정보 각 라벨에 저장후 subInfo 패널에 추가
		  name.setText("Name: " + Restaurant.restaurantName[ind]);
		  address.setText("Address: " +Restaurant.restaurantAddress[ind]);
		  Lat.setText("Latitude(위도): " + Restaurant.restaurantLA[ind]);
		  Lng.setText("Longitude(경도): " + Restaurant.restaurantLO[ind]);
		  phoneNum.setText("Phone Number: "+ Restaurant.restaurantPhoneNum[ind]);
		  subject.setText("카테고리: " + Restaurant.restaurantSubject[ind]);
		  menu.setText("주메뉴: " + Restaurant.restaurantMenu[ind]);
		  subInfo.add(name);
		  subInfo.add(address);
		  subInfo.add(Lat);
		  subInfo.add(Lng);
		  subInfo.add(phoneNum);
		  subInfo.add(subject);
		  subInfo.add(menu);
	  }
	  else if(option == "Hotel")						//옵션이 호텔일 경우
	  {

		//호텔에 해당하는 세부 정보 각 라벨에 저장후 subInfo 패널에 추가
		  name.setText("Name: " + Hotel.hotelName[ind]);
		  address.setText("Address: " +Hotel.hotelAddress[ind]);
		  Lat.setText("Latitude(위도): " + Hotel.hotelLA[ind]);
		  Lng.setText("Longitude(경도): " + Hotel.hotelLO[ind]);
		  phoneNum.setText("Phone Number: "+ Hotel.hotelNum[ind]);
		  level.setText("Hotel Level: " + Hotel.hotelPrice[ind]);
		  subInfo.add(name);
		  subInfo.add(address);
		  subInfo.add(Lat);
		  subInfo.add(Lng);
		  subInfo.add(phoneNum);
		  subInfo.add(level);
	  }
	  subInfo.add(distanceLabel);					//별도로 거리출력 라벨도 subInfo에 추가
	  
	    NativeInterface.open();						//지도 추가 작업 실시
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	    	  
	    	//ClonDetailFrame 의 기본 옵션 설정
	    	setUndecorated(true);
	    	setSize(700, 730);
	        setLocationByPlatform(true);
	        setVisible(true);
	        setResizable(false);
	        setLayout(null);
	        
	        //나가기 버튼 옵션 초기화 및 이벤트 설정
			detailExitButton = new JButton(detailExitButtonBasicImage);
			detailExitButton.setBounds(670,0,30,30);
			detailExitButton.setBorderPainted(false);
			detailExitButton.setContentAreaFilled(false);
			detailExitButton.setFocusPainted(false);
			detailExitButton.addMouseListener(new MouseAdapter(){
				@Override
				public void mouseEntered(MouseEvent e)
				{
					detailExitButton.setIcon(detailExitButtonEnteredImage);
					detailExitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
				@Override
				public void mouseExited(MouseEvent e)
				{
					detailExitButton.setIcon(detailExitButtonBasicImage);
					detailExitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	
				}
				@Override
				public void mousePressed(MouseEvent e)
				{
					dispose();									//나가기 버튼을 눌렀을 경우 해당 frame 닫기
				}
			});
			add(detailExitButton);								//frame에 나가기 버튼 추가
				
	        createContent();									//지도 관련 작업 함수
	        subPanel.add(subInfo);
	        add(subPanel);
	        
	        detailBar.setBounds(0,0,700,30);					//메뉴바 위치 설정
			detailBar.addMouseListener(new MouseAdapter()		//메뉴바 이벤트 설정
			{
				//메뉴바를 잡고 움직였을 때 전체 프레임도 움직이게 만듦
				@Override
					public void mousePressed(MouseEvent e)
					{
						mouseX = e.getX();
						mouseY = e.getY();
					}
			});
			detailBar.addMouseMotionListener(new MouseMotionAdapter()
			{
				@Override
				public void mouseDragged(MouseEvent e)
				{
					int x = e.getXOnScreen();
					int y = e.getYOnScreen();
					setLocation(x - mouseX, y - mouseY);
				}
			});
			add(detailBar);
		

	      }
	    });
	    
	}
	public void createContent() {
	    
		JPanel webBrowserPanel = new JPanel(new BorderLayout());					//지도를 출력할 패널 생성 및 초기화
		webBrowserPanel.setBounds(10,10,680,430);									//패널 크기 설정
		
	    final JWebBrowser webBrowser = new JWebBrowser();							//웹브라우져 객체 생성
	    webBrowser.setBarsVisible(false);
	    webBrowser.setStatusBarVisible(true);
	    final String htmlContent =
	      "<html>" + LS +
	      "<head>" + LS +
	      "<style>\r\n"  + LS +
	      "body {background-image: url(\"https://i.ytimg.com/vi/7Uvmww35oxw/maxresdefault.jpg\");\r\n"  + LS +
	      "      background-repeat: no-repeat;\r\n"  + LS +
	      "      background-attachment: fixed;\r\n"  + LS +
	      "      background-position: right bottom;}\r\n"  + LS +
	      "table, td {background-color: transparent;} \r\n"  + LS + 
	      "</style>" + LS +
	      "	</head>" + LS +
	      "  <body>" + LS +
	      "   <div id = \"map\"> <font size=30, color = white> <center> Loading... </center> </font> </div>" + LS +
	      "  </body>" + LS +
	      "</html>";
	    
	    webBrowser.addWebBrowserListener(new WebBrowserListener(){
			public void commandReceived(WebBrowserCommandEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void loadingProgressChanged(WebBrowserEvent arg0) {
			}
			public void locationChangeCanceled(WebBrowserNavigationEvent arg0) {
			}
			public void locationChanged(WebBrowserNavigationEvent arg0) {						//웹브라우져 현재 위치가 바뀌었을 때
				javascript = new Javascript();													//자바 스크립트 객체 선언
				if(options == "Hospital")														//병원일 경우 병원 데이터에 해당하는지도 정보설정
				{
					javascript.setDetailMain(Hospital.hospitalLA[index],Hospital.hospitalLO[index]);
				}
				else if(options == "Road")														//길일 경우 길 데이터에 해당하는지도 정보설정
				{
					javascript.setDetailMain(Road.roadLA[index],Road.roadLO[index]);			
				}
				
				else if(options == "Restaurant")												//식당일 경우 식당 데이터에 해당하는지도 정보설정
				{
					javascript.setDetailMain(Restaurant.restaurantLA[index],Restaurant.restaurantLO[index]);			
				}
				else if(options == "Hotel")														//호텔일 경우 호텔 데이터에 해당하는지도 정보설정
				{
					javascript.setDetailMain(Hotel.hotelLA[index],Hotel.hotelLO[index]);					
				}
				webBrowser.executeJavascript(javascript.getScript());
			}
			public void locationChanging(WebBrowserNavigationEvent arg0) {
			}
			public void statusChanged(WebBrowserEvent arg0) {
			}
			public void titleChanged(WebBrowserEvent arg0) {
			}
			public void windowClosing(WebBrowserEvent arg0) {
			}
			public void windowOpening(WebBrowserWindowOpeningEvent arg0) {
			}
			public void windowWillOpen(WebBrowserWindowWillOpenEvent arg0) {
			}
	    	
	    });
	    webBrowser.setHTMLContent(htmlContent);	
	    webBrowserPanel.add(webBrowser);													//웹브라우져를 지도 패널(webBrowserPanel)에 붙이기
	    subPanel.add(webBrowserPanel);														//subPanel 에 지도 패널 붙이기
	   
	    
	    //지도 출력 버튼 초기화 및 옵션 설정
	    executeJavascriptButton = new JButton(searchButtonBasicImage);
	    executeJavascriptButton.setLayout(null);
	    executeJavascriptButton.setBorderPainted(false);
	    executeJavascriptButton.setBounds(580,190,50,50);									//버튼위치 오른쪽 하단 첫번쨰 설정
		executeJavascriptButton.setHorizontalAlignment(SwingConstants.CENTER);
	    executeJavascriptButton.addMouseListener(new MouseAdapter() {						//지도 출력 버튼과 관련된 마우스 이벤트
	    
	    	public void mouseEntered(MouseEvent e)											//마우스 Hover시 이미지 변화
	    	{
	    		executeJavascriptButton.setIcon(searchButtonEnteredImage);
	    	}
	    	public void mouseExited(MouseEvent e)											//마우스 Exit시 기본이미지로 변화
	    	{
	    		executeJavascriptButton.setIcon(searchButtonBasicImage);
	    	}
	    	public void mouseReleased(MouseEvent e) {										//마우스 클릭시
	    			
				javascript = new Javascript();												//자바 스크립트 객체 선언
				if(options == "Hospital")													//병원일 경우 병원 데이터에 해당하는지도 정보설정
				{
					javascript.setDetailMain(Hospital.hospitalLA[index],Hospital.hospitalLO[index]);
				}
				else if(options == "Road")													//길일 경우 길 데이터에 해당하는지도 정보설정
				{
					javascript.setDetailMain(Road.roadLA[index],Road.roadLO[index]);			
				}
				
				else if(options == "Restaurant")											//식당일 경우 식당 데이터에 해당하는지도 정보설정
				{
					javascript.setDetailMain(Restaurant.restaurantLA[index],Restaurant.restaurantLO[index]);			
				}
				else if(options == "Hotel")													//호텔일 경우 호텔 데이터에 해당하는 지도 정보 설정
				{
					javascript.setDetailMain(Hotel.hotelLA[index],Hotel.hotelLO[index]);					
				}
				webBrowser.executeJavascript(javascript.getScript());						//웹브라우져 실행
	      }
	    });
	    
	    //인터넷 연결 버튼 초기화 및 옵션 설정
	    connectInternetButton = new JButton(internetBasic);
	    connectInternetButton.setBorderPainted(false);
	    connectInternetButton.setBounds(630,190,50,50);										//버튼위치 오른쪽 하단 두번쨰 설정
	    connectInternetButton.setHorizontalAlignment(SwingConstants.CENTER);
	    connectInternetButton.addMouseListener(new MouseAdapter() {							//인터넷 연결과 관련된 마우스 이벤트
	    	public void mouseEntered(MouseEvent e)											//마우스 Hover시 이미지 변화
	    	{
	    		connectInternetButton.setIcon(internetEntered);
	    	}
	    	public void mouseExited(MouseEvent e)											//마우스 Exit시 기본 이미지로 변화
	    	{
	    		connectInternetButton.setIcon(internetBasic);
	    	}
	    	public void mouseReleased(MouseEvent e) {										//마우스 클릭시
	    		
				if(options == "Hospital")															//병원일 경우
				{
					new WebPageOpen(Hospital.hospitalAddress[index],Hospital.hospitalName[index]);	//병원 주소와 이름을 매개변수로 전달한후 인터넷 브라우져 연결
				}
				else if(options == "Road")															//길일 경우
				{
					new WebPageOpen(Road.roadAddress[index],Road.roadName[index]);					//길 주소와 이름을 매개변수로 전달한후 인터넷 브라우져 연결
				}
				
				else if(options == "Restaurant")													//식당일 경우
				{
					new WebPageOpen(Restaurant.restaurantAddress[index],Restaurant.restaurantName[index]);	//식당 주소와 이름을 매개변수로 전달한후 인터넷 브라우져 연결
				}
				else if(options == "Hotel")															//호텔일 경우
				{
					new WebPageOpen(Hotel.hotelAddress[index],Hotel.hotelName[index]);				//호텔 주소와 이름을 매개변수로 전달한후 인터넷 브라우져 연결
				}
	      }
	    });
	  
	    //subInfo 패널에 지도출력 버튼과 인터넷 연결 버튼 추가
	    subInfo.add(executeJavascriptButton);														
	    subInfo.add(connectInternetButton);
	}
}