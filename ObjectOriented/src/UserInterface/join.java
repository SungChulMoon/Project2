package UserInterface;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import InnerClass.DBmethod;
/**
 * 유저들의 정보를 입력받아 DB로 보내고 저장시키는 GUI클래스
 * @author Moon light
 *	@see JFrame
 */
public class join extends JFrame {
	String gender="여자";
	String location="";
	int cnt = 0;
	String checkbody = "여자1";
	ImageIcon Icon_w0 = new ImageIcon("img/w_body0.png");
	ImageIcon Icon_w1 = new ImageIcon("img/w_body1.png");
	ImageIcon Icon_w2 = new ImageIcon("img/w_body2.png");
	ImageIcon Icon_w3 = new ImageIcon("img/w_body3.png");
	ImageIcon Icon_m0 = new ImageIcon("img/m_body0.png");
	ImageIcon Icon_m1 = new ImageIcon("img/m_body1.png");
	ImageIcon Icon_m2 = new ImageIcon("img/m_body2.png");
	ImageIcon Icon_m3 = new ImageIcon("img/m_body3.png");
	ImageIcon Icon_id = new ImageIcon("img/lb_join_id.png");
	ImageIcon Icon_name = new ImageIcon("img/lb_join_name.png");
	ImageIcon Icon_pass = new ImageIcon("img/lb_join_pass.png");
	ImageIcon Icon_passcheck = new ImageIcon("img/lb_join_passcheck.png");
	ImageIcon Icon_local = new ImageIcon("img/lb_join_local.png");
	ImageIcon Icon_gender = new ImageIcon("img/lb_join_gender.png");
	ImageIcon Icon_style = new ImageIcon("img/lb_join_style.png");
	ImageIcon Icon_back_join = new ImageIcon("img/lb_back_join.png");
	ImageIcon Icon_btn_join_join = new ImageIcon("img/btn_join_join.png");
	ImageIcon Icon_btn_check = new ImageIcon("img/btn_check.png");
	
	JRadioButton rd_body0 = new JRadioButton(Icon_w0, true);
	JRadioButton rd_body1 = new JRadioButton(Icon_w1);
	JRadioButton rd_body2 = new JRadioButton(Icon_w2);
	JRadioButton rd_body3 = new JRadioButton(Icon_w3);
	JRadioButton rd_m_body0 = new JRadioButton(Icon_m0, true);
	JRadioButton rd_m_body1 = new JRadioButton(Icon_m1, true);
	JRadioButton rd_m_body2 = new JRadioButton(Icon_m2, true);
	JRadioButton rd_m_body3 = new JRadioButton(Icon_m3, true);
	
	ArrayList<String> arrID = new ArrayList<>();
	
	boolean checkID = false;
	boolean checkjoin = false;
	
	private JPanel contentPane;
	private JTextField tf_join_id;
	private JTextField tf_join_name;
	private JPasswordField tf_join_pass;
	private JPasswordField tf_join_passcheck;
	private JTextField tf_join_local;
	public ArrayList<String> checkStly = new ArrayList<>();
	public JCheckBox cb_style0 = new JCheckBox("시크");
	public JCheckBox cb_style1 = new JCheckBox("큐티");
	public JCheckBox cb_style2 = new JCheckBox("섹시");
	public JCheckBox cb_style3 = new JCheckBox("빈티지");
	
	public join() {
		setTitle("웨더리쉬");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 720, 800);
		setResizable(false);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/Icon.png");
		setIconImage(img);
		
