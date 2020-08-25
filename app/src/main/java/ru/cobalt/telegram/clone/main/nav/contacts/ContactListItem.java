package ru.cobalt.telegram.clone.main.nav.contacts;

public class ContactListItem {

    private final String userName;
    private final String status;
    private final int photoRes;

    public String getUserName() {
        return userName;
    }

    public String getStatus() {
        return status;
    }

    public int getPhotoRes() {
        return photoRes;
    }

    public ContactListItem(String userName, String status, int photo) {
        this.userName = userName;
        this.status = status;
        this.photoRes = photo;
    }

}
