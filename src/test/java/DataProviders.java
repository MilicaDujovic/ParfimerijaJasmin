import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name ="failedLogin")
    public Object [][] getDataFromDataProvider(){
    return new Object [][]
            {
                    {Strings.YOUR_EMAIL, Strings.INVALID_PASSWORD},
                    {Strings.INVALID_EMAIL, Strings.YOUR_PASSWORD},
                    {Strings.INVALID_EMAIL, Strings.INVALID_PASSWORD}
            };

    }
}
