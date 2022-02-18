package project03.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project03.VO.MemberVo;
import projrct03.db.DataBase;

public class memberDAO {
	
	private DataBase database=null;

	public memberDAO() {
		
		 database=new DataBase();
		
	}
	public List<MemberVo> member_list(){
		List<MemberVo> list = new ArrayList<MemberVo>();
	    Connection con =null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
		System.out.println("s");
		try {
			System.out.println("d");
			con=database.getConnection();
			System.out.println("a");
			String query="select m_idx, m_id,m_pw,m_name,m_phone,m_rgstDate,m_mdfyDate from member";
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				MemberVo memberVo = new MemberVo();
				
				memberVo.setM_idx(rs.getInt("m_idx"));
				memberVo.setM_id(rs.getString("m_id"));
				memberVo.setM_pw(rs.getString("m_pw"));
				memberVo.setM_name(rs.getString("m_name"));
				memberVo.setM_phone(rs.getString("m_phone"));
				memberVo.setM_rgstDate(rs.getTimestamp("m_rgstDate"));
				memberVo.setM_mdfyDate(rs.getTimestamp("m_mdfyDate"));
				
				list.add(memberVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if( pstmt !=null) {
				try {
					 rs.close();
					 pstmt.close();
					 con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
		return list;
	}

}
