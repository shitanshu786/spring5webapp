package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author a1 = new Author("Shittu", "V");
        Author a2 = new Author("Rudyard", "Kipling");

        Book b1 = new Book("Notes", "123");
        Book b2 = new Book("The jungle book", "1245W");
        a1.getBooks().add(b1);
        a2.getBooks().add(b2);
        b1.getAuthors().add(a1);
        b2.getAuthors().add(a2);

        authorRepository.save(a1); authorRepository.save(a2);
        bookRepository.save(b1); bookRepository.save(b2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of authors: "+ authorRepository.count());
        System.out.println("Number of books: "+ bookRepository.count());
    }
}
