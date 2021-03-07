package EvilTester.StepDefinitions;

import EvilTester.POJOs.*;
import EvilTester.Utilities.ConfigurationReader;
import EvilTester.Utilities.EvilTesterUtilities;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class GetAllChallengesStepDefs {
    //I initialize global variables to use them inside different step definitions
    Response response;
    int idGlobal;

    @Given("User enters the {string} with url")
    public void user_enters(String string) {
        if(string.equals("challenger")){
            response = given().spec(EvilTesterUtilities.requestChallenger()).when().post(ConfigurationReader.get("url")+string);
        }else{
            response = given().spec(EvilTesterUtilities.requestChallenger()).when().get(ConfigurationReader.get("url")+string);
        }

        //Just want to see all the ids
        response.jsonPath().getList("todos.id").forEach(System.out::println);
    }

    @Then("User should see all challenges")
    public void user_should_see_all_challenges() {
        Assert.assertEquals(200, response.statusCode());
        //To see the logs
        response.then().log().all();

        //An implementation of POJO classes
        MyResponse resp = response.body().as(MyResponse.class);
       // System.out.println(resp.getChallenges().get(0).getName());

    }

    @Then("User should see the X-CHALLENGER in the response header")
    public void user_should_see_the_X_CHALLENGER_in_the_response_header() {

        String xchall = response.header("X-challenger");

        // I store my data inside Configuration.properties file
        // In this step I set it into the config.properties
        ConfigurationReader.setProperties("x-challenger",xchall);

    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);

    }

    @Given("User enters the {string} with url and id number {int}")
    public void userEntersTheWithUrlAndIdNumber(String endingPoint, int idNumber) {
        response = given().spec(EvilTesterUtilities.requestChallenger()).when().get(ConfigurationReader.get("url")+endingPoint+idNumber);
        TodoItem todoItem = response.body().as(TodoItem.class);
        System.out.println("todosItem.getTitle() = " + todoItem.getTodos().get(0).getTitle());
    }

    @Given("User enters the {string} with url and POST")
    public void userEntersTheWithUrlAndPOST(String endingPoint) {
        // I use spec class to maintain code more reusable
        // In my utulities class there is RequestSpesification Interface
        response= given().spec(EvilTesterUtilities.requestChallenger())
                         .body(CreateTODO.createTODOs("MyNewTod11",false,"Challange new TODO"))
                         .when().post(ConfigurationReader.get("url")+endingPoint);
        String actualTitle = response.jsonPath().getString("title");
        Assert.assertEquals("Check the titles are same",actualTitle,"MyNewTod11");
        idGlobal = response.body().path("id");
        System.out.println("idGlobal = " + idGlobal);
        response = given().spec(EvilTesterUtilities.requestChallenger())
                .when().delete(ConfigurationReader.get("url")+endingPoint+"/"+idGlobal);

    }

    @Then("User can be able to delete any TODO with id")
    public void userCanBeAbleToDeleteAnyTODOWithId() {
        response = given().spec(EvilTesterUtilities.requestChallenger())
                .when().delete(ConfigurationReader.get("url")+"todos"+idGlobal);


    }

    @And("User should NOT see the deleted TODO")
    public void userShouldNOTSeeTheDeletedTODO() {
        response = given().spec(EvilTesterUtilities.requestChallenger()).when().get(ConfigurationReader.get("url")+"todos");
        List<Integer>allIds = response.jsonPath().getList("todos.id");
        allIds.forEach(System.out::println);
        Assert.assertFalse(allIds.contains(idGlobal));

    }
}
