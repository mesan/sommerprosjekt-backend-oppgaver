package no.mesan.tvdb.shows;

import java.util.List;

import javax.ws.rs.core.Response;

import no.mesan.tvdb.domain.Show;
import no.mesan.tvdb.shows.service.ShowService;
import no.mesan.tvdb.vo.ShowId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class ShowsDelegate {

    @Autowired
    private ShowService showService;

    /**
     * Read all shows.
     *
     * @return list of shows, or no content if no shows exists.
     */
    public Response fetchShows() {
        final List<Show> shows = showService.fetchShows();

        if (CollectionUtils.isEmpty(shows)) {
            return Response.noContent().build();
        }

        return Response.ok().entity(shows).build();
    }

    /**
     * Read show by id.
     *
     * @param showId the show id.
     * @return matching show, or no content if no show is found
     */
    public Response fetchShowById(final ShowId showId) {
        /** TODO */

        return Response.noContent().build();
    }
}
