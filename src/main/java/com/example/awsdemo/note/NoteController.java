package com.example.awsdemo.note;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  // 웹 요청을 처리하는 컨트롤러
public class NoteController {

    private final NoteService noteService;

    // 생성자 주입
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")  // 루트로 들어오면 /notes로 리다이렉트
    public String root() {
        return "redirect:/notes";
    }

    @GetMapping("/notes")  // 메모 목록 페이지
    public String list(Model model) {
        List<Note> notes = noteService.findAll();
        model.addAttribute("notes", notes);          // 템플릿에 넘길 데이터
        model.addAttribute("title", "메모 목록");
        return "notes/list";                         // templates/notes/list.html
    }

    @GetMapping("/notes/new")  // 메모 작성 폼 페이지
    public String newForm(Model model) {
        model.addAttribute("title", "새 메모 작성");
        return "notes/new";                          // templates/notes/new.html
    }

    @PostMapping("/notes")  // 메모 저장 처리
    public String create(@RequestParam String title,
                         @RequestParam String content) {
        noteService.save(title, content);            // 서비스 호출로 DB 저장
        return "redirect:/notes";                    // 저장 후 목록으로 이동
    }

    @GetMapping("/health")  // 헬스 체크 용도 (AWS에서 상태 확인할 때 사용)
    @ResponseBody
    public String health() {
        return "OK";                                 // 단순 문자열 응답
    }
}
