# MakeMyTrip BDD Automation Framework

End-to-end BDD automation suite for the MakeMyTrip web application. Tests are written in Gherkin and executed via Cucumber-JVM with Selenium WebDriver. PicoContainer handles dependency injection across hooks and step definitions, and Extent Reports are generated after every run.

---

## Tech Stack

| Tool | Version |
|---|---|
| Java | 1.8 |
| Selenium WebDriver | 4.x |
| Cucumber-JVM | 7.x |
| TestNG | 7.x |
| cucumber-testng | 7.x |
| PicoContainer | 2.x |
| Extent Reports | 5.x |
| Maven | 3.x |

---

## Modules Covered

- Flights
- Trains
- Hotels
- Cabs
- Holiday Packages
- Gift Cards

---

## Project Structure

```
MakeMyTrip_Sprint/
│
├── src/main/java/
│   ├── base/
│   │   ├── BaseClass.java                            → ThreadLocal WebDriver management
│   │   └── Pages.java                                → All page object refs + loadAllPages()
│   ├── pages/
|   |   ├── HomePage.java                             → Landing page + modal handling
│   │   ├── LoginPage.java                            → Login flow
│   │   ├── FlightSearchPage.java                     → Flight search inputs
│   │   ├── FlightTrackerPage.java                    → Flight status tracker
│   │   ├── HotelSearchPage.java                      → Hotel search inputs
│   │   ├── HPHomePage.java                           → Holiday packages landing
│   │   ├── HPFilterPage.java                         → Holiday package filters
│   │   ├── HPActivityInfoPage.java                   → Package activity details
│   │   ├── HPReviewPage.java                         → Holiday package review/booking
│   │   ├── Homepagecab.java                          → Cab home page
│   │   ├── CabPage.java                              → Cab details page
│   │   ├── CABS_SearchPage.java                      → Cab search results
│   │   ├── SelectCabpage.java                        → Cab selection
│   │   ├── ReviewBookingPage.java                    → Booking review page
│   │   ├── SelectGiftCardPage.java                   → Gift card selection
│   │   ├── SelectOccasionPage.java                   → Gift card occasion picker
│   │   ├── GiftCardBookingPage.java                  → Gift card booking
│   │   ├── TrainSearchPage.java                      → Train search inputs
│   │   ├── TrainPNRPage.java                         → PNR status check
│   │   ├── TrainAddPassengerPage.java                → Add passenger details
│   │   ├── TrainFilterPage.java                      → Train search filters
│   │   ├── TrainPaymentPage.java                     → Train payment
│   │   └── TrainLiveStatusCheckerPage.java           → Train live running status                                        → Page Object classes (one per screen)
│   └── util/
│       ├── Actions_Helper.java                       → Reusable Selenium action wrappers
│       ├── AllFunctionalities.java                   → Common cross-module functions
│       ├── AllFunctionalUtility.java                 → Additional shared utilities
│       ├── ConfigReader.java                         → Reads config.properties
│       ├── Excel_Utility.java                        → Excel read/write helpers
│       ├── ExcelReader.java                          → Reads test data from .xlsx
│       ├── ExtentCucumberListener.java               → Hooks Cucumber events into Extent
│       ├── ExtentReportUtility.java                  → Extent HTML report generation
│       ├── JavaScriptExecutor_Utility.java           → JS-based interactions
│       ├── ScreenshotUtility.java                    → Screenshot capture helper
│       └── WebDriver_Utility.java                    → Driver-level utility methods
│
├── src/main/resources/
│   └── config.properties                             → Browser, URL, timeout, env config
│
├── src/test/java/
│   ├── hooks/
│   │   └── hook.java                                 → @Before / @After lifecycle
│   ├── stepDefinition/
│   │   ├── CabBookingSteps.java
│   │   ├── FlightSearchSteps.java
│   │   ├── FlightTrackerSteps.java
│   │   ├── GiftCardSteps.java
│   │   ├── HotelBookingStepDefinition.java
│   │   ├── HotelSearchStepDefinition.java
│   │   ├── HotelSelectionStepDefinition.java
│   │   ├── HP_TS1_SearchTest.java
│   │   ├── HP_TS2_FilterTest.java
│   │   ├── HP_TS3_ActivityTest.java
│   │   ├── HP_TS4_AddTravellerTest.java
│   │   ├── HP_TS5_AddInsuranceTest.java
│   │   ├── HP_TS6_HPBookingTest.java
│   │   ├── Train_AddMultiplePassengersStepDefinition.java
│   │   ├── Train_LiveStatus.java
│   │   ├── trainFilterSteps.java
│   │   ├── trainPassengerDetails.java
│   │   ├── trainPnr.java
│   │   ├── trainPNRIncorrect.java
│   │   ├── trainSearchStepDefinition.java
│   │   └── TS_LoginTest.java
│   └── testRunner/
│       └── TestRunnerIO.java                         → Cucumber + TestNG runner
│
├── src/test/resources/
│   ├── features/
│   │   ├── Cab_TripDetails.feature
│   │   ├── Flight_TS1-TS2.feature
│   │   ├── Flight_TS3-TS4.feature
│   │   ├── Flight_TS5-TS6.feature
│   │   ├── GiftCards.feature
│   │   ├── hotelBooking.feature
│   │   ├── hotelDates.feature
│   │   ├── hotelNegative.feature
│   │   ├── hotelSearch.feature
│   │   ├── hotelSelection.feature
│   │   ├── HP_TS1_SearchPackage.feature
│   │   ├── HP_TS2_FilterPackage.feature
│   │   ├── HP_TS3_PackageActivity.feature
│   │   ├── HP_TS4_AddTraveller.feature
│   │   ├── HP_TS5_AddInsurance.feature
│   │   ├── HP_TS6_HPBooking.feature
│   │   ├── sample.feature
│   │   ├── Train_AddMultiplePassenger.feature
│   │   ├── Train_AddPassenger.feature
│   │   ├── Train_Filtering.feature
│   │   ├── Train_LiveStatus.feature
│   │   ├── Train_PNRStatus.feature
│   │   ├── Train_Search.feature
│   │   └── TS_LoginApp.feature
│   └── testdata/
│       └── MakeMyTripExcelData.xlsx                  → Data-driven test inputs
│
├── pom.xml
└── testng.xml
```

