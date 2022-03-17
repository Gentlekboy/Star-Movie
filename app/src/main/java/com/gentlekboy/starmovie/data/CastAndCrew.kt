package com.gentlekboy.starmovie.data

import com.gentlekboy.starmovie.R

/**
 * Data class for Casts and crews shown on the Casts and crew Screen
 */
data class CastAndCrew(
    val id: Int,
    val realName: String,
    val movieName: String,
    val image: Int
)

val castAndCrewList = arrayListOf(
    CastAndCrew(
        1, "Keanu Reeves", "JOHN WICK", R.drawable.keanu_reeves
    ),
    CastAndCrew(
        1, "Halle Berry", "SOFIA", R.drawable.halle_berry
    ),
    CastAndCrew(
        1, "Laurence Fishburne", "BOWERY KING", R.drawable.laurence_lishburne
    ),
    CastAndCrew(
        1, "Mark Dacascos", "ZERO", R.drawable.mark_dacascos
    ),
    CastAndCrew(
        1, "Asia Kate Dillon", "ADJUDICATOR", R.drawable.asia_kate_dillon
    ),
    CastAndCrew(
        1, "Lance Reddick", "CHARON", R.drawable.lance_reddick
    ),
    CastAndCrew(
        1, "Anjelica Huston", "DIRECTOR", R.drawable.anjelica_huston
    ),
    CastAndCrew(
        1, "Margaret Daly", "Operator", R.drawable.margaret_daly
    ),
    CastAndCrew(
        1, "Jerome Flynn", "Berrada", R.drawable.jerome_flynn
    )
)