package com.epam.msfrolov.musicstore.util;

import com.epam.msfrolov.musicstore.model.*;
import org.joda.money.Money;

import javax.jws.soap.SOAPBinding;

public class StoreService {
    public static boolean buyTrack(Track track, User user) {
        if (!user.getAccount().canSpend(track.getPrice())) {
            return false;
        }
        Payment payment = Payment.conduct(User.ADMIN, user, track.getPrice(), DetailsOfPayment.PAY_PER_TRACK);
        user.getBoughtTracks().add(track);
        System.out.println(payment);
        return payment.isDone();
    }

    public static boolean buyAlbum(Album album, User user) {
        if (!user.getAccount().canSpend(album.getPrice())) {
            return false;
        }
        Payment payment = Payment.conduct(User.ADMIN, user, album.getPrice(), DetailsOfPayment.PAY_PER_TRACK);
        user.getBoughtTracks().addAll(album.getList());
        System.out.println(payment);
        return payment.isDone();
    }

    public static boolean accrualMoneyInAccount(User user, Money value) {
        Payment payment = Payment.conduct(user, User.ADMIN, value, DetailsOfPayment.ADD_BALANCE);
        return payment.isDone();
    }

    public static boolean takeOffMoneyInAccount(User user, Money value) {
        if (!user.getAccount().canSpend(value)) return false;
        Payment payment = Payment.conduct(User.ADMIN, user, value, DetailsOfPayment.LIFTING_OF_BALANCE);
        return payment.isDone();
    }
}