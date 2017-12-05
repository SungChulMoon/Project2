package UserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class adminPage2 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_fileName;
	private JTextField tf_link;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPage2 frame = new adminPage2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public adminPage2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btn_back = new JButton("GoToBack");
		btn_back.setBounds(45, 39, 105, 27);
		contentPane.add(btn_back);
		
		JLabel lb_fileName = new JLabel("\uD30C\uC77C\uBA85");
		lb_fileName.setBounds(231, 43, 53, 18);
		contentPane.add(lb_fileName);
		
		tf_fileName = new JTextField();
		tf_fileName.setBounds(331, 40, 116, 24);
		contentPane.add(tf_fileName);
		tf_fileName.setColumns(10);
		
		JLabel lb_gender = new JLabel("\uC131\uBCC4");
		lb_gender.setBounds(231, 102, 62, 18);
		contentPane.add(lb_gender);
		
		JRadioButton rBtn_woman = new JRadioButton("\uC5EC\uC790");
		rBtn_woman.setBounds(331, 98, 62, 27);
		contentPane.add(rBtn_woman);
		
		JRadioButton rBtn_man = new JRadioButton("\uB0A8\uC790");
		rBtn_man.setBounds(422, 98, 62, 27);
		contentPane.add(rBtn_man);
		
		JLabel lb_type = new JLabel("\uC885\uB958");
		lb_type.setBounds(231, 160, 62, 18);
		contentPane.add(lb_type);
		
		JRadioButton rBtn_outer = new JRadioButton("outer");
		rBtn_outer.setBounds(331, 156, 68, 27);
		contentPane.add(rBtn_outer);
		
		JRadioButton rBtn_top = new JRadioButton("top");
		rBtn_top.setBounds(422, 156, 62, 27);
		contentPane.add(rBtn_top);
		
		JRadioButton rBtn_pants = new JRadioButton("pants");
		rBtn_pants.setBounds(516, 156, 68, 27);
		contentPane.add(rBtn_pants);
		
		JRadioButton rBtn_shoes = new JRadioButton("shoes");
		rBtn_shoes.setBounds(620, 156, 69, 27);
		contentPane.add(rBtn_shoes);
		
		JLabel lb_season = new JLabel("\uACC4\uC808\uAC10");
		lb_season.setBounds(231, 219, 62, 18);
		contentPane.add(lb_season);
		
		JComboBox combo_season = new JComboBox();
		combo_season.setBounds(331, 216, 75, 24);
		contentPane.add(combo_season);
		
		JLabel lb_thick = new JLabel("\uB450\uAED8\uAC10");
		lb_thick.setBounds(516, 219, 62, 18);
		contentPane.add(lb_thick);
		
		JComboBox combo_thick = new JComboBox();
		combo_thick.setBounds(620, 216, 69, 24);
		contentPane.add(combo_thick);
		
		JLabel lb_style = new JLabel("\uC2A4\uD0C0\uC77C");
		lb_style.setBounds(231, 280, 62, 18);
		contentPane.add(lb_style);
		
		JLabel lb_style1 = new JLabel("\uC2DC\uD06C");
		lb_style1.setBounds(331, 280, 43, 18);
		contentPane.add(lb_style1);
		
		JComboBox combo_style1 = new JComboBox();
		combo_style1.setBounds(372, 277, 53, 24);
		contentPane.add(combo_style1);
		
		JLabel lb_style2 = new JLabel("\uD050\uD2F0");
		lb_style2.setBounds(459, 280, 43, 18);
		contentPane.add(lb_style2);
		
		JComboBox combo_style2 = new JComboBox();
		combo_style2.setBounds(498, 277, 53, 24);
		contentPane.add(combo_style2);
		
		JLabel lb_style3 = new JLabel("\uC139\uC2DC");
		lb_style3.setBounds(585, 280, 43, 18);
		contentPane.add(lb_style3);
		
		JComboBox combo_style3 = new JComboBox();
		combo_style3.setBounds(620, 277, 53, 24);
		contentPane.add(combo_style3);
		
		JLabel lb_style4 = new JLabel("\uBE48\uD2F0\uC9C0");
		lb_style4.setBounds(701, 280, 43, 18);
		contentPane.add(lb_style4);
		
		JComboBox combo_style4 = new JComboBox();
		combo_style4.setBounds(746, 277, 53, 24);
		contentPane.add(combo_style4);
		
		JLabel lb_link = new JLabel("\uB9C1\uD06C");
		lb_link.setBounds(231, 413, 62, 18);
		contentPane.add(lb_link);
		
		tf_link = new JTextField();
		tf_link.setColumns(10);
		tf_link.setBounds(331, 410, 220, 24);
		contentPane.add(tf_link);
		
		JButton btn_directory = new JButton("directory");
		btn_directory.setBounds(483, 39, 105, 27);
		contentPane.add(btn_directory);
		
		JButton btn_regist = new JButton("\uB4F1\uB85D");
		btn_regist.setBounds(701, 456, 105, 27);
		contentPane.add(btn_regist);
		
		JLabel lb_body = new JLabel("\uCCB4\uD615");
		lb_body.setBounds(231, 346, 62, 18);
		contentPane.add(lb_body);
		
		JLabel lb_body1 = new JLabel("\uBAB81");
		lb_body1.setBounds(331, 346, 43, 18);
		contentPane.add(lb_body1);
		
		JComboBox combo_body1 = new JComboBox();
		combo_body1.setBounds(372, 343, 53, 24);
		contentPane.add(combo_body1);
		
		JLabel lb_body2 = new JLabel("\uBAB82");
		lb_body2.setBounds(459, 346, 43, 18);
		contentPane.add(lb_body2);
		
		JComboBox combo_body2 = new JComboBox();
		combo_body2.setBounds(498, 340, 53, 24);
		contentPane.add(combo_body2);
		
		JLabel label_2 = new JLabel("\uBAB83");
		label_2.setBounds(585, 346, 43, 18);
		contentPane.add(label_2);
		
		JComboBox combo_body3 = new JComboBox();
		combo_body3.setBounds(620, 343, 53, 24);
		contentPane.add(combo_body3);
		
		JLabel lb_body4 = new JLabel("\uBAB84");
		lb_body4.setBounds(701, 346, 43, 18);
		contentPane.add(lb_body4);
		
		JComboBox combo_body4 = new JComboBox();
		combo_body4.setBounds(746, 343, 53, 24);
		contentPane.add(combo_body4);
	}
}
