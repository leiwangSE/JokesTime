/*
 * Tag.java
 * 
 * This is a model class represents a tag entity
 * 
 * This is the first change I make today
 * @author Lei
 *
 */
public class Tag {
   private int tag_id; 
   private String tag;
   private int joke_id;
   
   public Tag() {
   }
   public Tag(String tag) {
	   this.tag=tag;
   }
   public Tag(int tag_id, String tag, int joke_id) {
	   this.tag_id=tag_id;
	   this.tag=tag;
	   this.joke_id=joke_id;
   }
   
   public int getTag_id() {
		return tag_id;
	}
	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getJoke_id() {
		return joke_id;
	}
	public void setJoke_id(int joke_id) {
		this.joke_id = joke_id;
	}
}
