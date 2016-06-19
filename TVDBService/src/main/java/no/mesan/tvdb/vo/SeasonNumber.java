package no.mesan.tvdb.vo;

import no.mesan.tvdb.vo.base.IntegerVo;

public class SeasonNumber extends IntegerVo {

    public SeasonNumber(final Integer seasonNumber) {
        super(seasonNumber);
    }

    public SeasonNumber(final String seasonNumber) {
        super(seasonNumber);
    }

    public static SeasonNumber from(final Integer seasonNumber) {
        return new SeasonNumber(seasonNumber);
    }
}
