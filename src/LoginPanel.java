import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class LoginPanel extends JPanel {
	
	private JPanel titlePanel;
	private JLabel imgLabel;
	private JLabel headLabel;
	private JLabel subHeadLabel;
	
	private JPanel memberPanel;
	private JLabel titleLabel;
	private JLabel subtitleLabel1;
	private JLabel subtitleLabel2;
	private JTextField userIDField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton registerLabel;
	
	private JPanel centerPanel;
	private JLabel centerLabel;
	
	private JPanel dbPanel;
	private JLabel tLabel;
	private JLabel stLabel1;
	private JLabel stLabel2;
	private JTextArea courseInfoField;
	private JButton submitButton;
	
	private JPanel creditPanel;
	private JLabel creditLabel;
	
	private boolean loginBefore = false;
	
	public LoginPanel() {
		createComp();
		setLayout(new BorderLayout());
		setBackground(Color.white);
		add(this.titlePanel,BorderLayout.NORTH);
		add(this.memberPanel,BorderLayout.WEST);
		add(this.centerPanel,BorderLayout.CENTER);
		add(this.dbPanel,BorderLayout.EAST);
		add(this.creditPanel,BorderLayout.SOUTH);
	}
	
	public void createComp() {
		this.titlePanel = new JPanel();
		this.titlePanel.setPreferredSize(new Dimension(1214,200));
		this.titlePanel.setLayout(new GridBagLayout());
		this.titlePanel.setBackground(Color.white);
		GridBagConstraints tp = new GridBagConstraints();
		tp.anchor = GridBagConstraints.SOUTHWEST;
		tp.insets = new Insets(0,-120,5,0);
		tp.gridx = 0;
		tp.gridy = 0;
		tp.gridheight = 2;
		this.imgLabel = new JLabel(new ImageIcon(new ImageIcon("img/logo.png").getImage().getScaledInstance(115, 144, Image.SCALE_SMOOTH)));
		this.titlePanel.add(imgLabel,tp);
		tp.insets = new Insets(80,25,0,0);
		tp.gridx = 1;
		tp.gridheight = 1;
		this.headLabel = new JLabel("NCCU Course Schedule Planner");
		this.headLabel.setFont(new Font("Avenir-BlackOblique",Font.PLAIN,50));
		this.titlePanel.add(headLabel,tp);
		tp.insets = new Insets(5,25,0,0);
		tp.gridy = 1;
		this.subHeadLabel = new JLabel("\"see see ur schedule\"");
		this.subHeadLabel.setFont(new Font("Avenir-LightOblique",Font.PLAIN,36));
		this.titlePanel.add(subHeadLabel,tp);
		
		this.memberPanel = new JPanel();
		this.memberPanel.setLayout(new GridBagLayout());
		this.memberPanel.setBackground(Color.white);
		this.memberPanel.setPreferredSize(new Dimension(550,450));
		
		GridBagConstraints r1 = new GridBagConstraints();
		r1.insets = new Insets(40,80,0,0);
		r1.gridx = 0;
		r1.gridy = 0;
		r1.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints r2 = new GridBagConstraints();
		r2.insets = new Insets(10,80,0,0);
		r2.gridx = 0;
		r2.gridy = 1;
		r2.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints r3 = new GridBagConstraints();
		r3.insets = new Insets(5,80,0,0);
		r3.gridx = 0;
		r3.gridy = 2;
		r3.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints r4 = new GridBagConstraints();
		r4.insets = new Insets(15,80,0,0);
		r4.gridx = 0;
		r4.gridy = 3;
		r4.ipady = 12;
		r4.fill = GridBagConstraints.HORIZONTAL;
		
		GridBagConstraints r5 = new GridBagConstraints();
		r5.insets = new Insets(7,80,0,0);
		r5.gridx = 0;
		r5.gridy = 4;
		r5.ipady = 12;
		r5.fill = GridBagConstraints.HORIZONTAL;

		GridBagConstraints r6 = new GridBagConstraints();
		r6.insets = new Insets(15,80,50,0);
		r6.gridx = 0;
		r6.gridy = 5;
		r6.anchor = GridBagConstraints.EAST;
		
		this.titleLabel = new JLabel("登入以保存您的預排課表紀錄");
		this.titleLabel.setFont(new Font("Avenir-Medium",Font.PLAIN,28));
		this.titleLabel.setForeground(new Color(106,185,195));
		this.memberPanel.add(titleLabel,r1);
		
		this.subtitleLabel1 = new JLabel("協助保存此次登入操作，以便下次登入時");
		this.subtitleLabel1.setFont(new Font("Avenir",Font.PLAIN,20));
		this.subtitleLabel1.setForeground(new Color(122,122,122));
		this.memberPanel.add(subtitleLabel1,r2);
		
		this.subtitleLabel2 = new JLabel("快速存取。");
		this.subtitleLabel2.setFont(new Font("Avenir",Font.PLAIN,20));
		this.subtitleLabel2.setForeground(new Color(122,122,122));
		this.memberPanel.add(subtitleLabel2,r3);
		
		this.userIDField = new JTextField("  帳號/學號 ID");
		this.userIDField.setFont(new Font("Avenir",Font.PLAIN,20));
		this.userIDField.setForeground(new Color(120,120,120));
		this.userIDField.setBackground(new Color(182,220,224));
		this.memberPanel.add(userIDField,r4);
		addFocusListener1();
		
		this.passwordField = new JPasswordField("  密碼 Password");
		this.passwordField.setEchoChar((char)0);
		this.passwordField.setFont(new Font("Avenir",Font.PLAIN,20));
		this.passwordField.setForeground(new Color(120,120,120));
		this.passwordField.setBackground(new Color(182,220,224));
		this.memberPanel.add(passwordField,r5);
		addFocusListener2();
		
		this.loginButton = new JButton("Log-In");
		this.loginButton.setFont(new Font("Avenir-Heavy",Font.PLAIN,22));
		this.loginButton.setForeground(new Color(106,185,195));
		this.loginButton.setFocusable(false); 
		
		Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
		fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		this.registerLabel = new JButton("Join now!");
		this.registerLabel.setFont(new Font("Avenir",Font.PLAIN,20).deriveFont(fontAttributes));
		this.registerLabel.setForeground(new Color(86,122,154));
		this.registerLabel.setBorderPainted(false);
		this.registerLabel.setOpaque(false);
		this.registerLabel.setBackground(Color.WHITE);
		
		JPanel buttonSet = new JPanel();
		buttonSet.setBackground(Color.WHITE);
		buttonSet.setLayout(new GridBagLayout());
		GridBagConstraints bs = new GridBagConstraints();
		bs.fill = GridBagConstraints.BOTH;
		bs.gridx = 0;
		buttonSet.add(registerLabel,bs);
		bs.gridx = 1;
		bs.ipadx = 50;
		bs.ipady = 15;
		bs.fill = GridBagConstraints.BOTH;
		buttonSet.add(loginButton,bs);

		this.memberPanel.add(buttonSet,r6);
		
		this.centerPanel = new JPanel();
		this.centerPanel.setPreferredSize(new Dimension(60,400));
		this.centerPanel.setBackground(Color.white);
		this.centerPanel.setLayout(new GridBagLayout());
		GridBagConstraints center = new GridBagConstraints();
		center.fill = GridBagConstraints.VERTICAL;
		this.centerLabel = new JLabel(new ImageIcon(new ImageIcon("img/centerline.png").getImage().getScaledInstance(25, 356, Image.SCALE_SMOOTH)));
		this.centerPanel.add(centerLabel,center);
		
		GridBagConstraints d1 = new GridBagConstraints();
		d1.insets = new Insets(39,0,0,90);
		d1.gridx = 0;
		d1.gridy = 0;
		d1.fill = GridBagConstraints.HORIZONTAL;
		d1.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints d2 = new GridBagConstraints();
		d2.insets = new Insets(11,0,0,90);
		d2.gridx = 0;
		d2.gridy = 1;
		d2.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints d3 = new GridBagConstraints();
		d3.insets = new Insets(5,0,0,90);
		d3.gridx = 0;
		d3.gridy = 2;
		d3.fill = GridBagConstraints.BOTH;
		d3.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints d4 = new GridBagConstraints();
		d4.insets = new Insets(15,0,0,90);
		d4.gridx = 0;
		d4.gridy = 3;
		d4.ipady = 70;
		d4.fill = GridBagConstraints.BOTH;
		d4.anchor = GridBagConstraints.WEST;
		
		GridBagConstraints d6 = new GridBagConstraints();
		d6.insets = new Insets(15,0,50,90);
		d6.gridx = 0;
		d6.gridy = 5;
		d6.ipadx = 50;
		d6.ipady = 15;
		d6.anchor = GridBagConstraints.EAST;
		
		this.dbPanel = new JPanel();
		this.dbPanel.setBackground(Color.white);
		this.dbPanel.setPreferredSize(new Dimension(550,450));
		this.dbPanel.setLayout(new GridBagLayout());
		this.tLabel = new JLabel("直接輸入課程代碼或課程名稱");
		this.tLabel.setFont(new Font("Avenir-Medium",Font.PLAIN,28));
		this.tLabel.setForeground(new Color(240,85,67));
		this.dbPanel.add(tLabel,d1);
		
		this.stLabel1 = new JLabel("輸入課程代碼或課程名稱，使用連字號 (-) ");
		this.stLabel1.setFont(new Font("Avenir",Font.PLAIN,20));
		this.stLabel1.setForeground(new Color(122,122,122));
		this.dbPanel.add(stLabel1,d2);
		
		this.stLabel2 = new JLabel("將它們連起。");
		this.stLabel2.setFont(new Font("Avenir",Font.PLAIN,20));
		this.stLabel2.setForeground(new Color(122,122,122));
		this.dbPanel.add(stLabel2,d3);
		
		this.courseInfoField = new JTextArea("  XXX306XXX-000111222-程式設計二");
		this.courseInfoField.setLineWrap(true);
		this.courseInfoField.setFont(new Font("Avenir",Font.PLAIN,20));
		this.courseInfoField.setForeground(new Color(120,120,120));
		this.courseInfoField.setBackground(new Color(248,170,161));
		this.dbPanel.add(new JScrollPane(courseInfoField),d4);
		addFocusListener3();
		
		this.submitButton = new JButton("Submit");
		this.submitButton.setFont(new Font("Avenir-Heavy",Font.PLAIN,22));
		this.submitButton.setForeground(new Color(240,85,67));
		this.submitButton.setFocusable(false); 
		this.dbPanel.add(submitButton,d6);
		
		this.creditPanel = new JPanel();
		this.creditPanel.setBackground(Color.white);
		this.creditPanel.setLayout(new GridBagLayout());
		GridBagConstraints credit = new GridBagConstraints();
		credit.fill = GridBagConstraints.HORIZONTAL;
		credit.insets = new Insets(15,0,25,0);
		this.creditLabel = new JLabel("2021 NCCU OOP Project Group 4");
		this.creditLabel.setFont(new Font("Avenir-BookOblique",Font.PLAIN,22));
		this.creditLabel.setForeground(new Color(122,122,122));
		this.creditPanel.add(creditLabel,credit);
	}

	public JTextArea getCourseInfoField() {
		return this.courseInfoField;
	}
	
	//輸入提示字樣
	public void addFocusListener1() {
		class InputHintListener implements FocusListener{
		    public void focusGained(FocusEvent e) {
		    	if(userIDField.getText().equals("  帳號/學號 ID")) {
		    		userIDField.setText("");
		    	}
		    	userIDField.setForeground(new Color(70,70,70));
		    }
		    public void focusLost(FocusEvent e) {
		    	if(userIDField.getText().equals("")) {
		    		userIDField.setForeground(new Color(120,120,120));
			    	userIDField.setText("  帳號/學號 ID");
		    	}
		    }
		}
		FocusListener f = new InputHintListener();
		this.userIDField.addFocusListener(f);
	}
	
	public void addFocusListener2() {
		class InputHintListener implements FocusListener{
		    public void focusGained(FocusEvent e) {
		    	passwordField.setText("");
		    	passwordField.setEchoChar('\u2022');
		    	passwordField.setForeground(new Color(70,70,70));
		    }
		    public void focusLost(FocusEvent e) {
		    	String pass = new String(passwordField.getPassword());
		    	if(pass.equals("")) {
		    		passwordField.setForeground(new Color(120,120,120));
		    		passwordField.setEchoChar((char)0);
		    		passwordField.setText("  密碼 Password");
		    	}
		    	else {
		    		passwordField.setEchoChar('\u2022');
		    	}
		    }
		}
		FocusListener f = new InputHintListener();
		this.passwordField.addFocusListener(f);
	}
	
	public void addFocusListener3() {
		class InputHintListener implements FocusListener{
		    public void focusGained(FocusEvent e) {
		    	if(courseInfoField.getText().equals("  XXX306XXX-000111222-程式設計二")) {
		    		courseInfoField.setText("");
		    	}
		    	courseInfoField.setForeground(new Color(70,70,70));
		    }
		    public void focusLost(FocusEvent e) {
		    	if(courseInfoField.getText().equals("")) {
		    		courseInfoField.setForeground(new Color(120,120,120));
		    		courseInfoField.setText("  XXX306XXX-000111222-程式設計二");
		    	}
		    }
		}
		FocusListener f = new InputHintListener();
		this.courseInfoField.addFocusListener(f);
	}
	
	//會員登入按鈕
	public void addButtonListener1(JPanel main,SchedulePanel result) {
		class ClickListener implements ActionListener {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				try {
					int user = Integer.parseInt(userIDField.getText());
					char[] password = passwordField.getPassword();
					if(Query.loginVerify(user,password)) {
						if(loginBefore == true) {
							result.recordMemberID(user);
							result.recordMemberName(user);
							result.setMemberNameLabel();
							result.updateTimeTable(Query.dbGetResult(Integer.toString(user))[1]);
							result.updateCurrentCoursePanel();
							((CardLayout)main.getLayout()).show(main,"schedule");
						}
						else {
							loginBefore = true;
							result.recordMemberID(user);
							result.recordMemberName(user);
							result.setMemberNameLabel();
							result.createTimeTable(Query.dbGetResult(Integer.toString(user))[1]);
							result.createCurrentCoursePanel(Query.dbGetResult(Integer.toString(user))[0]);
							((CardLayout)main.getLayout()).show(main,"schedule");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "帳號或密碼輸入錯誤，\n請重新輸入。");
					}
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "帳號或密碼輸入錯誤，\n請重新輸入。");
				}
				finally {
					userIDField.setText("");
					passwordField.setText("");
				}
			}
		}
		ActionListener button = new ClickListener();
		this.loginButton.addActionListener(button);
	}
	
	//訪客查詢按鈕
	public void addButtonListener2(JPanel main,SchedulePanel result) {
		class ClickListener implements ActionListener {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				String cI = courseInfoField.getText();
				if(loginBefore == true) {
					if(cI.equals("")||cI.equals("  XXX306XXX-000111222-程式設計二")) {
						//nothing happens
					}
					else {
						ArrayList<String> extraList = new ArrayList<String>();
						for (String course:cI.split("-")) {
							extraList.add(course);
						}
						Query.dbSearch("Search",extraList);
					}
					result.recordVisitor("Search");
					result.recordMemberName(0);
					result.setMemberNameLabel();
					result.updateTimeTable(Query.dbGetResult("Search")[1]);
					result.updateCurrentCoursePanel();
					((CardLayout)main.getLayout()).show(main,"schedule");
				}
				else {
					loginBefore = true;
					result.recordVisitor("Search");
					result.recordMemberName(0);
					result.setMemberNameLabel();
					Query.visitorInitSearch(cI);
					result.createTimeTable(Query.dbGetResult("Search")[1]);
					result.createCurrentCoursePanel(Query.dbGetResult("Search")[0]);
					((CardLayout)main.getLayout()).show(main,"schedule");
				}
			}
		}
		ActionListener button = new ClickListener();
		this.submitButton.addActionListener(button);
	}
	
	//註冊按鈕
	public void addButtonListener3(JPanel main,RegisterPanel regis) {
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				((CardLayout)main.getLayout()).show(main,"register");
			}
		}
		ActionListener button = new ClickListener();
		this.registerLabel.addActionListener(button);
	}
	
}
