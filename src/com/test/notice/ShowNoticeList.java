package com.test.notice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Scanner;

import com.test.start.Start;

import data.Notice;
import data.NoticeBoard;
import data.Path;

public class ShowNoticeList {
	
	private static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean loop=true;
		while(loop) {
			
			// 헤더 출력
			System.out.println();
			showHeader();
			ShowNoticeListAdmin.noticeBoard.showPostTitle();
			// 선택메뉴 입력
			String sel=showMenuForCustomer();
			int PostNum=Integer.parseInt(sel)-1;
			if (sel.equals("0")) {
				System.out.println();
				loop=false;
			}else if (PostNum>=ShowNoticeListAdmin.noticeBoard.getBoardLength()
					|| PostNum<0){
				loop=false;
			}else {
				PostNum=ShowNoticeListAdmin.noticeBoard.getBoardLength()-PostNum-1;
				ShowNoticeListAdmin.noticeBoard.showPostForCustomer(PostNum);
				boolean subLoop=true;
				while(subLoop) {
					String choice=sc.nextLine();
					if (choice.equals("0")) {
						subLoop=false;
					}
					System.out.printf("\t\t뒤로 가려면 0을 입력하세요...");
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
	
	public static String showMenuForCustomer(){
		
		System.out.println("===============================================================================================");
		System.out.println("\t\t뒤로 가려면 0을 입력하세요...");
		System.out.printf("\t\t번호를 선택해주세요(ex: 1) : ");
		
		String selectMenu=sc.nextLine(); 
		
		return selectMenu;
	}
	

}