package com.GL.Library.repository;

import java.util.List;

import com.GL.Library.entity.Library;

public interface LibraryCreateService {

	String addSingleLibrary(Library library);

	String addAllLibraries(List<Library> libraries);

	Library addAllLibraryWithSaveAndFlush(Library library);

}