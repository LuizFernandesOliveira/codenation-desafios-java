package challenge;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends CrudRepository<Quote, Integer> {

    @Query(value = "SELECT * FROM scripts ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Quote getRandomQuote();

    @Query(value = "SELECT * FROM scripts WHERE actor = :actor ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Quote getByActor(@Param("actor") String actor);
}
