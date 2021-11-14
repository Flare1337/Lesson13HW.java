package src.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Message implements Comparable<Message> {
    private String message;
    private String name;
    private long phoneNumber;

    public Message(String message, String name, long phoneNumber) {
        this.message = message;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Collection <Message> findMessage(Collection<Message> messageCollection, String inputMessage) {
        Collection<Message> messages = new ArrayList<>();
        for (Message message : messageCollection) {
            if (message.getMessage().equals(inputMessage)) {
                messages.add(message);
            }
        }
        return messages;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message1 = (Message) o;
        return phoneNumber == message1.phoneNumber &&
                message.equals(message1.message) &&
                name.equals(message1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, name, phoneNumber);
    }

    @Override
    public int compareTo(Message o) {
        return 0;
    }
}