		contentPane = new JPanel(){
			public void paintComponent(Graphics g) {
				Rectangle r = getVisibleRect();
				g.drawImage(Icon_back_join.getImage(), 0, 0, r.width, r.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lb_join_id = new JLabel(Icon_id);
		JLabel lb_join_name = new JLabel(Icon_name);
		JLabel lb_join_pass = new JLabel(Icon_pass);
		JLabel lb_join_passcheck = new JLabel(Icon_passcheck);
		JLabel lb_join_local = new JLabel(Icon_local);
		JLabel lb_join_gender = new JLabel(Icon_gender);
		JLabel lb_join_style = new JLabel(Icon_style);
		JLabel lb_equal = new JLabel("불일치");
		tf_join_id = new JTextField();
		tf_join_name = new JTextField();
		tf_join_pass = new JPasswordField();
		tf_join_passcheck = new JPasswordField();
		tf_join_local = new JTextField();
		JRadioButton rd_woman = new JRadioButton("여자", true);
		JRadioButton rd_man = new JRadioButton("남자");
		JButton btn_back = new JButton(new ImageIcon("img/lb_back.png"));
		JButton btn_join = new JButton(Icon_btn_join_join);
		JButton btn_check = new JButton(Icon_btn_check);

		rd_body0.addItemListener(new bodyItemcheck());
		rd_body1.addItemListener(new bodyItemcheck());
		rd_body2.addItemListener(new bodyItemcheck());
		rd_body3.addItemListener(new bodyItemcheck());
		rd_m_body0.addItemListener(new bodyItemcheck());
		rd_m_body1.addItemListener(new bodyItemcheck());
		rd_m_body2.addItemListener(new bodyItemcheck());
		rd_m_body3.addItemListener(new bodyItemcheck());
		cb_style0.addItemListener(new itemListen());
		cb_style1.addItemListener(new itemListen());
		cb_style2.addItemListener(new itemListen());
		cb_style3.addItemListener(new itemListen());
		ButtonGroup g = new ButtonGroup();
		ButtonGroup g_woman = new ButtonGroup();
		ButtonGroup g_man = new ButtonGroup();

		lb_join_id.setBounds(120, 35, 130, 50);
		lb_join_name.setBounds(120, 95, 130, 50);
		lb_join_pass.setBounds(120, 155, 130, 50);
		lb_join_passcheck.setBounds(120, 215, 155, 50);
		lb_join_local.setBounds(120, 275, 130, 50);
		lb_join_gender.setBounds(135, 335, 100, 50);
		lb_join_style.setBounds(120, 570, 114, 50);
		lb_equal.setBounds(590, 225, 65, 20);
		tf_join_id.setBounds(275, 35, 290, 40);
		tf_join_name.setBounds(275, 95, 290, 40);
		tf_join_pass.setBounds(275, 155, 290, 40);
		tf_join_passcheck.setBounds(275, 215, 290, 40);
		tf_join_local.setBounds(275, 275, 290, 40);
		cb_style0.setBounds(250, 580, 130, 30);
		cb_style1.setBounds(430, 580, 130, 30);
		cb_style2.setBounds(250, 625, 130, 30);
		cb_style3.setBounds(430, 625, 130, 30);
		rd_body0.setBounds(250, 405, 75, 150);
		rd_body1.setBounds(340, 405, 75, 150);
		rd_body2.setBounds(430, 405, 75, 150);
		rd_body3.setBounds(520, 405, 90, 150);
		rd_m_body0.setBounds(250, 405, 75, 150);
		rd_m_body1.setBounds(340, 405, 75, 150);
		rd_m_body2.setBounds(430, 405, 75, 150);
		rd_m_body3.setBounds(520, 405, 90, 150);

		rd_woman.setBounds(270, 345, 100, 30);
		rd_man.setBounds(430, 345, 100, 30);
		btn_join.setBounds(120, 675, 440, 51);
		btn_check.setBounds(580, 35, 105, 40);
		btn_back.setBounds(33, 33, 51, 51);
		
		tf_join_id.setColumns(10);
		tf_join_name.setColumns(10);
		tf_join_pass.setColumns(10);
		tf_join_passcheck.setColumns(10);
		tf_join_local.setColumns(10);
		
		cb_style0.setFont(new Font("고딕", Font.BOLD, 17));
		cb_style1.setFont(new Font("고딕", Font.BOLD, 17));
		cb_style2.setFont(new Font("고딕", Font.BOLD, 17));
		cb_style3.setFont(new Font("고딕", Font.BOLD, 17));
		rd_woman.setFont(new Font("고딕", Font.PLAIN, 20));
		rd_man.setFont(new Font("굴림", Font.PLAIN, 20));
		
		cb_style0.setBackground(Color.WHITE);
		cb_style1.setBackground(Color.WHITE);
		cb_style2.setBackground(Color.WHITE);
		cb_style3.setBackground(Color.WHITE);
		rd_body0.setBackground(Color.WHITE);
		rd_body1.setBackground(Color.WHITE);
		rd_body2.setBackground(Color.WHITE);
		rd_body3.setBackground(Color.WHITE);
		rd_m_body0.setBackground(Color.WHITE);
		rd_m_body1.setBackground(Color.WHITE);
		rd_m_body2.setBackground(Color.WHITE);
		rd_m_body3.setBackground(Color.WHITE);
		rd_woman.setBackground(Color.WHITE);
		rd_man.setBackground(Color.WHITE);

		lb_equal.setForeground(Color.RED);
		cb_style0.setForeground(new Color(5, 97, 232));
		cb_style1.setForeground(new Color(5, 97, 232));
		cb_style2.setForeground(new Color(5, 97, 232));
		cb_style3.setForeground(new Color(5, 97, 232));
		rd_woman.setForeground(new Color(5, 97, 232));
		rd_man.setForeground(new Color(5, 97, 232));

		btn_back.setBorderPainted(false);
		rd_body0.setBorderPainted(true);
		rd_body1.setBorderPainted(true);
		rd_body2.setBorderPainted(true);
		rd_body3.setBorderPainted(true);
		rd_m_body0.setBorderPainted(true);
		rd_m_body1.setBorderPainted(true);
		rd_m_body2.setBorderPainted(true);
		rd_m_body3.setBorderPainted(true);
		
		g.add(rd_man);
		g.add(rd_woman);
		g_woman.add(rd_body0);
		g_woman.add(rd_body1);
		g_woman.add(rd_body2);
		g_woman.add(rd_body3);
		g_man.add(rd_m_body0);
		g_man.add(rd_m_body1);
		g_man.add(rd_m_body2);
		g_man.add(rd_m_body3);


		rd_m_body0.setVisible(false);
		rd_m_body1.setVisible(false);
		rd_m_body2.setVisible(false);
		rd_m_body3.setVisible(false);
		rd_woman.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (rd_woman.isSelected()) {
					cb_style2.setText("섹시");
					gender = "여자";
					rd_m_body0.setVisible(false);
					rd_m_body1.setVisible(false);
					rd_m_body2.setVisible(false);
					rd_m_body3.setVisible(false);

					rd_body0.setVisible(true);
					rd_body1.setVisible(true);
					rd_body2.setVisible(true);
					rd_body3.setVisible(true);
				}

			}
		});

