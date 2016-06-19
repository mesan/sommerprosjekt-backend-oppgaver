package no.mesan.tvdb.shows.dao;

import static org.junit.Assert.assertFalse;

import java.util.Optional;

import no.mesan.tvdb.TvdbDaoTestConfig;
import no.mesan.tvdb.domain.Show;
import no.mesan.tvdb.vo.ShowId;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TvdbDaoTestConfig.class)
@Sql(scripts = "classpath:shows-dataset.sql")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ShowDaoTest {

    @Autowired
    private ShowDao showDao;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private final ShowId showId = ShowId.from(100L);

    @Test
    public void readById_nonExistingId_returnNull() throws Exception {
        // Assign
        final ShowId nonExistingShowId = ShowId.from(12345L);

        // Act
        final Optional<Show> show = showDao.readById(nonExistingShowId);

        // Assert
        assertFalse(show.isPresent());
    }
}