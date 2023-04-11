package tech.alkosenko;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.core.PostgresDatabase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.DirectoryResourceAccessor;
import org.testcontainers.containers.PostgreSQLContainer;

public class IntegrationEnvironment {
    static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER;

    static {
        POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>("postgres:15");
        POSTGRE_SQL_CONTAINER.start();
        databaseMigrations();
    }

    protected static void databaseMigrations() {
        try (Connection connection = getDBConnection()) {
            Database postgres = new PostgresDatabase();
            postgres.setConnection(new JdbcConnection(connection));
            Liquibase liquibase = new Liquibase("master.xml",
                    new DirectoryResourceAccessor(
                            new File("../migrations").toPath().toAbsolutePath()),
                    postgres);
            liquibase.update(new Contexts(), new LabelExpression());
        } catch (SQLException | FileNotFoundException | LiquibaseException e) {
            throw new RuntimeException(e);
        }
    }

    protected static Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(POSTGRE_SQL_CONTAINER.getJdbcUrl(),
                POSTGRE_SQL_CONTAINER.getUsername(),
                POSTGRE_SQL_CONTAINER.getPassword());
    }
}
