package kr.co.mlec.board.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import kr.co.mlec.board.vo.BoardVO;

public class BoardDAO {
	private BufferedWriter fw = null;
	private BufferedReader fr = null;
	
	private BoardVO[] datas = null;
	public static final int DEFAULT_SIZE = 5;
	public BoardDAO() throws IOException {
		this(DEFAULT_SIZE);
	}
	
	public BoardDAO(int size) throws IOException {
		this(null, size);
	}
	
	public BoardDAO(String path, int size) throws IOException {
		datas = new BoardVO[size];
		fw = new BufferedWriter(new FileWriter(new File(path), true));
		fr = new BufferedReader(new FileReader(new File(path)));
		loadData(path);
	}
	
	private void loadData(String path) throws IOException {
		if(path != null) {
			Vector<BoardVO> vec = new Vector<BoardVO>();
			String readData = null;
			while((readData = fr.readLine()) != null) {
				BoardVO vo = new BoardVO();
				String[] load = readData.split("\t");
				vo.setNo(Integer.parseInt(load[0]));
				vo.setTitle(load[1]);
				vo.setWriter(load[2]);
				vo.setContent(load[3]);
				vec.add(vo);
			}
			datas = new BoardVO[vec.size()];
			datas = vec.toArray(datas);
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
	
	public boolean insertWithFile(BoardVO insertData) {
		try {
			Vector<BoardVO> list = new Vector<BoardVO>();
			for(BoardVO vo : datas) {
				if(vo != null)
					list.add(vo);
			}
			insertData.setNo(list.size() + 1);
			list.add(insertData);
			
			datas = list.toArray(new BoardVO[list.size()]);
			
			fw.newLine();
			StringBuffer sb = new StringBuffer();
			sb.append(insertData.getNo()).append("\t");
			sb.append(insertData.getTitle()).append("\t");
			sb.append(insertData.getWriter()).append("\t");
			sb.append(insertData.getContent());
			fw.write(sb.toString());
			fw.flush();
			
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

	public void close() throws IOException {
		fw.close();
		fr.close();
	}
	
	public static void main(String[] args) throws IOException {
		BoardDAO bd = new BoardDAO("ioload/day08/load.txt", 5);
		BoardVO v = new BoardVO();
		v.setNo(1);
		v.setTitle("adfsadfasdf");
		v.setWriter("asdfasdfasdf");
		v.setContent("asdfasdfsadf");
		bd.insertWithFile(v);
	}
}
