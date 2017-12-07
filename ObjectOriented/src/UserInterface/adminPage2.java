package UserInterface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import InnerClass.CodiOb;
import InnerClass.DBmethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;;
/**
 * 관리자가 추가할 코디정보를 DB로 보내고 저장하는  GUI클래스
 * 
 * @author Jaecheol
 * @see JFrame
 * 
 */
public class adminPage2 extends JFrame {
	ImageIcon Icon_back_admin2 = new ImageIcon("img/lb_back_admin2.png");
	/** JLabel에 적용할 "파일" 글자를 나타내는 ImageIcon*/
	ImageIcon Icon_lb_admin_file = new ImageIcon("img/lb_admin_file.png");
	/** JLabel에 적용할 "성별" 글자를 나타내는 ImageIcon*/
	ImageIcon Icon_lb_admin_gender = new ImageIcon("img/lb_admin_gender.png");
	/** JLabel에 적용할 "종류" 글자를 나타내는 ImageIcon*/
	ImageIcon Icon_lb_admin_type = new ImageIcon("img/lb_admin_type.png");
	/** JLabel에 적용할 "계절감" 글자를 나타내는 ImageIcon*/
	ImageIcon Icon_lb_admin_season = new ImageIcon("img/lb_admin_season.png");
	/** JLabel에 적용할 "두께감" 글자를 나타내는 ImageIcon*/
	ImageIcon Icon_lb_admin_thick = new ImageIcon("img/lb_admin_thick.png");
	/** JLabel에 적용할 "스타일" 글자를 나타내는 ImageIcon*/
	ImageIcon Icon_lb_admin_style = new ImageIcon("img/lb_admin_style.png");
	/** JLabel에 적용할 "체형" 글자를 나타내는 ImageIcon*/
	ImageIcon Icon_lb_admin_body = new ImageIcon("img/lb_admin_body.png");
	/** JLabel에 적용할 "링크" 글자를 나타내는 ImageIcon*/
	ImageIcon Icon_lb_admin_link = new ImageIcon("img/lb_admin_link.png");
	String gender ="여자";
	String clothpath ="outer";
	String genderpath ="woman";
	/** 성별 선택 시 "여자"를 선택하는 라디오버튼*/
	JRadioButton rd_w = new JRadioButton("여자",true);
	/** 성별 선택 시 "남자"를 선택하는 라디오버튼*/
	JRadioButton rd_m = new JRadioButton("남자");
	/** 종류 선택 시 "outer"를 선택하는 라디오버튼*/
	JRadioButton rd_outer = new JRadioButton("outer",true);
	/** 종류 선택 시 "top"를 선택하는 라디오버튼*/
	JRadioButton rd_top = new JRadioButton("top");
	/** 종류 선택 시 "pants"를 선택하는 라디오버튼*/
	JRadioButton rd_pants = new JRadioButton("pants");
	/** 종류 선택 시 "shoes"를 선택하는 라디오버튼*/
	JRadioButton rd_shoes = new JRadioButton("shoes");
	/** 계절감 수치를 선택하는 콤보박스*/
	JComboBox cb_season = new JComboBox();
	/** 스타일1의 수치를 선택하는 콤보박스*/
	JComboBox cb_style1 = new JComboBox();
	/** 스타일2의 수치를 선택하는 콤보박스*/
	JComboBox cb_style2 = new JComboBox();
	/** 스타일3의 수치를 선택하는 콤보박스*/
	JComboBox cb_style3 = new JComboBox();
	/** 스타일4의 수치를 선택하는 콤보박스*/
	JComboBox cb_style4 = new JComboBox();
	/** 체형1의 수치를 선택하는 콤보박스*/
	JComboBox cb_body1 = new JComboBox();
	/** 체형2의 수치를 선택하는 콤보박스*/
	JComboBox cb_body2 = new JComboBox();
	/** 체형3의 수치를 선택하는 콤보박스*/
	JComboBox cb_body3 = new JComboBox();
	/** 체형4의 수치를 선택하는 콤보박스*/
	JComboBox cb_body4 = new JComboBox();
	private JPanel contentPane;
	private JTextField tf_fileName;
	private JTextField tf_link;
	File selectedFile;

