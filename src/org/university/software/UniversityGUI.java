package org.university.software;
import java.util.ArrayList;
//imports to allow us to use swing (needed for GUI)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.hrs.system.HRGUI.MenuListener;
public class UniversityGUI extends JFrame{
	private University U;
	private JMenuBar menuBar;		//the horizontal container
	private JMenu file;		//JMenu objects are added to JMenuBar objects as the "tabs"
	private JMenu stu;	
	private JMenu admin;	
	
	//File Submenus
	private JMenuItem save; 
	private JMenuItem load; 
	private JMenuItem exit; 
	
	//Student Submenus
	private JMenuItem add_c;
	private JMenuItem drop_c;
	private JMenuItem print_sched;
	
	//Administrator submenus
	private JMenuItem print_all_info;
	private JMenuItem newCC;
	private JMenuItem newOC;
	private JMenuItem assignCR;
	
	public UniversityGUI(String windowTitle, University U1)  {
		
		super(windowTitle);
		setSize(300, 100);
		this.U = U1;
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JLabel("<HTML><center>welcome message</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}
	public void buildGUI() {
		menuBar = new JMenuBar();
		
		// MENU ITEMS
		
		file = new JMenu("File");
		admin = new JMenu("Administrator");
		stu = new JMenu("Student");
		
		//FILE SUBMENU ITEMS
		save = new JMenuItem("Save");
		load = new JMenuItem("Load");
		exit = new JMenuItem("Exit");
		
		//STUDENT SUBMENU ITEMS
		 add_c = new JMenuItem("Add Course");
		 drop_c = new JMenuItem("Drop Course");
		 print_sched = new JMenuItem("Print Schedule");
		
		
		//ADMIN SUBMENU ITEMS
		 print_all_info = new JMenuItem("Print All Info");
		 newCC = new JMenuItem("New Campus Course");
		 newOC = new JMenuItem("New Online Course");
		 assignCR = new JMenuItem("Assign Course Classroom");
		 
		 //for each menu item, need to add an action listener.
		 //The innerclass is implementing ActionListener, so it can take action when the JMenuItem is clicked.
		 save.addActionListener(new MenuListener());		
		 load.addActionListener(new MenuListener());		
		 exit.addActionListener(new MenuListener());		
		 
		 add_c.addActionListener(new MenuListener());		
		 drop_c.addActionListener(new MenuListener());	
		 print_sched.addActionListener(new MenuListener());		
		 
		 print_all_info.addActionListener(new MenuListener());		
		 newCC.addActionListener(new MenuListener());		
		 newOC.addActionListener(new MenuListener());		
		 assignCR.addActionListener(new MenuListener());		
		 
		 //now assign the submenus to their menu items
		 file.add(save);
		 file.add(load);
		 file.add(exit);
		 
		 stu.add(add_c);
		 stu.add(drop_c);
		 stu.add(print_sched);
		 
		 admin.add(print_all_info);
		 admin.add(newCC);
		 admin.add(newOC);
		 admin.add(assignCR);
		
		 menuBar.add(file);
		 menuBar.add(stu);
		 menuBar.add(admin);
		 setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JMenuItem source = (JMenuItem)(e.getSource());

			if(source.equals(save)){
				f_save();	
			}
			else if(source.equals(load))
			{
				f_load();
			}
			else if(source.equals(exit)) {
				f_exit();
			}
			else if(source.equals(add_c)) {
				s_add_c();
			}
			else if(source.equals(add_c)) {
				s_drop_c();
			}
			else if(source.equals(add_c)) {
				s_print_sched();
			}
			else if(source.equals(print_all_info)) {
				a_print_all_info();
			} 
			else if(source.equals(newCC)) {
				a_newCC();
			} 
			else if(source.equals(newOC)) {
				a_newOC();
			} 
			else if(source.equals(assignCR)) {
				a_assignCR();
			} 
			
		}
		public void f_save() {
			University.save_data(U);
		} 
		
		public void f_load() {}
		public void f_exit() {}
		
		public void s_add_c() {}
		public void s_drop_c() {}
		public void s_print_sched() {}
		
		public void a_print_all_info() {}
		public void a_newCC() {}
		public void a_newOC() {}
		public void a_assignCR() {}
	}
	

}

