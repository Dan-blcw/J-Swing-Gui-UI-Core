package maintest;

import javax.swing.UIManager;
import view.userManagView;
//what up? I'm Dan, 2022
public class mainTest {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new userManagView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
