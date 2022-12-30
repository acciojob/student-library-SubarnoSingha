package com.example.library.studentlibrary.services;

import com.example.library.studentlibrary.models.Card;
import com.example.library.studentlibrary.models.CardStatus;
import com.example.library.studentlibrary.models.Student;
import com.example.library.studentlibrary.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {


    @Autowired
    CardRepository cardRepository3;

    public Card createAndReturn(Student student) {
        Card card = null;
        if (student != null) {
            // Create a new card and link it to the student
            card = new Card();
            card.setStudent(student);

            // Save the card to the database
            card = cardRepository3.save(card);
        }
        // Return the newly created card
        return card;

    }

    public void deactivateCard(int student_id){
        cardRepository3.deactivateCard(student_id, CardStatus.DEACTIVATED.toString());
    }
}