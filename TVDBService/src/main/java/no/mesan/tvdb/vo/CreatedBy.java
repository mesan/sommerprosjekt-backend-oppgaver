package no.mesan.tvdb.vo;

import no.mesan.tvdb.vo.base.StringVo;

public class CreatedBy extends StringVo {

    public CreatedBy(final String createdBy) {
        super(createdBy);
    }

    public static CreatedBy from(final String createdBy) {
        return new CreatedBy(createdBy);
    }
}
