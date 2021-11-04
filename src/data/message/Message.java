package data.message;

public class Message {
	private String id;
	private String send;
	private String dest;
	private String text;
	private String idPhoto;
	private String channel;
	private String replied;

	public Message(String id, String dest, String send, String text, String idPhoto, String channel, String replied) {
		super();
		this.id = id;
		this.dest = dest;
		this.send = send;
		this.text = text;
		this.idPhoto = idPhoto;
		this.replied = replied;
		this.channel = channel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setIdPhoto(String id) {
		idPhoto = id;
	}

	public String getIdPhoto() {
		return idPhoto;
	}
	
	public String getReplied() {
		return this.replied;
	}
	
	public String getChannel() {
		return channel;
	}
	@Override
	public String toString() {
		return "Message[id=" + id + ", send=" + send + ", dest=" + dest + "text= " + text + "]";
	}

}
