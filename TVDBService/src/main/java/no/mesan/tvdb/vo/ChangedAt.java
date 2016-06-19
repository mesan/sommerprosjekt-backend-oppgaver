package no.mesan.tvdb.vo;

import java.time.OffsetDateTime;

import no.mesan.tvdb.vo.base.OffsetDateTimeVo;

public class ChangedAt extends OffsetDateTimeVo {

    public ChangedAt(final OffsetDateTime changedAt) {
        super(changedAt);
    }

    public static ChangedAt from(final OffsetDateTime changedAt) {
        return new ChangedAt(changedAt);
    }
}
