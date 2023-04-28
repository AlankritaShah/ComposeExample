package com.alankrita.composeexample.affirmations.data

import com.alankrita.composeexample.R
import com.alankrita.composeexample.affirmations.model.Affirmation

/**
 * [Datasource] generates a list of [Affirmation]
 */
class Datasource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image1),
            Affirmation(R.string.affirmation3, R.drawable.image1),
            Affirmation(R.string.affirmation4, R.drawable.image1),
            Affirmation(R.string.affirmation5, R.drawable.image1),
            Affirmation(R.string.affirmation6, R.drawable.image1),
            Affirmation(R.string.affirmation7, R.drawable.image1),
            Affirmation(R.string.affirmation8, R.drawable.image1),
            Affirmation(R.string.affirmation9, R.drawable.image1),
            Affirmation(R.string.affirmation10, R.drawable.image1))
    }
}