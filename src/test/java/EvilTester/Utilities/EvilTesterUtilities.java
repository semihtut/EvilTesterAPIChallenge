package EvilTester.Utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class EvilTesterUtilities {

    public static RequestSpecification requestChallenger(){

        // for Basic auth
       /* PreemptiveBasicAuthScheme basicAuthScheme = new PreemptiveBasicAuthScheme();
        basicAuthScheme.setPassword(password);
        basicAuthScheme.setUserName(email);*/
        RequestSpecification build = new RequestSpecBuilder()
                .setContentType("application/json")
                .setAccept(ContentType.JSON)
                .addHeader("X-challenger",ConfigurationReader.get("x-challenger"))
                .build();

        return build;

    }
}
