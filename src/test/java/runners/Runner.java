package runners;

public class Runner {
    public static void main(String[] args) {
        String[] cucumberArgs = new String[]{
                "src/test/resources/features/Purchase.feature",
                "--glue", "stepdefinitions",
                "--plugin", "pretty",
                "--plugin", "html:target/cucumber-reports.html"
        };
        try {
            io.cucumber.core.cli.Main.run(cucumberArgs, Thread.currentThread().getContextClassLoader());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
