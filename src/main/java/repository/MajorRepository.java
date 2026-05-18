package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;

import model.MajorBean;




public class MajorRepository {

	
	public   int insertMajor(MajorBean obj) {
		int i=0; 
		
	
	 String sql="   insert into major(major_name,mark) values(?,?)";
	 		
	 
	 		
	 try (
		 Connection con=	DBConnection.getConnection();
		PreparedStatement ps= con.prepareStatement(sql)
				){
		ps.setString(1, obj.getMajor_name());
		ps.setInt(2, obj.getMarks());
		
		
		
		
		i=ps.executeUpdate();// run
		
		
	} catch (SQLException e) {
		System.out.println("Insert error : "+e.getMessage());
	}
		
		return i;
		
	}
	public   List<MajorBean> getAllMajor() {
		List<MajorBean> list=new ArrayList<MajorBean>();
		
		String sql="SELECT * FROM major where delete_flag=1";
		
		try (
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs =ps.executeQuery()){
			while(rs.next()) {
				MajorBean obj=new MajorBean();
				obj.setId(rs.getInt("id"));
				obj.setMajor_name(rs.getString("major_name"));
				obj.setMarks(rs.getInt("mark"));
				
				
				list.add(obj);
			}
		} catch (SQLException e) {
			System.out.println("select error"+e.getMessage());
			
		}
		return list;
		}

	
	public  MajorBean getbyMajorId(int majorId) {
		MajorBean majorObj=null;
		
		
		
		String sql="SELECT * FROM jwd68.major where id=?;";
		
		try (
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql)){
			ps.setInt(1, majorId);
				
			try(ResultSet rs =ps.executeQuery()){
			
			
			
			while(rs.next()) {
			majorObj=new MajorBean();
			majorObj.setId(rs.getInt("id"));
			majorObj.setMajor_name(rs.getString("major_name"));
			majorObj.setMarks(rs.getInt("mark"));
				}
			}
			
		} catch (SQLException e) {
			System.out.println("getbyid error"+e.getMessage());
			
		}
		return majorObj;
		}
	public  int updateMajor(MajorBean obj) {
		int i=0;
		
		 String sql="update major set major_name=?, mark=? where id= ?";
		 		
		 try (
			 Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql)){
			 ps.setString(1,obj.getMajor_name() );
			 ps.setInt(2,obj.getMarks() );
			 ps.setInt(3,obj.getId() );
			
			
			i=ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("update error"+e.getMessage());
			
		}
		
		return i;
	}
	/*public  int deleteMajor(int id) {
		int i=0;
		
		 String sql="update major set delete_flag=0 where id=?";
		 		
		 try (
			 Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql)){
			 ps.setInt(1,id );
			
			
			
			i=ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			System.out.println("delete error"+e.getMessage());
			
		}
		
		return i;
	}*/
	}

