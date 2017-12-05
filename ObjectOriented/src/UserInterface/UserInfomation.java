package UserInterface;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import InnerClass.DBmethod;
import InnerClass.UserObject;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UserInfomation extends JFrame {

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

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UserInfomation(UserObject us) {

		ImageIcon Icon_w0 = new ImageIcon("img/w_body0.png");
		ImageIcon Icon_w1 = new ImageIcon("img/w_body1.png");
		ImageIcon Icon_w2 = new ImageIcon("img/w_body2.png");
		ImageIcon Icon_w3 = new ImageIcon("img/w_body3.png");

		ImageIcon Icon_m0 = new ImageIcon("img/m_body0.png");
		ImageIcon Icon_m1 = new ImageIcon("img/m_body1.png");
		ImageIcon Icon_m2 = new ImageIcon("img/m_body2.png");
		ImageIcon Icon_m3 = new ImageIcon("img/m_body3.png");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel label = new JLabel("\uC544\uC774\uB514");
		label.setBounds(105, 45, 78, 21);
		contentPane.add(label);

		JLabel lb_id = new JLabel("\uBCF4\uC5EC\uC904\uC544\uC774\uB514");
		lb_id.setBounds(266, 45, 153, 21);
		contentPane.add(lb_id);

		JLabel lblNewLabel = new JLabel("\uC774\uB984");
		lblNewLabel.setBounds(105, 98, 78, 21);
		contentPane.add(lblNewLabel);

		JLabel lb_name = new JLabel("\uBCF4\uC5EC\uC904 \uC774\uB984");
		lb_name.setBounds(264, 98, 185, 21);
		contentPane.add(lb_name);

		JLabel label_1 = new JLabel("\uC9C0\uC5ED");
		label_1.setBounds(105, 147, 78, 21);
		contentPane.add(label_1);

		tf_location = new JTextField();
		tf_location.setBounds(263, 144, 156, 27);
		contentPane.add(tf_location);
		tf_location.setColumns(10);

		ButtonGroup w = new ButtonGroup();
		ButtonGroup m = new ButtonGroup();
		wr1 = new JRadioButton(Icon_w0,true);
		wr1.setBorderPainted(true);
		wr1.setBounds(54, 270, 120, 180);
		contentPane.add(wr1);

		JLabel lblNewLabel_1 = new JLabel("\uCCB4\uD615");
		lblNewLabel_1.setBounds(54, 221, 78, 21);
		contentPane.add(lblNewLabel_1);

		wr2 = new JRadioButton(Icon_w1);
		wr2.setBorderPainted(true);
		wr2.setBounds(179, 270, 120, 180);
		contentPane.add(wr2);

		wr3 = new JRadioButton(Icon_w2);
		wr3.setBounds(310, 270, 120, 180);
		wr3.setBorderPainted(true);
		contentPane.add(wr3);

		wr4 = new JRadioButton(Icon_w3);
		wr4.setBounds(450, 270, 120, 180);
		wr4.setBorderPainted(true);
		contentPane.add(wr4);

		w.add(wr1);
		w.add(wr2);
		w.add(wr3);
		w.add(wr4);

		mr1 = new JRadioButton(Icon_m0,true);
		mr1.setBounds(54, 270, 120, 180);
		mr1.setBorderPainted(true);
		contentPane.add(mr1);

		mr2 = new JRadioButton(Icon_m1);
		mr2.setBounds(179, 270, 120, 180);
		mr2.setBorderPainted(true);
		contentPane.add(mr2);

		mr3 = new JRadioButton(Icon_m2);
		mr3.setBounds(308, 270, 120, 180);
		mr3.setBorderPainted(true);
		contentPane.add(mr3);

		mr4 = new JRadioButton(Icon_m3);
		mr4.setBounds(450, 270, 120, 180);
		mr4.setBorderPainted(true);
		contentPane.add(mr4);
		m.add(mr1);
		m.add(mr2);
		m.add(mr3);
		m.add(mr4);
		
		wr1.addItemListener(new bodyItemcheck());
		wr2.addItemListener(new bodyItemcheck());
		wr3.addItemListener(new bodyItemcheck());
		wr4.addItemListener(new bodyItemcheck());

		mr1.addItemListener(new bodyItemcheck());
		mr2.addItemListener(new bodyItemcheck());
		mr3.addItemListener(new bodyItemcheck());
		mr4.addItemListener(new bodyItemcheck());

		ch1 = new JCheckBox("\uC2DC\uD06C");
		ch1.setBounds(105, 545, 161, 29);
		contentPane.add(ch1);

		ch2 = new JCheckBox("\uD050\uD2F0");
		ch2.setBounds(310, 545, 161, 29);
		contentPane.add(ch2);

		ch3 = new JCheckBox("");
		ch3.setBounds(105, 601, 161, 29);
		contentPane.add(ch3);

		ch4 = new JCheckBox("\uBE48\uD2F0\uC9C0");
		ch4.setBounds(310, 601, 161, 29);
		contentPane.add(ch4);

		ch1.addItemListener(new itemListen());
		ch2.addItemListener(new itemListen());
		ch3.addItemListener(new itemListen());
		ch4.addItemListener(new itemListen());

		lb_id.setText(us.getId());
		lb_name.setText(us.getName());
		tf_location.setText(us.getLocation());
		JLabel lblNewLabel_2 = new JLabel("\uC2A4\uD0C0\uC77C");
		lblNewLabel_2.setBounds(54, 496, 78, 21);
		contentPane.add(lblNewLabel_2);

		JButton btn_change = new JButton("\uC815\uBCF4 \uBCC0\uACBD");
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
		btn_change.setBounds(424, 639, 125, 29);
		contentPane.add(btn_change);
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
