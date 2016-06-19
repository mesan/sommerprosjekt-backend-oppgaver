package no.mesan.tvdb.shows.service;

import java.util.List;

import no.mesan.tvdb.domain.Show;
import no.mesan.tvdb.shows.dao.ShowDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    @Autowired
    private ShowDao showDao;

    public List<Show> fetchShows() {
        return showDao.readShows();
    }

    /* TODO */
}
