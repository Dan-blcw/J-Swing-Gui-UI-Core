package model;

import java.util.ArrayList;

public class userManagModel {
		private ArrayList<userModel> listUser;
		private String select;
		private String fileName;

		public userManagModel() {
			this.listUser = new ArrayList<userModel>();
			this.select = "";
			this.fileName="";
		}

		public userManagModel(ArrayList<userModel> listUser) {
			this.listUser = listUser;
		}

		public ArrayList<userModel> getListUser() {
			return listUser;
		}

		public void setListUser(ArrayList<userModel> listUser) {
			this.listUser = listUser;
		}
		
		public void insert(userModel user) {
			this.listUser.add(user);
		}
		
		public void delete(userModel user) {
			this.listUser.remove(user);
		}
		
		public void update(userModel user) {
			this.listUser.remove(user);
			this.listUser.add(user);
		}

		public String getSelect() {
			return select;
		}

		public void setSelect(String select) {
			this.select = select;
		}

		public String getfileName() {
			return fileName;
		}

		public void setileName(String fileName) {
			this.fileName = fileName;
		}

		public boolean kiemTraTonTai(userModel ts) {
			for(userModel thiSinh: listUser) {
				if(thiSinh.getUserId() == ts.getUserId())
					return true;
			}
			return false;
		}
		
		
}
