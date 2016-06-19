package no.mesan.tvdb.vo;

import no.mesan.tvdb.vo.base.StringVo;

public class ChangedBy extends StringVo {

    public ChangedBy(final String changedBy) {
        super(changedBy);
    }

    public static ChangedBy from(final String changedBy) {
        return new ChangedBy(changedBy);
    }
}
