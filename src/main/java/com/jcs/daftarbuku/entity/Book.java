package com.jcs.daftarbuku.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "j_books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String judul;
    @Column(nullable = false)
    private String penerbit;
    @Column(name = "tahun_terbit", nullable = false)
    private Long tahunTerbit;
    private LocalDateTime inputAt;

    @PrePersist
    protected void onCreate() {
        inputAt = LocalDateTime.now();
    }
}
