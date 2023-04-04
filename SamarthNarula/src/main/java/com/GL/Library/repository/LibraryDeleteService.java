package com.GL.Library.repository;

import java.util.List;

import com.GL.Library.entity.Library;

public interface LibraryDeleteService {

	String deleteOneLibrary(Library library);

	String pruneTable();

	String deleteAllTheseLibrary(List<Library> libraries);

	String deleteAllInBatch();

	String deleteLibraryById(Long id);

	String deleteAllTheseLibrayInBatch(List<Library> libraries);

}