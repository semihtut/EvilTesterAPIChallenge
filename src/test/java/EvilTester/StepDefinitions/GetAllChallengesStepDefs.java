package EvilTester.StepDefinitions;

import EvilTester.POJOs.MyResponse;
import EvilTester.POJOs.ResponseTODOS;
import EvilTester.POJOs.TodoItem;
import EvilTester.POJOs.TodosItem;
import EvilTester.Utilities.ConfigurationReader;
import EvilTester.Utilities.EvilTesterUtilities;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class GetAllChallengesStepDefs {
    Response response;

    @Given("User enters the {string} with url")
    public void user_enters(String string) {
        if(string.equals("challenger")){
            response = given().spec(EvilTesterUtilities.requestChallenger()).when().post(ConfigurationReader.get("url")+string);
        }else{
            response = given().spec(EvilTesterUtilities.requestChallenger()).when().get(ConfigurationReader.get("url")+string);
        }

    }

    @Then("User should see all challenges")
    public void user_should_see_all_challenges() {
        Assert.assertEquals(200, response.statusCode());
        response.then().log().all();
        MyResponse resp = response.body().as(MyResponse.class);
        System.out.println(resp.getChallenges().get(0).getName());

    }

    @Then("User should see the X-CHALLENGER in the response header")
    public void user_should_see_the_X_CHALLENGER_in_the_response_header() {
        String xchall = response.header("X-challenger");
        ConfigurationReader.setProperties("x-challenger",xchall);

    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
        response.then().log().all();

    }

    @Given("User enters the {string} with url and id number {int}")
    public void userEntersTheWithUrlAndIdNumber(String endingPoint, int idNumber) {
        response = given().spec(EvilTesterUtilities.requestChallenger()).when().get(ConfigurationReader.get("url")+endingPoint+idNumber);
        TodoItem todoItem = response.body().as(TodoItem.class);
        System.out.println("todosItem.getTitle() = " + todoItem.getTodos().get(0).getTitle());
    }
}
