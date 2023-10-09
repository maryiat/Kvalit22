package webpage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import testbase.BaseClassPw;

import java.util.ArrayList;
import java.util.List;

public class HttpTrafficDemo extends BaseClassPw {

    @Test
    public void monitorHttpTrafficDemo() {

        List<Integer> responses = new ArrayList<>();
        page.onResponse(response -> responses.add(response.status()));

        page.navigate("https://playwright.dev/");

        System.out.println(responses);

        boolean foundMatch = responses.stream()
                .anyMatch(i -> i < 200 || i >= 300);

        Assertions.assertFalse(foundMatch);
    }
}
