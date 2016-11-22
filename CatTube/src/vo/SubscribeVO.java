package vo;

public class SubscribeVO {
	private String subScribeId;

	public SubscribeVO() {

	}

	public SubscribeVO(String subScribeId) {
		super();
		this.subScribeId = subScribeId;
	}

	public String getSubScribeId() {
		return subScribeId;
	}

	public void setSubScribeId(String subScribeId) {
		this.subScribeId = subScribeId;
	}

	@Override
	public String toString() {
		return "SubscribeVO [subScribeId=" + subScribeId + "]";
	}

}