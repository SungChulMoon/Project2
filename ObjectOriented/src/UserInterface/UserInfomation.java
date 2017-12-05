package UserInterface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import InnerClass.DBmethod;
import InnerClass.UserObject;
import java.util.ArrayList;


public class UserInfomation extends JFrame {

	ImageIcon Icon_back_join = new ImageIcon("img/lb_back_user.png");
	ImageIcon Icon_name = new ImageIcon("img/lb_join_name.png");
	ImageIcon Icon_local = new ImageIcon("img/lb_join_local.png");
	ImageIcon Icon_body = new ImageIcon("img/lb_admin_body.png");
	ImageIcon Icon_style = new ImageIcon("img/lb_join_style.png");
	ImageIcon Icon_logo = new ImageIcon("img/logo.png");
	ImageIcon Icon_w0 = new ImageIcon("img/w_body0.png");
	ImageIcon Icon_w1 = new ImageIcon("img/w_body1.png");
	ImageIcon Icon_w2 = new ImageIcon("img/w_body2.png");
	ImageIcon Icon_w3 = new ImageIcon("img/w_body3.png");
	ImageIcon Icon_m0 = new ImageIcon("img/m_body0.png");
	ImageIcon Icon_m1 = new ImageIcon("img/m_body1.png");
	ImageIcon Icon_m2 = new ImageIcon("img/m_body2.png");
	ImageIcon Icon_m3 = new ImageIcon("img/m_body3.png");
	ImageIcon Icon_id = new ImageIcon("img/lb_join_id.png");
	
	private JPanel contentPane;
	private JTextField tf_location;
	JRadioButton wr1;
	JRadioButton wr2;
	JRadioButton wr3;
	JRadioButton wr4;
	JRadioButton mr1;
	JRadioButton mr2;
	JRadioButton mr3;
	JRadioButton mr4;
	JCheckBox ch1;
	JCheckBox ch2;
	JCheckBox ch3;
	JCheckBox ch4;
	String checkbody = "";

	int cnt = 0;
	ArrayList<String> stylearr = new ArrayList<>();
	private JButton btn_back;

	public UserInfomation(UserObject us) {

		setTitle("웨더리쉬");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 740);
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

		JLabel lb_user_id = new JLabel(Icon_id);
		JLabel lb_id = new JLabel();
		JLabel lb_user_name = new JLabel(Icon_name);
		JLabel lb_name = new JLabel();
		JLabel lb_user_local = new JLabel(Icon_local);
		JLabel lb_user_body = new JLabel(Icon_body);
		JLabel lb_user_style = new JLabel(Icon_style);
		JLabel lb_logo = new JLabel(Icon_logo);
		tf_location = new JTextField();
		ButtonGroup w = new ButtonGroup();
		ButtonGroup m = new ButtonGroup();
		JButton btn_change = new JButton(new ImageIcon("img/btn_user_change.png"));
		btn_back = new JButton(new ImageIcon("img/lb_back.png"));
		wr1 = new JRadioButton(Icon_w0,true);
		wr2 = new JRadioButton(Icon_w1);
		wr3 = new JRadioButton(Icon_w2);
		wr4 = new JRadioButton(Icon_w3);
		mr1 = new JRadioButton(Icon_m0,true);
		mr2 = new JRadioButton(Icon_m1);
		mr3 = new JRadioButton(Icon_m2);
		mr4 = new JRadioButton(Icon_m3);
		ch1 = new JCheckBox("시크");
		ch2 = new JCheckBox("큐티");
		ch3 = new JCheckBox("");
		ch4 = new JCheckBox("빈티지");
		
