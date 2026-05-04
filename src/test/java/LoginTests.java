import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void LoginSuccses(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ninamarkova97@gmail.com","Y4QHVU8QHv3a");
        app.getHelperUser().submitYalla();
        app.getHelperUser().submitOk();

    }
}
