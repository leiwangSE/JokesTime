import java.sql.Timestamp;

public class Review {
	private int review_id;
	private int score;
	private String remark;
	private int joke_id;
	private int user_id;
	private Timestamp dateTime;

	public Review(int score, String remark, int joke_id, int user_id) {
		this.score=score;
		this.remark=remark;
		this.joke_id = joke_id;
		this.user_id = user_id;	
	}
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getJoke_id() {
		return joke_id;
	}
	public void setJoke_id(int joke_id) {
		this.joke_id = joke_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
}
