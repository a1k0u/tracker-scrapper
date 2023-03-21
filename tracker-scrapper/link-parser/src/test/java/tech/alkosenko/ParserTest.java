package tech.alkosenko;

import static org.junit.Assert.*;
import static tech.alkosenko.linkParser.services.utils.TransformerServiceDataToRecord.transformServiceToGitHub;
import static tech.alkosenko.linkParser.services.utils.TransformerServiceDataToRecord.transformServiceToStackOverflow;

import org.junit.Test;
import tech.alkosenko.linkParser.Parser;
import tech.alkosenko.linkParser.services.data.ServiceData;
import tech.alkosenko.linkParser.services.records.GitHubServiceData;

public class ParserTest {
    public boolean gitHubEquals(
            ServiceData serviceData, String userName, String repositoryName) {
        GitHubServiceData gitHubServiceData =
                transformServiceToGitHub(serviceData);
        return gitHubServiceData.userName().equals(userName)
                && gitHubServiceData.repositoryName().equals(repositoryName);
    }

    public boolean stackOverflowEquals(ServiceData serviceData, String id) {
        return transformServiceToStackOverflow(serviceData).id().equals(id);
    }

    @Test
    public void githubNoInfoTest() {
        assertNull(Parser.parse("https://github.com/"));
        assertNull(Parser.parse("https://github.com/a1k0u"));
        assertNull(Parser.parse("https://github.com/a1k0u?tab=repositories"));
    }

    @Test
    public void gitHubRepositoryTest() {
        ServiceData serviceData =
                Parser.parse("https://github.com/a1k0u/tracker-scrapper");
        assertTrue(gitHubEquals(serviceData, "a1k0u", "tracker-scrapper"));
    }

    @Test
    public void gitHubPullRequestTest() {
        ServiceData serviceData = Parser.parse(
                " https://github.com/a1k0u/my-python-web-services/pull/6");
        assertTrue(
                gitHubEquals(serviceData, "a1k0u", "my-python-web-services"));
    }

    @Test
    public void gitHubBranchTest() {
        ServiceData serviceData = Parser.parse(
                "https://github.com/a1k0u/error-recovery/tree/error-production");
        assertTrue(gitHubEquals(serviceData, "a1k0u", "error-recovery"));
    }

    @Test
    public void stackOverflowNoInfoTest() {
        ServiceData serviceData = Parser.parse("https://stackoverflow.com");
        assertNull(serviceData);
    }

    @Test
    public void stackOverflowAnswerTest() {
        ServiceData serviceData =
                Parser.parse("https://stackoverflow.com/a/75784699/21434190");
        assertTrue(stackOverflowEquals(serviceData, "75784699"));
    }

    @Test
    public void stackOverflowUserTest() {
        ServiceData serviceData = Parser.parse(
                "https://stackoverflow.com/users/21434190/alexey-kosenko");
        assertTrue(stackOverflowEquals(serviceData, "21434190"));
    }

    @Test
    public void stackOverflowQuestionTest() {
        ServiceData serviceData = Parser.parse(
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
