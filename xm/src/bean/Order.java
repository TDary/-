package bean;

public class Order {
	private int argeid;
	private int ocarid;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String cartimes;
	private String destination;
	private String source;
	private String begindate;
	private String begintime;
	private String enddate;
	private String endtime;
	private String price;
	public int getArgeid() {
		return argeid;
	}
	public void setArgeid(int argeid) {
		this.argeid = argeid;
	}
	public int getOcarid() {
		return ocarid;
	}
	public void setOcarid(int ocarid) {
		this.ocarid = ocarid;
	}
	public String getCartimes() {
		return cartimes;
	}
	public void setCartimes(String cartimes) {
		this.cartimes = cartimes;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