		lb_user_id.setBounds(105, 33, 130, 50);
		lb_id.setBounds(265, 45, 155, 25);
		lb_user_name.setBounds(105, 85, 130, 50);
		lb_name.setBounds(265, 100, 155, 25);
		lb_user_local.setBounds(105, 145, 130, 50);
		lb_user_body.setBounds(35, 215, 115, 50);
		lb_user_style.setBounds(55, 495, 130, 50);
		lb_logo.setBounds(433, 33, 200, 170);
		tf_location.setBounds(265, 155, 160, 30);
		wr1.setBounds(55, 270, 120, 180);
		wr2.setBounds(180, 270, 120, 180);
		wr3.setBounds(310, 270, 120, 180);
		wr4.setBounds(450, 270, 120, 180);
		mr1.setBounds(54, 270, 120, 180);
		mr2.setBounds(179, 270, 120, 180);
		mr3.setBounds(308, 270, 120, 180);
		mr4.setBounds(450, 270, 120, 180);
		ch1.setBounds(105, 545, 120, 30);
		ch2.setBounds(310, 545, 120, 30);
		ch3.setBounds(105, 600, 120, 30);
		ch4.setBounds(310, 600, 120, 30);
		btn_change.setBounds(450, 600, 125, 30);
		btn_back.setBounds(33, 33, 51, 51);

		lb_id.setFont(new Font("굴림", Font.PLAIN, 20));
		lb_name.setFont(new Font("굴림", Font.PLAIN, 20));
		tf_location.setFont(new Font("굴림", Font.PLAIN, 20));
		ch1.setFont(new Font("굴림", Font.PLAIN, 20));
		ch2.setFont(new Font("굴림", Font.PLAIN, 20));
		ch3.setFont(new Font("굴림", Font.PLAIN, 20));
		ch4.setFont(new Font("굴림", Font.PLAIN, 20));
		
		tf_location.setColumns(10);

		wr1.setBackground(Color.WHITE);
		wr2.setBackground(Color.WHITE);
		wr3.setBackground(Color.WHITE);
		wr4.setBackground(Color.WHITE);
		mr1.setBackground(Color.WHITE);
		mr2.setBackground(Color.WHITE);
		mr3.setBackground(Color.WHITE);
		mr4.setBackground(Color.WHITE);
		ch1.setBackground(Color.WHITE);
		ch2.setBackground(Color.WHITE);
		ch3.setBackground(Color.WHITE);
		ch4.setBackground(Color.WHITE);

		ch4.setForeground(new Color(5, 97, 232));
		ch1.setForeground(new Color(5, 97, 232));
		ch2.setForeground(new Color(5, 97, 232));
		ch3.setForeground(new Color(5, 97, 232));


		btn_back.setBorderPainted(false);
		wr1.setBorderPainted(true);
		wr2.setBorderPainted(true);
		wr3.setBorderPainted(true);
		wr4.setBorderPainted(true);
		mr1.setBorderPainted(true);
		mr2.setBorderPainted(true);
		mr3.setBorderPainted(true);
		mr4.setBorderPainted(true);

		wr1.addItemListener(new bodyItemcheck());
		wr2.addItemListener(new bodyItemcheck());
		wr3.addItemListener(new bodyItemcheck());
		wr4.addItemListener(new bodyItemcheck());
		mr1.addItemListener(new bodyItemcheck());
		mr2.addItemListener(new bodyItemcheck());
		mr3.addItemListener(new bodyItemcheck());
		mr4.addItemListener(new bodyItemcheck());
		ch1.addItemListener(new itemListen());
		ch2.addItemListener(new itemListen());
		ch3.addItemListener(new itemListen());
		ch4.addItemListener(new itemListen());
		w.add(wr1);
		w.add(wr2);
		w.add(wr3);
		w.add(wr4);
		m.add(mr1);
		m.add(mr2);
		m.add(mr3);
		m.add(mr4);
		contentPane.add(lb_user_id);
		contentPane.add(lb_id);
		contentPane.add(lb_user_name);
		contentPane.add(lb_name);
		contentPane.add(lb_user_local);
		contentPane.add(lb_user_body);
		contentPane.add(lb_user_style);
		contentPane.add(lb_logo);
		contentPane.add(tf_location);
		contentPane.add(wr1);
		contentPane.add(wr2);
		contentPane.add(wr3);
		contentPane.add(wr4);
		contentPane.add(mr1);
		contentPane.add(mr2);
		contentPane.add(mr3);
		contentPane.add(mr4);
		contentPane.add(ch1);
		contentPane.add(ch2);
		contentPane.add(ch3);
		contentPane.add(ch4);
		contentPane.add(btn_change);
		contentPane.add(btn_back);

