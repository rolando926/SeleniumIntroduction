package XPathConstantElements;

/**
 * Created by rrolando on 12/19/16.
 */
public interface DOTCOM {
    //URLs
    public static final String homeURL = "http:\\www.homedepot.com";

    // Header Search elements
    public static final String headerSearchBar = ".//input[@id='headerSearch']";
    public static final String headerSearchBarButton = ".//button[@id='headerSearchButton']";
    public static final String departmentMainMenu = ".//a[text()='All Departments']";
    public static final String christmasSubMenu = ".//a[text()='Christmas Decorations']";
    public static final String christmasTreesSubMenu = ".//a[text()='Christmas Trees']";
    public static final String mainMenuDivWrapper = ".//div[@class='MainFlyout__level1Wrapper']";
    public static final String navigateMenuChristmasTree = "departmentMainMenu;christmasSubMenu;christmasTreesSubMenu";

    // Search Page elements
    public static final String searchResultText = ".//span[@class='original-keyword u__regular']";
    public static final String searchChristmasTrees = ".//h1[@class='page-header' and text()='Christmas Trees']";
    public static final String searchPriceRefiner = ".//span[@class='top-refinement-label js-top-refinement-label drop-down__title drop-down__title--alt' and text()='Price']";

    // Price Search
    public static final String firstPriceElement = ".//span[@id='text_$0 - $10']";
    public static final String firstPriceLabel = ".//span[@class='bttn__content' and text()='Price: $0 - $10']";
}
