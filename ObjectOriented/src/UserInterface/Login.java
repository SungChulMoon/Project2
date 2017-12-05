package UserInterface;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import InnerClass.DBmethod;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/**
 * �������� ������ DB���� ������ ���̵�� �н����带 ���Ͽ� �α��ν�Ű�� Ŭ����
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
	private JTextField tf_id_login;
	private JPasswordField tf_pass_login;
	boolean idcheck = false;
	boolean passcheck = false;
	ArrayList<String> idarr = new ArrayList<>();
	ArrayList<String> passarr = new ArrayList<>();

	public static void main(String[] args) {

		Login frame = new Login();
		frame.setVisible(true);

	}

	public Login() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("img/Icon.png");
		setIconImage(img);
		
		JLabel lb_login = new JLabel(Icon_login);
		JLabel lb_id = new JLabel(Icon_id);
		JLabel lb_pass = new JLabel(Icon_pass);
		tf_id_login = new JTextField();
		tf_pass_login = new JPasswordField();
		JButton btn_login = new JButton(Icon_btn_login);
		JButton btn_join_login = new JButton(Icon_btn_join);
		JLabel lb_logo = new JLabel(Icon_logo);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Rectangle r = getVisibleRect();
				g.drawImage(Icon_back_login.getImage(), 0, 0, r.width, r.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		setTitle("��������");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 720, 480);
		setResizable(false);

		contentPane.setLayout(null);
		setContentPane(contentPane);

		lb_login.setBounds(100, 100, 190, 90);
		lb_id.setBounds(223, 195, 54, 35);
		lb_pass.setBounds(150, 235, 125, 35);
		tf_id_login.setBounds(290, 195, 284, 30);
		tf_pass_login.setBounds(290, 235, 284, 30);
		btn_login.setBounds(150, 300, 200, 30);
		lb_logo.setBounds(284, 16, 198, 169);
		
		btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					idarr = DBmethod.getUserId();
					passarr = DBmethod.getUserPass();

					if (idarr.contains(tf_id_login.getText())) {
						idcheck = true;
					} else {
						idcheck = false;
					}

					if (passarr.contains(tf_pass_login.getText())) {
						passcheck = true;
					} else {
						passcheck = false;
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!idcheck) {
					JOptionPane.showMessageDialog(null, "���̵� ���� ���� �ʽ��ϴ�.", "���̵� ���� ���� �ʽ��ϴ�.",
							JOptionPane.ERROR_MESSAGE);
				} else if (!passcheck) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ ���� �ʽ��ϴ�.", "��й�ȣ�� ��ġ ���� �ʽ��ϴ�.",
							JOptionPane.ERROR_MESSAGE);
				} else if (idcheck && passcheck) {
					JOptionPane.showMessageDialog(null, "�α��� �Ϸ�", "�α��� �Ϸ�", JOptionPane.INFORMATION_MESSAGE);
					if (tf_id_login.getText().equals("admin")) {
						adminPage ap = new adminPage();
						ap.setVisible(true);
						dispose();
					} else {
						Main main = new Main(tf_id_login.getText());
						main.setVisible(true);
						dispose();
					}
				}

			}
		});

		btn_join_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				join join = new join();
				dispose();
				join.setVisible(true);

			}
		});
		
		tf_id_login.setColumns(10);
		tf_pass_login.setColumns(10);
		contentPane.add(lb_login);
		contentPane.add(lb_id);
		contentPane.add(lb_pass);
		contentPane.add(tf_id_login);
		contentPane.add(tf_pass_login);
		contentPane.add(btn_login);
		contentPane.add(btn_join_login);
		contentPane.add(lb_logo);


	}

}