package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsOnlinePage extends BasePage{

    @FindBy(css=".wu-icon.wu-icon-heading__xl.icon-0124_menu.action-light")
    public WebElement burgerMenuIconLv;

    @FindBy(css=".header-hamburger_desktop__button.icon-D23-Menu-Hamburger.d-none.d-L-flex.wu-button.wu-button_primary.wu-button_primary--yellow.wu-icon__lg.m-0.text-black.pad-xxs-horz.outline-none")
    public WebElement burgerMenuIconUs;

    @FindBy(css=".wu-link.wu-link_tertiatry.wu-link_tertiatry--black.d-flex.align-items-center.header-hamburger__menu__item.text-decoration-none.pad-12-all.bdr-radius-all.text-nowrap[href='/us/en/bill-pay/app/billpay-start']\n")
    public WebElement burgerMenuPayBillsOption;

    @FindBy(xpath="//input[@id='companyName']")
    public WebElement payBillsPageCompanySearchBox;

    @FindBy(css="#billerNumber")
    public WebElement payBillsPageAccountNumberInputBox;

    @FindBy(css="#amount")
    public WebElement payBillsPageAmountInputBox;

    @FindBy(xpath="//div[@id='billPayFundsIn_AG']")
    public WebElement payBillsPagepayInStoreButton;

    @FindBy(xpath="//div[@id='billPayFundsIn_AG']")
    public WebElement payBillsPageUrgentButton;

    @FindBy(xpath="//li[@id='hamburger-nav-item']//li[6]//a[1]")
    public WebElement burgerMenuSettings;

    @FindBy(xpath="//select[@id='Question']")
    public WebElement settingsCountrySelectionBox;

    @FindBy(xpath="//div[@class='info-popup-container ng-star-inserted']//button[@class='btn btn-primary mrg-top-0 mrg-btm-0'][normalize-space()='Yes']\n")
    public WebElement settingsCountrySelectionConfirmationYesButton;

    @FindBy(xpath="//div[@class='info-popup-container ng-star-inserted']//button[@class='btn btn-primary btn-popup-negative mrg-top-0 mrg-btm-0 popup-no-btn-bg-color'][normalize-space()='No']")
    public WebElement settingsCountrySelectionConfirmationNoButton;

    @FindBy(xpath="//a[@class='wu-link wu-link_tertiatry wu-link_tertiatry--black pad-xxs-horz text-nowrap']//span[@class='text-nowrap'][normalize-space()='Send money']")
    public WebElement sendMoneyButtonHeader;

    @FindBy(css="button[type='submit']")
    public WebElement payBillsPageContinueButton;

    @FindBy(css="#eflState")
    public WebElement payBillsPageStateInputBox;

    @FindBy(xpath="//button[@id='onetrust-accept-btn-handler']")
    public WebElement privacyIAcceptButton;

    @FindBy(css="li[id='hamburger-nav-item'] li:nth-child(1) a:nth-child(1)")
    public WebElement burgerMenuFindLocationsOption ;

    @FindBy(css="#tab_Agent_anchor")
    public WebElement findLocationAgentButton;

    @FindBy(css="#input_input_find_agent_name")
    public WebElement findLocationAgentNameInputBox;

    @FindBy(css="#input_location_selection")
    public WebElement findLocationPostalCodeInputBox;

    @FindBy(css="#filter_open_now")
    public WebElement findLocationFilterOpenButton;

    @FindBy(xpath="//li[@id='agent_info_list1']//div//div[@id='label_find_agent_location_name']")
    public WebElement firstAgentLocatioOnList;

    @FindBy(xpath="//li[@id='agent_info_list1']//div//p[@id='label_find_location_postal_code']")
    public WebElement firstAgentLocatioPostalCode;

    @FindBy(xpath="//li[@id='agent_info_list1']//div//p[@id='label_find_location_location_address_city']")
    public WebElement firstAgentLocationAdressCity;

    @FindBy(xpath="//li[@id='agent_info_list1']//div//p[@id='label_find_location_agent_status']")
    public WebElement firstAgentLocationStatus;



}
