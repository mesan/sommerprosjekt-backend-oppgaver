package no.mesan.tvdb.shows.dao;

import java.util.List;
import java.util.Optional;

import no.mesan.tvdb.domain.Show;
import no.mesan.tvdb.vo.ShowId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ShowDao {

    @Autowired
    private NamedParameterJdbcTemplate tvdbNamedTemplate;

    public List<Show> readShows() {
        // TODO
        //tvdbNamedTemplate.query("", new ShowRowMapper());

        return null;
    }

    public Optional<Show> readById(final ShowId showId) {
        final SqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("ID", showId.value());
        

        // TODO:
        //final List<Show> shows = tvdbNamedTemplate.query(...);
        //return Optional.ofNullable(DataAccessUtils.singleResult(shows));
        return Optional.ofNullable(null);
    }
}
