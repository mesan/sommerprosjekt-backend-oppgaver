package no.mesan.tvdb.vo.base;

import java.time.OffsetDateTime;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Base for {@link OffsetDateTimeVo}-vo.
 */
public class OffsetDateTimeVo implements ValueObject<OffsetDateTime>{

    private final OffsetDateTime value;

    public OffsetDateTimeVo(final OffsetDateTime value) {
        this.value = value;
    }

    public OffsetDateTimeVo(final String value) {
        this.value = OffsetDateTime.parse(value);
    }

    @Override
    @JsonValue
    public OffsetDateTime value() {
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

        final OffsetDateTimeVo that = (OffsetDateTimeVo) o;

        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}