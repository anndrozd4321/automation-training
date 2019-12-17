package by.bsu.drozd.model;

import java.util.Objects;

public class UserData {
    private String bookingNumber;
    private String email;
    private String userName;
    private String cardNumber;
    private String nameOnCard;
    private String expirationDateMonth;
    private String expirationDateYear;
    private String cvcCVV;


    public UserData(String cardNumber, String nameOnCard, String expirationDateMonth, String expirationDateYear, String cvcCVV) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.expirationDateMonth = expirationDateMonth;
        this.expirationDateYear = expirationDateYear;
        this.cvcCVV = cvcCVV;
    }

    public UserData(String bookingNumber, String email) {
        this.bookingNumber = bookingNumber;
        this.email = email;
    }

    public String getBookingNumber() { return bookingNumber; }

    public void setBookingNumber(String bookingNumber) { this.bookingNumber = bookingNumber;  }

    public String getEmail() { return email;  }

    public void setEmail(String email) { this.email = email;  }

    public String getUserName() { return userName;  }

    public void setUserName(String userName) { this.email = userName;  }

    public String getCardNumber() { return cardNumber;  }

    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber;  }

    public String getNameOnCard() { return nameOnCard;  }

    public void setNameOnCard(String nameOnCard) { this.nameOnCard = nameOnCard;  }

    public String getExpirationDateMonth() { return expirationDateMonth;  }

    public void setExpirationDateMonth(String expirationDateMonth) { this.expirationDateMonth = expirationDateMonth;  }

    public String getExpirationDateYear() { return expirationDateYear;  }

    public void setExpirationDateYear(String expirationDateYear) { this.expirationDateYear = expirationDateYear;  }

    public String getCvcCVV() { return cvcCVV;  }

    public void setCvcCVV(String cvcCVV) { this.cvcCVV = cvcCVV;  }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return  Objects.equals(bookingNumber, userData.bookingNumber)&&
                Objects.equals(email, userData.email)&&
                Objects.equals(userName, userData.userName)&&
                Objects.equals(cardNumber, userData.cardNumber)&&
                Objects.equals(nameOnCard, userData.nameOnCard)&&
                Objects.equals(expirationDateMonth, userData.expirationDateMonth)&&
                Objects.equals(expirationDateYear, userData.expirationDateYear)&&
                Objects.equals(cvcCVV, userData.cvcCVV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingNumber, email, userName, cardNumber, nameOnCard, expirationDateMonth,
                expirationDateYear, cvcCVV);
    }
}
