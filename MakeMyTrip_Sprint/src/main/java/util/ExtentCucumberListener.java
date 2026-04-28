package util;

import io.cucumber.java.Scenario;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import util.ExtentReportUtility;
import util.ScreenshotUtility;
import base.BaseClass;

public class ExtentCucumberListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
    }

    private void stepStarted(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
            String stepText = step.getStep().getKeyword() + step.getStep().getText();
            ExtentReportUtility.step.set(
                    ExtentReportUtility.test.get().createNode(stepText)
            );
        }
    }

    private void stepFinished(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            Status status = event.getResult().getStatus();
            try {
                if (status.name().equals("PASSED")) {
                    ExtentReportUtility.step.get().pass("Step Passed");
                }
                else if (status.name().equals("FAILED")) {
                    // Capture screenshot file for Extent Report
                    String path = new ScreenshotUtility()
                            .capture(BaseClass.getCurrentDriver(), "FailedStep");

                    ExtentReportUtility.step.get()
                            .fail(event.getResult().getError())
                            .addScreenCaptureFromPath(path);

                    // Attach screenshot bytes to Cucumber Report
                    Scenario scenario = ExtentReportUtility.currentScenario.get();
                    if (scenario != null) {
                        byte[] screenshotBytes = ((TakesScreenshot) BaseClass.getCurrentDriver())
                                .getScreenshotAs(OutputType.BYTES);
                        scenario.attach(screenshotBytes, "image/png", "Failed Step Screenshot");
                    }
                }
                else if (status.name().equals("SKIPPED")) {
                    ExtentReportUtility.step.get().skip("Step Skipped");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}