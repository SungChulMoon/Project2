package UserInterface;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import InnerClass.DBmethod;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * 유저들의 정보를 DB에서 가져와 아이디와 패스워드를 비교하여 로그인시키는 클래스
 * 
 * @author Moon light
 * @see JFrame
 */
public class Login extends JFrame {
	ImageIcon Icon_back_login = new ImageIcon("img/lb_back_login.png");
	ImageIcon Icon_btn_login = new ImageIcon("img/btn_login.png");
	ImageIcon Icon_btn_join = new ImageIcon("img/btn_join.png");
	ImageIcon Icon_id = new ImageIcon("img/lb_id.png");
	ImageIcon Icon_pass = new ImageIcon("img/lb_pass.png");
	ImageIcon Icon_login = new ImageIcon("img/lb_login.png");
	ImageIcon Icon_logo = new ImageIcon("img/logo.png");
	
	private JPanel contentPane;
	private JTextField tf_login_id;
	private JPasswordField tf_login_pass;
	
	boolean idcheck = false;
	boolean passcheck = false;
	
	ArrayList<String> idarr = new ArrayList<>();
	ArrayList<String> passarr = new ArrayList<>();

	public static void main(String[] args) {
		Login frame = new Login();
		frame.setVisible(true);
	}

	public Login() {
		setTitle("웨더리쉬");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 720, 480);
		setResizable(false);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/Icon.png");
		setIconImage(img);
		
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Rectangle r = getVisibleRect();
				g.drawImage(Icon_back_login.getImage(), 0, 0, r.width, r.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lb_login = new JLabel(Icon_login);
		JLabel lb_id = new JLabel(Icon_id);
		JLabel lb_pass = new JLabel(Icon_pass);
		JLabel lb_logo = new JLabel(Icon_logo);
		tf_login_id = new JTextField();
		tf_login_pass = new JPasswordField();
		JButton btn_login = new JButton(Icon_btn_login);
		JButton btn_login_join = new JButton(Icon_btn_join);

		lb_id.setBounds(225, 215, 55, 35);
		lb_pass.setBounds(160, 265, 125, 35);
		lb_logo.setBounds(265, 20, 200, 170);
		lb_login.setBounds(80, 120, 190, 90);
		tf_login_id.setBounds(290, 215, 285, 30);
		tf_login_pass.setBounds(290, 265, 285, 30);
		btn_login.setBounds(150, 330, 200, 30);
		btn_login_join.setBounds(375, 330, 200, 30);

		tf_login_id.setColumns(10);
		tf_login_pass.setColumns(10);

		btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					idarr = DBmethod.getUserId();
					passarr = DBmethod.getUserPass();

					if (idarr.contains(tf_login_id.getText())) {
						idcheck = true;
					} else {
						idcheck = false;
					}

					if (passarr.contains(tf_login_pass.getText())) {
						passcheck = true;
					} else {
						passcheck = false;
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!idcheck) {
					JOptionPane.showMessageDialog(null, "아이디가 존재 하지 않습니다.", "아이디가 존재 하지 않습니다.",
							JOptionPane.ERROR_MESSAGE);
				} else if (!passcheck) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치 하지 않습니다.", "비밀번호가 일치 하지 않습니다.",
							JOptionPane.ERROR_MESSAGE);
				} else if (idcheck && passcheck) {
					JOptionPane.showMessageDialog(null, "로그인 완료", "로그인 완료", JOptionPane.INFORMATION_MESSAGE);
					if (tf_login_id.getText().equals("admin")) {
						adminPage ap = new adminPage();
						ap.setVisible(true);
						dispose();
					} else {
						Main main = new Main(tf_login_id.getText());
						main.setVisible(true);
						dispose();
					}
				}

			}
		});

		btn_login_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				join join = new join();
				dispose();
				join.setVisible(true);

			}
		});

		contentPane.add(lb_id);
		contentPane.add(lb_pass);
		contentPane.add(lb_login);
		contentPane.add(lb_logo);
		contentPane.add(tf_login_id);
		contentPane.add(tf_login_pass);
		contentPane.add(btn_login);
		contentPane.add(btn_login_join);
	}
}