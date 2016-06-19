package no.mesan.tvdb.domain;

import java.util.List;
import java.util.Objects;

import no.mesan.tvdb.vo.Description;
import no.mesan.tvdb.vo.Name;
import no.mesan.tvdb.vo.ShowId;

public class Show {
    private final ShowId id;
    private final Name name;
    private final Description description;
    private final List<Season> seasons;

    public Show(final ShowId id, final Name name, final Description description, final List<Season> seasons) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.seasons = seasons;
    }

    public ShowId getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Show show = (Show) o;
        return Objects.equals(id, show.id) &&
                Objects.equals(name, show.name) &&
                Objects.equals(description, show.description) &&
                Objects.equals(seasons, show.seasons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, seasons);
    }
}
