package UserInterface;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import InnerClass.UserObject;

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
	JCheckBox ch3;
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
		
		JLabel lb_pass = new JLabel("\uBCF4\uC5EC\uC904 \uC774\uB984");
		lb_pass.setBounds(264, 98, 185, 21);
		contentPane.add(lb_pass);
		
		JLabel label_1 = new JLabel("\uC9C0\uC5ED");
		label_1.setBounds(105, 147, 78, 21);
		contentPane.add(label_1);
		
		tf_location = new JTextField();
		tf_location.setBounds(263, 144, 156, 27);
		contentPane.add(tf_location);
		tf_location.setColumns(10);
		
		ButtonGroup w = new ButtonGroup();
		ButtonGroup m = new ButtonGroup();
		JRadioButton wr1 = new JRadioButton(Icon_w0);
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
	
		mr1 = new JRadioButton(Icon_m0);
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
		
		JCheckBox ch1 = new JCheckBox("\uC2DC\uD06C");
		ch1.setBounds(105, 545, 161, 29);
		contentPane.add(ch1);
		
		JCheckBox ch2 = new JCheckBox("\uD050\uD2F0");
		ch2.setBounds(310, 545, 161, 29);
		contentPane.add(ch2);
		
		ch3 = new JCheckBox("");
		ch3.setBounds(105, 601, 161, 29);
		contentPane.add(ch3);
		
		JCheckBox ch4 = new JCheckBox("\uBE48\uD2F0\uC9C0");
		ch4.setBounds(310, 601, 161, 29);
		contentPane.add(ch4);
		
		JLabel lblNewLabel_2 = new JLabel("\uC2A4\uD0C0\uC77C");
		lblNewLabel_2.setBounds(54, 496, 78, 21);
		contentPane.add(lblNewLabel_2);
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
		}
		else {
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
	public void changeGUI(String gender) {
		
	}
}
