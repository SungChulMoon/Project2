package UserInterface;

import weatherCodination.*;
//날씨에 getnowweatherParsed에 매개변수로 아이디를 넣어 비교하여 마지막 것을 가져오게한다
//

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.awt.*;

import org.sqlite.core.DB;

import InnerClass.DBmethod;
import InnerClass.LineChartEx2;
import InnerClass.UserObject;
import InnerClass.Now;
import InnerClass.nowWeather;
import InnerClass.Location;
import InnerClass.tipObject;

/**
 * 유저들의 정보를 읽어오고 현재날씨 와 예상날씨를 매칭을하여 Display하는 클래스
 * 
 * @author Moon light
 * @see JFrame
 */
public class Main extends JFrame {
	ImageIcon Icon_search = new ImageIcon("img/search.PNG");
	ImageIcon Icon_refresh = new ImageIcon("img/refresh.PNG");
	LineChartEx2 ex;
	ImageIcon weatherIcon;
	ImageIcon weatherIcon2;
	private JPanel contentPane;
	private JTextField tf_local;
	private JLabel la_tip0;
	private JLabel la_tip1;
	private JLabel la_tip2;
	private JLabel la_weather1;
	private JLabel la_weather3;
	private JLabel la_weather2;
	private JLabel lb_local;
	nowWeather nowinfo;
	codiDisplay ts;
	UserObject us;
	String location = "";
	String weather = "";
	String weather2 = "";
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lb_now_weather;
	private JPanel panel_forecast;
	private JPanel panel_style;
	ArrayList<tipObject> toarr = null;
	tiplink tl1;
	tiplink tl2;
	tiplink tl3;

	public Main(String id) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/Icon.png");
		setIconImage(img);

