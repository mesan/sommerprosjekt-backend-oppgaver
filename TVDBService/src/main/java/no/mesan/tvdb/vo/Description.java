package no.mesan.tvdb.vo;

import no.mesan.tvdb.vo.base.StringVo;

public class Description extends StringVo {

    public Description(final String description) {
        super(description);
    }

    public static Description from(final String description) {
        return new Description(description);
    }
}
