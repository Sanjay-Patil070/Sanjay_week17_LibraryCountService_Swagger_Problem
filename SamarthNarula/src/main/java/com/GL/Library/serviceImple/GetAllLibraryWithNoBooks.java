/*package com.GL.Library.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.GL.Library.entity.Library;
import com.GL.Library.repository.LibraryRepository;

@Service
public class GetAllLibraryWithNoBooks {
	@Autowired
	LibraryRepository readRepository;

	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}
	public List<Library> getAllLibrariesWithNoBooks() {
		Library librarywithNoBooks =new Library();
		librarywithNoBooks.setCommaSeparatedBookNames("");
		//below ExampleMatcher will make sure only commaSeparatedBookName is considered and id and name are ignored
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("commaSeparatedBookName",
				ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
		Example<Library> example=Example.of(librarywithNoBooks,exampleMatcher);
		return readRepository.findAll(example);
		//System.out.println("just to show you how this object will look like"+librarywithNoBooks);
	}
}*/
