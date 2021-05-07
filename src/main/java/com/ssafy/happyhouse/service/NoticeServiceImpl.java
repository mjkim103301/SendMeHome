package com.ssafy.happyhouse.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.NoticeDao;
import com.ssafy.happyhouse.dto.NoticeDto;

import ch.qos.logback.core.db.dialect.DBUtil;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao noticeDao;
	
	@Transactional
	@Override
	public void registerArticle(NoticeDto noticeDto) throws Exception {
		Connection conn=null;
		try {
			//conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			noticeDao.registerArticle(conn, noticeDto);
		}catch (SQLException e) {
			e.printStackTrace();
		//	DBUtil.rollback(conn);
			throw new Exception("게시글 등록 중 오류 발생");
		}finally {
			try {
				conn.commit();
			}catch (Exception e) {}
			//DBUtil.close(conn);
		}
	}

	@Transactional
	@Override
	public List<NoticeDto> listArticle(String key, String word) throws Exception {
		Connection conn=null;
		key=key==null?"":key;
		word=word==null?"":word;
		
		try {
		//	conn=DBUtil.getConnection();
			return noticeDao.listArticle(conn,key, word);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시글 목록 조회 중 오류 발생");
		}finally {
		//	DBUtil.close(conn);
		}
	}

	@Transactional
	@Override
	public NoticeDto getArticle(int articleNo) throws Exception {
		try {
			return noticeDao.getArticle(articleNo);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시글 조회 중 오류 발생");
		}
	}

	@Transactional
	@Override
	public void modifyArticle(NoticeDto noticeDto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Transactional
	@Override
	public void deleteArticle(int articleNo) throws Exception {
		try {
			noticeDao.deleteArticle(articleNo);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시글 삭제 중 오류 발생");
		}
	}

}
