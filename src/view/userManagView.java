package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.userManagModel;
import model.userModel;
import model.provinceModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.userManagController;
import javax.swing.JRadioButton;
import java.awt.Color;

public class userManagView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public userManagModel model;
	public JTextField textField_UserID_Search;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_FullName;
	public JTextField textField_Bod;
	public JTextField textField_Subject1;
	public JTextField textField_Subject2;
	public JTextField textField_Subject3;
	public ButtonGroup btn_Gender;
	public JComboBox comboBox_HomeTown;
	public JRadioButton radioButton_Male;
	public JRadioButton radioButton_Female;
	public JComboBox comboBox_HomeTown_Search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userManagView frame = new userManagView();
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
	public userManagView() {
		this.model = new userManagModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 751);

		Action action = new userManagController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuOpen);

		JMenuItem menuSaveFile = new JMenuItem("SaveFile");
		menuSaveFile.addActionListener(action);
		menuSaveFile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuSaveFile);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setBounds(44, 144, -28, -35);
		contentPane.add(verticalBox_1);

		JLabel label_homeTown = new JLabel("Home Town");
		label_homeTown.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_homeTown.setBounds(10, 11, 102, 54);
		contentPane.add(label_homeTown);

		JLabel label_id_user = new JLabel("ID User");
		label_id_user.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_id_user.setBounds(300, 11, 155, 54);
		contentPane.add(label_id_user);

		textField_UserID_Search = new JTextField();
		textField_UserID_Search.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_UserID_Search.setColumns(10);
		textField_UserID_Search.setBounds(393, 12, 123, 54);
		contentPane.add(textField_UserID_Search);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(action);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(526, 12, 89, 54);
		contentPane.add(btnSearch);

		comboBox_HomeTown_Search = new JComboBox();
		ArrayList<provinceModel> listProvince = provinceModel.getListProvince();
		comboBox_HomeTown_Search.addItem("");
		for (provinceModel flag : listProvince) {
			comboBox_HomeTown_Search.addItem(flag.getprovincedName());
		}
		comboBox_HomeTown_Search.setBounds(120, 11, 155, 54);
		contentPane.add(comboBox_HomeTown_Search);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 92, 738, 2);
		contentPane.add(separator_1);

		JLabel label_homeTown_check = new JLabel("List User");
		label_homeTown_check.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_homeTown_check.setBounds(10, 97, 251, 54);
		contentPane.add(label_homeTown_check);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", 
						"Full Name",
						"Home Town",
						"Day Of Bith",
						"Gender",
						"Score 1",
						"Score 2",
						"Score 3" }));

		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 144, 738, 214);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 369, 738, 2);
		contentPane.add(separator_1_1);

		JLabel label_HomeTown_1 = new JLabel("Information User");
		label_HomeTown_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_HomeTown_1.setBounds(10, 369, 233, 54);
		contentPane.add(label_HomeTown_1);

		JLabel label_ID = new JLabel("ID");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_ID.setBounds(10, 412, 102, 54);
		contentPane.add(label_ID);

		textField_ID = new JTextField();
		textField_ID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_ID.setColumns(10);
		textField_ID.setBounds(127, 425, 166, 29);
		contentPane.add(textField_ID);

		JLabel label_HoVaTen = new JLabel("Full Name");
		label_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_HoVaTen.setBounds(10, 457, 102, 54);
		contentPane.add(label_HoVaTen);

		textField_FullName = new JTextField();
		textField_FullName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_FullName.setColumns(10);
		textField_FullName.setBounds(127, 470, 166, 29);
		contentPane.add(textField_FullName);

		JLabel label_FindByHomeTown = new JLabel("Home Town");
		label_FindByHomeTown.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_FindByHomeTown.setBounds(10, 510, 102, 54);
		contentPane.add(label_FindByHomeTown);

		comboBox_HomeTown = new JComboBox();
		comboBox_HomeTown.addItem("");
		for (provinceModel tinh : listProvince) {
			comboBox_HomeTown.addItem(tinh.getprovincedName());
		}

		comboBox_HomeTown.setBounds(127, 522, 166, 35);
		contentPane.add(comboBox_HomeTown);

		JLabel label_NgaySinh = new JLabel("Day of birth");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_NgaySinh.setBounds(10, 563, 155, 54);
		contentPane.add(label_NgaySinh);

		textField_Bod = new JTextField();
		textField_Bod.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Bod.setColumns(10);
		textField_Bod.setBounds(127, 576, 166, 29);
		contentPane.add(textField_Bod);

		JLabel label_ID_1 = new JLabel("Gender");
		label_ID_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_ID_1.setBounds(324, 412, 102, 54);
		contentPane.add(label_ID_1);

		radioButton_Male = new JRadioButton("Male");
		radioButton_Male.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_Male.setBounds(405, 429, 61, 23);
		contentPane.add(radioButton_Male);

		radioButton_Female = new JRadioButton("Female");
		radioButton_Female.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_Female.setBounds(489, 429, 61, 23);
		contentPane.add(radioButton_Female);

		btn_Gender = new ButtonGroup();
		btn_Gender.add(radioButton_Male);
		btn_Gender.add(radioButton_Female);

		JLabel label_Subject1 = new JLabel("Subject 1");
		label_Subject1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Subject1.setBounds(324, 473, 102, 23);
		contentPane.add(label_Subject1);

		textField_Subject1 = new JTextField();
		textField_Subject1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Subject1.setColumns(10);
		textField_Subject1.setBounds(405, 470, 166, 29);
		contentPane.add(textField_Subject1);

		JLabel label_Subject2 = new JLabel("Subject 2");
		label_Subject2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Subject2.setBounds(324, 513, 102, 23);
		contentPane.add(label_Subject2);

		textField_Subject2 = new JTextField();
		textField_Subject2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Subject2.setColumns(10);
		textField_Subject2.setBounds(405, 510, 166, 29);
		contentPane.add(textField_Subject2);

		JLabel label_Subject3 = new JLabel("Subject 3");
		label_Subject3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_Subject3.setBounds(324, 557, 102, 23);
		contentPane.add(label_Subject3);

		textField_Subject3 = new JTextField();
		textField_Subject3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Subject3.setColumns(10);
		textField_Subject3.setBounds(405, 554, 166, 29);
		contentPane.add(textField_Subject3);

		JButton btnThem = new JButton("Add");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(31, 628, 89, 42);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("Delete");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBounds(151, 628, 89, 42);
		contentPane.add(btnXoa);

		JButton btnCapNhat = new JButton("Update");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBounds(264, 628, 135, 42);
		contentPane.add(btnCapNhat);

		JButton btnLuu = new JButton("Save");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBounds(421, 628, 135, 42);
		contentPane.add(btnLuu);

		JButton btnHuyBo = new JButton("Unchecked");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyBo.setBounds(585, 628, 135, 42);
		contentPane.add(btnHuyBo);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(15, 628, 733, -22);
		contentPane.add(separator_2);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 616, 738, 2);
		contentPane.add(separator_1_1_1);

		JButton btnHuyTim = new JButton("Unchecked Find");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyTim.setBounds(631, 11, 117, 54);
		contentPane.add(btnHuyTim);

		this.setVisible(true);
	}

	public void deleteForm() {
		textField_ID.setText("");
		textField_FullName.setText("");
		textField_UserID_Search.setText("");
		textField_Bod.setText("");
		textField_Subject1.setText("");
		textField_Subject2.setText("");
		textField_Subject3.setText("");
		comboBox_HomeTown.setSelectedIndex(-1);
		btn_Gender.clearSelection();
	}

	public void addUserinTable(userModel ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getUserId() + "",
				ts.getUserName(),
				ts.getHomeTown().getprovincedName(),
				ts.getBod().getDate() + "/" + (ts.getBod().getMonth() + 1) + "/"+ (ts.getBod().getYear() + 1900),
				(ts.isGender() ? "Nam" : "N???"),
				ts.getScores0() + "", 
				ts.getScores1() + "",
				ts.getScores2() + "", });
	}

	public void addOrUpdateUser(userModel ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.addUserinTable(ts);
		} else {
			this.model.update(ts);
			int nRow = model_table.getRowCount();
			for (int i = 0; i < nRow; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getUserId() + "")) {
					model_table.setValueAt(ts.getUserId() + "", i, 0);
					model_table.setValueAt(ts.getUserName() + "", i, 1);
					model_table.setValueAt(ts.getHomeTown().getprovincedName() + "", i, 2);
					model_table.setValueAt(ts.getBod().getDate() + "/" + 
							(ts.getBod().getMonth() + 1) + "/"
							+ (ts.getBod().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((ts.isGender() ? "Nam" : "N???"), i, 4);
					model_table.setValueAt(ts.getScores0() + "", i, 5);
					model_table.setValueAt(ts.getScores1() + "", i, 6);
					model_table.setValueAt(ts.getScores2() + "", i, 7);
				}
			}
		}
	}

	public userModel getUserSelect() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int userId = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String userName = model_table.getValueAt(i_row, 1) + "";
		provinceModel province = provinceModel.getProvinceByName(model_table.getValueAt(i_row, 2) + "");
		String s_bod = model_table.getValueAt(i_row, 3) + "";
		Date bod = new Date(s_bod);
		String textGender = model_table.getValueAt(i_row, 4) + "";
		boolean gender = textGender.equals("Male");
		float scores0 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float scores1 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float scores2 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		userModel ts = new userModel(userId, userName, province, bod, gender, scores0, scores1, scores2);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		userModel ts = getUserSelect();

		this.textField_ID.setText(ts.getUserId() + "");
		this.textField_FullName.setText(ts.getUserName() + "");
		this.comboBox_HomeTown.setSelectedItem(ts.getHomeTown().getprovincedName());
		String s_ngaySinh = ts.getBod().getDate() + "/" 
				+ (ts.getBod().getMonth() + 1) + "/"
				+ (ts.getBod().getYear() + 1900);
		this.textField_Bod.setText(s_ngaySinh + "");
		if (ts.isGender()) {
			radioButton_Male.setSelected(true);
		} else {
			radioButton_Female.setSelected(true);
		}
		this.textField_Subject1.setText(ts.getScores0() + "");
		this.textField_Subject2.setText(ts.getScores1() + "");
		this.textField_Subject3.setText(ts.getScores2() + "");
	}

	public void i_Delete() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int choose = JOptionPane.showConfirmDialog(this, "Are you sure to delete the selected line?");
		if (choose == JOptionPane.YES_OPTION) {
			userModel ts = getUserSelect();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}

	}

	public void addUser() {
		// Get du lieu
		int userId = Integer.valueOf(this.textField_ID.getText());
		String userName = this.textField_FullName.getText();
		int homeTome = this.comboBox_HomeTown.getSelectedIndex() - 1;
		provinceModel province = provinceModel.getProvinceById(homeTome);
		Date bod = new Date(this.textField_Bod.getText());
		boolean gender = true;
		if (this.radioButton_Male.isSelected()) {
			gender = true;
		} else if (this.radioButton_Female.isSelected()) {
			gender = false;
		}
		float scores1 = Float.valueOf(this.textField_Subject1.getText());
		float scores2 = Float.valueOf(this.textField_Subject2.getText());
		float scores3 = Float.valueOf(this.textField_Subject3.getText());

		userModel ts = new userModel(userId, userName, province, bod, gender, scores1, scores2, scores3);
		this.addOrUpdateUser(ts);
	}

	public void Search() {
		// Goi ham huy tim kiem
		this.ResetDocument();
		
		// Thuc hien tim kiem
		int homeTown = this.comboBox_HomeTown_Search.getSelectedIndex() - 1;
		String userIdSearch = this.textField_UserID_Search.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int nRow = model_table.getRowCount();

		Set<Integer> deleteUserId = new TreeSet<Integer>();
		if (homeTown >= 0) {
			provinceModel tinhDaChon = provinceModel.getProvinceById(homeTown);
			for (int i = 0; i < nRow; i++) {
				String provinceName = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!provinceName.equals(tinhDaChon.getprovincedName())) {
					deleteUserId.add(Integer.valueOf(id));
				}
			}
		}
		if (userIdSearch.length() > 0) {
			for (int i = 0; i < nRow; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(userIdSearch)) {
					deleteUserId.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idDelete : deleteUserId) {
			System.out.println(idDelete);
			nRow = model_table.getRowCount();
			for (int i = 0; i < nRow; i++) {
				String idInTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idInTable: " + idInTable);
				if (idInTable.equals(idDelete.toString())) {
					System.out.println("Deleted: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void ResetDocument() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (userModel ts : this.model.getListUser()) {
			this.addUserinTable(ts);
		}
	}

	public void appearAbout() {
		JOptionPane.showMessageDialog(this, "User Management Software 1.0!");
	}

	public void exitProgram() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Do you want to relax from the program?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setileName(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (userModel ts : this.model.getListUser()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void i_SaveFile() {
		if(this.model.getfileName().length()>0) {
			saveFile(this.model.getfileName());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	public void openFile(File file) {
		ArrayList<userModel> list = new ArrayList<userModel>();
		try {
			this.model.setileName(getName());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			userModel ts = null;
			while((ts = (userModel) ois.readObject())!=null) {
				list.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setListUser(list);
	}
	public void i_OpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			ResetDocument();
		} 
	}
}