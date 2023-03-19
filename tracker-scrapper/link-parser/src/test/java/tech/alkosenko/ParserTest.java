package tech.alkosenko;

import static org.junit.Assert.*;

import org.junit.Test;
import tech.alkosenko.linkParser.Parser;
import tech.alkosenko.linkParser.services.objects.ServiceData;
import tech.alkosenko.linkParser.services.objects.Id;

public class ParserTest {
    public static Parser parser = new Parser();
    public boolean gitHubEquals(
            ServiceData serviceData, String user, String repository) {
        return serviceData.id == Id.GITHUB
                && serviceData.serviceData.get("user").equals(user)
                && serviceData.serviceData.get("repository").equals(repository);
    }

    public boolean stackOverflowEquals(ServiceData serviceData, String id) {
        return serviceData.id == Id.STACKOVERFLOW
                && serviceData.serviceData.get("id").equals(id);
    }

    @Test
    public void githubNoInfoTest() {
        assertNull(parser.parse("https://github.com/"));
        assertNull(parser.parse("https://github.com/a1k0u"));
        assertNull(parser.parse("https://github.com/a1k0u?tab=repositories"));
    }

    @Test
    public void gitHubRepositoryTest() {
        ServiceData serviceData =
                parser.parse("https://github.com/a1k0u/tracker-scrapper");
        assertTrue(gitHubEquals(serviceData, "a1k0u", "tracker-scrapper"));
    }

    @Test
    public void gitHubPullRequestTest() {
        ServiceData serviceData = parser.parse(
                " https://github.com/a1k0u/my-python-web-services/pull/6");
        assertTrue(
                gitHubEquals(serviceData, "a1k0u", "my-python-web-services"));
    }

    @Test
    public void gitHubBranchTest() {
        ServiceData serviceData = parser.parse(
                "https://github.com/a1k0u/error-recovery/tree/error-production");
        assertTrue(gitHubEquals(serviceData, "a1k0u", "error-recovery"));
    }

    @Test
    public void stackOverflowNoInfoTest() {
        ServiceData serviceData = parser.parse("https://stackoverflow.com");
        assertNull(serviceData);
    }

    @Test
    public void stackOverflowAnswerTest() {
        ServiceData serviceData =
                parser.parse("https://stackoverflow.com/a/75784699/21434190");
        assertTrue(stackOverflowEquals(serviceData, "75784699"));
    }

    @Test
    public void stackOverflowUserTest() {
        ServiceData serviceData = parser.parse(
                "https://stackoverflow.com/users/21434190/alexey-kosenko");
        assertTrue(stackOverflowEquals(serviceData, "21434190"));
    }

    @Test
    public void stackOverflowQuestionTest() {
        ServiceData serviceData = parser.parse(
                "https://stackoverflow.com/questions/75784539/r-one-to-many-mappings");
        assertTrue(stackOverflowEquals(serviceData, "75784539"));
    }

    @Test
    public void invalidUrlTest() {
        assertNull(parser.parse("not_a_url"));
        assertNull(parser.parse("hhtpp://url_ihih"));
        assertNull(parser.parse("https://somesite.ru"));
    }
}