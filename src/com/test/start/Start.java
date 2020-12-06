package com.test.start;

import java.util.Scanner;

import com.test.nonmember.BookingMovie;
import com.test.notice.showNoticeList;

//장진영 구현 -> 초기화면
public class Start {
	public static void main(String[] args)  {

		Scanner scan = new Scanner(System.in);

		while(true) {
			System.out.println("===============================================================================================");
			System.out.println();
			System.out.println("\t\t\t\t[ 쌍 용 영 화 관 ]");
			System.out.println();
			System.out.println("===============================================================================================");
			System.out.println("\t\t\t\t0. 공지사항");
			System.out.println("\t\t\t\t1. 영화정보보기");
			System.out.println("\t\t\t\t2. 회원 예매");
			System.out.println("\t\t\t\t3. 비회원 예매");
			System.out.println("\t\t\t\t4. 회원 가입");
			System.out.println("\t\t\t\t5. ID/PW 찾기");
			System.out.println("\t\t\t\t9. 종료");
			System.out.println("-----------------------------------------------------------------------------------------------");
			
			System.out.print("\t\t\t번호를 입력하세요(ex: 1) : ");
			String sel = scan.nextLine();

			if(sel.equals("9")) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}	//F7i2jmWPs■JSG6CJSf5■쫈뫱■01013848199■서울특별시 성북구 성북동 271-471
			switch(sel) {
				case "0"://공지사항
					showNoticeList.main(null);
					break;
				case "1"://영화정보보기
					ViewMovieDetail.main(null);
					break;
				case "2"://회원예매 -> 로그인
					UserLogin.main(args);
					break;
				case "3"://비회원예매
					BookingMovie.main(args);
					break;
				case "4"://회원가입
					SignUp.main(args);
					break;
				case "5"://아이디, 비밀번호찾기
					Search.main(args);
					break;
				case "000"://관리자 로그인 (이스터에그)
					AdminLogin.main(args);
					break;
				default:
					System.out.println("잘못된 접근입니다.");
					
			}
		}
	}
}
