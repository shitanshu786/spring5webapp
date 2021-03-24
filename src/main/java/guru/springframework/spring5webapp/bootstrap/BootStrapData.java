package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher p1 = new Publisher("shittu", "add line 1", "city",
                "state", "zip");

        publisherRepository.save(p1);
        Author a1 = new Author("Shittu", "V");
        Author a2 = new Author("Rudyard", "Kipling");

        Book b1 = new Book("Notes", "123");
        Book b2 = new Book("The jungle book", "1245W");
        a1.getBooks().add(b1);
        a2.getBooks().add(b2);
        b1.getAuthors().add(a1);
        b1.setPublisher(p1);
        b2.getAuthors().add(a2);
        b2.setPublisher(p1);

        p1.getBooks().add(b1);

        authorRepository.save(a1); authorRepository.save(a2);
        bookRepository.save(b1);
        publisherRepository.save(p1);
        p1.getBooks().add(b2);
        bookRepository.save(b2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of authors: "+ authorRepository.count());
        System.out.println("Number of books: "+ bookRepository.count());


        publisherRepository.save(p1);
        System.out.println("Number Of Publishers: " + publisherRepository.count());
        System.out.println("P1 number of books: " + p1.getBooks().size());
    }
}
