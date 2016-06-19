package no.mesan.tvdb.vo;

import no.mesan.tvdb.vo.base.LongVo;

public class ShowId extends LongVo {

    public ShowId(final Long showId) {
        super(showId);
    }

    public ShowId(final String showId) {
        super(showId);
    }

    public static ShowId from(final Long showId) {
        return new ShowId(showId);
    }
}
