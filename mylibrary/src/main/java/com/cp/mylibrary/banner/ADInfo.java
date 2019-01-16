package com.cp.mylibrary.banner;

/**
 * 描述：广告信息</br>
 */
public class ADInfo {

	String id = "";
	String url = "";
	String content = "";
	String type = "";
	String jumpUrl = "";
	String title = "";
	String imgUrl;
	private String shareSubTitle;

	// 是否要分享，1分享，0不分享
	private String shareAble;
	private String shareTitle;
	private String share_url;


	// 是否人传参数 ，0 传，1不传
	private String parameter;

	private String shareType;


	private String eventPlanningType;


	// 消息跳转需要的参数

	private String gotoType;


	private String courseId;

	private String courseSubjectsId;



	public String getEventPlanningType() {
		return eventPlanningType;
	}

	public void setEventPlanningType(String eventPlanningType) {
		this.eventPlanningType = eventPlanningType;
	}

	public String getGotoType() {
		return gotoType;
	}

	public void setGotoType(String gotoType) {
		this.gotoType = gotoType;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseSubjectsId() {
		return courseSubjectsId;
	}

	public void setCourseSubjectsId(String courseSubjectsId) {
		this.courseSubjectsId = courseSubjectsId;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

	public String getShare_url() {
		return share_url;
	}

	public void setShare_url(String share_url) {
		this.share_url = share_url;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShareAble() {
		return shareAble;
	}

	public void setShareAble(String shareAble) {
		this.shareAble = shareAble;
	}

	public String getShareTitle() {
		return shareTitle;
	}

	public void setShareTitle(String shareTitle) {
		this.shareTitle = shareTitle;
	}
 

	public String getShareSubTitle() {
		return shareSubTitle;
	}

	public void setShareSubTitle(String shareSubTitle) {
		this.shareSubTitle = shareSubTitle;
	}

	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
