package com.ceshiren.framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;

public class ParamsTest {

    @ParameterizedTest
    @MethodSource()
    void search(TestCase testCase){
/*        WebDriver driver = new ChromeDriver();
        driver.get("https://ceshiren.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#search-button")).click();
        driver.findElement(By.cssSelector("#search-term")).sendKeys("selenium");*/

        System.out.println(testCase);
        testCase.run();
    }

    static List<TestCase> search() throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        POTestCase testCase = mapper.readValue(
                ParamsTest.class.getResourceAsStream("/framework/search_po_test.yaml"),
                POTestCase.class);
        return testCase.testcase_generate();

    }

}
