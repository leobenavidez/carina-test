package com.solvd.meta.carina.gui.utils;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.zebrunner.agent.core.registrar.TestRunRegistrar.LOGGER;

public class TakeScreenshot implements IDriverPool {

    public TakeScreenshot() {
    }

    public void makeScreenshot(String path) {

        File outputfile = new File(FilenameUtils.normalize("./Screenshots/" + path));
        BufferedImage screenshot = null;
        try {
            screenshot = ImageIO.read(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE));
            ImageIO.write(screenshot, "PNG", outputfile);
        } catch (IOException e) {
            LOGGER.info("Unable to capture screenshot");
            e.printStackTrace();
        }
    }
}
