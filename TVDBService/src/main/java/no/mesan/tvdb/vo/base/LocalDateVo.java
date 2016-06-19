package no.mesan.tvdb.vo.base;

import java.time.LocalDate;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Base for {@link LocalDate}-vo.
 */
public class LocalDateVo implements ValueObject<LocalDate>{

    private final LocalDate value;

    public LocalDateVo(final LocalDate value) {
        this.value = value;
    }

    public LocalDateVo(final String value) {
        this.value = LocalDate.parse(value);
    }

    @Override
    @JsonValue
    public LocalDate value() {
        return value;
    }

    public boolean hasValue() {
        return value != null;
    }

    public boolean isEmpty() {
        return !hasValue();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("value", value)
                .toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final LocalDateVo that = (LocalDateVo) o;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}