package com.GL.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GL.Library.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Long>{

}
