package seedu.duke;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiTest {
    @Test
    public void testModule() {
        System.out.println("Hardcoded url strings should remain the same");
        String hardcodeUrlString = "https://api.nusmods.com/v2/2020-2021/moduleList.json";
        String hardcodeUrlStringDetailed = "https://api.nusmods.com/v2/2020-2021/moduleInfo.json";
        Api api = new Api();
        assertEquals(api.urlString, hardcodeUrlString);
        assertEquals(api.urlStringDetailed, hardcodeUrlStringDetailed);
    }



}
