package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import bean.Car;
import bean.User;
import bean.Order;
import dbconnection.DatabaseConnection;
public class UserDao {
	private Statement sta;
	private ResultSet rs;
	PreparedStatement ps;
	//注册功能
	public int regist(String name,String password,String sex,Date birth,String phone,String idnum,String introduce,String address) throws Exception {
		DatabaseConnection u=new DatabaseConnection();
		Connection conn=u.getCon();
		String sql="insert into user(Username,Password,Sex,Birthday,Phone,ID_num,Introduce,Address) value(?,?,?,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, password);
		ps.setString(3, sex);
		ps.setDate(4,(java.sql.Date) birth);
		ps.setString(5, phone);
		ps.setString(6, idnum);
		ps.setString(7, introduce);
		ps.setString(8, address);
		int a=ps.executeUpdate();
		return a;
	}
	//登录功能函数
	public String login(String name,String password) {
		User user=new User();
		String sql="select ID,Username,Password from user where Username=? and Password=?";
		try {
			DatabaseConnection u=new DatabaseConnection();
			Connection conn=u.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("ID"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String i=user.getUsername();
		return i;
	}
	//车票查询并显示
	public ArrayList<Car> carShow() throws Exception{
		ArrayList<Car> car=new ArrayList<Car>();
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	sta=conn.createStatement();
    	String sql="select * from ordercontent";
    	rs=sta.executeQuery(sql);
    	while(rs.next()) {
    		Car cars=new Car();
    		cars.setCarid(rs.getInt("Car_id"));
    		cars.setCartimes(rs.getString("Car_times"));
    		cars.setNumber(rs.getInt("Number"));
    		cars.setCarnumber(rs.getString("Car_number"));
    		cars.setSitnumber(rs.getInt("Sit_number"));
    		cars.setSof(rs.getString("Sof"));
    		cars.setSource(rs.getString("Source"));
    		cars.setDestination(rs.getString("Destination"));
    		cars.setPrice(rs.getString("Price"));
    		cars.setBegin_date(rs.getString("Begin_date"));
    		cars.setBegin_time(rs.getString("Begin_time"));
    		cars.setEnd_date(rs.getString("End_date"));
    		cars.setEnd_time(rs.getString("End_time"));
    		car.add(cars);
    	}
    	return car; 
	}
	//个人用户信息显示
	public ArrayList<User> usershow(String uname) throws Exception{
		ArrayList<User> users=new ArrayList<User>();
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="select * from user where Username=?";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, uname);
    	rs=ps.executeQuery();
    	if(rs.next()) {
    		User user=new User();
    		user.setId(rs.getInt("ID"));
    		user.setUsername(rs.getString("Username"));
    		user.setPassword(rs.getString("Password"));
    		user.setSex(rs.getString("Sex"));
    		user.setBirth(rs.getDate("Birthday"));
    		user.setPhone(rs.getString("Phone"));
    		user.setIdnum(rs.getString("ID_num"));
    		users.add(user);
    	}
    	return users;
	}
	//修改个人信息:姓名
	public int modifyname(int id,String uname) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="update user set Username=? where ID=?";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, uname);
    	ps.setInt(2, id);
    	int a=ps.executeUpdate();
    	return a;
	}
	//修改个人信息:密码
	public int modifyPwd(int id,String password) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="update user set Password=? where ID=?";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, password);
    	ps.setInt(2, id);
    	int a=ps.executeUpdate();
    	return a;
	}
	//修改个人信息:性别
	public int modifySex(int id,String sex) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="update user set Sex=? where ID=?";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, sex);
    	ps.setInt(2, id);
    	int a=ps.executeUpdate();
    	return a;
	}
	//修改个人信息:生日
	public int modifyBirthday(int id,String birth) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="update user set Birthday=? where ID=?";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, birth);
    	ps.setInt(2, id);
    	int a=ps.executeUpdate();
    	return a;
	}
	//修改个人信息电话
	public int modifyPhone(int id,String phone) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="update user set Phone=? where ID=?";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, phone);
    	ps.setInt(2, id);
    	int a=ps.executeUpdate();
    	return a;
	}
	//修改个人信息:身份证号码
	public int modifyIdnum(int id,String idnum) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="update user set ID_num=? where ID=?";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, idnum);
    	ps.setInt(2, id);
    	int a=ps.executeUpdate();
    	return a;
	}
	//寻找用户Id函数
	public int findId(String uname) throws Exception{
		User user=new User();
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="select ID from user where Username=?";
    	ps=conn.prepareStatement(sql);
    	ps.setString(1, uname);
    	rs=ps.executeQuery();
    	if(rs.next()) {
    		user.setId(rs.getInt("ID"));
    	}
    	int a=user.getId();
    	return a;
	}
	//购买车票函数
	public int buyticket(int id,int number) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="update ordercontent set Number=Number-? where Car_id=?";
    	ps=conn.prepareStatement(sql);
    	ps.setInt(1, number);
    	ps.setInt(2, id);
    	int i=ps.executeUpdate();
    	return i;
	}
	//购买车票后添加到显示用的表上
	public int addbook(int carid) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="insert into orders(OCar_id,Car_times,Source,Destination,Price,Begin_date,Begin_time,End_date,End_time) select Car_id,Car_times,Source,Destination,Price,Begin_date,Begin_time,End_date,End_time from ordercontent where Car_id=?";
    	ps=conn.prepareStatement(sql);
    	ps.setInt(1, carid);
    	int s=ps.executeUpdate();
    	return s;
	}
	//订单显示函数
	public ArrayList<Order> orderShow(int id) throws Exception{
		ArrayList<Order> order=new ArrayList<Order>();
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	sta=conn.createStatement();
    	String sql="select * from orders where ID=?";
    	ps=conn.prepareStatement(sql);
    	ps.setInt(1, id);
    	rs=ps.executeQuery();
    	while(rs.next()) {
    		Order orders=new Order();
    		orders.setArgeid(rs.getInt("Arrangement_id"));
    		orders.setOcarid(rs.getInt("OCar_id"));
    		orders.setCartimes(rs.getString("Car_times"));
    		orders.setDestination(rs.getString("Destination"));
    		orders.setSource(rs.getString("Source"));
    		orders.setPrice(rs.getString("Price"));
    		orders.setBegindate(rs.getString("Begin_date"));
    		orders.setBegintime(rs.getString("Begin_time"));
    		orders.setEnddate(rs.getString("End_date"));
    		orders.setEndtime(rs.getString("End_time"));
    		order.add(orders);
    	}
    	return order; 
	}
	//退票函数
	public int deletetk(int Arrangement_id) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="delete from orders where Arrangement_id=?";
    	ps=conn.prepareStatement(sql);
    	ps.setInt(1, Arrangement_id);
    	int b=ps.executeUpdate();
    	return b;
	}//TODO:余票回档
	//购买车票添加的订单
	public int addbookid(int id,int carid) throws Exception{
		DatabaseConnection u=new DatabaseConnection();
    	Connection conn=u.getCon();
    	String sql="update orders set ID=? where OCar_id=?";
    	ps=conn.prepareStatement(sql);
    	ps.setInt(1, id);
    	ps.setInt(2, carid);
    	int a=ps.executeUpdate();
    	return a;
	}
}
