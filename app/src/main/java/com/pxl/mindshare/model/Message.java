package com.pxl.mindshare.model;

public class Message {
    private User sender;
    private User receiver;
    private String messageText;

    public Message(User sender, User receiver, String messageText) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageText = messageText;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMessageText() {
        return messageText;
    }

    public String getShortMessageText() {
        return messageText.substring(0,10) + "...";
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
