package stepdefinitions;

import base.BaseClass;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utils.ConfigReader;

import java.io.IOException;

public class ParaBankStepClass extends BaseClass {

    HomePage homePage;
    RegisterPage registerPage;
    AccountOverviewPage accountOverviewPage;
    OpenNewAccountPage openNewAccountPage;
    AccountOpenedPage accountOpenedPage;
    TransferFundsPage transferFundsPage;
    TransferCompletePage transferCompletePage;
    BillPayPage billPayPage;
    BillPaymentCompletePage billPaymentCompletePage;
    RequestLoanPage requestLoanPage;
    LoanRequestProcessedPage loanRequestProcessedPage;

    @Given("user opens the Parabank homepage")
    public void user_opens_the_parabank_homepage() {
        homePage = new HomePage(driver);
    }
    @When("user clicks the Register link")
    public void user_clicks_the_register_link() {
       homePage.clickRegister();
       registerPage = new RegisterPage(driver);
    }
    @Then("the registration page should be displayed")
    public void the_registration_page_should_be_displayed() {
        String heading = registerPage.getPageHeading();
        Assert.assertEquals(heading, "Signing up is easy!");
    }

    @When("user enters the valid registration details")
    public void user_enters_the_valid_registration_details() throws IOException {
        registerPage.enterFirstName(ConfigReader.getProperty("firstName"));
        registerPage.enterLastName(ConfigReader.getProperty("lastName"));
        registerPage.enterAddress(ConfigReader.getProperty("address"));
        registerPage.enterCity(ConfigReader.getProperty("city"));
        registerPage.enterState(ConfigReader.getProperty("state"));
        registerPage.enterZipcode(ConfigReader.getProperty("zipcode"));
        registerPage.enterPhoneNumber(ConfigReader.getProperty("phone"));
        registerPage.enterSSN(ConfigReader.getProperty("ssn"));
        registerPage.enterUserName(ConfigReader.getProperty("username"));
        registerPage.enterPassword(ConfigReader.getProperty("password"));
        registerPage.enterConfirmPassword(ConfigReader.getProperty("confirmPassword"));
    }
    @When("user clicks the Register button")
    public void user_clicks_the_register_button() {
        registerPage.clickRegisterBtn();
    }

    @Then("the account should be created successfully")
    public void the_account_should_be_created_successfully() {
        String message = registerPage.getSuccessMessage();

        Assert.assertTrue(message.contains("Welcome"),"Account creation failed");
    }

