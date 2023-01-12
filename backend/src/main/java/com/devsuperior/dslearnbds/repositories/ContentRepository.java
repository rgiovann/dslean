package com.devsuperior.dslearnbds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslearnbds.entities.Content;

//@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

}
