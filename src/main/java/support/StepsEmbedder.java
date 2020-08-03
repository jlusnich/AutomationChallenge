package support;

import com.google.common.collect.Lists;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.openqa.selenium.WebDriver;
import steps.AmazonSearchSteps;
import steps.CommonSteps;

import java.util.Arrays;
import java.util.List;

public class StepsEmbedder extends Embedder {

    @Override
    public Configuration configuration(){
        Class<? extends StepsEmbedder> embeddedClass = this.getClass();
        return new MostUsefulConfiguration().useStoryControls(new StoryControls().doResetStateBeforeScenario(false))
            .useStoryLoader(new LoadFromClasspath(embeddedClass.getClassLoader()));
    }

    @Override
    public EmbedderControls embedderControls() {
        return new EmbedderControls().doIgnoreFailureInStories(false).doIgnoreFailureInView(false).doVerboseFailures(true)
                .useStoryTimeouts("5000");
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        AmazonSearchSteps amazonSearchSteps = new AmazonSearchSteps();
        CommonSteps commonSteps = new CommonSteps();

        List<Object> listSteps = Lists.newArrayList();
        listSteps.add(amazonSearchSteps);
        listSteps.add(commonSteps);

		return new InstanceStepsFactory(configuration(), listSteps);

    }

    public void runStory(String storyName) {
        WebDriver driver = WebDriverManager.getWebDriver();
        StoryFinder finder = new StoryFinder();
        String codeLocation = CodeLocations.codeLocationFromClass(this.getClass()).getFile();
        codeLocation = codeLocation.replace("%20", " ");
        List<String> stories = finder.findPaths(codeLocation, Arrays.asList(storyName), Arrays.asList(""));
        try {
            runStoriesAsPaths(stories);
        } catch (Exception e){
            throw e;
        } finally {
            driver.close();
        }
    }
}
