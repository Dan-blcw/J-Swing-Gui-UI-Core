package model;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class userModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private provinceModel homeTown;
	private Date bod;
	private boolean gender;
	private float scores0, scores1, scores2;
	
	public userModel() {
	}

	public userModel(int userId,
			String userName,
			provinceModel homeTown,
			Date bod,
			boolean gender,
			float scores0,
			float scores1,
			float scores2){
		
		this.userId = userId;
		this.userName = userName;
		this.homeTown = homeTown;
		this.bod = bod;
		this.gender = gender;
		this.scores0 = scores0;
		this.scores1 = scores1;
		this.scores2 = scores2;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public provinceModel getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(provinceModel homeTown) {
		this.homeTown = homeTown;
	}

	public Date getBod() {
		return bod;
	}

	public void setBod(Date bod) {
		this.bod = bod;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public float getScores0() {
		return scores0;
	}

	public void setScores0(float score0) {
		this.scores0 = score0;
	}

	public float getScores1() {
		return scores1;
	}

	public void setScores1(float scores1) {
		this.scores1 = scores1;
	}

	public float getScores2() {
		return scores2;
	}

	public void setScores2(float scores2) {
		this.scores2 = scores2;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId 
				+ ", userName =" + userName 
				+ ", Home town =" + homeTown 
				+ ", birth of day ="+ bod 
				+ ", gender=" + gender 
				+ ", score 1 = " + scores0 
				+ ", score 2 =" + scores1
				+ ", score 3 =" + scores2 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(scores0, scores1, scores2, gender, userId, bod, homeTown, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		userModel other = (userModel) obj;
		return Float.floatToIntBits(scores0) == Float.floatToIntBits(other.scores0)
				&& Float.floatToIntBits(scores1) == Float.floatToIntBits(other.scores1)
				&& Float.floatToIntBits(scores2) == Float.floatToIntBits(other.scores2) 
				&& gender == other.gender
				&& userId == other.userId 
				&& Objects.equals(bod, other.bod)
				&& Objects.equals(homeTown, other.homeTown) && Objects.equals(userName, other.userName);
	}

}