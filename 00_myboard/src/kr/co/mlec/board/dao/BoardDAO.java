package kr.co.mlec.board.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import kr.co.mlec.board.vo.BoardVO;

public class BoardDAO implements BoardDAOable{
	private BoardVO[] datas = null;
	private String path = null;
	public static final int DEFAULT_SIZE = 5;
	
	public BoardDAO() throws IOException {
		this(DEFAULT_SIZE);
	}
	
	public BoardDAO(int size) throws IOException {
		this(null, size);
	}
	
	public BoardDAO(String path, int size) throws IOException {
		datas = new BoardVO[size];
		this.path = path;
		loadData();
	}
	
	public void loadData() throws IOException {
		if(path != null) {
			BufferedReader fr = new BufferedReader(new FileReader(new File(path)));
			
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
			
			fr.close();
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
			BufferedWriter fw = new BufferedWriter(new FileWriter(new File(path), true));
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
			fw.close();
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
			
			dataReWrite(datas);
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
			
			dataReWrite(datas);
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
	
	private void dataReWrite(BoardVO[] datas) throws IOException {
		BufferedWriter fw = new BufferedWriter(new FileWriter(new File(path), false));
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i < datas.length; i++) {
			BoardVO insertData = datas[i];
			sb.append(insertData.getNo()).append("\t");
			sb.append(insertData.getTitle()).append("\t");
			sb.append(insertData.getWriter()).append("\t");
			sb.append(insertData.getContent());
		}
		fw.flush();
		fw.write(sb.toString());
		fw.close();
	}
}
