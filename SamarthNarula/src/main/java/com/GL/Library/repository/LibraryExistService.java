package com.GL.Library.repository;

public interface LibraryExistService {

	boolean checkLibraryExistById(Long id);

	boolean checkLibraryByIdWithExample(String commaSeparatedBookNames);

}