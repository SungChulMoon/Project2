package UserInterface;
import javax.swing.*;
import java.awt.event.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.border.EmptyBorder;

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
	JRadioButton rd_body0 = new JRadioButton(Icon_w0, true);
	JRadioButton rd_body1 = new JRadioButton(Icon_w1);
	JRadioButton rd_body2 = new JRadioButton(Icon_w2);
	JRadioButton rd_body3 = new JRadioButton(Icon_w3);
	ImageIcon Icon_m0 = new ImageIcon("img/m_body0.png");
	ImageIcon Icon_m1 = new ImageIcon("img/m_body1.png");
	ImageIcon Icon_m2 = new ImageIcon("img/m_body2.png");
	ImageIcon Icon_m3 = new ImageIcon("img/m_body3.png");
	JRadioButton rd_m_body0 = new JRadioButton(Icon_m0, true);
	JRadioButton rd_m_body1 = new JRadioButton(Icon_m1, true);
	JRadioButton rd_m_body2 = new JRadioButton(Icon_m2, true);
	JRadioButton rd_m_body3 = new JRadioButton(Icon_m3, true);
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
	ArrayList<String> arrID = new ArrayList<>();
	boolean checkID = false;
	private JPanel contentPane;
	private JTextField tf_name_id;
	private JTextField tf_name_join;
	private JPasswordField tf_pass;
	private JPasswordField tf_checkpass;
	public ArrayList<String> checkStly = new ArrayList<>();
	public JCheckBox cb_style0 = new JCheckBox("시크");
	public JCheckBox cb_style1 = new JCheckBox("큐티");
	public JCheckBox cb_style2 = new JCheckBox("섹시");
	public JCheckBox cb_style3 = new JCheckBox("빈티지");
	private JTextField tf_local_join;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public join() {
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/Icon.png");
		setIconImage(img);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 720, 800);
		setTitle("웨더리쉬");
		setResizable(false);

		contentPane = new JPanel(){
			public void paintComponent(Graphics g) {
				Rectangle r = getVisibleRect();
				g.drawImage(Icon_back_join.getImage(), 0, 0, r.width, r.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel(Icon_id);
		lblNewLabel.setBounds(120, 33, 128, 52);
		lblNewLabel.setForeground(new Color(5, 97, 232));
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel(Icon_name);
		label.setForeground(new Color(5, 97, 232));
		label.setBounds(120, 96, 128, 52);
		contentPane.add(label);

		JLabel label_1 = new JLabel(Icon_pass);
		label_1.setForeground(new Color(5, 97, 232));
		label_1.setBounds(120, 159, 128, 52);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel(Icon_passcheck);
		label_2.setForeground(new Color(5, 97, 232));
		label_2.setBounds(120, 222, 155, 52);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel(Icon_gender);
		label_3.setForeground(new Color(5, 97, 232));
		label_3.setBounds(135, 343, 100, 51);
		contentPane.add(label_3);

		JLabel label_5 = new JLabel(Icon_local);
		label_5.setForeground(new Color(5, 97, 232));
		label_5.setBounds(120, 287, 128, 52);
		contentPane.add(label_5);
		
		tf_local_join = new JTextField();
		tf_local_join.setColumns(10);
		tf_local_join.setBounds(275, 295, 288, 37);
		contentPane.add(tf_local_join);
	
		
		tf_name_id = new JTextField();
		tf_name_id.setBounds(275, 41, 288, 37);
		contentPane.add(tf_name_id);
		tf_name_id.setColumns(10);

		tf_name_join = new JTextField();
		tf_name_join.setColumns(10);
		tf_name_join.setBounds(275, 100, 288, 37);
		contentPane.add(tf_name_join);

		tf_pass = new JPasswordField();
		tf_pass.setColumns(10);
		tf_pass.setBounds(275, 163, 288, 37);
		contentPane.add(tf_pass);

		tf_checkpass = new JPasswordField();
		tf_checkpass.setColumns(10);
		tf_checkpass.setBounds(275, 232, 288, 37);
		contentPane.add(tf_checkpass);

		ButtonGroup g = new ButtonGroup();
		ButtonGroup g_woman = new ButtonGroup();
		ButtonGroup g_man = new ButtonGroup();

		JLabel label_4 = new JLabel(Icon_style);
		label_4.setForeground(new Color(5, 97, 232));
		label_4.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		label_4.setBounds(120, 568, 124, 51);
		contentPane.add(label_4);

		cb_style0.setFont(new Font("나눔바른고딕", Font.BOLD, 17));
		cb_style0.setBackground(Color.WHITE);
		cb_style0.setBounds(250, 581, 131, 27);
		cb_style0.setForeground(new Color(5, 97, 232));
		contentPane.add(cb_style0);

		cb_style1.setFont(new Font("나눔바른고딕", Font.BOLD, 17));
		cb_style1.setForeground(new Color(5, 97, 232));
		cb_style1.setBackground(Color.WHITE);
		cb_style1.setBounds(429, 581, 131, 27);
		contentPane.add(cb_style1);

		cb_style2.setFont(new Font("나눔바른고딕", Font.BOLD, 17));
		cb_style2.setForeground(new Color(5, 97, 232));
		cb_style2.setBackground(Color.WHITE);
		cb_style2.setBounds(250, 633, 131, 27);
		contentPane.add(cb_style2);

		cb_style3.setFont(new Font("나눔바른고딕", Font.BOLD, 17));
		cb_style3.setForeground(new Color(5, 97, 232));
		cb_style3.setBackground(Color.WHITE);
		cb_style3.setBounds(429, 633, 131, 27);
		contentPane.add(cb_style3);

		rd_body0.addItemListener(new bodyItemcheck());
		rd_body1.addItemListener(new bodyItemcheck());
		rd_body2.addItemListener(new bodyItemcheck());
		rd_body3.addItemListener(new bodyItemcheck());

		rd_m_body0.addItemListener(new bodyItemcheck());
		rd_m_body1.addItemListener(new bodyItemcheck());
		rd_m_body2.addItemListener(new bodyItemcheck());
		rd_m_body3.addItemListener(new bodyItemcheck());
		rd_body0.setBackground(Color.WHITE);
		rd_body0.setBorderPainted(true);
		rd_body0.setBounds(252, 406, 75, 150);

		contentPane.add(rd_body0);

		rd_body1.setBackground(Color.WHITE);
		rd_body1.setBorderPainted(true);
		rd_body1.setBounds(341, 406, 75, 150);
		contentPane.add(rd_body1);

		rd_body2.setBackground(Color.WHITE);
		rd_body2.setBorderPainted(true);
		rd_body2.setBounds(430, 406, 75, 150);
		contentPane.add(rd_body2);

		rd_body3.setBackground(Color.WHITE);
		rd_body3.setBorderPainted(true);
		rd_body3.setBounds(519, 406, 90, 150);
		contentPane.add(rd_body3);
		g_woman.add(rd_body0);
		g_woman.add(rd_body1);
		g_woman.add(rd_body2);
		g_woman.add(rd_body3);

		rd_m_body0.setBackground(Color.WHITE);
		rd_m_body0.setBorderPainted(true);
		rd_m_body0.setBounds(252, 406, 75, 150);
		contentPane.add(rd_m_body0);

		rd_m_body1.setBorderPainted(true);
		rd_m_body1.setBackground(Color.WHITE);
		rd_m_body1.setBounds(341, 406, 75, 150);
		contentPane.add(rd_m_body1);

		rd_m_body2.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		rd_m_body2.setBackground(Color.WHITE);
		rd_m_body2.setBorderPainted(true);
		rd_m_body2.setBounds(430, 406, 75, 150);
		contentPane.add(rd_m_body2);

		rd_m_body3.setBackground(Color.WHITE);
		rd_m_body3.setBorderPainted(true);
		rd_m_body3.setBounds(519, 406, 90, 150);
		contentPane.add(rd_m_body3);
		g_man.add(rd_m_body0);
		g_man.add(rd_m_body1);
		g_man.add(rd_m_body2);
		g_man.add(rd_m_body3);
		rd_m_body0.setVisible(false);
		rd_m_body1.setVisible(false);
		rd_m_body2.setVisible(false);
		rd_m_body3.setVisible(false);
		JRadioButton rd_woman = new JRadioButton("\uC5EC\uC131", true);
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
		rd_woman.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		rd_woman.setForeground(new Color(5, 97, 232));
		rd_woman.setBackground(Color.WHITE);
		rd_woman.setBounds(250, 355, 93, 27);
		contentPane.add(rd_woman);

		JRadioButton rd_man = new JRadioButton("\uB0A8\uC131");
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
		rd_man.setBackground(Color.WHITE);
		rd_man.setFont(new Font("나눔바른고딕", Font.PLAIN, 20));
		rd_man.setForeground(new Color(5, 97, 232));
		rd_man.setBounds(429, 356, 93, 27);
		contentPane.add(rd_man);
		g.add(rd_man);
		g.add(rd_woman);

		JLabel jl_equal = new JLabel("불일치");
		jl_equal.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		jl_equal.setForeground(Color.RED);
		jl_equal.setBounds(588, 239, 62, 18);
		contentPane.add(jl_equal);
		boolean checkjoin = false;
		JButton btn_join = new JButton(Icon_btn_join_join);
		btn_join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tf_name_id.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!checkID) {
					JOptionPane.showMessageDialog(null, "아이디 중복검사 해주세요.", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (tf_name_join.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (tf_pass.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else if(tf_local_join.getText().equals("")) {
				
					JOptionPane.showMessageDialog(null, "지역를 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else if ((!cb_style0.isSelected()) && (!cb_style1.isSelected()) && (!cb_style2.isSelected())
						&& (!cb_style3.isSelected())) {
					JOptionPane.showMessageDialog(null, "스타일을 하나라도 선택해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if (tf_pass.getText().equals(tf_checkpass.getText())) {
						if(tf_local_join.getText().equals("광주")) {
							location ="Gwangju";
						}
						else if(tf_local_join.getText().equals("서울")) {
							location = "Seoul";
						}
						else if(tf_local_join.getText().equals("부산")) {
							location ="Busan";
						}
						jl_equal.setText("일치");
						jl_equal.setForeground(Color.GREEN);
						String style_str1 = "";
						for (int i = 0; i < checkStly.size(); i++) {
							style_str1 += "," + checkStly.get(i);
						}
						String style_str = style_str1.substring(1);
						System.out.println(style_str);
						try {
							System.out.println(gender);
							if (DBmethod.addUserInfo(tf_name_id.getText(), tf_pass.getText(), tf_name_join.getText(),
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
						jl_equal.setText("불일치");
						jl_equal.setForeground(Color.RED);
						JOptionPane.showMessageDialog(null, "확인 비밀번호가 불일치 입니다.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		btn_join.setForeground(new Color(5, 97, 232));
		btn_join.setFont(new Font("나눔바른고딕", Font.PLAIN, 19));
		btn_join.setBounds(120, 675, 440, 51);
		contentPane.add(btn_join);

		JButton btn_check = new JButton(Icon_btn_check);
		btn_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					arrID = DBmethod.getUserId();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (arrID.contains(tf_name_id.getText())) {
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
		btn_check.setFont(new Font("나눔바른고딕", Font.PLAIN, 18));
		btn_check.setBounds(570, 46, 105, 27);
		btn_check.setForeground(new Color(5, 97, 232));
		contentPane.add(btn_check);
		
	
		cb_style0.addItemListener(new itemListen());
		cb_style1.addItemListener(new itemListen());
		cb_style2.addItemListener(new itemListen());
		cb_style3.addItemListener(new itemListen());
		System.out.println(cnt + "");
		JButton btn_back = new JButton(new ImageIcon("img/lb_back.png"));
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(33, 33, 51, 51);
		contentPane.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
				
			}
		});
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