package spring.rest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.rest.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select b from Book as b where b.title like %?1% OR b.description like %?2%")
    List<Book> findByTitleContainingOrDescriptionContaining(String text, String textAgain);
}
