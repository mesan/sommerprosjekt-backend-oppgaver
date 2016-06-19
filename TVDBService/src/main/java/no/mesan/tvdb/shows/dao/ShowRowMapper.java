package no.mesan.tvdb.shows.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import no.mesan.tvdb.domain.Show;

import org.springframework.jdbc.core.RowMapper;

public class ShowRowMapper implements RowMapper<Show> {

    @Override
    public Show mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        return null; // TODO: Returnere Show fra resultset
    }
}
