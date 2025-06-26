package com.Arth.sql_generator_service.util;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class SQLQueryCleaner {

    private static final Pattern SQL_COMMENT_PATTERN = Pattern.compile("--.*$", Pattern.MULTILINE);
    private static final Pattern MULTIPLE_SPACES_PATTERN = Pattern.compile("\\s+");

    public String cleanAndFormat(String sqlQuery) {
        if (sqlQuery == null || sqlQuery.trim().isEmpty()) {
            return "";
        }

        // Remove SQL comments
        String cleaned = SQL_COMMENT_PATTERN.matcher(sqlQuery).replaceAll("");

        // Remove code blocks
        cleaned = cleaned.replaceAll("```sql", "").replaceAll("```", "");

        // Remove prefixes
        cleaned = cleaned.replaceAll("(?i)SQL Query:", "").replaceAll("(?i)Query:", "");

        // Normalize whitespace
        cleaned = MULTIPLE_SPACES_PATTERN.matcher(cleaned).replaceAll(" ");

        // Remove empty lines and trim
        cleaned = cleaned.lines()
                .filter(line -> !line.trim().isEmpty())
                .map(String::trim)
                .reduce((a, b) -> a + "\n" + b)
                .orElse("");

        // Ensure semicolon at end
        if (!cleaned.endsWith(";")) {
            cleaned += ";";
        }

        return cleaned;
    }

    public boolean isValidSQL(String sqlQuery) {
        if (sqlQuery == null || sqlQuery.trim().isEmpty()) {
            return false;
        }

        String upperQuery = sqlQuery.toUpperCase().trim();

        // Basic SQL validation
        return upperQuery.contains("SELECT") ||
                upperQuery.contains("INSERT") ||
                upperQuery.contains("UPDATE") ||
                upperQuery.contains("DELETE") ||
                upperQuery.contains("CREATE") ||
                upperQuery.contains("ALTER") ||
                upperQuery.contains("DROP");
    }
}
