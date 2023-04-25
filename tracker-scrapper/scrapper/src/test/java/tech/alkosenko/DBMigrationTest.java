package tech.alkosenko;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DBMigrationTest extends IntegrationEnvironment {
    @Test
    public void allTablesAreCreated() {
        String[] tables = {"chat", "link", "user_link"};

        try (Connection connection = getDBConnection()) {
            ResultSet rs =
                    connection.getMetaData().getTables(null, null, "%", null);
            ArrayList<String> tableNames = new ArrayList<>();

            while (rs.next()) {
                tableNames.add(rs.getString("TABLE_NAME"));
            }

            Assertions.assertTrue(tableNames.containsAll(List.of(tables)));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
