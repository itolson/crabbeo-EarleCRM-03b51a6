package com.enterprise.crm.messaging;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jamescrabbe
 */
@Named
@Stateful
@SessionScoped
public class MessageGateway {

    @Inject
    transient MessageService messageService;
    @Inject
    transient com.enterprise.crm.login.UserContent userContent;
    
    private Messages selectedMessage;
    private List<Messages> messages;
    private Long messageId;
    private String messageIdfrom;
    private String messageIdto;    
    private Date messageDatesent;
    private Date messageDateread;
    private String messageMessage;

    @PostConstruct
    public void initializeUser() {
        String username = userContent.getLoggedInUser().getUserName();
        messages = messageService.getMessagesByUserName(username);
    }

    public Messages getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(Messages selectedMessage) {
        this.selectedMessage = selectedMessage;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageIdfrom() {
        return messageIdfrom;
    }

    public void setMessageIdfrom(String messageIdfrom) {
        this.messageIdfrom = messageIdfrom;
    }

    public String getMessageIdto() {
        return messageIdto;
    }

    public void setMessageIdto(String messageIdto) {
        this.messageIdto = messageIdto;
    }

    public Date getMessageDatesent() {
        return messageDatesent;
    }

    public void setMessageDatesent(Date messageDatesent) {
        this.messageDatesent = messageDatesent;
    }

    public Date getMessageDateread() {
        return messageDateread;
    }

    public void setMessageDateread(Date messageDateread) {
        this.messageDateread = messageDateread;
    }

    public String getMessageMessage() {
        return messageMessage;
    }

    public void setMessageMessage(String messageMessage) {
        this.messageMessage = messageMessage;
    }
    
    public MessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void save() {
        messageService.save(selectedMessage);
    }

    public void delete() {
        messageService.delete(selectedMessage);
        //Refresh the User list
        initializeUser();

    }

    public void add() {
        Date Datesent = new Date();
        messageIdfrom="itolson";
        messageIdto="jbloggs";
        messageDateread= new Date();

        System.out.println("messageMessage" + messageMessage);
        
        
        messageService.add(messageIdfrom, messageIdto, Datesent, messageDateread, messageMessage);
        //Reset the values
        messageIdfrom = null;
        messageIdto = null;
        messageDatesent = null;
        messageDateread = null;
        messageMessage = null;

        //Refresh the USer list
        initializeUser();
    }
}
