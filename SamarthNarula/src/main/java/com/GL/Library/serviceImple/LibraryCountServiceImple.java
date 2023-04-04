package com.GL.Library.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.GL.Library.entity.Library;
import com.GL.Library.repository.LibraryCountService;
import com.GL.Library.repository.LibraryRepository;

@Service
public class LibraryCountServiceImple implements LibraryCountService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public long countLibraries() {
		return libraryRepository.count();
	}
	@Override
	public long countLibrariesWithNoBooks() {
		Library library=new Library();
		library.setCommaSeparatedBookNames("");
		
		ExampleMatcher examplematcher= ExampleMatcher.matching().
				withMatcher("commaSeparatedBookNames",ExampleMatcher.GenericPropertyMatchers.exact()).
				withIgnorePaths("id","name"); 
		Example<Library> example=Example.of(library, examplematcher);
		return libraryRepository.count(example);
	}
	
}
