package com.spring.practice.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.practice.board.model.dto.BoardDTO;
import com.spring.practice.board.model.dto.PageDTO;
import com.spring.practice.board.service.BoardService;

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

			return "/board/boardMain";

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

			return "/board/boardList";

		} catch (Exception e) {

			e.printStackTrace();

			model.addAttribute("msg", "게시글 조회 실패..");

			return "common/errorPage";

		}

	}

}