		setTitle("웨더리쉬");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 1150, 1110);
		Location sl = new Location();
		try {
			us = DBmethod.getUserinfo(id);
			sl.setlocal(us.getLocation());
			sl.joinThread();
			System.out.println("현재 메인" + sl.getResult());
			Now.addParsingNowWeather();

			nowinfo = DBmethod.getNowweatherParsed();
			System.out.println("현재온도 " + nowinfo.getTemp());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ImageIcon Icon_back_main = new ImageIcon("img/lb_back_main.png");
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Rectangle r = getVisibleRect();
				g.drawImage(Icon_back_main.getImage(), 0, 0, r.width, r.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		setResizable(false);

		contentPane.setLayout(null);
		setContentPane(contentPane);

		tf_local = new JTextField();
		tf_local.setFont(new Font("굴림", Font.PLAIN, 24));
		tf_local.setBounds(110, 55, 905, 40);
		contentPane.add(tf_local);
		tf_local.setColumns(10);

		JButton btn_search = new JButton(Icon_search);
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sl.stopThread();
				if (tf_local.getText().equals("광주")) {
					location = "Gwangju";
				} else if (tf_local.getText().equals("서울")) {
					location = "Seoul";
				} else if (tf_local.getText().equals("부산")) {
					location = "Busan";
				} else {
					location = tf_local.getText();
				}
				sl.setlocal(location);

				try {
					sl.joinThread();
					Now.addParsingNowWeather();
					nowinfo = DBmethod.getNowweatherParsed();
					lb_local.setText("지역 : " + nowinfo.getLocation());
					System.out.println("새로 검색된 지역" + nowinfo.getLocation());
					la_weather1.setText("현재기온 : " + nowinfo.getTemp());
					la_weather2.setText("최저 기온 : " + nowinfo.getMaxtemp());
					la_weather3.setText("최고 기온 : " + nowinfo.getMintemp());
					lb_now_weather.setText("현재 날씨 : " + nowinfo.getMain());
					setphoto(nowinfo.getMain());

					// ex.removeAll();
					panel_forecast.remove(ex);

					ex = new LineChartEx2();
					panel_forecast.add(ex);
					panel_forecast.repaint();

					weatherIcon = new ImageIcon(weather);
					weatherIcon2 = new ImageIcon(weather2);

					ts.removeAll();
					ts = new codiDisplay(us.getGender(), id, nowinfo.getTemp(), us.getSty_str(), us.getSty_size(),us.getBody());
					ts.setBounds(17, 723, 1090, 279);
					ts.setOpaque(false);
					contentPane.add(ts);
					ts.repaint();

					toarr.clear();
					toarr = DBmethod.selecttip(nowinfo.getMain());

					la_tip0.removeMouseListener(tl1);
					la_tip1.removeMouseListener(tl2);
					la_tip2.removeMouseListener(tl3);

					tl1 = new tiplink(toarr.get(toarr.size() - 3));
					tl2 = new tiplink(toarr.get(toarr.size() - 2));
					tl3 = new tiplink(toarr.get(toarr.size() - 1));

					la_tip0.setText(toarr.get(toarr.size() - 3).getTip());
					System.out.println(toarr.get(toarr.size() - 3).getTip());
					la_tip0.addMouseListener(tl1);
					la_tip1.setText(toarr.get(toarr.size() - 2).getTip());
					la_tip1.addMouseListener(tl2);
					la_tip2.setText(toarr.get(toarr.size() - 1).getTip());
					la_tip2.addMouseListener(tl3);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
		});
		
		btn_search.setBackground(Color.WHITE);
		btn_search.setBounds(1050, 45, 40, 40);
		contentPane.add(btn_search);

		try {
			toarr = DBmethod.selecttip(nowinfo.getMain());

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		tl1 = new tiplink(toarr.get(toarr.size() - 3));
		tl2 = new tiplink(toarr.get(toarr.size() - 2));
		tl3 = new tiplink(toarr.get(toarr.size() - 1));
		la_tip0 = new JLabel(toarr.get(toarr.size() - 3).getTip());
		la_tip1 = new JLabel(toarr.get(toarr.size() - 2).getTip());
		la_tip2 = new JLabel(toarr.get(toarr.size() - 1).getTip());

		la_tip0.setFont(new Font("굴림", Font.PLAIN, 20));
		la_tip1.setFont(new Font("굴림", Font.PLAIN, 20));
		la_tip2.setFont(new Font("굴림", Font.PLAIN, 20));
		la_tip0.setBackground(Color.WHITE);
		la_tip1.setBackground(Color.WHITE);
		la_tip2.setBackground(Color.WHITE);
		la_tip0.setBounds(65, 565, 930, 40);
		la_tip1.setBounds(65, 620, 930, 40);
		la_tip2.setBounds(65, 675, 930, 40);
		la_tip0.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		la_tip1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		la_tip2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		la_tip0.addMouseListener(tl1);
		la_tip1.addMouseListener(tl2);
		la_tip2.addMouseListener(tl3);
		contentPane.add(la_tip0);
		contentPane.add(la_tip1);
		contentPane.add(la_tip2);

		System.out.println(nowinfo.getMain());
		setphoto(nowinfo.getMain());

		weatherIcon = new ImageIcon(weather);
		weatherIcon2 = new ImageIcon(weather2);
		la_weather1 = new JLabel("현재온도 : ");
		la_weather2 = new JLabel("최저 기온 : ");
		la_weather3 = new JLabel("최고 기온 : ");
		lb_local = new JLabel("지역 : ");
		lb_now_weather = new JLabel("현재 날씨 : ");
		la_weather1.setFont(new Font("굴림", Font.PLAIN, 23));
		la_weather2.setFont(new Font("굴림", Font.PLAIN, 23));
		la_weather3.setFont(new Font("굴림", Font.PLAIN, 23));
		lb_local.setFont(new Font("굴림", Font.PLAIN, 25));
		lb_now_weather.setFont(new Font("굴림", Font.PLAIN, 25));
		la_weather1.setBounds(40, 130, 150, 65);
		la_weather2.setBounds(195, 130, 150, 65);
		la_weather3.setBounds(345, 130, 150, 65);
		lb_local.setBounds(110, 100, 230, 30);
		lb_now_weather.setBounds(40, 200, 230, 25);
		contentPane.add(la_weather1);
		contentPane.add(la_weather2);
		contentPane.add(la_weather3);
		contentPane.add(lb_local);
		contentPane.add(lb_now_weather);

		lb_local.setText("지역 : " + nowinfo.getLocation());
		la_weather1.setText("현재기온 : " + nowinfo.getTemp());
		la_weather2.setText("최저 기온 : " + nowinfo.getMaxtemp());
		la_weather3.setText("최고 기온 : " + nowinfo.getMintemp());
		lb_now_weather.setText("현재 날씨 : " + nowinfo.getMain());

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(weatherIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			}
		};
		
		
		JButton btn_back = new JButton(new ImageIcon("img/lb_back.png"));
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(33, 50, 51, 51);
		contentPane.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
				
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});

		panel.setBounds(40, 250, 200, 200);
		contentPane.add(panel);

		panel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(weatherIcon2.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
			}
		};
		panel_1.setBounds(286, 250, 200, 200);
		contentPane.add(panel_1);

		panel_forecast = new JPanel();
		panel_forecast.setBounds(495, 126, 633, 442);
		contentPane.add(panel_forecast);
		ex = new LineChartEx2();
		panel_forecast.add(ex);
		panel_forecast.setOpaque(false);

		ts = new codiDisplay(us.getGender(), id, nowinfo.getTemp(), us.getSty_str(), us.getSty_size(),us.getBody());
		System.out.println(us.getGender());
		ts.setBounds(17, 723, 1090, 279);
		ts.setOpaque(false);
		contentPane.add(ts);
		
		JLabel lb_id = new JLabel("");
		lb_id.setText(us.getName()+" 님 환영합니다.");
		lb_id.setFont(new Font("굴림", Font.PLAIN, 25));
		lb_id.setBounds(390, 20, 380, 25);
		contentPane.add(lb_id);
		
		JButton btn_userinfo = new JButton(new ImageIcon("img/btn_main_user.png"));
		btn_userinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfomation uif = new UserInfomation(us);
				uif.setVisible(true);
				dispose();
			}
		});
		btn_userinfo.setBounds(845, 20, 170, 30);
		contentPane.add(btn_userinfo);

		btn_back.setBorderPainted(false);
		btn_search.setBorderPainted(false);
	}

	public void setphoto(String main) {
		switch (nowinfo.getMain()) {
		case "Clear":
			weather = "img/sun1.png";
			weather2 = "img/sun2.png";
			break;
		case "Rain":
		case "Drizzle":
			weather = "img/rain1.png";
			weather2 = "img/rain2.png";
			break;
		case "Mist":
		case "Haze":
		case "Fog":
			weather = "img/fog1.png";
			weather2 = "img/fog2.png";
			break;
		case "Clouds":
			weather = "img/cloudy1.png";
			weather2 = "img/cloudy2.png";
			break;
		case "Lightning":
		case "Thunderstorm":
			weather = "img/thunder1.png";
			weather2 = "img/thunder2.png";
			break;
		case "Snow":
			weather = "img/snow1.png";
			weather2 = "img/snow2.png";
			break;
		default:
			weather = "img/sun1.png";
			weather = "img/sun2.png";
			break;
		}
	}
}

class tiplink extends MouseAdapter {
	tipObject to;

	public tiplink(tipObject to) {
		this.to = to;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() > 0) {
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				try {
					URI uri = new URI(to.getLink());
					desktop.browse(uri);
				} catch (IOException ex) {
					ex.printStackTrace();
				} catch (URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
