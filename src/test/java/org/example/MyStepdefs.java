package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import support.KnowsTheDomain;

public class MyStepdefs {

    KnowsTheDomain helper;

    public MyStepdefs(){
        helper = new KnowsTheDomain();
    }


    @Given("^I have deposited \\$(\\d+) in my account$")
    public void i_have_deposited_$_in_my_account(int amount) {
        // Write code here that turns the phrase above into concrete actions

        helper.getMyAccount().deposit(amount);

        Assert.assertEquals("Incorrect account balance", amount, helper.getMyAccount().getBalance());
    }

    @When("I withdraw ${int}")
    public void i_withdraw_$(int amount) {
        // Write code here that turns the phrase above into concrete actions
        Teller teller = new Teller(helper.getCashSlot());
        teller.withdrawFrom(helper.getMyAccount(), amount);

    }

    @Then("${int} should be dispensed")
    public void $_should_be_dispensed(int dollars) {
       Assert.assertEquals("Incorrect amount dispensed", dollars, helper.getCashSlot().getContents());
    }


}
