package booksM.com.booksM.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import booksM.com.booksM.common.Constant;
import booksM.com.booksM.common.DB;
import booksM.com.booksM.dao.RecordDao;
import booksM.com.booksM.pojo.Record;

public class RecordDaoImpl implements RecordDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public boolean borrowBook(Record record) {
		boolean result = false;
		String sql = "insert into record(student_id,book_id,record_borrow_date) values(?,?,?);";
		conn = DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, record.getStudentId());
			ps.setInt(2, record.getBookId());
			ps.setDate(3, new java.sql.Date(record.getRecordBorrowDate().getTime()));
			if(ps.executeUpdate()==1){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public boolean returnBook(Record record) {
		boolean result = false;
		String sql = "update record set record_return_date=? where book_id=? and record_return_date is null;";
		conn = DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setDate(1, new java.sql.Date(record.getRecordReturnDate().getTime()));
			ps.setInt(2, record.getBookId());
			if(ps.executeUpdate()==1){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public boolean isOutDate(int bookId,Date recordReturnDate) {
		boolean result = false;
		long a = recordReturnDate.getTime() - this.getRecordBorrowDate(bookId).getTime();
		if(a>Constant.ONE_MONTH){
			result = true;
		}
		return result;
	}
	@SuppressWarnings("unused")
	private Date getRecordBorrowDate(int bookId){
		Date recordBorrowDate = null;
		String sql = "select record_borrow_date from record where book_id=? and record_return_date is null;";
		conn=DB.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			if(rs.next()){
				recordBorrowDate = new Date(rs.getDate("record_borrow_date").getTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(conn, ps, rs);
		}
		return recordBorrowDate;
	}
	

}
