//creational design pattern
//Example 1

//Use Case: A configuration manager that ensures only one instance is created to manage application settings.
class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        // Load configuration settings
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void showConfig() {
        System.out.println("Configuration settings loaded.");
    }
}

// Example usage
public class ConfigApp {
    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        config1.showConfig();
        System.out.println("Are both instances same? " + (config1 == config2));
    }
}