package com.GL.Library.serviceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.GL.Library.entity.Library;
import com.GL.Library.repository.LibraryExistService;
import com.GL.Library.repository.LibraryRepository;

@Service
public class LibraryExistServiceImpl implements LibraryExistService {
	@Autowired
	LibraryRepository readRepository;
@Override
public boolean checkLibraryExistById(Long id) {
	return readRepository.existsById(id) ;
	
}
@Override
public boolean checkLibraryByIdWithExample(String commaSeparatedBookNames) {
	Library library=new Library();
	library.setCommaSeparatedBookNames(commaSeparatedBookNames);
	ExampleMatcher exampleMatcher=ExampleMatcher.matching().
			withMatcher("commaSeparatedBookNames",ExampleMatcher.GenericPropertyMatchers.exact()).
			withIgnorePaths("name","id");
	Example<Library> example= Example.of(library, exampleMatcher);
	return readRepository.exists(example);
	
}
}