---

## Prerequisites

Ensure the following are installed and configured before running the project:

- Java SE 21 — `JAVA_HOME` must be set and added to `PATH`
- Maven 3.x — must be added to `PATH`
- Google Chrome (latest stable version)
- Git

---

## Setup and Installation

**1. Clone the repository**
```bash
git clone https://github.com/your-org/makemytrip-automation.git
cd MakeMyTrip_Sprint
```

**2. Install dependencies**
```bash
mvn clean install -DskipTests
```

**3. Configure the test run**

Edit `src/main/resources/config.properties`:
```properties
browser=chrome
url=https://www.makemytrip.com
timeout=10
tester=Hari
env=staging
```

---

## How to Run Tests

Scenarios are triggered through `TestRunnerIO.java`, which extends `AbstractTestNGCucumberTests`. Maven calls TestNG, which calls the Cucumber runner.

**Run all tests**
```bash
mvn test
```

**Run via testng.xml**
```bash
mvn test -DsuiteXmlFile=testng.xml
```

**Run by tag at runtime**
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

**Run a specific module**
```bash
mvn test -Dcucumber.filter.tags="@trains"
```

---

## TestRunner Setup

`TestRunnerIO.java` connects Cucumber with TestNG. It must extend `AbstractTestNGCucumberTests`:

```java
package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"hooks", "stepDefinition"},
    tags = "@regression",
    plugin = {
        "pretty",
        "html:reports/cucumber-report.html"
    },
    monochrome = true
)
public class TestRunnerIO extends AbstractTestNGCucumberTests {
}
```

