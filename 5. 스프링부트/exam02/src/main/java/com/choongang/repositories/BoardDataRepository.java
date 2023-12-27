package com.choongang.repositories;

import com.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long> { // Long = 기본키 자료형
    List<BoardData> findBySubjectContaining(String keyword);
    Page<BoardData> findBySubjectContaining(String keyword, Pageable pageable);
    List<BoardData> findBySubjectContainingOrderBySeqDesc(String keyword);

}
