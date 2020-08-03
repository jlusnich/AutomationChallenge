package amazonTests;

import support.StepsEmbedder;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.steps.Steps;
import org.testng.annotations.Test;


public class AmazonTest {

   @Test()
    public void alexaSearchTest() {
        StepsEmbedder embedded= new StepsEmbedder();
        embedded.runStory("stories/AlexaSearchTest.story");
    }
}
