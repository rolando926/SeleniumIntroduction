package XPathConstantElements;

/**
 * Created by rrolando on 12/13/16.
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
}