To run scenarios in parallel, override `dataProvider` in the runner:
```java
@Override
@DataProvider(parallel = true)
public Object[][] scenarios() {
    return super.scenarios();
}
```

---

## Configuration Reference

| Key | Description | Accepted Values |
|---|---|---|
| `browser` | Browser to launch | `chrome`, `firefox`, `edge` |
| `url` | Base URL of the application | Any valid URL |
| `timeout` | Implicit wait duration in seconds | Integer e.g. `10` |
| `tester` | Tester name shown in Extent Report | Any string |
| `env` | Environment label shown in Extent Report | `staging`, `prod`, `uat` |

---

## Test Data

Data-driven scenarios read input from:
```
src/test/resources/testdata/MakeMyTripExcelData.xlsx
```

Use `ExcelReader.java` or `Excel_Utility.java` from the `util` package to access rows and columns in step definitions. Sheet names should match the module they belong to (e.g. `Flights`, `Trains`, `Hotels`).

---

## Tagging Strategy

Tags are applied in `.feature` files above the `Scenario` keyword and used to filter which tests run.

| Tag | Purpose |
|---|---|
| `@smoke` | Critical path tests — run on every build |
| `@regression` | Full suite — run nightly |
| `@flights` | Flight module scenarios only |
| `@trains` | Train module scenarios only |
| `@hotels` | Hotel module scenarios only |
| `@cabs` | Cab module scenarios only |
| `@holidaypackages` | Holiday package module scenarios only |
| `@giftcards` | Gift card module scenarios only |
| `@wip` | Work in progress — excluded from CI runs |

---

## Writing New Tests

Follow these steps to add a new scenario to the framework:

1. Create or open the relevant `.feature` file under `src/test/resources/features/`
2. Write the scenario in Gherkin using `Given / When / Then`
3. Create the page object class under `src/main/java/pages/` and call `PageFactory.initElements(driver, this)` in its constructor
4. Add the page field to `Pages.java` and initialise it inside `loadAllPages()`
5. Create the step definition class under `stepDefinition/` and inject `BaseClass` and `Pages` via constructor
6. Tag the scenario with the appropriate module tag and either `@smoke` or `@regression`

**Step definition constructor pattern:**
```java
public class myModuleSteps {
    private BaseClass b;
    private Pages pages;

    public myModuleSteps(BaseClass b, Pages pages) {
        this.b = b;
        this.pages = pages;
    }
}
```

PicoContainer injects the same `BaseClass` and `Pages` instances used in `hook.java` — do not create new instances manually.

---

## How the Framework Works

```
TestRunnerIO.java  ← TestNG triggers this
│
└── @Before in hook.java
        │
        ├── Reads config.properties via ConfigReader
        ├── Launches browser → b.setDriver(driver)
        ├── p.loadAllPages(driver) → creates all page object instances
        │       └── Each page constructor calls PageFactory.initElements()
        │               └── @FindBy WebElements wired up inside each page
        │
        └── Step Definition constructor receives same b and pages via PicoContainer
                │
                └── pages.tp.enterSource("Chennai")  ✓ works
```

`loadAllPages()` creates the page object instances. `PageFactory.initElements()` inside each page class wires up the `@FindBy` WebElements. Both are required — removing either causes a `NullPointerException` at a different level.

---

## Reports

After every run, an HTML report is generated at:
```
reports/ExtentReport.html
```

The report includes pass/fail status per scenario, step-level logs, browser and environment info, and screenshots on failure captured via `ScreenshotUtility.java`. `ExtentCucumberListener.java` hooks into Cucumber's event system and feeds results into Extent automatically.

---

## Team Members
 - Hari Sri Ragavi S
 - Monica D
 - Lakshmi Priya T
 - Renukasree M
 - Padma Priya D
