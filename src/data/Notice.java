package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

import com.test.notice.showNoticeList;

import data.Path;

// 공지사항 게시판
public class Notice{
	
	Scanner sc=new Scanner(System.in);
	
	// 멤버변수
	private String title;
	private String author;
	private String content;
	private String creationTime;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	
	public Notice(String title, String author, String content, String creationTime) {
			
			this.title = title;
			this.author = author;
			this.content = content;
			this.creationTime = creationTime;
	}
	
	public Notice(String branch) {
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.printf("\t\t\t\t공지사항 등록\n");
		System.out.println();
		System.out.println("===============================================================================================");
		System.out.printf("\t\t작성자 : %s 관리자", branch);
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
															now.get(Calendar.MONTH)+1,
															now.get(Calendar.DATE),
															(now.get(Calendar.AM_PM)==0)?"오전":"오후",
															now.get(Calendar.HOUR),
															now.get(Calendar.MINUTE));
		this.title=title;
		this.author=branch+"점 관리자";
		this.content=content;
		this.creationTime=creationTime;
		
		try {
			Path listPath=new Path();
			String path=listPath.noticePath+"noticeList.txt";
			BufferedWriter writer=new BufferedWriter(new FileWriter(path, true));
			String noticeInfo=null;
			if (NoticeBoard.getBoardLength()==0) {
				noticeInfo=this.title+"■"+this.author+"■"+this.content+"■"+this.creationTime;
			}else {
				noticeInfo="\n"+this.title+"■"+this.author+"■"+this.content+"■"+this.creationTime;
			}
			writer.write(noticeInfo);
			writer.close();
		}catch(Exception e) {
			System.out.println("Notice.Notice()");
		}
		
	}
	
	

}
