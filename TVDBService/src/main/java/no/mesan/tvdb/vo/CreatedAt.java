package no.mesan.tvdb.vo;

import java.time.OffsetDateTime;

import no.mesan.tvdb.vo.base.OffsetDateTimeVo;

public class CreatedAt extends OffsetDateTimeVo {

    public CreatedAt(final OffsetDateTime createdAt) {
        super(createdAt);
    }

    public static CreatedAt from(final OffsetDateTime createdAt) {
        return new CreatedAt(createdAt);
    }

    public static CreatedAt now() {
        return new CreatedAt(OffsetDateTime.now());
    }
}
