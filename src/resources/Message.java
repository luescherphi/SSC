package resources;
import java.time.LocalDateTime;

/**
 * A Class for the Message Object. It contains the Author, Timestamp and the Message Text.
 */
public class Message {
    private int chatroomID;
    private LocalDateTime timestamp;
    private String author;
    private String messageText;

    /**
     * Creates a Message Instance with these Params.
     * @param author who wrote the Message
     * @param timestamp of the Message Date and Time ISO-8601
     * @param messageText of Message
     */
    public Message(int chatroomID, String author, LocalDateTime timestamp, String messageText){
        this.chatroomID = chatroomID;
        this.timestamp = timestamp;
        this.author = author;
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

    public int getChatroomID() {
        return chatroomID;
    }
}
