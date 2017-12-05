/**
 * GuideToSeoul.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.tools.DocumentationTool.Location;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


public class GuideToSeoul extends JFrame {																				//JFrame을 class 자체에 import

	private ImageIcon intro1 = new ImageIcon(Main.class.getResource("images/intro1.png"));								//intro화면이미지1 초기화
	private ImageIcon intro2 = new ImageIcon(Main.class.getResource("images/intro2.png"));								//intro화면이미지2 초기화
	private ImageIcon intro3 = new ImageIcon(Main.class.getResource("images/intro3.png"));								//intro화면이미지3 초기화
	
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("images/exitButtonEntered.png"));	//나가기 버튼 Hover 상태 이미지 초기화
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("images/exitButtonBasic.png"));		//나가기 버튼 일반 상태 이미지 초기화
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("images/menuBar.png")));					//메인 메뉴바 이미지 초기화
	private JButton exitButton = new JButton(exitButtonBasicImage);														//나가기 버튼 초기하ㅗ
	
	private int mouseX, mouseY;																							//마우스 절대경로 x,y 좌표 변수 선언
	private JLabel introBackgroundImage;																				//into화면들을 저장할 JLabel 선언
	
	//upperMainPanel 에서 사용할 것
	private ImageIcon hospitalButtonBasicImage = new ImageIcon(Main.class.getResource("images/hospitalBasic.png"));		//병원 버튼 Hover 상태 이미지 초기화
	private ImageIcon hospitalButtonEnteredImage = new ImageIcon(Main.class.getResource("images/hospitalEntered.png"));	//병원 버튼 일반 상태 이미지 초기화
	private ImageIcon hospitalButtonClickedImage = new ImageIcon(Main.class.getResource("images/hospitalClicked.png"));	//병원 버튼 클릭 상태 이미지 초기화
	private ImageIcon roadButtonBasicImage = new ImageIcon(Main.class.getResource("images/roadBasic.png"));				//길 버튼 Hover 상태 이미지 초기화
	private ImageIcon roadButtonEnteredImage = new ImageIcon(Main.class.getResource("images/roadEntered.png"));			//길 버튼 Hover 상태 이미지 초기화
	private ImageIcon roadButtonClickedImage = new ImageIcon(Main.class.getResource("images/roadClicked.png"));			//길 버튼 Hover 상태 이미지 초기화
	private ImageIcon restaurantButtonBasicImage = new ImageIcon(Main.class.getResource("images/restaurantBasic.png"));	//식당 버튼 Hover 상태 이미지 초기화
	private ImageIcon restaurantButtonEnteredImage = new ImageIcon(Main.class.getResource("images/restaurantEntered.png"));//식당 버튼 Hover 상태 이미지 초기화
	private ImageIcon restaurantButtonClickedImage = new ImageIcon(Main.class.getResource("images/restaurantClicked.png"));//식당 버튼 Hover 상태 이미지 초기화
	private ImageIcon hotelButtonBasicImage = new ImageIcon(Main.class.getResource("images/hotelBasic.png"));			//호텔 버튼 Hover 상태 이미지 초기화
	private ImageIcon hotelButtonEnteredImage = new ImageIcon(Main.class.getResource("images/hotelEntered.png"));		//호텔 버튼 Hover 상태 이미지 초기화
	private ImageIcon hotelButtonClickedImage = new ImageIcon(Main.class.getResource("images/hotelClicked.png"));		//호텔 버튼 Hover 상태 이미지 초기화
	private ImageIcon logoImage = new ImageIcon(Main.class.getResource("images/logo.png"));								//로고 이미지 초기화
	private JButton	hospitalButton = new JButton(hospitalButtonBasicImage);												//병원 버튼 초기화
	private JButton roadButton = new JButton(roadButtonBasicImage);														//길 버튼 초기화
	private JButton hotelButton = new JButton(hotelButtonBasicImage);													//호텔 버튼 초기화
	private JButton restaurantButton = new JButton(restaurantButtonBasicImage);											//식당 버튼 초기화
	private JPanel upperMainPanel = new JPanel();																		//메인 패널 중 위의 패널 초기화
	private JLabel logo = new JLabel(logoImage);																		//로고 출력 라벨 초기화
	
	//Java script 및 MainMap 에서 사용될 것들
	private ImageIcon searchButtonBasicImage = new ImageIcon(Main.class.getResource("images/searchBasic.png"));			//검색 버튼 일반 상태 이미지 초기화
	private ImageIcon searchButtonEnteredImage = new ImageIcon(Main.class.getResource("images/searchEntered.png"));		//검색 버튼 Hover 상태 이미지 초기화
	private ImageIcon openButtonBasicImage = new ImageIcon(Main.class.getResource("images/openButtonBasic.png"));		//측면 화살표 버튼 일반 상태  이미지 초기화
	private ImageIcon openButtonEnteredImage = new ImageIcon(Main.class.getResource("images/openButtonEntered.png"));	//측면 화살표 버튼 Hover 상태 이미지 초기화
	private ImageIcon openedButtonBasicImage = new ImageIcon(Main.class.getResource("images/openedButtonBasic.png"));	//측면 화살표 (오픈된 상태) 버튼 일반 상태 이미지 초기화
	private ImageIcon openedButtonEnteredImage = new ImageIcon(Main.class.getResource("images/openedButtonEntered.png"));//측면 화살표 (오픈된 상태) 버튼 Hover 상태 이미지 초기화
	
	protected static final String LS = System.getProperty("line.separator");											//html 문서 개행 명령 문자 저장
	public static String myLocation = new String("");																	//사용자 위치 변수 선언
	public static JPanel mainMap = new JPanel();																		//MainMap 패널 선언
	private Javascript script;																							//JavaScript 객체선언
	private JPanel configurationPanel;																					//검색버튼, 텍스트 필드를 담을 패널 선언
	private JButton executeJavascriptButton;																			//검색버튼 초기화
	private JButton openPanelButton;																					//오픈 패널 버튼 초기화
	private JTextField placeInput;																						//텍스트 필드 선언
	private JScrollPane scroll;																							//스크롤바 선언
	private boolean panelOpenedFlag;																					//측면 패널이 오픈되었는지 안되었지를 판단하는 boolen 변수
	
	
	private ImageIcon exitIcon1 = new ImageIcon(Main.class.getResource("images/ending1.png"));							//초기화면 개발자 설명 이미지 선언
	private ImageIcon exitIcon2 = new ImageIcon(Main.class.getResource("images/ending2.png"));							//초기화면 프로젝트 기간 설명 이미지 선언
	
	//공용으로 사용되는 elements 들------------------------------------------------------------------------------
	public static double myLat;																							//사용자 위도 변수 선언
	public static double myLng;																							//사용자 경도 변수 선언
	
	private DetailInfo infoPanel;																						//측면 패널 추가 객체 생성
	private Parsing par = new Parsing();																				//웹상 데이터 자료 파싱 객체 생성및 선언
	private Geocoder geocoder;																							//사용자 위치 계산 class 객체 생성
	private Hotel hotel;																								//호텔 데이터 자료 class 객체 생성
	
	public GuideToSeoul()
	{
		hotel = new Hotel();																							//호텔 선언 (호텔 자료 초기화됨)
		
		//Frame initialization---------------------------------------------------------------------------------------------------
		setUndecorated(true);																	//디폴트 메뉴바 없앰
		setTitle("Guide To Seoul");															
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);											//메인프레임 크기 설정
		setResizable(false);										
		setLocationRelativeTo(null);															//화면 출력 위치 설정
		setVisible(true);			
		setLayout(null);
		panelOpenedFlag = false;																//측면 프레임 오픈 상태가 아닌것으로 설정
	    introMain();
	}
	
	public void introMain()
	{
		//intro화면 출력 준비
		introBackgroundImage = new JLabel(intro1);												
		introBackgroundImage.setBounds(0,0,Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		add(introBackgroundImage);
		
		//1초 및 2초 간격으로 인트로 화면 출력
		try
		{
			Thread.sleep(1000);
			introBackgroundImage.setIcon(intro2);
			Thread.sleep(1000);
			introBackgroundImage.setIcon(intro3);
			Thread.sleep(1000);
			introBackgroundImage.setIcon(intro1);
			Thread.sleep(1000);
			introBackgroundImage.setIcon(intro2);
			Thread.sleep(1000);
			introBackgroundImage.setIcon(intro3);
			Thread.sleep(1000);
			introBackgroundImage.setIcon(intro1);
			Thread.sleep(1000);
			introBackgroundImage.setIcon(intro2);
			Thread.sleep(1000);
			introBackgroundImage.setIcon(intro3);
			Thread.sleep(1000);
			introBackgroundImage.setIcon(exitIcon1);
			Thread.sleep(2000);
			introBackgroundImage.setIcon(exitIcon2);
			Thread.sleep(2000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		introBackgroundImage.setVisible(false);									//인트로 화면 끄기
		
		//나가기 버튼 옵션 설정 및 MouseAction 이벤트 추가
		exitButton.setBounds(1460, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter(){
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e)
			{
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	
			}
			@Override
			public void mouseReleased(MouseEvent e)
			{
				System.exit(0);
			}
		});
		add(exitButton);
		
		//메뉴바 옵션 설정 및 MouseAction 이벤트 추가
		menuBar.setBounds(0,0,1500,30);
		menuBar.addMouseListener(new MouseAdapter()
		{	@Override
				public void mousePressed(MouseEvent e)
				{
					mouseX = e.getX();
					mouseY = e.getY();
				}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter()
		{
			//메뉴바를 잡고 움직였을 때 전체 프레임도 움직이게 만듦
			@Override
			public void mouseDragged(MouseEvent e)
			{
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
		
		//메인 화면 위쪽 패널 옵션 추가
		upperMainPanel.setBounds(0,30,1500,100);
		upperMainPanel.setLayout(null);
		upperMainPanel.setBackground(new Color(255,200,0));
		
		logo.setBounds(20,10,80,80);										//로고 이미지 위치 설정
		upperMainPanel.add(logo);											//로고 upperMainPanel 에 추가
		
		//병원 버튼 옵션 설정 및 upperMainPanel 에추가
		hospitalButton.setBounds(280,0,200,100);
		hospitalButton.setBorderPainted(false);
		hospitalButton.setFont(new Font("Gothic"+ "", Font.BOLD, 20));
		upperMainPanel.add(hospitalButton);

		//길 버튼 옵션 설정 및 upperMainPanel 에추가
		roadButton.setBounds(480,0,200,100);
		roadButton.setBorderPainted(false);
		roadButton.setFont(new Font("Gothic", Font.BOLD, 20));
		upperMainPanel.add(roadButton);

		//호텔 버튼 옵션 설정 및 upperMainPanel 에추가
		hotelButton.setBounds(680,0,200,100);
		hotelButton.setBorderPainted(false);
		hotelButton.setFont(new Font("Gothic", Font.BOLD, 20));
		upperMainPanel.add(hotelButton);

		//식당 버튼 옵션 설정 및 upperMainPanel 에추가
		restaurantButton.setBounds(880,0,200,100);
		restaurantButton.setBorderPainted(false);
		restaurantButton.setFont(new Font("Gothic", Font.BOLD, 20));
		upperMainPanel.add(restaurantButton);

		//측면 버튼 옵션 설정 및 프레임에  바로 추가
		openPanelButton = new JButton(openButtonBasicImage);
		openPanelButton.setBounds(1480, Main.SCREEN_HEIGHT/2-150, 20, 300);
		openPanelButton.setBorderPainted(false);
		openPanelButton.setFont(new Font("Gothic", Font.BOLD,5));
		add(openPanelButton);
		
	    enterMain();
	}
	public void enterMain()
	{
		repaint();
			NativeInterface.open();						//Javascript 와 웹브라우져 Swing 에 붙일 준비
			SwingUtilities.invokeLater(new Runnable() {	//Runnable 객체 생성 및 run 함수 실행
	    	public void run()
	    	{
			    createContent();						//mainMap 패널에 관련된 사항 초기화
			    add(mainMap);

				repaint();
	    	}
		 });
		NativeInterface.runEventPump();					//Runnable객체 연속적으로 실행(쓰래드) 및 내부 이벤트 처리를 모두 해줌
	}

	public void createContent() {
		//메인맵 기본 옵션 설정
		mainMap.setLayout(null);						
	    mainMap.setBounds(0,130,1500,700);	
	    mainMap.setBackground(new Color(255,200,0));
		
	    infoPanel = new DetailInfo();					//측면 패널 객체 선언 (DetailInfo.class)
		
		JPanel webBrowserPanel = new JPanel(new BorderLayout());		//웹브라우져를 출력할 패널 생성 및 선언
		webBrowserPanel.setBounds(20,0,1460,680);
	    final JWebBrowser webBrowser = new JWebBrowser();				//웹브라우져 객체 생성 및 선언
	    webBrowser.setBarsVisible(false);
	    webBrowser.setStatusBarVisible(true);
	    final String htmlContent =										//기본 html 코드 선언
	      "<html>" + LS +
	      "<head>" + LS +
	      "<style>\r\n"  + LS +
	      "body {background-image: url(\"https://www.asiaexchange.org/wp-content/uploads/2017/05/Seoul-destination-hero.jpg\");\r\n"  + LS +
	      "      background-repeat: no-repeat;\r\n"  + LS +
	      "      background-attachment: fixed;\r\n"  + LS +
	      "      background-position: right bottom;}\r\n"  + LS +
	      "table, td {background-color: transparent;} \r\n"  + LS + 
	      "</style>" + LS +
	      "	</head>" + LS +
	      "  <body>" + LS +
	      "   <div id = \"map\"> <font size=30, face = \"arial\", color = white> <center> Click Search Button to start </center></font></div>" + LS +
	      "  </body>" + LS +
	      "</html>";
	    webBrowser.setHTMLContent(htmlContent);
	    webBrowserPanel.add(webBrowser);
	    
	    //측면 패널 오픈 버튼 이벤트 추가
	    openPanelButton.addMouseListener(new MouseAdapter()
		{
	    	public void mouseEntered(MouseEvent e)
	    	{
	    		if(panelOpenedFlag == false)								//오픈 되어있지 않을때
				{
	    			openPanelButton.setIcon(openButtonEnteredImage);		//패널이 오픈 되어있지 않은 이미지의 Hover이미지 출력
				}
				else if(panelOpenedFlag == true)							//오픈 되어있을때
				{
	    			openPanelButton.setIcon(openedButtonEnteredImage);		//오픈된 이미지의 Hover 이미지 출력
				}
	    	}
	    	public void mouseExited(MouseEvent e)
	    	{
	    		if(panelOpenedFlag == false)								//오픈 되어있지 않을떄
				{
	    			openPanelButton.setIcon(openButtonBasicImage);			//패널이  오픈 되어있지 않은 이미지의 기본 이미지 출력
				}
				else if(panelOpenedFlag == true)							//오픈 되어있을 떄
				{
	    			openPanelButton.setIcon(openedButtonBasicImage);		//패널이  오픈된 싱태의 기본 이미지 출력
				}
	    	}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(panelOpenedFlag == false)								//클릭시 패널 오픈 및 기본 옵션 초기화
				{
					openPanelButton.setIcon(openedButtonBasicImage);
					webBrowserPanel.setBounds(20,0,1060,680);
					openPanelButton.setBounds(1080, Main.SCREEN_HEIGHT/2-150, 20, 300);
					panelOpenedFlag =true;
				}
				else if(panelOpenedFlag == true)							//클릭시 패널 닫고 기본 옵션 초기화
				{
					openPanelButton.setIcon(openButtonBasicImage);
					webBrowserPanel.setBounds(20,0,1460,680);
					openPanelButton.setBounds(1480, Main.SCREEN_HEIGHT/2-150, 20, 300);
					panelOpenedFlag =false;
				}
			}
		});
	    mainMap.add(webBrowserPanel);										//웹브라우져 패널 mainMap 패널에 추가
	    
	    //스크롤바 객체 기본 옵션 설정 및 mainMap 패널에 추가
	    scroll = new JScrollPane(infoPanel.getPanel());
	    scroll.setPreferredSize(new Dimension(400, 200));
	    scroll.setBounds(1100, 0, 380, 680);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    mainMap.add(scroll);

	    //검색 버튼 및 Text Field 를 담을 패널 객체 선언 및 기본 옵션 초기화
	    configurationPanel = new JPanel();
	    configurationPanel.setLayout(null);
	    configurationPanel.setBackground(new Color(255,200,0));
	    configurationPanel.setBounds(1080,25,420,50);
	    
	    //검색 버튼 기본 옵션 초기화
	    executeJavascriptButton = new JButton(searchButtonBasicImage);
	    executeJavascriptButton.setBorderPainted(false);
	    executeJavascriptButton.setBounds(20,0,50,50);
		executeJavascriptButton.setHorizontalAlignment(SwingConstants.CENTER);
		
		//TextField 기본옵션 초기화
	    placeInput = new JTextField("Seoul");
	    placeInput.setBounds(50+20,0,330,50);
	    placeInput.setBorder(null);
	    placeInput.setBackground(new Color(255,156,0));
	    placeInput.setFont(new Font("Gothic", Font.BOLD, 30));
	    
	    //병원 버튼 마우스 이벤트 추가
	    hospitalButton.addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e)
	    	{
	    		if(hospitalButton.isSelected()==false)
	    			hospitalButton.setIcon(hospitalButtonEnteredImage);
	    	}
	    	public void mouseExited(MouseEvent e)
	    	{
	    		if(hospitalButton.isSelected()==false)
	    			hospitalButton.setIcon(hospitalButtonBasicImage);	
	    	}
	    	public void mouseReleased(MouseEvent e)									//병원 버튼 클릭시
	    	{
	    		//병원버튼을 제외한 나머지 버튼들 옵션 설정
	    		roadButton.setSelected(false);
	    		roadButton.setIcon(roadButtonBasicImage);
	    		hotelButton.setSelected(false);
	    		hotelButton.setIcon(hotelButtonBasicImage);
	    		hospitalButton.setSelected(true);
	    		restaurantButton.setSelected(false);
	    		restaurantButton.setIcon(restaurantButtonBasicImage);
	    		hospitalButton.setIcon(hospitalButtonClickedImage);
	    		
	    		
	    		script.setMarker("Hospital",myLat, myLng);							//병원 버튼에 해당하는 javscript 코드 설정
				webBrowser.executeJavascript(script.getScript());					//javascript 코드 실행
				infoPanel.setDetailContents("Hospital", myLat, myLng);				//측면 패널에 병원에 관련된 정보 추가
				infoPanel.setLabelPos();											//측면 패널에 병원 관련 정보 출력
				repaint();
	    	}
	    });
	    //길 버튼 마우스 이벤트 추가
	    roadButton.addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e)	
	    	{
	    		if(roadButton.isSelected()==false)
	    			roadButton.setIcon(roadButtonEnteredImage);
	    	}
	    	public void mouseExited(MouseEvent e)
	    	{
	    		if(roadButton.isSelected()==false)
	    			roadButton.setIcon(roadButtonBasicImage);		
	    	}
	    	public void mouseReleased(MouseEvent e)									//길버튼 클릭시
	    	{
	    		//길버튼을 제외한 나머지 버튼들 옵션 설정
	    		roadButton.setSelected(true);
	    		hotelButton.setSelected(false);
	    		hotelButton.setIcon(hotelButtonBasicImage);
	    		hospitalButton.setSelected(false);
	    		hospitalButton.setIcon(hospitalButtonBasicImage);
	    		restaurantButton.setSelected(false);
	    		restaurantButton.setIcon(restaurantButtonBasicImage);
	    		roadButton.setIcon(roadButtonClickedImage);
	    		
	    		script.setMarker("Road",myLat, myLng);								//길 버튼에 해당하는 javscript 코드 설정
				webBrowser.executeJavascript(script.getScript());					//javascript 코드 실행
				infoPanel.setDetailContents("Road", myLat, myLng);					//측면 패널에 길에 관련된 정보 추가
				infoPanel.setLabelPos();											//측면 패널에 길 관련 정보 출력
				repaint();	
	    	}
	    });
	    
	    //식당 버튼 마우스 이벤트 추가
	    restaurantButton.addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e)
	    	{
	    		if(restaurantButton.isSelected()==false)
	    			restaurantButton.setIcon(restaurantButtonEnteredImage);
	    	}
	    	public void mouseExited(MouseEvent e)
	    	{
	    		if(restaurantButton.isSelected()==false)
	    			restaurantButton.setIcon(restaurantButtonBasicImage);	
	    	}
	    	public void mouseReleased(MouseEvent e)									//식당 버튼 클릭시
	    	{
	    		//식당 버튼을 제외한 나머지 버튼들 옵션 설정
	    		roadButton.setSelected(false);
	    		roadButton.setIcon(roadButtonBasicImage);
	    		hotelButton.setSelected(false);
	    		hotelButton.setIcon(hotelButtonBasicImage);
	    		hospitalButton.setSelected(false);
	    		hospitalButton.setIcon(hospitalButtonBasicImage);
	    		restaurantButton.setSelected(true);
	    		restaurantButton.setIcon(restaurantButtonClickedImage);
	    		
	    		script.setMarker("Restaurant",myLat, myLng);						//식당 버튼에 해당하는 javscript 코드 설정
				webBrowser.executeJavascript(script.getScript());					//javascript 코드 실행
				infoPanel.setDetailContents("Restaurant", myLat, myLng);			//측면 패널에 식당에 관련된 정보 추가
				infoPanel.setLabelPos();											//측면 패널에 식당 관련 정보 출력
				repaint();
	    	}
	    });
	    //호텔 버튼 마우스 이벤트 추가
	    hotelButton.addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e)
	    	{
	    		if(hotelButton.isSelected()==false)
	    			hotelButton.setIcon(hotelButtonEnteredImage);		
	    	}
	    	public void mouseExited(MouseEvent e)
	    	{
	    		if(hotelButton.isSelected()==false)
	    			hotelButton.setIcon(hotelButtonBasicImage);			
	    	}
	    	public void mouseReleased(MouseEvent e)
	    	{
	    		//호텔 버튼을 제외한 나머지 버튼들 옵션 설정
	    		roadButton.setSelected(false);
	    		roadButton.setIcon(roadButtonBasicImage);
	    		hotelButton.setSelected(true);
	    		hospitalButton.setSelected(false);
	    		hospitalButton.setIcon(hospitalButtonBasicImage);
	    		restaurantButton.setSelected(false);
	    		restaurantButton.setIcon(restaurantButtonBasicImage);
	    		hotelButton.setIcon(hotelButtonClickedImage);
	    		
	    		script.setMarker("Hotel",myLat, myLng);								//호텔 버튼에 해당하는 javscript 코드 설정
				webBrowser.executeJavascript(script.getScript());					//javascript 코드 실행
				infoPanel.setDetailContents("Hotel", myLat, myLng);					//측면 패널에 호텔에 관련된 정보 추가
				infoPanel.setLabelPos();											//측면 패널에 호텔 관련 정보 출력
				repaint();
	    	}
	    });
	  
	    //검색 버튼 마우스 이벤트 추가
	    executeJavascriptButton.addMouseListener(new MouseAdapter() {
	    	public void mouseEntered(MouseEvent e)
	    	{
	    		 executeJavascriptButton.setIcon(searchButtonEnteredImage);		
	    	}
	    	public void mouseExited(MouseEvent e)
	    	{
	    		 executeJavascriptButton.setIcon(searchButtonBasicImage);			
	    	}
	    	public void mouseReleased(MouseEvent e) {								//검색 버튼 클릭시
	    		
	    		//각 버튼 클릭 활성화
				hospitalButton.setEnabled(true);
				roadButton.setEnabled(true);
				restaurantButton.setEnabled(true);
				hotelButton.setEnabled(true);		
				openPanelButton.setEnabled(true);
				myLocation = placeInput.getText();
				
				geocoder = new Geocoder(myLocation);								//사용자 위도 경도 설정
				myLat = Double.parseDouble(geocoder.getLat());						//사용자 위도 가져오기
				myLng = Double.parseDouble(geocoder.getLng());						//사용자 경도 가져오기
				
				script = new Javascript();											//자바 스크립트 처리 클래스 객체 선언
				script.setMain(myLocation);											//자바 스크립트 기본 코드 설정
				
				webBrowser.executeJavascript(script.getScript());					//지도 설정
				infoPanel.setInitial();												//측면 패널 하얗게 초기화
				repaint();
	      }
	    });
	    
	    configurationPanel.add(placeInput);								//Text Field 패널에 추가
	    configurationPanel.add(executeJavascriptButton);				//검색 버튼 패널에 추가
	    upperMainPanel.add(configurationPanel);							//upperMainPanel 에 위의 추가된 패널을 추가
	    add(upperMainPanel);											//upperMainPanel 을 프레임에 추가
	}
}
