package constant;

import java.io.File;

/**
 * OOPS: This interface is used to store the file paths used in the application. It provides a constant for the config file path.
 */
public interface FilePaths {

    String CONFIG_FILE_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config" + File.separator + "config.properties";

    String TEST_DATA_EXCEL_FILE_PATH = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "testData" + File.separator + "mar26-data-driven.xlsx";

    String FAILED_TEST_CASES = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "failedScreenshot" + File.separator + "%s.png";

}
