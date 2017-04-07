package crud;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class CrudGui implements ActionListener,MouseListener {
	JTextField nameTxt, emailTxt, passTxt;
	JButton btnInsert;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem userlist, adduser;
	JPanel mainPanel = new JPanel();
	UserDAOImp daoImp = new UserDAOImp();
	JPanel listUserPanel;
	JFrame frame = new JFrame();
	final static String INSERT_PANEL = "panelInsert";
	final static String List_USER_PANEL = "listUserPanel";
	ArrayList<User> list;
	JTable userTable;

	public void createGui() {
		JPanel panelInsert = new JPanel();
		panelInsert.setLayout(new GridLayout(0, 2, 10, 5));
		panelInsert.add(new JLabel("Name"));
		nameTxt = new JTextField();
		panelInsert.add(nameTxt);
		panelInsert.add(new JLabel("Email"));
		emailTxt = new JTextField();
		panelInsert.add(emailTxt);
		panelInsert.add(new JLabel("Password"));
		passTxt = new JTextField();
		panelInsert.add(passTxt);
		panelInsert.add(new JLabel(""));
		btnInsert = new JButton("NEW USER");
		btnInsert.addActionListener(this);
		panelInsert.add(btnInsert);
		mainPanel.setLayout(new CardLayout());
		mainPanel.add(panelInsert, INSERT_PANEL);
		showUserGui(listUserPanel);
		mainPanel.add(listUserPanel, List_USER_PANEL);
		frame.add(mainPanel);
		CardLayout card = (CardLayout) mainPanel.getLayout();
		card.show(mainPanel, INSERT_PANEL);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(createMenu());
		frame.pack();
		frame.setVisible(true);

	}

	public void showUserGui(JPanel mainpanel) {
		listUserPanel = new JPanel();
		list = (ArrayList<User>) daoImp.getAllUsers();
		userTable = new JTable();
		userTable.addMouseListener(this);
		JScrollPane jScrollPane = new JScrollPane(userTable);
		showDataInTable(list, userTable);
		listUserPanel.add(jScrollPane);
	}

	public void showDataInTable(ArrayList<User> list, JTable userTable) {

		DefaultTableModel model = new DefaultTableModel(new Object[] { "ID", "NAME", "EMAIL", "PASSWORD" }, 0);
		for (User user : list) {
			model.addRow(new Object[] { user.getId(), user.getName(), user.getEmail(), user.getPassord() });
		}
		userTable.setModel(model);
	}

	public JMenuBar createMenu() {
		menubar = new JMenuBar();
		menu = new JMenu("User");
		adduser = new JMenuItem("New User");
		adduser.addActionListener(this);
		userlist = new JMenuItem("Users List");
		userlist.addActionListener(this);
		menubar.add(menu);
		menu.add(adduser);
		menu.add(userlist);
		return menubar;
	}

	public static void main(String[] args) {
		CrudGui gui = new CrudGui();
		gui.createGui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name, email, password;
		name = nameTxt.getText();
		email = emailTxt.getText();
		password = passTxt.getText();
		if (e.getSource() == btnInsert) {
			User user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassord(password);
			if (daoImp.addUser(user)) {
				JOptionPane.showMessageDialog(frame, "User Added Successfully", " User Add Success",
						JOptionPane.WARNING_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(frame, "Unable To Add User", "Error User Add", JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == adduser) {
			CardLayout card = (CardLayout) mainPanel.getLayout();
			card.show(mainPanel, INSERT_PANEL);
		} else if (e.getSource() == userlist) {
			list = (ArrayList<User>) daoImp.getAllUsers();
			showDataInTable(list, userTable);
			CardLayout card = (CardLayout) mainPanel.getLayout();
			card.show(mainPanel, List_USER_PANEL);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int table_row_id=userTable.getSelectedRow();
		int id=Integer.parseInt(userTable.getModel().getValueAt(table_row_id, 0).toString());
		System.out.println(id);
		System.out.println(daoImp.getStudentById(id).toString());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