    @When("user enters the valid username and password")
    public void user_enters_the_valid_username_and_password() throws IOException {
        homePage.enterUserName(ConfigReader.getProperty("username"));
        homePage.enterPassword(ConfigReader.getProperty("password"));
    }
    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        homePage.clickLoginBtn();
    }
    @Then("the account overview page should be displayed")
    public void the_account_overview_page_should_be_displayed() {
        accountOverviewPage = new AccountOverviewPage(driver);
        String pageHeading = accountOverviewPage.getPageHeading();
        Assert.assertTrue(pageHeading.contains("Overview"),"Account overview page is not displayed");
    }
    @Then("user clicks the Open New Account link")
    public void user_clicks_the_open_new_account_link() {
        accountOverviewPage.clickOpenNewAccountLink();
    }
    @Then("user selects the account type and select fromaccount")
    public void user_selects_the_account_type_and_select_fromaccount() {
        openNewAccountPage = new OpenNewAccountPage(driver);
        openNewAccountPage.selectAccountType("SAVINGS");
    }

    @Then("user clicks the Open New Account button")
    public void user_clicks_the_open_new_account_button() {
        openNewAccountPage.clickOpenNewAccountButton();
    }
    @Then("verify the new bank account successfully created by the user")
    public void the_new_bank_account_successfully_created_by_the_user() {
        accountOpenedPage = new AccountOpenedPage(driver);
        String heading = accountOpenedPage.getPageHeading();
        Assert.assertEquals(heading, "Account Opened!", "New bank account creation failed");

        String message = accountOpenedPage.getSuccessMessage();
        Assert.assertTrue(message.contains("Congratulations"),"Account opened success message is not displayed");
    }

    @Then("user navigates to Accounts Overview")
    public void user_navigates_to_accounts_overview() {
        accountOpenedPage.clickAccountsOverview();
    }
    @Then("the Accounts Overview page should be displayed and screenshot should be captureed")
    public void the_accounts_overview_page_should_be_displayed_and_screenshot_should_be_captureed() throws IOException {
        String heading = accountOverviewPage.getPageHeading();
        Assert.assertTrue(heading.contains("Overview"), "Accounts overview page is not displayed");
        takeScreenshot("AccountOverviewPage");
    }
    @When("user clicks the logout button")
    public void user_clicks_the_logout_button() {
        accountOverviewPage.clickLogoutLink();
    }
    @Then("user should be logged out successfully")
    public void user_should_be_logged_out_successfully() {
        String heading = homePage.getPageHeading();

        Assert.assertEquals(heading, "Customer Login", "User logout was unsuccessful");
    }
    @When("user clicks the Transfer Funds link")
    public void user_clicks_the_transfer_funds_link() {
        accountOverviewPage.clickTransferFundsLink();
        transferFundsPage = new TransferFundsPage(driver);
    }
    @When("user enters the transfer amount {string}")
    public void user_enters_the_transfer_amount(String amount) {
        transferFundsPage.enterAmount(amount);
    }

    @When("user clicks the Transfer button")
    public void user_clicks_the_transfer_button() {
        transferFundsPage.clickTransferBtn();
    }

    @Then("the funds should be transferred successfully")
    public void the_funds_should_be_transferred_successfully() {
        transferCompletePage = new TransferCompletePage(driver);
        String heading = transferCompletePage.getTransferCompleteHeading();
        Assert.assertEquals(heading, "Transfer Complete!", "Funds transfer was unsuccessful");

    }

    @Then("user clicks the Bill Pay link")
    public void user_clicks_the_bill_pay_link() {
        accountOverviewPage.clickBillPayLink();
        billPayPage = new BillPayPage(driver);
    }
    @Then("user enters the payee detail")
    public void user_enters_the_payee_detail() throws IOException {
        billPayPage.enterPayeeName(ConfigReader.getProperty("payeeName"));
        billPayPage.enterPayeeStreet(ConfigReader.getProperty("payeeStreet"));
        billPayPage.enterPayeeCity(ConfigReader.getProperty("payeeCity"));
        billPayPage.enterPayeeState(ConfigReader.getProperty("payeeState"));
        billPayPage.enterPayeeZipcode(ConfigReader.getProperty("payeeZipcode"));
        billPayPage.enterPayeePhoneNumber(ConfigReader.getProperty("payeePhoneNumber"));
        billPayPage.enterPayeeAccountNumber(ConfigReader.getProperty("payeeAccountNumber"));
        billPayPage.verifyPayeeAccountNumber(ConfigReader.getProperty("payeeAccountNumber"));
    }
    @Then("user enters the bill payment amount {string}")
    public void user_enters_the_bill_payment_amount(String amount) {
        billPayPage.enterAmount(amount);
    }
    @Then("user clicks the Send Payment button")
    public void user_clicks_the_send_payment_button() {
        billPayPage.clickSendPaymentBtn();
    }
    @Then("the bill payment should be completed successfully")
    public void the_bill_payment_should_be_completed_successfully() throws IOException {
        billPaymentCompletePage = new BillPaymentCompletePage(driver);
        String heading = billPaymentCompletePage.getPageHeading();
        Assert.assertEquals(heading, "Bill Payment Complete", "Bill payment was unsuccessful");

        String message = billPaymentCompletePage.getSuccessMessage();
        Assert.assertTrue(message.contains("was successful"), "Bill payment success message is not displayed");
        takeScreenshot("BillPaymentComplete");
    }

    @When("user clicks the Request Loan link")
    public void user_clicks_the_request_loan_link() {
        accountOverviewPage.clickRequestLoanLink();
        requestLoanPage = new RequestLoanPage(driver);
    }
    @When("user enters the loan amount {string}")
    public void user_enters_the_loan_amount(String loanAmount) {
        requestLoanPage.enterLoanAmount(loanAmount);
    }
    @When("user enters the down payment {string}")
    public void user_enters_the_down_payment(String downPayment) {
        requestLoanPage.enterDownPayment(downPayment);
    }
    @And("user clicks the apply now button")
    public void userClicksTheApplyNowButton() {
        requestLoanPage.clickApplyNowBtn();
    }
    @Then("the loan request result should be displayed")
    public void the_loan_request_result_should_be_displayed() throws IOException {
        loanRequestProcessedPage = new LoanRequestProcessedPage(driver);
        String heading = loanRequestProcessedPage.getPageHeading();
        Assert.assertEquals(heading, "Loan Request Processed", "Loan request was unsuccessful");
        takeScreenshot("LoanRequestProcessedPage");
    }

}
