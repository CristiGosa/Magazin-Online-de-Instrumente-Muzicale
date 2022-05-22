package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.SellerNotExistsException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameNotExistsException;
import org.loose.fis.sre.model.Instrument;
import org.loose.fis.sre.model.Review;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class ReviewService {


    private static ObjectRepository<Review> ReviewRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("reviews.db").toFile())
                .openOrCreate("test", "test");

        ReviewRepository = database.getRepository(Review.class);
    }
    public static void checkSellerDoesNotExist(String seller) throws  SellerNotExistsException {
        int c = 0;
        for (Review rv : ReviewRepository.find()) {
            if (Objects.equals(seller, rv.getSeller())) c = 1;
        }
        if(c == 0) throw new SellerNotExistsException(seller);
    }

    public static void addReview(int index, String text, String buyer, String seller) throws SellerNotExistsException {
        checkSellerDoesNotExist(seller);
        ReviewRepository.insert(new Review(index, text, buyer, seller));
    }

    public static ObjectRepository<Review> GetRepository() {
        return ReviewRepository;
    }

}
