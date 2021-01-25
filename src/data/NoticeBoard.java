package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Scanner;

public class NoticeBoard implements Interface_NoticeBoard{
	
	private static LinkedList<Notice> board;
	

	Scanner sc=new Scanner(System.in);
	
	public LinkedList<Notice> getNoticeBoard() {
		return board;
	}

	// 게시판에 공지사항 추가 기능
	@Override
	public void addPost(Notice notice) {
		board.add(notice);
	};
	
	// 제목만 조회
	@Override
	public void showPostTitle() {
		if (board.size()==0) {
			System.out.println("\t\t표시할 공지사항이 없습니다.");
		}else {
			int idxNum=1;
			for (int i=board.size()-1;i>=0;i--) {
				System.out.printf("\t\t%d. %s\n", idxNum, board.get(i).getTitle());
				idxNum++;
			}
		}
		
		
	}
	
	// 포스트 상세조회 기능(고객용)
	@Override
	public void showPostForCustomer(int i) {
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.printf("\t\t\t\t%s\n", board.get(i).getTitle());
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.printf("\t\t작성자 : %s | %s\n", board.get(i).getAuthor(), board.get(i).getCreationTime());
		System.out.println();
		System.out.println("\t\t내용 :");
		String[] contentSplit=board.get(i).getContent().split("◘");
		for(int j=0;j<contentSplit.length;j++) {
			System.out.printf("\t\t%s\n", contentSplit[j]);
		}
		System.out.println();
		System.out.printf("\t\t뒤로 가려면 0을 입력하세요...");
		
	}
	
	// 포스트 상세조회 기능(관리자용)
	@Override
	public void showPostForAdmin(int i) {
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.printf("\t\t\t\t%s\n", board.get(i).getTitle());
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.printf("\t\t작성자 : %s | %s\n", board.get(i).getAuthor(), board.get(i).getCreationTime());
		System.out.println();
		System.out.println("\t\t내용 :");
		String[] contentSplit=board.get(i).getContent().split("◘");
		for(int j=0;j<contentSplit.length;j++) {
			System.out.printf("\t\t%s\n", contentSplit[j]);
		}
		System.out.println();
		showSubMenu();
		
	}
	
	@Override
	// 포스트 수정 기능
	public void modifyPost(int i) {
		
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.printf("\t\t\t\t공지사항 수정\n");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.println();
		System.out.printf("\t\t제목 : ");
		String title=sc.nextLine();
		System.out.println("\t\t내용 : ");
		String content="";
		String line=null;
		while(!(line=sc.nextLine()).isEmpty()) {
			if (content.length()>0) {
				content+="◘";
			}
			content+=line;
		}
		
		Calendar now=Calendar.getInstance();
		// 2020년 11월 28일 오전 10:10 형식
		String creationTime=String.format("%s년 %s월 %s일 %s %s:%s", now.get(Calendar.YEAR),
															now.get(Calendar.MONTH),
															now.get(Calendar.DATE),
															(now.get(Calendar.AM_PM)==0)?"오전":"오후",
															now.get(Calendar.HOUR),
															now.get(Calendar.MINUTE));
		board.get(i).setTitle(title);
		board.get(i).setContent(content);
		board.get(i).setCreationTime(creationTime);

		try {
			Path listPath=new Path();
			String path=listPath.noticePath+"noticeList.txt";
			
			BufferedWriter writer=new BufferedWriter(new FileWriter(path));
			String noticeInfo=null;
			for (int j=0; j<board.size();j++) {
				if (j==0) {
					noticeInfo=board.get(j).getTitle()+"■"+board.get(j).getAuthor()+"■"+board.get(j).getContent()+"■"+board.get(j).getCreationTime();
				}else {
					noticeInfo="\r\n"+board.get(j).getTitle()+"■"+board.get(j).getAuthor()+"■"+board.get(j).getContent()+"■"+board.get(j).getCreationTime();
				}
				writer.write(noticeInfo);
			}
			writer.close();
			System.out.println("\t\t수정했습니다.");
		}catch(Exception e) {
			System.out.println("NoticeBoard.modifyPost()");
		}
		
	};
	
	public static int getBoardLength() {
		return board.size();
	}
	
	// 포스트 삭제 기능
	@Override
	public void deletePost(int i) {
		board.remove(i);
		
		try {
			Path listPath=new Path();
			String path=listPath.noticePath+"noticeList.txt";
			
			BufferedWriter writer=new BufferedWriter(new FileWriter(path));
			String noticeInfo=null;
			for (int j=0; j<board.size();j++) {
				if (j==0) {
					noticeInfo=board.get(j).getTitle()+"■"+board.get(j).getAuthor()+"■"+board.get(j).getContent()+"■"+board.get(j).getCreationTime();
				}else {
					noticeInfo="\r\n"+board.get(j).getTitle()+"■"+board.get(j).getAuthor()+"■"+board.get(j).getContent()+"■"+board.get(j).getCreationTime();
				}
				writer.write(noticeInfo);
			}
			writer.close();
		System.out.println("\t\t삭제했습니다.");
		}catch(Exception e) {
			System.out.println("NoticeBoard.deletePost()");
		}
		
	}

	public NoticeBoard() {
		LinkedList<Notice> board=new LinkedList();
		this.board=board;
	}
	
	public static void showSubMenu(){
		
		System.out.println("===============================================================================================");
		System.out.println("\t\t\t1. 공지사항 수정");
		System.out.println("\t\t\t2. 공지사항 삭제");
		System.out.println("\t\t\t0. 뒤로가기");
		System.out.printf("\t\t\t번호를 선택해주세요(ex: 1) : ");
	}

	

}
