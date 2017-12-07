package UserInterface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import InnerClass.DBmethod;

/**
 * 관리자가 추가할 생활 팁을 DB로 보내고 저장하는 GUI클래스
 * 
 * @author Jaecheol
 * @see JFrame
 * 
 */
public class adminPage extends JFrame {
	/** JLabel에 적용할 "관리자 페이지" 글자를 나타내는 ImageIcon */
	ImageIcon Icon_admin = new ImageIcon("img/lb_admin_page.png");
	/** JLabel에 적용할 "팁" 글자를 나타내는 ImageIcon */
	ImageIcon Icon_tip = new ImageIcon("img/lb_admin_tip.png");
	/** JLabel에 적용할 "링크" 글자를 나타내는 ImageIcon */
	ImageIcon Icon_link = new ImageIcon("img/lb_admin_link.png");
	/** adminPage의 배경이미지에 사용하는 ImageIcon */
	ImageIcon Icon_back_admin = new ImageIcon("img/lb_back_admin.png");

	private JPanel contentPane;
	private JTextField tf_tip;
	private JTextField tf_link;

	public adminPage() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/Icon.png");
		setIconImage(img);

		setTitle("웨더리쉬");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 400);
		setResizable(false);

		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Rectangle r = getVisibleRect();
				g.drawImage(Icon_back_admin.getImage(), 0, 0, r.width, r.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lb_tip = new JLabel(Icon_tip);
		JLabel lb_link = new JLabel(Icon_link);
		JLabel lb_admin = new JLabel(Icon_admin);
		tf_tip = new JTextField();
		tf_link = new JTextField();
		JButton btn_addtip = new JButton(new ImageIcon("img/btn_admin_addtip.png"));
		JButton btn_back = new JButton(new ImageIcon("img/lb_back.png"));
		JButton btn_cloth = new JButton(new ImageIcon("img/btn_cloth.png"));
		btn_cloth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminPage2 ap2 = new adminPage2();
				ap2.setVisible(true);
				dispose();
			}
		});
		JComboBox cb_weather = new JComboBox();
		cb_weather.addItem("Clear");
		cb_weather.addItem("Rain");
		cb_weather.addItem("Drizzle");
		cb_weather.addItem("Mist");
		cb_weather.addItem("Haze");
		cb_weather.addItem("Fog");
		cb_weather.addItem("Clouds");
		cb_weather.addItem("Snow");

		lb_tip.setBounds(225, 152, 80, 40);
		lb_link.setBounds(225, 204, 80, 40);
		lb_admin.setBounds(325, 40, 318, 73);
		tf_tip.setBounds(325, 153, 520, 40);
		tf_link.setBounds(325, 205, 520, 40);
		btn_addtip.setBounds(725, 270, 120, 40);
		btn_back.setBounds(33, 33, 51, 51);
		btn_cloth.setBounds(325, 270, 120, 40);
		cb_weather.setBounds(89, 161, 122, 24);

		tf_tip.setColumns(10);
		tf_link.setColumns(10);

		btn_back.setBorderPainted(false);

		btn_addtip.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (tf_tip.getText().equals("") || tf_link.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "빈칸을 채워주세요", "에러", JOptionPane.ERROR_MESSAGE);

					} else {
						String weather = (String) cb_weather.getSelectedItem();
						String tip = tf_tip.getText();
						String link = tf_link.getText();
						DBmethod.addtip(weather, tip, link);
						tf_tip.setText("");
						tf_link.setText("");
						JOptionPane.showMessageDialog(null, "팁 추가 완료", " 완료", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e1) {
					System.out.println("추가하는데 에러");
					e1.printStackTrace();
				}
			}
		});

		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();

			}
		});

		contentPane.add(lb_tip);
		contentPane.add(lb_link);
		contentPane.add(lb_admin);
		contentPane.add(tf_tip);
		contentPane.add(tf_link);
		contentPane.add(btn_addtip);
		contentPane.add(btn_back);
		contentPane.add(btn_cloth);
		contentPane.add(cb_weather);
	}
}
