package com.GL.Library.serviceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GL.Library.entity.Library;
import com.GL.Library.repository.LibraryDeleteService;
import com.GL.Library.repository.LibraryRepository;

@Service
public class LibraryDeleteServiceImple implements LibraryDeleteService {
	@Autowired
	LibraryRepository readRepository;
	@Override
	public String deleteOneLibrary(Library library) {
		 readRepository.delete(library);
		return"Deleted library:"+library;
	}
	@Override
	public String pruneTable() {
		readRepository.deleteAll();
		return "prune complete";
	}
	@Override
	public String deleteAllTheseLibrary(List<Library> libraries) {
		readRepository.deleteAll(libraries);
		return "Delete all complete";
	}
	@Override
	public String deleteAllInBatch() {
		readRepository.deleteAllInBatch();
		return "delete all in batch is complete" ;
		}
	@Override
	public String deleteLibraryById(Long id) {
		readRepository.deleteById(id);
		return "delete by this id " + id + " complete";
		
	}
	@Override
	public String deleteAllTheseLibrayInBatch(List<Library> libraries) {
		readRepository.deleteInBatch(libraries);
		return "deleted all libraries in list in batch mode";
		
	}
}
