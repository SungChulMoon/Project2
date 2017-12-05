package UserInterface;

import java.awt.*;
import javax.swing.*;

import InnerClass.CodiOb;
import InnerClass.DBmethod;

import java.awt.event.*;
import java.io.File;;

public class adminPage2 extends JFrame {

	ImageIcon Icon_back_admin2 = new ImageIcon("img/lb_back_admin2.png");
	ImageIcon Icon_lb_admin_file = new ImageIcon("img/lb_admin_file.png");
	ImageIcon Icon_lb_admin_gender = new ImageIcon("img/lb_admin_gender.png");
	ImageIcon Icon_lb_admin_type = new ImageIcon("img/lb_admin_type.png");
	ImageIcon Icon_lb_admin_season = new ImageIcon("img/lb_admin_season.png");
	ImageIcon Icon_lb_admin_thick = new ImageIcon("img/lb_admin_thick.png");
	ImageIcon Icon_lb_admin_style = new ImageIcon("img/lb_admin_style.png");
	ImageIcon Icon_lb_admin_body = new ImageIcon("img/lb_admin_body.png");
	ImageIcon Icon_lb_admin_link = new ImageIcon("img/lb_admin_link.png");
	
	private JPanel contentPane;
	private JTextField tf_fileName;
	private JTextField tf_link;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public adminPage2() {
		setTitle("¿þ´õ¸®½¬");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 580);
		setResizable(false);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/Icon.png");
		setIconImage(img);
		
		contentPane = new JPanel(){
			public void paintComponent(Graphics g) {
				Rectangle r = getVisibleRect();
				g.drawImage(Icon_back_admin2.getImage(), 0, 0, r.width, r.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setLayout(null);
		setContentPane(contentPane);

		ButtonGroup sort = new ButtonGroup();

		JLabel lb_fileName = new JLabel(Icon_lb_admin_file);
		JLabel lb_gender = new JLabel(Icon_lb_admin_gender);
		JLabel lb_type = new JLabel(Icon_lb_admin_type);
		JLabel lb_season = new JLabel(Icon_lb_admin_season);
		JLabel lb_thick = new JLabel(Icon_lb_admin_thick);
		JLabel lb_style = new JLabel(Icon_lb_admin_style);
		JLabel lb_style1 = new JLabel("½ÃÅ©");
		JLabel lb_style2 = new JLabel("Å¥Æ¼");
		JLabel lb_style3 = new JLabel("¼½½Ã");
		JLabel lb_style4 = new JLabel("ºóÆ¼Áö");
		JLabel lb_body = new JLabel(Icon_lb_admin_body);
		JLabel lb_body1 = new JLabel("¸ö1");
		JLabel lb_body2 = new JLabel("¸ö2");
		JLabel lb_body3 = new JLabel("¸ö3");
		JLabel lb_body4 = new JLabel("¸ö4");
		JLabel lb_link = new JLabel(Icon_lb_admin_link);
		tf_fileName = new JTextField();
		tf_link = new JTextField();
		JButton btn_back = new JButton(new ImageIcon("img/lb_back.png"));
		JButton btn_directory = new JButton(new ImageIcon("img/btn_folder.png"));
		JButton btn_regist = new JButton(new ImageIcon("img/btn_admit_regist.png"));
		JRadioButton rd_w = new JRadioButton("¿©ÀÚ",true);
		JRadioButton rd_m = new JRadioButton("³²ÀÚ");
		JRadioButton rd_outer = new JRadioButton("outer",true);
		JRadioButton rd_top = new JRadioButton("top");
		JRadioButton rd_pants = new JRadioButton("pants");
		JRadioButton rd_shoes = new JRadioButton("shoes");
		JComboBox cb_season = new JComboBox();
		JComboBox cb_style1 = new JComboBox();
		JComboBox cb_style2 = new JComboBox();
		JComboBox cb_style3 = new JComboBox();
		JComboBox cb_style4 = new JComboBox();
		JComboBox cb_body1 = new JComboBox();
		JComboBox cb_body2 = new JComboBox();
		JComboBox cb_body3 = new JComboBox();
		JComboBox cb_body4 = new JComboBox();
		ButtonGroup g = new ButtonGroup();
		lb_fileName.setBounds(220, 35, 99, 52);
		lb_gender.setBounds(230, 89, 76, 52);
		lb_type.setBounds(230, 150, 76, 52);
		lb_season.setBounds(220, 205, 99, 52);
		lb_thick.setBounds(510, 200, 99, 52);
		lb_style.setBounds(220, 265, 99, 52);
		lb_style1.setBounds(331, 280, 43, 18);
		lb_style2.setBounds(459, 280, 43, 18);
		lb_style3.setBounds(585, 280, 43, 18);
		lb_style4.setBounds(695, 280, 62, 18);
		lb_body.setBounds(233, 329, 76, 52);
		lb_body1.setBounds(331, 346, 45, 20);
		lb_body2.setBounds(459, 346, 45, 20);
		lb_body3.setBounds(585, 346, 45, 20);
		lb_body4.setBounds(701, 346, 45, 20);
		lb_link.setBounds(235, 395, 76, 52);
		tf_fileName.setBounds(330, 45, 220, 32);
		tf_link.setBounds(330, 410, 220, 30);
		btn_back.setBounds(66, 33, 51, 51);
		btn_directory.setBounds(573, 45, 32, 32);
		btn_regist.setBounds(679, 410, 120, 40);
		rd_w.setBounds(330, 100, 62, 27);
		rd_m.setBounds(420, 100, 62, 27);
		rd_outer.setBounds(330, 155, 68, 27);
		rd_top.setBounds(422, 155, 62, 27);
		rd_pants.setBounds(516, 155, 76, 27);
		rd_shoes.setBounds(620, 155, 85, 27);
		cb_season.setBounds(330, 215, 75, 24);
		

		

		btn_back.setBorderPainted(false);
		contentPane.add(btn_back);

		contentPane.add(lb_fileName);

		contentPane.add(tf_fileName);
		tf_fileName.setColumns(10);

		contentPane.add(lb_gender);
		g.add(rd_w);
		g.add(rd_m);
		
		rd_w.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		rd_w.setBackground(Color.WHITE);
		rd_w.setForeground(new Color(5, 97, 232));
		contentPane.add(rd_w);

		rd_m.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		rd_m.setBackground(Color.WHITE);
		rd_m.setForeground(new Color(5, 97, 232));
		contentPane.add(rd_m);

		contentPane.add(lb_type);

		rd_outer.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		rd_outer.setForeground(new Color(5, 97, 232));
		rd_outer.setBackground(Color.WHITE);
		contentPane.add(rd_outer);

		rd_top.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		rd_top.setForeground(new Color(5, 97, 232));
		rd_top.setBackground(Color.WHITE);
		contentPane.add(rd_top);

		rd_pants.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		rd_pants.setForeground(new Color(5, 97, 232));
		rd_pants.setBackground(Color.WHITE);
		contentPane.add(rd_pants);

		rd_shoes.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		rd_shoes.setForeground(new Color(5, 97, 232));
		rd_shoes.setBackground(Color.WHITE);
		contentPane.add(rd_shoes);

		contentPane.add(lb_season);

		cb_season.addItem("WARM");
		cb_season.addItem("COLD");
		contentPane.add(cb_season);

		contentPane.add(lb_thick);

		JComboBox cb_thick = new JComboBox();
		cb_thick.setBounds(620, 215, 69, 24);
		cb_style1.setBounds(372, 275, 53, 24);
		cb_style2.setBounds(498, 275, 53, 24);
		for (int i = 0; i < 6; i++)
			cb_thick.addItem(Integer.toString(i));

		contentPane.add(cb_thick);

		contentPane.add(lb_style);

		lb_style1.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		lb_style1.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_style1);

		for (int i = 0; i < 6; i++)
			cb_style1.addItem(Integer.toString(i));
		contentPane.add(cb_style1);

		lb_style2.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		lb_style2.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_style2);

		for (int i = 0; i < 6; i++)
			cb_style2.addItem(Integer.toString(i));
		contentPane.add(cb_style2);

		lb_style3.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		lb_style3.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_style3);

