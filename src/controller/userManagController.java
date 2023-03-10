package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import view.userManagView;

public class userManagController implements Action{
	public userManagView view;
	
	
	public userManagController(userManagView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: "+cm);
		if(cm.equals("Add")) {
			this.view.deleteForm();
			this.view.model.setSelect("Add");
		}else if(cm.equals("Save")) {
			try {
				this.view.addUser();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}else if(cm.equals("Update")) {
			this.view.hienThiThongTinThiSinhDaChon();
		}else if(cm.equals("Delete")) {
			this.view.i_Delete();
		}else if(cm.equals("Unchecked")) {
			this.view.deleteForm();
		}else if(cm.equals("Search")) {
			this.view.Search();
		}else if(cm.equals("Unchecked Find")) {
			this.view.ResetDocument();
		}else if(cm.equals("About Me")) {
			this.view.appearAbout();
		}else if(cm.equals("Exit")) {
			this.view.exitProgram();
		}else if(cm.equals("SaveFile")) {
			this.view.i_SaveFile();
		}else if(cm.equals("Open")) {
			this.view.i_OpenFile();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}