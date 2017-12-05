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
		ImageIcon Icon_id = new ImageIcon("img/lb_id.png");
		ImageIcon Icon_pass = new ImageIcon("img/lb_pass.png");
		ImageIcon Icon_login = new ImageIcon("img/lb_login.png");
		ImageIcon Icon_logo = new ImageIcon("img/logo.png");

		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 720, 480);
		setTitle("��������");
		setResizable(false);
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Rectangle r = getVisibleRect();
				g.drawImage(Icon_back_login.getImage(), 0, 0, r.width, r.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel(Icon_login);
		lblNewLabel.setFont(new Font("�����ٸ����", Font.PLAIN, 40));
		lblNewLabel.setBounds(100, 100, 190, 90);
		lblNewLabel.setForeground(new Color(5, 97, 232));
		contentPane.add(lblNewLabel);

		JLabel lb_id = new JLabel(Icon_id);
		lb_id.setFont(new Font("�����ٸ����", Font.PLAIN, 18));
		lb_id.setBounds(223, 195, 54, 35);
		lb_id.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_id);

		JLabel label = new JLabel(Icon_pass);
		label.setFont(new Font("�����ٸ����", Font.PLAIN, 18));
		label.setBounds(150, 235, 125, 35);
		label.setForeground(new Color(5, 97, 232));
		contentPane.add(label);

		tf_id_login = new JTextField();
		tf_id_login.setBounds(290, 195, 284, 30);
		contentPane.add(tf_id_login);
		tf_id_login.setColumns(10);

		tf_pass_login = new JPasswordField();
		tf_pass_login.setColumns(10);
		tf_pass_login.setBounds(290, 235, 284, 30);
		contentPane.add(tf_pass_login);

		JButton btn_login = new JButton(Icon_btn_login);
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
		btn_login.setFont(new Font("����", Font.BOLD, 20));
		btn_login.setForeground(new Color(5, 97, 232));
		btn_login.setBounds(150, 300, 200, 30);
		contentPane.add(btn_login);

		JButton btn_join_login = new JButton(Icon_btn_join);
		btn_join_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				join join = new join();
				dispose();
				join.setVisible(true);

			}
		});
		btn_join_login.setFont(new Font("����", Font.PLAIN, 19));
		btn_join_login.setBounds(374, 300, 200, 30);
		btn_join_login.setForeground(new Color(5, 97, 232));
		contentPane.add(btn_join_login);

		JLabel label_1 = new JLabel(Icon_logo);
		label_1.setBounds(284, 16, 198, 169);
		contentPane.add(label_1);

	}

}