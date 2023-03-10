package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class provinceModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int provinceId;
	private String provincedName;
	
	public provinceModel(int provinceId, String provincedName) {
		this.provinceId = provinceId;
		this.provincedName = provincedName;
	}

	public int getprovinceId() {
		return provinceId;
	}

	public void setprovinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getprovincedName() {
		return provincedName;
	}

	public void setprovincedName(String provincedName) {
		this.provincedName = provincedName;
	}

	@Override
	public String toString() {
		return "Province [Id : " + provinceId + " , NameProv : " + provincedName + " ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(provinceId, provinceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		provinceModel other = (provinceModel) obj;
		return provinceId == other.provinceId && Objects.equals(provincedName, other.provincedName);
	}
	public static ArrayList<provinceModel> getListProvince(){
		String[] arr_province = {"An Giang","Ba Ria – Vung Tau",
							"Bac Lieu","Bac Giang",
							"Bac Kan","Bac Ninh",
							"Ben Tre","Binh Duong",
							"Binh Đinh","Binh Phuoc",
							"Binh Thuan","Ca Mau",
							"Cao Bang","Can Thơ",
							"Đa Nang","Đak Lak",
							"Đak Nong","Đien Bien",
							"Đong Nai","Đong Thap",
							"Gia Lai","Ha Giang",
							"Ha Nam","Ha Noi",
							"Ha Tinh","Hai Duong",
							"Hai Phong","Hau Giang",
							"Hoa Binh","Ho Chi Minh City",
							"Hung Yen","Khanh Hoa",
							"Kien Giang","Kon Tum",
							"Lai Chau","Lang Son",
							"Lao Cai","Lam Đong",
							"Long An","Nam Đinh",
							"Nghe An","Ninh Binh",
							"Ninh Than","Phu Tho",
							"Phu Yen","Quang Binh",
							"Quang Nam","Quang Ngai",
							"Quang Ninh","Quang Tri",
							"Soc Trang","Son La",
							"Tay Ninh","Thai Binh",
							"Thai Nguyen","Thanh Hoa",
							"Thua Thien Hue","Tien Giang",
							"Tra Vinh","Tuyen Quang",
							"Vinh Long","Vinh Phuc","Yen Bai"};
		ArrayList<provinceModel> listProvince = new ArrayList<provinceModel>();
		int i = 0;
		for (String name : arr_province) {
			provinceModel t = new provinceModel(i, name);
			listProvince.add(t);
		}
		return listProvince;
	}

	public static provinceModel getProvinceById(int Id) {
		return provinceModel.getListProvince().get(Id);
	}

	public static provinceModel getProvinceByName(String provinceName) {
		ArrayList<provinceModel> listProvince = provinceModel.getListProvince();
		for (provinceModel flag : listProvince) { 
			if(flag.provincedName.equals(provinceName))
				return flag;
		}
		return null;
	}
}