package data;

// 게시판 기능이 들어있는 Interface
interface Interface_NoticeBoard {
	
	// 포스트 생성 기능
	void addPost(Notice notice);
	
	// 포스트 제목 리스트 기능
	void showPostTitle();
	
	// 포스트 상세 조회 기능(고객용)
	void showPostForCustomer(int i);
	
	// 포스트 상세 조회 기능(관리자용)
	void showPostForAdmin(int i);
	
	// 포스트 수정 기능
	void modifyPost(int i);
	
	// 포스트 삭제 기능
	void deletePost(int i);

}
