/**
 * DetailObject.class
 * @author 이상협, 김준혁, 조다은, 유혜인
 * 
 * 최종 작성일: 2017년 10월 25일
 * 최종 수정일: 2017년 12월 7일
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

public class DetailObject {
	private JButton detailButton;														//DetailInfo.class의 패널(GuideToSeoul.class의 측면 패널)에 들어갈 버튼 객체 생성
	private JLabel name;																//이름 객체 생성
	private JLabel address;																//주소 객체 생성
	private JLabel details;																//세부 정보 객체 생성
	private CloneDetailFrame cloneFrame;												//버튼 클릭시 새로운 프레임을 생성하기 위한 객체 생성
	
	public DetailObject() {
		detailButton = new JButton();													//버튼 초기화
		detailButton.setPreferredSize(new Dimension(200,120));							//버튼 사이즈 설정
		name = new JLabel();
		address = new JLabel();
		details = new JLabel();
	}
	public DetailObject(String option, String name, String address, String details, int index, double distance) {
		
		detailButton = new JButton();
		detailButton.setLayout(new BorderLayout());										//버튼 layout 설정
		detailButton.setPreferredSize(new Dimension(200,120));							//버튼 사이즈 설정
		this.name = new JLabel(name);													//이름 Label 선언 및 옵션 설정
		this.name.setFont(new Font("Gothic", Font.BOLD, 20));
		this.address = new JLabel(address);												//주소 라벨 설정
		this.details = new JLabel(details);												//세부정보 라벨 설정
		detailButton.setBackground(new Color(255,248,230));
		
		detailButton.add(BorderLayout.NORTH,this.name);									//이름 버튼 상단 배치
		detailButton.add(BorderLayout.CENTER,this.address);								//주소 버튼 중앙 배치
		detailButton.add(BorderLayout.SOUTH,this.details);								//세부정보 버튼 하단 배치
		detailButton.addMouseListener(new MouseAdapter(){								//버튼 마우스 이벤트 추가
				
				public void mouseEntered(MouseEvent e)
				{
					detailButton.setBackground(Color.orange);							//버튼 Hover시 컬러 변화
				}
				public void mouseExited(MouseEvent e)
				{
					detailButton.setBackground(new Color(255,248,230));	
				}
				@Override
				public void mouseReleased(MouseEvent e)
				{
					new CloneDetailFrame(option, index, distance);						//버튼 클릭시 세부 정보frame 생성 
				}
		});
	}
	public JButton getDetailButton() {													//버튼 반환
		return detailButton;
	}
	public JLabel getName() {															//이름 반환
		return name;
	}
	public JLabel getAddress() {														//주소 반환
		return address;
	}
	public JLabel getDetails() {														//세부정보 반환
		return details;
	}
	public void setName(String name) {													//이름 설정
		this.name.setText(name);
		this.name.setFont(new Font("Gothic", Font.BOLD, 20));
	}
	public void setAddress(String address) {											//주소 설정
		this.address.setText(address);
		this.address.setFont(new Font("Gothic", Font.BOLD, 14));
	}
	public void setDetails(String details) {											//세부정보 설정
		this.details.setText(details);
		this.details.setFont(new Font("Gothic", Font.BOLD, 14));
	}
}
