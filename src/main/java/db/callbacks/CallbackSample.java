package db.callbacks;
import org.flywaydb.core.api.callback.*;

class CallbackSample implements Callback {
    
    // Ensures that this callback handles both events
    public boolean supports(Event event, Context context) {
        System.out.println("Check support function Event: " + event);
        return (event.equals(Event.AFTER_MIGRATE) || event.equals(Event.AFTER_MIGRATE_ERROR) 
        || event.equals(Event.AFTER_EACH_MIGRATE) || event.equals(Event.AFTER_VALIDATE));
    }
    
    // Not relevant if we don't interact with the database
    public boolean canHandleInTransaction(Event event, Context context) {
        return true;
    }
    
    // Send a notification when either event happens.
    public void handle(Event event, Context context) {
        System.out.println("Handling Event: " + event);
    }
}






