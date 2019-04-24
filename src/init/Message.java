package init;
import java.time.LocalDateTime;

/**
 * A Class for the Message Object. It contains the Author, Timestamp and the Message Text.
 */
public class Message {
    private String author;
    private LocalDateTime timestamp;
    private String messageText;

    /**
     * Creates a Message Instance with these Params.
     * @param author who wrote the Message
     * @param timestamp of the Message Date and Time ISO-8601
     * @param messageText of Message
     */
    public Message(String author, LocalDateTime timestamp, String messageText){
        this.author = author;
        this.timestamp = timestamp;
        this.messageText = messageText;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessageText() {
        return messageText;
    }
}
