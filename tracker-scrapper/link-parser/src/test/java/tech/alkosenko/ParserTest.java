package tech.alkosenko;

import static org.junit.Assert.*;

import org.junit.Test;
import tech.alkosenko.linkParser.Parser;
import tech.alkosenko.linkParser.services.records.GitHubServiceData;
import tech.alkosenko.linkParser.services.records.StackOverflowServiceData;

public class ParserTest {
    public boolean gitHubEquals(
            GitHubServiceData serviceData, String userName, String repositoryName) {
        return serviceData.userName().equals(userName)
                && serviceData.repositoryName().equals(repositoryName);
    }

    public boolean stackOverflowEquals(
            StackOverflowServiceData serviceData, String id) {
        return serviceData.id().equals(id);
    }

    @Test
    public void githubNoInfoTest() {
        assertNull(Parser.parse("https://github.com/"));
        assertNull(Parser.parse("https://github.com/a1k0u"));
        assertNull(Parser.parse("https://github.com/a1k0u?tab=repositories"));
    }

    @Test
    public void gitHubRepositoryTest() {
        GitHubServiceData serviceData = (GitHubServiceData) Parser.parse(
                "https://github.com/a1k0u/tracker-scrapper");
        assertTrue(gitHubEquals(serviceData, "a1k0u", "tracker-scrapper"));
    }

    @Test
    public void gitHubPullRequestTest() {
        GitHubServiceData serviceData = (GitHubServiceData) Parser.parse(
                " https://github.com/a1k0u/my-python-web-services/pull/6");
        assertTrue(
                gitHubEquals(serviceData, "a1k0u", "my-python-web-services"));
    }

    @Test
    public void gitHubBranchTest() {
        GitHubServiceData serviceData = (GitHubServiceData) Parser.parse(
                "https://github.com/a1k0u/error-recovery/tree/error-production");
        assertTrue(gitHubEquals(serviceData, "a1k0u", "error-recovery"));
    }

    @Test
    public void stackOverflowNoInfoTest() {
        StackOverflowServiceData serviceData =
                (StackOverflowServiceData) Parser.parse(
                        "https://stackoverflow.com");
        assertNull(serviceData);
    }

    @Test
    public void stackOverflowAnswerTest() {
        StackOverflowServiceData serviceData =
                (StackOverflowServiceData) Parser.parse(
                        "https://stackoverflow.com/a/75784699/21434190");
        assertTrue(stackOverflowEquals(serviceData, "75784699"));
    }

    @Test
    public void stackOverflowUserTest() {
        StackOverflowServiceData serviceData =
                (StackOverflowServiceData) Parser.parse(
                        "https://stackoverflow.com/users/21434190/alexey-kosenko");
        assertTrue(stackOverflowEquals(serviceData, "21434190"));
    }

    @Test
    public void stackOverflowQuestionTest() {
        StackOverflowServiceData serviceData =
                (StackOverflowServiceData) Parser.parse(
                        "https://stackoverflow.com/questions/75784539/r-one-to-many-mappings");

        assertTrue(stackOverflowEquals(serviceData, "75784539"));
    }

    @Test
    public void invalidUrlTest() {
        assertNull(Parser.parse("not_a_url"));
        assertNull(Parser.parse("hhtpp://url_ihih"));
        assertNull(Parser.parse("https://somesite.ru"));
    }
}