		cb_style3.setBounds(620, 275, 53, 24);
		for (int i = 0; i < 6; i++)
			cb_style3.addItem(Integer.toString(i));
		contentPane.add(cb_style3);

		lb_style4.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		lb_style4.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_style4);

		cb_style4.setBounds(746, 275, 53, 24);
		for (int i = 0; i < 6; i++)
			cb_style4.addItem(Integer.toString(i));
		contentPane.add(cb_style4);

		contentPane.add(lb_link);

		tf_link.setColumns(10);
		contentPane.add(tf_link);

		btn_directory.setBackground(Color.WHITE);

		btn_directory.setBorderPainted(false);
			
		contentPane.add(btn_directory);

		contentPane.add(btn_regist);

		contentPane.add(lb_body);

		lb_body1.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		lb_body1.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_body1);

		cb_body1.setBounds(372, 343, 53, 24);
		for (int i = 0; i < 6; i++)
			cb_body1.addItem(Integer.toString(i));
		contentPane.add(cb_body1);

		lb_body2.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		lb_body2.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_body2);

		cb_body2.setBounds(498, 340, 53, 24);
		for (int i = 0; i < 6; i++)
			cb_body2.addItem(Integer.toString(i));
		contentPane.add(cb_body2);

		lb_body3.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		lb_body3.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_body3);

		cb_body3.setBounds(620, 343, 53, 24);
		for (int i = 0; i < 6; i++)
			cb_body3.addItem(Integer.toString(i));
		contentPane.add(cb_body3);

		lb_body4.setFont(new Font("±¼¸²", Font.PLAIN, 17));
		lb_body4.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_body4);

		cb_body4.setBounds(746, 343, 53, 24);
		for (int i = 0; i < 6; i++)
			cb_body4.addItem(Integer.toString(i));
		contentPane.add(cb_body4);
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adminPage ap = new adminPage();
				ap.setVisible(true);
				dispose();

			}
		});
		sort.add(rd_outer);
		sort.add(rd_top);
		sort.add(rd_pants);
		sort.add(rd_shoes);
		btn_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				DBmethod.insertcodi(new CodiOb(tf_fileName.getText(), filepath, season, thick, gender, link, type, style1, style2, style3, style4, body1, body2, body3, body4))
			}
		});
	}
}
