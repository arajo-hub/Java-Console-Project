package com.test.notice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

import data.Notice;
import data.NoticeBoard;
import data.Path;
import data.ScreenInfo;
import data.ScreenInfoDetail;

public class CreateNoticeBoard {

	public static NoticeBoard newBoard=new NoticeBoard();
	
	
	public static NoticeBoard main(String[] args) {
		
		try {
			Path tempPath=new Path();
			String path = tempPath.noticePath + "noticeList.txt";
			File file=new File(path);
			if (file.exists()) {
				BufferedReader reader=new BufferedReader(new FileReader(path));
				String line;
				while((line=reader.readLine())!=null) {
					
					String[] postInfo=line.split("■");
					Notice newNotice=new Notice(postInfo[0], postInfo[1], postInfo[2], postInfo[3]);
					newBoard.addPost(newNotice);
					
					
				}
			}
			return newBoard;
			
		}catch(Exception e) {
			System.out.println("createNoticeboard.main()");
		};
		
		return newBoard;
	}

}
