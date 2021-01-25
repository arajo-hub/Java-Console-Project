package com.test.notice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

import com.test.start.Start;

import data.Notice;
import data.NoticeBoard;
import data.Path;

public class ShowNoticeListAdmin {
	
	private static Scanner sc=new Scanner(System.in);
	public static NoticeBoard noticeBoard=CreateNoticeBoard.main(null);
	
	public static void main(String[] args) {
		
		boolean loop=true;
		while(loop) {
			
			// 헤더 출력
			showHeader();
			noticeBoard.showPostTitle();
			// 선택메뉴 입력
			String sel=showMenu();
			if (sel.equals("0")) {
				System.out.println();
				break;
			}else {
				int PostNum=Integer.parseInt(sel)-1;
				if (PostNum>=noticeBoard.getBoardLength()||PostNum<0) {
					System.out.println("\t\t상세조회할 공지사항이 없습니다.");
					ShowNoticeListAdmin.main(null);
				}else {
					PostNum=noticeBoard.getBoardLength()-PostNum-1;
					noticeBoard.showPostForAdmin(PostNum);
				}
				boolean subLoop=true;
				while(subLoop) {
					String choice=sc.nextLine();
					if (choice.equals("1")) { // 공지사항 수정
						noticeBoard.modifyPost(PostNum);
					}else if (choice.equals("2")) { // 공지사항 삭제
						noticeBoard.deletePost(PostNum);
					}else if (choice.equals("0")) { // 뒤로가기
						subLoop=false;
					}else{
						System.out.printf("\t\t뒤로 가려면 0을 입력하세요...");
					}
					
				}
			}
			
			
		}
	}
	
	private static void showHeader() {
		System.out.println("===============================================================================================");
		System.out.println("[ 쌍 용 영 화 관 ]");
		System.out.println("\t\t\t\t공지사항");
		System.out.println();
		System.out.println("===============================================================================================");
	}

	
	public static String showMenu(){
			
		System.out.println("===============================================================================================");
		System.out.println("\t\t뒤로 가려면 0을 입력하세요...");
		System.out.printf("\t\t번호를 선택해주세요(ex: 1) : ");
		
		String selectNum=sc.nextLine(); 
		
		return selectNum;
	}
	

}