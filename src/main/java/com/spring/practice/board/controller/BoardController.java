package com.spring.practice.board.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.spring.practice.board.model.dto.BoardDTO;
import com.spring.practice.board.model.dto.PageDTO;
import com.spring.practice.board.service.BoardService;
import com.spring.practice.member.model.dto.MemberDTO;

@Controller
@RequestMapping("/board")
public class BoardController {

	private final BoardService boardService;

	// --------------------------------------------------------- // @Autowired 생략 가능
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@RequestMapping("/main")
	public String main() {
		return "redirect:/index.jsp";
	}

	// 보드 메인을 불러옴
	@RequestMapping("/boardMain")
	public String boardMain(PageDTO pageDTO, Model model) {

		// mebubar에서 넘겨준 page = 1을 메소드에 파라미터로 넣어 start = 1, end = 10 으로 pageDTO에 set (첫
		// 페이지니까 page = 1)
		pageDTO.setStartEnd(pageDTO.getPage());

		try {

			// 1부터 10까지의 글만 가져오기 위해 pageDTO를 파라미터로 담아 보낸다.
			List<BoardDTO> list = boardService.selectBoardList(pageDTO);

			System.out.println("가져온 게시글 정보:" + list);

			model.addAttribute("list", list);

			// 전체 글 수를 가져온다.
			int count = boardService.selectCount();

			model.addAttribute("count", count);

			// 글 수를 토대로 전체 페이지 수를 구한다.
			// 글 수가 10의 배수면 +1을 하지 않는다.
			int pages = count / 10;

			// 글 수가 10의 배수가 아니면 +1을 한다.
			if (count % 10 != 0) {
				pages += 1;
			}

			model.addAttribute("pages", pages);

			return "board/boardMain";

		} catch (Exception e) {

			e.printStackTrace();

			model.addAttribute("msg", "게시글 조회 실패..");

			return "common/errorPage";

		}

	}

	// 보드 메인을 불러옴
	@RequestMapping("/boardList")
	public String boardList(PageDTO pageDTO, Model model) {

		pageDTO.setStartEnd(pageDTO.getPage());

		try {

			List<BoardDTO> list = boardService.selectBoardList(pageDTO);

			System.out.println("가져온 게시글 정보:" + list);

			model.addAttribute("list", list);

			return "board/boardList";

		} catch (Exception e) {

			e.printStackTrace();

			model.addAttribute("msg", "게시글 조회 실패..");

			return "common/errorPage";

		}

	}

	@GetMapping("/insertForm")
	public void boardInsertForm() {

	}

	@PostMapping("/insertBoard")
	public String insertBoard(BoardDTO boardDTO, HttpServletRequest request, MultipartFile img, Model model) {

		HttpSession session = request.getSession();
		
		// 로그인한 유저의 id를 memberDTO에서 가져와 boardDTO의 writer에 set
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("loginUser");
		String writer = memberDTO.getId();
		boardDTO.setWriter(writer);
		
		String root = session.getServletContext().getRealPath("resources");
		
		System.out.println("root : " + root);
		
		// 파일을 저장할 경로
		String filePath = root + "/uploadFiles"; // mac은 \ 아니고 /
		
		String savedName = "";
		
		// 첨부 파일이 있으면 true를, 없으면 false를 반환
		System.out.println("img가 있는지 확인: " + !img.isEmpty());
		
		// img가 있을 때
		if(!img.isEmpty()) {
			
			// java.io의 File을 import
			// filePath에 폴더가 없으면 폴더 생성
			File mkdir = new File(filePath);
			if(!mkdir.exists()) {
				mkdir.mkdirs();
			}
			
			// 파일명 변경 처리
			// 첨부 파일의 이름을 가져온다.
			String originFileName = img.getOriginalFilename();
			// 거기서 확장자만 잘라서 변수에 저장한다.
			String ext = originFileName.substring(originFileName.lastIndexOf("."));
			// 랜덤한 파일이름을 생성한 후 뒤에 확장자를 붙인다.
			savedName = UUID.randomUUID().toString().replace("-", "") + ext;
			
			// boardDTO에 변경한 파일명을 set
			boardDTO.setImgName(savedName);
			
			try {
				
				// 이미지 파일을 생성한다.
				img.transferTo(new File(filePath + "/" + savedName)); 
				
			} catch (Exception e) {
				
				e.printStackTrace();

				// 오류 발생 시 생성한 파일을 삭제한다.
				new File(filePath + "/" + savedName).delete();
				
				model.addAttribute("msg", "게시글 작성 실패..");

				return "common/errorPage";
				
			}
			
		} // img가 있을 때
		
		System.out.println("이미지 있나 없나 확인: " + boardDTO);
		
		try {
			
			boardService.insertBoard(boardDTO);
			
			// mapper에서 useGeneratedKeys="true" keyProperty="boardNo" 해줬기 때문에 boardDTO에 insert한 게시글의 No가 담겨 있다.
			int boardNo = boardDTO.getBoardNo();
			
			// insert한 그 글의 detail로 바로 가게끔 boardNo를 파라미터로 같이 보낸다.
			return "redirect:/board/boardDetail?boardNo="+boardNo;
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
			// 오류 발생 시 생성한 파일을 삭제한다.
			new File(filePath + "/" + savedName).delete();
			
			model.addAttribute("msg", "게시글 작성 실패..");

			return "common/errorPage";
			
		}	
	
	}
	
	
	
	@RequestMapping("/boardDetail")
	public String boardDetail(int boardNo, Model model) {

		System.out.println("조회할 게시글의 번호는: " + boardNo);
		
		try {
			
			BoardDTO boardDTO = boardService.boardDetail(boardNo);
			
			boardDTO.setViews(boardDTO.getViews()+1);
			
			boardService.addViews(boardNo);
			
			model.addAttribute("boardDTO", boardDTO);
			
			return "board/boardDetail";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			model.addAttribute("msg", "게시글 작성 실패..");

			return "common/errorPage";
			
		}
		
	}
	
	
	
}
