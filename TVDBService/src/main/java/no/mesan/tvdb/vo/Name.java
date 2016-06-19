package no.mesan.tvdb.vo;

import no.mesan.tvdb.vo.base.StringVo;

public class Name extends StringVo {

    public Name(final String name) {
        super(name);
    }

    public static Name from(final String name) {
        return new Name(name);
    }
}
