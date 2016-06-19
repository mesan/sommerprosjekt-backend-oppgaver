package no.mesan.tvdb.util;

import java.time.OffsetDateTime;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;

public class RowMapperUtils {

    private RowMapperUtils() {}

    public static OffsetDateTime getOffsetDateTime(final ResultSet rs, final String columnName) throws SQLException {
        if (rs.getTimestamp(columnName) == null) {
            return null;
        }

        return OffsetDateTime.ofInstant(
            Timestamp.valueOf(rs.getTimestamp(columnName).toLocalDateTime()).toInstant(),
            ZoneId.systemDefault());
    }
}
