package kr.co.mlec.board.dao;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import kr.co.mlec.board.vo.BoardVO;

public class BoardDAO {
	private BoardVO[] datas = null;
	public static final int DEFAULT_SIZE = 5;
	public BoardDAO() throws FileNotFoundException {
		this(DEFAULT_SIZE);
	}
	
	public BoardDAO(int size) throws FileNotFoundException {
		this(null, size);
	}
	
	public BoardDAO(String path, int size) throws FileNotFoundException {
		datas = new BoardVO[size];
		loadData(path);
	}
	
	private void loadData(String path) throws FileNotFoundException {
		if(path != null) {
			Scanner sc = new Scanner(new java.io.File(path));
			Vector<BoardVO> vec = new Vector<BoardVO>();
			while(sc.hasNextLine()) {
				BoardVO vo = new BoardVO();
				String[] load = sc.nextLine().split("\t");
				vo.setNo(Integer.parseInt(load[0]));
				vo.setTitle(load[1]);
				vo.setWriter(load[2]);
				vo.setContent(load[3]);
				vec.add(vo);
			}
			datas = new BoardVO[vec.size()];
			datas = vec.toArray(datas);
			sc.close();
		}
	}
	
	public BoardVO[] selectList() {
		Vector<BoardVO> list = new Vector<BoardVO>();
		
		for(BoardVO vo : datas) {
			if(vo != null)
				list.add(vo);
		}
		
		datas = list.toArray(new BoardVO[list.size()]);
		return datas;
	}
	
	public BoardVO selectDetail(int num) {
		BoardVO data = null;
		try {
			data = datas[num - 1];
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return data;
	}
	
	public boolean insert(BoardVO insertData) {
		try {
			Vector<BoardVO> list = new Vector<BoardVO>();
			for(BoardVO vo : datas) {
				if(vo != null)
					list.add(vo);
			}
			
			insertData.setNo(list.size() + 1);
			list.add(insertData);
			
			datas = list.toArray(new BoardVO[list.size()]);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean delete(int num) {
		try {
			datas[num - 1] = null;
			Vector<BoardVO> list = new Vector<BoardVO>();
			for(BoardVO vo : datas) {
				if(vo != null) {
					list.add(vo);
				}
			}
			
			datas = list.toArray(new BoardVO[list.size()]);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean update(int num, BoardVO updateData) {
		try {
			datas[num - 1].setContent(updateData.getContent());
			datas[num - 1].setTitle(updateData.getTitle());
			
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public BoardVO[] getDatas() {
		Vector<BoardVO> list = new Vector<BoardVO>();
		for(BoardVO vo : datas) {
			if(vo != null) {
				list.add(vo);
			}
		}
		
		return list.size() > 0 ? datas : null;
	}
}
