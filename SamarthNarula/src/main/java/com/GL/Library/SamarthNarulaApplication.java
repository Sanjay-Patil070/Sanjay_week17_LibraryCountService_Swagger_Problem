package com.GL.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.GL.Library.entity.Library;
import com.GL.Library.repository.LibraryCountService;
import com.GL.Library.repository.LibraryCreateService;
import com.GL.Library.repository.LibraryDeleteService;
import com.GL.Library.repository.LibraryExistService;
import com.GL.Library.serviceImple.LibrayRepoServiceImple;

//import com.GL.Library.serviceImple.GetAllLibraryWithNoBooks;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SamarthNarulaApplication implements CommandLineRunner {

	@Autowired
	LibraryCreateService createServiceImpl;

	@Autowired
	LibrayRepoServiceImple libraryReadServiceImple;

	@Autowired
	LibraryCountService countServiceImpl;

	@Autowired
	LibraryExistService checkIfLibraryExist;

	@Autowired
	LibraryDeleteService deleteLibrary;

	// GetAllLibraryWithNoBooks getAllLibWithNoBooks;
	public static void main(String[] args) {
		SpringApplication.run(SamarthNarulaApplication.class, args);
		System.out.println("Instructor Samarth Narula");
	}

	@Override
	public void run(String... args) throws Exception {
		// readServiceImplMethodsExecution();
		// createServiceImplMethodsExecution();
		// countLibraryServiceImpleMethods();
		// existServiceImplMethodExecution();
		//log.info("deleted library->{}", deleteLibrary.deleteOneLibrary(
			//	Library.builder().id(5l).commaSeparatedBookNames("red ,yellow,blue").name("star library").build()));
		//log.info("prune library table->{}", deleteLibrary.pruneTable());
		/*List<Library> libraries=new ArrayList<Library>();
		libraries.add(Library.builder().commaSeparatedBookNames("").name("zoology library").id(3l).build());
		libraries.add(Library.builder().commaSeparatedBookNames("").name("Botany library").id(4l).build());
		log.info("Delete all these->{}",deleteLibrary.deleteAllTheseLibrary(libraries));
		log.info("delete all in batch is complete->{}",deleteLibrary.deleteAllInBatch());*/
		//log.info("delete by id is complete->{}",deleteLibrary.deleteLibraryById(6l));
		List<Library> libraries=new ArrayList<Library>();
		libraries.add(Library.builder().commaSeparatedBookNames("").id(3l).name("zoology library").build());
		libraries.add(Library.builder().commaSeparatedBookNames("").id(4l).name("Botany library").build());
		log.info("delete all these in libraries in batch->{}",deleteLibrary.deleteAllTheseLibrayInBatch(libraries));
	}

	private void existServiceImplMethodExecution() {
		log.info("check if exist library by id->{}", checkIfLibraryExist.checkLibraryExistById(12l));
		log.info("check if exist library by example ->{}",
				checkIfLibraryExist.checkLibraryByIdWithExample("sun ,moon,saturn"));
	}

	private void countLibraryServiceImpleMethods() {
		log.info("count  the number of libraries->", countServiceImpl.countLibraries());
		log.info("count libraries with zero books ->{}", countServiceImpl.countLibrariesWithNoBooks());
	}

	private void createServiceImplMethodsExecution() {
		log.info("Persist a single library->{}", createServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("E Library").commaSeparatedBookNames("xyz,abc").build()));
		List<Library> libraries = new ArrayList<Library>();
		libraries.add(Library.builder().id(12l).name("F Library").commaSeparatedBookNames("fruit,apple").build());
		libraries.add(Library.builder().id(13l).name("G Library").commaSeparatedBookNames("fruit,banana").build());
		libraries.add(Library.builder().id(14l).name("H Library").commaSeparatedBookNames("fruit,orange").build());
		log.info("Persist a single library->{}", createServiceImpl.addAllLibraries(libraries));

		log.info("Persist a single library->{}", createServiceImpl.addAllLibraryWithSaveAndFlush(Library.builder()
				.id(15l).name("Shirt Library").commaSeparatedBookNames("Lenin,Allen solly,Levis").build()));
	}

	private void readServiceImplMethodsExecution() {
		System.out.println("command line runner");
		// List<Library> libraries=libraryReadServiceImple.getAllLibrary();
		log.info("Fetch All libraries ->{}", libraryReadServiceImple.getAllLibrary());
		Page<Library> page = libraryReadServiceImple.getLibrariesPaged();
		List<Library> libraries = page.get().collect(Collectors.toList());
		log.info("Fetch All libray with page format ->{}", libraries);
		log.info("library with customised page number->{}",
				libraryReadServiceImple.customisedPgeMethod(2, 2).get().collect(Collectors.toList()));
		log.info("Fetch all library with latest added order->{}",
				libraryReadServiceImple.getLibrariesWithLatestAddedOrder());
		// log.info("Fetch All libraries w
		// ->{}",getAllLibWithNoBooks.getAllLibrariesWithNoBooks());
		log.info("Fetch library according sorted order by Id->{}",
				libraryReadServiceImple.getLibrariesCustomSortedById(Direction.ASC));
		log.info("Fetch library according sorted order by Name->{}",
				libraryReadServiceImple.getLibrariesCustomSortedByName(Direction.DESC));
		log.info("Fetch library accoring to Paged,sortedwith these books->{}", libraryReadServiceImple
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("xyz,abc,lmn").get().collect(Collectors.toList()));

		log.info("Fetch library according to paged and sorted sorted by Name->{}",
				libraryReadServiceImple.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));
		log.info("Fetch library customised page with deafult sorting order by with these books ->{}",
				libraryReadServiceImple
						.getLibrariesCustomisedPagedAndSortedWithDefaultOrderByNameWithTheseBooks("xyz,abc,lmn", 1, 2)
						.get().collect(Collectors.toList()));
		log.info("Fetch library Sorted By Name With These Books->{}",
				libraryReadServiceImple.getLibrariesSortedByNameWithTheseBooks("xyz,abc,lmn"));
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		log.info("fetch library Libraries By Id ->{}", libraryReadServiceImple.getLibrariesById(ids));
		long id = 12l;
		Optional<Library> optionalLibrary = libraryReadServiceImple.getLibraryById(id);
		if (optionalLibrary.isPresent()) {
			log.info("get library by id->{}", optionalLibrary.get());
		} else {
			log.info("no matching library found with id number " + id + " in database");
		}

		Optional<Library> optionalSingleLibrary = libraryReadServiceImple
				.getALibaryWithTheseBooks("tommy,brownie,zaro");
		if (optionalSingleLibrary.isPresent()) {
			log.info("get single library with these books->{}", optionalSingleLibrary.get());
		} else {
			log.info("no matching library found with id number " + id + " in database");
		}
	}

}
