package no.mesan.tvdb.domain;

import java.util.List;
import java.util.Objects;

import no.mesan.tvdb.vo.SeasonNumber;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Season {
    private final SeasonNumber seasonNumber;
    private final List<Episode> episodes;

    public Season(final SeasonNumber seasonNumber, final List<Episode> episodes) {
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
    }

    public SeasonNumber getSeasonNumber() {
        return seasonNumber;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Season season = (Season) o;
        return Objects.equals(seasonNumber, season.seasonNumber) &&
                Objects.equals(episodes, season.episodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seasonNumber, episodes);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("seasonNumber", seasonNumber)
                .append("episodes", episodes)
                .toString();
    }
}
