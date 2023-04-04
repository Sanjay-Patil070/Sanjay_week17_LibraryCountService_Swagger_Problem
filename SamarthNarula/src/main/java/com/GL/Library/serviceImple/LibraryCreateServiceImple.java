package com.GL.Library.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GL.Library.entity.Library;
import com.GL.Library.repository.LibraryCreateService;
import com.GL.Library.repository.LibraryRepository;

@Service
public class LibraryCreateServiceImple implements LibraryCreateService {

	@Autowired
	LibraryRepository libraryRepository; 
	@Override
	public String addSingleLibrary(Library library) {
		libraryRepository.save(library);
		libraryRepository.flush();
		return "library saved";
		
	}
	@Override
	public String addAllLibraries(List<Library> libraries) {
		libraryRepository.saveAll(libraries);
		libraryRepository.flush();
		return "All Libraries saved";
	}
	@Override
	public Library addAllLibraryWithSaveAndFlush(Library library) {
		return libraryRepository.saveAndFlush(library);
	}
}
