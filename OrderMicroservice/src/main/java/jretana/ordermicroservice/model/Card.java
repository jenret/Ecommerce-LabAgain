package jretana.ordermicroservice.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.UUID;

public class Card {

    @Id
    private UUID cardUUID;

    private String cardName;

    private String cardNumber;

    private String expirationDate;

    private String CVV;

    private String company;

    public Card() {
    }

    public Card(UUID cardUUID, String cardName, String cardNumber, String expirationDate, String CVV, String company) {
        this.cardUUID = cardUUID;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.CVV = CVV;
        this.company = company;
    }

    public UUID getCardUUID() {
        return cardUUID;
    }

    public void setCardUUID(UUID cardUUID) {
        this.cardUUID = cardUUID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

//    public boolean isValid(String cardNumber, String expirationDate, String cvv) {
//        boolean isValid = false;
//        try {
//            String expirationDatePattern = "(?:0[1-9]|1[0-2])/[0-9]{2}";
//
//            String cardNumberPattern = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
//                    "(?<mastercard>5[1-5][0-9]{14})|" +
//                    "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
//                    "(?<amex>3[47][0-9]{13})|" +
//                    "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
//                    "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
//
//            String cvvPattern = "[0-9]{2}/[0-9]{2}";
//
//            Pattern numberRegex = Pattern.compile(cardNumberPattern);
//            Pattern expirationRegex = Pattern.compile(expirationDatePattern);
//            Pattern cvvRegex = Pattern.compile(cvvPattern);
//
//            //Strip all hyphens
//            String cardNumberStrip = cardNumber.replaceAll("-", "");
//
//            //Match the card
//            Matcher matcherNumber = numberRegex.matcher(cardNumberStrip);
//            Matcher matcherExpired = expirationRegex.matcher(expirationDate);
//            Matcher matcherCVV = cvvRegex.matcher(cvv);
//
//            if (matcherExpired.matches()) {
//                this.setExpirationDate(expirationDate);
//                if (matcherNumber.matches()) {
//                    this.setCardNumber(cardNumber);
//                    if (matcherCVV.matches()) {
//                        this.setCVV(cvv);
//                        isValid = true;
//                    }
//                }
//            }
//
//            return isValid;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(getCardUUID(), card.getCardUUID()) && Objects.equals(getCardName(), card.getCardName()) && Objects.equals(getCardNumber(), card.getCardNumber()) && Objects.equals(getExpirationDate(), card.getExpirationDate()) && Objects.equals(getCVV(), card.getCVV()) && Objects.equals(getCompany(), card.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardUUID(), getCardName(), getCardNumber(), getExpirationDate(), getCVV(), getCompany());
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardUUID=" + cardUUID +
                ", cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", CVV='" + CVV + '\'' +
                ", company='" + company + '\'' + '}';
    }
}
