package com.epam.training.student_david_kadasiev.nested_classes.contact_book;

import java.util.Objects;

public class Contact {
    private String contactName;
    private final ContactInfo[] contactInfo = new ContactInfo[10];

    private class NameContactInfo implements ContactInfo{
        @Override
        public String getTitle(){
            return "Name";
        }

        @Override
        public String getValue(){
            return contactName;
        }

        @Override
        public String toString(){
            return "\"Name: " + contactName + "\"";
        }
    }

    public static class Email implements ContactInfo{
        private final String email;

        Email(String email){
            this.email = email;
        }

        @Override
        public String getTitle(){
            return "Email";
        }

        @Override
        public String getValue(){
            return email;
        }

        @Override
        public String toString(){
            return "\"Email: " + email + "\"";
        }
    }

    public static class Social implements ContactInfo{
        private String title;
        private final String id;

        Social(String title, String id){
            this.title = title;
            this.id = id;
        }

        Social(String id){
            this.id = id;
        }

        @Override
        public String getTitle(){
            return title;
        }

        @Override
        public String getValue(){
            return id;
        }

        @Override
        public String toString(){
            return "\"" + title + ": " + id + "\"";
        }
    }

    public Contact(String contactName) {
        this.contactName = contactName;
        contactInfo[0] = new NameContactInfo();
    }

    public void rename(String newName) {
        if(Objects.equals(newName, "") || newName == null){
            return;
        }
        contactName = newName;
    }

    public Email addEmail(String localPart, String domain) {
        if(contactInfo[2] != null && contactInfo[3] != null && contactInfo[4] != null){
            return null;
        }
        int i = 2;
        for(; i < 4; i++){
            if(contactInfo[i] == null){
                break;
            }
        }
        contactInfo[i] = new Email(localPart + "@" + domain);
        return (Email)contactInfo[i];
    }

    public Email addEpamEmail(String firstname, String lastname) {
        if(contactInfo[2] != null && contactInfo[3] != null && contactInfo[4] != null){
            return null;
        }
        int i = 2;
        for(; i < 5; i++){
            if(contactInfo[i] == null){
                break;
            }
        }
        contactInfo[i] = new Email(firstname + "_" + lastname + "@epam.com"){
            @Override
            public String getTitle(){
                return "Epam Email";
            }

            @Override
            public String toString(){
                return "\"Epam Email: " + getValue() + "\"";
            }
        };
        return (Email)contactInfo[i];
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if(contactInfo[1] != null){
            return null;
        }
        String phoneNumber = "+" + code + " " + number;
        ContactInfo phone = new ContactInfo() {
            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return phoneNumber;
            }

            @Override
            public String toString(){
                return "Tel: " + phoneNumber;
            }
        };
        contactInfo[1] = phone;
        return phone;
    }

    public Social addTwitter(String twitterId) {
        if(!isTherePlaceForMedia()){
            return null;
        }
        int index = getPlaceForMedia();
        contactInfo[index] = new Social(twitterId){
            @Override
            public String getTitle(){
                return "Twitter";
            }

            @Override
            public String toString(){
                return "\"Twitter:  " + getValue() + "\"";
            }
        };
        return (Social)contactInfo[index];
    }

    public Social addInstagram(String instagramId) {
        if(!isTherePlaceForMedia()){
            return null;
        }
        int index = getPlaceForMedia();
        contactInfo[index] = new Social(instagramId){
            @Override
            public String getTitle(){
                return "Instagram";
            }

            @Override
            public String toString(){
                return "\"Instagram:  " + getValue() + "\"";
            }
        };
        return (Social)contactInfo[index];
    }

    public Social addSocialMedia(String title, String id) {
        if(!isTherePlaceForMedia()) {
            return null;
        }
        return (Social)(contactInfo[getPlaceForMedia()] = new Social(title, id));
    }

    public ContactInfo[] getInfo() {
        int count = 0;
        for(ContactInfo contact : contactInfo){
            if(contact != null)
                count++;
        }
        ContactInfo[] contacts = new ContactInfo[count];
        int i = 0;
        for(ContactInfo contact : contactInfo){
            if(contact != null) {
                contacts[i++] = contact;
            }
        }
        return contacts;
    }

    private boolean isTherePlaceForMedia(){
        boolean isPlace = false;
        for(int i = 5; i < 10; i++){
            if (contactInfo[i] == null) {
                isPlace = true;
                break;
            }
        }
        return isPlace;
    }

    private int getPlaceForMedia(){
        int i = 5;
        for(; i < 10; i++){
            if (contactInfo[i] == null) {
                break;
            }
        }
        return i;
    }
}