package no.mesan.tvdb.shows;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import no.mesan.tvdb.vo.ShowId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("shows")
public class ShowsRestService {

    @Autowired
    private ShowsDelegate delegate;

    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response fetchShows() {
        return delegate.fetchShows();
    }

    @GET
    @Path("{showId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response fetchShowById(
            @PathParam("showId") final ShowId showId) {
        return delegate.fetchShowById(showId);
    }
}