		lb_id.setText(us.getId());
		lb_name.setText(us.getName());
		tf_location.setText(us.getLocation());

		btn_change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tf_location.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "지역를 작성해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else if ((!ch1.isSelected()) && (!ch2.isSelected()) && (!ch3.isSelected()) && (!ch4.isSelected())) {
					JOptionPane.showMessageDialog(null, "스타일을 하나라도 선택해주세요", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					String style_str1 = "";
					for (int i = 0; i < stylearr.size(); i++) {
						style_str1 += "," + stylearr.get(i);
					}
					String style_str = style_str1.substring(1);
					System.out.println(style_str);
					try {
						DBmethod.updateInfo(us.getId(), tf_location.getText(), checkbody, style_str,
								Integer.toString(cnt));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Main m = new Main(us.getId());
					m.setVisible(true);
					dispose();
				}
			}
		});
		
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main ma = new Main(us.getId());
				ma.setVisible(true);
				dispose();
			}
		});
		
		if (us.getGender().equals("여자")) {
			ch3.setText("섹시");
			mr1.setVisible(false);
			mr2.setVisible(false);
			mr3.setVisible(false);
			mr4.setVisible(false);

			wr1.setVisible(true);
			wr2.setVisible(true);
			wr3.setVisible(true);
			wr4.setVisible(true);
		} else {
			ch3.setText("댄디");
			wr1.setVisible(false);
			wr2.setVisible(false);
			wr3.setVisible(false);
			wr4.setVisible(false);

			mr1.setVisible(true);
			mr2.setVisible(true);
			mr3.setVisible(true);
			mr4.setVisible(true);
		}
	}

	class bodyItemcheck implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == wr1) {
					checkbody = "여자0";
				} else if (e.getItem() == wr2) {
					checkbody = "여자1";
				} else if (e.getItem() == wr3) {
					checkbody = "여자2";
				} else if (e.getItem() == wr4) {
					checkbody = "여자3";
				} else if (e.getItem() == mr1) {
					checkbody = "남자0";
				} else if (e.getItem() == mr2) {
					checkbody = "남자1";
				} else if (e.getItem() == mr3) {
					checkbody = "남자2";
				} else if (e.getItem() == mr4) {
					checkbody = "남자3";
				}
			}
			System.out.println(checkbody);
		}
	}

	class itemListen implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				if (e.getItem() == ch1) {
					cnt++;
					stylearr.add(ch1.getText());
				} else if (e.getItem() == ch2) {
					cnt++;
					stylearr.add(ch2.getText());
				} else if (e.getItem() == ch3) {
					cnt++;
					stylearr.add(ch3.getText());
				} else if (e.getItem() == ch4) {
					cnt++;
					stylearr.add(ch4.getText());
				}
			} else {
				if (e.getItem() == ch1) {
					cnt--;
					stylearr.remove(ch1.getText());
				} else if (e.getItem() == ch2) {
					cnt--;
					stylearr.remove(ch2.getText());
				} else if (e.getItem() == ch3) {
					cnt--;
					stylearr.remove(ch3.getText());
				} else if (e.getItem() == ch4) {
					cnt--;
					stylearr.remove(ch4.getText());
				}
			}
			System.out.println(cnt + "");
			for (int i = 0; i < stylearr.size(); i++) {
				System.out.println(stylearr.get(i));
			}
		}
	}
}
