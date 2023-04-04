package com.GL.Library.serviceImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.GL.Library.entity.Library;
import com.GL.Library.repository.LibraryRepository;

@Service
public class LibrayRepoServiceImple {
	@Autowired
	LibraryRepository readRepository;

	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	public Page<Library> getLibrariesPaged() {
		Pageable first3Records = PageRequest.of(0, 3);
		return readRepository.findAll(first3Records);

	}

	public Page<Library> customisedPgeMethod(int pageNumber, int numberOfRecordsOnPage) {
		Pageable first3Records = PageRequest.of(pageNumber, numberOfRecordsOnPage);
		return readRepository.findAll(first3Records);
	}

	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}

	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}

	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		Library librarywithTheseBooks = new Library();
		librarywithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(librarywithTheseBooks, exampleMatcher);
		Pageable first3Records = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(example, first3Records);
	}

	public Page<Library> getLibrariesPagedAndSortedByName() {
		Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(pageable);
	}

	public Page<Library> getLibrariesCustomisedPagedAndSortedWithDefaultOrderByNameWithTheseBooks(
			String commaSeparatedBookNames, int pageNumber, int numberOfRecordsOnPage) {
		Library librarywithTheseBooks = new Library();
		librarywithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(librarywithTheseBooks, exampleMatcher);
		Pageable customPaged = PageRequest.of(pageNumber, numberOfRecordsOnPage, Sort.by("name"));
		return readRepository.findAll(example, customPaged);
	}

	public List<Library> getLibrariesSortedByNameWithTheseBooks(String commaSeparatedBookNames) {
		Library librarywithTheseBooks = new Library();
		librarywithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(librarywithTheseBooks, exampleMatcher);
		return readRepository.findAll(example, Sort.by("name"));
	}

	public List<Library> getLibrariesById(List<Long> ids) {
		return readRepository.findAllById(ids);
	}

	public Optional<Library> getLibraryById(Long id) {
		return readRepository.findById(id);
	}

	public Optional<Library> getALibaryWithTheseBooks(String commaSeparatedBookNames) {
		Library librarywithTheseBooks = new Library();
		librarywithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(librarywithTheseBooks, exampleMatcher);
		return readRepository.findOne(example);
	}
}
