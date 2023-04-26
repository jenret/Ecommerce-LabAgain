package jretana.usermicroservice.model;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class User {

        @Id
        private UUID userUUID;

        private String firstName;

        private String lastName;

        private String username;

        private String password;

        private String email;

        private Address userAddress;

        private List<Card> paymentCards = new ArrayList<>();

        public User() {
        }

        public User(UUID userUUID, String firstName, String lastName, String username, String password, String email, Address userAddress, List<Card> paymentCards) {
                this.userUUID = userUUID;
                this.firstName = firstName;
                this.lastName = lastName;
                this.username = username;
                this.password = password;
                this.email = email;
                this.userAddress = userAddress;
                this.paymentCards = paymentCards;
        }

        public UUID getUserUUID() {
                return userUUID;
        }

        public void setUserUUID(UUID userUUID) {
                this.userUUID = userUUID;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Address getUserAddress() {
                return userAddress;
        }

        public void setUserAddress(Address userAddress) {
                this.userAddress = userAddress;
        }

        public List<Card> getPaymentCards() {
                return paymentCards;
        }

        public void setPaymentCards(List<Card> paymentCards) {
                this.paymentCards = paymentCards;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return Objects.equals(getUserUUID(), user.getUserUUID()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getUserAddress(), user.getUserAddress()) && Objects.equals(getPaymentCards(), user.getPaymentCards());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getUserUUID(), getFirstName(), getLastName(), getUsername(), getPassword(), getEmail(), getUserAddress(), getPaymentCards());
        }

        @Override
        public String toString() {
                return "User{" +
                        "userUUID=" + userUUID +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", username='" + username + '\'' +
                        ", password='" + password + '\'' +
                        ", email='" + email + '\'' +
                        ", userAddress=" + userAddress +
                        ", paymentCards=" + paymentCards +
                        '}';
        }
}
