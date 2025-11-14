package com.example.awsdemo.note;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity                     // 이 클래스가 DB 테이블과 매핑된다는 뜻
@Table(name = "notes")      // 테이블 이름 지정
public class Note {

    @Id                     // 기본 키 컬럼
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO_INCREMENT
    private Long id;        // 메모 번호

    @Column(nullable = false, length = 100)
    private String title;   // 메모 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; // 메모 내용

    private LocalDateTime createdAt;  // 생성 시간

    // 기본 생성자 (JPA가 사용)
    protected Note() {
    }

    // 편하게 생성할 수 있는 생성자
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();  // 생성 시각 자동 저장
    }

    // Getter, Setter (롬복 안 쓰는 버전)
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