	public adminPage2() {
		setTitle("웨더리쉬");
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
		JLabel lb_style1 = new JLabel("시크");
		JLabel lb_style2 = new JLabel("큐티");
		JLabel lb_style3 = new JLabel("섹시");
		JLabel lb_style4 = new JLabel("빈티지");
		JLabel lb_body = new JLabel(Icon_lb_admin_body);
		JLabel lb_body1 = new JLabel("몸1");
		JLabel lb_body2 = new JLabel("몸2");
		JLabel lb_body3 = new JLabel("몸3");
		JLabel lb_body4 = new JLabel("몸4");
		JLabel lb_link = new JLabel(Icon_lb_admin_link);
		tf_fileName = new JTextField();
		tf_link = new JTextField();
		JButton btn_back = new JButton(new ImageIcon("img/lb_back.png"));
		JButton btn_directory = new JButton(new ImageIcon("img/btn_folder.png"));
		JButton btn_regist = new JButton(new ImageIcon("img/btn_admit_regist.png"));
		JComboBox cb_thick = new JComboBox();

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
		cb_body1.setBounds(372, 343, 53, 24);
		cb_body2.setBounds(498, 340, 53, 24);
		cb_body3.setBounds(620, 343, 53, 24);
		cb_body4.setBounds(746, 343, 53, 24);
		cb_thick.setBounds(620, 215, 69, 24);
		cb_style1.setBounds(372, 275, 53, 24);
		cb_style2.setBounds(498, 275, 53, 24);
		cb_style3.setBounds(620, 275, 53, 24);
		cb_style4.setBounds(746, 275, 53, 24);
		
		rd_w.addItemListener(new itemlisten());
		rd_m.addItemListener(new itemlisten());
		rd_outer.addItemListener(new itemlisten());
		rd_pants.addItemListener(new itemlisten());
		rd_top.addItemListener(new itemlisten());
		rd_shoes.addItemListener(new itemlisten());
		
		rd_w.setFont(new Font("굴림", Font.PLAIN, 17));
		rd_m.setFont(new Font("굴림", Font.PLAIN, 17));
		rd_outer.setFont(new Font("굴림", Font.PLAIN, 17));
		rd_top.setFont(new Font("굴림", Font.PLAIN, 17));
		rd_pants.setFont(new Font("굴림", Font.PLAIN, 17));
		rd_shoes.setFont(new Font("굴림", Font.PLAIN, 17));
		lb_style1.setFont(new Font("굴림", Font.PLAIN, 17));
		lb_style2.setFont(new Font("굴림", Font.PLAIN, 17));
		lb_style3.setFont(new Font("굴림", Font.PLAIN, 17));
		lb_style4.setFont(new Font("굴림", Font.PLAIN, 17));
		lb_body1.setFont(new Font("굴림", Font.PLAIN, 17));
		lb_body2.setFont(new Font("굴림", Font.PLAIN, 17));
		lb_body3.setFont(new Font("굴림", Font.PLAIN, 17));
		lb_body4.setFont(new Font("굴림", Font.PLAIN, 17));

		btn_back.setBorderPainted(false);
		btn_directory.setBorderPainted(false);
		
		tf_fileName.setColumns(10);
		tf_link.setColumns(10);

		rd_w.setBackground(Color.WHITE);
		rd_m.setBackground(Color.WHITE);
		rd_outer.setBackground(Color.WHITE);
		rd_top.setBackground(Color.WHITE);
		rd_pants.setBackground(Color.WHITE);
		rd_shoes.setBackground(Color.WHITE);
		btn_directory.setBackground(Color.WHITE);
		
		rd_w.setForeground(new Color(5, 97, 232));
		rd_m.setForeground(new Color(5, 97, 232));
		rd_outer.setForeground(new Color(5, 97, 232));
		rd_top.setForeground(new Color(5, 97, 232));
		rd_pants.setForeground(new Color(5, 97, 232));
		rd_shoes.setForeground(new Color(5, 97, 232));
		lb_style1.setForeground(new Color(5, 97, 232));
		lb_style2.setForeground(new Color(5, 97, 232));
		lb_style3.setForeground(new Color(5, 97, 232));
		lb_style4.setForeground(new Color(5, 97, 232));
		lb_body1.setForeground(new Color(5, 97, 232));
		lb_body2.setForeground(new Color(5, 97, 232));
		lb_body3.setForeground(new Color(5, 97, 232));
		lb_body4.setForeground(new Color(5, 97, 232));

		for (int i = 0; i < 6; i++)
			cb_thick.addItem(Integer.toString(i));
		for (int i = 0; i < 6; i++)
			cb_style1.addItem(Integer.toString(i));
		for (int i = 0; i < 6; i++)
			cb_style2.addItem(Integer.toString(i));
		for (int i = 0; i < 6; i++)
			cb_style3.addItem(Integer.toString(i));
		for (int i = 0; i < 6; i++)
			cb_style4.addItem(Integer.toString(i));
		for (int i = 0; i < 6; i++)
			cb_body1.addItem(Integer.toString(i));
		for (int i = 0; i < 6; i++)
			cb_body2.addItem(Integer.toString(i));
		for (int i = 0; i < 6; i++)
			cb_body3.addItem(Integer.toString(i));
		for (int i = 0; i < 6; i++)
			cb_body4.addItem(Integer.toString(i));
		
		btn_directory.addActionListener(new UploadActionListener());
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adminPage ap = new adminPage();
				ap.setVisible(true);
				dispose();
			}
		});
		
		g.add(rd_w);
		g.add(rd_m);
		contentPane.add(btn_back);
		contentPane.add(lb_fileName);
		contentPane.add(tf_fileName);
		contentPane.add(lb_gender);
		contentPane.add(rd_w);
		contentPane.add(rd_m);
		contentPane.add(lb_type);
		contentPane.add(rd_outer);
		contentPane.add(rd_pants);
		contentPane.add(rd_shoes);
		contentPane.add(lb_season);
		cb_season.addItem("WARM");
		cb_season.addItem("COLD");
		contentPane.add(cb_season);
		contentPane.add(lb_thick);
		contentPane.add(cb_thick);
		contentPane.add(lb_style);
		contentPane.add(lb_style1);
		contentPane.add(lb_style2);
		contentPane.add(lb_style3);
		contentPane.add(lb_style4);
		contentPane.add(lb_link);
		contentPane.add(cb_style1);
		contentPane.add(cb_style2);
		contentPane.add(cb_style3);
		contentPane.add(cb_style4);
		contentPane.add(tf_link);
		contentPane.add(btn_directory);
		contentPane.add(btn_regist);
		contentPane.add(lb_body);
		contentPane.add(lb_body1);
		contentPane.add(cb_body1);
		contentPane.add(lb_body2);
		contentPane.add(cb_body2);
		contentPane.add(lb_body3);
		contentPane.add(cb_body3);
		contentPane.add(lb_body4);
		contentPane.add(cb_body4);
		sort.add(rd_outer);
		sort.add(rd_top);
		sort.add(rd_pants);
		sort.add(rd_shoes);
		
		btn_regist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cnt =DBmethod.insertcodi(new CodiOb(tf_fileName.getText(),"clothes\\"+clothpath+"\\"+genderpath+"\\"+tf_fileName.getText(), (String)cb_season.getSelectedItem(), (String)cb_thick.getSelectedItem(), (String)gender, (String)tf_link.getText(), (String)clothpath,
							(String)cb_style1.getSelectedItem(), (String)cb_style2.getSelectedItem(), (String)cb_style3.getSelectedItem(), (String)cb_style4.getSelectedItem(),
							(String)cb_body1.getSelectedItem(), (String)cb_body2.getSelectedItem(), (String)cb_body3.getSelectedItem(), (String)cb_body4.getSelectedItem()));
					uploadFile(clothpath,genderpath,tf_fileName.getText());
					if(cnt>0) {
						JOptionPane.showMessageDialog(null, "등록 완료", "등록 완료", JOptionPane.INFORMATION_MESSAGE);
						adminPage ap =new adminPage();
						ap.setVisible(true);
						dispose();

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	/**마우스 클릭시 파일을 업로드 하는 클래스*/
	class UploadActionListener implements ActionListener {
	      JFileChooser chooser;

	      UploadActionListener() {
	         chooser = new JFileChooser();
	         
	         chooser.setCurrentDirectory(new File(System.getProperty("user.home")+"//"+"Desktop"));
	         
	         FileNameExtensionFilter filter=new FileNameExtensionFilter("png 파일", "png");
	         FileNameExtensionFilter filter2=new FileNameExtensionFilter("jpg 파일", "jpg");
	         
	         chooser.addChoosableFileFilter(filter);
	         chooser.addChoosableFileFilter(filter2);
	         
	      }

	      public void actionPerformed(ActionEvent e) {
	         int ret = chooser.showOpenDialog(null);
	         if (ret != JFileChooser.APPROVE_OPTION) {
	            //            JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
	            return;
	         }

	         selectedFile = chooser.getSelectedFile();
	         
	         tf_fileName.setText(selectedFile.getName());
	         

	         
	      }
	   }
	/**
	 * 코디 추가시 파일을 업로드하는 메소드
	 * 
	 * @param clothpath
	 * @param genderpath
	 * @param filename
	 */
	public void uploadFile(String clothpath,String genderpath,String filename) {
		
	      FileInputStream  fin  = null;
	      FileOutputStream fout = null;
	      int data = 0 ;

	      try{
	         fin = new FileInputStream(selectedFile.getPath());
	         fout = new FileOutputStream("clothes\\"+clothpath+"\\"+genderpath+"\\"+filename); //확장명 jpg는 바꾸면 안됨
	         while(true) {
	            data = fin.read();
	            if( data == -1) break;
	            fout.write(data); 
	         }
	         System.out.println();
	         System.out.println(selectedFile.getName() + " 저장 완료");

	      }
	      catch(IOException e1) {
	         System.out.println("파일오픈실패");
	         e1.printStackTrace();
	      }
	      finally {
	         try   {
	            fin.close();
	            fout.close();
	         }
	         catch(Exception e1) {

	         }
	      }
	      System.out.println("작업종료");
	}
	/**성별과 종류에 따라 코디 추가시 파일이 저장되는 경로를 결정하는 클래스 */
	class itemlisten implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==rd_w) {
				gender="여자";
				genderpath="woman";
			}
			else if(e.getSource()==rd_m) {
				gender="남자";
				genderpath="man";
			}
			else if(e.getSource()==rd_outer) {
				clothpath="outer";
			}
			else if(e.getSource()==rd_top) {
				clothpath="top";
			}
			else if(e.getSource()==rd_pants) {
				clothpath="pants";
			}
			else if(e.getSource()==rd_shoes) {
				clothpath="shoes";
			}
			
		}
		
	}
}