package no.mesan.tvdb.shows;

import static com.jayway.restassured.RestAssured.basePath;
import static com.jayway.restassured.RestAssured.baseURI;

import org.junit.Before;
import org.junit.Test;

/**
 * Integration test of {@link ShowRestServiceIT}.
 */
public class ShowRestServiceIT {

    @Before
    public void setUp() {
        baseURI = "http://localhost:9000";
        basePath = "/TVDBEndpoint/api";
    }

    @Test
    public void fetchShowById_returnCorrectShow() throws Exception {
        // TODO
    }
}