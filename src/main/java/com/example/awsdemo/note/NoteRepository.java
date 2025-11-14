package com.example.awsdemo.note;

import org.springframework.data.jpa.repository.JpaRepository;

// Note 엔티티를 DB에서 CRUD 해주는 인터페이스
public interface NoteRepository extends JpaRepository<Note, Long> {
}