		rd_man.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (rd_man.isSelected()) {
					cb_style2.setText("댄디");
					
					gender = "남자";
					rd_m_body0.setVisible(true);
					rd_m_body1.setVisible(true);
					rd_m_body2.setVisible(true);
					rd_m_body3.setVisible(true);

					rd_body0.setVisible(false);
					rd_body1.setVisible(false);
					rd_body2.setVisible(false);
					rd_body3.setVisible(false);
				}

			}
		});

		lb_equal.setFont(new Font("고딕", Font.PLAIN, 18));
		btn_join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tf_join_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!checkID) {
					JOptionPane.showMessageDialog(null, "아이디 중복검사 해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (tf_join_name.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (tf_join_pass.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else if(tf_join_local.getText().equals("")) {
				
					JOptionPane.showMessageDialog(null, "지역를 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else if ((!cb_style0.isSelected()) && (!cb_style1.isSelected()) && (!cb_style2.isSelected())
						&& (!cb_style3.isSelected())) {
					JOptionPane.showMessageDialog(null, "스타일을 하나라도 선택해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if (tf_join_pass.getText().equals(tf_join_passcheck.getText())) {
						if(tf_join_local.getText().equals("광주")) {
							location ="Gwangju";
						}
						else if(tf_join_local.getText().equals("서울")) {
							location = "Seoul";
						}
						else if(tf_join_local.getText().equals("부산")) {
							location ="Busan";
						}
						lb_equal.setText("일치");
						lb_equal.setForeground(Color.GREEN);
						String style_str1 = "";
						for (int i = 0; i < checkStly.size(); i++) {
							style_str1 += "," + checkStly.get(i);
						}
						String style_str = style_str1.substring(1);
						System.out.println(style_str);
						try {
							System.out.println(gender);
							if (DBmethod.addUserInfo(tf_join_id.getText(), tf_join_pass.getText(), tf_join_name.getText(),
									location,gender, checkbody, style_str, Integer.toString(cnt)) > 0) {
								JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.", "회원가입이 완료되었습니다.",
										JOptionPane.INFORMATION_MESSAGE);
								dispose();
								Login login = new Login();
								login.setVisible(true);
							}

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						// 체크박스 체크된 갯수와 체크된 스트링을 얻어서 ,로 붙여서 디비에 추가
					} else {
						lb_equal.setText("불일치");
						lb_equal.setForeground(Color.RED);
						JOptionPane.showMessageDialog(null, "확인 비밀번호가 불일치 입니다.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});


		btn_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					arrID = DBmethod.getUserId();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (arrID.contains(tf_join_id.getText())) {
					checkID = false;

				} else {
					checkID = true;

				}

				if (checkID) {
					JOptionPane.showMessageDialog(null, "사용가능한 아이디 입니다.", "사용가능한 아이디 입니다.",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.", "중복된 아이디 입니다.", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	
		System.out.println(cnt + "");
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(lb_join_id);
		contentPane.add(lb_join_name);
		contentPane.add(lb_join_pass);
		contentPane.add(lb_join_passcheck);
		contentPane.add(lb_join_local);
		contentPane.add(lb_join_gender);
		contentPane.add(lb_join_style);
		contentPane.add(lb_equal);
		contentPane.add(tf_join_id);
		contentPane.add(tf_join_name);
		contentPane.add(tf_join_pass);
		contentPane.add(tf_join_passcheck);
		contentPane.add(tf_join_local);
		contentPane.add(cb_style0);
		contentPane.add(cb_style1);
		contentPane.add(cb_style2);
		contentPane.add(cb_style3);
		contentPane.add(rd_body0);
		contentPane.add(rd_body1);
		contentPane.add(rd_body2);
		contentPane.add(rd_body3);
		contentPane.add(rd_m_body0);
		contentPane.add(rd_m_body1);
		contentPane.add(rd_m_body2);
		contentPane.add(rd_m_body3);
		contentPane.add(rd_woman);
		contentPane.add(rd_man);
		contentPane.add(btn_join);
		contentPane.add(btn_check);
		contentPane.add(btn_back);
	}

	class itemListen implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == cb_style0) {
					cnt++;
					checkStly.add(cb_style0.getText());
				} else if (e.getItem() == cb_style1) {
					cnt++;
					checkStly.add(cb_style1.getText());
				} else if (e.getItem() == cb_style2) {
					cnt++;
					checkStly.add(cb_style2.getText());
				} else if (e.getItem() == cb_style3) {
					cnt++;
					checkStly.add(cb_style3.getText());
				}
			} else {
				if (e.getItem() == cb_style0) {
					cnt--;
					checkStly.remove(cb_style0.getText());
				} else if (e.getItem() == cb_style1) {
					cnt--;
					checkStly.remove(cb_style1.getText());
				} else if (e.getItem() == cb_style2) {
					cnt--;
					checkStly.remove(cb_style2.getText());
				} else if (e.getItem() == cb_style3) {
					cnt--;
					checkStly.remove(cb_style3.getText());
				}
			}
			System.out.println(cnt + "");
			for (int i = 0; i < checkStly.size(); i++) {
				System.out.println(checkStly.get(i));
			}
		}
	}

	class bodyItemcheck implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == rd_body0) {
					checkbody = "여자0";
				} else if (e.getItem() == rd_body1) {
					checkbody = "여자1";
				} else if (e.getItem() == rd_body2) {
					checkbody = "여자2";
				} else if (e.getItem() == rd_body3) {
					checkbody = "여자3";
				} else if (e.getItem() == rd_m_body0) {
					checkbody = "남자0";
				} else if (e.getItem() == rd_m_body1) {
					checkbody = "남자1";
				} else if (e.getItem() == rd_m_body2) {
					checkbody = "남자2";
				} else if (e.getItem() == rd_m_body3) {
					checkbody = "남자3";
				}
			}
			System.out.println(checkbody);
		}
	}
}