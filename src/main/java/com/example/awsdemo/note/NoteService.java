package com.example.awsdemo.note;

import org.springframework.stereotype.Service;

import java.util.List;

@Service  // 비즈니스 로직을 담당하는 클래스
public class NoteService {

    private final NoteRepository noteRepository;

    // 생성자 주입
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // 메모 전체 조회
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    // 메모 저장
    public Note save(String title, String content) {
        Note note = new Note(title, content);  // 엔티티 생성
        return noteRepository.save(note);      // DB에 저장
    }
}
