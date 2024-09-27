//creational design pattern
//Example 2

//Use Case: A notification system that creates different types of notifications (Email, SMS) based on user preferences.
abstract class Notification {
    public abstract void notifyUser(String message);
}

class EmailNotification extends Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("Email Notification: " + message);
    }
}

class SMSNotification extends Notification {
    @Override
    public void notifyUser(String message) {
        System.out.println("SMS Notification: " + message);
    }
}

abstract class NotificationFactory {
    public abstract Notification createNotification();
}

class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}

// Example usage
public class NotificationApp {
    public static void main(String[] args) {
        NotificationFactory factory = new EmailNotificationFactory();
        Notification notification = factory.createNotification();
        notification.notifyUser("Hello via Email!");

        factory = new SMSNotificationFactory();
        notification = factory.createNotification();
        notification.notifyUser("Hello via SMS!");
    }
}