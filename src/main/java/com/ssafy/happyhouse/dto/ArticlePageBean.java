package com.ssafy.happyhouse.dto;

/** UI 화면 페이지에 대한 정보를 표시하는 클래스 */
public class ArticlePageBean {
	/** 검색 조건 */
	private String key;
	/** 검색 단어 */
	private String word;
	/** 현재 페이지 번호 */
	private int pageNo;

	private String articleType;
	/** 한 페이지에 보여주 content 개수 */
	private int articleInterval = 10;
	/** 페이지의 시작 게시글 번호 **/
	private int startArticleId = 1;

//	private String pageLink;
	public ArticlePageBean() {	}
	public ArticlePageBean(String key, String word, int pageNo, String articleType) {
		setKey(key);
		setWord(word);
		setPageNo(pageNo);
		setArticleType(articleType);
	}
	public ArticlePageBean(String key, String word, String pageNo, String articleType) {
		setKey(key);
		setWord(word);
		setPageNo(pageNo);
		setArticleType(articleType);
	}
	
	//스프링에서는 1 빼야함-0번부터 시작
	//1번부터 시작하게 함
	public int getStartArticleId() {
		return (pageNo - 1) * articleInterval;
	}
	public void setStartArticleId(int startArticleId) {
		this.startArticleId = startArticleId;
	}
	private void setPageNo(String pageNo) {
		try {
			this.pageNo = Integer.parseInt(pageNo);
		} catch (Exception e) {
			this.pageNo = 1;
		}
	}
	public String getKey() {
		return key;
	}

	public String getKey(String k) {
		if (key != null && key.equals(k)) {
			return "selected='selected'";
		} else {
			return "";
		}
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getArticleInterval() {
		return articleInterval;
	}

	public void setArticleInterval(int articleInterval) {
		this.articleInterval = articleInterval;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

@Override
	public String toString() {
		return "PageBean [key=" + key + ", word=" + word + ", pageNo=" + pageNo + ", interval=" + articleInterval
			+ "]";
	}
//	public void setPageLink(String pageLink) {
//		this.pageLink = pageLink;
//	}
//	public String getPageLink() {
//		return pageLink;
//	}
}
