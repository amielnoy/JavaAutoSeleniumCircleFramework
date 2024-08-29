package Config;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

 public class ConfigurationManager {
     private static ConfigurationManager ConfigurationManagerInstance=null;
    private final Properties prop = new Properties();
    private  ConfigurationManager(String env) {
        try
        {
            InputStream props= Files.newInputStream(Paths.get("src/test/resources/" + env + ".properties"));
            prop.load(props);
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static ConfigurationManager GetInstance(String Env)
    {
        if (ConfigurationManagerInstance==null)
        {
            ConfigurationManagerInstance= new ConfigurationManager(Env);
        }
        return ConfigurationManagerInstance;
    }
     public  String GetProperty(String Name)
     {
         return  prop.getProperty(Name);
     }

 }
